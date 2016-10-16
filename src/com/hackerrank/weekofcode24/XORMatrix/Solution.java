package com.hackerrank.weekofcode24.XORMatrix;

import java.util.Scanner;

/**
 * 
 * @author Manav
 *
 */
public class Solution {
	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int m = scan.nextInt();
		
		int[][] xorMatrix = new int[m][n];
		
		for (int i = 0; i < n; i++) {
			xorMatrix[0][i] = scan.nextInt();
			System.out.print(xorMatrix[0][i] + " ");
		}
		
		System.out.println();
		
		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n-1; j++) {
				xorMatrix[i][j] = xorMatrix[i-1][j] ^ xorMatrix[i-1][j+1];
				System.out.print(xorMatrix[i][j] + " ");
			}
			xorMatrix[i][n-1] = xorMatrix[i-1][n-1] ^ xorMatrix[i-1][0];
			System.out.print(xorMatrix[i][n-1] + " ");
			
			System.out.println();
		}
		
		
    }

}
