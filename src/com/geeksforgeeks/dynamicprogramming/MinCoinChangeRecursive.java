/**
 * 
 */
package com.geeksforgeeks.dynamicprogramming;

/**
 * @author Manav
 *
 */
public class MinCoinChangeRecursive {

	private int sum = 11;
	private int[] coins = { 1, 5, 3 };
	int minCoins = Integer.MAX_VALUE;
	
	// Can be used for memoization but I am not using it right now
	private int[] result = new int[sum + 1];

	private int findMinCoins(int remainingAmount) {

		// System.out.println(remainingAmount);

		// base case
		if (remainingAmount == 0)
			return 0;

		// Initialize result
		int minCoins = Integer.MAX_VALUE;

		// Try every coin that has smaller textValue than 
		for (int i=0; i < coins.length; i++) {
			if (coins[i] <= remainingAmount) {
				int numCoins = findMinCoins(remainingAmount - coins[i]);

				// If you dont check numCoins for Integer.MAX_VALUE then it will add 1 to it and make it a negative number
				if (numCoins != Integer.MAX_VALUE && numCoins + 1 < minCoins) {
					minCoins = numCoins + 1;
				}
			}
		}
		return minCoins;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MinCoinChangeRecursive obj = new MinCoinChangeRecursive();
		
		// Initialize the result array with MAX textValue
		for (int i=0; i < obj.result.length; i++) {
			obj.result[i] = Integer.MAX_VALUE;
		}
		
		System.out.println(obj.findMinCoins(obj.sum));

	}

}
