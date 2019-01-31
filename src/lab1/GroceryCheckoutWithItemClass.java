package lab1;

import java.util.Scanner;

/**
 * Write a description of class GroceryCheckoutWithItemClass here. Use a single
 * ARRAY OF ITEM Objects to store the data for the purchases
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class GroceryCheckoutWithItemClass {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int numItems = 0;

		while (true) {
			System.out.print("How many items? ");
			numItems = keyboard.nextInt();
			Item items[] = new Item[numItems];

			for (int i = 0; i < numItems; i++) {
				System.out.print("enter next item and price: ");
				items[i] = new Item(keyboard.next(), keyboard.nextDouble());
			}

			welcome();

			System.out.println("Thankyou. Your items were:");
			boolean printAverage = false;

			for (int i = numItems - 1; i >= 0; i--) {
				System.out.printf("%s %.2f\n", items[i].getName(), items[i].getCost());
				if (items[i].getName().equalsIgnoreCase("peas")) {
					printAverage = true;
				}
			}

			if (printAverage) {
				System.out.printf("average price: %.2f\n", calculateAverage(items));
			} else {
				System.out.printf("no average output\n");
			}
			
			
			System.out.printf("Would you like to enter a new list? [yes/no]: ");
			if (keyboard.next().equalsIgnoreCase("no")) {
				break;
			}
		}
	}

	private static void welcome() {
		System.out.println("Welcome to MPC");
	}
	
	
	private static double calculateAverage(Item[] items) {
		double totalCost = 0;
		
		for (int i=0; i<items.length; i++) {
			totalCost += items[i].getCost();
		}
		
		return totalCost/items.length;
	}
	
	
	static class Item {
		private String name;
		private double cost;
		
		public Item() {
			
		}
		
		public Item(String name, double cost) {
			this.name = name;
			this.cost = cost;
		}
		
		public String getName() {
			return name;
		}

		public double getCost() {
			return cost;
		}
	}
}

/*
How many items? 2
enter next item and price: josh 10.50
enter next item and price: dirt 1.30
Welcome to MPC
Thankyou. Your items were:
dirt 1.30
josh 10.50
no average output
Would you like to enter a new list? [yes/no]: no
*/