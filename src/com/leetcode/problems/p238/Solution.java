package com.leetcode.problems.p238;

/**
 * 238. Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self/
 *
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 *
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 *
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {

        /**
         * Solution using O(n) space
         */

//         int[] leftProducts = new int[nums.length];
//         int[] rightProducts = new int[nums.length];

//         leftProducts[0] = 1;
//         for (int i=1; i < nums.length; i++) {
//             leftProducts[i] = nums[i-1] * leftProducts[i-1];
//         }

//         rightProducts[nums.length - 1] = 1;
//         for (int i=nums.length-2; i >= 0; i--) {
//             rightProducts[i] = nums[i+1] * rightProducts[i+1];
//         }

//         int[] result = new int[nums.length];
//         for (int i=0; i<nums.length; i++) {
//             result[i] = leftProducts[i] * rightProducts[i];
//         }

//         return result;

        /**
         * Solution using O(1) space
         */
        int[] result = new int[nums.length];

        int prefixProduct = 1;
        result[0] = prefixProduct;

        for (int i=1; i<nums.length; i++) {
            prefixProduct = prefixProduct * nums[i-1];
            result[i] = prefixProduct;
        }

        //At this point,result=[1,1,2,6]. Note that the element at index i is the product of all elements from 0..i-1

        //Now we need to iterate backwards maintaining a product of suffixes in a variable called suffixProduct
        //In the same loop, we will update result array and
        //set the element at index i = suffixProduct * result[i] (which is basically existing prefixProduct at index i


        int suffixProduct = 1;
        for (int i=nums.length-2; i >= 0; i--) {
            suffixProduct = suffixProduct * nums[i+1];
            result[i] = result[i] * suffixProduct;
        }

        return result;
    }
}
