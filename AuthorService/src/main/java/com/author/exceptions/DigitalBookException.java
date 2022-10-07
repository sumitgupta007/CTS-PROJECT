package com.author.exceptions;

public class DigitalBookException extends Exception {

	public DigitalBookException() {
		super();
	}

	public DigitalBookException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DigitalBookException(String message, Throwable cause) {
		super(message, cause);
	}

	public DigitalBookException(String message) {
		super(message);
	}

	public DigitalBookException(Throwable cause) {
		super(cause);
	}

}
