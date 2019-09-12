package com.bayviewglen.firstArrays;

public class ContactDriver {

	public static void main(String[] args) {
		ContactList book = new ContactList();
		book.addContact(new Contact("a", "b", "c"));
		book.addContact(new Contact("a1", "b1", "c1"));
		book.addContact(new Contact("a2", "b2", "c2"));
	
		book.removeContact("b1");
		book.removeContact("y");
	
		System.out.println();
	}

}
