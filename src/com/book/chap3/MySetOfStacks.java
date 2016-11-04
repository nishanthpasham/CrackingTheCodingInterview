package com.book.chap3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.book.exception.EmptyStackException;

/**
 * 
 * @author Nishanth Pasham
 *
 * @param <T>
 * 
 * Need to test these classes in a multi-threaded environment.
 */
public class MySetOfStacks<T> implements MyStack<T>, Serializable {
	private static final long serialVersionUID = 5101267429218561916L;
	List<MyLinkedStack<T>> setOfStacks;
	List<Integer> stackSizes;
	
	private static final int capacity = 2;
	
	public MySetOfStacks() {
		setOfStacks = new ArrayList<MyLinkedStack<T>>();
		stackSizes = new ArrayList<Integer>();
	}

	@Override
	public synchronized T pop() {
		if(setOfStacks.isEmpty())
			throw new EmptyStackException();
		int lastStackIndex = setOfStacks.size()-1;
		T element = setOfStacks.get(lastStackIndex).pop();
		Integer size = stackSizes.get(lastStackIndex);
		size -= 1;
		stackSizes.set(lastStackIndex, size);
		if(size==0) {
			setOfStacks.remove(lastStackIndex);
			stackSizes.remove(lastStackIndex);
		}
		return element;
	}

	@Override
	public synchronized void push(T data) {
		int lastStackIndex = setOfStacks.size()-1;
		MyLinkedStack<T> stack;
		if(lastStackIndex==-1 || stackSizes.get(lastStackIndex) == capacity) {
			stack = new MyLinkedStack<>();
			stack.push(data);
			setOfStacks.add(stack);
			stackSizes.add(new Integer(1));
		} else {
			setOfStacks.get(lastStackIndex).push(data);
			Integer size = stackSizes.get(lastStackIndex);
			size += 1;
			stackSizes.set(lastStackIndex, size);
		}
	}

	@Override
	public synchronized T peek() {
		int lastStackIndex = setOfStacks.size()-1;
		if(setOfStacks.isEmpty())
			throw new EmptyStackException();
		return setOfStacks.get(lastStackIndex).peek();
	}

	@Override
	public synchronized boolean isEmpty() {
		return setOfStacks.size()==0 || setOfStacks.get(0).isEmpty();
	}
	
	public synchronized T popAt(int index) {
		if(index >= setOfStacks.size())
			throw new IndexOutOfBoundsException();
		MyLinkedStack<T> mlss = setOfStacks.get(index);
		Integer size = stackSizes.get(index);
		size = size>0 ? size-1: 0;
		stackSizes.set(index, size);
		if(size==0) {
			setOfStacks.remove(index);
			stackSizes.remove(index);
		}
		return mlss==null ? null : mlss.pop();
	}

}
