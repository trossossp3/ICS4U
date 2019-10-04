package com.bayviewglen.tree;

public class IntBST {
	private IntBianaryTreeNode root;

	public IntBST() {
		root = null;
	}

	public void delete(int data) {

		root = delete(root, data);
	}

	private IntBianaryTreeNode delete(IntBianaryTreeNode node, int data) {
		if (node == null) {
			return null;
		}

		if (data < node.getData()) {

			node.setLeftChild(delete(node.getLeftChild(), data));
		} else if (data > node.getData()) {
			node.setrightChild(delete(node.getrightChild(), data));

		} else {
			if (!node.hasLeft() && !node.hasRight()) {
				return null;
			} else if (!node.hasLeft()) {
				return node.getrightChild();
			} else if (!node.hasRight()) {
				return node.getLeftChild();
			}
			// find the smallest value on right side of root
			node.setData(min(node.getrightChild()));

			// delete the value i just moved to root
			node.setrightChild(delete(node.getrightChild(), node.getData()));
		}
		return node;

	}

	private int min(IntBianaryTreeNode node) {
		int min = node.getData();
		while (node.hasLeft()) {
			min = node.getLeftChild().getData();
			node = node.getLeftChild();
		}
		return min;
	}

	public void addInteger(int data) {
		if (root == null)
			root = new IntBianaryTreeNode(data);
		else
			addInteger(root, data);
	}

	private void addInteger(IntBianaryTreeNode node, int data) {
		if (data < node.getData()) {
			if (node.hasLeft())
				addInteger(node.getLeftChild(), data);
			else
				node.setLeftChild(new IntBianaryTreeNode(data));
		} else {
			if (node.hasRight())
				addInteger(node.getrightChild(), data);
			else
				node.setrightChild(new IntBianaryTreeNode(data));
		}
	}

	public void processNode(IntBianaryTreeNode node) {
		System.out.println(node.getData());
	}

	public void preOrderTraversal() {
		preOrderTraversal(root);
	}

	private void preOrderTraversal(IntBianaryTreeNode node) {
		processNode(node);
		if (node.hasLeft())
			preOrderTraversal(node.getLeftChild());
		if (node.hasRight())
			preOrderTraversal(node.getrightChild());
		
		/*
		if(node ==null) {
			return;
		}else {
			System.out.println(node);
			preOrderTraversal(node.getLeftChild());
			preOrderTraversal(node.getrightChild());
		}
	*/}

	public void postOrderTraversal() {
		postOrderTraversal(root);
	}

	private void postOrderTraversal(IntBianaryTreeNode node) {

		if (node.hasLeft())
			postOrderTraversal(node.getLeftChild());
		if (node.hasRight())
			postOrderTraversal(node.getrightChild());

		processNode(node);
	}

	public void inOrderTraversal() {
		inOrderTraversal(root);
	}

	private void inOrderTraversal(IntBianaryTreeNode node) {
		if (node.hasLeft())
			inOrderTraversal(node.getLeftChild());
		processNode(node);
		if (node.hasRight())
			inOrderTraversal(node.getrightChild());
	}

}
