package com.bayviewglen.postfix;

public class Stack {
	private String[] arr = new String[100];
	private int manyItems = 0;

	public String peek() {
		// TODO Auto-generated method stub
		if (manyItems == 0) {
			throw new IllegalStateException("Bad");
		}
		return arr[manyItems - 1];

	}

	
	public String pop() {
		if (manyItems == 0) {
			throw new IllegalStateException("Bad");
		}
		return arr[--manyItems];
	}

	
	public boolean isEmpty() {
		return manyItems == 0;
	}

	public void push(String x) {
		arr[manyItems++] = x;
	}
	public String toString() {
		String s1 = "";
		for(int i =0; i<manyItems;i++) {
			s1+=arr[i] + " ";
		}
		return s1;
	}
}
