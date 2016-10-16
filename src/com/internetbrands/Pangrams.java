package com.internetbrands;

import java.util.HashSet;
import java.util.Set;

public class Pangrams {

	public static String isPangram(String[] inputStrings) {

		String result = "";
		
		if (inputStrings.length == 0) {
			result = "No string entered. Please enter a string";
		}
		
		if (inputStrings.length >= 100) {
			result = "Total number of strings exceed 100";
		}

		Set charset = new HashSet();

		for (String str : inputStrings) {
			if (str.length() > 100000) {
				result = "Length of string exceeds the valid limit. Keep it shorter than 100000 characters";
			}
			for (char s : str.toCharArray()) {
				
				if (s != ' ') {
					if (s < 97 || s > 122) {
						result = "The input string "+str+
								" contains either special characters or numbers and hence is an invalid string";
						return result;
					}
					charset.add(s);
				}
			}

			if (charset.size() == 26) {
				result += 1;
			} else {
				result += 0;
			}			
			charset.removeAll(charset);
		}
		return result;
	}

	public static void main(String[] args) {

		String[] strArray = new String[] { 
				"the quick brown fox jumps over the lazy dog",
				"dfkdsfdskjgndfkjgb",
				"skf45ti54bf5f9b4kbff348bf34uif4o5fb45f"
			};
		System.out.println(isPangram(strArray));
	}

}
