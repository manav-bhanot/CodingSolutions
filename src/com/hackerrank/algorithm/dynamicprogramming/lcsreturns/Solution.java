/**
 * 
 */
package com.hackerrank.algorithm.dynamicprogramming.lcsreturns;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Manav
 *
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named AdditionWithoutUsingOperator.
		 */
		Scanner read = new Scanner(System.in);
		String a = read.next();
		String b = read.next();

		int n = a.length();
		int m = b.length();

		char string_a[] = new char[n + 1];
		char string_b[] = new char[m + 1];

		System.arraycopy(a.toCharArray(), 0, string_a, 1, n);
		System.arraycopy(b.toCharArray(), 0, string_b, 1, m);

		int dp[][] = new int[n + 1][m + 1];

		// Initialize row 0 and column 0 of dp to 0
		Arrays.fill(dp[0], 0);
		for (int i = 1; i < n + 1; i++) {
			dp[i][0] = 0;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (string_a[i] == string_b[j]) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}

		/*
		 * for (int i=1; i<=n; i++) { System.out.println(); for (int j=1; j<=m;
		 * j++) { System.out.print(dp[i][j]+ " "); } }
		 * 
		 * System.out.println();
		 */

		char[] lcs = new char[dp[n][m]];

		int i = n;
		int j = m;
		while (i > 0 && j > 0) {
			if (string_a[i] == string_b[j]) {
				lcs[dp[i][j] - 1] = string_a[i];
				i--;
				j--;
			} else if (dp[i - 1][j] > dp[i][j - 1]) {
				i--;
			} else {
				j--;
			}
		}

		for (char z : lcs) {
			System.out.print(z);
		}
	}
}
