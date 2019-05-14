package lab12;

/**
 * An interface for the ADT priority queue.
 * 
 * @author Frank M. Carrano
 * @version 3.0
 */

public class PriorityQueue<T extends Comparable<? super T>> {
	
	private MaxHeap<T> myQueue;
	
	/**
	 * Adds a new entry to this priority queue.
	 * 
	 * @param newEntry an object
	 */
	public void add(T newEntry) {
	}

	/**
	 * Removes and returns the item with the highest priority.
	 * 
	 * @return either the object with the highest priority or, if the priority queue
	 *         is empty before the operation, null
	 */
	public T remove() {
		return null;
	}

	/**
	 * Retrieves the item with the highest priority.
	 * 
	 * @return either the object with the highest priority or, if the priority queue
	 *         is empty, null
	 */
	public T peek() {
		return null;
	}

	/**
	 * Detects whether this priority queue is empty.
	 * 
	 * @return true if the priority queue is empty, or false otherwise
	 */
	public boolean isEmpty() {
		return false;
	}

	/**
	 * Gets the size of this priority queue.
	 * 
	 * @return the number of entries currently in the priority queue
	 */
	public int getSize() {
		return 0;
	}

	/** Removes all entries from this priority queue */
	public void clear() {
	}
}