package com.crackingthecodinginterview.chapter2;

public class FindNthToLastElement {
	
	private Node head;
	
	public void createLinkedList() {

		for (int i = 0; i < 12; i++) {

			if (this.head == null) {
				Node newNode = new Node(i);
				this.head = newNode;
				continue;
			} else {
				this.head.appendToTail(i);
			}
		}
	}
	
	public int findSizeOfLinkedList(Node head) {
		
		Node n = head;
		int size = 0;
		while (n != null) {
			size++;
			n = n.next;
		}
		return size;
	}
	
	public void getNthToLastElement(Node head, int size, int k) {
		
		Node n = head;		
		int pos = size - k + 1;
		
		for (int i=1; i<pos ; i++) {
			n = n.next;
		}		
		System.out.println("\n\nElement is : "+n.data);
	}
	
	public static void main(String[] args) {
		
		FindNthToLastElement findNthToLastElement = new FindNthToLastElement();
		
		findNthToLastElement.createLinkedList();
		
		int size = findNthToLastElement.findSizeOfLinkedList(findNthToLastElement.head);
		
		System.out.println("Size of Linked List is : "+size);
		
		// Print the linked list
		if (findNthToLastElement.head != null) {
			findNthToLastElement.head.printLinkedList();
		}
		
		findNthToLastElement.getNthToLastElement(findNthToLastElement.head, size, 7);
	}
}
