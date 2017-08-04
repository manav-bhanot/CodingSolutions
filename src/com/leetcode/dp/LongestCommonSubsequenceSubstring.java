/**
 * 
 */
package com.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Manav
 * 
 * Given two strings s1 and s2.
 * Find the length of longest common subsequence in s1 which
 * is a substring in s2.
 * 
 * eg : s1 = Maninder
 * 		s2 = Manpinder
 * 
 * 	Ans : Inder
 *
 */
public class LongestCommonSubsequenceSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String s1 = "Maninder";
		String s2 = "Manpinder";
		
		findLongestCommonSubsequenceSubstring(s1, s2);
	}

	private static void findLongestCommonSubsequenceSubstring(String s1, String s2) {
		
		int n = s1.length();
		int m = s2.length();
		
		int[][] dp = new int[m + 1][n + 1];
		
		int len = Integer.MIN_VALUE;
		List<String> results = new ArrayList<String>();
		
		for (int i = 1; i <= m; i++) {
			
			for (int j = 1; j <= n; j++) {
				
				if (s1.charAt(j - 1) == s2.charAt(i - 1)) {
					
					dp[i][j] = 1 + dp[i - 1][j - 1];
					
					if (dp[i][j] > len) {
						len = dp[i][j];
						results.clear();
						results.add(s2.substring(i - len, i));
					}
				} else {
					dp[i][j] = dp[i][j - 1];
				}			
			}
		}
		
		System.out.println("Longest Common Subsequence Substring = " + len);
		for (String s : results) {
			System.out.println(s);
		}
		
	}
}
