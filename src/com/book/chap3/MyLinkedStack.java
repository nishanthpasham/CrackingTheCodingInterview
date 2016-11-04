package com.book.chap3;

import java.io.Serializable;

import com.book.exception.EmptyStackException;

public class MyLinkedStack<T> implements MyStack<T>, Serializable {
	private static final long serialVersionUID = 6393808593340044106L;

	private static class MyStackNode<T> {
		private T data;
		private MyStackNode<T> next;
		
		MyStackNode(T data) {
			this.data = data;
		}
	}
	
	private MyStackNode<T> top;
	
	/* (non-Javadoc)
	 * @see com.book.chap3.MyStack#pop()
	 */
	@Override
	public synchronized T pop() {
		if(top == null)
			throw new EmptyStackException();
		T data = top.data;
		top = top.next;
		return data;
	}
	
	/* (non-Javadoc)
	 * @see com.book.chap3.MyStack#push(T)
	 */
	@Override
	public synchronized void push(T data) {
		if(top == null) {
			top = new MyStackNode<T>(data);
		} else {
			MyStackNode<T> node = new MyStackNode<T>(data);
			node.next = top;
			top = node;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.book.chap3.MyStack#peek()
	 */
	@Override
	public synchronized T peek() {
		if(top == null)
			throw new EmptyStackException();
		return top.data;
	}
	
	/* (non-Javadoc)
	 * @see com.book.chap3.MyStack#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return (top==null);
	}
	
}
