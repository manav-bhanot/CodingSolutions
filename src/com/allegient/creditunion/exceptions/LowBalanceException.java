package com.allegient.creditunion.exceptions;

public class LowBalanceException extends RuntimeException {
	
	public LowBalanceException(String msg) {
		System.out.println(msg);
	}

}
