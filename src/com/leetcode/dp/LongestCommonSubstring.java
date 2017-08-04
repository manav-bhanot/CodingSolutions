/**
 * 
 */
package com.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Manav
 *
 */
public class LongestCommonSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(findLCS("maninder", "manpinder"));
	}

	private static String findLCS(String s1, String s2) {

		char[] cArr1 = s1.toCharArray();
		char[] cArr2 = s2.toCharArray();

		int[][] lcs = new int[cArr1.length][cArr2.length];
		
		int rows = lcs.length;
		int cols = lcs[0].length;
		
		
		int maxLen = Integer.MIN_VALUE;
		List<String> results = new ArrayList<String>();

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				
				//System.out.println("i = " + i + " j = " + j);
				if (cArr1[i] == cArr2[j]) {	
					
					if (i == 0 || j == 0) {
						lcs[i][j] = 1;
						results.add(String.valueOf(cArr1[i]));
					} else {
						lcs[i][j] = 1 + lcs[i - 1][j - 1];
						
						if (lcs[i][j] > maxLen) {
							maxLen = lcs[i][j];
							results.clear();
						}
						
						// Add the maximum length substring found till now
						results.add(s2.substring(j - maxLen + 1, j+1));
					}					
				}
			}
		}		
		// System.out.println(maxLen + " : " + results.get(0));	
		return results.get(0);
	}

}
