package Exceptions;

public class TestExceptions {
	static float b = 0;

	public static void Divide() throws ArithmeticException { // THROWS

		System.out.println("attempting to divide by zero");
		b = 5 / 0;

		// Once Exception occurs, other lines of program execution does not proceed.
		int[] arr = new int[2];

		if (arr[0] == 0) // Block is not required - ie try/catch/finally are a single block
			try {
				arr[1] = 1;
				arr[2] = 1;
				// throw new ArrayIndexOutOfBoundsException();
				// THROW - to create a new Exception explicitly;
				// Here, even without that, exception will be handled due to try catch
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		// finally(){ System.out.println("in final block"); } //Getting error- lookup

	}

	public static void main(String[] args) {
		try {
			Divide();
		} catch (ArithmeticException e) {
			System.out.println("in catch block; value of variable remains as:" + b);
			System.out.println(e.toString());
		}

	}

}
