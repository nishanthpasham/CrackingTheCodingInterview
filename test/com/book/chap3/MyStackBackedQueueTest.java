package com.book.chap3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyStackBackedQueueTest {

	MyStackBackedQueue<Integer> msbq;
	
	@Before
	public void setUp() throws Exception {
		msbq = new MyStackBackedQueue<>();
		msbq.add(1);
		msbq.add(2);
		msbq.add(3);
		msbq.add(4);
		msbq.add(5);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		assertEquals(new Integer(1), msbq.peek());
	}

	@Test
	public void testRemove() {
		assertEquals(new Integer(1), msbq.remove());
		assertEquals(new Integer(2), msbq.peek());
		assertEquals(new Integer(2), msbq.remove());
		assertEquals(new Integer(3), msbq.remove());
		assertEquals(new Integer(4), msbq.remove());
	}

	@Test
	public void testPeek() {
		assertEquals(new Integer(1), msbq.peek());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(msbq.isEmpty());
		
		MyStackBackedQueue<Integer> queue = new MyStackBackedQueue<>();
		assertTrue(queue.isEmpty());
	}

}
