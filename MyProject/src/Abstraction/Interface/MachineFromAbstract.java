package Abstraction.Interface;

import Abstraction.Abstract.AbstractClassSubImpl;

public class MachineFromAbstract extends AbstractClassSubImpl {

	public String nameInSubClass = "MachineFromAbstract";

	// New Method only defined here
	private void getStatus() {
		System.out.print("MachineFromAbstract -running status");
	}

	public static void main(String args[]) {
		AbstractClassSubImpl subSubClass = new AbstractClassSubImpl();
		MachineFromAbstract subSubClassInOtherPackage = new MachineFromAbstract();

		// Protected methods- cannot be accessed from this package
		// subSubClass.absratctMethodWithImpl();
		// subSubClass.abstractMethod();

		AbstractClassSubImpl.abstractMethodWithStatic(); // can access even those methods that are not implemented in
															// subClass but as Static methods in main Abstract

		subSubClass.typeOut();
		subSubClassInOtherPackage.getStatus();

		// Can call protected method from another package due to inheritance
		subSubClassInOtherPackage.typeOutProtected();
	}

}
