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
}