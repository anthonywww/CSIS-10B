package assignment3;

/**
 * Implements a Queue using Linked Nodes
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class LQueue {

	private Node front; // reference to the front node of the queue (the next to be dequeued)
	private Node back; // reference to the back node of the queue (the last item that was added)

	// Define Constructor here

	public void enqueue(Object value) {
	}
	// post: the value is added to the tail of the structure

	public Object dequeue() {
		return null;
	}
	// pre: the queue is not empty
	// post: the head of the queue is removed and returned

	public Object getFront() {
		return null;
	}
	// pre: the queue is not empty
	// post: the element at the head of the queue is returned

	public boolean isEmpty() {
		return true;
	}
	// post: returns true if and only if the queue is empty

	public int size() {
		return 0;
	}
	// post: returns the number of elements in the queue

	public String toString() {
		return "";
	}

	private class Node {
		// Data members
		public Object element; // Queue element
		public Node next; // Pointer to the next element

		// because there are no access labels (public, private or protected),
		// access is limited to the package where these methods are declared

		// Constructor
		Node(Object elem, Node nextPtr) {
			element = elem;
			next = nextPtr;
		}

	}

}