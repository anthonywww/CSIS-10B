package lab10.lab10b;

import java.util.Iterator;

/**
 * An class for a dictionary with distinct search keys.
 * 
 * @author Frank M. Carrano
 * @version 3.0
 */
public class EZ_HashedDictionary {

	private String[] keys;
	private char[] values;
	private static final int CAPACITY = 7;

	public EZ_HashedDictionary() {
		keys = new String[CAPACITY];
		values = new char[CAPACITY];
	}

	public void display() {
		System.out.println("Dictionary contents: ");
		for (int k = 0; k < keys.length; k++) {
			System.out.println("\t" + keys[k] + ": " + values[k]);
		}
	}

	/**
	 * Adds a new entry to this dictionary. If the given search key already exists
	 * in the dictionary, replaces the corresponding value.
	 * 
	 * @param key   an object search key of the new entry
	 * @param value an object associated with the search key
	 * @return either null if the new entry was added to the dictionary or the value
	 *         that was associated with key if that value was replaced
	 */
	public char add(String key, char value) {
		int location = key.hashCode() % CAPACITY;

		// If current cell is occupied
		while (keys[location] != null) {
			location++;
			location %= CAPACITY;
		}

		keys[location] = key;
		values[location] = value;

		return '\0';
	}

	/**
	 * Removes a specific entry from this dictionary.
	 * 
	 * @param key an object search key of the entry to be removed
	 * @return either the value that was associated with the search key or null if
	 *         no such object exists
	 */
	public char remove(String key) {
		char value = getValue(key);

		return '\0';
	}

	/**
	 * Retrieves from this dictionary the value associated with a given search key.
	 * 
	 * @param key an object search key of the entry to be retrieved
	 * @return either the value that is associated with the search key or null if no
	 *         such object exists
	 */
	public char getValue(String key) {
		int location = key.hashCode() % CAPACITY;

		// If current cell is occupied
		while (keys[location] != null && !keys[location].equals(key)) {
			location++;
			location %= CAPACITY;
		}

		return values[location];
	}

	/**
	 * Sees whether a specific entry is in this dictionary.
	 * 
	 * @param key an object search key of the desired entry
	 * @return true if key is associated with an entry in the dictionary
	 */
	public boolean contains(String key) {
		return true;
	}

	/**
	 * Creates an iterator that traverses all search keys in this dictionary.
	 * 
	 * @return an iterator that provides sequential access to the search keys in the
	 *         dictionary
	 */
	public Iterator<String> getKeyIterator() {
		return null; // keys.iterator();
	}

	/**
	 * Creates an iterator that traverses all values in this dictionary.
	 * 
	 * @return an iterator that provides sequential access to the values in this
	 *         dictionary
	 */
	public Iterator<Character> getValueIterator() {
		return null; // values.iterator();
	}

	/**
	 * Sees whether this dictionary is empty.
	 * 
	 * @return true if the dictionary is empty
	 */
	public boolean isEmpty() {
		return true;
	}

	/**
	 * Gets the size of this dictionary.
	 * 
	 * @return the number of entries (key-value pairs) currently in the dictionary
	 */
	public int getSize() {
		return 0;
	}

	/** Removes all entries from this dictionary. */
	public void clear() {

	}
}