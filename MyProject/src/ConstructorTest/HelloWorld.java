package ConstructorTest;

import java.util.Scanner;

public class HelloWorld {

	String name; // instance: copy of var for each instance/object of the class
	public static String MyMaidenName = "Divya"; // Static:belongs to class
	public static final String MyLocation = "Chennai"; // Static Final : cannot change value

	// --------------------------------------------------------------
	public HelloWorld() {
		System.out.println("Hello World!");
	}

	public HelloWorld(String name) {
		this(); // if there is a call to default constructor, then it must be first statement
		this.name = name;
		System.out.println("Hello " + name);
	}
	// --------------------------------------------------------------

	public void checkPrintf() {
		// TODO - learn printf method; why only obj[] is expected
		// Object[] i = {'10'};
		// float a = 12.653f;
		// System.out.printf("first part:%4.2f \n", a);
	}

	public static String ScannerTest() {
		// Get user input
		System.out.println("Enter value:");
		Scanner inputStream = new Scanner(System.in);
		String userInput = inputStream.nextLine();
		inputStream.close(); // Stream has to be closed
		return userInput;
	}

	// --------------------------------------------------------------
	// STATIC & FINAL
	public static String GetMaidenName() {
		// name = ""; //Wont work - instance var cannot be used within static method
		return MyMaidenName; // Static var can be accessed only from static method
	}

	public void setName(String newName) {
		// this.name = name; //if both instance & local var name are same, then use
		// 'this'
		name = newName; // This word is not reqd if var name is different
		MyMaidenName = newName; // Static var can be used from within an instance method

	}

	public String getLocation() {
		// MyLocation = "Mumbai"; //Wont work - final var cannot be assigned again

		return MyLocation;
	}

	// --------------------------------------------------------------
	// ARRAYS
	public void arrayTest() {
		int value = 10; // stores value

		int[] values = { 10, 20, 30 }; // reference var
		int[] newValues = new int[3];

		System.out.println(value); // gives value
		System.out.println(values); // gives ref to mem location of 'values'
		System.out.println(newValues[0]); // all values are auto initialized to 0

		newValues[0] = 10;
		System.out.println(newValues[0] + ":" + newValues[1] + ":" + newValues[2]);

	}

	// --------------------------------------------------------------
	public static void main(String[] args) {
		String userInput = ScannerTest();
		HelloWorld hwVar = new HelloWorld(userInput); // Call Constructor

		String name = GetMaidenName();
		System.out.println("MyMaidenName original::" + name);
		hwVar.setName("Divya K");
		System.out.println("MyMaidenName after new::" + MyMaidenName);
		System.out.println("MyLocation::" + MyLocation);

		hwVar.arrayTest();
	}

}
