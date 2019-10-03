package com.bayviewglen.testReview;

public class StackLink {
	private Node head;
	
	public int peek() {
		if(head==null) {
			throw new IllegalStateException("bad");
		}else {
			return head.getData();
		}
	}
	
	public int pop() {
		if(head==null) {
			throw new IllegalStateException("bad");
		}else {
			int x= peek(); //get the first value so i can return it
			head = head.getLink(); //by making the head = its link i am effectivly stranding the head in no-mans land 
									// so it might aswell be deleted
			return x;
		}
	}
	
	public void push() {
		
	}
}
