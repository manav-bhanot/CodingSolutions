/**
 * 
 */
package com.geeksforgeeks.amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Manav
 * 
 *         Given an array of integers having size n. Find k numbers with most
 *         occurrences
 *
 */
public class KNumbersWithMostOccurences {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr1 = new int[] { 3, 1, 4, 4, 5, 2, 6, 1 };
		int[] arr2 = new int[] { 7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9 };

		for (int num : findKMostOccuredNumbers(arr1, 2)) {
			System.out.print(num + " ");
		}
		
		System.out.println("\n");

		for (int num : findKMostOccuredNumbers(arr2, 4)) {
			System.out.print(num + " ");
		}

	}

	private static int[] findKMostOccuredNumbers(int[] arr, int k) {

		PriorityQueue<Entry> pq = new PriorityQueue<Entry>();
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int num : arr) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		for (int key : map.keySet()) {
			pq.add(new Entry(key, map.get(key)));
		}
		
		int[] res = new int[k];
		int idx = 0;
		
		while (idx < k) {
			res[idx] = pq.remove().val;
			idx++;
		}
		
		return res;
	}

}

class Entry implements Comparable<Entry> {
	int val;
	int freq;

	public Entry(int val, int freq) {
		this.val = val;
		this.freq = freq;
	}

	@Override
	public int compareTo(Entry o) {
		
		if (((Integer)o.freq).compareTo(this.freq) == 0) {
			return ((Integer)o.val).compareTo(this.val);
		}
		
		return ((Integer)o.freq).compareTo(this.freq);
	}
}
