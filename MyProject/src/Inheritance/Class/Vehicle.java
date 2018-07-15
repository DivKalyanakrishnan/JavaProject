package Inheritance.Class;
/*
 * super class
 * */
public class Vehicle {

	protected String mcName = "Machine";

	public void start() {
		System.out.println("Machine started.");
	}
	
	
	//private methods are not accessible by child classes; only protected/public are allowed for inheritance.
	//generally : keep var as private / protected; and other methods as public. 
		private void stop() {
		System.out.println("Machine stopped.");
	}

	
	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle();
		vehicle.start();
		vehicle.stop();
	}

}
