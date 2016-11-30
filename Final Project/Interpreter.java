import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Interpreter {

	private Player player;
	private JTextArea ta;
	private JTextField tf;

	public Interpreter(Player player, JTextArea ta, JTextField tf) {
		this.player = player;
		this.ta = ta;
		this.tf = tf;
	}

	public static void processCommand(String s) {
		String q = "";
		switch(s) {
			case "test": q = test(); break;
			case "i": q = playerInventory();
			case "inventory": q = playerInventory();
			default: break;
		}
		this.ta.append(q);
		this.tf.setText("");
	}

	private static String test() {
		return "testing the command interpreter";
	}

	private static String playerInventory() {
		inventory = this.player.getInventory();
		ArrayList<Item> items = inventory.getItems();
	}

}