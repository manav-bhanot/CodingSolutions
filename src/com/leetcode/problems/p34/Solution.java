package com.leetcode.problems.p34;

/**
 * 34. Find First and Last Position of Element in Sorted Array.
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 *
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] targetPositions = new int[] {-1, -1};

        /**
         * Usually in Binary Search, we stop the search at the moment when we find the element in the sorted array and
         * return the index as output. If the element is not found, we return -1.
         *
         * In this case, the only change is that we have to keep looking in the specified directions
         * (as governed by normal binary search) and if we found an element, chances are that there might be
         * duplicate elements either on the left or right side of the element.
         * And hence we need to continue searching in the corresponding directions to get the leftmost
         * and rightmost indices.
         */
        bSearchLeft(nums, target, 0, nums.length - 1, targetPositions);
        bSearchRight(nums, target, 0, nums.length - 1, targetPositions);

        return targetPositions;
    }

    private void bSearchLeft(int[] nums, int target, int leftIdx, int rightIdx, int[] targetPositions) {

        if (leftIdx > rightIdx) {
            return;
        }

        int mid = (leftIdx + rightIdx)/2;

        if (nums[mid] == target) {
            targetPositions[0] = mid;
            bSearchLeft(nums, target, leftIdx, mid -1, targetPositions);
        } else if (nums[mid] > target) {
            bSearchLeft(nums, target, leftIdx, mid - 1, targetPositions);
        } else if (nums[mid] < target) {
            bSearchLeft(nums, target, mid + 1, rightIdx, targetPositions);
        }
    }

    private void bSearchRight(int[] nums, int target, int leftIdx, int rightIdx, int[] targetPositions) {

        if (leftIdx > rightIdx) {
            return;
        }

        int mid = (leftIdx + rightIdx) / 2;

        if (nums[mid] == target) {
            targetPositions[1] = mid;
            bSearchRight(nums, target, mid + 1, rightIdx, targetPositions);
        } else if (nums[mid] > target) {
            bSearchRight(nums, target, leftIdx, mid - 1, targetPositions);
        } else if (nums[mid] < target) {
            bSearchRight(nums, target, mid + 1, rightIdx, targetPositions);
        }
    }
}
