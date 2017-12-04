package com.book.chap4;

import java.util.ArrayList;
import java.util.List;

public class CompleteBinaryTree extends BinaryTree {

	private int depth;

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public CompleteBinaryTree(BinaryTreeNode root) {
		super(root);
	}

	public CompleteBinaryTree(int value) {
		super(value);
	}
	
	@Override
	public void insert(int value) {
		insertHelper(value);
	}

	protected BinaryTreeNode insertHelper(int value) {
		BinaryTreeNode node = new BinaryTreeNode(value);
		BinaryTreeNode targetNode = determineTargetNode();
		if(targetNode.getLeft()==null) {
			targetNode.setLeft(node);
		} else {
			targetNode.setRight(node);
		}
		node.setParent(targetNode);
		node.setLevel(targetNode.getLevel()+1);
		
		if(node.getLevel()==getDepth()+1)
			setDepth(getDepth()+1);
		
		return node;
	}

	public BinaryTreeNode determineTargetNode() {
		BinaryTreeNode targetNode = findTargetNode(getRoot());
		if (targetNode == null) {
			BinaryTreeNode node = getRoot();
			while (node.getLeft() != null)
				node = node.getLeft();
			targetNode = node;
		}
		return targetNode;
	}

	private BinaryTreeNode findTargetNode(BinaryTreeNode node) {
		BinaryTreeNode result = null;
		if (node != null) {
			if (node.getLevel() == depth - 1) {
				if (!node.hasBothChildren())
					result = node;
			} else {
				result = findTargetNode(node.getLeft());
				if (result == null)
					result = findTargetNode(node.getRight());
			}
		}
		return result;
	}

	public List<BinaryTreeNode> listAllNodesAtLevel(int level) {
		List<BinaryTreeNode> nodesAtLevel = new ArrayList<BinaryTreeNode>();
		if (level > depth)
			return nodesAtLevel;
		nodesAtlevelHelper(getRoot(), nodesAtLevel, level);
		return nodesAtLevel;
	}

	private void nodesAtlevelHelper(BinaryTreeNode node, List<BinaryTreeNode> nodesAtLevel, int level) {
		if (node.getLevel() == level) {
			nodesAtLevel.add(node);
			return;
		}
		nodesAtlevelHelper(node.getLeft(), nodesAtLevel, level);
		nodesAtlevelHelper(node.getRight(), nodesAtLevel, level);
	}

}
