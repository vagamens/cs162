import java.awt.Robot;
import java.util.Timer;
import java.util.Arrays;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.TimerTask;
import java.lang.ClassLoader;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;
import java.awt.AWTException;
import java.awt.event.WindowEvent;
import java.lang.reflect.Constructor;

public class Interpreter {

	private Game parent;
	private int sleepLen = 0;
	private String[] state = {"setup", "name"};
	private boolean debug = true;
	Timer timer = new Timer();
	private boolean[] hasPrinted = {false, false, false};
	private boolean[] firstRun = {true, true, true};

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

	private void setupPrompt(int i, String prompt) {
		if(!hasPrinted[i]) {
			appendNewLine(prompt);
			hasPrinted[i] = true;
			//robotKeyPress(KeyEvent.VK_ENTER);
		}
	}

	private void setupName(String s) {
		if(state[1] == "name") {
			setupPrompt(0, "What is your name?");
			if(s != "") {
				this.parent.getPlayer().setName(s);
				if(!firstRun[0]) {state[1] = "quest";}
			}
		}
		firstRun[0] = false;
	}

	private void setupQuest(String s) {
		if(state[1] == "quest") {
			setupPrompt(1, "what is your quest?");
			if(s != "") {
				this.parent.getPlayer().setQuest(s);
				if(!firstRun[1]) {state[1] = "color";}
			}	
		}
		firstRun[1] = false;
	}

	private void setupColor(String s) {
		if(state[1] == "color") {
			setupPrompt(2, "What is your favorite color?");
			if(s != "") {
				this.parent.getPlayer().setColor(s);
				if(!firstRun[2]) {state[1] = "done";}
			}
		}
		firstRun[2] = false;
	}
	
	private void setup(String[] s) {
		System.out.println(Arrays.toString(state));
		String q = "";
		for(int i=0;i<s.length;i++) {
			if(i != 0) {
				q = q+" ";
			}
			q = q + s[i];
		}
		System.out.println("\""+q+"\"");
		if(state[1] == "name") {setupName(q);}
		if(state[1] == "quest") {setupQuest(q);}
		if(state[1] == "color") {setupColor(q);}
		if(state[0] == "setup" && state[1] == "done") {
			state[0] = "running";
			state[1] = "";
		}
		System.out.println(Arrays.toString(state));
		
	}

	private void processCommand(String[] s) {
		System.out.println(Arrays.toString(state));
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
				case "load": load(s); break;
				case "save": save(s); break;
				case "help": help(s); break;
				case "exit": exit(s); break;
				default: q = ""; break;
			}
			appendNewLine(q);
		}
	}

	private void help(String[] s) {
		appendNewLine("Help");
		appendNewLine("    Help <command>:     get command-specific help");
		appendNewLine("    i | inventory:      list the player's inventory");
		appendNewLine("    l | look <object>:  either look about your current space or at a specific object");
		appendNewLine("    sleep <seconds>:    take a <seconds> long nap");
		appendNewLine("    name:               check your name");
		appendNewLine("    quest:              check your quest");
		appendNewLine("    color:              check your color");
		appendNewLine("    load <save>:        load a <save>");
		appendNewLine("    save:               save your current game");
		appendNewLine("    help:               print this page");
		appendNewLine("    exit:               close the game without saving");
	}

	private void save(String[] s) {
		if(s.length > 1) {
			appendNewLine("Your game has been saved");
		} else {
			appendNewLine("Save 1");
			appendNewLine("Save 2");
			appendNewLine("Save 3");
			appendNewLine("Save <save number>");
		}
	}

	private void load(String[] s) {
		if(s.length > 1) {
			appendNewLine("Your save has been loaded");
		} else {
			appendNewLine("Save 1");
			appendNewLine("Save 2");
			appendNewLine("Save 3");
			appendNewLine("Load <save number>");
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