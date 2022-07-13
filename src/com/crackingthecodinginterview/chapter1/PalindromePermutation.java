package com.crackingthecodinginterview.chapter1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwards and backwards. A permutation
 * is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
 * EXAMPLE
 * Input: Tact Coa
 * Output: True (permutations: "taco cat". "atco cta". etc.)
 */
public class PalindromePermutation {

    public static void main(String[] args) {
        for (String s : testStrings()) {
            boolean result = isPalindromePermutation(s);
            System.out.println(s + ".isPalindromePermutation : " + result);
        }
    }

    private static boolean isPalindromePermutation(String inputString) {
        Map<Character, Integer> charCount = new HashMap<>();

        for (Character c: inputString.toLowerCase().toCharArray()) {
            if (c != ' ') {
                charCount.put(c, charCount.getOrDefault(c,0) + 1);
            }
        }

        boolean foundOneOddOccurrence = false;

        for (int occurrences : charCount.values()) {
            if (occurrences % 2 != 0) {
                if (!foundOneOddOccurrence) {
                    foundOneOddOccurrence = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private static List<String> testStrings() {
        return List.of(
                "Taco Cat",
                "Miss i ssim",
                "atco cta",
                "caat tac",
                "daot tad"
        );
    }
}
