package Abstraction.Interface;

public class WashingMachine implements IMachine {

	public String nameInSubClass = "WashingMachine";

	public void start() {
	}

	/*
	 * Has to implement ALL methods of Interface public String getName() { return
	 * this.nameInSubClass; }
	 */

	public String getName() {
		return this.nameInSubClass;
	}

	// New Method only defined here
	private void getStatus() {
		System.out.print("washing machine is running");
	}

	public static void main(String[] args) {
		// IMachine machineInterfaceObj = new IMachine(); // Wrong- cant instantiate

		// Another way:
		IMachine imachineObj = new IMachine() {
			// Have to implement all the methods of Interface
			public void start() {
				System.out.println("starting");
			}

			public String getName() {
				String name = "this is IMachine impl inside imachineObj";
				return name;
			}
		};
		imachineObj.start();
		// imachineObj.getName(); //--> need not be called

		IMachine machineInterfaceObj = new WashingMachine();
		System.out.println("Name from Interface  : " + IMachine.nameInInterface);
		System.out.println("Name from Interface obj : " + machineInterfaceObj.nameInInterface);
		// Not advised: has to be accessed in static way

		System.out.println("Subclass method accessed thro interface obj:" + machineInterfaceObj.getName());

		// System.out.println("Private method in Subclass -" +
		// machineInterfaceObj.getStatus());
		// Wrong : Interface var doesnot have getStatus method definition.

		// machineInterfaceObj.nameInInterface = "Washing Machine";
		// wrong:Interface obj is Static & final; cannot be assigned value

		WashingMachine washingMachine = new WashingMachine();
		System.out.println(
				"Washing mc name :" + washingMachine.nameInSubClass + " .From Method:" + washingMachine.getName());
		System.out.println("\n Private method in Subclass - :");
		washingMachine.getStatus();

	}

}
