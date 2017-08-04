/**
 * 
 */
package com.zrzahid;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Manav
 * 
 * Given a collection of intervals.
 * Find the total number of overlapping intervals
 *
 */
public class MaxNumberOfOverlappingIntervals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[][] intervals = new int[][] {
			{1,3}, {2,6}, {8,10},{15,18}, {3,9}, {5,7}, {11,14}, {19,21}			
		};
		
		int totalOverlappingIntervals = findOverlappingIntervals(intervals);
		System.out.println("Total Overlapping Intervals are : " + totalOverlappingIntervals);
	}
	
	static void printIntervals(int[][] intervals) {
		
		for (int i = 0; i < intervals.length; i++) {
			System.out.println("[" + intervals[i][0] + "," + intervals[i][1] + "]");
		}
		
	}

	private static int findOverlappingIntervals(int[][] intervals) {
		
		// printIntervals(intervals);
		
		Arrays.sort(intervals, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
			
		});
		
		// printIntervals(intervals);
		
		int end = intervals[0][1], count = 1, maxCount = 0;
		
		for (int i = 1; i < intervals.length; i++) {
			if (end >= intervals[i][0]) {
				maxCount = Integer.max(maxCount, ++count);
			} else {
				count = 0;
			}
			end = intervals[i][1];
		}
		
		return maxCount;
	}

}
