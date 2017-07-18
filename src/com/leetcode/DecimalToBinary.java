/**
 * 
 */
package com.leetcode;

/**
 * @author Manav
 *
 */
public class DecimalToBinary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(decimalToBinary(10));

	}
	
	public static String decimalToBinary(int n) {
		StringBuilder binary = new StringBuilder();
		
		while (n != 0) {
			if ( (n & 1) == 1) {
				binary.append("1");
			} else {
				binary.append("0");
			}
			
			n = n >> 1;
		}
		
		return binary.reverse().toString();
	}

}
