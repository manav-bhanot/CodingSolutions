package com.crackingthecodinginterview.chapter1;

/**
 * Write a method to replace all spaces in a string with '%20: You may assume that the string
 * has sufficient space at the end to hold the additional characters, and that you are given the "true"
 * length of the string. (Note: If implementing in Java, please use a character array so that you can
 * perform this operation in place.)
 * EXAMPLE
 * Input:  "Mr John Smith    "  13
 * Output: "Mr%20John%20Smith"
 */
public class Urlify {

    public static void main(String[] args) {
        System.out.println(urlify("Mr John Smith    ", 13));
    }

    private static char[] urlify(String inputString, int trueLength) {

        int inputStringLength = inputString.length();

        char[] outputCharArray = inputString.toCharArray();

        int pointerOne = inputStringLength - 1; // tracks the array
        int pointerTwo = trueLength - 1;  // tracks the string

        while (pointerOne >= 0 && pointerTwo >= 0) {
            if (inputString.charAt(pointerTwo) != ' ') {
                outputCharArray[pointerOne] = inputString.charAt(pointerTwo);
                pointerOne--;
                pointerTwo--;
            } else {
                outputCharArray[pointerOne] = '0';
                outputCharArray[--pointerOne] = '2';
                outputCharArray[--pointerOne] = '%';

                pointerOne--;
                pointerTwo--;
            }
        }
        return outputCharArray;
    }
}
