package com.book.chap3;

import com.book.exception.EmptyQueueException;

public class MyLinkedQueue<T> implements MyQueue<T> {
	
	private int size;

	private static class MyQueueNode<T> {
		T data;
		MyQueueNode<T> next;
		
		MyQueueNode(T data) {
			this.data = data;
		}
	}
	
	private MyQueueNode<T> first;
	private MyQueueNode<T> last;
	
	//add(item) remove() peek() isEmpty()
	
	@Override
	public void add(T data) {
		if(first == null) {
			first = new MyQueueNode<T>(data);
			last = first;
		} else if(first == last) {
			last = new MyQueueNode<T>(data);
			first.next = last;
		} else {
			MyQueueNode<T> node = last;
			last = new MyQueueNode<T>(data);
			node.next = last;
		}
		size++;
	}
	
	@Override
	public T remove() {
		T data;
		if(first == null)
			throw new EmptyQueueException();
		else if(first == last) {
			data = first.data;
			first = null;
			last = null;
			size=0;
		} else {
			data = first.data;
			first = first.next;
			size--;
		}
		return data;
	}
	
	@Override
	public T peek() {
		return first == null ? null : first.data;
	}
	
	@Override
	public boolean isEmpty() {
		return first == null;
	}

	@Override
	public int size() {
		return size;
	}

}
