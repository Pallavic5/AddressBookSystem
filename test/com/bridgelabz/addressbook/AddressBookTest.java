package com.bridgelabz.addressbook;
/*
 * Problem Statement :Ability to Add new Contact to the Address Book Database
 */
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bridgelabz.addressbook.AddressBookService.IOService;

public class AddressBookTest {
	private static AddressBookService addressBookService;

	@BeforeClass
	public static void createAddressBookObj() {
		addressBookService = new AddressBookService();
		System.out.println("Welcome to the Address Book System");
	}

	@Test
	public void givenAddressBookDetails_WhenRetrieved_ShouldMachPersonsCount() throws AddressBookException {
		List<ContactDetails> list = addressBookService.readAddressBookData(IOService.DB_IO);
		Assert.assertEquals(2, list.size());
	}

	@Test
	public void givenAddressBookDetails_WhenUpdated_ShouldSyncWithDB() throws AddressBookException {
		List<ContactDetails> data = addressBookService.readAddressBookData(IOService.DB_IO);
		addressBookService.updateDBRecord("Pallavi", "Chedge");
		boolean result = addressBookService.checkUpdatedRecordSyncWithDatabase("Pallavi");
		Assert.assertEquals(true, result);
	}

	@Test
	public void givenAddressBookDetails_WhenRetrieved_ForGivenRange_ShouldMatchPersonsCount() throws AddressBookException {
		List<ContactDetails> list = addressBookService.readAddressBookData(IOService.DB_IO, "2020-11-01", "2020-11-22");
		Assert.assertEquals(2, list.size());
	}

	@Test
	public void givenAddressBookDetails_WhenRetrieved_ShouldReturnTotalNumberOfContacts() throws AddressBookException {
		Assert.assertEquals(1, addressBookService.readAddressBookData("Count", "PQR"));
	}

	@Test
	public void givenAddressBookDetails_WhenaddedNewcontact_ShouldSyncWithDB() throws AddressBookException {
		addressBookService.readAddressBookData(IOService.DB_IO);
		addressBookService.addNewContact("Pallavi", "Chedge", "Lakewood", "Pune", "Maharashtra", "3890456", "91 9087654563",
				"pc@gmail.com");
		boolean result = addressBookService.checkUpdatedRecordSyncWithDatabase("Manju");
		Assert.assertEquals(true, result);
	}

	@Test
	public void givenPersons_WhenAddedToDBUsingThread_ShouldMatchNumOfEntries() throws AddressBookException {
		ContactDetails[] arrayOfContacts = {
				new ContactDetails("Swati", "Verma", "Nova", "Nagpur", "Maharashtra", "345789", "91 7685674563", "swati@gmail.com"),
				new ContactDetails("Pranali", "Punewar", "IrisCourt", "Pune", "Maharashtra", "585001", "91 8707562341", "pranali@gmail.com") };
		addressBookService.readAddressBookData(IOService.DB_IO);
		Instant start = Instant.now();
		addressBookService.addMultipleContacts(Arrays.asList(arrayOfContacts));
		Instant end = Instant.now();
		System.out.println("Duration with thread: " + Duration.between(start, end));
		Assert.assertEquals(3, addressBookService.countEntries(IOService.DB_IO));
	}
}
