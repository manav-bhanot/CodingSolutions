package com.crackingthecodinginterview.chapter2;

public class ReverseLinkedList {
    private static Node recursiveReverseLinkedList(Node curr) {

        if (curr.next == null) { //=> curr the last node. This is going to be the new head.
            return curr;
        }

        // When curr.next is null => we are at the last node of the linked list
        // So the last node needs to be set as the new head which we are doing here.
        Node head = recursiveReverseLinkedList(curr.next);

        // The below 2 lines actually reverse the pointers.
        curr.next.next = curr;
        curr.next = null;

        // Keep returning the head since we want the head to be the same after every recursive call ends.
        return head;
    }

    public static void main(String[] args) {
        int size = 15;

        Node head = Node.createLinkedListWithRandomIntegers(size);

        head.printLinkedList();

        recursiveReverseLinkedList(head).printLinkedList();
    }
}
