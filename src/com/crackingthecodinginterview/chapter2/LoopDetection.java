package com.crackingthecodinginterview.chapter2;

public class LoopDetection {

    static Node detectLoop(Node head) {
        Node slow = head;
        Node fast = head;

        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                System.out.println("\nLoop detected at : " + slow.data);

                fast = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        System.out.println("\nNo loop detected");
        return null;
    }

    public static void main(String[] args) {

        Node linkedList = new Node(0);
        linkedList.appendToTail(1);
        linkedList.appendToTail(2);
        linkedList.appendToTail(3);
        linkedList.appendToTail(4);
        linkedList.appendToTail(5);
        linkedList.appendToTail(6);
        linkedList.appendToTail(7);
        linkedList.appendToTail(8);

        Node tail = linkedList.appendToTail(9);

        linkedList.printLinkedList();

        Node n = linkedList.getNodeAtIndex(6);
        System.out.println("\nAppending the node with value " + n.data + " to tail");
        tail.next = n;

        System.out.println("\nPrinting linked list to see that the loop has been established");
        int i = 0;

        Node head = linkedList;
        while (i < 30) {
            System.out.print(head.data + " -> ");
            head = head.next;
            i++;
        }

        Node nodeAtBeginningOfLoop = detectLoop(linkedList);
        System.out.println("\nNode at the beginnig of the loop : " + nodeAtBeginningOfLoop.data);
    }
}
