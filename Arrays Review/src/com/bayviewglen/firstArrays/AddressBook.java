package com.bayviewglen.firstArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class AddressBook {

	ContactList contacts = new ContactList();
	int numContacts = 0;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public void addContact() throws IOException {
		System.out.println("Enter Full Name superatred by a space");
		String name = br.readLine();
		String[] split = name.split(" ");

		String f = split[0];
		String l = split[1];
		System.out.println("Enter phone number");
		String p = br.readLine();
		contacts.addContact(new Contact(f, l, p));
		numContacts++;
		System.out.println("Contact added");
		System.out.println("*************************************");
	}

	public void displayContact() throws IOException {
		System.out.println("Enter last name of the contact you want");
		String searchName = br.readLine();
		boolean b1 = false;

		if (contacts.get(searchName) != null) {
			System.out.println(contacts.get(searchName));
		} else {
			System.out.println("no contacts with that name");
		}

		System.out.println("*************************************");

	

	
		System.out.println("*************************************");

	}

	public void destroy() throws IOException {
		System.out.println("Enter name of person to destroy first and last seperated by space");
		String name = br.readLine();
		String[] split = name.split(" ");
		boolean b1 = false;
		if(contacts.handle(split[0],split[1])!=null)
		{
			b1 = true;
		}
		if (b1) {
			System.out.println("Target eliminated");
		} else {
			System.out.println("enter a real person");
		}
		System.out.println("*************************************");
	}

}
