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
 import java.io.PrintWriter;
 import java.io.FileNotFoundException;

public class TH1 {

	

	public static void main(String[] args) {

		String[] menuItems = {"1. Read from file",
							  "2. Input number",
							  "3. Create Histogram",
							  "4. Write to file",
							  "5. Help",
							  "6. Quit"};

		Menu menu = new Menu(menuItems, 1);

		int[] randoms={};
		int value=1;
		while(value!=0) {
			value = menu.run();
			switch (value) {
				case 1: randoms = readFile(); break;
				case 2: randoms = numberInput(); break;
				case 3: printHistogram(randoms); break;
				case 4: writeFile(randoms); break;
				case 5: help(); break;
				case 6: value=0; break;
			}
		}

	}

	private static int[] readFile() {
		System.out.println("Which file would you like to read from?");
		Scanner scan = new Scanner(System.in);
		String fileName = scan.next();
		int[] randoms={};
		try {
			File file  = new File(fileName);
			Scanner reader = new Scanner(file);	
			while(reader.hasNext()) {
				int[] temp = new int[randoms.length+1];
				for(int i=0; i<randoms.length; i++) {
					temp[i] = randoms[i];
				}
					randoms = temp;
					randoms[randoms.length-1] = reader.nextInt();
				}
		} catch (FileNotFoundException e) {
			sopl("Some exception happened! Ignoring");
		}
		return randoms;
	}

	private static void writeFile(int[] randoms) {
		String[] strings = createHistogram(randoms);
		try {
			PrintWriter writer = new PrintWriter("TH1Output.txt");
			for(int i=0;i<strings.length;i++) {
				writer.println(strings[i]);
			}
			writer.close();
		} catch (FileNotFoundException e) {
			sopl("Some exception happened! Ignoring");
		}
	}

	private static int[] numberInput() {
		sopl("How many numbers would you like to generate?");
		Scanner scan = new Scanner(System.in);
		int gen = scan.nextInt();
		sopl("");
		sopl("");
		return generateRandoms(gen);
	}

	private static int[] generateRandoms(int gen) {
		Random rand = new Random();
		int[] randoms = new int[gen];
		for(int i=0; i<gen; i++) {
			randoms[i] = rand.nextInt(100)+1;
		}
		return randoms;
	}

	private static void printHistogram(int[] randoms) {
		String[] strings = createHistogram(randoms);
		sopl("");
		sopl("");
		for(int i=0; i<strings.length;i++) {
			System.out.println(strings[i]);
		}
		sopl("");
		sopl("");
	}

	private static String[] createHistogram(int[] randoms) {
		Histogram hist = new Histogram();
		hist.setRandoms(randoms);
		return hist.generateHistogram();
	}

	private static void help() {
		// print help page
		sopl("");
		sopl("1: Read numbers from an input file.");
		sopl("2: Write the created Histogram to the \'TH1Output.txt\' file.");
		sopl("3: Create a series of randoms numbers. The about generated will be\nthe input value.");
		sopl("4: Prints the Histogram to standard ou.");
		sopl("5: Prints this help page.");
		sopl("6: Exits this program.");
		sopl("");
	}

	private static void sopl(String s) {
		System.out.println(s);
	}

	private static void sop(String s) {
		System.out.print(s);
	}

}