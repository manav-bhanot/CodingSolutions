/**
 * 
 */
package com.leetcode.string;

/**
 * @author Manav
 * 
 * Given a string s, find the longest palindromic substring in s.
 * 
 * Example:
 * 	Input : abbacdedca
 * 	Output : acdedca
 *
 */
public class LongestPalindromicSubstring {

	public static void main(String[] args) {

		String s = "abbacdedca";
		
		System.out.println(findLongestPalindromicSubstring(s));

	}

	public static String findLongestPalindromicSubstring(String s) {
		int maxLenStartIdx = 0, maxLen = 0;
		int strLen = s.length();
		char[] s_char = s.toCharArray();
		boolean dp[][] = new boolean[strLen][strLen];

		// set the diagonal element to TRUE
		for (int i = 0; i < strLen; i++) {
			dp[i][i] = true;
			maxLen = 1;
		}

		int i = 0, j = 1;
		while (j < strLen) {
			if (s_char[i] == s_char[j]) {
				dp[i][j] = true;
				maxLen = 2;
				maxLenStartIdx = i;
			}
			i++;
			j++;
		}

		// Starting to deal with substrings of length=3
		// index starts at 2

		for (int currLen = 2; currLen < strLen; currLen++) {

			for (int rIdx = 0; rIdx < strLen - currLen; rIdx++) {

				int cIdx = rIdx + currLen;

				if (s_char[rIdx] == s_char[cIdx] && dp[rIdx + 1][cIdx - 1]) {

					dp[rIdx][cIdx] = true;

					// System.out.println(maxLenStartIdx + ":" + maxLen);

					if (cIdx - rIdx + 1 > maxLen) {
						maxLen = cIdx - rIdx + 1;
						maxLenStartIdx = rIdx;
					}

					// System.out.println(maxLenStartIdx + ":" + maxLen);
				}

			}
		}

		return s.substring(maxLenStartIdx, maxLenStartIdx + maxLen);
	}

}
