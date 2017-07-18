/**
 * 
 */
package com.leetcode;

/**
 * @author Manav
 *
 */
public class BinaryToDecimal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(binaryToDecimal("1101"));
	}
	
	public static int binaryToDecimal(String n) {
		
		char[] cArr = n.toCharArray();
		int d = 0;
		
		for (int i = n.length() - 1; i >= 0; i--) {
			d = (int) (cArr[i] == '1' ? d + Math.pow(2, n.length() - 1 - i) : d);
		}
		
		return d;
		
	}

}
