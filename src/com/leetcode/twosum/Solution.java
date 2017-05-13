/**
 * 
 */
package com.leetcode.twosum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Manav
 * 
 *         Given an array of integers, return indices of the two numbers such
 *         that they add up to a specific target.
 * 
 *         You may assume that each input would have exactly one solution.
 * 
 *         Given nums = [2, 7, 11, 15], target = 9,
 * 
 *         Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 *
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = {2,7,11,9};
		twoSum(a, 9);
		
	}

	public static int[] twoSum(int[] nums, int target) {
		
		Map<Integer, Integer> indices = new HashMap<Integer, Integer>();
		int arr[] = new int[2];
		
		for (int index=0; index < nums.length; index++) {			
			
			if (indices.containsKey(target - nums[index])) {
				arr[0] = indices.get(target - nums[index]);;
				arr[1] = index;
			}			
			indices.put(nums[index], index);
		}
		
		return arr;
	}
}
