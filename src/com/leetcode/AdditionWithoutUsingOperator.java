package com.leetcode;

public class AdditionWithoutUsingOperator {

	public int getSum(int a, int b) {
		
		int carry = a & b;
		
		while (true) {
			carry = carry << 1; // left shift carry by one bit
			if (carry == 0) {
				break;
			}
			a = a^b; // result of a XOR b is stored in a
			b = carry;			
			carry = a & b;
		}
		
		return a ^ b;

	}

}
