package com.allegient.creditunion.exceptions;

public class CustomerAccountDoesNotExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerAccountDoesNotExistException(String msg) {
		System.out.println(msg);
	}
}
