/**
 * 
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Manav
 *
 */
public class LongestIncreasingSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] arr = new int[] {10,1,11,2,12,3,11};
		findlis(arr);		
	}
	
	private static int findIndex(int[] nums, int low, int high, int num) {
		
		while (low < high) {
			
			int mid = (int)Math.ceil(low + (high - low)/2);
			
			if (num <= nums[mid]) {
				high = mid;
			} else {
				low = mid;
			}
		}
		return high + 1;
	}
	
	private static void findlis(int[] nums) {
		
		int[] endElements = new int[nums.length];
		endElements[0] = nums[0];
		int len = 1;
		
		for (int i = 1; i < nums.length; i++) {
			
			if (nums[i] < endElements[0]) {
				endElements[0] = nums[i];
			} else if (nums[i] > endElements[len - 1]) {
				endElements[len] = nums[i];
				len++;
			} else {
				int idx = findIndex(nums, 0, len - 1, nums[i]);
				endElements[idx] = nums[i];
			}			
		}
		
		System.out.println(len);
	}

}
