package com.book.exception;

public class SizeOverCapacityException extends RuntimeException {

	private static final long serialVersionUID = 7394121116030247011L;

	public SizeOverCapacityException() {
	}
	
	public SizeOverCapacityException(String s) {
		super(s);
	}
}
