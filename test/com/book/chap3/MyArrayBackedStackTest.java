package com.book.chap3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyArrayBackedStackTest {
	
	MyArrayBackedStack<Integer> stack;

	@Before
	public void setUp() throws Exception {
		stack = new MyArrayBackedStack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPop() {
		assertEquals(new Integer(5), stack.pop());
		assertEquals(new Integer(4), stack.pop());
		assertEquals(new Integer(3), stack.pop());
		assertEquals(new Integer(2), stack.pop());
		assertEquals(new Integer(1), stack.pop());
	}

	@Test
	public void testPush() {
		assertEquals(new Integer(5), stack.peek());
	}

	@Test
	public void testPeek() {
		assertEquals(new Integer(5), stack.peek());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(stack.isEmpty());
		
		MyArrayBackedStack<Integer> stack2 = new MyArrayBackedStack<>();
		assertTrue(stack2.isEmpty());
	}

}
