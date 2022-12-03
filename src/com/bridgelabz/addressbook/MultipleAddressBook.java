package com.bridgelabz.addressbook;

/*
 * UC - 6 Refactor to add multiple Address Book to the System. Each Address Book
has a unique Name.
 */
import java.util.HashMap;
import java.util.Scanner;

public class MultipleAddressBook {
	static Scanner scanner = new Scanner(System.in);
	// Here used hashmap it gives the key value pair.
	HashMap<String, AddressBook> addressbook = new HashMap<>();

	// create method for add multiple addressbook.
	public void addMultipleAddressBook() {
		while (true) {

			System.out.println("Enter selection \n1)To Access Address Book\n2)exit");
			int selection = scanner.nextInt();

			switch (selection) {
			// In this case check addressbook name present or not.
			case 1:
				String name = scanner.next();
				if (addressbook.containsKey(name)) {
					System.out.println("Entered Addressbook name already present");
				} else {
					AddressBook address = new AddressBook();
					System.out.println("Welcome To Addressbook " + name);
					addressbook.put(name, address);

				}
				break;

			case 2:
				System.out.println("exiting");
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		// object of a class create.
		MultipleAddressBook multiplebook = new MultipleAddressBook();
		// method calling
		multiplebook.addMultipleAddressBook();

	}

}
