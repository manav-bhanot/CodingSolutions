package com.crackingthecodinginterview.chapter3;

import java.util.Arrays;

/**
 * 3.1 Three in One: Describe how you could use a single array to implement three stacks.
 * Hints: #2, #72, #38, #58
 */
public class ArrayBackedStack {

    static int counter = 0;
    static int[] array = new int[1000];

    int id;
    int size;

    public ArrayBackedStack() {
        this.id = counter++;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        size--;
        int top = findTopIndex(size);

        return array[top];
    }

    public void push(int element) {
        int top = findTopIndex(size);

        if (top > array.length / 2) {
            System.out.println("Current size : " + array.length);
            copyArray();
            System.out.println("New size : " + array.length);
        }

        array[top] = element;
        size++;
    }

    private void copyArray() {
        array = Arrays.copyOf(array, array.length * 2);
    }

    public int peek() {
        // if size is zero then return -1
        if (size == 0) {
            return -1;
        }
        int top = findTopIndex(size-1);
        return array[top];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int findTopIndex(int size) {
        int top = (counter * size) + id ;
        return top;
    }
}

class Main {

    public static void main(String[] args) {

        ArrayBackedStack stackOne = new ArrayBackedStack();
        ArrayBackedStack stackTwo = new ArrayBackedStack();
        ArrayBackedStack stackThree = new ArrayBackedStack();

        for (int i = 1; i <= 5; i++) {
            stackOne.push(i);
        }

        for (int i = 10; i <= 20; i++) {
            stackTwo.push(i);
        }

        for (int i = 40; i <= 60; i++) {
            stackThree.push(i);
        }
    }

}
