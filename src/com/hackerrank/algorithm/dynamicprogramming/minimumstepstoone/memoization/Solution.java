/**
 * 
 */
package com.hackerrank.algorithm.dynamicprogramming.minimumstepstoone.memoization;

import java.util.Scanner;

/**
 * @author Manav
 *
 */
public class Solution {
	
	//int[] memo[]

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner read = new Scanner(System.in);
		int n = read.nextInt();
		
		int[] memo = new int[n+1];
		
		// We initialize the array to -1. -1 => the particular subproblem is not solved yet.
		/*for (int i=1; i<n+1; i++) {
			memo[i] = -1;
		}*/
		
		System.out.println(getMinSteps(n, memo));

	}
	
	private static int getMinSteps(int n, int[] memo) {
		
		if (n == 1) {
			return 0;
		}
		
		// Check if memo[n] == -1
		// If not => we solved it already and hence we need to send back the solution for that.
		if (memo[n] != 0) {
			return memo[n];
		}
		
		
		int r = 1 + getMinSteps(n-1, memo);
		
		if (n%3 == 0) {
			r = Math.min(r,  1 + getMinSteps(n/3, memo));
		}
		
		if (n%2 == 0) {
			r = Math.min(r, 1 + getMinSteps(n/2, memo));
		}	
		
		
		// Saving the result for future reference.
		// If we forget this step, it is same as plain old recursion.
		memo[n] = r;
		
		return r;
	}

}
