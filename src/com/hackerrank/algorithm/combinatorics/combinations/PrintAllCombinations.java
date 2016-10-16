/**
 * 
 */
package com.hackerrank.algorithm.combinatorics.combinations;

import java.math.BigInteger;

/**
 * @author Manav
 *
 */
public class PrintAllCombinations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		StringBuilder str = new StringBuilder("abc");
		//combinations(new StringBuilder(""),str);
		//combinations("",str.toString());
		subset("",str.toString());
	}
	
	private static void subset(String prefix, String s) {
		/*if (prefix.length() == 2) {
			System.out.println(prefix);
		}*/
		
		System.out.println(prefix);
		
		for (int i = 0; i < s.length(); i++) {
			//System.out.println("i = "+i+" :: prefix = "+prefix);
			subset(prefix + s.charAt(i), s.substring(i + 1));
		}
	}
	
	/*static void combinations(StringBuilder out, StringBuilder in) {
		System.out.println(out);
		for (int i=0; i<in.length(); i++) {
			StringBuilder s1 = new StringBuilder(out.append(in.charAt(i)));
			StringBuilder s2 = new StringBuilder(in.substring(i+1));
			combinations(s1, s2);
		}
	}
	
	static void combinations(String out, String in) {
		System.out.println(out);
		
		for (int i=0; i<in.length(); i++) {
			out = out + in.charAt(i);			
			combinations(out, in.substring(i+1));
		}
	}*/
}
