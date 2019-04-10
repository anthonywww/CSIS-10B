package lab5;

import java.util.Arrays;

/**
 * A class that implements the ADT list by using an array. The list is never
 * full.
 * 
 * @author Frank M. Carrano
 * @version 3.0
 */
public class ArrayList<T> {
	private T[] myArray;
	private int mySize;
	private static final int DEFAULT_INITIAL_CAPACITY = 25;

	// public methods:
	public ArrayList() {
		this(DEFAULT_INITIAL_CAPACITY);
	}

	public ArrayList(int initialCapacity) {
		mySize = 0;
		@SuppressWarnings("unchecked")
		T[] tempArray = (T[]) new Object[initialCapacity];
		myArray = tempArray;
	}

	public boolean isEmpty() {
		return mySize == 0;
	}

	public void add(T newEntry) {
		ensureCapacity();
		myArray[mySize] = newEntry;
		mySize++;
	}

	public boolean add(int newPosition, T newEntry) {
		if (newPosition > 0) {
			ensureCapacity();
			if (newPosition < myArray.length) {
				for (int i=mySize; i>=newPosition; i--) {
					myArray[i] = myArray[i-1];
				}
				myArray[newPosition-1] = newEntry;
				return true;
			}
		}
		return false;
	}

	public T remove(int givenPosition) {
		if (givenPosition > mySize) {
			return null;
		}
		T o = myArray[givenPosition];
		for (int i=givenPosition;i<mySize;i++) {
			myArray[givenPosition] = myArray[givenPosition+1];
		}
		mySize -= 1;
		return o;
	}

	public void clear() {
		for (int k = 0; k < mySize; k++) {
			myArray[k] = null;
		}
		mySize = 0;
	}

	public boolean replace(int givenPosition, T newEntry) {
		if (givenPosition > mySize) {
			return false;
		}
		
		myArray[givenPosition] = newEntry;
		
		return true;
	}

	public T getEntry(int givenPosition) {
		if (!isEmpty()) {
			if (myArray[givenPosition-1] != null) {
				return myArray[givenPosition-1];
			}
		}
		return null;
	}

	public boolean contains(T anEntry) {
		for (int index=0; index<mySize; index++) {
			if (anEntry.equals(myArray[index])) {
				return true;
			}
		}
		return false;
	}

	public int getLength() {
		return mySize;
	}

	private void ensureCapacity() {
		if (mySize == myArray.length) {
			myArray = Arrays.copyOf(myArray, 2 * myArray.length);
		}
	}

	public Object[] toArray() {
		Object[] result = new Object[mySize];
		for (int index = 0; index < mySize; index++) {
			result[index] = myArray[index];
		}
		return result;
	}

	public int getPosition(Object obj) {
		for (int i=0;i<mySize; i++) {
			if (myArray[i].equals(obj)) {
				return i;
			}
		}
		return -1;
	}
	
	public void moveToEnd(int position) {
		if (position > mySize) {
			return;
		}
		Object o = myArray[position];
		for (int i=position-1;i<mySize;i++) {
			
		}
	}
	
	/**
	 * Converts all the data in the bag into one big String
	 * 
	 * @return a very long String of objects contained in bag
	 */
	@Override
	public String toString() {
		String result = "[";
		for (int i=0; i<mySize; i++) {
			if (i < mySize - 1) {
				result += myArray[i] + ", ";
			} else {
				result += myArray[i];
			}
		}
		return result + "]";
	}
}
