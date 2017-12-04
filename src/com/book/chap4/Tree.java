package com.book.chap4;

public interface Tree {
	
	public void insert(int value);
	
	public boolean find(int value);
	
	public BinaryTreeNode findNode(int value);
	
	public boolean delete(int value);

}
