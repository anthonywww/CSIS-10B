package lab6.lab6a;

/**
 * A class of bags whose entries are stored in a chain of linked nodes. The bag
 * is never full.
 * 
 * @author Frank M. Carrano
 * @version 3.0
 */
public class LinkedBag<T> implements BagInterface<T> {

	private Node root;
	private int numberOfEntries;

	public LinkedBag() {
		root = null;
		numberOfEntries = 0;
	}

	// Exercise 1 -------------------------
	public LinkedBag(T[] items) {
		for (T object : items) {
			add(object);
		}
	}

	/**
	 * Adds a new entry to this bag.
	 * 
	 * @param object the object to be added as a new entry
	 * @return true
	 */
	public boolean add(T object) {
		Node node = new Node(object);
		node.next = root;
		root = node;
		numberOfEntries++;
		return true;
	}

	/**
	 * Sees whether this bag is empty.
	 * 
	 * @return true if the bag is empty, or false if not
	 */
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	/**
	 * Sees whether this bag is full.
	 * 
	 * @return false
	 */
	public boolean isFull() { // Assumed an infinite size bag by instructor.
		return false;
	}

	/**
	 * Gets the number of entries currently in this bag.
	 * 
	 * @return the integer number of entries currently in the bag
	 */
	public int getCurrentSize() {
		return numberOfEntries;
	}

	/**
	 * Counts the number of times a given entry appears in this bag.
	 * 
	 * @param anEntry the entry to be counted
	 * @return the number of times anEntry appears in the bag
	 */
	public int getFrequencyOf(Object anEntry) {
		int frequency = 0;
		Node node = root;
		while (node != null) {
			if (node.data.equals(anEntry)) {
				frequency++;
			}
			node = node.next;
		}
		return frequency;
	}

	/**
	 * Tests whether this bag contains a given entry.
	 * 
	 * @param anEntry the entry to locate
	 * @return true if the bag contains anEntry, or false otherwise
	 */
	public boolean contains(Object anEntry) {
		// This can be O(log(n)) if we just used a loop instead of calling
		// getFrequencyOf, which is O(n).
		return getFrequencyOf(anEntry) > 0;
	}

	/**
	 * Removes one unspecified entry from this bag, if possible.
	 * 
	 * @return either the removed entry, if the removal was successful, or null
	 */
	public T remove() {
		T result = null;
		Node node = root;
		while (node != null && node.next != null) {
			node.next = node.next.next;
			node = node.next;
			numberOfEntries--;
		}
		return result;
	}

	/**
	 * Removes one occurrence of a given entry from this bag, if possible.
	 * 
	 * @param anEntry the entry to be removed
	 * @return true if the removal was successful, or false otherwise
	 */
	public boolean remove(Object anEntry) {
		boolean result = false;
		Node currentNode = findNode(anEntry);

		if (currentNode != null) {
			currentNode.data = root.data;
			remove();
			result = true;
		}

		return result;
	}

	private Node findNode(Object entry) {
		Node node = root;
		while (node != null) {
			if (entry.equals(node.data)) {
				return node;
			}
			node = node.next;
		}
		return root;
	}

	/** Removes all entries from this bag. */
	public void clear() {
		root = null;
		numberOfEntries = 0;
	}

	/**
	 * Retrieves all entries that are in this bag.
	 * 
	 * @return a newly allocated array of all the entries in the bag
	 */
	public Object[] toArray() {
		Object[] result = new Object[numberOfEntries];
		Node currentNode = root;
		for (int i = 0; i < numberOfEntries; i++) {
			result[i] = currentNode.data;
			currentNode = currentNode.next;
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public BagInterface<T> union(BagInterface<T> anotherBag) {
		T[] temp = (T[]) anotherBag.toArray();
		BagInterface<T> result = new LinkedBag<T>(temp);
		Node currentNode = root;
		while (currentNode != null) {
			result.add(currentNode.data);
			currentNode = currentNode.next;
		}
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node node = root;
		int count = 0;
		sb.append('[');
		while (node != null) {

			sb.append(node.data);

			if (count < numberOfEntries - 1) {
				sb.append(", ");
			}

			node = node.next;
			count++;
		}

		return sb.append(']').toString();
	}

	private class Node {
		public T data;
		public Node next;

		private Node(T dataPortion) {
			this(dataPortion, null);
		}

		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		}
	}
}
