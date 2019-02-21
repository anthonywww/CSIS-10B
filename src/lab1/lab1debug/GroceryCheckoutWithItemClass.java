package lab1.lab1debug;

import java.util.Scanner;

/**
 * Write a description of class GroceryCheckoutWithItemClass here. Use a single
 * ARRAY OF ITEM Objects to store the data for the purchases
 * 
 * @author David Ruiz
 * @version 2/4/2019
 */
public class GroceryCheckoutWithItemClass {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		int numItems;
		String name;
		double price;
		double sum = 0.0;
		System.out.println("How many items? ");
		numItems = keyboard.nextInt();
		Item[] arrayofItems = new Item[numItems];

		for (int i = 0; i < arrayofItems.length; i++) {
			System.out.println("Enter item name");
			name = keyboard.next();
			System.out.println("Enter item price");
			price = keyboard.nextDouble();
			arrayofItems[i] = new Item(name, price);
			// arrayofItems[i].setName(name);
			// arrayofItems[i].setPrice(price);
			// arrayofItems[i] = new Item(name, price);
		}

		// call message method
		message();

		System.out.print("Thank you. Your items were:" + "\n");

		// loop through items array backwards and print the item
		for (int i = arrayofItems.length - 1; i >= 0; i--) {
			System.out.println(arrayofItems[i]);
		}

		for (int i = 0; i < arrayofItems.length; i++) {
			sum += arrayofItems[i].getPrice();
		}
		boolean found = false;
		
		for (int i = 0; i < arrayofItems.length; i++) {

			if (arrayofItems[i].getName().equalsIgnoreCase("peas")) {
				// call the average method with sum and numItems
				// average(sum, numItems);
				found = true;
			}
		}
		
		if (found) {
			average(sum, numItems);
		}
		System.out.printf("Total Price: $%.2f", sum);
		keyboard.close();
	}

	// method that prints the message "Welcome to MPC"
	public static void message() {
		System.out.println("Welcome to MPC");
	}

	// Method that calculates and print average cost of items
	public static void average(double sum, double items) {
		double avgCost;
		avgCost = sum / items;
		System.out.printf("Average Price: $%.2f\n", avgCost);
	}
}
