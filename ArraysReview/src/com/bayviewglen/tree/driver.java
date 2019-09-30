package com.bayviewglen.tree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class driver {


	public static void main(String[] args) throws IOException {
		String file = "C:\\Dev\\ICS4U\\ArraysReview\\src\\com\\bayviewglen\\tree\\data.txt";
		BufferedReader in = new BufferedReader(new FileReader(file));
		IntBST bst = new IntBST();
		
		
		String [] temp = in.readLine().split(" ");
		int[] arr = new int[temp.length];
		for(int i =0;i<arr.length;i++) {
			bst.addInteger(Integer.parseInt(temp[i]));
			
		}
		
		bst.inOrderTraversal();
		System.out.println();
		bst.delete(70);
		bst.inOrderTraversal();
	}
}
