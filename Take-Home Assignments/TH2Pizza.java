public class TH2Pizza {

	private String[] toppings = {};

	private String sauce;

	private boolean[] cheese = new boolean[2];

	private String[] crust = new String[2];

	private String[] validToppings = {"pepperoni", "ham", "bacon", "sausage", "beef", "chicken",
									"fish", "chedder cheese", "banana peppers", "bell peppers",
									"tomatoes", "basil", "onion", "pineapple", "hot sauce", "garlic",
									"mushcooms"};

	public TH2Pizza() {

	}

	public String[] getValidToppings() {
		return this.validToppings;
	}

	public String getSauce() {
		return this.sauce;
	}

	public boolean[] getCheese() {
		return this.cheese;
	}

	public String[] getCrust() {
		return this.crust;
	}

	public void setCrust(String crust) {
		if (this.isValidCrust(crust)) {
			this.crust[0] = crust;
		}
	}

	public void setCrust(String crust, String thick) {
		this.setCrust(crust);
		this.setCrustThickness(thick);
	}

	public void setCrustThickness(String thick) {
		if (this.isValidThickness(thick)) {
			this.crust[1] = thick;
		}
	}

	public void addTopping(String top) {
		String[] temp = new String[toppings.length+1];
		for(int i=0;i<toppings.length;i++) {
			temp[i] = toppings[i];
		}
		if(isValidTopping(top)) {
			temp[temp.length-1] = top;
			toppings = temp;
		}
	}

	public void addSauce(String sauce) {
		if(isValidSauce(sauce)) {
			this.sauce = sauce;
		}
	}

	public void addCheese(Boolean cheese) {
		this.cheese[0] = cheese;
		this.cheese[1] = cheese;
	}

	public void addCheese(Boolean leftCheese, Boolean rightCheese) {
		this.cheese[0] = leftCheese;
		this.cheese[1] = rightCheese;
	}

	public String[] getToppings() {
		return this.toppings;
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
		return isValid(validToppings, topping);
	}

	private boolean isValidSauce(String sauce) {
		String[] validSauces = {"tomato", "white", "BBQ"};
		return isValid(validSauces, sauce);
	}

	private boolean isValidCrust(String crust) {
		String[] validCrusts = {"regular", "gluten free"};
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
		String[] validCheeses = {"half", "normal", "double", "none"};
		return isValid(validCheeses, cheese);
	}

	private boolean isValidDLC(String dlc) {
		String[] validDLC = {"crushed red peppers", "\"special\" crust",
							"M. Night Shroomalooms", "parmesian cheese powder"};
		return isValid(validDLC, dlc);
	}
}