package com.book.chap3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyMinLinkedStackTest {
	
	MyMinLinkedStack minStack;

	@Before
	public void setUp() throws Exception {
		minStack = new MyMinLinkedStack();
		minStack.push(2);
		minStack.push(19);
		minStack.push(1);
		minStack.push(5);
		minStack.push(5);
		minStack.push(6);
		minStack.push(4);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPop() {
		Integer expected = new Integer(4);
		assertEquals(expected, minStack.pop());
	}

	@Test
	public void testPush() {
		minStack.push(12);
		Integer expected = new Integer(12);
		assertEquals(expected, minStack.peek());
	}

	@Test
	public void testPeek() {
		minStack.push(12);
		Integer expected = new Integer(12);
		assertEquals(expected, minStack.peek());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(minStack.isEmpty());
	}

	@Test
	public void testMin() {
		Integer expected = new Integer(1);
		assertEquals(expected, minStack.min());
	}

}
