/**
 * 
 */
package com.hyperscience;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author Manav
 * 
 *         Given an array a[] of positive integers of length n and a number c.
 *         Count all the triplets (a[i], a[j], a[k]) that satisfies the below
 *         constraints
 * 
 *         (i) a[i] + a[j] + a[k] > c
 * 
 *         (ii) i < j < k
 * 
 *         (iii) a[i] < a[j] < a[k]
 *
 */
public class CountTripletsv2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CountTripletsv2 obj = new CountTripletsv2();
		/*
		 * int a[] = obj.createArray();
		 * 
		 * int c = 143;
		 */

		int arr[] = new int[] { 5, 1, 3, 4, 7, 2, 6, 9, 8 };
		int c = 10;
		int triplets = obj.findTriplets(arr, c);

		// int triplets = obj.findTriplets(a, c);

		System.out.println(triplets);

	}

	private int findTriplets(int[] a, int c) {
		int len = a.length;

		if (len < 3) {
			return 0;
		}

		int[] indices = new int[len];
		for (int i = 0; i < len; i++) {
			indices[i] = a[i];
		}

		int count = 0;

		// Sort the array a and also order the indices array
		// such that the indices dictate the sorted order
		sort(a, indices);

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
					
					// Check the constraints on the indices
					// The constraint on the individual elements automatically holds here
					if (indices[i] < indices[left] && indices[left] < indices[right]) {
						System.out.println("<" + a[i] + "," + a[left] + "," + a[right] + ">");
						count++;
					}

					// Now we have our triplet found at the current location of i, left and right in the sorted array.
					// Lets decrement the right counter now
					right--;
				}
			}
		}

		return count;
	}

	private void sort(int[] a, int[] indices) {

		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();

		for (int i = 0; i < a.length; i++) {
			pq.add(new Pair(a[i], i));
		}

		int idx = 0;
		while (!pq.isEmpty()) {
			Pair p = pq.remove();
			a[idx] = p.val;
			indices[idx] = p.index;
			idx++;
		}

	}

	private int[] createArray() {

		int upperBound = 1000;
		Random r = new Random();
		int n = r.nextInt(upperBound);

		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = r.nextInt(upperBound);
		}

		return a;
	}

}

class Pair implements Comparable<Pair> {
	Integer val;
	Integer index;

	public Pair(Integer val, Integer index) {
		super();
		this.val = val;
		this.index = index;
	}

	@Override
	public int compareTo(Pair o) {
		return this.val.compareTo(o.val);
	}
}
