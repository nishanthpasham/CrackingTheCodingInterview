package com.book.exception;

public class EmptyStackException extends RuntimeException {
	private static final long serialVersionUID = -5859786386297L;

	public EmptyStackException() {
	}
	
	public EmptyStackException(String s) {
		super(s);
	}
}
