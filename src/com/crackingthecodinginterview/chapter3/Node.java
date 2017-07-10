/**
 * 
 */
package com.crackingthecodinginterview.chapter3;

/**
 * @author Manav
 *
 */
public class Node {
	public Node next = null;
	public Object data;

	public Node(Object data) {
		super();
		this.data = data;
	}
	
	// These methods are not required for the Stack class.

	/*public void printLinkedList() {
		System.out.println("\n");
		Node n = this;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println("\n");
	}

	public void appendToTail(Object d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	public Node deleteNode(Node head, int d) {

		return null;
	}*/
	
}
