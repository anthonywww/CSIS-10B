package assignment3;

/**
 * Implements Stack using Linked Nodes
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class StackLink {
	
	private Node topNode; // reference to the top node of our stack
	private int size;

	public StackLink() {
		topNode = new Node(null, null);
		size = 0;
	}
	
	/**
	 * Pushes a new item onto top of stack
	 * @param item the item to add to the stack
	 */
	public void push(Object item) {
		Node ptr = topNode;
		while (ptr.next != null) {
			ptr = ptr.next;
		}
		ptr.next = new Node(item, null);
		size++;
	}

	/**
	 * Pops an item off the top of stack
	 * @return the top item
	 */
	public Object pop() {
		Object data = topNode.data;
		topNode.next = topNode.next.next;
		return data;
	}

	/**
	 * Returns the top item from stack without removing
	 * @return the top item
	 */
	public Object peek() {
		return topNode.next.data;
	}

	/**
	 * Checks for empty stack
	 * @return true iff stack is empty
	 */
	public boolean isEmpty() {
		return topNode.next == null;
	}

	/**
	 * Gets the number of items in the stack
	 * 
	 * @return the number of items in stack
	 */
	public int size() {
		return size;
	}

	/**
	 * Creates and returns a string version of stack
	 * 
	 * @return a string reprenting items in stack
	 */
	@Override
	public String toString() {
		Node current = topNode.next;
		String result = "";
		while (current != null) {
			result = current.data + " " + result;
			current = current.next;
		}
		return result;
	}

	private class Node {
		public Object data; // data field -- the data stored in this particular node
		public Node next; // next field -- reference to next SLLNode in list, or null

		// Constructor
		Node(Object data, Node next) {
			this.data = data;
			this.next = next;
		}

	}
}