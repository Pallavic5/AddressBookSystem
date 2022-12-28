package com.bridgelabz.addressbook;
/*Problem Statement UC - 6
 * Refactor to add multiple Address Book to the System. Each Address Book has a unique name.
 */
import java.util.HashMap;
import java.util.Scanner;

public class MultipleAddressBook {
	static Scanner scanner = new Scanner(System.in);
	HashMap<String, EditContactInAddressBook> addressbook = new HashMap<>();
	/*
	 * ablility to add multiple addressbook
	 * 
	 */
	public void addMultipleAddressBook() {
		while (true) {
			System.out.println("Enter selection \n1)To Access address book\n2)exit and add");// add new if running
			int selection = scanner.nextInt();
			switch (selection) {

			case 1:
				System.out.println("Enter Address book name");
				String name = scanner.next();
				if (addressbook.containsKey(name)) {
					System.out.println("Entered addressbook name already present");
				} else {
					EditContactInAddressBook address = new EditContactInAddressBook();
					address.equals(name);
					System.out.println("Welcome to addressbook" + name);
					addressbook.put(name, address);
				}
				break;

			case 2:
				System.out.println("Exiting");
				System.exit(0);
			}
		}
	}
		//main method
	public static void main(String[] args) {
		MultipleAddressBook multiplebook = new MultipleAddressBook();
		System.out.println("Welcome to the address book system");
		multiplebook.addMultipleAddressBook();

	}

}
