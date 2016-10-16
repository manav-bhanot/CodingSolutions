/**
 * 
 */
package com.hackerrank.algorithm.implementation.equalstacks;

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
		int n1 = in.nextInt();
		int n2 = in.nextInt();
		int n3 = in.nextInt();

		int h_s1 = 0;
		int h_s2 = 0;
		int h_s3 = 0;
		int top_s1 = n1 - 1;
		int top_s2 = n2 - 1;
		int top_s3 = n3 - 1;

		int h1[] = new int[n1];
		for (int h1_i = n1 - 1; h1_i >= 0; h1_i--) {
			h1[h1_i] = in.nextInt();
			h_s1 = h_s1 + h1[h1_i];
		}
		int h2[] = new int[n2];
		for (int h2_i = n2 - 1; h2_i >= 0; h2_i--) {
			h2[h2_i] = in.nextInt();
			h_s2 = h_s2 + h2[h2_i];
		}
		int h3[] = new int[n3];
		for (int h3_i = n3 - 1; h3_i >= 0; h3_i--) {
			h3[h3_i] = in.nextInt();
			h_s3 = h_s3 + h3[h3_i];
		}

		while (!(h_s1 == h_s2 && h_s2 == h_s3)) {
			if (Math.max(h_s2, h_s3) < h_s1) {
				// h_s1 is maximum
				h_s1 = h_s1 - h1[top_s1];
				top_s1--;
			} else if (h_s2 > h_s3) {
				// h_s2 is maximum
				h_s2 = h_s2 - h2[top_s2];
				top_s2--;
			} else {
				// h_s3 is maximum
				h_s3 = h_s3 - h3[top_s3];
				top_s3--;
			}
			if (h_s1 == 0 || h_s2 == 0 || h_s3 == 0) {
				h_s1 = 0;
				h_s2 = 0;
				h_s3 = 0;
			}
		}
		System.out.println(h_s1);
	}
}
