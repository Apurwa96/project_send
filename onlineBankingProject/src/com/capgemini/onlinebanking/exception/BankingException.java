package com.capgemini.onlinebanking.exception;


public class BankingException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public BankingException(String message) {
		super(message);
	}

}
