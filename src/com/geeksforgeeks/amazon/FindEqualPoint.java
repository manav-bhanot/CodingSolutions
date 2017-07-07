/**
 * 
 */
package com.geeksforgeeks.amazon;

/**
 * @author Manav
 * 
 *         Given a string of brackets, the task is to find an index k which
 *         decides the number of opening brackets is equal to the number of
 *         closing brackets. String must be consists of only opening and closing
 *         brackets i.e. ‘(‘ and ‘)’.
 * 
 *         An equal point is an index such that the number of opening brackets
 *         before it is equal to the number of closing brackets from and after.
 * 
 *         Examples:
 * 
 *         Input : str = "(())))(" Output: 4 After index 4, string splits into
 *         (()) and ))(. Number of opening brackets in the first part is equal
 *         to number of closing brackets in the second part.
 * 
 *         Input : str = "))" Output: 2 As after 2nd position i.e. )) and
 *         "empty" string will be split into these two parts: So, in this number
 *         of opening brackets i.e. 0 in the first part is equal to number of
 *         closing brackets in the second part i.e. also 0.
 *
 */
public class FindEqualPoint {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindEqualPoint obj = new FindEqualPoint();
		System.out.println(obj.findEqualityPoint("(())))(")); // Ans = 4
		System.out.println(obj.findEqualityPoint("))")); // Ans = 2
		System.out.println(obj.findEqualityPoint("(()))(()()())))")); // Ans = 9
	}
	
	public int findEqualityPoint(String s) {
		
		int equalityIdx = 0;
		
		char[] s_c = s.toCharArray();
		
		int len = s_c.length;
		int[] countClosingBrackets = new int[len];
		int[] countOpeningBrackets = new int[len];
		
		for (int idx = 1; idx < s_c.length; idx++) {
			
			countOpeningBrackets[idx] = countOpeningBrackets[idx - 1];
			
			if (s_c[idx - 1] == '(') {
				countOpeningBrackets[idx]++;
			} 
			if (s_c[len - idx] == ')') {
				countClosingBrackets[len - idx]++;
			}
			
			countClosingBrackets[len - (idx + 1)] = countClosingBrackets[len - idx];
		}
		
		if (s_c[0] == ')') {
			countClosingBrackets[0]++;
		}
		
		// Check if all brackets are opening brackets or closing brackets
		if (countClosingBrackets[0] == len) {
			equalityIdx = len;
		} else if (countClosingBrackets[0] == 0) {
			equalityIdx = 0;
		} else {
			for (int idx = 0; idx < len; idx++) {
				if (countClosingBrackets[idx] == countOpeningBrackets[idx]) {
					equalityIdx = idx;
				}
			}
		}
		
		return equalityIdx;
	}
}
