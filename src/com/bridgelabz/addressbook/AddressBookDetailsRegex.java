package com.bridgelabz.addressbook;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 * Apply regex pattern on all userDetails in Addressbook System.
 */
public class AddressBookDetailsRegex {
	static Scanner scanner = new Scanner(System.in);
	static String regex;
	static Pattern pattern;
	static Matcher matcher;

	public static String isValidFirstName(String firstName) {
		regex = "^[A-Z]{1}[a-z]{2,}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(firstName);
		while (!matcher.matches()) {
			System.out.println("Invalid first name, please try again....");
			firstName = scanner.nextLine();
			matcher = pattern.matcher(firstName);
		}
		return firstName;
	}

	public static String isValidLastName(String lastName) {
		regex = "^[A-Z]{1}[a-z]{2,}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(lastName);
		while (!matcher.matches()) {
			System.out.println("Invalid last name, please try again....");
			lastName = scanner.nextLine();
			matcher = pattern.matcher(lastName);
		}
		return lastName;
	}

	public static String isValidAddress(String address) {
		regex = "^[A-Z]{1}[a-z]{2,}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(address);
		while (!matcher.matches()) {
			System.out.println("Invalid address, please try again....");
			address = scanner.nextLine();
			matcher = pattern.matcher(address);
		}
		return address;
	}

	public static String isValidCityName(String city) {
		regex = "^[A-Z]{1}[a-z]{2,}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(city);
		while (!matcher.matches()) {
			System.out.println("Invalid city name, please try again....");
			city = scanner.nextLine();
			matcher = pattern.matcher(city);
		}
		return city;
	}

	public static String isValidStateName(String state) {
		regex = "^[A-Z]{1}[a-z]{2,}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(state);
		while (!matcher.matches()) {
			System.out.println("Invalid state name, please try again....");
			state = scanner.nextLine();
			matcher = pattern.matcher(state);
		}
		return state;
	}

	public static String isValidZipCode(String zipCode) {
		regex = "^[1-9]{1}[0-9]{2}[ ]?[0-9]{3}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(zipCode);
		while (!matcher.matches()) {
			System.out.println("Invalid zipcode, please try again....");
			zipCode = scanner.nextLine();
			matcher = pattern.matcher(zipCode);
		}
		return zipCode;
	}

	public static String isValidMobileNumber(String mobileNumber) {
		regex = "^[0-9]{2} [0-9]{10}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(mobileNumber);
		while (!matcher.matches()) {
			System.out.println("Invalid mobilenumber, please try again....");
			mobileNumber = scanner.nextLine();
			matcher = pattern.matcher(mobileNumber);
		}
		return mobileNumber;
	}

	public static String isValidEmail(String email) {
		regex = "^[a-z]+[+-_.]*[a-z]*[@][a-z]+[.][a-z]{2,4}[.]*([a-z]{2,3})*$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(email);
		while (!matcher.matches()) {
			System.out.println("Invalid email address, please try again....");
			email = scanner.nextLine();
			matcher = pattern.matcher(email);
		}
		return email;
	}

}
