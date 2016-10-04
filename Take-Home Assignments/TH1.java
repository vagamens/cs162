/* Take-Home Assignment 1
   
   Make a program that has or can do the following:

   Note Well!: you do not have to actually read or write a file for this
   assignment, just setup the initial user input, and confirmation of input as
   output you can verify visually.

   Note: you should have a few methods to accomplish these, but you do not
   necessarily need a method for each.

   1. a text-based menu for the user to interact with this program (numbers for
   menu input is fine)
   2. ask for the name of a file, ask for a filename to writeto, and print the
   value back out to confirm the input with your eyes
   3. ask for text to be written to a file, ask for a filename to write to, and
   print the value back out to confirm the input with your eyes
   4. a menu item that when selected will ask the user for a number between 1
   and 10 (inclusive), verify that that number was input, generate that many
   random numbers from 1-100, and when done generating numbers print a message
   indicating how many of each of the number generated were in the following
   ranges: 1-10, 11-20, 21-30, ... 91-100 (store these in an array, but without
   storing each of the generated numbers directly)
   5. quit the program and say goodbye
   6. loop back to the menu after finishing an item (definitely do not invoke
   the main method from within the program...) and ask what the user would like
   to do next.
*/

 import java.util.Random;
 import java.util.Scanner;
 import java.io.File;

public class TH1 {

	

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		Histogram hist = new Histogram();

		String[] menuItems = {"1. Read from file", "2. Write to file",
		"3. Input number", "4. Create Histogram", "5. Help", "6. Quit"};

		Menu menu = new Menu(menuItems, 1);

		int value=1;
		while(value!=0) {
			value = menu.run();
			switch (value) {
				case 1: readFile(); printHistogram(); break;
				case 2: writeFile(); break;
				case 3: numberInput(); break;
				case 4: printHistogram(); break;
				case 5: break;
				case 6: value=0; break;
				default: break;
			}
		}

	}

	private static void readFile() {
		System.out.println("Which file would you like to read from?");
		String fileName = scan.next();
		File file  = new File(fileName);
		Scanner reader = new Scanner(file);

		int[] randoms;
		while(reader.hasNext()) {
			int[] temp = new int[randoms.length+1];
			for(int i=0; i<randoms.length; i++) {
				temp[i] = randoms[i];
			}
			randoms = temp;
			randoms[randoms.length-1] = reader.nextInt();
		}
		hist.setRandoms(randoms);
		String[] strings = createHistogram();

	}

	private static void writeFile() {
		String[] strings = createHistogram();
	}

	private static void numberInput() {
		String[] strings = createHistogram();
	}

	private static void generateRandoms() {
		System.out.println("How many numbers would you like to generate?");
		int gen = this.scan.nextInt();
		int[] randoms = new int[gen];
		for(int i=0; i<gen; i++) {
			randoms[i] = rand.nextInt(100)+1;
		}
		hist.setRandoms(randoms);
	}

	private static void printHistogram() {
		Strings[] strings = createHistogram();
		for(int i=0; i<strings.length;i++) {
			System.out.println(strings[i]);
		}
	}

	private static void createHistogram() {
		return host.generateHistogram();
	}

	private static void help() {
		// print help page
	}

}