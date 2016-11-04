package com.book.chap3;

public class StackUtils {
	
	@SuppressWarnings("unchecked")
	public MyStack<Integer> sortStack(MyStack<Integer> stack) {
		MyStack<Integer> tempStack = null;
		try {
			tempStack = stack.getClass().newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		Integer top, tempTop;
		int len = 0;
		while(!stack.isEmpty()) {
			top = stack.pop();
			if(tempStack.isEmpty() || top < tempStack.peek()) {
				tempStack.push(top);
			} else if(top >= tempStack.peek()) {
				len = 0;
				tempTop = tempStack.peek();
				while(top >= tempTop) {
					stack.push(tempStack.pop());
					len++;
					tempTop = tempStack.peek();
				}
				tempStack.push(top);
				while(len>0) {
					tempStack.push(stack.pop());
					len--;
				}
			}
		}
		return tempStack;
	}

}
