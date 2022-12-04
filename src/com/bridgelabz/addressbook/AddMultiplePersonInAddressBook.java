package com.bridgelabz.addressbook;
/*
 * UC - 1 Ability to add multiple person to Address Book.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddMultiplePersonInAddressBook {
	// Here used collection framework i.e List and Arraylist to save multiple person
	// details.
	List<ContactDetails> arraylist = new ArrayList<ContactDetails>();
	static Scanner scanner = new Scanner(System.in); // This Scanner class is used for take integer value from user.
	static Scanner reader = new Scanner(System.in); // This Scanner class is used for take string value from user.
	// Add details
	public void newContact() {
		System.out.print("Enter First Name: ");
		String firstName = reader.nextLine();
		System.out.print("Enter last Name: ");
		String lastName = reader.nextLine();
		System.out.print("Enter your address: ");
		String address = reader.nextLine();
		System.out.print("Enter your city: ");
		String city = reader.nextLine();
		System.out.print("Enter your state: ");
		String state = reader.nextLine();
		System.out.print("Enter zip code : ");
		int zipcode = scanner.nextInt();
		System.out.print("Enter phone number: ");
		String phoneNo = reader.nextLine();
		System.out.print("Enter your email: ");
		String email = reader.nextLine();
		System.out.println("Added Successfully");
		ContactDetails contactdetails = new ContactDetails(firstName, lastName, address, city, state, zipcode, phoneNo,
				email);
		arraylist.add(contactdetails);
	}
	// View Person List
	public void viewPerson() {
		for (ContactDetails person : arraylist) {
			System.out.println(person);
		}
	}
	// main function
	public static void main(String[] args) {
		// instance of AddMultiplePersonInAddressBook
		AddMultiplePersonInAddressBook multipleperson = new AddMultiplePersonInAddressBook();
		int choice;
		// infinite loop
		do {
			System.out.println("1.ADD PERSON");
			System.out.println("2.DISPLAY");
			System.out.println("Enter your choice");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter number of persons you want to add: ");
				// taking input from user for person count.
				int person_count = scanner.nextInt();
				for (int i = 0; i < person_count; i++) {
					multipleperson.newContact();
				}
				break;
			case 2:
				System.out.println("Display Multiple Person Details.");
				multipleperson.viewPerson();
				break;
			}
		} while (choice != 0);

		System.out.println("Invalid Choice!!!");

		scanner.close();
		reader.close();
	}

}
