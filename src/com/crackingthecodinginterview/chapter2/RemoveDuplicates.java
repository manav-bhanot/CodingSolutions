package com.crackingthecodinginterview.chapter2;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

    // Reference to the header node of the linked list
    private Node head;

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        removeDuplicates.createLinkedList();
        removeDuplicates.head.printLinkedList();

        // Remove duplicates from the Linked List
        removeDuplicates.removeDuplicateNodes(removeDuplicates.head);

        System.out.println();

        // Print the linked list
        removeDuplicates.head.printLinkedList();
    }

    public void createLinkedList() {

        for (int i = 0; i < 12; i++) {

            if (this.head == null) {
                Node newNode = new Node(i % 10);
                this.head = newNode;
            } else {
                this.head.appendToTail(i % 10);
            }
        }

		/*Node n=new Node(5);
        n.appendToTail(10);
        n.appendToTail(2);
        n.appendToTail(3);
        n.appendToTail(5);
        //Node  head;
        this.head=n;*/
    }

    public void removeDuplicateNodes(Node n) {

        Set<Integer> values = new HashSet<>();
        Node previous = null;

        //if (n != null) {

        //values.add(n.data);

        while (n != null) {

            if (values.contains(n.data)) {
                previous.next = n.next;
            } else {
                values.add(n.data);
                previous = n;
            }

            n = n.next;
        }
        //}
    }
}
