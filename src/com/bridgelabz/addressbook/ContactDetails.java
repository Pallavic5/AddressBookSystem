package com.bridgelabz.addressbook;
/*UC - 1
 * Ability to create a Contacts in Address Book with first and last names, address, city, state, zip, phone number 
 * and email...
 * Here I created a POJO class
 * POJO - It stands for Plain old java object.
 */
public class ContactDetails {
	// variables
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zipcode;
	private String phoneNumber;
	private String email;
	// create default constructor
	public ContactDetails() {
		super();
	}	
	// create parameterized constructor
	public ContactDetails(String firstName, String lastName, String address, String city, String state, String zipcode,
			String phoneNumber, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	// create getter and setter methods
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getphoneNumber() {
		return phoneNumber;
	}

	public void setphoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// override toString method
	@Override
	public String toString() {
		return "ContactDetails [FirstName = " + firstName + ", LastName = " + lastName + ", Address = " + address
				+ ", City = " + city + ", Zipcode = " + zipcode + ", State = " + state + ", PhoneNo = " + phoneNumber
				+ ", Email = " + email + "]";
	}
	//override equals method
	@Override
	  public boolean equals(Object object) {
	    ContactDetails contact = (ContactDetails) object;
	    return this.getFirstName().equalsIgnoreCase(contact.firstName);
	  }
}
