public class Player extends Being {
	private String character = "@";
	private String role;
	private String color;
	private String quest;

	public Player(String n, String d, String sd, String cl) {
		super(n, d, sd, new Inventory("Main Inventory", "Player\'s main inventory", "main inventory", 100),
				new Inventory("Equipment", "Player\'s Equipment", "equip", 6),
				new Stats());
		this.role = cl;
	}

	public Player(String n, String d, String sd) {
		this(n, d, sd, "human");
	}

	public String getRole() {
		return this.role;
	}

	public void setWizard(String cl) {
		this.role = cl;
	}

	public void setQuest(String q) {
		this.quest = q;
	}

	public String getQuest() {
		return this.quest;
	}

	public void setColor(String c) {
		this.color = c;
	}

	public String getColor() {
		return this.color;
	}
}