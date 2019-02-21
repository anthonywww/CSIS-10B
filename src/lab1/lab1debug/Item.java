package lab1.lab1debug;

import java.util.Scanner;

/**
 * class Item represents a Grocery checkout item
 * 
 * @author David Ruiz
 * @version 2/4/2019
 */
public class Item {
	// instance variables
	private String name;
	private double price;

	/**
	 * No-args Constructor for objects of class Item (default constructor)
	 */
	public Item() {
		name = "----";
		price = 0.0;
	}

	// explicit constructor
	public Item(String name, double price) {
		this.name = name;
		this.price = price;
	}

	// getName
	public String getName() {
		return name;
	}

	// getPrice
	public double getPrice() {
		return price;
	}

	// setName
	public void setName(String name) {
		this.name = name;
	} // end setName

	// setPrice
	public void setPrice(double price) {
		this.price = price;
	}

	// toString
	@Override
	public String toString() {
		return name + " $" + price;
	}

	public static void main(String[] args) {
		// *********** test 1 No-arg Constructor, toString **********
		Item one = new Item();
		System.out.println("Item one = " + one);

		// *********** END test 1 ***********************************/
		// *********** test 2 Explicit Constructor ******************

		Item two = new Item("peas", 2.40);
		System.out.println("Item two = " + two);

		// *********** END test 2 ***********************************/
		// *********** test 3 getters and setters ********************

		one.setName("peas and carrots");
		System.out.println("Item one name = " + one.getName());

		two.setPrice(2.59);
		System.out.println("Item two price = " + two.getPrice());

		// *********** END test 3 ***********************************/
		// *********** test 4 check if we have peas *******************
		// two ways to check if we have peas

		if (one.getName().equals("peas")) // comparing two Strings
			System.out.println("Item one: Nice peas there");

		if (two.getName().equals("peas"))
			System.out.println("Item two: Nice peas there");

		// *********** end test 4 *********************************/
		// *********** test 5 read an Item object from Scanner ******
		Scanner keyboard = new Scanner(System.in);
		String name;
		double price;

		System.out.print("Enter an item (name and price): ");
		name = keyboard.next();
		price = keyboard.nextDouble();

		Item three = new Item(name, price);
		System.out.println("Item three = " + three);

		System.out.print("Enter a new name and price for Item three: ");
		name = keyboard.next();
		price = keyboard.nextDouble();
		three.setName(name);
		three.setPrice(price);
		System.out.println("Item three now = " + three);

		// *********** end test 5 *********************************/
		keyboard.close();
	}
}
