package ConstructorTest;

public class TestConstructor {
	String testName;

	/*
	 * void TestConstructor() // assumed as a method if return type is mentioned {
	 * 
	 * } public void Test(HelloWorld hw) { this.testName = hw.name;
	 * System.out.println("Assigning local var to HW var : " + testName); }
	 */
	public static void main(String[] args) {
		HelloWorld hw = new HelloWorld("Gayathri"); // instantiating from another class

		TestConstructor sampleTest = new TestConstructor(); // no Default constructor necessary
		// sampleTest.Test(hw);
		hw.name = sampleTest.testName;

	}

}
