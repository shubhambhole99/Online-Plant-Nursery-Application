package com.exception;

public class UserSessionException extends RuntimeException {
	public UserSessionException() {
		super();
		
	}

	public UserSessionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public UserSessionException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public UserSessionException(String message) {
		super(message);
		
	}

	public UserSessionException(Throwable cause) {
		super(cause);
		
	}
}
