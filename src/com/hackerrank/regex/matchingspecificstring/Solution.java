/**
 * 
 */
package com.hackerrank.regex.matchingspecificstring;

/**
 * @author Manav
 *
 */
public class Solution {
	
	private static String specialCharsRegexStart = "^\\W*";
	private static String specialCharsRegexEnd = "\\W*$";
	
	public static String processWord(String next) {
		return next.replaceAll(specialCharsRegexStart, "").replaceAll(specialCharsRegexEnd, "").toLowerCase();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = processWord("#@%$#$%#$%manav@gmail.com3$$%#$%#$%");
		System.out.println(s);
	}

}
