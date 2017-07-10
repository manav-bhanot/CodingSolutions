/**
 * 
 */
package com.leetcode;

/**
 * @author Manav
 * 
 *         Given an array of numbers nums, in which exactly two elements appear
 *         only once and all the other elements appear exactly twice. Find the
 *         two elements that appear only once.
 * 
 *         For example:
 * 
 *         Given nums = [1, 2, 1, 3, 2, 5],
 *         return [3, 5].
 * 
 *         Note:
 *         The order of the result is not important.
 *         So in the above example, [5, 3] is also correct.
 *         Your algorithm should run in linear runtime complexity. 
 *         Could you implement it using only constant space complexity?
 *
 */
public class SingleNumberV3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SingleNumberV3 obj = new SingleNumberV3();
		
		int[] nums = new int[] {1, 2, 1, 3, 2, 5};		
		
		int[] uniqueElements = obj.findUniqueElements(nums);
		
		for (int el : uniqueElements) {
			System.out.print(el + " ");
		}
	}

	private int[] findUniqueElements(int[] nums) {
		
		// First XOR all the array elements
		// Since every element in the array occurs twice
		// except for those 2 elements.
		// Therefore the final xor result will give XOR of those 2 unique elements
		// Lets find it first
		
		int xor = 0;
		for (int el : nums) {
			xor ^= el;
		}
		
		// Now we have the xor of two unique elements
		// the individual set bit values in this xor provides us with the information
		// about those bits that are different in both the unique values
		// since only those bits will be set after xor operation on those numbers
		
		// Lets find the rightmost set bit of this xor element
		// which enables us to know the first LSB which differs in 
		// both these unique numbers
		
		// The below operation achieves this task
		xor = xor & (-xor);
		
		// Now we can group our original array elements
		// into 2 groups
		// 1 -> having that particular bit set
		// 2 -> having that particular bit unset
		// xoring the two groups will give us the two unique numbers
		
		int num1 = 0;
		int num2 = 0;
		
		for (int el : nums) {
			if ((el & xor) == 0) {
				num1 ^= el;
			} else {
				num2 ^= el;
			}
		}		
		return new int[] {num1, num2};		
	}

}
