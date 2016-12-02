import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.util.ArrayList;
import java.awt.event.WindowEvent;

public class Interpreter {

	private Player player;
	private JTextArea ta;
	private JTextField tf;
	private JFrame parent;

	public Interpreter(Player player, JTextArea ta, JTextField tf, JFrame parent) {
		this.player = player;
		this.ta = ta;
		this.tf = tf;
		this.parent = parent;
	}

	public String processCommand(String s) {
		String q = "";
		switch(s) {
			case "test": q = test(); break;
			case "i": q = playerInventory();
			case "inventory": q = playerInventory();
			case "exit": exit(); break;
			default: return s;
		}
		q = q+"\n";
		for(int i=0;i<100;i++) {
			this.ta.append(q);
		}
		this.ta.append(q);
		this.tf.setText("");
		return "";
	}

	private String test() {
		return "testing the command interpreter";
	}

	private String playerInventory() {
		Inventory inventory = this.player.getInventory();
		ArrayList<Item> items = inventory.getItems();
		String q = this.player.getName() + "\'s "+inventory.getName()+"\n";
		for(Item i : items) {
			q = q+i.getName()+": "+i.getDescription()+"\n";
		}
		return q;
	}

	private void exit() {
		this.parent.dispatchEvent(new WindowEvent(this.parent, WindowEvent.WINDOW_CLOSING));
	}

}