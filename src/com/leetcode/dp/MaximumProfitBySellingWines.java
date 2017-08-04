/**
 * 
 */
package com.leetcode.dp;

/**
 * @author Manav
 * 
 *         "Imagine you have a collection of N wines placed next to each other
 *         on a shelf. For simplicity, let's number the wines from left to right
 *         as they are standing on the shelf with integers from 1 to N,
 *         respectively. The price of the ith wine is pi. (prices of different
 *         wines can be different).
 * 
 *         Because the wines get better every year, supposing today is the year
 *         1, on year y the price of the ith wine will be y*pi, i.e. y-times the
 *         value that current year.
 * 
 *         You want to sell all the wines you have, but you want to sell exactly
 *         one wine per year, starting on this year. One more constraint - on
 *         each year you are allowed to sell only either the leftmost or the
 *         rightmost wine on the shelf and you are not allowed to reorder the
 *         wines on the shelf (i.e. they must stay in the same order as they are
 *         in the beginning).
 * 
 *         You want to find out, what is the maximum profit you can get, if you
 *         sell the wines in optimal order?"
 *
 */
public class MaximumProfitBySellingWines {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] prices = new int[] {2,3,5,1,4};
		int year = 1;
				
		System.out.println("Max Profit = " + findProfit(prices, year));
	}

	private static int findProfit(int[] prices, int year) {
		
		if (year > prices.length) {
			return 0;
		}
		
		/*
		return Math.max(findMaxProfit(prices,  year + 1, leftProfit), 
				findMaxProfit(prices,  year + 1, rightProfit));*/
		
		
		return Integer.max(((year * prices[year - 1]) + findProfit(prices,  year + 1)), 
				((year * prices[prices.length - year]) + findProfit(prices,  year + 1)));
	}

}
