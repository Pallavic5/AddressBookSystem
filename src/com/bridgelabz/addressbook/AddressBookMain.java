package com.bridgelabz.addressbook;
/*
 * Problem Statement -UC 8 Ability to search Person in a City or State across the multiple AddressBook 
 * - Search Result can show multiple person in the city or state
- Use Java Streams
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBookMain {
	private static final HashMap<String, AddressBookMain> addressBookList = null;
	static Scanner scanner = new Scanner(System.in);
	List<ContactDetails> arraylist = new ArrayList<ContactDetails>(); // Use arraylist to save the contactdetails
	/*
	 * create method to add new contact in addressbook Apply regex on Addressbook
	 * details.
	 */

	public void addContact() {
		ContactDetails contact = new ContactDetails();
		System.out.println("Enter First Name: ");
		String firstName = scanner.next();
		contact.setFirstName(AddressBookDetailsRegex.isValidFirstName(firstName));

		System.out.println("Enter Last Name: ");
		String lastName = scanner.next();
		contact.setLastName(AddressBookDetailsRegex.isValidLastName(lastName));

		System.out.println("Enter Address: ");
		String address = scanner.next();
		contact.setAddress(AddressBookDetailsRegex.isValidAddress(address));

		System.out.println("Enter Your City Name : ");
		String city = scanner.next();
		contact.setCity(AddressBookDetailsRegex.isValidCityName(city));

		System.out.println("Enter Your State Name: ");
		String state = scanner.next();
		contact.setState(AddressBookDetailsRegex.isValidStateName(state));

		System.out.println("Enter Zip Code: ");
		String zip = scanner.next();
		contact.setZipcode(AddressBookDetailsRegex.isValidZipCode(zip));

		System.out.println("Enter Phone Number: ");
		scanner.nextLine();
		String phoneNumber = scanner.nextLine();
		contact.setphoneNumber(AddressBookDetailsRegex.isValidMobileNumber(phoneNumber));

		System.out.println("Enter Your Email: ");
		String email = scanner.nextLine();
		contact.setEmail(AddressBookDetailsRegex.isValidEmail(email));

		/*
		 * check duplicate entries
		 */
		contact.getFirstName().equals(firstName);
		if (!isUnique(contact)) {
			System.out.println("Sorry this contact already exists.");
			return;
		}
		try {
			contact.getFirstName();
			arraylist.add(contact);
		} catch (InputMismatchException e) {
			System.out.println("Enter a numeric value for zip code and phone number next time.");
		}
		System.out.println("Contact has been saved successfully.");
	}

	// create method to edit contact in addressbook
	public void editContact() {
		System.out.println("Enter name to Edit");
		String name = scanner.next();

		for (int i = 0; i < arraylist.size(); i++) {
			ContactDetails update = (ContactDetails) arraylist.get(i);

			if (name.equals(update.getFirstName())) {
				System.out.print(
						"Enter what you want to update(\n1.First name\n2. Last name\n3. Address\n4. State\n5. Phone\n6. Zipcode\n7. Email): ");
				int choice = scanner.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter your first name to update: ");
					String firstName = scanner.next();
					update.setFirstName(AddressBookDetailsRegex.isValidFirstName(firstName));
					break;
				case 2:
					System.out.println("Enter your last name to update:");
					String lastName = scanner.next();
					update.setLastName(AddressBookDetailsRegex.isValidLastName(lastName));
					break;
				case 3:
					System.out.println("Enter your address to update:");
					String address = scanner.next();
					update.setCity(AddressBookDetailsRegex.isValidAddress(address));
					break;
				case 4:
					System.out.println("Enter your city name to update:");
					String city = scanner.next();
					update.setCity(AddressBookDetailsRegex.isValidCityName(city));
					break;
				case 5:
					System.out.println("Enter your state name to update:");
					String state = scanner.next();
					update.setState(AddressBookDetailsRegex.isValidStateName(state));
					break;
				case 6:
					System.out.println("Enter your zipcode to update:");
					String zip = scanner.next();
					update.setZipcode(AddressBookDetailsRegex.isValidZipCode(zip));
					break;
				case 7:
					System.out.println("Enter Your phone number to update:");
					String phoneNumber = scanner.next();
					update.setphoneNumber(AddressBookDetailsRegex.isValidMobileNumber(phoneNumber));
					break;
				case 8:
					System.out.println("Enter Your email to update:");
					String email = scanner.next();
					update.setEmail(AddressBookDetailsRegex.isValidEmail(email));
					break;
				default:
					System.out.println("invalid choice");
					break;
				}
				System.out.println("Contacts Edited Successfully\n" + arraylist);
			}
		}
	}

	// create method to delete contact from addressbook
	public void deletePerson() {
		System.out.println("Enter name to Delete");
		String name = scanner.next();

		for (int i = 0; i < arraylist.size(); i++) {
			ContactDetails details = (ContactDetails) arraylist.get(i);
			if (name.equals(details.getFirstName())) {
				arraylist.remove(i);
				System.out.println("Contacts deleted Successfully\n" + arraylist);
			}
		}
	}

	// create method to display addressbook details
	public void displayContactDetails() {
		for (ContactDetails result : arraylist) {
			System.out.println(result);
		}
	}

	// create method for check duplicate entries using Java Stream.
	public boolean isUnique(ContactDetails contact) {
		return !arraylist.stream().anyMatch(personContact -> personContact.equals(contact));
	}

	// create search method to search by city or search by state
	public void search(HashMap<String, AddressBookMain> addressBookList) {
		if (addressBookList.size() < 1) {
			System.out.println("The addressbook list is empty, please aDD a few contacts for search.");
			return;
		}
		String choice = "";
		do {
			System.out.print("\nSearch Menu \n1. Search by city \n2. Search by state \n3. Quit \nEnter your choice: ");
			choice = scanner.nextLine().trim().toLowerCase();
			switch (choice) {
			case "1":
			case "city":
				searchByCity(addressBookList);
				break;

			case "2":
			case "state":
				searchByState(addressBookList);
				break;

			case "3":
			case "quit":
				choice = "quit";
				System.out.println("quitting search menu...");
				break;

			default:
				System.out.println("Invalid Match, try again");
				break;
			}
		} while (!choice.equals("quit"));
	}

	public void searchByCity(HashMap<String, AddressBookMain> addressBookList) {
		System.out.print("Enter the city to search people in: ");
		String cityToSearch = scanner.nextLine();
		List<String> peopleOfThatCity = new ArrayList<>();
		for (Map.Entry<String, AddressBookMain> addressBook : addressBookList.entrySet()) {
			List<String> matchedPeople = addressBook.getValue().arraylist.stream()
					.filter(contact -> contact.getCity().equalsIgnoreCase(cityToSearch))
					.map(c -> c.getFirstName() + " " + c.getLastName()).collect(Collectors.toList());
			peopleOfThatCity.addAll(matchedPeople);
		}
		if (peopleOfThatCity.size() > 0)
			System.out.println("people from '" + cityToSearch + "' city are: " + peopleOfThatCity);
		else
			System.out.println("we couldnt find any people from '" + cityToSearch + "' city in the addressbook list.");
	}

	public void searchByState(HashMap<String, AddressBookMain> addressBookList) {
		System.out.print("Enter the state to search people in: ");
		String stateToSearch = scanner.nextLine();
		List<String> peopleOfThatState = new ArrayList<>();

		for (Map.Entry<String, AddressBookMain> addressBook : addressBookList.entrySet()) {
			List<String> matchedPeople = addressBook.getValue().arraylist.stream()
					.filter(contact -> contact.getState().equalsIgnoreCase(stateToSearch))
					.map(c -> c.getFirstName() + " " + c.getLastName()).collect(Collectors.toList());

			peopleOfThatState.addAll(matchedPeople);
		}

		if (peopleOfThatState.size() > 0)
			System.out.println("people from '" + stateToSearch + "' state are: " + peopleOfThatState);
		else
			System.out
					.println("we couldnt find any people from '" + stateToSearch + "' state in the addressbook list.");
	}

	// main method
	public static void main(String[] args) {
		AddressBookMain personDetail = new AddressBookMain();
		System.out.println("Welcome To AddressBook System.");
		int choice;
		// infinite loop
		do {
			System.out.println("1.INSERT");
			System.out.println("2.EDIT");
			System.out.println("3.DELETE");
			System.out.println("4.DISPLAY");
			System.out.println("5.Search By City Or State");
			System.out.println("6.Exit");
			System.out.println("Enter your choice");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter Number of Address book you want to add :");
				int addressbook_count = scanner.nextInt();
				for (int i = 0; i < addressbook_count; i++) {
					System.out.println("Enter the address book number");
					int number = scanner.nextInt();
					System.out.printf("Welcome to Address-book_%d\n", number);
					System.out.println("Enter Number of persons you want to add :");
					int personCount = scanner.nextInt();
					for (int j = 0; j < personCount; j++) {
						personDetail.addContact();
					}
				}
				break;
			case 2:
				personDetail.editContact();
				break;
			case 3:
				personDetail.deletePerson();
				break;
			case 4:
				personDetail.displayContactDetails();
				break;
			case 5:
				personDetail.search(addressBookList);
		        break;
			case 6:
				System.out.println("Exiting from address book");
				System.exit(0);
				break;
			default:
				System.out.println("Select from Menu!!");
			}

		} while (choice != 0);
		System.out.println("Invalid Choice!!!");
	}
}
