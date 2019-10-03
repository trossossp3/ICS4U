package com.bayviewglen.stackQueue;

import java.util.ArrayList;

public class Tree {
	
	private Node root;

	public Node BuildTree(Node root) {
		ArrayList<Node> list = new ArrayList<Node>();
		store(root,list);
		
		int n = list.size();
		return (buildTreeUtil(list,0,n-1));
	}
	
	public static void main(String[] args)  
    { 
         /* Constructed skewed binary tree is 
                10 
               / 
              8 
             / 
            7 
           / 
          6 
         / 
        5   */
        Tree tree = new Tree(); 
        tree.root = new Node(10); 
        tree.root.left = new Node(8); 
        tree.root.left.left = new Node(7); 
        tree.root.left.left.left = new Node(6); 
        tree.root.left.left.left.left = new Node(5); 
  
        tree.root = tree.BuildTree(tree.root); 
        System.out.println("Preorder traversal of balanced BST is :"); 
        tree.preOrder(tree.root); 
    } 

	private Node buildTreeUtil(ArrayList<Node> list, int start, int end) {
		if(start>end) {
			return null;
		}
		int m = (start+end)/2;
		Node root = list.get(m);
		
		root.setLeft(buildTreeUtil(list,start,m-1));
		root.setRight(buildTreeUtil(list,m+1,end));
		
		return root;
	}

	private void store(Node root, ArrayList<Node> list) {
		
		if(root==null) {
			return;
		}
		
		store(root.getLeft(),list);
		list.add(root);
		store(root.getRight(),list);
	}
	
	private void preOrder(Node node) {
		
		if(node == null) {
			return;
		}
		
		preOrder(node.getLeft());
		System.out.print(node.getData() + " ");
		preOrder(node.getRight());
	}

}
