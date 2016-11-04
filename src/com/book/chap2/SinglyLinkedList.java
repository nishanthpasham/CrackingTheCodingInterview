
package com.book.chap2;

public class SinglyLinkedList<E> {
	
	Node<E> head;
	
	public static class Node<E> {
		E item;
		Node<E> next;
		
		Node(Node<E> next, E item) {
			this.next = next;
			this.item = item;
		}
		
		protected Node<E> clone() {
			Node<E> n = new Node<E>(null, this.item);
			return n;
		}
		
		E getItem(){
			return item;
		}
		
		boolean equals(Node<E> other) {
			if(other == null)
				return false;
			if(this.item != other.item)
				return false;
			if(this.next == null && other.next == null)
				return true;
			else 
				return next.equals(other.next);
		}
		
		int hashcode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((item == null) ? 0 : item.hashCode());
			result = prime * result + ((next == null) ? 0 : next.hashCode());
			return result;
		}
		
		boolean equalsOnlyValue(Node<E> other) {
			if(other == null)
				return false;
			if(this.item != other.item)
				return false;

			return true;
		}
	}
	
	public SinglyLinkedList() {
		this.head = null;
	}
	
	public SinglyLinkedList(Node<E> head) {
		this.head = head;
	}
	
	public void deleteNode(Node<E> n) {
		if(n == head) {
			head = head.next;
			return;
		}	
		Node<E> node = head;
		while(node.next != null) {
			if(node.next == n) {
				node.next = n.next;
				return;
			}
			node = node.next;
		}
		return;
	}
	
	public void addNodeLast(Node<E> node) {
		if(head == null)
			head = node;
		else {
			Node<E> n = head;
			while(n.next != null) {
				n = n.next;
			}
			n.next = node;
		}
	}
	
	public void addItemLast(E item) {
		Node<E> node = new Node<E>(null, item);
		addNodeLast(node);
	}
	
	public void addNodeFirst(Node<E> node) {
		if(head == null)
			head = node;
		else {
			node.next = head;
			head = node;
		}
	}
	
	public void addItemFirst(E item) {
		Node<E> node = new Node<E>(null, item);
		addNodeFirst(node);
	}
	
	public int getLength() {
		int len = 0;
		if(head == null)
			return 0;
		Node<E> n = head;
		len += 1;
		while(n.next != null) {
			len += 1;
			n = n.next;
		}
		return len;
	}
	
	public boolean equals(SinglyLinkedList<E> other) {
		if(this.getLength() != other.getLength())
			return false;
		if(this.head == null && other.head == null)
			return true;
		else 
			return head.equals(other.head);
	}
	
	public String toString(){
		Node<E> n = head;
		StringBuffer buffer = new StringBuffer(n.item.toString());
		while(n.next != null) {
			buffer.append("-->");
			buffer.append(n.next.item.toString());
			n = n.next;
		}
		return buffer.toString();
	}
	
	public void print() {
		System.out.println(this.toString());
	}
}
