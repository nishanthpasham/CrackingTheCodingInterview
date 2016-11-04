package com.book.chap3;

public interface MyStack<T> {

	T pop();

	void push(T data);

	T peek();

	boolean isEmpty();

}