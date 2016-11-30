import javax.swing.JFrame;
import javax.swing.JPanel;

public class BaseFrame extends JFrame {
	public BaseFrame(String title) {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void add(JPanel panel) {
		this.getContentPane().add(panel);
		this.pack();
		this.setVisible(true);
	}
}