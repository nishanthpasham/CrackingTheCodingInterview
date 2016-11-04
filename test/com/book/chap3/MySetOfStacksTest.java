package com.book.chap3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MySetOfStacksTest {
	
	MySetOfStacks<Integer> setOfStacks;

	@Before
	public void setUp() throws Exception {
		setOfStacks = new MySetOfStacks<Integer>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMySetOfStacks() {
	}

	@Test
	public void testPop() {
		setOfStacks.push(1);
		setOfStacks.push(2);
		setOfStacks.push(3);
		setOfStacks.push(4);
		
		Integer expected = new Integer(4);
		assertEquals(expected, setOfStacks.pop());
		
		assertEquals(new Integer(3), setOfStacks.peek());
	}

	@Test
	public void testPush() {
		setOfStacks.push(1);
		setOfStacks.push(2);
		setOfStacks.push(3);
		setOfStacks.push(4);
		
		Integer expected = new Integer(4);
		assertEquals(expected, setOfStacks.peek());
	}

	@Test
	public void testPeek() {
		setOfStacks.push(1);
		setOfStacks.push(2);
		setOfStacks.push(3);
		setOfStacks.push(4);
		setOfStacks.push(5);
		
		Integer expected = new Integer(5);
		assertEquals(expected, setOfStacks.peek());
	}

	@Test
	public void testIsEmpty() {
		assertTrue(setOfStacks.isEmpty());
		
		setOfStacks.push(1);
		setOfStacks.push(2);
		setOfStacks.push(3);
		
		assertFalse(setOfStacks.isEmpty());
	}

}
