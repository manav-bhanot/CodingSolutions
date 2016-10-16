/**
 * 
 */
package com.hackerrank.algorithm.dynamicprogramming.longestcommonsubsequence.bruteforce;

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
		int m = read.nextInt();
		
		StringBuilder a = new StringBuilder();
		for (int i=0; i<n; i++) {
			a.append(read.next());
		}
		
		StringBuilder b = new StringBuilder();
		for (int i=0; i<m; i++) {
			b.append(read.next());
		}
		
		String max = "";
		String min = "";
		
		if (a.length() > b.length()) {
			max = a.toString();
			min = b.toString();
		} else {
			max = b.toString();
			min = a.toString();
		}
		
		int[] arr = new int[min.length()];
		
		for (int i=0; i<min.length(); i++) {
			arr[i] = max.indexOf(min.charAt(i));		
		}
		
		StringBuilder longestCommonSubSeq = new StringBuilder();
		
		for (int i=0; i<arr.length; i++) {
			if (arr[i] != -1) {
				longestCommonSubSeq.append(min.charAt(i));
			}
		}		
		System.out.println(longestCommonSubSeq);
	}
}
