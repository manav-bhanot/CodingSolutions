/**
 * 
 */
package com.amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * @author Manav
 * 
 *         Most popular text editors include a feature to detect unbalanced
 *         brackets. A pair of brackets is balanced if each opening bracket is
 *         accompanied by a closing bracket. Furthermore, the order is
 *         important. An enclosed bracket is only considered balance if it's
 *         corresponding open or closed bracket is enclosed by the same set of
 *         balanced bracket pairs.
 * 
 *         For a given string consisting of sequence of characters, write an
 *         algorithm to check whether the brackets in the string are balanced or
 *         not. If the brackets in the string are balanced, the output is 1
 *         otherwise the output is 0.
 * 
 *         Input to the function is a string - str -> representing the sequence
 *         of brackets
 * 
 *         Output 1 if the brackets are balanced and 0 if they are not.
 * 
 *         Constraint : str consists of only '(', ')', '{', '}', '[', ']', '<',
 *         '>' only
 * 
 *         Input : str = (h[e{l<l>o}!]~)000( Output : 0
 * 
 *         Input : str = [](){}<> Output : 1
 *
 */
public class ValidateOpenAndCloseBraces {

	public static void main(String[] args) {
		ValidateOpenAndCloseBraces obj = new ValidateOpenAndCloseBraces();

		System.out.println(obj.validateBraces("(h[e{l<l>o}!]~)000("));
		System.out.println(obj.validateBraces("[](){}<>"));
	}

	private int validateBraces(String str) {
		
		Set<Character> closingBrackets = new HashSet<Character>();
		closingBrackets.add(')');
		closingBrackets.add('}');
		closingBrackets.add(']');
		closingBrackets.add('>');

		Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        map.put('<','>');

		Stack<Integer> stack = new Stack<Integer>();
		
		char[] str_chars = str.toCharArray();
		
		for (int i=0; i < str_chars.length; i++) {
			if (map.containsKey(str_chars[i])) {
				stack.push(i);
			} else if (closingBrackets.contains(str_chars[i]) && !(stack.isEmpty())) {
				if (map.get(str_chars[stack.pop()]) != str_chars[i]) {
					return 0;
				}
			}
		}
		
		if (stack.isEmpty()) return 1;
		else return 0;
	}

}
