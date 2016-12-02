import java.util.ArrayList;

public class Inventory {

	public static final int DEFAULT_CAPACITY = 10;

	private String name;
	private String description;
	private String shortDescription;

	private int capacity;
	private int size;

	private ArrayList<Item> items;

	public Inventory(String n, String d, String sd, int c, ArrayList<Item> i) {
		this.name = n;
		this.description = d;
		this.shortDescription = sd;

		this.capacity = c;
		this.size = i.size();

		this.items = i;
	}

	public Inventory(String n, String d, String sd, int c) {
		this(n, d, sd, c, new ArrayList<Item>());
	}

	public Inventory(String n, String d, String sd) {
		this(n, d, sd, DEFAULT_CAPACITY, new ArrayList<Item>());
	}

	public Inventory() {
		this("not yet named", "not yet described", "not yet short described", DEFAULT_CAPACITY, new ArrayList<Item>());
	}

	public int getSize() {
		return size;
	}

	public int getCapacity() {
		return capacity;
	}

	public String getName() {
		return this.name;
	}

	public int add(Item i) {
		int success = 0;
		if(size < capacity) {
			items.add(i);
			success = 1;
		}
		return success;
	}

	public Item getItemByName(String iName) {
		Item result = null;
		for(Item i : items) {
			if(i.getName().equals(iName)) {
				result = i;
			}
		}
		return result;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public Item remove(int iNum) {
		Item success = null;
		if(size >= iNum) {
			success = items.remove(iNum);
		}
		return success;
	}

	//returns position of newItem in the items list or -1 if it does not exist
	public int indexOf(Item i) {
		return items.indexOf(i);
	}
}