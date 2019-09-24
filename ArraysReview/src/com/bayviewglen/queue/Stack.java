package com.bayviewglen.queue;

public interface Stack {

	
	public void enqueue(Integer el);
	public Integer dequeue();
	public Integer peek();
	public void clear();
	public boolean isEmpty();
	
}
