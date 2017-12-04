package com.book.chap4;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CompleteBinaryTreeTest {
	
	CompleteBinaryTree completeBinaryTree;
	
	@Before
	public void setUp() {
		completeBinaryTree = new CompleteBinaryTree(5);
		completeBinaryTree.insert(12);
		completeBinaryTree.insert(10);
		completeBinaryTree.insert(16);
		completeBinaryTree.insert(17);
		completeBinaryTree.insert(14);
		completeBinaryTree.insert(22);
		completeBinaryTree.insert(30);
		completeBinaryTree.insert(35);
		completeBinaryTree.insert(19);
	}
	
	@Test
	public void testFind() {
		assertTrue(completeBinaryTree.find(10));
		assertTrue(completeBinaryTree.find(35));
		assertFalse(completeBinaryTree.find(13));
		assertTrue(completeBinaryTree.find(19));
	}

	@Test
	public void testAddNode() {
		completeBinaryTree.inOrderTraversal(completeBinaryTree.getRoot());
	}

	@Test
	public void testListAllNodesAtLevel() {
		int level = 5;
		List<BinaryTreeNode> listAllNodesAtLevel = completeBinaryTree.listAllNodesAtLevel(level);
		if(Collections.EMPTY_LIST.equals(listAllNodesAtLevel))
			System.out.println("No elements are present at level: "+level);
		for(BinaryTreeNode b:listAllNodesAtLevel){
			System.out.println(b);
		}
	}
	
	@Test
	public void testFindBottomRightNode() {
		BinaryTreeNode bottomRightNode = completeBinaryTree.findBottomRightNode();
		assertTrue(bottomRightNode!=null);
		assertTrue(bottomRightNode.getValue()==19);
	}
	
	@Test
	public void testDelete() {
		assertTrue(completeBinaryTree.delete(10));
		assertTrue(completeBinaryTree.findBottomRightNode().getValue()==35);
		
		assertTrue(completeBinaryTree.delete(5));
		assertTrue(completeBinaryTree.findBottomRightNode().getValue()==30);
	}

	@Test
	public void testInOrderTraversal() {
		completeBinaryTree.inOrderTraversal(completeBinaryTree.getRoot());
	}

	@Test
	public void testPreOrderTraversal() {
		completeBinaryTree.preOrderTraversal(completeBinaryTree.getRoot());
	}

	@Test
	public void testPostOrderTraversal() {
		completeBinaryTree.postOrderTraversal(completeBinaryTree.getRoot());
	}

}
