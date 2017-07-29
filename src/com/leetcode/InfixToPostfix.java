/**
 * 
 */
package com.leetcode;

import java.util.Stack;

/**
 * @author Manav
 * 
 *         Given an infix expression, convert it to the corresponding postfix
 *         expression
 * 
 *         Algorithm :
 * 
 *         1. Create an empty stack called opstack for keeping operators. Create an
 *         empty list for output.
 *         Convert the input infix string to a list by using the string method
 *         split.
 *         2. Scan the token list from left to right.
 *         		a) If the token is an operand, append it to the end of the output list.
 *         		b) If the token is a left parenthesis, push it on the opstack.
 *         		c) If the token is a right parenthesis, pop the opstack until the 
 *         		   corresponding left parenthesis is removed. Append each operator to
 *         		   the end of the output list.
 *         		d) If the token is an operator, *, /, +, or -, push it on the opstack.
 *         			However, first remove any operators already on the opstack that have
 *         			higher or equal precedence and append them to the output list.
 *         3) When the input expression has been completely processed, check the
 *         opstack. Any operators still on the stack can be removed and appended
 *         to the end of the output list.
 *
 */
public class InfixToPostfix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String infixExp = "A+B*C";
		String postfixExp = getPostfoxExp(infixExp);
		System.out.println(infixExp + " --> " + postfixExp);

		infixExp = "(A+B)*C";
		postfixExp = getPostfoxExp(infixExp);
		System.out.println(infixExp + " --> " + postfixExp);

		infixExp = "A+B*C+D";
		postfixExp = getPostfoxExp(infixExp);
		System.out.println(infixExp + " --> " + postfixExp);

		infixExp = "(A+B)*(C+D)";
		postfixExp = getPostfoxExp(infixExp);
		System.out.println(infixExp + " --> " + postfixExp);

		infixExp = "A*B+C*D";
		postfixExp = getPostfoxExp(infixExp);
		System.out.println(infixExp + " --> " + postfixExp);

		infixExp = "A+B+C+D";
		postfixExp = getPostfoxExp(infixExp);
		System.out.println(infixExp + " --> " + postfixExp);

		infixExp = "(A+B)*C-(D-E)*(F+G)";
		postfixExp = getPostfoxExp(infixExp);
		System.out.println(infixExp + " --> " + postfixExp);

	}

	private static String getPostfoxExp(String infixExp) {

		char[] cArr = infixExp.toCharArray();
		Stack<String> opStack = new Stack<String>();

		StringBuilder postfixExp = new StringBuilder();

		for (Character c : cArr) {

			switch (c) {
			case '(':
				opStack.push(String.valueOf(c));
				break;

			case ')':

				do {
					postfixExp.append(opStack.pop());
				} while (!opStack.isEmpty() && !opStack.peek().equals("("));

				// Popping out the open parenthesis
				opStack.pop();
				break;

			case '/':
				while (!opStack.isEmpty() && (opStack.peek().equals("/") || opStack.peek().equals("*"))) {
					postfixExp.append(opStack.pop());
				}
				opStack.push(String.valueOf(c));
				break;

			case '*':
				while (!opStack.isEmpty() && (opStack.peek().equals("/") || opStack.peek().equals("*"))) {
					postfixExp.append(opStack.pop());
				}
				opStack.push(String.valueOf(c));
				break;

			case '+':
				while (!opStack.isEmpty() && (opStack.peek().equals("/") || opStack.peek().equals("*")
						|| opStack.peek().equals("+") || opStack.peek().equals("-"))) {
					postfixExp.append(opStack.pop());
				}
				opStack.push(String.valueOf(c));
				break;

			case '-':
				while (!opStack.isEmpty() && (opStack.peek().equals("/") || opStack.peek().equals("*")
						|| opStack.peek().equals("+") || opStack.peek().equals("-"))) {
					postfixExp.append(opStack.pop());
				}
				opStack.push(String.valueOf(c));
				break;

			default:
				postfixExp.append(String.valueOf(c));
			}
		}

		while (!opStack.isEmpty()) {
			postfixExp.append(opStack.pop());
		}

		return postfixExp.toString();
	}

}
