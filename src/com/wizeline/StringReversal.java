/**
 * 
 */
package com.wizeline;

import java.util.Stack;

/**
 * @author Manav
 * 
 * Write a method that for a given input string, reverse all the characters inside parentheses. Consider nested parentheses.
 * "(bar)"           => "rab"
 * "foo(bar)baz"     => "foorabbaz"
 * "foo(bar(baz))"   => "foo(barzab)" => "foobazrab"
 * "foo(bar(baz)uy(xz))"   => "foo(barzabuyzx)" => "fooxzyubazrab"
 */
public class StringReversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println(reverseParenthesizedString("foo(bar(baz)uy(xz))man(avbha(not))"));
		System.out.println(reverseParenthesizedString("foo(bar(baz))"));
		System.out.println(reverseParenthesizedString("foo(bar)baz"));
		System.out.println(reverseParenthesizedString("foo(bar(baz)uy(xz))"));
	}
	
	static String reverseParenthesizedString(String str) {
		
		Stack<Integer> st = new Stack<Integer>();
		
		int len = str.length();
		int index = 0;
		
		// String result = "";
		
		while (index < len) {
			
			// Keep moving forward till we encounter the first ( or )
			while( index < len && !( str.charAt(index) == '(' || str.charAt(index) == ')')) {
				index++;
			}
			
			if (index >= len) {
				break;
			}
			
			// If we find a ( then put the index of the first char after that on a stack
			// else if it is a ) then pop the top index from the stack and reverse the string between
			// the index popped from the stack and the current index
			// Once you reverse the string, append it back to the original string at the original location.
			// Take care of the index and the length.
			
			if (str.charAt(index) == '(') {
				index++;
				st.push(index);
			} else if (!st.isEmpty()){
				
				// begin was the index of the char after the (
				int begin = st.pop();
				
				// index -> stores the index of the corresponding )
				str = str.substring(0, begin - 1) + reverse(str.substring(begin, index)) + str.substring(index + 1);
				len = str.length();
				
				// Because we are modifying the original string and deleting a ")" from the end
				// so decrease the index by 2 as the string will be shifted by 2 char towards left.
				index -= 2;
			}
		}
		
		return str;
		
	}
	
	static String reverse(String s) {
		return (new StringBuilder(s).reverse()).toString();
	}

}
