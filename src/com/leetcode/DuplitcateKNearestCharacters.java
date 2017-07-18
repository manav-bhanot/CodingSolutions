/**
 * 
 */
package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Manav
 * 
 *         Write a function that determines whether a String contains
 *         duplicate characters within k indices of each other.
 *
 */
public class DuplitcateKNearestCharacters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String s = "123145";
		
		System.out.println(isKNearDuplicate(s, 3));
	}
	
	public static boolean isKNearDuplicate(String s, int k) {
		
		if (k <= 1) {
			return true;
		}
		
		int left = 0, right = 0;
		Set<Character> seen = new HashSet<Character>();
		
		char[] cArr = s.toCharArray();
		int len = cArr.length;
		
		while (right < len) {
			
			if (seen.contains(cArr[right])) {
				System.out.println(cArr[right] + " is duplicate");
				return true;
			}
			
			if (right >= k) {
				seen.remove(cArr[left]);
				left++;
			}
			seen.add(cArr[right]);
			right++;
			
			for (char str : seen) {
				System.out.print(str + " ");
			}
			System.out.println();
		}
		
		return false;
	}

}
