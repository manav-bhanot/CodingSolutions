package com.hackerrank.algorithm.pre2post;

import java.util.Stack;

public class PrefixToPostfix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(preToPost("+1*23"));
	}
	//++a*BC
	public static String preToPost(String prefix) {
		Stack<String> s = new Stack();
		
		for(int index=prefix.length()-1;index>=0;index--) {
			if(isOperator(prefix.charAt(index))) {
				String a =s.pop();
				String b = s.pop();
				s.push(a+b+prefix.charAt(index));
			}else
				s.push(String.valueOf(prefix.charAt(index)));
		}
		//String.valueOf(5);
		return s.pop();
	}
	private static boolean isOperator(char charAt) {
		if(charAt == '+' ||charAt == '-' ||charAt == '/' ||charAt == '*' )
			return true;
		return false;
	}

	
}
