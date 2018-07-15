package Abstraction.Abstract;

public abstract class AbstractClass {

	// public static void main(String[] args) { } // not necessary to have main.

	// fully abstract class has all methods as only defined - defines what to do but
	// not how to do.
	protected void abstractMethod() {
	}

	// partially abstract - some methods defined
	protected void absratctMethodWithImpl() {
		System.out.println("hello there");
	}

	protected static void abstractMethodWithStatic() {
		System.out.println("hello - abstractMethodWithStatic ");
	}
}
