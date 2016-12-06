import java.awt.Dimension;
import java.util.ArrayList;

public class Room extends KSObject {

	private int sizeX, sizeY;
	private String description;
	private Dimension dimension;
	private ArrayList<RoomObject> objects;

	private Room(String n, String d, String sd, Dimension dim, ArrayList<RoomObject> objects) {
		super(n, d, sd);
		this.dimension = dim;
		this.objects = objects;
	}

	public Room(String n, String d, String sd, ArrayList<RoomObject> objects) {
		this(n, d, sd, new Dimension(), objects);
	}

	public Room(String n, String d, String sd) {
		this(n, d, sd, new Dimension(100, 100), new ArrayList<RoomObject>());
	}

	public Room(Dimension dim) {
		this("Room", "Just a room", "Just a room", new Dimension(), null);
	}

	public Room() {
		this(new Dimension(100, 100));
	}

	public Dimension getSize() {
		return this.dimension;
	}

	public void setSize(Dimension dim) {
		this.dimension = dim;
	}

	public void addObject(RoomObject object) {
		this.objects.add(object);
	}

	public RoomObject getObject(int index) {
		return this.objects.get(index);
	}

	public RoomObject getObject(String name) {
		if(!this.objects.isEmpty()) {
			for(int i=0;i<this.objects.size();i++) {
				if(this.objects.get(i).getName().toLowerCase() == name) {
					return this.objects.get(i);
				}
			}
		}
		return new RoomObject(null, null, null);
	}

	public ArrayList<RoomObject> getObjects() {
		return objects;
	}
}