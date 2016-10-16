/**
 * 
 */
package com.hackerrank.string;

import java.util.Scanner;

/**
 * @author Manav 
 * 		   Bob has received a binary string of length N transmitted by
 *         Alice. He knows that due to errors in transmission, up to K bits
 *         might have been corrupted (and hence flipped). However, he also knows
 *         that the string Alice had intended to transmit was not periodic. A
 *         string is not periodic if it cannot be represented as a smaller
 *         string concatenated some number of times. For example, "0001", "0110"
 *         are not periodic while "00000", "010101" are periodic strings.
 * 
 *         Now he wonders how many possible strings could Alice have
 *         transmitted.
 * 
 *         Input Format :: The first line contains the number of test cases T. T
 *         test cases follow. Each case contains two integers N and K on the
 *         first line, and a binary string of length N on the next line.
 * 
 *         Output Format :: Output T lines, one for each test case. Since the
 *         answers can be really big, output the numbers modulo 1000000007.
 * 
 *         Constraints
 *         1 <= T <= 20
 *         1 <= N <= 1000
 *         0 <= K <= N
 *         
 *         Sample Input
 * 
 *         3 
 *         5 0 
 *         00000 
 *         3 1 
 *         001 
 *         3 3 
 *         101 
 *         
 *         Sample Output * 
 *         0 
 *         3 
 *         6 
 *         
 *         Explanation: For the second example, Alice could have
 *         transmitted "001", or "011" or "101". For the third example, Alice
 *         could have transmitted 001, 010, 100, 011, 101, 110
 */
public class StringTransmission {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		StringTransmission stringTransmission =  new StringTransmission();
		
		Scanner reader = new Scanner(System.in);

		System.out.println("Enter the number of testcases : ");
		int numberOfTestCases = Integer.parseInt(reader.nextLine());
		
		int[] solutions = new int [numberOfTestCases];

		for (int i = 0; i < numberOfTestCases; i++) {
			System.out.println("Enter the length of the string, followed by a space "
					+ "and the number of bits that could have been modified :");
			
			String[] lengthAndBitsModified = reader.nextLine().split(" ");
			System.out.println(lengthAndBitsModified);
			int length = Integer.parseInt(lengthAndBitsModified[0].trim());
			int bitsModified = Integer.parseInt(lengthAndBitsModified[1].trim());
			
			System.out.println("Enter the string transmitted : ");
			String str = reader.nextLine();			
			
			solutions[i] = stringTransmission.bruteForce(length, bitsModified, str);			
		}

	}

	int bruteForce(int length, int bitsModified, String s) {
		
		
		
		return 0;

	}

}
