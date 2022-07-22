package com.crackingthecodinginterview.chapter2;

/**
 * Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but
 * the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
 * that node.
 * EXAMPLE
 * Input: the node c from the linked list a - >b- >c - >d - >e- >f
 * Result: nothing is returned, but the new linked list looks like a - >b- >d - >e- >f
 * Hints: #72
 */
public class DeleteMiddleNode {

    public void deleteNode(Node n) {
        n.data = n.next.data;
        n.next = n.next.next;
    }

    public static void main(String[] args) {
        DeleteMiddleNode deleteMiddleNode = new DeleteMiddleNode();

        Node head = Node.createLinkedListWithRandomIntegers(10);

        System.out.println("\nLinkedList before deletion");
        head.printLinkedList();

        int nodeIndexToBeDeleted = 7;

        Node nodeToBeDeleted = head;
        int idx = 0;
        while (idx < nodeIndexToBeDeleted) {
            nodeToBeDeleted = nodeToBeDeleted.next;
            idx++;
        }
        System.out.println("\nNode to be deleted : " + nodeToBeDeleted.data);

        deleteMiddleNode.deleteNode(nodeToBeDeleted);

        System.out.println("\nLinkedList after deletion");
        head.printLinkedList();

    }
}
