package lab10.lab10b;

import java.util.Iterator;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * A driver that demonstrates the class HashedDictionary. Note: The class Name
 * overrides hashCode in a way that causes collisions for the test performed by
 * testHashTable.
 * 
 * @author Frank M. Carrano
 * @version 3.0
 */
public class Driver {
	public static void main(String[] args) {
		// testDictionary();
		// testHashTable(); // with entry removal to see how TableEntry manages removals
		loadTest();
		System.out.println("\n\nDone.");
	}

	public static void loadTest() {
		// For Load Testing the HashedDictionary, print statistics on number of
		// collisions
		// We are intentionally taking the load factor Lambda past 0.5
		// where the hash table would normally resize itself
		// So to suppress the resizing we will have to set the MaxLoadFactor constant to
		// 1.0
		//
		// Do the load test first with the bad hashCode already provided in Name class
		// then switch with the better hashCode commented out
		// Also,
		// 1) add public numCollisions field to the HashedDictionary, initially 0
		// 2) in probe, under else // follow probe sequence
		// add one to numCollisions
		// 3) to switch from Linear to Quadratic probing,
		// in probe, uncomment the line // int increment = 1;
		// in probe, comment out the line // index = (index + 1) % hashTable.length;
		// in probe, uncomment the lines
		// index = (index + increment) % hashTable.length; // quadratic probing
		// **********
		// increment = increment + 2; // odd values for quadratic probing **********
		// 4) change the hashCode method for the Name class to compute the
		// hashcode using a person's full name
		// (this code is commented out in the hashCode method for Name)

		Scanner keyboard = new Scanner(System.in);
		System.out.println("enter the size of your hash table (will be increased to next prime)");
		int size = keyboard.nextInt();

		HashedDictionary<Name, String> pb = new HashedDictionary<Name, String>(size);
		try {
			Scanner file = new Scanner(new File("src/lab10/lab10b/phoneBook1k.txt"));
			while (file.hasNextLine()) {
				String fname = file.next();
				String lname = file.next();
				String pnum = file.nextLine();
				pb.add(new Name(fname, lname), pnum);
			}
			file.close();
		} catch (Exception e) {
			System.err.println(e);
			System.exit(1);
		}
		display2(pb);
		System.out.println("Number of collisions = " + pb.numCollisions);
		System.out.println("Average Number of collisions = " + pb.numCollisions/1000.0);
	}

