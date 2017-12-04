package com.book.chap4;

public class BinarySearchTree extends BinaryTree {

	public BinarySearchTree(BinaryTreeNode root) {
		super(root);
	}

	public BinarySearchTree(int value) {
		super(value);
	}

	@Override
	public void insert(int value) {
		insertHelper(getRoot(), value);
	}

	private void insertHelper(BinaryTreeNode node, int value) {
		if (node.getValue() >= value) {
			if (node.getLeft() == null) {
				BinaryTreeNode n = new BinaryTreeNode(value);
				n.setParent(node);
				node.setLeft(n);
			} else {
				insertHelper(node.getLeft(), value);
			}
		} else {
			if (node.getRight() == null) {
				BinaryTreeNode n = new BinaryTreeNode(value);
				n.setParent(node);
				node.setRight(n);
			} else {
				insertHelper(node.getRight(), value);
			}
		}
	}

}
