package com.bayviewglen.stackQueue;

public class IntLinkedListStack implements Stack{

	private IntegerNode head;
	public Integer peek() {
		if(head == null) {
			throw new IllegalStateException("Bad");
		}
		return head.data;
	}

	@Override
	public Integer pop() {
		if(head == null) {
			throw new IllegalStateException("Bad");
		}
		Integer x = peek();
		head = head.link;
		return x;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public void push(Integer x) {
		head= new IntegerNode(x,head);
		
	}
		
	class IntegerNode{
		private Integer data;
		private IntegerNode link;
		
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

