/* Take-Home Assignment 2
   
   1. Start with another person's design (car, house, computer, ...) and tests
      to work on this project
   2. design a few decomposed components* (the design must include variables,
      methods, and possible objects that the component would need access to to
      properly work)
   3. choose one component, write a few tests for it (tests that you know if
   	working would show that your code should be working properly)
   4. implement one of those components in code as a class file of its own (with
      variables, methods, and a main that will act as a driver to show it working
      with your tests and to demonstrate what it stores or can do)
   5. you may choose to have the main work with user input, but you *must* have the
      ability to read inputs from a properly formatted text file (which can mimic the
      format of what you would ask a user for input)
*/

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class TH2 {

   String[] cheese = {"half", "normal", "double", "none"};
   String[] dlc = {"crushed red peppers", "\"special\" crust", "M. Night Shroomalooms",
                   "parmesian cheese powder"
                  };

	public static void main(String[] args) {
      TH2Pizza pizza = new TH2Pizza();

		JFrame frame = new JFrame("TH2-Pizza");

      TH2OrderPanel panel = new TH2OrderPanel(frame, pizza);
      frame.getContentPane().add(panel);

      frame.pack();
      frame.setVisible(true);
	}
}