/**
 * Excercise 1.3
 * Design an algorithm and write code to remove the duplicate characters in a string without using any 
 * additional buffer. NOTE: One or two additional variables are fine. An extra copy of the array is not. 
 * FOLLOW UP.
 * Write the test cases for this method.
 */

package com.crackingthecodinginterview.chapter1;

public class RemoveDuplicateCharsFromString {
	
	public static void main(String[] args) {
		
		String str = "mississippi";
		
		for (int i=0; i < str.length(); i++) {
			for (int j=i+1; j<str.length(); j++) {
				
				if (str.charAt(i) == str.charAt(j)){
					
					System.out.println("i = "+i+" :: j = "+j);
					str = str.substring(0, j) + str.substring(j+1, str.length());
					System.out.println(str);
					j--;
				}				
			}
		}
		
		System.out.println("Result is : "+str);
		
	}
	
	
	
}
