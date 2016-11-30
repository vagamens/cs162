public class Stats {
	private static final int statCount = 6;
	private final String[] statNames = {"Strength", "Dexterity", "Constitution",
										"Intelligence", "Wisdom", "Charisma"};
	private int[] stats;

	public Stats(int st, int dex, int con, int intel, int wis, int cha) {
		stats = new int[statCount];
		stats[0] = st;
		stats[1] = dex;
		stats[2] = con;
		stats[3] = intel;
		stats[4] = wis;
		stats[5] = cha;
	}

	public Stats() {
		this(0, 0, 0, 0, 0, 0);
	}

	public int[] getStats() {
		return stats;
	}

	public String[] getStatNames() {
		return statNames;
	}

	public void setStats(int[] stats) {
		this.stats = stats;
	}

	public void add(Stats addStats) {
		int[] adds = addStats.getStats();
		for (int i=0;i<stats.length;i++) {
			stats[i] = stats[i]+adds[i];
		}
	}

	public void subtract(Stats subStats) {
		int[] subs = subStats.getStats();
		for (int i=0;i<stats.length;i++) {
			stats[i] = stats[i]-subs[i];
		}
	}

	public String toString() {
		String result = "Attributes:\n";
		for(int i = 0;i<stats.length;i++) {
			result = result + "\t"+statNames[i]+": "+stats[i];
		}
		return result;
	}
}