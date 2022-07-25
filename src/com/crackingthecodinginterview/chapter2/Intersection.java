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

        // Traverse listOne and add node to the set
        while (listOne != null) {
            nodeSet.add(listOne);
            listOne = listOne.next;
        }

        // Traverse listTwo and see if you are able to find the node from listOne in the set.
        // That would be the intersection point.

        while (listTwo != null) {
            if (nodeSet.contains(listTwo)) {
                return listTwo;
            }
            listTwo = listTwo.next;
        }

        return null;
    }


    public static void main(String[] args) {

        Intersection intersection = new Intersection();

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

        System.out.println("List One: " + listOne.printLinkedList());
        System.out.println("List Two: " + listTwo.printLinkedList());

        Node iNode = findIntersectingNode(listOne, listTwo);

        if (iNode != null) {
            System.out.println("Intersecting node is : " + iNode.data);
        } else {
            System.out.println("No intersecting node found : " + iNode.data);
        }
    }
}