	public static void testDictionary() {
		String dirk = "Dirk";
		String abel = "Abel";
		String miguel = "Miguel";
		String tabbie = "Tabatha";
		String tom = "Tom";
		String sam = "Sam";
		String reiss = "Reiss";
		String bette = "Bette";
		String carole = "Carole";
		String derek = "Derek";
		String nancy = "Nancy";
		String bogus = "Bo";

// create a dictionary of initial size 11
		HashedDictionary<String, String> nameList = new HashedDictionary<String, String>();

		System.out.println("\fCreate a dictionary:\n");
		System.out.println("Initial dictionary should be empty; isEmpty() returns " + nameList.isEmpty());

// test add     
		System.out.println("\n\nTesting add():\n");
		nameList.add(dirk, "555-1234");
		nameList.add(abel, "555-5678");
		nameList.add(miguel, "555-9012");
		nameList.add(tabbie, "555-3456");
		nameList.add(tom, "555-5555");
		nameList.add(sam, "555-7890");
		nameList.add(reiss, "555-2345");
		nameList.add(bette, "555-7891");
		nameList.add(carole, "555-7892");
		nameList.add(derek, "555-7893");
		nameList.add(nancy, "555-7894");

		System.out.println(nameList.getSize() + " (should be 11) items in dictionary, as follows:\n");
		display(nameList);

// test getValue
		System.out.println("\n\nTesting getValue():\n");
		System.out.println("\nAbel:   " + nameList.getValue(abel) + " should be 555-5678");
		System.out.println("\nSam:    " + nameList.getValue(sam) + " should be 555-7890");
		System.out.println("\nTom:    " + nameList.getValue(tom) + " should be 555-5555");
		System.out.println("\nReiss:  " + nameList.getValue(reiss) + " should be 555-2345");
		System.out.println("\nMiguel: " + nameList.getValue(miguel) + " should be 555-9012");

// test contains
		System.out.println("\n\n\nTesting contains():\n");

		if (nameList.contains(sam))
			System.out.println("\nSam is in dictionary - OK");
		else
			System.out.println("Error in contains()");

		if (nameList.contains(abel))
			System.out.println("\nAbel is in dictionary - OK");
		else
			System.out.println("Error in contains()");

		if (nameList.contains(miguel))
			System.out.println("\nMiguel is in dictionary - OK");
		else
			System.out.println("Error in contains()");

		if (nameList.contains(tom))
			System.out.println("\nTom is in dictionary - OK");
		else
			System.out.println("Error in contains()");

		if (!nameList.contains(bogus))
			System.out.println("\nBo is not in dictionary - OK");
		else
			System.out.println("Error in contains()");

// remove first item
		System.out.println(
				"\n\n\nRemoving first item Dirk - Dirk's number is " + nameList.remove(dirk) + " should be 555-1234");

// test replacing value
		System.out.println("Replacing phone number of Reiss and Miguel:\n");
		String oldNumber = nameList.add(reiss, "555-5432");
		System.out.println("Reiss's old number " + oldNumber + " is replaced by 555-5432");
		oldNumber = nameList.add(miguel, "555-2109");
		System.out.println("Miguel's old number " + oldNumber + " is replaced by 555-2109");

		System.out.println("\n" + nameList.getSize() + " (should be 10) items in dictionary, as follows:\n");
		display(nameList);

// remove interior and last items
		System.out.println("\n\nRemoving interior item Reiss and last item Nancy:\n");
		System.out.println(" Reiss's number is " + nameList.remove(reiss) + " should be 555-5432");
		System.out.println(" Nancy's number is " + nameList.remove(nancy) + " should be 555-7894");

// remove Bo (not in dictionary)                
		System.out.println("\nRemoving Bo (not in dictionary):\n");
		String result = nameList.remove(bogus);
		if (result == null)
			System.out.println("Bo was not found in the dictionary.");
		else
			System.out.println("Error in remove().");

		System.out.println("\n\n" + nameList.getSize() + " (should be 8) items in dictionary, as follows:\n");
		display(nameList);

// test clear
		System.out.println("\n\nTesting clear():\n");
		nameList.clear();

		System.out.println("Dictionary should be empty; isEmpty() returns " + nameList.isEmpty());
	} // testDictionary

