package com.bayviewglen.queue;

public class IntArrayQueue implements Stack {

	private int[] arr = new int[100];
	private int manyItems=0;
	
	
	//put the element el at the end of the queue;
	public void enqueue(Integer el) {
		// TODO Auto-generated method stub		
		arr[manyItems++] = el;
		
	}

	
	//take the first element from the queue
	public Integer dequeue() {
		if(manyItems ==0) {
			throw new IllegalStateException("Bad");
		}
		Integer temp = arr[0];
		for(int i =1; i<manyItems;i++) {
			arr[i-1] = arr[i];
		}
		
		return temp;
	}

	@Override
	public boolean isEmpty() {
		return manyItems==0;
	}

	@Override
	public void clear() {
		manyItems = 0;
	}

	@Override
	public Integer peek() {
		if(manyItems ==0) {
			throw new IllegalStateException("Bad");
		}
		return arr[0];
	}
	
}

