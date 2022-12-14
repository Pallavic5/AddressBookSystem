package com.bridgelabz.addressbook;
/*
 * Problem Statement:UC 12 Ability to sort the entries in the address book by City, State, or Zip 
 * - Write functions to sort person by City, State or Zip 
 * - Use Collection Library for Sorting - Use Java Streams
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome To AddressBook System");
		HashMap<String, AddressBookMain> addressBookList = new HashMap<>();
		Scanner scanner = new Scanner(System.in);
		AddressBookMain main = new AddressBookMain();
		while (true) {
			System.out.println("1Add Contact \n2. Display Contact \n3. Edit Contact \n4. Delete Contact \n5.Add New Address Book"
							+ "\n6.Display Existing Addressbook \n7.Display Address books \n8.Search\n9.ViewPersons\n10.CountPerson\n11.SortByPerson's Name\n12.SortByCity/State/Zipcode\n13.Exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the address book name to add contact: ");
				String addressBookName = scanner.next();
				if (!addressBookList.containsKey(addressBookName)) {
					System.out.println("Address book not exists!");
				} else {
					main = addressBookList.get(addressBookName);
					main.addContact();
				}
				break;
			case 2:
				System.out.println("Enter the address book name to display contacts: ");
				String addressBookNameFirst = scanner.next();
				if (!addressBookList.containsKey(addressBookNameFirst)) {
					System.out.println("Address book not exists!");
				} else {
					main = addressBookList.get(addressBookNameFirst);
					main.addContact();
				}
				break;
			case 3:
				System.out.println("Enter the address book name to edit contacts: ");
				String addressBookNameSecond = scanner.next();
				if (!addressBookList.containsKey(addressBookNameSecond)) {
					System.out.println("Address book not exists!");
				} else {
					main = addressBookList.get(addressBookNameSecond);
					main.editContact();
				}
				break;
			case 4:
				System.out.println("Enter the address book name to edit contacts: ");
				String addressBookNameThird = scanner.next();
				if (!addressBookList.containsKey(addressBookNameThird)) {
					System.out.println("Address book not exists!");
				} else {
					main = addressBookList.get(addressBookNameThird);
					main.deletePerson();
				}
				break;
			case 5:
				System.out.println("Enter the address book name : ");
				String name = scanner.next();
				if (addressBookList.containsKey(name)) {
					System.out.println("Address book already exists!");
				} else {
					addressBookList.put(name, main);
				}
				break;
			case 6:
				Set<String> keys = addressBookList.keySet();
				if (keys.isEmpty()) {
					System.out.println("There is no address books available!");
				}
				for (String str : keys) {
					System.out.print(str + " ");
				}
				System.out.println();
				break;
			case 7:
				Set<Map.Entry<String, AddressBookMain>> addressBook = addressBookList.entrySet();
				if (addressBook.isEmpty()) {
					System.out.println("There is no address books available!");
				}
				for (Map.Entry entry : addressBook) {
					System.out.println(entry.getKey());
					main = (AddressBookMain) entry.getValue();
					main.displayContactDetails();
				}
				break;
			case 8:
				System.out.println("Search By City or State");
				Set<Map.Entry<String, AddressBookMain>> addressBookNew = addressBookList.entrySet();
				System.out.println("Enter city or state : ");
				String userDetails = scanner.next();
				if (addressBookNew.isEmpty()) {
					System.out.println("No address books available!");
				}
				for (Map.Entry entry : addressBookNew) {
					System.out.println(entry.getKey());
					main = (AddressBookMain) entry.getValue();
					main.searchByCityOrState(userDetails);
				}
				break;
			case 9:
				System.out.println("1.View Persons By City");
				System.out.println("2.View Persons By State");
				int result = scanner.nextInt();
				switch (result) {
				case 1:
					System.out.println("Enter city :");
					String city = scanner.next();
					main.viewPersonsByCity(addressBookList, city);
					break;
				case 2:
					System.out.println("Enter state :");
					String state = scanner.next();
					main.viewPersonsByState(addressBookList, state);
					break;
				}
				break;
			case 10:
				System.out.println("1.Count Persons By City");
				System.out.println("2.Count Persons By State");
				int input = scanner.nextInt();
				switch (input) {
				case 1:
					System.out.println("Enter city :");
					String city = scanner.next();
					main.getCountOfPersonByCity(addressBookList, city);
					break;
				case 2:
					System.out.println("Enter state :");
					String state = scanner.next();
					main.getCountOfPersonByCity(addressBookList, state);
					break;
				}
			case 11:
				main.sortByPersonsName(addressBookList);
				break;
			case 12:
				System.out.println("1.Sort By City");
				System.out.println("2.Sort By State");
				System.out.println("3.Sort By Zipcode");
                int sort = scanner.nextInt();
                switch (sort){
                    case 1:
                        AddressBookMain.sortByCity(addressBookList);
                        break;
                    case 2:
                        AddressBookMain.sortByState(addressBookList);
                        break;
                    case 3:
                        AddressBookMain.sortByZipcode(addressBookList);
                        break;
                }
			case 13:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice");
			}

		}
	}
}
