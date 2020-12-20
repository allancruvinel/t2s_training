package com.t2s.exceptions;

public class InvalidParameterException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidParameterException(String msg) {
		super(msg);
	}
}
