/**
 * 
 */
package com.misc;

/**
 * @author Manav
 * 
 * Basic Implementation of KMP algorithm
 * 
 * Given a string str and a pattern p. 
 * Return true if you are able to find the occurrence of this pattern in String str
 */
public class KMP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String str = "ABCABCDABABCDABCDABDE";
		String pattern = "ABCDABD";
		
		System.out.println("Does String contains the given pattern ? " + findPatternInString(str, pattern));
	}

	private static boolean findPatternInString(String s, String p) {
		
		int[] lps = new int[p.length()];
		
		populateLps(lps, p);
		
		int i=0, j=0;
		
		while (i < s.length()) {
			
			if (j == p.length()){
				return true;
			}
			
			if (s.charAt(i) == p.charAt(j)) {
				i++;
				j++;
			} else {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i++;
				}				
			}			 		
		}
		return false;		
	}

	private static void populateLps(int[] lps, String p) {
		
		lps[0] = 0;
		
		int i = 1, len = 0;
		
		while (i < lps.length) {
			
			if (p.charAt(i) == p.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if (len > 0) {
					len = lps[len - 1];
				} else {
					lps[i] = len;
					i++;
				}
			}
		}
		
		// Print lps array
		for (int n : lps) {
			System.out.print(" " + n);
		}
		System.out.println();
	}
}
