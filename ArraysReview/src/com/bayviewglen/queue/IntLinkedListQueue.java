package com.bayviewglen.queue;

public class IntLinkedListQueue implements Queue{

	private IntegerNode head;
	
	public IntLinkedListQueue() {
		
	}
	public Integer peek() {
		if(head == null) {
			throw new IllegalStateException("Bad");
		}
		return head.data;
	}
	@Override
	public Integer dequeue() {
		if(head == null) {
			throw new IllegalStateException("Bad");
		}
		int temp = head.data;
		head = head.link;
		return temp;		
	}
	@Override
	public boolean isEmpty() {
		return head == null;
	}
	public void clear() {
		head = null;
	}

	@Override
	public void enqueue(Integer el) {
		
		if(head==null) {
			head = new IntegerNode(el,head);
			return;
		}
		IntegerNode cur = head;
		
		while(cur.link != null) {
			cur = cur.link;
		}
		cur.setLink(new IntegerNode(el,null));
	}
	
		
	class IntegerNode{
		private Integer data;
		public IntegerNode link;
		
		public Integer getData() {
			return data;
		}

		public void setData(Integer data) {
			this.data = data;
		}

		public IntegerNode getLink() {
			return link;
		}

		public void setLink(IntegerNode link) {
			this.link = link;
		}

		public IntegerNode(Integer data, IntegerNode link) {
			this.data = data;
			this.link = link;
		}
		
		
	}
}

