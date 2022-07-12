package com.crackingthecodinginterview.chapter1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Implement an algorithm to determine if a string has all unique characters. What if you
 * cannot use additional data structures?
 */
public class IsUnique {

    public static void main(String[] args) {

        for (String s : testStrings()) {
            boolean result = isUnique(s);
            System.out.println(s + ".isUnique : " + result);
        }

        for (String s : testStrings()) {
            boolean result = isUnique_withoutAdditionalDataStructure(s);
            System.out.println(s + ".isUnique : " + result);
        }

    }

    private static boolean isUnique(String str) {

        Set<Character> uniqueChars = new HashSet<>();

        for (char c: str.toCharArray()) {
            if (!uniqueChars.add(c)) {
                return false;
            }
        }
        return true;
    }


    private static boolean isUnique_withoutAdditionalDataStructure(String str) {
        char[] strCharArray = str.toCharArray();

        // TODO:: Replace with merge sort.
        Arrays.sort(strCharArray);

        for (int idx = 1; idx < strCharArray.length; idx++) {

            if (strCharArray[idx - 1] == strCharArray[idx]) {
                return false;
            }
        }

        return true;
    }

    private static List<String> testStrings() {
        return List.of(
                "Manav",
                "Aastha",
                "Gaurav",
                "Ying"
        );
    }

}
