package assignment3;

import java.util.Vector;

/**
 * Implements a Queue using a Vector
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class VQueue<E> {

	// declare a Vector<E> queue here to hold the data in the VQueue
	private Vector<E> vector;

	public VQueue() {
		vector = new Vector<E>();
	}

	public void enqueue(E value) {
		vector.add(value);
	}

	public E dequeue() {
		return vector.remove(0);
	}

	public E getFront() {
		return vector.get(0);
	}

	public boolean isEmpty() {
		return vector.size() == 0;
	}

	public int size() {
		return vector.size();
	}

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < vector.size(); i++) {
			result = result + " " + vector.get(i);
		}
		return result;
	}

}