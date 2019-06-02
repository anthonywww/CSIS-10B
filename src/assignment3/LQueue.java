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
	private int size;

	public LQueue() {
		front = null;
		back = null;
		size = 0;
	}

	public void enqueue(Object value) {
		Node node = new Node(value, null);
		if (front == null && back == null) {
			front = node;
			back = node;
		} else {
			back.next = node;
			back = back.next;
		}
		size++;
	}

	public Object dequeue() {
		if (front == null) {
			return null;
		}
		Node removed = front;
		if (front.next != null) {
			front = front.next;
		} else {
			front = null;
			back = null;
		}
		size--;
		return removed.element;
	}

	public Object getFront() {
		return front.element;
	}

	public boolean isEmpty() {
		return front == null && back == null;
	}

	public int size() {
		return size;
	}

	@Override
	public String toString() {
		String result = "";
		Node current = front;
		while (current != null) {
			result = result + "" + current.element;
			current = current.next;
		}
		return result;
	}

	private class Node {
		public Object element;
		public Node next;

		// because there are no access labels (public, private or protected),
		// access is limited to the package where these methods are declared

		Node(Object elem, Node nextPtr) {
			element = elem;
			next = nextPtr;
		}
	}
}