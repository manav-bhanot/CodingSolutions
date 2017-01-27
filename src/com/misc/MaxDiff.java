/**
 * 
 */
package com.misc;

/**
 * @author 014838159-sa
 * 
 *         Given an array. Find the max difference between any pair of elements
 *         of an array with the below constraint
 * 
 *         For all i,j a[i] < a[j] and i < j
 *
 */
public class MaxDiff {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// int a[] = { 2, 3, 10, 6, 4, 8, 1 };
		int a[] = { 5, 7, 1, };
		System.out.println(findMaxDiff(a));

	}

	/**
	 * Approach being used here is :
	 * 
	 * Find the min element found so far and subtract it from the current element 
	 * if the diff > 0 and the diff is greater than the prev diff
	 * then update the maxdiff variable
	 * 
	 * @param a
	 * @return
	 */
	public static int findMaxDiff(int[] a) {
		int min = Integer.MAX_VALUE;
		int maxDiff = Integer.MIN_VALUE;
		int diff = 0;
		for (int i = 0; i < a.length; i++) {

			if (a[i] < min) {
				min = a[i];
			}

			diff = a[i] - min;

			if (diff > maxDiff && min < a[i]) {
				maxDiff = diff;
			}
		}
		return maxDiff;
	}
}
