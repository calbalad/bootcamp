package com.christian;

public class JuegoException extends Exception {
	public JuegoException() {
		super();
	}

	public JuegoException(String message) {
		super(message);
	}

	public JuegoException(String message, Throwable cause) {
		super(message, cause);
	}

	public JuegoException(Throwable cause) {
		super(cause);
	}
}
