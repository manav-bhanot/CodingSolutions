/**
 * 
 */
package com.hackerrank.algorithm.dynamicprogramming.circularincreasingsubsequence;

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
		int N = read.nextInt();
		
		//System.out.println("N = "+N);
		
		int arr[] = new int[2*N];
		
		for (int i=0; i < N; i++) {
			//System.out.println("i = "+i);
			arr[i] = read.nextInt();
			arr[i+N] = arr[i];
		}
		
		int maxSubSeqSize = 0;
		int index = 0;
		
		for (int i=0; i<N; i++) {
			//System.out.println(getLongestIncreasingSubSeqSize(arr, i, i+N));
			maxSubSeqSize = Math.max(maxSubSeqSize, getLongestIncreasingSubSeqSize(arr, i, i+N));
			//System.out.println(maxSubSeqSize);
		}		
		System.out.println(maxSubSeqSize);
		
	}
	
	private static int getLongestIncreasingSubSeqSize(int arr[], int si, int ei) {
		int[] LS = new int[ei-si];
		for (int i=0; i<ei-si-1; i++) {
			LS[0] = 1;
			
			for (int j=0; j<i; j++) {
				if (arr[i+si] > arr[j+si] && LS[i] <= LS[j]) {
					LS[i] = LS[j] + 1;
				}
			}
		}
		
		int maxSize = LS[0];
		for (int i=0; i<LS.length; i++) {
			maxSize = Math.max(maxSize, LS[i]);
		}
		
		return maxSize;
	}
}
