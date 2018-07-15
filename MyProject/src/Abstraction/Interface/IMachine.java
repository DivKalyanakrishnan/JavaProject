package Abstraction.Interface;

public interface IMachine {

	public String nameInInterface = "GenericMachine"; // "this gets defined as static final"

	public void start();

	public String getName();

	// This is wrong - only abstract methods are allowed in interface
	/*
	 * public String getName(){ return(this.name); }
	 */

	// This is wrong - Only public & abstract are permitted for Interface
	// private void tryPrivateInInterface() {}

}
