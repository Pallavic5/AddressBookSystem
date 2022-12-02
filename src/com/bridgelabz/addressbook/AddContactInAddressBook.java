package com.bridgelabz.addressbook;

/*
 * UC - 2 Ability to add a new Contact to Address Book.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddContactInAddressBook {

	public static void main(String[] args) {
		System.out.println("Welcome to the Address Book System");
		List<ContactDetails> arraylist = new ArrayList();	//Use arraylist to save the contactdetails
		Scanner scanner = new Scanner(System.in);			//This Scanner class is used for take integer value from user.
		Scanner reader = new Scanner(System.in);			//This Scanner class is used for take string value from user.

		int choice;
		//infinite loop
		do {
			System.out.println("1.INSERT");
			System.out.println("2.DISPLAY");
			System.out.println("Enter your choice");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
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
				ContactDetails contactdetails = new ContactDetails(firstName, lastName, address, city, state, zipcode,
						phoneNo, email);
				arraylist.add(contactdetails);
				break;
			case 2:
				System.out.println(arraylist);
				break;
			}
		} while (choice != 0);

		System.out.println("Invalid Choice!!!");

		scanner.close();
		reader.close();

	}

}
