/**
 * 
 */
package com.crackingthecodinginterview.chapter2;

/**
 * @author Manav
 *
 */
class Node {
	public Node next = null;
	public int data;

	public Node(int data) {
		super();
		this.data = data;
	}

	public void printLinkedList() {
		System.out.println("\n");
		Node n = this;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println("\n");
	}

	public void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	public Node deleteNode(Node head, int d) {

		return null;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
}
