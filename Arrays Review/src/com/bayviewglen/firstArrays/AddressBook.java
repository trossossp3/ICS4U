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
		String l =split[1];
		System.out.println("Enter phone number");
		String p = br.readLine();
		contacts.addContact(new Contact(f,l,p));
		numContacts++;
		System.out.println("Contact added");
		System.out.println("*************************************");
	}

	public void displayContact() throws IOException {
		System.out.println("Enter last name of the contact you want");
		String searchName = br.readLine();
		boolean b1 = false;
		for (int i = 0; i < numContacts; i++) {
			try {
				if (contacts.get(i).getLastName().equals(searchName)) {
					System.out.println(contacts.get(i).toString() + "\n");
					b1 = true;
				}
			} catch (NullPointerException e) {

			}

		}

		if (!b1) {
			System.out.println("no contacts with that name");
		}
		System.out.println("*************************************");

	}

	public void displayContacts() {
		// TODO Auto-generated method stub
		for (int i = 0; i < numContacts; i++) {
			try {
				System.out.println(contacts.get(i).toString() + "\n");
			} catch (NullPointerException e) {

			}
		}
		System.out.println("*************************************");

	}

	public void destroy() throws IOException {
		System.out.println("Enter name of person to destroy first and last seperated by space");
		String name = br.readLine();
		String[] split = name.split(" ");
		boolean b1 = false;
		for (int i = 0; i < numContacts; i++) {
			try {
				
				if (contacts.get(i).getFirstName().equals(split[0]) && contacts.get(i).getLastName().equals(split[1])) {
					b1 = true;
					contacts.remove(i);
						

				}

			} catch (NullPointerException e) {

			}
		}
		if (b1) {
			System.out.println("Target eliminated");
		} else {
			System.out.println("enter a real person");
		}
		System.out.println("*************************************");
	}
	

}
