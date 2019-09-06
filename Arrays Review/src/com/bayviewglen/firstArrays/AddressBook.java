package com.bayviewglen.firstArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddressBook {

	Contact[] contacts = new Contact[20];
	int numContacts = 0;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public void addContact() throws IOException {
		System.out.println("Enter Full Name superatred by a space");
		String name = br.readLine();
		String[] split = name.split(" ");
		contacts[numContacts] = new Contact();
		contacts[numContacts].setFirstName(split[0]);
		contacts[numContacts].setLastName(split[1]);
		System.out.println("Enter phone number");
		contacts[numContacts].setPhone(br.readLine());
		numContacts++;
		System.out.println("Contact added");
		System.out.println("*************************************");
	}

	public void displayContact() throws IOException {
		System.out.println("Enter last name of the contact you want");
		String searchName = br.readLine();
		boolean b1 = false;
		for (int i = 0; i < 20; i++) {
			try {
				if (contacts[i].getLastName().equals(searchName)) {
					System.out.println(contacts[i].toString() + "\n");
					b1 = true;
				}
			} catch (NullPointerException e) {

			}

		}

		if (!b1) {
			System.out.println("no contacts with that name");
		}

	}

	public void displayContacts() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 20; i++) {
			try {
				System.out.println(contacts[i].toString() + "\n");
			} catch (NullPointerException e) {

			}
		}

	}

	public void destroy() throws IOException {
		System.out.println("Enter name of person to destroy first and last seperated by space");
		String name = br.readLine();
		String[] split = name.split(" ");
		boolean b1 = false;
		for (int i = 0; i < 20; i++) {
			try {
				
				if (contacts[i].getFirstName().equals(split[0]) && contacts[i].getLastName().equals(split[1])) {
					b1 = true;
					contacts[i] = null;
					

				}

			} catch (NullPointerException e) {

			}
		}
		if (b1) {
			System.out.println("Target eliminated");
		} else {
			System.out.println("enter a real person");
		}
	}

}
