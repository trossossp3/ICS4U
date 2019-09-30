package com.bayviewglen.tree;

public class IntBianaryTreeNode {
	
	private int data;
	private IntBianaryTreeNode leftChild;
	private IntBianaryTreeNode rightChild;
	
	public IntBianaryTreeNode(int data, IntBianaryTreeNode leftChild, IntBianaryTreeNode rightChild) {
		super();
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	public IntBianaryTreeNode(int data) {
		super();
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	
	public boolean hasLeft() {
		return leftChild !=null;
	}
	public boolean hasRight() {
		return rightChild !=null;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public IntBianaryTreeNode getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(IntBianaryTreeNode leftChild) {
		this.leftChild = leftChild;
	}
	public IntBianaryTreeNode getrightChild() {
		return rightChild;
	}
	public void setrightChild(IntBianaryTreeNode rightChild) {
		this.rightChild = rightChild;
	}
	
	

}
