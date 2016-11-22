import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Button;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TH2ConfirmationPanel extends JPanel {

	TH2Pizza pizza;
	JFrame parent;

	public TH2ConfirmationPanel(JFrame parent, TH2Pizza pizza) {
		this.parent = parent;
		this.pizza = pizza;

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel pizzaPanel = new JPanel();
		pizzaPanel.setLayout(new BoxLayout(pizzaPanel, BoxLayout.Y_AXIS));
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

		String[] crust = pizza.getCrust();
		JLabel crustLabel = new JLabel("Crust: " + crust[0] + ", " + crust[1]);
		pizzaPanel.add(crustLabel);

		String sauce = pizza.getSauce();
		JLabel sauceLabel = new JLabel("Sauce: " + sauce);
		pizzaPanel.add(sauceLabel);

		boolean[] cheese = pizza.getCheese();
		JLabel cheeseLabel;
		if(cheese[0] && cheese [1]) {
			cheeseLabel = new JLabel("Cheese: Full");
		} else if (cheese[0]) {
			cheeseLabel = new JLabel("Cheese: Left Half");
		} else if (cheese[1]) {
			cheeseLabel = new JLabel("Cheese: Right Half");
		} else {
			cheeseLabel = new JLabel("Cheese: None");
		}
		pizzaPanel.add(cheeseLabel);

		String[] tops = pizza.getToppings();
		pizzaPanel.add(new JLabel("Toppings:"));
		for(int i=0;i<tops.length;i++) {
			pizzaPanel.add(new JLabel("     "+tops[i]));
		}

		Button completeButton = new Button("Submit Order");
		Button cancelButton = new Button("Cancel Order");

		completeButton.setActionCommand("complete");
		cancelButton.setActionCommand("exit");

		completeButton.addActionListener(new ButtonListener());
		cancelButton.addActionListener(new ButtonListener());

		buttonPanel.add(completeButton);
		buttonPanel.add(cancelButton);

		this.add(pizzaPanel);
		this.add(buttonPanel);

	}

	private class ButtonListener implements ActionListener {
		private void submitOrder() {
			parent.dispose();
			JFrame frame = new JFrame("TH2-Pizza Confirmation");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			TH2Dialog panel = new TH2Dialog(frame);

			frame.getContentPane().add(panel);
			frame.pack();
			frame.setVisible(true);
		}

		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			switch(command) {
				case "complete": submitOrder(); break;
				case "exit": parent.dispose(); break;
				default: break;
			}
		}
	}

}