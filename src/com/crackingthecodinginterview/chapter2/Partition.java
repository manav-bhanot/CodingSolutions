package com.crackingthecodinginterview.chapter2;

/**
 * Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
 * before all nodes greater than or equal to x. lf x is contained within the list, the values of x only need
 * to be after the elements less than x (see below). The partition element x can appear anywhere in the
 * "right partition"; it does not need to appear between the left and right partitions.
 * EXAMPLE
 * Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition = 5)
 * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8  (There could be other right solutions as well because order does not matter here)
 * Hints: #3, #24
 */
public class Partition {
    static Node partitionLinkedList(Node head, int p) {

        Node curr = head;
        Node end = head;

        int size = 1;

        /**
         * Move towards the end of the list first thereby noting the size.
         */
        while (end.next != null) {
            end = end.next;
            size++;
        }

        /**
         * Keep appending nodes with value > partition value at the end.
         *
         */
        for (int i = 0; i < size; i++) {
            if (curr.data >= p) {
                Node newNode = new Node(curr.data);
                end.next = newNode;
                end = newNode;

                curr.data = curr.next.data;
                curr.next = curr.next.next;

            } else {
                curr = curr.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {

        Node linkedList = new Node(3) ;
        linkedList.appendToTail(5);
        linkedList.appendToTail(8);
        linkedList.appendToTail(5);
        linkedList.appendToTail(10);
        linkedList.appendToTail(2);
        linkedList.appendToTail(1);

        linkedList.printLinkedList();

        Node partitionedList = partitionLinkedList(linkedList, 5);

        partitionedList.printLinkedList();
    }
}
