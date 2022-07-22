package com.leetcode.problems.p125;

/**
 * 125. Valid Palindrome
 * https://leetcode.com/problems/valid-palindrome/
 *
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 *
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * Example 3:
 *
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 2 * 105
 * s consists only of printable ASCII characters.
 *
 */
public class Solution {
    public boolean isPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return false;
        }

        String refinedString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int leftIdx = 0;
        int rightIdx = refinedString.length() - 1;

//         while (leftIdx < rightIdx) {
//             if (refinedString.charAt(leftIdx) != refinedString.charAt(rightIdx)) {
//                 if (leftIdx == rightIdx) {
//                     return true;
//                 }
//                 return false;
//             }
//             leftIdx++;
//             rightIdx--;
//         }

//         return true;

        return isValidPalindromeUsingRecursion(refinedString, leftIdx, rightIdx);
    }

    private boolean isValidPalindromeUsingRecursion(String s, int leftIdx, int rightIdx) {
        if (leftIdx >= rightIdx) {
            return true;
        }
        if (s.charAt(leftIdx) != s.charAt(rightIdx)) {
            return false;
        }

        return isValidPalindromeUsingRecursion(s, leftIdx + 1, rightIdx - 1);
    }
}
