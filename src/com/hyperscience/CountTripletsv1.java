/**
 * 
 */
package com.hyperscience;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Manav
 * 
 * Given an array a[] of positive integers of length n and a number c.
 * Count all the triplets (a[i], a[j], a[k]) that satisfies the below constraints
 * 
 * (i)  a[i] + a[j] + a[k] > c
 * (ii) i < j < k
 *
 */
public class CountTripletsv1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		CountTripletsv1 obj = new CountTripletsv1();
		/*int a[] = obj.createArray();
		
		int c = 143;*/
		
		int arr[] = new int[]{5, 1, 3, 4, 7};
		int sum = 2;
		int triplets = obj.findTriplets(arr, sum);
		
		// int triplets = obj.findTriplets(a, c);
		
		System.out.println(triplets);
	}
	
	
	private int findTriplets(int[] a, int c) {
		int len = a.length;
		
		if (len < 3) {
			return 0;
		}
		
		int count = 0;		
		Arrays.sort(a);
		
		for (int i = 0; i < len; i++) {
			
			int left = i + 1, right = len - 1;
			
			while (left < right) {
				
				if (a[i] + a[left] + a[right] <= c) {
					// Manipulate the pointers
					// Since the sum is < c => we need a bigger element
					// So move forward the left pointer
					left++;			
				} else {
					// Increment the count of triplets found
					count = count + (right - left);
					
					// Now we have our triplet found at the current location of i, left and right.
					// Lets decrement the right counter now
					right--;
				}
			}
		}
		
		return count;
	}

	private int[] createArray() {
		
		int upperBound = 1000;
		Random r = new Random();
		int n = r.nextInt(upperBound);
		
		int[] a = new int[n];
		
		for (int i=0; i < n; i++) {
			a[i] = r.nextInt(upperBound);
		}
		
		return a;
	}
}
