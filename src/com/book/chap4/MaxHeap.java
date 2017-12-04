package com.book.chap4;

public class MaxHeap extends CompleteBinaryTree {

	MaxHeap(BinaryTreeNode root) {
		super(root);
	}

	public MaxHeap(int value) {
		super(value);
	}

	@Override
	public void insert(int value) {
		BinaryTreeNode node = insertHelper(value);
		heapifyIterative(node);
	}

	private void heapifyIterative(BinaryTreeNode node) {
		while (node.getParent() != null && node.getValue() > node.getParent().getValue()) {
			int temp = node.getValue();
			node.setValue(node.getParent().getValue());
			node.getParent().setValue(temp);
			node = node.getParent();
		}
	}

	public void insertRecursively(int value) {
		BinaryTreeNode node = insertHelper(value);
		heapifyRecursive(node);
	}

	private void heapifyRecursive(BinaryTreeNode node) {
		if (node.getParent() != null && node.getValue() > node.getParent().getValue()) {
			int temp = node.getValue();
			node.setValue(node.getParent().getValue());
			node.getParent().setValue(temp);
			heapifyRecursive(node.getParent());
		}
	}

}
