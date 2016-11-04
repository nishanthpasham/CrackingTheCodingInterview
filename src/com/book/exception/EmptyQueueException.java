package com.book.exception;

public class EmptyQueueException extends RuntimeException {
	private static final long serialVersionUID = 34798579487972L;
	
	public EmptyQueueException() {
	}
	
	public EmptyQueueException(String s) {
		super(s);
	}

}
