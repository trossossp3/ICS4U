package com.bayviewglen.stackQueue;
public class IntArrayStack implements Stack {

	private int[] arr = new int[100];
	private int manyItems=0;
	public Integer peek() {
		// TODO Auto-generated method stub		
		if(manyItems ==0) {
			throw new IllegalStateException("Bad");
		}
		return arr[manyItems-1];	
		
	}

	@Override
	public Integer pop() {
		if(manyItems ==0) {
			throw new IllegalStateException("Bad");
		}
		return arr[--manyItems];
	}

	@Override
	public boolean isEmpty() {
		return manyItems==0;
	}

	@Override
	public void push(Integer x) {
		arr[manyItems] = x;
		manyItems++;
	}
}

