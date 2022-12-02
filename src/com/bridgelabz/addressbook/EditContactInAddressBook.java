package com.bridgelabz.addressbook;
/*UC-3
 * Ability to edit existing contact person using their name
 */
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class EditContactInAddressBook {

	public static void main(String[] args) {
		System.out.println("Welcome to the address book system");
		List<ContactDetails> arraylist = new ArrayList(); // Use arraylist to save the contactdetails
		Scanner scanner = new Scanner(System.in); // This Scanner class is used for take integer value from user.
		Scanner reader = new Scanner(System.in); // This Scanner class is used for take string value from user.

		int choice;
		// infinite loop
		do {
			System.out.println("1.INSERT");
			System.out.println("2.DISPLAY");
			System.out.println("3.EDIT");
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

			case 3:
				boolean found = false;
				System.out.println("Enter first name of the person for update ");
				String firstNameNew = reader.nextLine();
				System.out.println("------------------------------------");
				// Use Iterator for traversing the list.
				ListIterator<ContactDetails> listIterator = arraylist.listIterator();

				while (listIterator.hasNext()) {
					contactdetails = listIterator.next();
					// put condition for check the name is existing or not in the list.
					if (contactdetails.getFirstName().equals(firstNameNew)) {
						System.out.print("Enter new first Name: ");
						firstNameNew = reader.nextLine();
						System.out.print("Enter new last Name: ");
						lastName = reader.nextLine();
						System.out.print("Enter your new address: ");
						address = reader.nextLine();
						System.out.print("Enter your new city: ");
						city = reader.nextLine();
						System.out.print("Enter your state: ");
						state = reader.nextLine();
						System.out.print("Enter zip code : ");
						zipcode = scanner.nextInt();
						System.out.print("Enter phone number: ");
						phoneNo = reader.nextLine();
						System.out.print("Enter your email: ");
						email = reader.nextLine();
						listIterator.set(new ContactDetails(firstNameNew, lastName, address, city, state, zipcode,
								phoneNo, email));
						found = true;
					}
				}
				System.out.println("_____________________________________");
				// if record not found then this if condition get in the output.
				if (!found) {
					System.out.println("Record not found");
				} else {
					System.out.println("Record is updated successfully");
				}
				System.out.println("_______________________________________");
				break;
			default:
				System.out.println("default");

			}
		} while (choice != 0);

		System.out.println("Invalid Choice!!!");
		scanner.close();
		reader.close();
	}

}
