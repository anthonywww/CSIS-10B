
import assignment1.Coin;
import assignment1.GeneralCoin;

/**
 * Write a description of class CoinApp here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class CoinApp {

	public static void main(String[] args) {
		// ******************** Prob 2b) ****************************************
		// Write a program that tosses two GeneralCoin coins 50 times each.
		// Record and report how many times each coin lands heads up.
		// Also report which coin landed heads up most often.
		//
		// use the following to get started

		GeneralCoin a = new GeneralCoin();
		GeneralCoin b = new GeneralCoin();

		a.toss();
		b.toss();

		System.out.println("Coin a is " + a.getSideUp() + " and Coin b is " + b.getSideUp());

		// Now add statements to toss both coins 50 times,
		// count the number of times each coin came up heads
		// print the results, and print which coin had more heads

		int countHeadsA = 0; // to store the number of heads for coin A
		int countHeadsB = 0; // B

		// continue...

		for (int i = 0; i < 50; i++) {
			a.toss();
			b.toss();

			if (a.getSideUp().equals("heads")) {
				countHeadsA++;
			}
			if (b.getSideUp().equals("heads")) {
				countHeadsB++;
			}
		}

		System.out.printf("Coin a heads count = %d , Coin b heads count = %d\n", countHeadsA, countHeadsB);

		// ******************** END Prob 2b) ****************************************/
		// ******************** Prob 2D) ****************************************
		// Write a small program that tests your Coin class.
		// (Essentially, repeating the steps from 2B but with Coin objects)
		// Show that your new coins inherit the behaviors of a GeneralCoin object.
		// (i.e. they can also be tossed)

		// Here is an example with one coin
		Coin coinA = new Coin();
		coinA.setValue(25);
		coinA.setName("Quarter");
		coinA.toss();

		System.out.println("Coin a is a " + coinA.getName());
		System.out.println("Coin a value is " + coinA.getValue());
		System.out.println("Coin a side up is " + coinA.getSideUp());

		/******************** END Prob 2D) ****************************************/
		// ******************** Prob 2E) ****************************************
		// Write your coin tossing application here after reading assignment1
		// handout step 2E

		Coin theCoin = new Coin(); // we can reuse this one variable for all coins
		ArrayBag<Coin> headCoins = new ArrayBag<Coin>(40);

		// use either an array of Coin or an ArrayBag<Coin> for the tailCoins
		ArrayBag<Coin> tailCoins = new ArrayBag<Coin>();

		// write a for loop that repeats 10 times, the following code

		// a) assign theCoin a new Coin
		// set the value to 1, name to "penny" and toss theCoin
		// if theCoin is heads, add it to the headCoins bag, etc

		// b) assign theCoin a new Coin
		// set the value to 5, name to "nickel" and toss theCoin
		// if theCoin is heads, add it to the headCoins bag, etc

		// c) and d) repeat for dimes and quarters

		for (int i = 0; i < 10; i++) {
			theCoin = new Coin();
			theCoin.setValue(1);
			theCoin.setName("penny");
			theCoin.toss();

			if (theCoin.getSideUp().equals("heads")) {
				headCoins.add(theCoin);
			} else {
				tailCoins.add(theCoin);
			}

			theCoin = new Coin();
			theCoin.setValue(5);
			theCoin.setName("nickel");
			theCoin.toss();

			if (theCoin.getSideUp().equals("heads")) {
				headCoins.add(theCoin);
			} else {
				tailCoins.add(theCoin);
			}

			theCoin = new Coin();
			theCoin.setValue(10);
			theCoin.setName("dimes");
			theCoin.toss();

			if (theCoin.getSideUp().equals("heads")) {
				headCoins.add(theCoin);
			} else {
				tailCoins.add(theCoin);
			}

			theCoin = new Coin();
			theCoin.setValue(25);
			theCoin.setName("quarters");
			theCoin.toss();

			if (theCoin.getSideUp().equals("heads")) {
				headCoins.add(theCoin);
			} else {
				tailCoins.add(theCoin);
			}
		}

		// end the coin creating for loop

		// write a loop that removes all coins from headBag and counts their
		// their total value

		int totalAmtHeads = 0;
		int totalAmtTails = 0;

		while (!headCoins.isEmpty()) {
			totalAmtHeads += headCoins.remove().getValue();
		}

		while (!tailCoins.isEmpty()) {
			totalAmtTails += tailCoins.remove().getValue();
		}

		// write a loop that counts all the tailCoin values

		// add up the two totals and make sure they equal 410 cents!!

		System.out.printf("Heads amt = %d , Tails amt = %d , Total = %d\n", totalAmtHeads, totalAmtTails,
				totalAmtHeads + totalAmtTails);

		// ******************** END Prob 2E) ****************************************/
	}
}

/*
Coin a is heads and Coin b is tails
Coin a heads count = 23 , Coin b heads count = 22
Coin a is a Quarter
Coin a value is 25
Coin a side up is heads
Heads amt = 142 , Tails amt = 268 , Total = 410
*/