	/** Tests the hash table when no locations contain null */
	public static void testHashTable() {
		// declaring the type of nameList as HashedDictionary instead of
		// DictionaryInterface
		// enables us to use the display method defined in HashedDictionary
		HashedDictionary<Name, String> nameList = new HashedDictionary<Name, String>(11);

		System.out.println("\n\n-----------------------------------------------------------------------\n");
		System.out.println("testHashTable():");

		System.out.println("Create a dictionary whose initial hash table has 11 locations:\n");
		System.out.println("Initial dictionary should be empty; isEmpty() returns " + nameList.isEmpty());

// add 5 names - rehashing will not occur, since the load factor will be < 0.5  
		System.out.println("\n\nTesting add() - add 5 names:\n");
		nameList.add(new Name("Tabatha"), "555-1234");
		nameList.add(new Name("Toni"), "555-1235");
		nameList.add(new Name("Tobbie"), "555-1236");
		nameList.add(new Name("Tabbie"), "555-1237");
		nameList.add(new Name("Tim"), "555-1238");

		System.out.println("Dictionary should not be full; isFull() returns " + nameList.isFull() + "\n");
		System.out.println("Dictionary contains " + nameList.getSize() + " (should be 5) items, as follows:\n");
		display2(nameList);

		System.out.println("\nThe hash table is:\n");
		nameList.display(); // display hash table [METHOD ADDED TO CLASS FOR TESTING PURPOSES]

//    We now remove a name and add a name, so the table size remains the same. Our goal is to
//    remove null from all table locations. Then we will test the method contains() in this situation.

		System.out.println("\nRemove Tabatha, add Nancy:\n");
		nameList.remove(new Name("Tabatha"));
		nameList.add(new Name("Nancy"), "555-1239");
		System.out.println("\nThe hash table is:\n");
		nameList.display();

		System.out.println("\nRemove Toni, add Derek:\n");
		nameList.remove(new Name("Toni"));
		nameList.add(new Name("Derek"), "555-1240");
		System.out.println("\nThe hash table is:\n");
		nameList.display();

		System.out.println("\nRemove Tabbie, add Carole:\n");
		nameList.remove(new Name("Tabbie"));
		nameList.add(new Name("Carole"), "555-1241");
		System.out.println("\nThe hash table is:\n");
		nameList.display();

		System.out.println("\nRemove Tobbie, add Bette:\n");
		nameList.remove(new Name("Tobbie"));
		nameList.add(new Name("Bette"), "555-1242");
		System.out.println("\nThe hash table is:\n");
		nameList.display();

		System.out.println("\nRemove Tim, add Reiss:\n");
		nameList.remove(new Name("Tim"));
		nameList.add(new Name("Reiss"), "555-1243");
		System.out.println("\nThe hash table is:\n");
		nameList.display();

		System.out.println("\nRemove Tim, add Miguel:\n");
		nameList.remove(new Name("Tim"));
		nameList.add(new Name("Miguel"), "555-1244");
		System.out.println("\nThe hash table is:\n");
		nameList.display();

		System.out.println("\nRemove Bette, add Tom:\n");
		nameList.remove(new Name("Bette"));
		nameList.add(new Name("Tom"), "555-1245");
		System.out.println("\nThe hash table is:\n");
		nameList.display();

		System.out.println("\nLocate Reis, Carole, Nancy, and Zeke: ");
		if (nameList.contains(new Name("Reiss")))
			System.out.println("Reis is in the dictionary ");
		else
			System.out.println("Reis is NOT in the dictionary: ERROR ");

		if (nameList.contains(new Name("Carole")))
			System.out.println("Carole is in the dictionary ");
		else
			System.out.println("Carole is NOT in the dictionary: ERROR ");

		if (nameList.contains(new Name("Nancy")))
			System.out.println("Nancy is in the dictionary ");
		else
			System.out.println("Nancy is NOT in the dictionary: ERROR ");

		if (nameList.contains(new Name("Zeke")))
			System.out.println("Zeke is in the dictionary: ERROR ");
		else
			System.out.println("Zeke is NOT in the dictionary ");
	}

	public static void display(HashedDictionary<String, String> dictionary) {
		Iterator<String> keyIterator = dictionary.getKeyIterator();
		Iterator<String> valueIterator = dictionary.getValueIterator();

		while (keyIterator.hasNext() && valueIterator.hasNext())
			System.out.println(keyIterator.next() + " : " + valueIterator.next());
		System.out.println();
	}

