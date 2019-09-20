package com.bayviewglen.firstArrays;

public class ContactList {
	private ContactNode head;
	
	public void addContact(Contact c){
		head = new ContactNode(c, head);
	}
	
	public Contact removeContact(String lastName){
		// check the head
		if (head == null) 
			return null;
		else if (head.getData().getLastName().equals(lastName)){
			Contact c = head.getData();
			head = head.getLink();
			return c;
		}else{
			ContactNode prev = head;
			
			while(prev.getLink()!= null){
				if (prev.getData().getLastName().equals(lastName)){
					Contact c = prev.getLink().getData();
					prev.setLink(prev.getLink().getLink());
					return c;
				}else{
					prev = prev.getLink();
				}
				
			}
			
			return null;
		}
	}
	
	public Contact get(String lastName) {
		if(head == null) {
			return null;
		}
		ContactNode cur = head;
		while(cur !=null) {
			if(cur.getData().getLastName().equals(lastName)) {
				return cur.getData();
				
			}
			cur = cur.getLink();
		}
		return null;
	}
	public void all() {
		ContactNode cur= head;
		while (cur != null) {
				System.out.println(cur.getData().toString());
				cur = cur.getLink();
		}
	}
	public Contact handle(String fNam, String lNam) {
		if(head == null) {
			return null;
		}
		if (head.getData().getLastName().equals(lNam)) {
			Contact c1 = head.getData();
			head = head.getLink();
			return c1;
		}
		Contact cur = null;
		ContactNode previous = head;
		while (previous != null) {
			if (previous.getData().getLastName().equals(lNam)) {
				cur = previous.getLink().getData();
				if (previous.getLink().getLink() == null) {
					previous.setLink(null);
				} else {
					previous.setLink(previous.getLink().getLink());
				}
			}
			previous = previous.getLink();
		}
		return cur;
	}
}