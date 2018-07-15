package Concepts;

//CLASS
class Plant {
	public void grow() {
		System.out.println("Plant growing"); // has implementation
	}
}

// INTERFACE
interface IPlant {
	public void stop(); // only definition
}

// MAIN CLASS
public class AnonymousClassTest {

	public static void main(String[] args) {

		// ANONYMOUS CLASS
		Plant plant1 = new Plant() {

			// NEW METHOD INSIDE
			public void water() {
				System.out.println("Watering of plant...");
			}

			// OVER_RIDE IMPLEMENTATION
			public void grow() {
				System.out.println("Plant starting to grow...");
				water(); // NEW method can be called from existing method ; but not separately
			}

		};
		plant1.grow();
		// plant1.water(); // INCORRECT - no definition for water() in class Plant

		IPlant plant2 = new IPlant() {
			public void stop() {
				System.out.println("Plant is fully grown...");
			}
		};
		plant2.stop();

	}

}
