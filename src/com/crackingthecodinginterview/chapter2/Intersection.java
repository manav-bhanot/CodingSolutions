package com.crackingthecodinginterview.chapter2;

import java.util.HashSet;
import java.util.Set;

/**
 * Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting
 * node. Note that the intersection is defined based on reference, not value. That is, if the kth
 * node of the first linked list is the exact same node (by reference) as the jth node of the second
 * linked list, then they are intersecting.
 */
public class Intersection {

    static Node findIntersectingNode(Node listOne, Node listTwo) {
        Set<Node> nodeSet = new HashSet<>();

        while (listOne != null || listTwo != null) {

            if (listOne != null) {
                if (nodeSet.contains(listOne)) {
                    return listOne;
                }
                nodeSet.add(listOne);
                listOne = listOne.next;
            }
            if (listTwo != null) {
                if (nodeSet.contains(listTwo)) {
                    return listTwo;
                }
                nodeSet.add(listTwo);
                listTwo = listTwo.next;
            }
        }

        return null;
    }


    public static void main(String[] args) {
        Node listTwo = new Node(0);
        listTwo.appendToTail(1);
        listTwo.appendToTail(2);
        listTwo.appendToTail(3);
        listTwo.appendToTail(4);
        Node intersectionPoint = listTwo.appendToTail(5);
        listTwo.appendToTail(6);
        listTwo.appendToTail(7);
        listTwo.appendToTail(8);
        listTwo.appendToTail(9);

        System.out.println("List One: " + listTwo.printLinkedList());

        Node listOne = new Node(9);
        listOne.appendToTail(8);
        listOne.appendToTail(7);
        listOne.appendToTail(6);
        listOne.appendToTail(5);
        listOne.appendToTail(4);
        listOne.appendToTail(3);

        // Intersection created
        listOne.appendToTail(intersectionPoint);
//        listOne.appendToTail(2);
//        listOne.appendToTail(1);
//        listOne.appendToTail(0);

        System.out.println("List Two: " + listOne.printLinkedList());

        Node iNode = findIntersectingNode(listOne, listOne);

        System.out.println("Intersecting node is : " + iNode.data);

    }
}
