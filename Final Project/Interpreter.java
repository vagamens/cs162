import java.util.ArrayList;
import javax.swing.JScrollPane;
import java.awt.event.WindowEvent;

public class Interpreter {

	private Game parent;

	public Interpreter(Game parent) {
		this.parent = parent;
	}

	public void processCommand() {
		String s = this.parent.getInput();
		this.parent.resetInput();
		String q = "";
		switch(s) {
			case "test": q = test(); break;
			case "i": q = playerInventory(); break;
			case "inventory": q = playerInventory(); break;
			case "l": q = look(); break;
			case "look": q = look(); break;
			case "exit": exit(); break;
			default: break;
		}
		q = q+"\n";
		this.parent.getOutput().append(q);
		this.parent.resetInput();
		JScrollPane sp = this.parent.getScrollPane();
		sp.getVerticalScrollBar().setValue(sp.getVerticalScrollBar().getMaximum());
	}

	public String getInput() {
		return "";
	}

	private String test() {
		return "testing the command interpreter";
	}

	private String look() {
		return this.parent.getCurrentRoom().getDescription();
	}

	private String playerInventory() {
		Inventory inventory = this.parent.getPlayer().getInventory();
		ArrayList<Item> items = inventory.getItems();
		String q = this.parent.getPlayer().getName() + "\'s "+inventory.getName()+":\n";
		if (!items.isEmpty()) {
			for(Item i : items) {
				q = q+"    ";
				q = q+i.getName()+": "+i.getDescription()+"\n";
			}
		} else {
			q = q+"    Empty";
		}
		return q;
	}

	private void exit() {
		BaseFrame frame = this.parent.getFrame();
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}

}