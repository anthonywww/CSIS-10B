package lab1;

import java.util.Scanner;

/**
 * class GroceryCheckout models a checkout counter at a store Use PARALLEL
 * ARRAYS to store the data for all the purchases
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class GroceryCheckout {
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int numItems = 0;
		
		while (true) {		
			System.out.print("How many items? ");
			numItems = keyboard.nextInt();
			String[] itemNames = new String[numItems];
			double[] itemCosts = new double[numItems];
	
			for (int i = 0; i < numItems; i++) {
				System.out.print("enter next item and price: ");
				itemNames[i] = keyboard.next();
				itemCosts[i] = keyboard.nextDouble();
			}
	
			welcome();
			
			System.out.println("Thankyou. Your items were:");
			boolean printAverage = false;
			
			for (int i = numItems-1; i >= 0; i--) {
				System.out.printf("%s %.2f\n", itemNames[i], itemCosts[i]);
				if (itemNames[i].equalsIgnoreCase("peas")) {
					printAverage = true;
				}
			}
			
			if (printAverage) {
				System.out.printf("average price: %.2f\n", calculateAverage(itemCosts));
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
	
	
	private static double calculateAverage(double[] costs) {
		double totalCost = 0;
		
		for (int i=0; i<costs.length; i++) {
			totalCost += costs[i];
		}
		return totalCost/costs.length;
	}
	
}

/*
How many items? 2
enter next item and price: wade 2.00
enter next item and price: grass 30.932
Welcome to MPC
Thankyou. Your items were:
grass 30.93
wade 2.00
no average output
Would you like to enter a new list? [yes/no]: yes
How many items? 2
enter next item and price: wade 1.0
enter next item and price: peas 10.04
Welcome to MPC
Thankyou. Your items were:
peas 10.04
wade 1.00
average price: 5.52
Would you like to enter a new list? [yes/no]: no
*/
