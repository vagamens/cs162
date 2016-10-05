import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

public class Quiz1Panel extends JPanel {
	private JLabel label;
	private JButton button;
	private Random rand = new Random();
	String[] excuses = {"low clock speed", "solar flares", "electromagnetic radiation from satellite debris",
						"static from nylon underwear", "static from plastic slide rules", "global warming",
						"poor power conditioning", "static buildup", "doppler effect", "hardware stress fractures",
						"magnetic interference from money/credit cards", "dry joins on cable plug",
						"we're waiting for [the phone company] to fix that line",
						"sounds like a Windows problem, try calling Microsoft support", "temporary routing anonaly",
						"somebodywas calculating pi on the server", "fat electrons in the lines", "excess surge protection",
						"floatingpoint processor overflow", "divide-by-zero error"
						};

	public Quiz1Panel() {
		setBackground(new Color(150, 149, 24));
		setPreferredSize(new Dimension(680, 680));
		setFont(new Font("Arial", Font.BOLD, 16));

		label = new JLabel("Press the button to get a new excuse.");
		button = new JButton("Press me!");

		button.addActionListener(new TempListener());

		add(label);
		add(button);
	}

	private class TempListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			String text = "The function failed due to " + excuses[rand.nextInt(excuses.length)] + ".";

			label.setText(text);
		}
	}
}