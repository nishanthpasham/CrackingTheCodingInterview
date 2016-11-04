package com.book.chap3;

import java.io.Serializable;

/**
 * 
 * @author Nishanth Pasham
 * 
 * All operations will be O(1)
 * Negative: Was unable to use MyStack Interface! This is a stand-alone class!
 *
 */
public class MyMinLinkedStack implements Serializable  {
	private static final long serialVersionUID = 1524771903967723513L;

	private static class MyMinLinkedStackNode {
		private Integer data;
		private MyMinLinkedStackNode prev;
		private Integer min;
		
		public MyMinLinkedStackNode(Integer data, MyMinLinkedStackNode prev) {
			this.data = data;
			this.prev = prev;
			this.min = (prev==null) || (data.compareTo(prev.min) < 0) ? data : prev.min;
		}
	}
	
	private MyMinLinkedStackNode top;

	public Integer pop() {
		if (top==null)
			return null;
		Integer element = top.data;
		top = top.prev;
		return element;
	}

	public void push(Integer data) {
		MyMinLinkedStackNode node = new MyMinLinkedStackNode(data, top);
		top = node;
	}

	public Integer peek() {
		return top==null ? null : top.data;
	}

	public boolean isEmpty() {
		return top==null;
	}
	
	public Integer min() {
		return top==null ? null : top.min;
	}

}
