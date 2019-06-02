package lab5;

import java.util.Arrays;

import lab6.lab6a.BagInterface;

/**
 * A class of bags whose entries are stored in a fixed-size array.
 * @param <T>
 */
public class ArrayBag<T> implements BagInterface<T> {

	private T[] myArray;
	private static final int DEFAULT_CAPACITY = 25;
	private int mySize;

	/** Creates an empty bag whose initial capacity is 25. */
	public ArrayBag() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Creates an empty bag having a given initial capacity.
	 * 
	 * @param capacity the integer capacity desired
	 */
	@SuppressWarnings("unchecked")
	public ArrayBag(int capacity) {
		myArray = (T[]) new Object[capacity];
		mySize = 0;
	}

	/**
	 * Adds a new entry to this bag.
	 * 
	 * @param newEntry the object to be added as a new entry
	 * @return true if the addition is successful, or false if not
	 */
	public boolean add(T newEntry) {
		if (!isFull()) {
			myArray[mySize] = newEntry;
			mySize++;
			return true;
		}
		return false;
	}

	/**
	 * Sees whether this bag is empty.
	 * 
	 * @return true if this bag is empty, or false if not
	 */
	public boolean isEmpty() {
		return mySize == 0;
	}

	/**
	 * Sees whether this bag is full.
	 * 
	 * @return true if this bag is full, or false if not
	 */
	public boolean isFull() {
		return mySize == myArray.length;
	}

	/**
	 * Gets the current number of objects in this bag.
	 * 
	 * @return the integer number of objects currently in the bag
	 */
	public int getCurrentSize() {
		return mySize;
	}

	/**
	 * Counts the number of times a given entry appears in this bag.
	 * 
	 * @param anEntry the entry to be counted
	 * @return the number of times anEntry appears in the bag
	 */
	public int getFrequencyOf(Object anEntry) {
		int freq = 0;

		for (int i = 0; i < myArray.length; i++) {
			if (anEntry.equals(myArray[i])) {
				freq++;
			}
		}

		return freq;
	}

	/**
	 * Tests whether this bag contains a given entry.
	 * 
	 * @param anEntry the entry to locate
	 * @return true if this bag contains anEntry, or false otherwise
	 */
	public boolean contains(Object anEntry) {

		for (int i = 0; i < myArray.length; i++) {
			if (anEntry.equals(myArray[i])) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Removes one unspecified entry from this bag, if possible.
	 * 
	 * @return either the removed entry, if the removal was successful, or null
	 */
	public T remove() {
		if (!isEmpty()) {
			T o = myArray[mySize - 1];
			myArray[mySize - 1] = null;
			mySize--;
			return o;
		}
		return null;
	}

	/**
	 * Removes one occurrence of a given entry from this bag.
	 * 
	 * @param anEntry the entry to be removed
	 * @return true if the removal was successful, or false otherwise
	 */
	public boolean remove(Object anEntry) {
		if (contains(anEntry)) {
			for (int i = 0; i < mySize; i++) {
				if (myArray[i].equals(anEntry)) {
					myArray[i] = myArray[mySize];
					myArray[mySize] = null;
					mySize--;
					return true;
				}
			}
		}
		return false;
	}

	/** Removes all entries from this bag. */
	public void clear() {
		for (int i = 0; i < myArray.length; i++) {
			remove();
		}
	}

	/**
	 * Retrieves all entries that are in this bag.
	 * 
	 * @return a newly allocated array of all the entries in the bag
	 */
	public Object[] toArray() {
		return Arrays.copyOf(myArray, mySize);
	}

	/**
	 * Converts all the data in the bag into one big String
	 * 
	 * @return a very long String of objects contained in bag
	 */
	@Override
	public String toString() {
		int k;
		String result = "[";
		for (k = 0; k < mySize; k++) {
			if (k < mySize - 1) {
				result += myArray[k] + ", "; // up to item before last
			} else {
				result += myArray[k]; // the last item
			}
		}
		return result + "]";
	}

	@Override
	public BagInterface<T> union(BagInterface<T> anotherBag) {
		return null;
	}

}
