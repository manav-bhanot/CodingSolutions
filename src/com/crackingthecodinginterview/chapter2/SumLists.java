package com.crackingthecodinginterview.chapter2;

public class SumLists {

    static Node sumListsIteratively(Node firstNumber, Node secondNumber) {

        int carry = 0;

        Node headOne = firstNumber;
        Node headTwo = secondNumber;

        Node resultHead = null;
        Node n = null;

        int result = 0;

        while (headOne != null || headTwo != null) {
            if (headOne != null && headTwo != null) {
                result = headOne.data + headTwo.data + carry;

                headOne = headOne.next;
                headTwo = headTwo.next;

            } else if (headTwo != null) {
                result = headTwo.data + carry;
                headTwo = headTwo.next;
            } else {
                result = headOne.data + carry;
                headOne = headOne.next;
            }

            carry = result > 9 ? 1 : 0;
            result = result > 9 ? result % 10 : result;

            if (resultHead == null) {
                resultHead = new Node(result);
                n = resultHead;
            } else {
                n.next = new Node(result);
                n = n.next;
            }
        }

        if (carry == 0) {
            n = null;
        } else {
            n.next = new Node(carry);
        }
        return resultHead;
    }

    static Node sumListsRecursively(Node firstNumber, Node secondNumber, int sum, int carry) {

        if (firstNumber == null && secondNumber == null) {
            if (carry == 0) {
                return null;
            } else {
                return new Node(carry);
            }
        }

        Node n = new Node(0);

        if (firstNumber != null && secondNumber != null) {
            sum = (firstNumber.data + secondNumber.data + carry) % 10;
            carry = (firstNumber.data + secondNumber.data + carry) / 10;
            n.next = sumListsRecursively(firstNumber.next, secondNumber.next, sum, carry);
        } else if (firstNumber != null) {
            sum = (firstNumber.data + carry) % 10;
            carry = (firstNumber.data + carry) / 10;
            n.next = sumListsRecursively(firstNumber.next, null, sum, carry);
        } else {
            sum = (secondNumber.data + carry) % 10;
            carry = (secondNumber.data + carry) / 10;
            n.next = sumListsRecursively(null, secondNumber.next, sum, carry);
        }
        n.data = sum;
        return n;
    }

    public static void main(String[] args) {

        Node firstNumber = new Node(9);
        firstNumber.appendToTail(9);
        firstNumber.appendToTail(9);
        firstNumber.appendToTail(9);
        firstNumber.appendToTail(9);
        firstNumber.appendToTail(9);
        firstNumber.appendToTail(9);
        firstNumber.appendToTail(9);


        firstNumber.printLinkedList();

        Node secondNumber = new Node(1);

        secondNumber.printLinkedList();

//        Node iterativeSumResult = sumListsIteratively(firstNumber, secondNumber);
//        iterativeSumResult.printLinkedList();

        Node recursiveSumResult = sumListsRecursively(firstNumber, secondNumber, 0, 0);
        recursiveSumResult.printLinkedList();
    }
}
