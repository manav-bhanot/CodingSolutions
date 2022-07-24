package com.crackingthecodinginterview.chapter2;

/**
 * 2.6 Palindrome: Implement a function to check if a linked list is a palindrome.
 */
public class Palindrome {

    boolean isPalindrome = true;
    Node start = null;

    private boolean isPanlindrome(Node head) {
        start = head;
        isPalindromeRecursively(head);

        return isPalindrome;
    }

    private void isPalindromeRecursively(Node tail) {

        // Base case: When we traversed the whole linked list. Recursion backtracks then
        if (tail == null) {
            return;
        }

        isPalindromeRecursively(tail.next);
//        System.out.println("Comparing start.data = " + start.data + " with tail.data = " + tail.data);
        if (start.data != tail.data) {
            isPalindrome = false;
        }

        start = start.next;
//        System.out.println("isPalindrome is : " + isPalindrome);
    }

    public static void main(String[] args) {

        Palindrome palindrome = new Palindrome();

        Node linkedList = new Node(0);
        linkedList.appendToTail(2);
        linkedList.appendToTail(2);
        linkedList.appendToTail(3);
        linkedList.appendToTail(3);
        linkedList.appendToTail(2);
        linkedList.appendToTail(1);
        linkedList.appendToTail(0);

        System.out.println("Is the list " + linkedList.printLinkedList() + " palindrome ? \n" + palindrome.isPanlindrome(linkedList));
    }

}
