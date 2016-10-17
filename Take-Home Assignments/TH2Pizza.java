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
		if(top == "pizza") {
			top = new TH2Pizza();
		}
		temp[temp.length-1] = top;
	}

	public void addSauce(String sauce) {
		this.sauce = {sauce, sauce};
	}

	public void addSauce(String leftSauce, String rightSauce) {
		this.sauce = {leftSauce, rightSauce};
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

	public void getToppings() {
		return toppings;
	}

	public void getPizza()
}