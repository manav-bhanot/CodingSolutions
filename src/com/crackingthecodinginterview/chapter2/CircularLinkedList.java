package com.crackingthecodinginterview.chapter2;

import java.util.HashSet;
import java.util.Set;

public class CircularLinkedList {

	private Node head;
	
	Set<Node> setOfNodes;

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
	
	public void createCircularLinkedList() {
		
		Node a = new Node('a');
		Node b = new Node('b');
		Node c = new Node('c');
		Node d = new Node('d');
		Node e = new Node('e');
		
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = b;	
		
		this.head = a;
	}
	
	public Node getStartOfLoopNode(Node head) {
		
		Node n = head;
		
		setOfNodes = new HashSet<Node>();
		
		while (!setOfNodes.contains(n)) {
			setOfNodes.add(n);
			n = n.next;
			if (n == null) {
				return n;
			}
		}
		
		return n;
	}

	public static void main(String[] args) {
		
		CircularLinkedList cll = new CircularLinkedList();
		cll.createCircularLinkedList();
		
		Node startingNodeOfLoop = cll.getStartOfLoopNode(cll.head);
		if (startingNodeOfLoop == null) {
			System.out.println("Sorry this linked list has no loop");
		} else {
			System.out.println("The circular linked list loop begins at : "+(char)startingNodeOfLoop.data);
		}
	}

}
