package com.bridgelabz.addressbook;
/*
 * Problem Statement :Ability to Add new Contact to the Address Book Database
 */
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDBService {

	private static List<ContactDetails> addressBookData = new ArrayList<>();
	private PreparedStatement addressBookPreparedStatement;
	private static AddressBookDBService addressBookDBService;

	public static AddressBookDBService getInstance() {
		if (addressBookDBService == null)
			addressBookDBService = new AddressBookDBService();
		return addressBookDBService;
	}

	private Connection getConnection() throws SQLException {

			try {
				/*
				 * load driver class
				 */
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver loaded...");
				/*
				 * Make Connection
				 */
				String DataBaseName = "addressbookservice";
				String URL = "jdbc:mysql://localhost:3306/" + DataBaseName;
				String DataBaseUserName = "root";
				String dbPass = "admin";
				Connection connection = DriverManager.getConnection(URL, DataBaseUserName, dbPass);
				System.out.println("Successfull Connection with " + DataBaseName + "....");
				connection.close();
			} catch (ClassNotFoundException e) {
				System.out.println(e);
			} catch (SQLException e) {
				System.out.println(e);
			}
			return getConnection();

	}

	public List<ContactDetails> readData() throws AddressBookException {
		String query = null;
		query = "select * from addressbook";
		return getAddressBookDataUsingDatabase(query);
	}

	private List<ContactDetails> getAddressBookDataUsingDatabase(String query) throws AddressBookException {
		try (Connection con = this.getConnection();) {
			Statement statement = (Statement) con.createStatement();
			ResultSet resultSet = ((java.sql.Statement) statement).executeQuery(query);
			addressBookData = this.getAddressBookDetails(resultSet);
		} catch (SQLException e) {
			throw new AddressBookException(e.getMessage(), AddressBookException.ExceptionType.ConnectionFailed);
		}
		return addressBookData;
	}

	private List<ContactDetails> getAddressBookDetails(ResultSet resultSet) throws AddressBookException {
		try {
			while (resultSet.next()) {
				String firstName = resultSet.getString("FirstName");
				String lastName = resultSet.getString("LastName");
				String address = resultSet.getString("Address");
				String city = resultSet.getString("City");
				String state = resultSet.getString("State");
				String zipCode = resultSet.getString("Zip");
				String phoneNumber = resultSet.getString("PhoneNumber");
				String email = resultSet.getString("Email");
				addressBookData.add(
						new ContactDetails(firstName, lastName, address, city, state, zipCode, phoneNumber, email));
			}
		} catch (SQLException e) {
			throw new AddressBookException(e.getMessage(), AddressBookException.ExceptionType.DatabaseException);
		}
		return addressBookData;
	}

	public int updateAddressBookData(String firstName, String address) throws AddressBookException {
		try (Connection connection = this.getConnection()) {
			String query = String.format("update addressbook set Address = '%s' where FirstName = '%s';", address,
					firstName);
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			return preparedStatement.executeUpdate(query);
		} catch (SQLException e) {
			throw new AddressBookException(e.getMessage(), AddressBookException.ExceptionType.ConnectionFailed);
		}
	}

	public List<ContactDetails> getAddressBookData(String firstName) throws AddressBookException {
		if (this.addressBookPreparedStatement == null)
			this.prepareAddressBookStatement();
		try {
			addressBookPreparedStatement.setString(1, firstName);
			ResultSet resultSet = addressBookPreparedStatement.executeQuery();
			addressBookData = this.getAddressBookDetails(resultSet);
		} catch (SQLException e) {
			throw new AddressBookException(e.getMessage(), AddressBookException.ExceptionType.ConnectionFailed);
		}
		System.out.println(addressBookData);
		return addressBookData;
	}

	private void prepareAddressBookStatement() throws AddressBookException {
		try {
			Connection connection = this.getConnection();
			String query = "select * from addressbook where FirstName = ?";
			addressBookPreparedStatement = connection.prepareStatement(query);
		} catch (SQLException e) {
			throw new AddressBookException(e.getMessage(), AddressBookException.ExceptionType.DatabaseException);
		}
	}

	public List<ContactDetails> readData(LocalDate start, LocalDate end) throws AddressBookException {
		String query = null;
		if (start != null)
			query = String.format("select * from addressbook where startdate between '%s' and '%s';", start, end);
		if (start == null)
			query = "select * from addressbook";
		List<ContactDetails> addressBookList = new ArrayList<>();
		try (Connection connection = this.getConnection();) {
			Statement statement = (Statement) connection.createStatement();
			ResultSet resultSet = ((java.sql.Statement) statement).executeQuery(query);
			addressBookList = this.getAddressBookDetails(resultSet);
		} catch (SQLException e) {
			throw new AddressBookException(e.getMessage(), AddressBookException.ExceptionType.DatabaseException);
		}
		return addressBookList;
	}

	public int readDataFromAddressBook(String count, String city) throws AddressBookException {
		int noOfContacts = 0;
		String query = String.format("select %s(state) from addressbook where city = '%s' group by city;", count, city);
		try (Connection connection = this.getConnection()) {
			Statement statement = (Statement) connection.createStatement();
			ResultSet resultSet = ((java.sql.Statement) statement).executeQuery(query);
			resultSet.next();
			noOfContacts = resultSet.getInt(1);
		} catch (SQLException e) {
			throw new AddressBookException(e.getMessage(), AddressBookException.ExceptionType.DatabaseException);
		}
		return noOfContacts;
	}

	public ContactDetails addNewContact(String firstName, String lastName, String address, String city, String state,
			String zip, String phno, String emailId) throws AddressBookException {
		int personId = -1;
		ContactDetails personData = null;
		String query = String.format(
				"insert into addressbook(FirstName, LastName, Address, City, State, Zip, PhoneNumber, Email) values"
						+ "('%s', '%s', '%s', '%s', '%s','%s', '%s', '%s')",
				firstName, lastName, address, city, state, zip, phno, emailId);
		try (Connection connection = this.getConnection()) {
			Statement statement = (Statement) connection.createStatement();
			int rowAffected = statement.executeUpdate(query, statement.RETURN_GENERATED_KEYS);
			if (rowAffected == 1) {
				ResultSet resultSet = ((java.sql.Statement) statement).getGeneratedKeys();
				if (resultSet.next())
					personId = resultSet.getInt(1);
			}
			personData = new ContactDetails(firstName, lastName, address, city, state, zip, phno, emailId);
		} catch (SQLException e) {
			throw new AddressBookException(e.getMessage(), AddressBookException.ExceptionType.DatabaseException);
		}
		return personData;
	}

}
