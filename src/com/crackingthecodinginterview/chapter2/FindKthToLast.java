package com.crackingthecodinginterview.chapter2;

/**
 * Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
 *
 * Eg: for a list with 10 elements, the element which is 4th from last is the 7th element.
 */
public class FindKthToLast {
	public Node findKthToLast(Node head, int k) {
		Node runnerOne = head;
		Node runnerTwo = head;

		// Move runnerTwo to kth position from beginning.
		int pos = 0;
		while (pos < k) {
			if (runnerTwo == null) {
				return null;
			}
			runnerTwo = runnerTwo.next;
			pos++;
		}

		while (runnerTwo != null) {
			runnerOne = runnerOne.next;
			runnerTwo = runnerTwo.next;
		}

		return runnerOne;
	}
	
	public static void main(String[] args) {
		
		FindKthToLast findKthToLastElement = new FindKthToLast();

		Node head = Node.createLinkedListWithRandomIntegers(10);
		int k = 6;

		head.printLinkedList();
		System.out.println(" k = " + k);

		// Print the linked list
		Node kthToLast = findKthToLastElement.findKthToLast(head, k);
		System.out.println(kthToLast == null ? null : kthToLast.data);
	}
}
