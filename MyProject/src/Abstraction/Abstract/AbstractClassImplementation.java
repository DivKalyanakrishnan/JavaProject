package Abstraction.Abstract;

public class AbstractClassImplementation extends AbstractClass {

	// over-ridden ; if not - then superclass implementation will be used.
	protected void absratctMethodWithImpl() {
		System.out.println("hello there in the sub class");
	}

	// need not implement all methods of parent.
	/*
	 * protected void abstractMethod() {
	 * System.out.println("hello - impl for fully abstract method"); }
	 */

	public static void main(String[] args) {
		AbstractClassImplementation subClass = new AbstractClassImplementation();

		subClass.absratctMethodWithImpl();

		subClass.abstractMethod(); // though not implemented, but can still access

		// This is wrong - cannot instantiate
		// AbstractClassTest mainClass = new AbstractClassTest();

	}
}
