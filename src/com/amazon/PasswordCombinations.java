/**
 * 
 */
package com.amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Manav
 * 
 *         You are designing a New User sign-up form for a website. When a
 *         user enters text in the password field, you want to suggest possible
 *         'stronger' passwords to the user by swapping in special characters,
 *         like turning an "a" into an "@". Given a password represented as a
 *         string and a character map that contains common characters and
 *         substitutions, create a list of all possible password combinations
 *         that can be created.
 *         Example: Input: Map:
 *         {{'i','!'},{'a','@'},{'s','$'},{'o','0'},{'E','3'}} Password:
 *         password
 *
 * 
 */
public class PasswordCombinations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('i', '!');
		map.put('a', '@');
		map.put('s', '$');
		map.put('o', '0');
		map.put('E', '3');
		
		String s = "password";
		
		generatePasswordCombinations(s, "", map);

	}

	static void generatePasswordCombinations(String s, String perm, Map<Character, Character> map) {
		
		if (s.equals("")) {
			System.out.println(perm);
			return;
		}
		
		if (map.containsKey(s.charAt(0))) {
			generatePasswordCombinations(s.substring(1), perm + map.get(s.charAt(0)), map);
		} 
		generatePasswordCombinations(s.substring(1), perm + s.charAt(0), map);
	}

}
