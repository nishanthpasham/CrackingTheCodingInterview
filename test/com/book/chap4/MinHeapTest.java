package com.book.chap4;

import org.junit.Before;
import org.junit.Test;

public class MinHeapTest {
	
	MinHeap minHeap;
	
	@Before
	public void setUp() {
		minHeap = new MinHeap(5);
		minHeap.insert(12);
		minHeap.insert(10);
		minHeap.insert(16);
		minHeap.insert(17);
		minHeap.insert(14);
		minHeap.insert(22);
		minHeap.insert(30);
		minHeap.insert(35);
		minHeap.insert(19);
	}

	@Test
	public void testInsert() {
		minHeap.insert(2);
		System.out.println("New root is: " +minHeap.getRoot());
		minHeap.inOrderTraversal(minHeap.getRoot());
		
		minHeap.insert(3);
		System.out.println("New root is: " +minHeap.getRoot());
		minHeap.inOrderTraversal(minHeap.getRoot());
		
		minHeap.insert(1);
		System.out.println("New root is: " +minHeap.getRoot());
		minHeap.inOrderTraversal(minHeap.getRoot());
	}

	@Test
	public void testInsertRecursively() {
		minHeap.insertRecursively(2);
		System.out.println("New root is: " +minHeap.getRoot());
		minHeap.inOrderTraversal(minHeap.getRoot());
	}

}
