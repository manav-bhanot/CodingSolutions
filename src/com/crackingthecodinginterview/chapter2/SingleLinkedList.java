package com.crackingthecodinginterview.chapter2;

import java.util.Random;

public class SingleLinkedList extends Node {

    Node head;

    public SingleLinkedList(int t) {
        super(t);
    }

    public String printLinkedList() {

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Node n = this;
        while (n != null) {
            sb.append(n.data).append(",");
            n = n.next;
        }
        sb.deleteCharAt(sb.lastIndexOf(","));

        sb.append("]");
//        System.out.println(sb);
        return sb.toString();
    }


    public Node getNodeAt(int index) {
        Node nodeAtIndex = head;
        int idx = 0;
        while (idx < index) {
            nodeAtIndex = nodeAtIndex.next;
            idx++;
        }

        return nodeAtIndex;
    }
}
