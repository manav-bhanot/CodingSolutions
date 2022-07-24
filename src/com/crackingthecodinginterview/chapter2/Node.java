/**
 * 
 */
package com.crackingthecodinginterview.chapter2;

import java.util.Random;

/**
 * @author Manav
 *
 */
class Node {
	public Node next;
	public int data;
	public Node(int data) {
		this.data = data;
	}

	public void printLinkedList() {

		StringBuilder sb = new StringBuilder();
		sb.append("[");

		Node n = this;
		while (n != null) {
			sb.append(n.data).append(",");
			n = n.next;
		}
		sb.deleteCharAt(sb.lastIndexOf(","));

		sb.append("]");
		System.out.println(sb);
	}

	public Node appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
		return end;
	}

	public Node deleteNodeByValue(Node head, int d) {
		Node n = new Node(this.data);
		n.next = head.next;

		while (n != null) {
			if (n.data == d) {
				n.data = n.next.data;
				n.next = n.next.next;
				break;
			}
			n = n.next;
		}
		return head;
	}

	public Node getNodeAtIndex(int index) {
		Node nodeAtIndex = this;
		int idx = 0;
		while (idx < index) {
			nodeAtIndex = nodeAtIndex.next;
			idx++;
		}

		return nodeAtIndex;
	}

	public void deleteNodeByReference(Node nodeToBeDeleted) {
		nodeToBeDeleted.data = nodeToBeDeleted.next.data;
		nodeToBeDeleted.next = nodeToBeDeleted.next.next;
	}

	public static Node createLinkedListWithRandomIntegers(int size) {

		Random random = new Random();
		int bound = 10000;

		Node head = new Node(random.nextInt(bound));

		for (int idx = 1; idx < size; idx++) {

			int data = random.nextInt(bound);
			head.appendToTail(data);
		}

		return head;
	}
}
