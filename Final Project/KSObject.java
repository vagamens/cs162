import java.awt.Dimension;

public class KSObject {
	protected String name;
	protected String description;
	protected String shortDescription;
	protected Dimension dimension;

	public KSObject(String n, String d, String sd, Dimension dim) {
		this.setName(n);
		this.setDescription(d);
		this.setShortDescription(sd);
		this.setDimension(dim);
	}

	public KSObject(String n, String d, String sd) {
		this(n, d, sd, null);
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

	public Dimension getDimension() {
		return this.dimension;
	}

	public void setDimension(Dimension dim) {
		this.dimension = dim;
	}
}