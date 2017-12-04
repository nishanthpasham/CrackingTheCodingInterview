package com.book.chap4;

import org.junit.Before;
import org.junit.Test;

public class MaxHeapTest {

	MaxHeap maxHeap;

	@Before
	public void setUp() {
		maxHeap = new MaxHeap(5);
		maxHeap.insert(12);
		maxHeap.insert(10);
		maxHeap.insert(16);
		maxHeap.insert(17);
		maxHeap.insert(14);
		maxHeap.insert(22);
		maxHeap.insert(30);
		maxHeap.insert(35);
		maxHeap.insert(19);
	}

	@Test
	public void testInsert() {
		maxHeap.insert(2);
		System.out.println("New root is: " +maxHeap.getRoot());
		maxHeap.inOrderTraversal(maxHeap.getRoot());
		
		maxHeap.insert(3);
		System.out.println("New root is: " +maxHeap.getRoot());
		maxHeap.inOrderTraversal(maxHeap.getRoot());
		
		maxHeap.insert(1);
		System.out.println("New root is: " +maxHeap.getRoot());
		maxHeap.inOrderTraversal(maxHeap.getRoot());
	}

	@Test
	public void testInsertRecursively() {
		maxHeap.insertRecursively(2);
		System.out.println("New root is: " +maxHeap.getRoot());
		maxHeap.inOrderTraversal(maxHeap.getRoot());
	}

}
