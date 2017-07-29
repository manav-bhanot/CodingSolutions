/**
 * 
 */
package com.leetcode.dp;

/**
 * @author Manav
 *
 */
public class LongestCommonSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		findLongestCommonLCS("bedaacbade", "dccaeedbeb");
	}
	
	private static void findLongestCommonLCS(String s1, String s2) {
		
		if (s1.isEmpty() || s2.isEmpty()) {
			System.out.println("Length of Longest Common Subsequence is : " + 0);
			return;
		}
		
		char[] cArr1 = s1.toCharArray();
		char[] cArr2 = s2.toCharArray();
		
		int[][] lcs = new int[cArr1.length + 1][cArr2.length + 1];
		
		for (int i = 1; i < lcs.length; i++) {
			for (int j = 1; j < lcs[0].length; j++) {
				
				if (cArr1[i - 1] == cArr2[j - 1]) {					
					lcs[i][j] = 1 + lcs[i-1][j-1];
				} else {
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
				}				
			}
		}
		
		System.out.println("Length of Longest Common Subsequence is : " + lcs[cArr1.length][cArr2.length]);
		
	}

}
