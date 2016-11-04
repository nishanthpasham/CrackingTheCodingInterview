package com.book.chap2;

import java.util.HashMap;

import com.book.chap2.SinglyLinkedList.Node;

public class SinglyLinkedListUtils<E> {

	public SinglyLinkedList<Integer> addLists(final SinglyLinkedList<Integer> list1, final SinglyLinkedList<Integer> list2) {
		Node<Integer> node1 = list1.head;
		Node<Integer> node2 = list2.head;
		Node<Integer> head = new Node<Integer>(null, node1.item + node2.item);
		SinglyLinkedList<Integer> sumList = new SinglyLinkedList<Integer>(head);
		Node<Integer> node3;
		while(node1.next != null && node2.next != null) {
			node3 = new Node<Integer>(null, node1.next.item + node2.next.item);
			node1 = node1.next;
			node2 = node2.next;
			sumList.addNodeLast(node3);
		}
		return sumList;
	}

	public SinglyLinkedList<Integer> addListsWithCarry(final SinglyLinkedList<Integer> list1, final SinglyLinkedList<Integer> list2) {
		SinglyLinkedList<Integer> sumList = new SinglyLinkedList<Integer>();
		int len1 = list1.getLength();
		int len2 = list2.getLength();
		int len = len1>len2 ? len1:len2;

		Node<Integer> node1 = list1.head;
		Node<Integer> node2 = list2.head;
		Node<Integer> node3;

		Integer carry = computeCarry(node1, node2, 0);
		node3 = new Node<Integer>(null, carry==1?(node1.item+node2.item-10):(node1.item+node2.item));
		sumList.addNodeLast(node3);

		// the same can be achieved without actually finding out lengths. You can just forward iterate using while loop
		for (int i = 1; i <len; i++) {
			if(i < len1 && i < len2) {
				node3 = new Node<Integer>(null, computeCarry(node1.next, node2.next, carry)==1?(node1.next.item+node2.next.item+carry-10):(node1.next.item+node2.next.item+carry));
				carry = computeCarry(node1.next, node2.next, carry);
				node1 = node1.next;
				node2 = node2.next;
			} else if (i >= len1 && i < len2){
				node3 = new Node<Integer>(null, computeCarry(null, node2.next, carry)==1?(node2.next.item+carry-10):(node2.next.item+carry));
				carry = computeCarry(null, node2.next, carry);
				node2 = node2.next;
			} else if (i < len1 && i >= len2){
				node3 = new Node<Integer>(null, computeCarry(node1.next, null, carry)==1?(node1.next.item+carry-10):(node1.next.item+carry));
				carry = computeCarry(node1.next, null, carry);
				node1 = node1.next;
			}
			sumList.addNodeLast(node3);
		}
		if(carry==1) {
			node3 = new Node<Integer>(null, 1);
			sumList.addNodeLast(node3);
		}
		return sumList;
	}

	public boolean isSinglyLinkedListAPalindrome(SinglyLinkedList<E> list1) {
		// Idea is to reverse the linkedlist and compare nodes
		Node<E> n1 = list1.head;
		SinglyLinkedList<E> list2 = new SinglyLinkedList<>(new Node<E>(null, list1.head.item));
		while(n1.next != null) {
			list2.addItemFirst(n1.next.item);
			n1 = n1.next;
		}
		return list1.head.equals(list2.head);
	}

	public Node<E> intersection(SinglyLinkedList<E> list1, SinglyLinkedList<E> list2) {
		Node<E> node1 = list1.head;
		Node<E> node2 = list2.head;
		boolean found = false;
		while(node1.next != null) {
			node2 = list2.head;
			while(node2.next != null) {
				found = node1.equals(node2);
				if(found) break;
				node2 = node2.next;
			}
			if(found) break;
			node1 = node1.next;
		}
		return node1;
	}

	public Node<E> loopDetection(SinglyLinkedList<E> list) {
		Node<E> node = list.head;
		HashMap<Node<E>, Integer> nodeCount = new HashMap<Node<E>, Integer>();
		Integer count;
		while(node.next != null) {
			count = nodeCount.get(node);
			if(count == null)
				nodeCount.put(node, 1);
			else
				return node;
			node = node.next;
		}
		return null;
	}

	private Integer computeCarry(final Node<Integer> n1, final Node<Integer> n2, int prevCarry) {
		if(( (n1==null? 0:n1.item) + (n2==null?0:n2.item) + prevCarry) >= 10)
			return 1;
		else 
			return 0;
	}

}


