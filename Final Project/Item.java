public class Item extends KSObject {

	private Stats stats;

	public Item(String n, String d, String sd, Stats st) {
		super(n, d, sd);

		this.stats = st;
	}

	public Item(String n, String d, String sd) {
		this(n, d, sd, new Stats());
	}

	public Item() {
		this("not yet named", "not yet described", "not yet short described", new Stats());
	}

	public Stats getStats() {
		return stats;
	}

	public void setStats(Stats st) {
		this.stats = st;
	}
}