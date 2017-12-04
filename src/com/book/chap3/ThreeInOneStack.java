package com.book.chap3;

import java.io.Serializable;

public class ThreeInOneStack<T> implements Serializable {
	private static final long serialVersionUID = -6664463767330872479L;
	private int stackCount = 3;
	private volatile T elementData[];
	private volatile int[] stackCapacity = new int[stackCount];
	private int sizeIncrement;
	private volatile int[] stackSize = new int[stackCount];
	private static final double capacityThreshold = 0.75;
	
	private static final Object[] EMPTY_ELEMENTDATA = {null, null, null, null, null, null, null, null, null}; // 9 elements
	
	@SuppressWarnings("unchecked")
	public ThreeInOneStack(int capacityPerStack, int sizeIncrement) {
		if(capacityPerStack == 0) {
			elementData = (T[]) EMPTY_ELEMENTDATA;
			for(int i=0; i<stackCount; i++)
				stackCapacity[i] = 3;
		}
		else {
			for(int i=0; i<stackCapacity.length; ++i)
				stackCapacity[i] = capacityPerStack;
			elementData = (T[]) new Object[stackCount*stackCapacity[0]];
		}
		this.sizeIncrement = sizeIncrement;
	}
	
	public ThreeInOneStack(int capacityPerStack) {
		this(capacityPerStack, 0);
	}
	
	public ThreeInOneStack() {
		this(0, 0);
	}
	
	// 0 is stack1 , 1 is stack2, etc
	public synchronized T pop(int stackNum) {
		checkStackNumIsValid(stackNum);
		int startOfStack = startOfStack(stackNum);
		int popPosition = startOfStack + stackSize[stackNum]-1;
		T element = elementData[popPosition];
		elementData[popPosition] = null;
		stackSize[stackNum] -= 1;
		return element;
	}

	public synchronized void push(T data, int stackNum) {
		checkStackNumIsValid(stackNum);
		if(isResizeNeeded(stackNum)) 
			resize(stackNum);
		int startOfStack = startOfStack(stackNum);
		int pushPosition = startOfStack + stackSize[stackNum];
		
		elementData[pushPosition] = data;
		stackSize[stackNum] += 1;
	}
	
	public synchronized T peek(int stackNum) {
		checkStackNumIsValid(stackNum);
		int startOfStack = startOfStack(stackNum);
		int peekPosition = startOfStack + stackSize[stackNum]-1;
		return elementData[peekPosition];
	}

	public synchronized boolean isEmpty(int stackNum) {
		checkStackNumIsValid(stackNum);
		return stackSize[stackNum]==0;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		int startOfStack = 0;
		for(int i=0; i<stackCount; i++) {
			sb.append("Stack ");
			sb.append(i);
			sb.append(": \n");
			startOfStack = startOfStack(i);
			for(int j=0; j<stackSize[i]; j++) {
				sb.append(elementData[startOfStack+j]);
				sb.append(", ");
			}
			sb.append(" \n");
		}
		return sb.toString();
	}
	
	public int getStackSize(int stackNum) {
		return stackSize[stackNum];
	}
	
	public synchronized int getStackCapacity(int stackNum) {
		return stackCapacity[stackNum];
	}
	
	private int startOfStack(int stackNum) {
		int startOfStack = 0;
		if(stackNum==1)
			startOfStack = stackCapacity[0];
		else if (stackNum==2)
			startOfStack = stackCapacity[0] + stackCapacity[1];
		return startOfStack;
	}
	
	@SuppressWarnings("unchecked")
	private synchronized void resize(int stackNum) {
		int currTotalCapacity = computeTotalCapacity();
		int increment = sizeIncrement!=0 ? sizeIncrement : stackCapacity[stackNum];
		T[] temp = (T[]) new Object[currTotalCapacity + increment];
		int newStartOfStack, oldStartOfStack = 0;
		for(int i=0; i<stackCount; i++) {
			oldStartOfStack = startOfStack(i);
			newStartOfStack = (stackNum<i) ? startOfStack(i)+increment : startOfStack(i);
			for(int j=0; j<stackSize[i]; j++) {
				temp[newStartOfStack+j] = elementData[oldStartOfStack+j];
			}
		}
		stackCapacity[stackNum] += increment;
		elementData = temp;
	}
	
	private synchronized boolean isResizeNeeded(int stackNum) {
		checkStackNumIsValid(stackNum);
		double ratio = (stackSize[stackNum]+1)/stackCapacity[stackNum];
		return ratio>capacityThreshold;
	}
	
	private synchronized int computeTotalCapacity() {
		int totalCapacity = 0;
		for(int i=0; i<stackCapacity.length; i++)
			totalCapacity += stackCapacity[i];
		return totalCapacity;
	}
	
	private void checkStackNumIsValid(int stackNum) {
		if(stackNum<0 || stackNum>stackCount-1) new RuntimeException("stackNum is out of bounds: " + stackNum); 
	}
}
