public class KSObject {
	protected String name;
	protected String description;
	protected String shortDescription;

	public KSObject(String n, String d, String sd) {
		this.name = n;
		this.description = d;
		this.shortDescription = sd;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String n) {
		this.name = n;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String d) {
		this.description = d;
	}

	public String getShortDescription() {
		return this.shortDescription;
	}

	public void setShortDescription(String sd) {
		this.shortDescription = sd;
	}
}