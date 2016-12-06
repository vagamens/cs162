import java.util.ArrayList;

public class Map extends KSObject {

	ArrayList<Room> rooms;

	public Map(String n, String d, String sd, ArrayList<Room> rooms) {
		super(n, d, sd);
		this.rooms = rooms;
	}

	public Map() {
		this("Map", "just a map", "just a map", null);
	}

	public void addRoom(Room r) {
		this.rooms.add(r);
	}

	public Room getRoom(int r) {
		return this.rooms.get(r);
	}
}