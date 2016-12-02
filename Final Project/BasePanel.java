import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import java.awt.event.WindowEvent;

public class BasePanel extends JPanel {

	JFrame parent;

	public BasePanel(JFrame parent) {
		super();
		this.parent = parent;
	}

	public BasePanel() {
		this(null);
	}

	public void setNewLayout(String layout) {
		switch(layout) {
			case "boxX": setLayout(new BoxLayout(this, BoxLayout.X_AXIS)); break;
			case "boxY": setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); break;
			default: break;
		}
	}

	private void close() {
		this.parent.dispatchEvent(new WindowEvent(this.parent, WindowEvent.WINDOW_CLOSING));
	}

	private void close(JFrame frame) {
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}
}