/**
 * 
 */
package com.crackingthecodinginterview.chapter8;

/**
 * @author Manav
 *
 */
public class StringPermutations {

	String str = "abc";

	public void showPermutations(String s) {
		showPermutations("", s);
	}

	private void showPermutations(String prefix, String s) {
		
		int strlen = s.length();
		
		if (strlen == 0) {
			System.out.println(prefix);
		}
		
		for (int i = 0; i < s.length(); i++) {
			// System.out.println("i = "+i+" :: prefix = "+prefix);
			showPermutations(prefix + s.charAt(i), s.substring(0,i) + s.substring(i + 1));
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringPermutations permutations = new StringPermutations();
		permutations.showPermutations(permutations.str);

	}

}
