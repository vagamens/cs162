import java.util.Timer;
import java.util.TimerTask;

public class Game {

	private int state = 0;
	BaseFrame frame;
	GamePanel panel;

	public Game() {
		frame = new BaseFrame("Kitten Simulator");

		panel = new GamePanel(frame);

		frame.add(panel);
	}

	public void run() {
		switch(state) {
			case 0: prompt("What is your name?");
			case 1: prompt("What is your quest?");
			case 2: prompt("what is your favorite color?");
		}
	}

	private void prompt(String s) {
		panel.getTextArea().append(s);
		state++;
	}

	private class GameTimer extends TimerTask {
		
		@Override
		public void run() {
			run();
		}

		public void completeTask() {}
	}
}