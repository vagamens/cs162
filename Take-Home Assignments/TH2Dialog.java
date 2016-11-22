import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TH2Dialog extends JPanel {

	JFrame parent;

	public TH2Dialog (JFrame parent) {
		this.parent = parent;

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(new JLabel("Your order has been submitted"));
		Button okButton = new Button("OK");
		okButton.setActionCommand("exit");
		okButton.addActionListener(new ButtonListener());
		add(okButton);
	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			switch(command) {
				case "complete": break;
				case "exit": parent.dispose(); break;
				default: break;
			}
		}
	}

}