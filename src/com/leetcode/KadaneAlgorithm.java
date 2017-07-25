/**
 * 
 */
package com.leetcode;

/**
 * @author Manav
 *
 */
public class KadaneAlgorithm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(maxSubarraySum(new int[] {-2,1,-3,4,-1,2,1,-5,4} ));
	}
	
	static int maxSubarraySum(int[] nums) {
		
		int currSum = 0, maxSum = Integer.MIN_VALUE;
		int startIdx = 0, endIdx = 0, beg = 0;
		
		for (int i = 0; i < nums.length; i++) {
			
			currSum += nums[i];
			
			if (currSum > maxSum) {
				maxSum = currSum;
				startIdx = beg;
				endIdx = i;
			} 
			
			if (currSum < 0) {
				currSum = 0;
				beg = i + 1;
			}			
		}
		
		for (int i = startIdx; i <= endIdx; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
		return maxSum;		
	}

}
