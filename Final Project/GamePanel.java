import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {

	private JTextArea ta;
	private JTextField tb;
	private JButton b;

	private Player player;
	public GamePanel() {
		player = new Player("User", "User", "User");
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		ta = new JTextArea();
		ta.setPreferredSize(new Dimension(500, 200));
		ta.setFocusable(false);
		tb = new JTextField();
		tb.setActionCommand("input");
		tb.addActionListener(new InputListener());
		b = new JButton("Submit");
		b.setActionCommand("input");
		b.addActionListener(new InputListener());
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.add(tb);
		panel.add(b);
		add(ta);
		add(panel);
		tb.requestFocus();
	}

	private class InputListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String command = event.getActionCommand();
			if(command == "input") {
				processInput();
			}
		}

		private void processInput() {
			String command = tb.getText();
			Interpreter.processCommand(command, ta, tb);
		}
	}
}