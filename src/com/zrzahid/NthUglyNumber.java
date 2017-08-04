/**
 * 
 */
package com.zrzahid;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Manav
 * 
 *         Write a program to find the n-th ugly number.
 * 
 *         Ugly numbers are positive numbers whose prime factors only include 2,
 *         3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of
 *         the first 10 ugly numbers.
 * 
 *         Note that 1 is typically treated as an ugly number.
 *
 */
public class NthUglyNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int n = 11;

		// Complexity : O(nlogn)

		int nthUgly = findNthUglyNumberUsingMinHeap(n);
		System.out.println(n + "th ugly number (using Min Heap) is : " + nthUgly);

		// Complexity : O(n)
		nthUgly = findNthUglyNumberUsingDP(n);
		System.out.println(n + "th ugly number (using DP) is : " + nthUgly);

	}

	/**
	 * O(nlogn)
	 * We can see that an ugly number is a multiple of either 2, 3 or 5. Only
	 * exception is that 1 is also ugly. Starting from 1 can we multiply 1 by 2, 3,
	 * and 5 then can we get next 3 ugly numbers {2, 3, 5}? No, because there is one
	 * more ugly number 4 before 5. So it is obvious that each time we pick min ugly
	 * and compute all the numbers multiples of 2,3, and 5 of that number and add it
	 * to a data structure. Next time we pick the minimum and so on. Which data
	 * structures fit where we aways get min in O(1) time? Answer is MinHeap.
	 * 
	 * So, we will keep a min heap and initially push 1 as the first ugly number.
	 * The heap is {1}. Now, for next ugly number we extract min 1 from heap and
	 * push the multiples of 2, 3, and 5. Now, the heap becomes {2, 3, 5}. For next
	 * ugly we extract min from heap which is 2. SO, we push 2*2=4, 2*3=6, 2*5=10
	 * into the heap and the heap becomes {3, 4, 5, 6, 10}. Next we extract 3 and
	 * push 3*2=6, 3*3=9, and 3*5=15. Note that, we already pushed 6 so we should
	 * not push another 6 into heap. Now heap becomes {4, 5, 6, 9, 10, 15}. And so
	 * on.
	 * @param n
	 * @return
	 */
	private static int findNthUglyNumberUsingMinHeap(int n) {

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		Set<Integer> pushedElems = new HashSet<Integer>();
		int[] primeFactors = new int[] { 2, 3, 5 };

		minHeap.add(1);
		pushedElems.add(1);
		int min = 1;

		while (n > 0) {
			min = minHeap.poll();
			
			for (int f : primeFactors) {
				int num = min * f;
				if (!pushedElems.contains(num)) {
					minHeap.offer(num);
					pushedElems.add(num);
				}
			}
			n--;
		}

		return min;
	}

	/**
	 * DP Approach
	 * 
	 * @param n
	 * @return
	 */
	private static int findNthUglyNumberUsingDP(int n) {
		
		int[] ugly = new int[n];
		ugly[0] = 1;
		
		int i2 = 0, i3 = 0, i5 = 0;
		
		for (int idx = 1; idx < n; idx++) {
			
			int nextUglyNum = Integer.min(ugly[i2] * 2, Integer.min(ugly[i3] * 3, ugly[i5] * 5));
			ugly[idx] = nextUglyNum;
			
			if (nextUglyNum == ugly[i2] * 2) {
				i2++;
			}
			if (nextUglyNum == ugly[i3] * 3) {
				i3++;
			} 
			if (nextUglyNum == ugly[i5] * 5) {
				i5++;
			}
		}
		return ugly[n-1];
	}
}
