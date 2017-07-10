/**
 * 
 */
package com.crackingthecodinginterview.chapter1;

/**
 * @author Manav
 *
 */
public class RotateMatrixByNinetyDegrees {
	
	private static int n = 5;
	
	public static void main(String[] args) {
		
		long [][] matrix = new long[n][n];
		long [][] resultMatrix = new long[n][n];
		
		int data = 1;
		
		// Initialize the matrix
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				matrix[i][j] = data;
				data++;
				//System.out.print("matrix["+i+"]["+j+"]"+matrix[i][j]);
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("\nNow printing the 90 degrees rotated matrix \n");
		
		// Rotate the matrix clockwise by 90 degrees
		int k = n;		
		for (int i=0; i<n; i++) {
			k--;
			for (int j=0; j<n; j++) {
				resultMatrix[j][k] = matrix[i][j];
			}
		}
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				//System.out.print("matrix["+i+"]["+j+"]"+matrix[i][j]);
				System.out.print(resultMatrix[i][j]+" ");
			}
			System.out.println();
		}
		
		
		
	}

}