	public static void display2(HashedDictionary<Name, String> dictionary) {
		Iterator<Name> keyIterator = dictionary.getKeyIterator();
		Iterator<String> valueIterator = dictionary.getValueIterator();

		while (keyIterator.hasNext() && valueIterator.hasNext())
			System.out.println(keyIterator.next() + " : " + valueIterator.next());
		System.out.println();
	}
}
/*
 * Create a dictionary:
 * 
 * Initial dictionary should be empty; isEmpty() returns true
 * 
 * 
 * Testing add():
 * 
 * 11 (should be 11) items in dictionary, as follows:
 * 
 * Miguel : 555-9012 Derek : 555-7893 Bette : 555-7891 Tom : 555-5555 Dirk :
 * 555-1234 Sam : 555-7890 Nancy : 555-7894 Carole : 555-7892 Reiss : 555-2345
 * Tabatha : 555-3456 Abel : 555-5678
 * 
 * 
 * 
 * Testing getValue():
 * 
 * 
 * Abel: 555-5678 should be 555-5678
 * 
 * Sam: 555-7890 should be 555-7890
 * 
 * Tom: 555-5555 should be 555-5555
 * 
 * Reiss: 555-2345 should be 555-2345
 * 
 * Miguel: 555-9012 should be 555-9012
 * 
 * 
 * 
 * Testing contains():
 * 
 * 
 * Sam is in dictionary - OK
 * 
 * Abel is in dictionary - OK
 * 
 * Miguel is in dictionary - OK
 * 
 * Tom is in dictionary - OK
 * 
 * Bo is not in dictionary - OK
 * 
 * 
 * 
 * Removing first item Dirk - Dirk's number is 555-1234 should be 555-1234
 * Replacing phone number of Reiss and Miguel:
 * 
 * Reiss's old number 555-2345 is replaced by 555-5432 Miguel's old number
 * 555-9012 is replaced by 555-2109
 * 
 * 10 (should be 10) items in dictionary, as follows:
 * 
 * Miguel : 555-2109 Derek : 555-7893 Bette : 555-7891 Tom : 555-5555 Sam :
 * 555-7890 Nancy : 555-7894 Carole : 555-7892 Reiss : 555-5432 Tabatha :
 * 555-3456 Abel : 555-5678
 * 
 * 
 * 
 * Removing interior item Reiss and last item Nancy:
 * 
 * Reiss's number is 555-5432 should be 555-5432 Nancy's number is 555-7894
 * should be 555-7894
 * 
 * Removing Bo (not in dictionary):
 * 
 * Bo was not found in the dictionary.
 * 
 * 
 * 8 (should be 8) items in dictionary, as follows:
 * 
 * Miguel : 555-2109 Derek : 555-7893 Bette : 555-7891 Tom : 555-5555 Sam :
 * 555-7890 Carole : 555-7892 Tabatha : 555-3456 Abel : 555-5678
 * 
 * 
 * 
 * Testing clear():
 * 
 * Dictionary should be empty; isEmpty() returns true
 * 
 * 
 * -----------------------------------------------------------------------
 * 
 * testHashTable(): Create a dictionary whose initial hash table has 11
 * locations:
 * 
 * Initial dictionary should be empty; isEmpty() returns true
 * 
 * 
 * Testing add() - add 5 names:
 * 
 * Dictionary should not be full; isFull() returns false
 * 
 * Dictionary contains 5 (should be 5) items, as follows:
 * 
 * Tabatha : 555-1234 Tabbie : 555-1237 Tim : 555-1238 Toni : 555-1235 Tobbie :
 * 555-1236
 * 
 * 
 * The hash table is:
 * 
 * Tabatha 555-1234 Tabbie 555-1237 Tim 555-1238 Toni 555-1235 Tobbie 555-1236
 * null null null null null null
 * 
 * 
 * Remove Tabatha, add Nancy:
 * 
 * 
 * The hash table is:
 * 
 * notIn Tabbie 555-1237 Tim 555-1238 Toni 555-1235 Tobbie 555-1236 null null
 * null null null Nancy 555-1239
 * 
 * 
 * Remove Toni, add Derek:
 * 
 * 
 * The hash table is:
 * 
 * Tobbie 555-1236 Nancy 555-1239 null null null null null null Tabbie 555-1237
 * Derek 555-1240 null null null null null null null null null null null null
 * Tim 555-1238
 * 
 * 
 * Remove Tabbie, add Carole:
 * 
 * 
 * The hash table is:
 * 
 * Tobbie 555-1236 Nancy 555-1239 Carole 555-1241 null null null null null notIn
 * Derek 555-1240 null null null null null null null null null null null null
 * Tim 555-1238
 * 
 * 
 * Remove Tobbie, add Bette:
 * 
 * 
 * The hash table is:
 * 
 * notIn Nancy 555-1239 Carole 555-1241 null null null null null notIn Derek
 * 555-1240 null null null null null null null Bette 555-1242 null null null
 * null Tim 555-1238
 * 
 * 
 * Remove Tim, add Reiss:
 * 
 * 
 * The hash table is:
 * 
 * notIn Nancy 555-1239 Carole 555-1241 null null null null null notIn Derek
 * 555-1240 null null Reiss 555-1243 null null null null Bette 555-1242 null
 * null null null notIn
 * 
 * 
 * Remove Tim, add Miguel:
 * 
 * 
 * The hash table is:
 * 
 * notIn Nancy 555-1239 Carole 555-1241 null null null null null notIn Derek
 * 555-1240 null null Reiss 555-1243 Miguel 555-1244 null null null Bette
 * 555-1242 null null null null notIn
 * 
 * 
 * Remove Bette, add Tom:
 * 
 * 
 * The hash table is:
 * 
 * notIn Nancy 555-1239 Carole 555-1241 null null Tom 555-1245 null null notIn
 * Derek 555-1240 null null Reiss 555-1243 Miguel 555-1244 null null null notIn
 * null null null null notIn
 * 
 * 
 * Locate Reis, Carole, Nancy, and Zeke: Reis is in the dictionary Carole is in
 * the dictionary Nancy is in the dictionary Zeke is NOT in the dictionary
 * 
 * 
 * Done.
 */
