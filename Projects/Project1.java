/* Project1.java
   pg435 project 8.3 (Histogram)

   Write a program that creates a histogram that allows you to visually inspect
   the frequency distribution of a set of values. The program should read in an
   arbitrary number of integers from a text input file that are in the range 1
   to 100 inclusive; then produce a chart similar to the one below that indicates
   how many input values fell in the range 1 to 10, 11 to 20, and so on. Print
   one asteroid for each value entered.

   +----------+----------------+
   | 1  - 10  | *****          |
   | 11 - 20  | **             |
   | 21 - 30  | ************** |
   | 31 - 40  |                |
   | 41 - 50  | ***            |
   | 51 - 60  | *********      |
   | 61 - 70  | **             |
   | 71 - 80  | *****          |
   | 81 - 90  | *******        |
   | 91 - 100 | **********     |
   +----------+----------------+
*/

import java.io.File;
import java.util.Scanner;
import java.util.Random;

class Project1 {

	public static void main(String[] args) {
		Random rand = new Random();		

		int[] counts = new int[10];

		for(int i=0;i<100;i++) {
			int in = rand.nextInt(100)+1;
			if (in >= 91) {
				counts[9] = counts[9]+1;
			} else if (in >= 81) {
				counts[8] = counts[8]+1;
			} else if (in >= 71) {
				counts[7] = counts[7]+1;
			} else if (in >= 61) {
				counts[6] = counts[6]+1;
			} else if (in >= 51) {
				counts[5] = counts[5]+1;
			} else if (in >= 41) {
				counts[4] = counts[4]+1;
			} else if (in >= 31) {
				counts[3] = counts[3]+1;
			} else if (in >= 21) {
				counts[2] = counts[2]+1;
			} else if (in >= 11) {
				counts[1] = counts[1]+1;
			} else if (in >= 1) {
				counts[0] = counts[0]+1;	
			}
		}

		String[] strings = getStrings(counts);
		for(int i=0;i<strings.length;i++) {
			System.out.println(strings[i]);
		}
	}

	private static String[] getStrings(int[] c) {
		int l=0;
		for(int i=0;i<c.length;i++) {
			if(c[i] > l) {
				l = c[i];
			}
		}
		String[] strings = new String[12];
		strings[0] = "+----------+";
		strings[11] = "+----------+";
		for(int i=0;i<=l+1;i++) {
			strings[0] = strings[0]+"-";
			strings[11] = strings[11]+"-";
		}
		strings[0] = strings[0]+"+";
		strings[11] = strings[11]+"+";
		for(int i=1;i<11;i++) {
			strings[i] = "| ";
		}
		strings[1] = strings[1] + "1  - 10 ";
		strings[2] = strings[2] + "11 - 20 ";
		strings[3] = strings[3] + "21 - 30 ";
		strings[4] = strings[4] + "31 - 40 ";
		strings[5] = strings[5] + "41 - 50 ";
		strings[6] = strings[6] + "51 - 60 ";
		strings[7] = strings[7] + "61 - 70 ";
		strings[8] = strings[8] + "71 - 80 ";
		strings[9] = strings[9] + "81 - 90 ";
		strings[10] = strings[10] + "91 - 100";
		for(int i=1;i<=10;i++) {
			strings[i] = strings[i] + " | ";
			for(int j=0;j<c[i-1];j++) {
				strings[i] = strings[i] + "*";
			}
			for(int j=0;j<l-c[i-1];j++) {
				strings[i] = strings[i] + " ";
			}
		}
		for(int i=1;i<11;i++) {
			strings[i] = strings[i]+" |";
		}
		return strings;
	}
}