/**
 * 
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Manav
 * 
 *         Given k sorted arrays of size n each, merge them and print the sorted
 *         output.
 * 
 *         Example:
 * 
 *         Input:
 *         k = 3, n = 4
 *         arr[][] = { {1, 3, 5, 7},
 *         {2, 4, 6, 8},
 *         {0, 9, 10, 11}} ;
 * 
 *         Output: 0 1 2 3 4 5 6 7 8 9 10 11
 *
 */
public class MergeKSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int arr[][] = new int[][] {
			{1, 3, 5, 7},
			{2, 4, 6, 8},
			{0, 9, 10, 11}
		};
		
		List<List<Element>> kSortedArrays = new ArrayList<List<Element>>();
		
		for (int i = 0; i < arr.length; i ++) {
			List<Element> ithArray = new ArrayList<Element>();
			for (int j = 0; j < arr[0].length; j++) {
				Element el = new Element(arr[i][j], i);
				ithArray.add(el);
			}
			kSortedArrays.add(ithArray);
		}
		
		List<Integer> mergedArray= mergeKSortedArrays(kSortedArrays);
		
		for (int num : mergedArray) {
			System.out.print(num + " ");
		}
	}

	private static List<Integer> mergeKSortedArrays(List<List<Element>> kSortedArrays) {
		
		List<Integer> mergedArray = new ArrayList<Integer>();
		
		PriorityQueue<Element> pQ = new PriorityQueue<Element>();
		
		for (int arrayIndex = 0; arrayIndex < kSortedArrays.size(); arrayIndex++) {
			pQ.add(kSortedArrays.get(arrayIndex).remove(0));
		}
		
		while (!pQ.isEmpty()) {
			Element el = pQ.poll();
			mergedArray.add(el.val);
			
			if (!kSortedArrays.get(el.index).isEmpty()) {
				pQ.add(kSortedArrays.get(el.index).remove(0));
			}
		}		
		return mergedArray;
	}
}

class Element implements Comparable<Element> {
	int val;
	int index;
	public Element(int val, int index) {
		super();
		this.val = val;
		this.index = index;
	}
	@Override
	public int compareTo(Element o) {
		return ((Integer) this.val).compareTo(o.val);
	}
}
