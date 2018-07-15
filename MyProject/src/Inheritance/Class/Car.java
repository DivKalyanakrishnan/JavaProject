package Inheritance.Class;

/*
 * child class - override 
 * */
public class Car extends Vehicle {

	// @Override

	// 1. Cannot reduce visibility
	public void start() {

		super.start();

		System.out.println("car is also started.");
	}

	// Over-loading : a. different args count b. diff args type
	private void status() {

		System.out.println("car is currently running");
	}

	private void status(String type) {

		System.out.println("car is currently running on a " + type + " start");
	}

	// 3. Cannot implement super.stop() , as stop() is private

	// 5. Own Methods
	private void carStop() {
		System.out.println("Car stopped");
	}

	private void showInfo() {
		System.out.println(mcName);
	}

	public static void main(String[] args) {
		Car car1 = new Car();

		// over-ridden method
		car1.start();

		// OverLoading
		car1.status();
		car1.status("cold");

		// local methods
		car1.showInfo();
		car1.carStop();

	}

}
