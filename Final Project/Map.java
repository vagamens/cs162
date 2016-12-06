import java.util.ArrayList;

public class Map extends KSObject {

	ArrayList<Room> rooms;

	public Map(String n, String d, String sd, ArrayList<Room> rooms) {
		super(n, d, sd);
		this.rooms = rooms;
	}

	public Map(String n, String d, String sd) {
		this(n, d, sd, new ArrayList<Room>());
	}

	public Map() {
		this("Map", "just a map", "just a map", new ArrayList<Room>());
	}

	public void addRoom(Room r) {
		this.rooms.add(r);
	}

	public Room getRoom(int r) {
		return this.rooms.get(r);
	}
}