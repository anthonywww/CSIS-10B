package assignment3;

import java.util.Vector;

/**
 * Write a description of class FunWithVector here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class FunWithVector {
	
	public static void main(String[] args) {
		
		// create a Vector object
		Vector<String> myList = new Vector<String>();

		// add some items at the end
		myList.add("hey");
		myList.add("there");
		myList.add("people");
		System.out.println("myList = " + myList);

		// add some items in the middle
		myList.add(0, "eh-hem! ");
		myList.add(3, "all you ");
		System.out.println("myList = " + myList);

		// remove some items
		myList.remove(3);
		myList.remove("eh-hem! ");
		System.out.println("myList = " + myList);
	}
}
