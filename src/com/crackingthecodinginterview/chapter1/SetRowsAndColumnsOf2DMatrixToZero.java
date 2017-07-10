/**
 * 
 */
package com.crackingthecodinginterview.chapter1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Manav
 *
 */
public class SetRowsAndColumnsOf2DMatrixToZero {

	private static int m = 6;
	private static int n = 5;

	public static void printMatrix(long[][] mat) {
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		long[][] matrix = new long[m][n];
		long[][] resultMatrix = new long[m][n];

		HashMap<Integer, List<Integer>> recordZeroValuesRowsAndCols = new HashMap<Integer, List<Integer>>();
		List<Integer> columnsList = new ArrayList<Integer>();

		int data = 1;

		// Initialize the matrix
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = (i + j) % 7 == 0 ? 0 : data++;				
			}
		}
		
		printMatrix(matrix);
		System.out.println();

		/*
		 * Track the row and column indices which have zero values
		 */
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					columnsList.add(j);
					recordZeroValuesRowsAndCols.put(i, columnsList);
				}
			}
		}

		/**
		 * Set the corresponding rows and columns to zero
		 */
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {

				if (recordZeroValuesRowsAndCols.containsKey(row)) {
					matrix[row][col] = 0;
					continue;
				}
			}
		}
		
		printMatrix(matrix);
	}

}
