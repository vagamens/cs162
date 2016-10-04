/* Kitten.java
   
   Class which describes a kitten
*/

public class Kitten {
	int numHairs;
	int age;
	int height;
	String name;
	boolean hasTail;
	double[] position = new double[3];

	public Kitten() {}

	public void walk(double steps, double direction) {
		this.position[1] = steps*Math.sin(direction);
		this.position[2] = steps*Math.cos(direction);
	}

	public void mew() {
		System.out.println("Mew");
	}

	public double[] getPosition() {
		return this.position;
	}

	public void setNumHairs(int hairs) {
		this.numHairs = hairs;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setHasTail(boolean tail) {
		this.hasTail = tail;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHairs() {
		return this.numHairs;
	}

	public int getAge() {
		return this.age;
	}

	public int getHeight() {
		return this.height;
	}

	public String getName() {
		return this.name;
	}

	public boolean getTail() {
		return this.hasTail;
	}
}