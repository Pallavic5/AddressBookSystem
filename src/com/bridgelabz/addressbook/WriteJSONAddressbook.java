package com.bridgelabz.addressbook;

/*
 * Problem Statement : UC 15 Ability to Read or Write the Address Book with Persons Contact as JSON File.
 */
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class WriteJSONAddressbook {
				//method for create jsonfile
	private static void createJsonFile() throws IOException {
		JSONObject contact = new JSONObject();
		contact.put("firstName", "Pallavi");
		contact.put("lastName", "Chedge");
		contact.put("address", "Lakewood");
		contact.put("city", "Chennai");
		contact.put("state", "TamilNadu");
		contact.put("zipCode", "890765");
		contact.put("phoneNumber", "91 9808766789");
		contact.put("email", "pc@gmail.com");
		System.out.println(contact);

		JSONObject contactNew = new JSONObject();
		contactNew.put("contactDetails", contact);

		JSONObject contactNewObject = new JSONObject();
		contactNewObject.put("firstName", "Priya");
		contactNewObject.put("lastName", "Sharma");
		contactNewObject.put("address", "Nova");
		contactNewObject.put("city", "Pune");
		contactNewObject.put("state", "Maharashtra");
		contactNewObject.put("zipCode", "345678");
		contactNewObject.put("phoneNumber", "91 9989095643");
		contactNewObject.put("email", "priya@gmail.com");
		System.out.println(contactNewObject);

		JSONObject contactNewFirst = new JSONObject();
		contactNewFirst.put("contactDetails", contactNewObject);

		JSONArray contactList = new JSONArray();
		contactList.add(contactNew);
		contactList.add(contactNewFirst);

		try (FileWriter file = new FileWriter("src/static/MyJson.json")) {
			file.write(contactList.toJSONString());
			file.flush();

		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}
			//main method
	public static void main(String[] args) throws IOException {
		createJsonFile();
	}
}
