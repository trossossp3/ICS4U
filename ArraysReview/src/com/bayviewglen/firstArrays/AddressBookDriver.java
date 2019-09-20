package com.bayviewglen.firstArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddressBookDriver {
	static final String INPUTS = "12345";
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


	public static void main(String[] args) throws IOException {
		AddressBook contacts = new AddressBook();
		
		while(true) {
			int option = getOption();
		
		process(option,contacts);
		}
		
	}
	
	private static void process(int option, AddressBook contacts) throws IOException {
		if(option == 1) {
			contacts.addContact();
		}else if(option == 2) {
			contacts.displayContact();
		}else if(option ==3) {
			//contacts.displayContacts();
		}else {
			contacts.destroy();
			
		}
		
	}

	public static void displayOptions() {
		System.out.println("What would you like to do?\n");
		System.out.println("\tAdd contact (type \"1\")");		
		System.out.println("\tDisplay Contact (type \"2\")");
		System.out.println("\tDisplay all contacts (type \"3\")");
		System.out.println("\tDestroy Contact (type \"4\")");
	}
	
	public static int getOption() throws IOException {
		boolean validInput = false;
		String input ="";
		displayOptions();
		while(!validInput) {
			input= br.readLine();
			
			if(input.length()==1&&INPUTS.indexOf(input)!=-1) {
				validInput = true;
			}else {
				System.out.println("Incorrect Input try again");
				displayOptions();
			}
			
			
			
		}
		return Integer.parseInt(input);
	}

}
