import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class Quiz1 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Quiz1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Quiz1Panel panel = new Quiz1Panel();

		frame.getContentPane().add(panel);

		frame.pack();
		frame.setVisible(true);
	}
}