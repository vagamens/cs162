import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends BasePanel {

	private JTextArea ta;
	private JTextField tb;
	private JButton b;
	Interpreter interpret;
	JScrollPane spane;
	JFrame parent;
	private Player player;
	BaseFrame setupFrame;
	SetupPanel setupPanel;
	private int startUp = 0;

	public GamePanel(JFrame parent) {
		super();
		this.parent = parent;
		player = new Player("Kitten", "User", "User");
		setNewLayout("boxX");
		ta = new JTextArea();
		ta.setFocusable(false);
		tb = new JTextField();
		tb.setActionCommand("input");
		tb.addActionListener(new InputListener());
		b = new JButton("Submit");
		b.setActionCommand("input");
		b.addActionListener(new InputListener());
		BasePanel panel = new BasePanel();
		spane = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		spane.setPreferredSize(new Dimension(500, 200));
		panel.setNewLayout("boxX");
		panel.add(tb);
		panel.add(b);
		add(spane);
		add(panel);
		tb.requestFocus();
		this.interpret = new Interpreter(this.player, this.ta, this.tb, this.parent);
	}

	public JTextArea getTextArea() {
		return this.ta;
	}

	public JTextField getTextField() {
		return this.tb;
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
			String input = interpret.processCommand(command);
			ta.append(input+"\n\n");
			switch(startUp) {
				case 0: player.setName(input); startUp++; break;
				case 1: player.setQuest(input); startUp++; break;
				case 2: player.setColor(input); startUp++; break;
				default: break;
			}
		}
	}
}