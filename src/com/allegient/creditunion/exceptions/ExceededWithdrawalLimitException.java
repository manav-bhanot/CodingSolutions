package com.allegient.creditunion.exceptions;

public class ExceededWithdrawalLimitException extends RuntimeException {
	
	public ExceededWithdrawalLimitException(String msg) {
		System.out.println(msg);
	}
}
