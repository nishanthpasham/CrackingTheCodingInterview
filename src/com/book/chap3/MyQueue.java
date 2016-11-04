package com.book.chap3;

public interface MyQueue<T> {
	
	public void add(T data);
	
	public T remove();
	
	public T peek();
	
	public boolean isEmpty();
}