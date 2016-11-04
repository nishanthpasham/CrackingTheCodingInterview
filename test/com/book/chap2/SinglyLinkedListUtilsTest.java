package com.book.chap2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.book.chap2.SinglyLinkedList.Node;

public class SinglyLinkedListUtilsTest {
	
	SinglyLinkedListUtils<Integer> singlyLinkedListUtils;
	SinglyLinkedList<Integer> singlyLinkedList1, singlyLinkedList2;
	Node<Integer> head1, node1, node2, h1, n1, n2;

	@Before
	public void setUp() throws Exception {
		singlyLinkedListUtils = new SinglyLinkedListUtils<Integer>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddLists() {
		head1 = new Node<Integer>(null, 1);
		node1 = new Node<Integer>(null, 2);
		node2 = new Node<Integer>(null, 3);
		
		h1 = new Node<Integer>(null, 2);
		n1 = new Node<Integer>(null, 3);
		n2 = new Node<Integer>(null, 4);
		
		singlyLinkedList1 = new SinglyLinkedList<Integer>(head1);
		singlyLinkedList1.addNodeLast(node1);
		singlyLinkedList1.addNodeLast(node2);
		
		singlyLinkedList2 = new SinglyLinkedList<Integer>(h1);
		singlyLinkedList2.addNodeLast(n1);
		singlyLinkedList2.addNodeLast(n2);
		
		SinglyLinkedList<Integer> sumList = singlyLinkedListUtils.addLists(singlyLinkedList1, singlyLinkedList2);
		String expected = "3-->5-->7";
		assertEquals(expected, sumList.toString());
	}
	
	@Test
	public void testAddListsWithCarry() {
		head1 = new Node<Integer>(null, 7);
		node1 = new Node<Integer>(null, 1);
		node2 = new Node<Integer>(null, 9);
		
		h1 = new Node<Integer>(null, 5);
		n1 = new Node<Integer>(null, 5);
//		n2 = new Node<Integer>(null, 2);
		
		singlyLinkedList1 = new SinglyLinkedList<Integer>(head1);
		singlyLinkedList1.addNodeLast(node1);
		singlyLinkedList1.addNodeLast(node2);
		
		singlyLinkedList2 = new SinglyLinkedList<Integer>(h1);
		singlyLinkedList2.addNodeLast(n1);
		singlyLinkedList2.addNodeLast(n2);
		
		SinglyLinkedList<Integer> sumList = singlyLinkedListUtils.addListsWithCarry(singlyLinkedList1, singlyLinkedList2);
		String expected = "2-->7-->9";
		assertEquals(expected, sumList.toString());
	}
	
	@Test
	public void testIsSinglyLinkedListAPalindrome() {
		head1 = new Node<Integer>(null, 1);
		singlyLinkedList1 = new SinglyLinkedList<Integer>(head1);
		singlyLinkedList1.addItemLast(2);
		singlyLinkedList1.addItemLast(2);
		singlyLinkedList1.addItemLast(1);
		
		boolean expected = singlyLinkedListUtils.isSinglyLinkedListAPalindrome(singlyLinkedList1);
		assertTrue(expected);
		
	}

}
