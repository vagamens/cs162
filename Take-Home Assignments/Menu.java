/* Menu.java
   
   Useful library for creating basic menus in the Java cli
*/

 import java.util.Scanner;

public class Menu {
	String[] items;
	int mode;
	Scanner scan = new Scanner();

	public Menu(String[] menuItems, int mode) {
		this.items = menuItems;
		this.mode = mode;
	}

	public int run() {
		while(true) {
			for(int i=0; i<items.length; i++) {
				System.out.println(items[i]);
			}
		}
		System.out.println("What would you like to do?");
		return this.scan.nextInt();
	}
}