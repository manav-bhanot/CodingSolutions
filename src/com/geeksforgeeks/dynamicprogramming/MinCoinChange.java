/**
 * 
 */
package com.geeksforgeeks.dynamicprogramming;

/**
 * Src : https://www.topcoder.com/community/data-science/data-science-tutorials/dynamic-programming-from-novice-to-advanced/
 * Algorithm Used
 * 
 * Set Min[i] equal to Infinity for all of i
 * 
 * Min[0]=0
 * 
 * For i = 1 to S           
 * For j = 0 to N - 1 
 * 		If (Vj<=i AND Min[i-Vj]+1<Min[i]) Then
 * 			Min[i]=Min[i-Vj]+1
 * 
 * Output Min[S]
 * 
 * @author Manav
 *
 */
public class MinCoinChange {

	private int sum = 11;
	private int[] coins = { 1, 2, 3, 5 };

	private int findMinCoins() {
		int[] min = new int[sum + 1];

		for (int i = 0; i < min.length; i++) {
			min[i] = Integer.MAX_VALUE;
		}

		min[0] = 0;

		for (int i = 0; i < min.length; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i && min[i - coins[j]] + 1 < min[i]) {
					min[i] = min[i - coins[j]] + 1;
				}
			}
		}

		return min[sum];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MinCoinChange obj = new MinCoinChange();
		System.out.println(obj.findMinCoins());

	}

}
