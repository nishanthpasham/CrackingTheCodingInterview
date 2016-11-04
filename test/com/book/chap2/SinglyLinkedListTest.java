package com.book.chap2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.book.chap2.SinglyLinkedList.Node;

public class SinglyLinkedListTest {
	
	SinglyLinkedList<Integer> singlyLinkedList;
	Node<Integer> node1, node2; 

	@Before
	public void setUp() throws Exception {
		Node<Integer> head = new Node<Integer>(null, 1);
		singlyLinkedList = new SinglyLinkedList<Integer>(head);
		node1 = new Node<Integer>(null, 2);
		node2 = new Node<Integer>(null, 3);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSinglyLinkedList() {
		String expected = "1";
		assertEquals(expected, singlyLinkedList.toString());
	}

	@Test
	public void testDeleteNode() {
		singlyLinkedList.addNodeLast(node1);
		singlyLinkedList.addNodeLast(node2);
		singlyLinkedList.deleteNode(node2);
		String expected = "1-->2";
		assertEquals(expected, singlyLinkedList.toString());
	}

	@Test
	public void testAddNodeLast() {
		singlyLinkedList.addNodeLast(node1);
		String expected = "1-->2";
		assertEquals(expected, singlyLinkedList.toString());
	}

	@Test
	public void testAddItemLast() {
		singlyLinkedList.addItemLast(2);
		String expected = "1-->2";
		assertEquals(expected, singlyLinkedList.toString());
	}

	@Test
	public void testAddNodeFirst() {
		singlyLinkedList.addNodeFirst(node1);
		singlyLinkedList.addNodeFirst(node2);
		String expected = "3-->2-->1";
		assertEquals(expected, singlyLinkedList.toString());
	}

	@Test
	public void testAddItemFirst() {
		singlyLinkedList.addItemFirst(2);
		String expected = "2-->1";
		assertEquals(expected, singlyLinkedList.toString());
	}
	
	@Test
	public void testGetLength() {
		singlyLinkedList.addNodeLast(node1);
		singlyLinkedList.addNodeLast(node2);
		int expected = 3;
		assertEquals(expected, singlyLinkedList.getLength());
	}

	@Test
	public void testToString() {
		singlyLinkedList.addNodeLast(node1);
		singlyLinkedList.addNodeLast(node2);
		String expected = "1-->2-->3";
		assertEquals(expected, singlyLinkedList.toString());
	}

}
