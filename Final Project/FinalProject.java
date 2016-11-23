/* Final Project

   Demonstrate the following:
    1. an understanding of the use of variables, conditionals,
       loops, and arrays
    2. an understanding of code organization (methods, classes,
       and source files)
    3. an understanding of various design (hierarchy) and testing
       (test methods and drivers) techniques
    4. user IO, file IO, and input validation
    5. java interfaces
    6. recursion
    7. nested classes
    8. GUI components, event listeners, and their various uses
    9. inheritance and polymorphism
   10. exceptions
*/
import javax.swing.JFrame;

public class FinalProject {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Final Project");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GamePanel panel = new GamePanel();

		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}
}