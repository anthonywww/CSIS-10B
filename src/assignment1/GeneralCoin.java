package assignment1;

import java.util.Random;

/**
 * class GeneralCoin represents a coin that can be flipped.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class GeneralCoin {
	
	// Why the hell are we using a string instead of a boolean?
	private String sideUp;
	private Random gen;

	/**
	 * Constructor for objects of class GeneralCoin
	 */
	public GeneralCoin() {
		gen = new Random();
		// randomly set sideUp to either "heads" or "tails"
		// based on the outcome of gen.nextInt(2)
		toss();
	}

	// add methods to getSideUp, setSideUp, and toss the coin
	public String getSideUp() {
		return sideUp;
	}
	
	public void setSideUp(String sideUp) {
		this.sideUp = sideUp;
	}
	
	public void toss() {
		sideUp = (gen.nextInt(2) == 1 ? "heads" : "tails");
	}
}
