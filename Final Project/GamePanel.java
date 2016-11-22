import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GamePanel extends JPanel {
	public GamePanel() {
		Player player = new Player();
		setPreferredSize(new Dimension(300, 75));
	}

	private class TempListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {

		}
	}
}