package com.book.chap3;

public interface MyQueue<T> {
	
	public void add(T data);
	
	public T remove();
	
	public T peek();
	
	//No need for this method!
	public int size();
	
	public boolean isEmpty();
}