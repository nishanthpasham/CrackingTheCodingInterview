package com.book.chap4;

public class BinaryTree implements Tree {
	
	private BinaryTreeNode root;
	
	public BinaryTreeNode getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode root) {
		this.root = root;
	}

	public BinaryTree(BinaryTreeNode root) {
		this.root = root;
	}
	
	public BinaryTree(int value) {
		this.root = new BinaryTreeNode(value);
	}
	
	public void inOrderTraversal(BinaryTreeNode n) {
		if (n != null) {
			inOrderTraversal(n.getLeft());
			System.out.println(n.getValue() + ", ");
			inOrderTraversal(n.getRight());
		}
	}

	public void preOrderTraversal(BinaryTreeNode n) {
		if (n != null) {
			System.out.println(n.getValue() + ", ");
			preOrderTraversal(n.getLeft());
			preOrderTraversal(n.getRight());
		}
	}

	public void postOrderTraversal(BinaryTreeNode n) {
		if (n != null) {
			postOrderTraversal(n.getLeft());
			postOrderTraversal(n.getRight());
			System.out.println(n.getValue() + ", ");
		}
	}

	@Override
	public void insert(int value) {
		throw new RuntimeException("insert is not supported on Binary Tree.");
	}

	@Override
	public boolean find(int value) {
		return findHelper(this.getRoot(), value);
	}

	private boolean findHelper(BinaryTreeNode node, int value) {
		if (node != null) {
			if (node.getValue() == value)
				return true;
			else {
				boolean found = findHelper(node.getLeft(), value);
				if (found)
					return true;
				else
					return findHelper(node.getRight(), value);
			}
		}
		return false;
	}

	@Override
	public boolean delete(int value) {
		BinaryTreeNode nodeToBeChanged = findNode(value);
		if(nodeToBeChanged==null)
			return false;
		BinaryTreeNode bottomRightNode = findBottomRightNode();
		if(this.getRoot().equals(bottomRightNode)) { //only root is present in the tree and one is trying to remove the root
			setRoot(null);
		} else { // more than one element in tree
			if(!nodeToBeChanged.equals(bottomRightNode)) { 
				nodeToBeChanged.setValue(bottomRightNode.getValue());
			} 
				BinaryTreeNode parent = bottomRightNode.getParent();
				if(bottomRightNode.equals(parent.getLeft()))
					parent.setLeft(null);
				else
					parent.setRight(null);
		}
		return true;
	}

	@Override
	public BinaryTreeNode findNode(int value) {
		return findNodeHelper(getRoot(), value);
	}
	
	private BinaryTreeNode findNodeHelper(BinaryTreeNode node, int value) {
		if (node != null) {
			if (node.getValue() == value)
				return node;
			else {
				BinaryTreeNode n = findNodeHelper(node.getLeft(), value);
				if (n!=null)
					return n;
				else
					return findNodeHelper(node.getRight(), value);
			}
		}
		return null;
	}
	
	public BinaryTreeNode findBottomRightNode() {
		BinaryTreeNode bottomRightNode = getRoot();
		return findBottomRightNodeHelper(getRoot(), bottomRightNode);
	}
	
	private BinaryTreeNode findBottomRightNodeHelper(BinaryTreeNode node, BinaryTreeNode bottomRightNode) {
			if(node.getLevel()>=bottomRightNode.getLevel())
				bottomRightNode = node;
			if(node.getLeft()!=null)
				bottomRightNode = findBottomRightNodeHelper(node.getLeft(), bottomRightNode);
			if(node.getRight()!=null)
				bottomRightNode = findBottomRightNodeHelper(node.getRight(), bottomRightNode);
			return bottomRightNode;
	}
}
