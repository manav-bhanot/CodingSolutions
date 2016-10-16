/**
 * 
 */
package com.leetcode.reversestring;

import java.util.Arrays;

/**
 * @author Manav
 *
 */
public class Solution {

	public String reverseString(String s) {
		char[] sArray = s.toCharArray();
		
		for (int i = 0; i < Math.ceil(sArray.length / 2); i++) {
			char temp = sArray[i];
			sArray[i] = sArray[sArray.length-1-i];
			sArray[sArray.length-1-i] = temp;
		}
		
		return new String(sArray);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}

}
