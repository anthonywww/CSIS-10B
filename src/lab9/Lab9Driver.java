package lab9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Random;
import java.util.Vector;

/**
 * Write a description of class FunWithIterators here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lab9Driver {
	public static void main(String[] args) {

		// ***************** 0 Iterator Demo ********************************

		Vector<String> v = new Vector<String>();

		v.add("mon");
		v.add("tue");
		v.add("wed");
		v.add("thur");
		v.add("fri");
		v.add("sat");
		v.add("sun");

		// create an Iterator for v
		Iterator<String> vit = v.iterator();

		// print all items in v converted to upper case
		while (vit.hasNext()) {
			System.out.println(vit.next().toUpperCase());
		}

		// notice you can't go backwards (previous not defined)

		// create a ListIterator for v and try forward/reverse iteration
		ListIterator<String> lit = v.listIterator();
		System.out.println(lit.next());
		System.out.println(lit.next());
		System.out.println(lit.next());

		// remove wed from v
		lit.remove();

		System.out.println("v = " + v);

		for (String s : v) {
			System.out.println("s = " + s.toUpperCase());
		}

		/******************** end *****************************************/
		// ******** 1 Add Iterator to our own AList class, test here *********

		//AList<String> list = new AList<String>();
		LList<String> list = new LList<String>();

		list.add("jan");
		list.add("feb");
		list.add("mar");
		list.add("apr");
		list.add("may");
		list.add("jun");

		Iterator<String> it = list.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

		for (String s : list) {
			System.out.println(s.toUpperCase());
		}

		/******************** end *****************************************/
		/********
		 * 2 Complete the CharIterator clsss, test here *********** StringBuilder test =
		 * new StringBuilder("hellooooo wooorld");
		 * 
		 * /**** a) Create a CharIterator and use it in a loop to display all letters //
		 * in String test CharIterator ci = new CharIterator(test);
		 * 
		 * // make a while loop that displays all characters one at a time using ci.
		 * 
		 * 
		 * /**** b) Create a new CharIterator and use it to remove all letter 'o's in
		 * the // String test. Show test after your operation completes.
		 * 
		 * 
		 * 
		 * /******************** end
		 *****************************************/
		StringBuilder test = new StringBuilder("hellooooo wooorld");
		// test.deleteCharAt(3);
		System.out.println(test);

		// a:
		CharIterator ci = new CharIterator(test);
		while (ci.hasNext()) {
			System.out.print(ci.next());
			System.out.println(" hasNext(): " + ci.hasNext());
		}

		System.out.println();

		// b: remove all 'o's in test.
		CharIterator ci2 = new CharIterator(test);
		while (ci2.hasNext()) {
			char c = ci2.next();
			System.out.print(c);
			if (c == 'o') {
				ci2.remove();
			}
		}

		System.out.println();
		System.out.println("now test = " + test);

		// ******** 3 Do the Solitaire Game Program here *******************

		// define the ArrayList to hold the numbers
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		// this test pattern should get a win: 34 10 82 89 12 84 23 53
		list1.add(34);
		list1.add(10);
		list1.add(82);
		list1.add(89);
		list1.add(12);
		list1.add(84);
		list1.add(23);
		list1.add(53);

		// test setup for dealing with numbers
		Random rand = new Random();
		for (int k = 0; k < 20; k++) {
			int value = 10 + rand.nextInt(90);
			// list1.add(value);
			System.out.println("Test random gen: " + value);
			System.out.println("1st digit: " + value / 10);
			System.out.println("2nd digit: " + value % 10);
		}

		// print your ArrayList after it is initialized with values
		System.out.println(list1);

		// define the ListIterator to iterate over the ArrayList
		ListIterator<Integer> li = list1.listIterator();

		// process the list using your ListIterator, according to the handout

		// HINT code this and put in a loop
		// there ARE some tricks and surprises along the way!!
		int val1 = li.next();
		int val2 = li.next();

		// get val1a = first digit of val1 (divide by 10)
		// val1b = second digit (mod % 10)
		// etc

		if (val1 / 10 == val2 / 10 || val1 % 10 == val2 % 10) {
			li.remove();
			li.previous();
			li.remove();
			System.out.println(list1);
		}

		/******************** end *****************************************/

		// ******** 4 Extend a SortedAList from the AList class, test here *************
		System.out.println("Testing add() ");
		SortedArrayList<String> myList = new SortedArrayList<String>();

		myList.add("45");
		myList.add("15");
		myList.add("25");
		myList.add("35");
		myList.add("55");
		myList.add("95");
		myList.add("85");
		myList.add("65");
		myList.add("75");

		System.out.println("List should contain 15, 25, 35, 45, 55, 65, 75, 85, 95\n");
		System.out.println("myList = " + myList);

		System.out.println("Testing getPosition() ");
		System.out.println("15 is at position " + myList.getPosition("15"));
		System.out.println("55 is at position " + myList.getPosition("55"));
		System.out.println("95 is at position " + myList.getPosition("95"));
		System.out.println("0 s/b at position " + myList.getPosition("0"));
		System.out.println("50 s/b at position " + myList.getPosition("50"));
		System.out.println("90 s/b at position " + myList.getPosition("90"));
		System.out.println("99 s/b at position " + myList.getPosition("996"));

		System.out.println("\nTesting remove() ");
		System.out.println("Removing 15: returns " + myList.remove("15"));
		System.out.println("Removing 55: returns " + myList.remove("55"));
		System.out.println("Removing 95: returns " + myList.remove("95"));
		System.out.println("Removing 0: returns " + myList.remove("0"));
		System.out.println("List should contain 25, 35, 45, 65, 75, 85\n");
		System.out.println("myList = " + myList);

		/******************** end *****************************************/
		// ******** 5 Solve the PacketReader problem in the PacketReader class
		// *************
		// then move on to number 6

		// ok

		/******************** end *****************************************/

		// ******** 6 Solve the SearchRange problem. Write code or a method
		// that meets the description in the lab9 handout. The method could
		// print the range or return an array of the min and max values in range

		int[] data = { 5, 8, 10, 13, 15, 20, 22, 26 };
		int[] targets = { 8, 2, 9, 17 };

		Arrays.sort(targets);
		
		// use Arrays.binarySearch to find the min and max cell numbers that
		// contain the range of values stored in target
		
		for (int target : targets) {
			int value = Arrays.binarySearch(targets, target);
			System.out.println(value);
		}

		/******************** end *****************************************/

		/********
		 * 7 Add an iterator class to the LList class. Test it using the code in step 1
		 */
		
		// ok
		
	}
}
