/**
 * 
 */
package com.hackerrank.algorithm.implementation.mindistances;

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
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int A[] = new int[n];
		for (int A_i = 0; A_i < n; A_i++) {
			A[A_i] = in.nextInt();
		}

		int d = n + 1;
		int min_distance = n + 1;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (A[i] == A[j]) {
					d = Math.abs(i - j);
					break;
				}
			}
			min_distance = Math.min(min_distance, d);
		}
		System.out.println(min_distance != n+1 ? min_distance : "-1");

	}

}
