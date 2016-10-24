public class TH2Pizza {

	String[] toppings = {};

	String[] sauce = new String[2];

	String[][] cheese = new String[2][2];

	public TH2Pizza() {

	}

	public void addTopping(String top) {
		String[] temp = new String[toppings.length+1];
		for(int i=0;i<toppings.length;i++) {
			temp[i] = toppings[i];
		}
		temp[temp.length-1] = top;
	}

	public void addSauce(String sauce) {
		this.sauce[0] = sauce;
		this.sauce[1] = sauce;
	}

	public void addSauce(String leftSauce, String rightSauce) {
		this.sauce[0] = leftSauce;
		this.sauce[1] = rightSauce;
	}

	public void addCheese(String cheese) {
		this.cheese[0][0] = cheese;
		this.cheese[1][0] = cheese;
	}

	public void addCheese(String[] cheese) {
		this.cheese[0] = cheese;
		this.cheese[1] = cheese;
	}

	public void addCheese(String[] leftCheese, String[] rightCheese) {
		this.cheese[0] = leftCheese;
		this.cheese[1] = rightCheese;
	}

	public String[] getToppings() {
		return toppings;
	}

	public TH2Pizza getPizza() {
		return this;
	}

	private boolean isValid(String[] stuff, String check) {
		for(String s : stuff) {
			if(check == s) {
				return true;
			}
		}
		return false;
	}

	private boolean isValidTopping(String topping) {
		String[] validToppings = {"pepperoni", "ham", "bacon", "sausage", "beef", "chicken",
									"fish", "chedder cheese", "banana peppers", "bell peppers",
									"tomatoes", "basil", "onion", "pineapple", "hot sauce", "garlic",
									"mushcooms"};

		return isValid(validToppings, topping);
	}

	private boolean isValidSauce(String sauce) {
		String[] validSauces = {"tomato", "white", "BBQ"};
		return isValid(validSauces, sauce);
	}

	private boolean isValidCrust(String crust) {
		String[] validCrusts = {"regular", "gluten  free"};
		return isValid(validCrusts, crust);
	}

	private boolean isValidThickness(String thickness) {
		String[] validThicknesses = {"thick", "thin", "flat"};
		return isValid(validThicknesses, thickness);
	}

	private boolean isValidSize(String size) {
		String[] validSizes = {"personal", "small", "medium", "large"};
		return isValid(validSizes, size);
	}

	private boolean isValidCheeseAmount(String cheese) {
		String[] validCheeses = {"half", "normal", "double", "non"};
		return isValid(validCheeses, cheese);
	}

	private boolean isValidDLC(String dlc) {
		String[] validDLC = {"crushed red peppers", "\"special\" crust",
							"M. Night Shroomalooms", "parmesian cheese powder"};
		return isValid(validDLC, dlc);
	}
}