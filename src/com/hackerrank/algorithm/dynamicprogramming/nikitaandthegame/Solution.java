/**
 * 
 */
package com.hackerrank.algorithm.dynamicprogramming.nikitaandthegame;

import java.util.Scanner;

/**
 * @author Manav
 *
 */
public class Solution {
	
	private static long getSum(long[] a, int si, int ei) {
		long sum = 0;
		for (int i=si; i<ei; i++) {
			sum = sum + a[i];
		}
		//System.out.println("Sum = "+sum+" && Sum/2 = "+sum/2);
		
		return sum;
	}
	
	private static int findPartition(int si, int ei, long[] arr) {
		int i = si;
		long sum = getSum(arr, si, ei);
		if (sum%2 != 0) return -1;
		long subsetSum = 0;
		
		while (i < ei) {
			subsetSum += arr[i];
			if (subsetSum == sum/2) {
				//System.out.println("k = "+i);
				return i;
			}
			i++;
		}
		
		return -1;
	}
	
	private static char chooseDirection(int si, int k, int ei, long[] arr) {
		
		long lMax = 0;
		long rMax = 0;
		long rMin = Integer.MAX_VALUE;
		long lMin = Integer.MAX_VALUE;
		
		for (int i=si; i<=k; i++) {
			lMax = Math.max(lMax, arr[i]);
			lMin = Math.min(lMin, arr[i]);
		}
		
		for (int i=k+1; i<ei; i++) {
			rMax = Math.max(rMax, arr[i]);
			rMin = Math.min(rMin, arr[i]);
		}
		
		if (lMax - lMin > rMax - rMin) {
			return 'r';
		} else {
			return 'l';
		}
		
	}
	
	private static boolean isZeroElementArray(long[] a, int N) {
		for (int i=0; i<N; i++) {
			if (a[i] != 0) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean isValidPartition(int si, int k, int ei, long[] arr) {
		long lSum = 0;
		long rSum = 0;
		
		for (int i=si; i<=k; i++) {
			lSum = lSum + arr[i];
		}
		
		for (int i=k+1; i<ei; i++) {
			rSum = rSum + arr[i];
		}
		
		return lSum == rSum ? true : false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner read = new Scanner(System.in);
		int T = read.nextInt();
		
		for (int t=0; t<T; t++) {
			int N = read.nextInt();
			long a[] = new long[N];
			
			for (int i=0; i<N; i++) {
				a[i] = read.nextLong();
			}
			
			int totalPoints = 0;
			int si = 0;
			int ei = N;
			
			if (isZeroElementArray(a, N)) {
				System.out.println(N-1);
			} else {
				int k = findPartition(si, ei, a);
				if (k != -1) totalPoints++;
				
				while (k != -1) {
					if (k - si + 1 == ei - k - 1) {
						if (chooseDirection(si, k, ei, a) == 'r') {
							si = k + 1;
						} else {
							ei = k + 1;
						}						
					} else  if (k - si + 1 < ei - k - 1) {
						si = k + 1;					
					} else {
						ei = k + 1;					
					}
					//System.out.print("si : "+si+", ei : "+ei+ "\n");
					k = findPartition(si, ei, a);
					if (!isValidPartition(si, k, ei, a)) {
						break;
					} else {
						totalPoints++;
					}				
				}
				
				System.out.println(totalPoints);				
			}			
		}
	}
}
