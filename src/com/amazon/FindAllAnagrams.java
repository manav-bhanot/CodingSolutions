/**
 * 
 */
package com.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Manav
 * 
 *         Q: An anagram is a word that is formed by rearranging the letters of
 *         the word so as to produce a new word which uses all the original
 *         letters exactly once.
 * 
 *         You are given 2 strings - word1 and word2, containing ASCII
 *         characters Write an algorithm to output a list of 0-based indices of
 *         the occurences of all anagrams of word2 in word1
 * 
 *         Example : Input: word1 = bbbababaaabbbb word2 = ab
 * 
 *         Output: [2,3,4,5,6,9]
 * 
 *         NOTE : All character comparisons should be case sensitive
 *
 */
public class FindAllAnagrams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String word1 = "bbbababaaabbbb";
		String word2 = "ab";

		for (Integer i : findAnagrams(word1, word2)) {
			System.out.print(" " + i);
		}

	}
	
	/**
	 * s => bigger string
	 * 
	 * 
	 * @param s
	 * @param p
	 * @return
	 */
	public static List<Integer> findAnagrams(String s, String p) {
		
		List<Integer> list = new ArrayList<Integer>();
		
		if (s == null || s.length() == 0 || p == null || p.length() == 0)
			return list;

		// Stores the total count of each character occurring in word2 i.e p
		int[] p_chars = new int[256]; 
		
		for (char c : p.toCharArray()) {
			p_chars[c]++;
		}		
		
		// two points, initialize len to p's length
		int left = 0, right = 0, len = p.length();

		while (right < s.length()) {
			
			// move right everytime, if the character exists in p's hash, decrease the count
			// current hash value >= 1 means the character is existing in p
			if (p_chars[s.charAt(right)] >= 1) {
				len--;
			}
			
			p_chars[s.charAt(right)]--;
			right++;

			// when the count is down to 0, means we found the right anagram
			// then add window's left to result list
			if (len == 0) {
				list.add(left);
			}
			
			
			// if we find the window's size equals to p, then we have to move left (narrow
			// the window) to find the new match window
			// ++ to reset the hash because we kicked out the left
			// only increase the count if the character is in p
			// the count >= 0 indicate it was original in the hash, cuz it won't go below 0
			if (right - left == p.length()) {

				if (p_chars[s.charAt(left)] >= 0) {
					len++;
				}
				
				p_chars[s.charAt(left)]++;
				left++;
			}

		}
		return list;
	}

}
