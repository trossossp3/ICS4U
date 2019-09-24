package com.bayviewglen.queue;

import com.bayviewglen.stackQueue.IntLinkedListStack.IntegerNode;

public class IntLinkedListQueue implements Stack{

	private IntegerNode head;
	
	public IntLinkedListQueue() {
		head = new IntegerNode(0,null);
	}
	public Integer peek() {
		if(head == null) {
			throw new IllegalStateException("Bad");
		}
		return head.link.data;
	}
	@Override
	public Integer dequeue() {
		if(head == null) {
			throw new IllegalStateException("Bad");
		}
		int temp = head.link.data;
		head.link = head.link.link;
		return temp;		
	}
	@Override
	public boolean isEmpty() {
		return head.link == null;
	}
	public void clear() {
		head.link = null;
	}

	@Override
	public void enqueue(Integer el) {
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

