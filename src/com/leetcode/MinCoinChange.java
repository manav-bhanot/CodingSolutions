/**
 * 
 */
package com.leetcode;

/**
 * @author Manav
 * 
 *         Given a value V, if we want to make change for V cents, and we have
 *         infinite supply of each of C = { C1, C2, .. , Cm} valued coins, what
 *         is the minimum number of coins to make the change?
 *         
 *         Also print the coin denominations that are required to make the change
 *
 */
public class MinCoinChange {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] coins = new int[] { 7, 2, 3, 1 };
		
		int N = 13;
		
		// to store the indices of the coins in the coin array
		int[] coinIndices = new int[N+1];
		for (int i = 0; i < coinIndices.length; i++) {
			coinIndices[i] = -1;
		}

		System.out.println(findMinCoins(coins, coinIndices, N));

	}

	private static int findMinCoins(int[] coins, int[] coinIndices, int n) {

		// T arrays stores the total number of coins req
		// T[lastIndex] gives the final answer
		int[] T = new int[n + 1];
		T[0] = 0;
		for (int i = 1; i < T.length; i++) {
			T[i] = Integer.MAX_VALUE - 1;
		}

		for (int coin : coins) {

			for (int value = 0; value < T.length; value++) {

				// System.out.println(value + " : " + coins[coin] + " : " + T[value]);
				if (value >= coin) {
					T[value] = Math.min(T[value], 1 + T[value - coin]);
					
					/*if (coinIndices[value] < 0) {
						coinIndices[value] = coin;
					}*/											
				}

			}
		}

		/*
		 * for (int t : T) {
		 * System.out.print(t + " ");
		 * }
		 */
		
		/** 
		 * Get the coins and print them 
		 */
		/*int idx = coinIndices.length - 1;
		while (idx > 0) {
			//System.out.println(idx + " : " + coinIndices[idx]);
			System.out.print(coins[coinIndices[idx]] + " ");
			idx = idx - coins[coinIndices[idx]]; 
		}
		
		System.out.println("\n");*/

		return T[T.length - 1];

	}

}
