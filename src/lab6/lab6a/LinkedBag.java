package lab6.lab6a;

/**
 * A class of bags whose entries are stored in a chain of linked nodes. The bag
 * is never full.
 * 
 * @author Frank M. Carrano
 * @version 3.0
 */
public class LinkedBag {
	
	private Node firstNode; // reference to first node
	private int numberOfEntries;

	public LinkedBag() {
		
	}

	// Exercise 1 -------------------------
	public LinkedBag(Object[] items, int numberOfItems) {

	}

	/**
	 * Adds a new entry to this bag.
	 * 
	 * @param newEntry
	 *            the object to be added as a new entry
	 * @return true
	 */
	public boolean add(Object newEntry) // OutOfMemoryError possible
	{
		return true;
	}

	/**
	 * Sees whether this bag is empty.
	 * 
	 * @return true if the bag is empty, or false if not
	 */
	public boolean isEmpty() {
		return false;
	}

	/**
	 * Sees whether this bag is full.
	 * 
	 * @return false
	 */
	public boolean isFull() {
		return false;
	}

	/**
	 * Gets the number of entries currently in this bag.
	 * 
	 * @return the integer number of entries currently in the bag
	 */
	public int getCurrentSize() {
		return 0;
	}

	/**
	 * Counts the number of times a given entry appears in this bag.
	 * 
	 * @param anEntry
	 *            the entry to be counted
	 * @return the number of times anEntry appears in the bag
	 */
	public int getFrequencyOf(Object anEntry) {
		return 0;
	}

	/**
	 * Tests whether this bag contains a given entry.
	 * 
	 * @param anEntry
	 *            the entry to locate
	 * @return true if the bag contains anEntry, or false otherwise
	 */
	public boolean contains(Object anEntry) {
		return false;
	}

	/**
	 * Removes one unspecified entry from this bag, if possible.
	 * 
	 * @return either the removed entry, if the removal was successful, or null
	 */
	public Object remove() {
		return null;
	}

	/**
	 * Removes one occurrence of a given entry from this bag, if possible.
	 * 
	 * @param anEntry
	 *            the entry to be removed
	 * @return true if the removal was successful, or false otherwise
	 */
	public boolean remove(Object anEntry) {
		return false;
	}

	/** Removes all entries from this bag. */
	public void clear() {
	}

	// public BagInterface<T> union(BagInterface<T> anotherBag)
	// {
	//
	//
	// }

	/**
	 * Retrieves all entries that are in this bag.
	 * 
	 * @return a newly allocated array of all the entries in the bag
	 */
	public Object[] toArray() {

		return null;
	}

	public String toString() {
		return "";
	}

	private class Node {
		public Object data; // entry in bag
		public Node next; // link to next node

		private Node(Object dataPortion) {
			this(dataPortion, null);
		}

		private Node(Object dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		}
	}
}
