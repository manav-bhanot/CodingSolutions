/**
 * 
 */
package com.hackerrank.algorithm.dynamicprogramming.kmarsh;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Manav
 *
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner read = new Scanner(System.in);
		int m = read.nextInt();
		int n = read.nextInt();

		char[][] field = new char[m][n];
		for (int i = 0; i < m; i++) {
			String row = read.next();
			for (int j = 0; j < n; j++) {
				field[i][j] = row.charAt(j);
			}
		}

		/*for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(field[i][j]);
			}
			System.out.println();
		}*/

		int[] hist = new int[field[0].length];
		int maxPer = 0;

		for (int row = 0; row < m; row++) {
			for (int col = 0; col < n; col++) {
				if (field[row][col] == '.') {
					hist[col]++;
				} else {
					hist[col] = 0;
				}
			}

			// Calculate maximum perimeter histogram
			maxPer = Math.max(maxPer, maximumPerimeterRectangle(hist));
		}
		System.out.println(2*maxPer);
	}

	private static int maximumPerimeterRectangle(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		int max = 0;

		while (i < height.length) {
			// push index to stack when the current height is larger than the
			// previous one
			if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
				// calculate max textValue when the current height is less than the
				// previous one
				int p = stack.pop();
				int h = height[p];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max((h-1) + (w-1), max);
			}
		}

		while (!stack.isEmpty()) {
			int p = stack.pop();
			int h = height[p];
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			max = Math.max((h-1) + (w-1), max);
		}
		return max;
	}
}
