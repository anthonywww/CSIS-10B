package lab9;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Write a description of class CharIterator here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class CharIterator implements Iterator<Character> {
	
	private StringBuilder theString; // declare a StringBuilder to refer to the CharIterators source. StringBuilder lets you remove/add items from/to the StringBuilder object
	private int cursor; // declare an int to refer to the current position of the cursor
	private boolean calledNext;

	// define a constructor that takes a String and initializes theString to it, and
	// cursor to -1
	public CharIterator(StringBuilder aString) {
		theString = aString;
		cursor = -1;
		calledNext = false;
	}

	/**
	 * Detects whether this iterator has completed its traversal and gone beyond the
	 * last entry in the collection of data.
	 * 
	 * @return true if the iterator has another entry to return
	 */
	@Override
	public boolean hasNext() {
		return false;
	}

	/**
	 * Retrieves the next entry in the collection and advances this iterator by one
	 * position.
	 * 
	 * @return a reference to the next entry in the iteration, if one exists
	 * @throws NoSuchElementException if the iterator had reached the end already,
	 *                                that is, if hasNext() is false
	 */
	@Override
	public Character next() {
		calledNext = true;
		return theString.charAt(cursor++);
	}

	/**
	 * Removes from the collection of data the last entry that next() returned. A
	 * subsequent call to next() will behave as it would have before the removal.
	 * Precondition: next() has been called, and remove() has not been called since
	 * then. The collection has not been altered during the iteration except by
	 * calls to this method.
	 * 
	 * @throws IllegalStateException         if next() has not been called, or if
	 *                                       remove() was called already after the
	 *                                       last call to next().
	 * @throws UnsupportedOperationException if the iterator does not permit a
	 *                                       remove operation.
	 */
	@Override
	public void remove() {
		if (calledNext) {
			throw new IllegalStateException();
		}
		
	}

}
