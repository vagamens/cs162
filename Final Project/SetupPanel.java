import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetupPanel extends BasePanel {

	private JLabel nLabel;
	private JLabel cLabel;
	private JLabel qLabel;
	private JTextField nField;
	private JTextField cField;
	private JTextField qField;
	private JButton sButton;
	String[] answers = new String[3];

	public SetupPanel(JFrame parent) {
		super(parent);
		setNewLayout("boxY");
		nLabel = new JLabel("What is your name?");
		qLabel = new JLabel("What is your quest?");
		cLabel = new JLabel("What is your favorite color?");
		nField = new JTextField();
		qField = new JTextField();
		cField = new JTextField();
		sButton = new JButton("Submit");
		sButton.addActionListener(new InputListener());
		BasePanel nPanel = new BasePanel();
		nPanel.setNewLayout("boxX");
		BasePanel qPanel = new BasePanel();
		qPanel.setNewLayout("boxX");
		BasePanel cPanel = new BasePanel();
		cPanel.setNewLayout("boxX");

	}

	public SetupPanel() {
		this(null);
	}

	public String[] getAnswers() {
		return this.answers;
	}

	private class InputListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			answers[0] = nLabel.getText();
			answers[1] = qLabel.getText();
			answers[2] = cLabel.getText();
		}

	}
}