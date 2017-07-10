/**
 * 
 */
package com.crackingthecodinginterview.chapter8;

/**
 * @author Manav
 *
 */

public class StringSubset {

	String str = "ab";

	public void subset(String s) {
		subset("", s);
	}

	private void subset(String prefix, String s) {
		System.out.println(prefix);
		for (int i = 0; i < s.length(); i++) {
			//System.out.println("i = "+i+" :: prefix = "+prefix);
			subset(prefix + s.charAt(i), s.substring(i + 1));
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] a) {

		StringSubset obj = new StringSubset();
		obj.subset(obj.str);
	}
}
