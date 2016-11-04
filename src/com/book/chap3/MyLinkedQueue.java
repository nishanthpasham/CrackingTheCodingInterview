package com.book.chap3;

import java.io.Serializable;

import com.book.exception.EmptyQueueException;

public class MyLinkedQueue<T> implements MyQueue<T>, Serializable {
	private static final long serialVersionUID = 16464285247L;

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
	}
	
	public T remove() {
		T data;
		if(first == null)
			throw new EmptyQueueException();
		else if(first == last) {
			data = first.data;
			first = null;
			last = null;
		} else {
			data = first.data;
			first = first.next;
		}
		return data;
	}
	
	public T peek() {
		return first == null ? null : first.data;
	}
	
	public boolean isEmpty() {
		return first == null;
	}

}
