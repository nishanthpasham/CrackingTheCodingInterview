package com.book.chap3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StackUtilsTest {
	
	StackUtils stackUtils;
	MyStack<Integer> stack;
	
	@Before
	public void setUp() throws Exception {
		stackUtils = new StackUtils();
		stack = new MyArrayBackedStack<>();
		
		stack.push(0);
		stack.push(4);
		stack.push(2);
		stack.push(1);
		stack.push(3);
		stack.push(5);
		stack.push(7);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSortStack() {
		MyStack<Integer> sortedStack = stackUtils.sortStack(stack);
		
		assertEquals(new Integer(0), sortedStack.pop());
		assertEquals(new Integer(1), sortedStack.pop());
		assertEquals(new Integer(2), sortedStack.pop());
		assertEquals(new Integer(3), sortedStack.pop());
		assertEquals(new Integer(4), sortedStack.pop());
		assertEquals(new Integer(5), sortedStack.pop());
		assertEquals(new Integer(7), sortedStack.pop());
	}

}
