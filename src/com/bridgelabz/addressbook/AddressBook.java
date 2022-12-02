package com.bridgelabz.addressbook;
/*UC - 1
 * Able to create a contact.
 */
public class AddressBook {

	public static void main(String[] args) {

		System.out.println("Welcome to Address Book Programs");
		// put the values using parameterized constructor
		ContactDetails contactdetails = new ContactDetails("Pallavi", "Chedge", "World City", "Mumbai", "Maharashtra",
				603562, "7778903421", "pp@gmail.com");
		System.out.println(contactdetails);

	}

}
