package com.book.chap3;
/**
 * 
 * @author Nishanth Pasham
 * 
 * Operations add and remove are O(n)
 *
 * @param <T>
 */
public class MyStackBackedQueue<T> implements MyQueue<T> {
	
	private volatile MyArrayBackedStack<T> stack = new MyArrayBackedStack<>();
	private volatile MyArrayBackedStack<T> reverseStack = new MyArrayBackedStack<>();
	
	@Override
	public synchronized void add(T data) {
		stack.push(data);
		reverseStack = flipStack(stack);
	}

	@Override
	public synchronized T remove() {
		T element = reverseStack.pop();
		stack = flipStack(reverseStack);
		return element;
	}

	@Override
	public synchronized T peek() {
		return reverseStack.peek();
	}

	@Override
	public synchronized boolean isEmpty() {
		return stack.isEmpty();
	}
	
	//Does the private method needs to be synchronized ??
	private MyArrayBackedStack<T> flipStack(final MyArrayBackedStack<T> stack) {
		MyArrayBackedStack<T> flippedStack = new MyArrayBackedStack<T>();
		MyArrayBackedStack<T> clonedStack =  new MyArrayBackedStack<T>(stack);
		while(!clonedStack.isEmpty()) {
			flippedStack.push(clonedStack.pop());
		}
		return flippedStack;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
