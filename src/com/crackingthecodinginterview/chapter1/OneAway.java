package com.crackingthecodinginterview.chapter1;

/**
 * There are three types of edits that can be performed on strings: insert a character,
 * remove a character, or replace a character. Given two strings, write a function to check if they are
 * one edit (or zero edits) away.
 * EXAMPLE
 * pale, pIe -> true
 * pales. pale -> true
 * pale. bale -> true
 * pale. bake -> false
 */
public class OneAway {

    public static void main(String[] args) {
        for (String[] strArray : testStrings()) {
            boolean result = isOneAway(strArray[0], strArray[1]);
            System.out.println("Is " + strArray[0] + " one-away from " + strArray[1] + " :: " + result);
        }
    }

    private static boolean isOneAway(String firstString, String secondString) {

        if (null == firstString || null == secondString) {
            return false;
        }

        if (firstString.length() == secondString.length()) {
            return isOneEditAway(firstString, secondString);
        } else if (Math.abs(firstString.length() - secondString.length()) == 1) {
            if (firstString.length() < secondString.length()) {
                return isOneInsertOrDeleteAway(firstString, secondString);
            } else {
                return isOneInsertOrDeleteAway(secondString, firstString);
            }

        }
        return false;
    }

    private static boolean isOneInsertOrDeleteAway(String smallString, String largeString) {
        boolean foundOneExtraChar = false;

        int smallStringPointer = 0;
        int largeStringPointer = 0;

        do {
            if (smallString.charAt(smallStringPointer) != largeString.charAt(largeStringPointer)) {
                if (foundOneExtraChar) {
                    return false;
                }
                foundOneExtraChar = true;
                largeStringPointer++;
            }
            smallStringPointer++;
            largeStringPointer++;
        } while(smallStringPointer < smallString.length() && largeStringPointer < largeString.length());

        return true;
    }

    private static boolean isOneEditAway(String firstString, String secondString) {
        boolean oneEditFound = false;

        int charIndex = 0;

        do {
            if (firstString.charAt(charIndex) != secondString.charAt(charIndex)) {
                if (oneEditFound) {
                    return false;
                }
                oneEditFound = true;
            }
            charIndex++;
        } while(charIndex < firstString.length());
        return true;
    }

    private static String[][] testStrings() {
        return new String[][]{
                {"pale", "ple"},
                {"pales", "pale"},
                {"pale", "bale"},
                {"pale", "bake"}
        };
    }

}
