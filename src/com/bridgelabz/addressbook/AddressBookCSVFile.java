package com.bridgelabz.addressbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class AddressBookCSVFile {

	public static void writeIntoCSVFile() throws FileNotFoundException {
		ContactDetails contact = new ContactDetails("Nirved", "Punewar", "IrisCourt", "Nagpur", "Maharashtra", "897678",
				"91 8908765432", "nirved@gmail.com");
		ContactDetails contactFirst = new ContactDetails("Pallavi", "Chedge", "NovaApartment", "Mumbai", "Maharashtra",
				"340567", "91 9876778882", "pc@gmail.com");
		ContactDetails contactSecond = new ContactDetails("Rahul", "Punewar", "DattaApartment", "Pune", "Maharashtra",
				"917678", "91 8988054322", "rp@gmail.com");

		List<ContactDetails> list = new ArrayList<>();
		File csvFile = new File("src/static/Addressbook.csv");
		PrintWriter printWriter = new PrintWriter(csvFile);
		printWriter.append("FirstName,LastName,Address,City,State,ZipCode,PhoneNumber,Email");
		printWriter.append("\n");

		list.add(contact);
		list.add(contactFirst);
		list.add(contactSecond);
	
		System.out.println();
		for (ContactDetails contactDetails : list) {
			
			printWriter.println(contactDetails.getFirstName() + "," + contactDetails.getLastName() + ","
					+ contactDetails.getAddress() + "," + contactDetails.getCity() + "," + contactDetails.getState()
					+ "," + contactDetails.getZipcode() + "," + contactDetails.getphoneNumber() + ","
					+ contactDetails.getEmail());
			
		}		
		printWriter.close();
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("CSV File Created Successfully!!");
		writeIntoCSVFile();
	}
}
