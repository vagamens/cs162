import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

public class TH2OrderPanel extends JPanel {
	private TH2Pizza pizza;
	private JFrame parent;

	private JCheckBox[] toppingChecks = new JCheckBox[17];

	public TH2OrderPanel(JFrame parent, TH2Pizza pizza) {
		this.parent = parent;
		this.pizza = pizza;
		pizza.setCrust("regular", "thick");
		pizza.addSauce("tomato");
		pizza.addCheese(true);
		setFont(new Font("Arial", Font.BOLD, 16));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// Set up panes
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.X_AXIS));
		JPanel leftPane = new JPanel();
		leftPane.setLayout(new BoxLayout(leftPane, BoxLayout.Y_AXIS));
		JPanel rightPane = new JPanel();
		rightPane.setLayout(new BoxLayout(rightPane, BoxLayout.Y_AXIS));
		JPanel internalRightPane = new JPanel();
		internalRightPane.setLayout(new BoxLayout(internalRightPane, BoxLayout.X_AXIS));
		JPanel internalRightPaneLeft = new JPanel();
		internalRightPaneLeft.setLayout(new BoxLayout(internalRightPaneLeft, BoxLayout.Y_AXIS));
		JPanel internalRightPaneRight = new JPanel();
		internalRightPaneRight.setLayout(new BoxLayout(internalRightPaneRight, BoxLayout.Y_AXIS));
		JPanel bottomPane = new JPanel();
		bottomPane.setLayout(new BoxLayout(bottomPane, BoxLayout.X_AXIS));

		// Set up left pane
		JLabel leftPaneTitle = new JLabel("Crust Type");
		JLabel leftPaneTitel2 = new JLabel("Crust Thickness");
		JRadioButton regularCrust = new JRadioButton("Regular");
		regularCrust.setActionCommand("regular");
		regularCrust.setSelected(true);

		JRadioButton glutenFree = new JRadioButton("Gluten Free");
		glutenFree.setActionCommand("gluten");

		ButtonGroup crustTypeGroup = new ButtonGroup();
		crustTypeGroup.add(regularCrust);
		crustTypeGroup.add(glutenFree);

		regularCrust.addActionListener(new RadioListener());
		glutenFree.addActionListener(new RadioListener());

		JRadioButton thickCrust = new JRadioButton("Thick Crust");
		thickCrust.setSelected(true);
		thickCrust.setActionCommand("thick");
		thickCrust.addActionListener(new RadioListener());

		JRadioButton thinCrust = new JRadioButton("Thin Crust");
		thinCrust.setSelected(false);
		thinCrust.setActionCommand("thin");
		thinCrust.addActionListener(new RadioListener());

		JRadioButton flatCrust = new JRadioButton("Flat Crust");
		flatCrust.setSelected(false);
		flatCrust.setActionCommand("flat");
		flatCrust.addActionListener(new RadioListener());

		ButtonGroup thicknessGroup = new ButtonGroup();
		thicknessGroup.add(thickCrust);
		thicknessGroup.add(thinCrust);
		thicknessGroup.add(flatCrust);

		leftPane.add(leftPaneTitle);
		leftPane.add(regularCrust);
		leftPane.add(glutenFree);
		//leftPane.add(new JSeparator(SwingConstants.HORIZONTAL));
		leftPane.add(leftPaneTitel2);
		leftPane.add(thickCrust);
		leftPane.add(thinCrust);
		leftPane.add(flatCrust);

		// Set up right pane
		JLabel rightPaneLabel = new JLabel("Toppings");
		rightPane.add(rightPaneLabel);

		String[] toppings = pizza.getValidToppings();

		for(int i=0; i<toppingChecks.length; i++) {
			toppingChecks[i] = new JCheckBox(toppings[i]);
			toppingChecks[i].setSelected(false);
			if(i%2 == 0) {
				internalRightPaneLeft.add(toppingChecks[i]);
			} else {
				internalRightPaneRight.add(toppingChecks[i]);
			}
		}

		internalRightPane.add(internalRightPaneLeft);
		internalRightPane.add(internalRightPaneRight);

		rightPane.add(internalRightPane);

		// Set up cheese frame
		JPanel cheeseFrame = new JPanel();
		cheeseFrame.setLayout(new BoxLayout(cheeseFrame, BoxLayout.Y_AXIS));
		JPanel internalCheeseFrame = new JPanel();
		internalCheeseFrame.setLayout(new BoxLayout(internalCheeseFrame, BoxLayout.X_AXIS));
		JLabel cheeseLabel = new JLabel("Cheese");

		JRadioButton fullCheese = new JRadioButton("Full Cheese");
		fullCheese.setActionCommand("full");
		fullCheese.setSelected(true);
		fullCheese.addActionListener(new RadioListener());
		JRadioButton leftHalfCheese = new JRadioButton("Left Half");
		leftHalfCheese.setActionCommand("left");
		leftHalfCheese.setSelected(false);
		leftHalfCheese.addActionListener(new RadioListener());
		JRadioButton rightHalfCheese = new JRadioButton("Right Half");
		rightHalfCheese.setActionCommand("full");
		rightHalfCheese.setSelected(false);
		rightHalfCheese.addActionListener(new RadioListener());

		ButtonGroup cheeseGroup = new ButtonGroup();
		cheeseGroup.add(fullCheese);
		cheeseGroup.add(leftHalfCheese);
		cheeseGroup.add(rightHalfCheese);

		internalCheeseFrame.add(leftHalfCheese);
		internalCheeseFrame.add(fullCheese);
		internalCheeseFrame.add(rightHalfCheese);

		cheeseFrame.add(cheeseLabel);
		cheeseFrame.add(internalCheeseFrame);

		// Set up sauce frame
		JPanel sauceFrame = new JPanel();
		sauceFrame.setLayout(new BoxLayout(sauceFrame, BoxLayout.Y_AXIS));
		JPanel internalSauceFrame = new JPanel();
		internalSauceFrame.setLayout(new BoxLayout(internalSauceFrame, BoxLayout.X_AXIS));
		JLabel sauceLabel = new JLabel("Sauce");

		JRadioButton tomatoSauce = new JRadioButton("Tomato Sauce");
		tomatoSauce.setActionCommand("tomato");
		tomatoSauce.setSelected(true);
		tomatoSauce.addActionListener(new RadioListener());

		JRadioButton whiteSauce = new JRadioButton("White Sauce");
		whiteSauce.setActionCommand("white");
		whiteSauce.setSelected(true);
		whiteSauce.addActionListener(new RadioListener());

		JRadioButton bbqSauce = new JRadioButton("BBQ Sauce");
		bbqSauce.setActionCommand("bbq");
		bbqSauce.setSelected(true);
		bbqSauce.addActionListener(new RadioListener());

		ButtonGroup sauceGroup = new ButtonGroup();
		sauceGroup.add(tomatoSauce);
		sauceGroup.add(whiteSauce);
		sauceGroup.add(bbqSauce);

		internalSauceFrame.add(tomatoSauce);
		internalSauceFrame.add(whiteSauce);
		internalSauceFrame.add(bbqSauce);

		sauceFrame.add(sauceLabel);
		sauceFrame.add(internalSauceFrame);

		// Set up Bottom Frame
		Button completeButton = new Button("Complete Order");
		completeButton.setActionCommand("complete");
		completeButton.addActionListener(new ButtonListener());
		Button exitButton = new Button("Exit");
		exitButton.setActionCommand("exit");
		exitButton.addActionListener(new ButtonListener());

		bottomPane.add(completeButton);
		bottomPane.add(exitButton);

		mainPane.add(leftPane);
		mainPane.add(rightPane);

		this.add(mainPane);
		this.add(cheeseFrame);
		this.add(sauceFrame);
		this.add(bottomPane);
	}

	private class RadioListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			switch(command) {
				case "regular": pizza.setCrust("regular"); break;
				case "gluten": pizza.setCrust("gluten free"); break;
				case "thick": pizza.setCrustThickness("thick"); break;
				case "thin": pizza.setCrustThickness("thin"); break;
				case "flat": pizza.setCrustThickness("flat"); break;
				case "full": pizza.addCheese(true); break;
				case "left": pizza.addCheese(true, false); break;
				case "right": pizza.addCheese(false, true); break;
				case "tomato": pizza.addSauce("tomato"); break;
				case "white": pizza.addSauce("white"); break;
				case "bbq": pizza.addSauce("BBQ"); break;
				default: break;
			}
		}
	}

	private class ButtonListener implements ActionListener {
		private void completeOrder() {
			String[] tops = pizza.getValidToppings();
			for(int i=0; i<toppingChecks.length;i++) {
				pizza.addTopping(tops[i]);
			}
			parent.dispose();
			JFrame frame = new JFrame("TH2-Pizza Comfirmation");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			TH2ConfirmationPanel confirm = new TH2ConfirmationPanel(frame, pizza);

			frame.getContentPane().add(confirm);
			frame.pack();
			frame.setVisible(true);
		}

		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			switch(command) {
				case "complete": completeOrder(); break;
				default: break;
			}
		}
	}
}