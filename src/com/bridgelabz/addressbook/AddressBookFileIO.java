package com.bridgelabz.addressbook;
/*
 * ProblemStatement - UC13 Ability to Read or Write the Address Book with Persons Contact into aFile using File IO
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AddressBookFileIO {
	
	public static String address_DATA_FILE_PATH = "src/static/Addressbook.txt";
	
	// method create for create text file into the folder.
	public void createTextFile() {
		File fileObj = new File("src/static/Addressbook.txt");
		try {
			fileObj.createNewFile();
			System.out.println("Addressbook Text File Created!!!");
		} catch (IOException e) {
			System.out.print(e);
		}
	}
	// method for writeintofile
	/*
	 * The flush() method of Writer Class in Java is used to flush the writer. 
	 * By flushing the writer, it means to clear the writer of any element that may be or maybe not inside the writer. 
	 * It neither accepts any parameter nor returns any value.
	 */
	public void writeInToFile() throws IOException {
		String message = "This is a AddressBook File.";
		FileWriter fr = new FileWriter("src/static/Addressbook.txt", true);
		fr.write(message);
		fr.flush();
		fr.close();
		System.out.println("Done!!!");
	}
	// method for readintofile
	public void readFromFile() throws IOException {
		File file = new File("src/static/Addressbook.txt");
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String message = scanner.nextLine();
				System.out.println(message);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}
	// main method
	public static void main(String[] args) throws IOException {
		AddressBookFileIO file = new AddressBookFileIO();
		file.createTextFile();
		file.writeInToFile();
		file.readFromFile();
	}
}
