package Abstraction.Abstract;

public class AbstractClassSubImpl extends AbstractClassImplementation {

	public void typeOut() {
		System.out.println("Public call Under AbstractClassSubImpl");
	}

	protected void typeOutProtected() {
		System.out.println("Protected call Under AbstractClassSubImpl");
	}

	public static void main(String args[]) {
		AbstractClassSubImpl subSubClass = new AbstractClassSubImpl();
		subSubClass.absratctMethodWithImpl();

		subSubClass.abstractMethod(); // can access even those methods that are not implemented in subClass

		AbstractClassSubImpl.abstractMethodWithStatic(); // can access even those methods that are not implemented in
															// subClass but as Static methods in main Abstract
	}
}