import java.awt.Font;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

	private int state = 0;
	private BaseFrame frame;
	private BasePanel gamePanel;
	private JTextArea output;
	private JTextField input;
	private JButton submit;
	private Interpreter interpret;
	private JScrollPane spane;
	private Player player;
	private Map map;
	private int currentRoom = 0;
	private Font mainFont;

	public Game() {
		frame = new BaseFrame("Kitten Simulator");
		player = new Player("Kitten", "User", "User");
		interpret = new Interpreter(this);
		mainFont = new Font(Font.MONOSPACED, Font.PLAIN, 12);

		// setup basic GamePanel
		gamePanel = new BasePanel();
		gamePanel.setNewLayout("boxY");
		output = new JTextArea();
		output.setFocusable(false);
		output.append("\n\n\n\n\n\n\n\n\n\n\n\n\n");
		output.setFont(mainFont);
		output.setCaretPosition(output.getDocument().getLength());
		input = new JTextField();
		input.setActionCommand("input");
		input.addActionListener(new InputListener());
		input.setFont(mainFont);
		submit = new JButton("Submit");
		submit.setActionCommand("input");
		submit.addActionListener(new InputListener());
		BasePanel innerPanel = new BasePanel();
		spane = new JScrollPane(output, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		spane.setPreferredSize(new Dimension(500, 200));
		spane.getVerticalScrollBar().setValue(spane.getVerticalScrollBar().getMaximum());
		innerPanel.setNewLayout("boxX");
		innerPanel.add(input);
		innerPanel.add(submit);
		gamePanel.add(spane);
		gamePanel.add(innerPanel);
		input.requestFocus();
		ArrayList<RoomObject> tempObjects = new ArrayList<RoomObject>();
		tempObjects.add(new RoomObject("Couch", "Just a simple three-coushin couch", "Just a couch"));
		tempObjects.add(new RoomObject("Rug", "A nice european rug with tassles on the short sides.", "A nice eurpoean rug"));
		Room room = new Room("Living Room", "Just the living room where all the humans sit.", "The Living Room", tempObjects);
		map = new Map("Main Map", "Just the main map", "Just a map");
		map.addRoom(room);
		//map.addRoom(new Room("Living Room", "Just the living room where all the humans sit.", "The Living Room"));//, tempObjects));

		frame.add(gamePanel);

		interpret.run();
	}

	public void setup() {
		while (this.state < 3) {
			switch(state) {
				case 0: prompt("What is your name?\n"); break;
				case 1: prompt("What is your quest?\n"); break;
				case 2: prompt("what is your favorite color?\n"); break;
				default: break;
			}
			String in = takeInput();
			System.out.println(input);
			if(in != "") {
				setValue(in);
				state++;
			}
		}
	}

	public String getInput() {
		return this.input.getText();
	}

	public void resetInput() {
		this.input.setText("");
	}

	public Player getPlayer() {
		return this.player;
	}

	public JTextArea getOutput() {
		return this.output;
	}

	public BaseFrame getFrame() {
		return this.frame;
	}

	public JScrollPane getScrollPane() {
		return this.spane;
	}

	public void setValue(String input) {
		switch(state) {
			case 0: this.player.setName(input); break;
			case 1: this.player.setQuest(input); break;
			case 2: this.player.setColor(input); break;
			default: break;
		}
	}

	public Room getCurrentRoom() {
		return this.map.getRoom(currentRoom);
	}

	public void changeRoom(int i) {
		this.currentRoom = i;
	}

	public void setInterpreter(Interpreter i) {
		this.interpret = i;
	}

	private String takeInput() {
		String input = this.input.getText();
		this.input.setText("");
		return input;
	}

	private void prompt(String s) {
		this.output.append(s);
	}

	private class InputListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String command = event.getActionCommand();
			if(command == "input") {
				interpret.run();
			}
		}
	}
}