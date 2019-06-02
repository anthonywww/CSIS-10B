package assignment3;

import java.util.Arrays;

/**
 * Implements Stack using an Array
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class StackArray {
	private Object[] array; // object array we store items in
	private int top; // the cell where the current top of stack is located
	private static final int DEFAULT_CAPACITY = 10;

	public StackArray() {
		array = new Object[DEFAULT_CAPACITY];
		top = -1;
	}

	/**
	 * Pushes a new item onto top of stack
	 * 
	 * @param item the item to add to the stack
	 */
	public void push(Object item) {
		if (top + 1 >= array.length) {
			// inefficient
			array = Arrays.copyOf(array, array.length * 2);
		}
		array[++top] = item;
	}

	/**
	 * Pops an item off the top of stack
	 * 
	 * @return the top item
	 */
	public Object pop() {
		Object temp = peek();
		array[top--] = null;
		return temp;
	}

	/**
	 * Returns the top item from stack without removing
	 * 
	 * @return the top item
	 */
	public Object peek() {
		return array[top];
	}

	/**
	 * Checks for empty stack
	 * 
	 * @return true iff stack is empty
	 */
	public boolean isEmpty() {
		return top == -1;
	}

	/**
	 * Gets the number of items in the stack
	 * 
	 * @return the number of items in stack
	 */
	public int size() {
		return top + 1;
	}

	/**
	 * Creates and returns a string version of stack
	 * 
	 * @return a string reprenting items in stack
	 */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("[");

		for (int i = 0; i <= top; i++) {
			sb.append(array[i]);
			if (i < top) {
				sb.append(',').append(' ');
			}
		}

		sb.append("]");
		return sb.toString();
	}

}