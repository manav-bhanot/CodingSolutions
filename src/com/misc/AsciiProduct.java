/**
 * 
 */
package com.misc;

/**
 * @author Manav
 *
 */
public class AsciiProduct {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = new int[] {1,3,11,17};
		
		String s = "HELLO WORLD";
		
		System.out.println(findAsciiProductRecursively(s, arr, s.length()));
		
		// System.out.println(findAsciiProduct(s, arr));

	}

	private static long findAsciiProduct(String s, int[] arr) {
		
		long sum = 0;
		
		for (int i=0; i < s.length(); i++) {
			//System.out.println((int) s.charAt(i) + " x " + arr[i % 4]);
			sum += (s.charAt(i) * arr[i % 4]);
		}
		return sum;		
	}

	private static int findAsciiProductRecursively(String s, int[] arr, int len) {
		
		if (s == "" || s.length() == 0) {
			return 0;
		}
		int ch = (int)s.charAt(0);
		
		return ch * arr[(len - s.length()) % 4]	+ findAsciiProductRecursively(s.substring(1), arr, len);		
	}
}
