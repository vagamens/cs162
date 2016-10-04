/* In-Class Project 1
   1. design and create aclass to represent a somewhat complex object (car,
   house, computer, being, container structure) including:
   		1. a few attributes (variables). -done
   		2. a few behaviors (methods). -done
   		3. a simple menu to:
   			1. get basic input from a user,
   			2. display basic info about your object
   			3. a few tests that would show evidence that your program is
   				working correctly.
*/
 
import Menu;
import Kitten;

public class IC1 {

	public static void main(String[] args) {
		String[] menuItems = {"1. Change Name", "2. Change Age",
							  "3. Change Number of hairs", "4. Change Height",
							  "5. Change Tail", "6. Get Position",
							  "9. Get The Information about your Kitten", "8. Quit"};
		Kitten kitty = new Kitten();
		Menu menu = new Menu(menuItems, 1);

		int value = 1;
		while(value != 0) {
			int value = menu.run();
			switch (value) {
				case 1: break;
				case 2: break;
				case 3: break;
				case 4: break;
				case 5: break;
				case 6: break;
				default: break;
			}
		}
	}

	private static void printKitten() {
		String s = 
	}

	private static void printName() {

	}

	private static void printAge() {

	}

	private static void printAge() {

	}

	private static void printHairs() {

	}

	private static void printHeight() {

	}

	private static void printTail() {

	}

	private static void printPosition() {

	}

	private static void quit() {

	}

}