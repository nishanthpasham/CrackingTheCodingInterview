package com.book.chap3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ThreeInOneStackTest {
	
	ThreeInOneStack<Integer> tios;

	@Before
	public void setUp() throws Exception {
		tios = new ThreeInOneStack<Integer>();
		tios.push(1, 0);
		tios.push(2, 0);
		tios.push(5, 1);
		tios.push(6, 1);
		tios.push(10, 2);
		tios.push(11, 2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testThreeInOneStackInt() {
		tios = new ThreeInOneStack<Integer>(4);
		tios.push(1, 0);
		tios.push(2, 0);
		tios.push(5, 1);
		tios.push(6, 1);
		tios.push(10, 2);
		tios.push(11, 2);
		
		assertEquals(tios.getStackCapacity(0), 4);
	}

	@Test
	public void testThreeInOneStack() {
		tios = new ThreeInOneStack<Integer>(3, 10);
		tios.push(1, 0);
		tios.push(2, 0);
		tios.push(5, 1);
		tios.push(6, 1);
		tios.push(10, 2);
		tios.push(11, 2);
		
		tios.push(3, 0);
		
		assertEquals(13, tios.getStackCapacity(0));
//		System.out.println(tios.toString());
	}

	@Test
	public void testPop() {
		Integer actual = tios.pop(0);
		Integer expected = new Integer(2);
		
		assertEquals(expected, actual);
		assertEquals(1, tios.getStackSize(0));
	}

	@Test
	public void testPush() {
		tios.push(3, 0);
		
		Integer expected = new Integer(3);
		assertEquals(expected, tios.peek(0));
		assertEquals(3, tios.getStackSize(0));
		assertEquals(6, tios.getStackCapacity(0));
	}

	@Test
	public void testPeek() {
		Integer expected = new Integer(6);
		assertEquals(expected, tios.peek(1));
	}

	@Test
	public void testIsEmpty() {
		tios.pop(2);
		tios.pop(2);
		assertTrue(tios.isEmpty(2));
	}

	@Test
	public void testToString() {
//		System.out.println(tios.toString());
	}

}
