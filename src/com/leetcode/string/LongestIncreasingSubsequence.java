/**
 * 
 */
package com.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Manav
 *         The Longest Increasing Subsequence (LIS) problem is to find the
 *         length of the longest subsequence of a given sequence such that all
 *         elements of the subsequence are sorted in increasing order. For
 *         example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is
 *         6 and LIS is {10, 22, 33, 50, 60, 80}.
 *
 */
public class LongestIncreasingSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int arr[] = new int[] { 10, 22, 9, 33, 21, 50, 41, 60 };
		System.out.println(findLengthOfLongestIncreasingSubsequence(arr));
	}

	private static int findLengthOfLongestIncreasingSubsequence(int[] arr) {

		int lis[] = new int[arr.length];
		lis[0] = 1;

		for (int idx = 1; idx < arr.length; idx++) {

			lis[idx] = 1;

			for (int i = 0; i < idx; i++) {

				if (arr[idx] > arr[i] && 1 + lis[i] > lis[idx]) {
					lis[idx] = 1 + lis[i];
				}
			}
		}
		
		System.out.println("Printing the LIS array");
		for (int n : lis) {
			System.out.print(n + " ");
		}
		
		int len = lis[arr.length - 1];
		System.out.println("Printing the Longest Increasing SubSequence");
		for (int i = lis.length - 1; i >= 0; i--) {
			if (lis[i] == len) {
				System.out.print(arr[i] + " ");
				len--;
			}
		}

		return lis[arr.length - 1];
	}
}
