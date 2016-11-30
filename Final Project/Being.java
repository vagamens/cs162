public class Being extends KSObject {
	protected Stats stats;
	protected int experience;
	protected int gold;
	protected Inventory inventory;
	protected Inventory equips;
	protected boolean dead;
	protected String deathOptions;

	public Being(String n, String d, String sd, Inventory i, Inventory e, Stats st) {
		super(n, d, sd);

		stats = st;
		experience = 0;
		inventory = i;
		equips = e;

		dead = false;

		deathOptions = "\tYou have died!"
			+"\n(revive) Revive in room (-60% gold, -20% experience)"
			+"\n(respawn) Respawn at start of map (-40% gold, -40% experience)"
			+"\n(new) Create new character for a new map (-20% gold, -60% experience)"
			+"\n(quit) Quit"
			+"\n(rage Quit) Rage Quit (delete save and quit!)";
	}

	public Inventory getInventory() {
		return inventory;
	}

	public Inventory getEquipment() {
		return equips;
	}
}