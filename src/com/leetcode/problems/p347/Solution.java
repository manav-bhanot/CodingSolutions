package com.leetcode.problems.p347;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


/**
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 * https://leetcode.com/problems/top-k-frequent-elements/
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 *
 *
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> valueFrequencyMap = new HashMap<>();

        int maxFrequency = 0;

        // Create the value frequency map
        // eg: an entry [1,10] => the value 1 appears 10 times in the list
        for (int val: nums) {
            valueFrequencyMap.put(val, valueFrequencyMap.getOrDefault(val, 0) + 1);
            maxFrequency = Math.max(valueFrequencyMap.get(val), maxFrequency);
        }


        /**
         * Solution using PriorityQueue
         */
        PriorityQueue<Pair> pq = new PriorityQueue();

        // Add the elements in a priority queue, ordered by their frequency such that the element
        // with the highest frequency is at the top of the queue.

        for (int element: valueFrequencyMap.keySet()) {
            pq.add(new Pair(element, valueFrequencyMap.get(element)));
        }

        int[] kMostFrequentElementsArray = new int[k];
        for (int idx = 0; idx < k; idx++) {
            kMostFrequentElementsArray[idx] = pq.poll().element;
        }
        return kMostFrequentElementsArray;

        /**
         * Solution using Bucket Sort
         */

//         List<Integer>[] frequentElements = new List[maxFrequency + 1];
//         for (int element: valueFrequencyMap.keySet()) {
//             int fIdx = valueFrequencyMap.get(element);
//             if (frequentElements[fIdx] == null) {
//                 frequentElements[fIdx] = new ArrayList();
//             }
//             frequentElements[fIdx].add(element);
//         }

//         List<Integer> kMostFrequentElementsList = new ArrayList();
//         int idx = frequentElements.length - 1;

//         do {
//             if (frequentElements[idx] != null && frequentElements[idx].size() > 0) {
//                 kMostFrequentElementsList.addAll(frequentElements[idx]);
//             }
//             idx--;

//         } while (idx > 0 && kMostFrequentElementsList.size() < k);


//         return kMostFrequentElementsList.stream().mapToInt(Integer::intValue).toArray();
    }
}
/**
 * Custom class created for PriorityQueue solution
 */
class Pair implements Comparable<Pair> {
    Integer element;
    Integer frequency;

    public Pair(int element, int frequency) {
        super();
        this.element = element;
        this.frequency = frequency;
    }

    public int compareTo(Pair p) {
        Pair thisPair = (Pair) this;
        return p.frequency.compareTo(thisPair.frequency);
    }
}
