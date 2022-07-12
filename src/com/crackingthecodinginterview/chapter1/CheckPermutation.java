package com.crackingthecodinginterview.chapter1;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings, write a method to decide if one is a permutation of the
 * other.
 */
public class CheckPermutation {

    public static void main(String[] args) {

        for (String[] strArray : testStrings()) {
            boolean result = checkPermutation(strArray[0], strArray[1]);
            System.out.println(strArray[0] + " is permutation of " + strArray[1] + " :: " + result);
        }
    }


    private static boolean checkPermutation(String firstString, String secondString) {

        if (firstString.length() != secondString.length()) {
            return false;
        }

        Map<Character, Integer> charCount = new HashMap<>();

        for (Character c : firstString.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for (Character c : secondString.toCharArray()) {
            if (charCount.getOrDefault(c, 0) - 1 < 0) {
                return false;
            }
            charCount.put(c, charCount.get(c) - 1);
        }
        return true;
    }

    private static String[][] testStrings() {
        return new String[][]{
                {"manav", "aamnv"},
                {"aastha", "sthaaa"},
                {"jain", "niaj"},
                {"ying", "ting"}
        };
    }
}
