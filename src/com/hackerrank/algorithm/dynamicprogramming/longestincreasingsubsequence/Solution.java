/**
 * 
 */
package com.hackerrank.algorithm.dynamicprogramming.longestincreasingsubsequence;

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
		// TODO Auto-generated method stub
		
		Scanner read = new Scanner(System.in);
		int n = read.nextInt();
		
		int[] a = new int[n];
		
		for (int i=0; i<n; i++) {
			a[i] = read.nextInt();
			System.out.println(a[i]);
		}
		
		int LS[] = new int[n];
		
		for (int i=0; i<n; i++) {
			LS[i] = 1;			
			for (int j=0; j<i; j++) {
				if (a[i] > a[j] && LS[i] <= LS[j]) {
					LS[i] = 1 + LS[j];
				}
			}
			//System.out.println(LS[i]);
		}
		int largestSubSeqSize = LS[0];
		for (int i=1; i<n; i++) {
			//System.out.println(LS[i]);
			largestSubSeqSize = Math.max(largestSubSeqSize, LS[i]);
		}
		
		System.out.println(largestSubSeqSize);
	}

}
