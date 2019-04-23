package lab9;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A class that implements the ADT list by using an array. The list is never
 * full.
 * 
 * @author Frank M. Carrano
 * @version 3.0
 */
public class AList<T> implements Iterable<T> {
	private T[] myArray; // array of list entries
	private int mySize;
	private static final int DEFAULT_INITIAL_CAPACITY = 25;

	// public methods:
	public AList() {
		this(DEFAULT_INITIAL_CAPACITY);
	} // end default constructor

	public AList(int initialCapacity) {
		mySize = 0;
		@SuppressWarnings("unchecked")
		T[] tempArray = (T[]) new Object[initialCapacity];
		myArray = tempArray;
	} // end constructor

	public boolean isEmpty() {
		return mySize == 0;
	} // end isEmpty

	public void add(T newEntry) {
		ensureCapacity();
		myArray[mySize] = newEntry;
		mySize++;
	} // end add

	public boolean add(int newPosition, T newEntry) {
		ensureCapacity();
		int index = newPosition - 1;
		if (index >= 0 && index <= mySize) {
			for (int k = mySize; k > index; k--) {
				myArray[k] = myArray[k - 1];
			}
			myArray[index] = newEntry;
			mySize++;
			return true;
		}
		return false;
	} // end add

	public T remove(int givenPosition) {
		int index = givenPosition - 1;
		if (index >= 0 && index < mySize) {
			T temp = (T) myArray[index];
			for (int k = index; k < mySize - 1; k++) {
				myArray[k] = myArray[k + 1];
			}
			mySize--;
			return temp;
		}
		return null;
	} // end remove

	public void clear() {
		for (int k = 0; k < mySize; k++)
			myArray[k] = null;
		mySize = 0;
	} // end clear

	public boolean replace(int givenPosition, T newEntry) {
		int index = givenPosition - 1;
		if (index >= 0 && index < mySize) {
			myArray[index] = newEntry;
			return true;
		}
		return false;
	} // end replace

	public T getEntry(int givenPosition) {
		int index = givenPosition - 1;
		if (index >= 0 && index <= mySize) {
			return myArray[index];
		} else {
			return null;
		}
	} // end getEntry

	public int getPosition(T newEntry) {
		for (int k = 0; k < mySize; k++) {
			if (newEntry == myArray[k]) {
				return k + 1;
			}
		}
		return -1;
	}

	public void moveToEnd(int givenPosition) {
		int index = givenPosition - 1;
		if (index >= 0 && index < mySize) {
			T temp = (T) myArray[index];
			for (int k = index; k < mySize - 1; k++) {
				myArray[k] = myArray[k + 1];
			}
			myArray[mySize - 1] = temp;
		}
	}

	public boolean contains(T anEntry) {
		boolean found = false;
		for (int index = 0; !found && (index < mySize); index++) {
			if (anEntry.equals(myArray[index]))
				found = true;
		} // end for

		return found;
	} // end contains

	public int getLength() {
		return mySize;
	} // end getLength

	private void ensureCapacity() {
		if (mySize == myArray.length)
			myArray = Arrays.copyOf(myArray, 2 * myArray.length);
	}

	public Object[] toArray() {
		Object[] result = new Object[mySize];
		for (int index = 0; index < mySize; index++) {
			result[index] = myArray[index];
		} // end for
		return result;
	} // end toArray

	/**
	 * Converts all the data in the bag into one big String
	 * 
	 * @return a very long String of objects contained in bag
	 */
	@Override
	public String toString() {
		int k;
		String result = "";
		for (k = 0; k < mySize; k++)
			if (k < mySize - 1)
				result += myArray[k] + ", "; // up to item before last
			else
				result += myArray[k]; // the last item
		return result;
	}

	public Iterator<T> iterator() {
		return new MySimpleIterator();
	}
	
	private class MySimpleIterator implements Iterator<T> {
		private int cursor;
		
		MySimpleIterator() {
			cursor = -1;
		}
		
		@Override
		public boolean hasNext() {
			// or cursor < mySize - 1
			return myArray[cursor+1] != null;
		}

		@Override
		public T next() {
			
			// TODO: Why this?
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			T temp = (T) myArray[++cursor];
			return temp;
			
			// Instead of:
			// return myArray[cursor++];
		}
	}
	
}