import java.util.Timer;
import java.util.Arrays;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.TimerTask;
import java.lang.ClassLoader;
import javax.swing.JScrollPane;
import java.awt.event.WindowEvent;
import java.lang.reflect.Constructor;

public class Interpreter {

	private Game parent;
	private int sleepLen = 0;
	private String[] state = {"setup", "name"};
	private boolean debug = true;
	Timer timer = new Timer();
	private boolean[] hasPrinted = {false, false, false};
	private boolean[] hasValue = {false, false, false};

	public Interpreter(Game parent) {
		this.parent = parent;
	}

	public void run() {
		String[] s = this.parent.getInput().split(" ");
		resetInput();
		if(state[0] == "setup") {
			setup(s);
		} else {
			processCommand(s);
		}

	}

	private void setup(String[] s) {
		String q = "";
		for(int i=0;i<s.length;i++) {
			q = q + s[i] + " ";
		}
		if(!hasValue[0]) {
			hasValue[0] = outputTest("What is your name?", q, hasPrinted[0]);
			hasPrinted[0] = true;
		} else if(!hasValue[1]) {
			hasValue[1] = outputTest("What is your quest?", q, hasPrinted[1]);
			hasPrinted[1] = true;
		} else if(!hasValue[2]) {
			hasValue[2] = outputTest("what is your favorite color?", q, hasPrinted[2]);
			hasPrinted[2] = true;
		}
		if(hasValue[0] && hasPrinted[0]) {
			state[1] = "quest";
		}
		if(hasValue[1] && hasPrinted[1]) {
			state[1] = "color";
		}
		if(hasValue[2] && hasPrinted[2]) {
			state[1] = "done";
		}
		if(state[0] == "setup" && state[1] == "done") {
			state[0] = "running";
			state[1] = "";
		}
	}

	private boolean outputTest(String st, String s, boolean has) {
		System.out.println(st);
		System.out.println(s);
		appendNewLine(s);
		if(!has) {
			appendNewLine(st);
		}
		if(s != "" || s != null) {
			switch(state[1]) {
				case "name": parent.getPlayer().setName(s); return true;
				case "quest": parent.getPlayer().setQuest(s); return true;
				case "color": parent.getPlayer().setColor(s); return true;
			}
		}
		return false;
	}

	private void processCommand(String[] s) {
		System.out.println(Arrays.toString(s));
		if(sleepLen == 0) {
			String q = "";
			if(debug) {
				switch(s[0]) {
					case "test": q = test(s); break;
					//case "reload": reload(); break;
					default: q = ""; break;
				}
			}
			switch(s[0]) {
				case "i": q = playerInventory(s); break;
				case "inventory": q = playerInventory(s); break;
				case "l": q = look(s); break;
				case "look": q = look(s); break;
				case "sleep": sleep(s); break;
				case "name": q = name(s); break;
				case "quest": q = quest(s); break;
				case "color": q = color(s); break;
				case "exit": exit(s); break;
				default: q = ""; break;
			}
			appendNewLine(q);
		}
	}

	private String name(String[] s) {
		String q = "Your name is " + this.parent.getPlayer().getName();
		return q;
	}

	private String quest(String[] s) {
		String q = "Your quest is " + this.parent.getPlayer().getQuest();
		return q;
	}

	private String color(String[] s) {
		String q = "Your favorite color is " + this.parent.getPlayer().getColor();
		return q;
	}

	public String getInput(String[] s) {
		return "";
	}

	private String test(String[] s) {
		return "testing the command interpreter";
	}

	private String look(String[] s) {
		String q = this.parent.getCurrentRoom().getDescription() + "which contains:\n";
		ArrayList<RoomObject> objects = this.parent.getCurrentRoom().getObjects();
		if(!objects.isEmpty()) {
			for(int i=0;i<objects.size();i++) {
				q = q+"\t"+objects.get(i).getName()+"\n";
			}
		} else {
			q = "\tNothing";
		}
		return q;
	}

	private void sleep(String[] s) {
		appendNewLine("You curl up and lay down for a nap.");
		if(s.length > 1) {
			String[] nums = s[1].split("");
			sleepLen = 0;
			for(int i=1;i<nums.length;i++) {
				sleepLen*=10;
				switch(nums[i]) {
					case "1": sleepLen+=1; break;
					case "2": sleepLen+=2; break;
					case "3": sleepLen+=3; break;
					case "4": sleepLen+=4; break;
					case "5": sleepLen+=5; break;
					case "6": sleepLen+=6; break;
					case "7": sleepLen+=7; break;
					case "8": sleepLen+=8; break;
					case "9": sleepLen+=9; break;
					default: break;
				}
			}
			TimerTask sleepTask = new TimerTask() {
				@Override
				public void run() {
					if(sleepLen <= 0) {
						sleepLen = 0;
						timer.cancel();
						timer.purge();
						appendNewLine("That was a great nap.");
						appendNewLine();
					} else {
						appendNewLine("ZZZzzz...");
						sleepLen--;
					}
				}
			};
			timer.scheduleAtFixedRate(sleepTask, 1000, 1000);
		} else {
			appendNewLine("Turns out, you weren't all that tired any way.\n");
			appendNewLine();
		}
	}

	private void appendNewLine(String s) {
		appendNewLine();
		appendToOutput(s);
	}

	private void appendNewLine() {
		appendToOutput("\n");
	}

	private void appendToOutput(String s) {
		if(s != "") {
			this.parent.getOutput().append(s);
			JScrollPane sp = this.parent.getScrollPane();
			sp.getVerticalScrollBar().setValue(sp.getVerticalScrollBar().getMaximum());
			this.parent.getOutput().setCaretPosition(parent.getOutput().getDocument().getLength());
		}
	}

	private void resetInput() {
		this.parent.resetInput();
	}

	private String playerInventory(String[] s) {
		Inventory inventory = this.parent.getPlayer().getInventory();
		ArrayList<Item> items = inventory.getItems();
		String q = this.parent.getPlayer().getName() + "\'s "+inventory.getName()+":\n";
		if (!items.isEmpty()) {
			for(Item i : items) {
				q = q+"    ";
				q = q+i.getName()+": "+i.getDescription()+"\n";
			}
		} else {
			q = q+"\tEmpty";
		}
		return q;
	}

	private void exit(String[] s) {
		BaseFrame frame = this.parent.getFrame();
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}

}