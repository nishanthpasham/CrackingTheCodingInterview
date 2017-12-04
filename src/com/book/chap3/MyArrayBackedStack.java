package com.book.chap3;

import com.book.exception.EmptyStackException;

public class MyArrayBackedStack<T> implements MyStack<T> {
	
	private Object[] elementData;
	private static final int DEFAULT_INIT_CAPACITY = 10;
	private int size;
	
	@SuppressWarnings("unchecked")
	public MyArrayBackedStack(int initCapacity) {
		elementData = new Object[initCapacity];
	}
	
	public MyArrayBackedStack(MyArrayBackedStack<T> other) {
		this.elementData = other.elementData;
		this.size = other.size;
	}
	
	@SuppressWarnings("unchecked")
	public MyArrayBackedStack() {
		elementData = new Object[DEFAULT_INIT_CAPACITY];
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public synchronized T pop() {
		if(elementData[0] == null)
			throw new EmptyStackException();
		T element = (T) elementData[size-1];
		size--;
		return element;
	}

	@Override
	public synchronized void push(T data) {
		elementData[size] = data;
		size++;
	}

	@SuppressWarnings("unchecked")
	@Override
	public synchronized T peek() {
		if(elementData[0] == null)
			throw new EmptyStackException();
		return (T) elementData[size-1];
	}

	@Override
	public synchronized boolean isEmpty() {
		return size==0;
	}

}
