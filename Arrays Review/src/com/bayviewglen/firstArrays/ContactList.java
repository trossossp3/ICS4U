package com.bayviewglen.firstArrays;

public class ContactList {
	private ContactNode head;
	
	public void addContact(Contact c) {
		head = new ContactNode(c, head);
	}
	
	public Contact removeContact(String lName) {
		
	}

}
