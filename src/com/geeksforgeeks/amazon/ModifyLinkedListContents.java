/**
 * 
 */
package com.geeksforgeeks.amazon;

/**
 * @author Manav
 * 
 *         Given a singly linkedlist containing n nodes Modify the textValue of 1st
 *         half nodes such that 1st node's new textValue = 1st node's curr textValue -
 *         last node's textValue; 2nd node's new textValue = 2nd's node current textValue -
 *         secondlast node's textValue
 * 
 *         If n is odd, then the textValue in the middle remains unchanged
 *
 */
public class ModifyLinkedListContents {

	Node headerNode;

	public static void main(String[] args) {

		ModifyLinkedListContents obj = new ModifyLinkedListContents();

		int[] arr = new int[] { 10, 4, 5, 3, 6, 9 };

		Node head = obj.createLinkedList(arr);
		head = obj.modifyLinkedList(head);
		obj.printLinkedList(head);
	}

	private Node createLinkedList(int[] arr) {
		Node head = new Node(arr[0]);
		Node node = head;

		for (int i = 1; i < arr.length; i++) {
			node.next = new Node(arr[i]);
			node = node.next;
		}
		return head;
	}

	private void printLinkedList(Node head) {

		if (head == null) {
			return;
		}
		System.out.print(head.val + " ");
		printLinkedList(head.next);
	}

	private Node modifyLinkedList(Node head) {
		
		// Reverse the second half of the linked list
		// Navigate the LinkedList using two pointers (fast and slow)
		// to find the mid point
		Node slow = head;
		Node fast = head.next;
		
		while (fast != null) {			
			fast = fast.next;
			if (fast != null) {
				slow = slow.next;
				fast = fast.next;
			}			
		}
		
		// Now the slow pointer is pointing before the midPoint in the list
		// So first separate the first half by breaking the Linked List in the middle
		Node firstHalfHead = head;
		Node secondHalfTail = slow.next;
		slow.next = null;
		
		// Now we have the tail of the secondHalf i.e. the tail once the second half will be reversed
		// Lets reverse the second half		
		Node secondHalfHead = reverseLinkedList(secondHalfTail);
		// System.out.println("Second Half Head = " + secondHalfHead.val);
		
		// Taking backup of the secondHalfHead which will be required later to reverse the linked list
		Node backup = secondHalfHead;
		
		// Now modify the list 
		while (secondHalfHead.next != null && firstHalfHead.next != null) {
			firstHalfHead.val -= secondHalfHead.val;
			firstHalfHead = firstHalfHead.next;
			secondHalfHead = secondHalfHead.next;
		}
		
		// Now again reverse the second half
		secondHalfHead = reverseLinkedList(backup);
		
		while (secondHalfHead != null) {
			firstHalfHead.next = secondHalfHead;
			secondHalfHead = secondHalfHead.next;
			firstHalfHead = firstHalfHead.next;
		}
		
		return head;
	}
	
	private Node reverseLinkedList(Node head) {
		Node curr = head;
		Node prev = null;
		Node next = null;		
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}		
		return prev;
	}

}

class Node {
	int val;
	Node next;

	public Node(int val) {
		super();
		this.val = val;
	}

	public Node(int val, Node next) {
		super();
		this.val = val;
		this.next = next;
	}
}
