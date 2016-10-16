/**
 * 
 */
package com.hackerrank.algorithm.dynamicprogramming.minimumstepstoone.bottomsupapproach;

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

		Scanner read = new Scanner(System.in);
		int n = read.nextInt();

		System.out.println(getMinSteps(n));
	}
	
	private static int getMinSteps(int n) {
		
		int dp[] = new int[n+1];
		int i = 0;
		
		dp[1] = 0;
		
		for (i=2; i<=n; i++) {
			dp[i] = 1 + dp[i-1];
			
			if (i%2 == 0) {
				dp[i] = Math.min(dp[i], 1 + dp[i/2]);				
			}
			
			if (i%3 == 0) {
				dp[i] = Math.min(dp[i], 1 + dp[i/3]);
			}
		}
		
		return dp[n];
	}

}
