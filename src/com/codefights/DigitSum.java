package com.codefights;

public class DigitSum {
	
	public static void main(String... a) {
		System.out.println(digitSum(345));
	}

	static int digitSum(int n) {
		int sum = 0;
		while (n > 0) {
            sum = sum + n % 10;
            n = n / 10;
        }

		return sum;

	}

}
