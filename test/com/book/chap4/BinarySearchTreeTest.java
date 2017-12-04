package com.book.chap4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {
	
	BinarySearchTree binarySearchTree;
	
	@Before
	public void setUp() {
		binarySearchTree = new BinarySearchTree(5);
		binarySearchTree.insert(12);
		binarySearchTree.insert(10);
		binarySearchTree.insert(16);
		binarySearchTree.insert(17);
		binarySearchTree.insert(14);
		binarySearchTree.insert(22);
		binarySearchTree.insert(30);
		binarySearchTree.insert(35);
		binarySearchTree.insert(19);
	}

	@Test
	public void testInsert() {
		binarySearchTree.inOrderTraversal(binarySearchTree.getRoot());
	}
	
	@Test
	public void testFind() {
		assertTrue(binarySearchTree.find(12));
		assertTrue(binarySearchTree.find(30));
		assertFalse(binarySearchTree.find(18));
		assertFalse(binarySearchTree.find(11));
		assertTrue(binarySearchTree.find(16));
	}

}
