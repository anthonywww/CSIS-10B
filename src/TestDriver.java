
// Change DEFAULT_INITIAL_CAPACITY in SortedArrayDictionary to 6
import java.util.Iterator;

/**
 * A driver that demonstrates the class SortedArrayDictionary.
 * 
 * @author Frank M. Carrano
 * @version 3.0
 */
public class TestDriver {
	
	public static void main(String[] args) {
		// 1) DEMO working with a dictionary of names and phone numbers
		// a) create an empty dictionary that will contain the names (first names) and
		// telephone numbers of your
		// friends.
		SortedArrayDictionary<String, String> phoneBook = new SortedArrayDictionary<String, String>();

		// b) add several names and telephone numbers to the dictionary that you created
		phoneBook.add("Jack", "111-2222");
		phoneBook.add("Curly", "111-2222");
		phoneBook.add("Tina", "111-2222");
		phoneBook.add("Steve", "111-2222");
		
		
		// c) print the entire phone book
		Iterator<String> keyIterator = phoneBook.getKeyIterator();
		Iterator<String> valueIterator = phoneBook.getValueIterator();
		while (keyIterator.hasNext()) {
			System.out.println(keyIterator.next() + " " + valueIterator.next());
		}
		
		// d) display either Steve’s telephone number, if he is in the dictionary, or an
		// error message
		// if he is not
		
		if (phoneBook.contains("Steve")) {
			System.out.println("Steve's number is " + phoneBook.getValue("Steve"));
		}

		// e) update one of the entries with a new phone number
		String oldNumber = phoneBook.add("Steve", "444-5555");
		System.out.println("Steve's old number " + oldNumber);
		
		// f) print the entire book again, verify the new number has been recorded
		display(phoneBook);
		
		// testDictionary();
		System.out.println("\n\nDone.");
	} // end main

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

		SortedArrayDictionary<String, String> nameList = new SortedArrayDictionary<String, String>();

		System.out.println("Create a dictionary:\n");
		System.out.println("Initial dictionary should be empty; isEmpty() returns " + nameList.isEmpty());

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

		System.out.println("\n\nTesting getValue():\n");
		System.out.println("\nAbel:   " + nameList.getValue(abel) + " should be 555-5678");
		System.out.println("\nSam:    " + nameList.getValue(sam) + " should be 555-7890");
		System.out.println("\nTom:    " + nameList.getValue(tom) + " should be 555-5555");
		System.out.println("\nReiss:  " + nameList.getValue(reiss) + " should be 555-2345");
		System.out.println("\nMiguel: " + nameList.getValue(miguel) + " should be 555-9012");

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
		
		System.out.println("\n\n\nRemoving first item Dirk - Dirk's number is " + nameList.remove(dirk) + " should be 555-1234");

		System.out.println("Replacing phone number of Reiss and Miguel:\n");
		String oldNumber = nameList.add(reiss, "555-5432");
		System.out.println("Reiss's old number " + oldNumber + " is replaced by 555-5432");
		oldNumber = nameList.add(miguel, "555-2109");
		System.out.println("Miguel's old number " + oldNumber + " is replaced by 555-2109");

		System.out.println("\n" + nameList.getSize() + " (should be 10) items in dictionary, as follows:\n");
		display(nameList);

		System.out.println("\n\nRemoving interior item Reiss and last item Nancy:\n");
		nameList.remove(reiss);
		nameList.remove(nancy);
				
		System.out.println("\nRemoving Bo (not in dictionary):\n");
		String result = nameList.remove(bogus);
		if (result == null) {
			System.out.println("Bo was not found in the dictionary.");
		} else {
			System.out.println("Error in remove().");
		}

		System.out.println("\n\n" + nameList.getSize() + " (should be 8) items in dictionary, as follows:\n");
		display(nameList);
		
		System.out.println("\n\nTesting clear():\n");
		nameList.clear();

		System.out.println("Dictionary should be empty; isEmpty() returns " + nameList.isEmpty());
	} // testDictionary

	public static void display(SortedArrayDictionary<String, String> dictionary) {
		Iterator<String> keyIterator = dictionary.getKeyIterator();
		Iterator<String> valueIterator = dictionary.getValueIterator();

		while (keyIterator.hasNext() && valueIterator.hasNext())
			System.out.println(keyIterator.next() + " : " + valueIterator.next());
		System.out.println();
	}
	
	public static void display(EZ_Dictionary<String, String> dictionary) {
		Iterator<String> keyIterator = dictionary.getKeyIterator();
		Iterator<String> valueIterator = dictionary.getValueIterator();

		while (keyIterator.hasNext() && valueIterator.hasNext()) {
			System.out.println(keyIterator.next() + " : " + valueIterator.next());
		}
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
 * Dirk : 555-1234 Abel : 555-5678 Miguel : 555-9012 Tabatha : 555-3456 Tom :
 * 555-5555 Sam : 555-7890 Reiss : 555-2345 Bette : 555-7891 Carole : 555-7892
 * Derek : 555-7893 Nancy : 555-7894
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
 * Nancy : 555-7894 Abel : 555-5678 Miguel : 555-2109 Tabatha : 555-3456 Tom :
 * 555-5555 Sam : 555-7890 Reiss : 555-5432 Bette : 555-7891 Carole : 555-7892
 * Derek : 555-7893
 * 
 * 
 * 
 * Removing interior item Reiss and last item Nancy:
 * 
 * 
 * Removing Bo (not in dictionary):
 * 
 * Bo was not found in the dictionary.
 * 
 * 
 * 8 (should be 8) items in dictionary, as follows:
 * 
 * Carole : 555-7892 Abel : 555-5678 Miguel : 555-2109 Tabatha : 555-3456 Tom :
 * 555-5555 Sam : 555-7890 Derek : 555-7893 Bette : 555-7891
 * 
 * 
 * 
 * Testing clear():
 * 
 * Dictionary should be empty; isEmpty() returns true
 * 
 * 
 * Done.
 */
