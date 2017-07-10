package com.crackingthecodinginterview.chapter2;

public class DeleteANode {

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
	
	public boolean deleteNode(Node n) {
		
		
		// Check if this is the last node
		if (n == null || n.next == null) {
			System.out.println("Cannot delete the last node");
			return false;
		}
		
		Node nextNode = n.next;
		n.data = nextNode.data;
		n.next = nextNode.next;
		return true;
	}

	public static void main(String[] args) {
		DeleteANode deleteANode = new DeleteANode();

		deleteANode.createLinkedList();

		int size = deleteANode.findSizeOfLinkedList(deleteANode.head);

		System.out.println("Size of Linked List is : " + size);

		// Print the linked list
		if (deleteANode.head != null) {
			deleteANode.head.printLinkedList();
		}
		
		//Get the node from the linkedlist to be deleted
		int nodeToBeDeleted = 11;
		Node nodeObjToBeDeleted = deleteANode.head;
		
		for (int i=0; i<nodeToBeDeleted; i++) {
			if (nodeObjToBeDeleted.next != null) {
				nodeObjToBeDeleted = nodeObjToBeDeleted.next;
			} else {
				System.out.println("\nNo such node exists in the linked list");
				break;
			}
		}		
		deleteANode.deleteNode(nodeObjToBeDeleted);
		
		deleteANode.head.printLinkedList();
	}
}
