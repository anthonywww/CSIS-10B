package lab9;

import java.util.Iterator;

/**
 * A linked implementation of the ADT list.
 * 
 * @author Frank M. Carrano
 * @version 3.0
 */
public class LList<T> implements Iterable<T> {
	
	private Node firstNode; // reference to first node
	private int mySize;
	private Iterator<T> iterator;
	
	public LList() {
		firstNode = null;
		mySize = 0;
		iterator = new IteratorLList();
	}

	public boolean isEmpty() {
		boolean result;

		if (mySize == 0) // or getLength() == 0
		{
			assert firstNode == null;
			result = true;
		} else {
			assert firstNode != null;
			result = false;
		} // end if

		return result;
	} // end isEmpty

	public void add(T newEntry) // OutOfMemoryError possible
	{
		Node newNode = new Node(newEntry);
		if (isEmpty()) {
			firstNode = newNode;
			mySize++;
		} else {
			Node lastNode = firstNode;
			while (lastNode.next != null) {
				lastNode = lastNode.getNextNode();
			}
			lastNode.next = newNode;
			mySize++;
		}
	} // end add

	public boolean add(int newPosition, T newEntry) // OutOfMemoryError possible
	{
		Node newNode = new Node(newEntry);
		if (newPosition >= 1 && newPosition <= mySize + 1) {
			if (newPosition == 1) {
				newNode.next = firstNode;
				firstNode = newNode;
				mySize++;
				return true;
			} else {
				Node nodeBefore = firstNode;
				for (int k = 1; k < newPosition - 1; k++) {
					nodeBefore = nodeBefore.next;
				}
				Node nodeAfter = nodeBefore.getNextNode();
				newNode.setNextNode(nodeAfter);
				nodeBefore.setNextNode(newNode);
				mySize++;
				return true;
			}
		}
		return false;
	} // end add

	public T remove(int givenPosition) {
		if (givenPosition >= 1 && givenPosition <= mySize) {
			if (givenPosition == 1) {
				Node nodeToRemove = firstNode;
				firstNode = firstNode.getNextNode();
				mySize--;
				return nodeToRemove.getData();
			} else {
				Node nodeBefore = firstNode;
				for (int k = 1; k < givenPosition - 1; k++) {
					nodeBefore = nodeBefore.next;
				}
				Node nodeToRemove = nodeBefore.getNextNode();
				Node nodeAfter = nodeToRemove.getNextNode();
				nodeBefore.setNextNode(nodeAfter);
				mySize--;
				return nodeToRemove.getData();
			}
		}
		return null; // return removed entry, or null if operation fails
	} // end remove

	public final void clear() // note the final method
	{
		firstNode = null;
		mySize = 0;
	} // end clear

	public boolean replace(int givenPosition, T newEntry) {
		if (givenPosition >= 1 && givenPosition <= mySize) {
			remove(givenPosition);
			add(givenPosition, newEntry);
			return true;
		}
		return false;
	} // end replace

	public T getEntry(int givenPosition) {
		Node currentNode = firstNode;
		if (currentNode != null && givenPosition >= 1 && givenPosition <= mySize) {
			for (int k = 1; k < givenPosition; k++) {
				currentNode = currentNode.getNextNode();
			}
			if (currentNode != null)
				return currentNode.getData();
		}

		return null;
	} // end getEntry

	public boolean contains(T anEntry) {
		boolean found = false;
		Node currentNode = firstNode;

		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.getData()))
				found = true;
			else
				currentNode = currentNode.getNextNode();
		}

		return found;
	}

	public int getPosition(T newEntry) {
		int num = 1;
		Node currentNode = firstNode;
		if (contains(newEntry)) {
			for (int k = 1; k <= mySize; k++) {
				if (currentNode.data.equals(newEntry))
					return num;
				currentNode = currentNode.getNextNode();
				num++;
			}
		}
		return -1;
	}

	public void moveToEnd(int givenPosition) {
		Node currentNode = firstNode;
		if (currentNode != null && givenPosition >= 1 && givenPosition <= mySize) {
			T toEnd = remove(givenPosition);
			add(mySize + 1, toEnd);
		}
	}

	public int getLength() {
		return mySize;
	}

	public T[] toArray() {
		// the cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[mySize];

		int index = 0;
		Node currentNode = firstNode;
		while ((index < mySize) && (currentNode != null)) {
			result[index] = currentNode.getData();
			currentNode = currentNode.getNextNode();
			index++;
		}

		return result;
	}

	@Override
	public String toString() {
		String result = "[";
		Node currentNode = firstNode;
		if (currentNode == null)
			result = "[]";
		while (currentNode != null) {
			if (currentNode.getNextNode() == null)
				result += currentNode.getData() + "]";
			else
				result += currentNode.getData() + ", ";
			currentNode = currentNode.getNextNode();
		}
		return result;
	}
	
	private class Node {
		private T data; // entry in list
		private Node next; // link to next node

		private Node(T dataPortion) {
			data = dataPortion;
			next = null;
		}

		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		}

		private T getData() {
			return data;
		}

		private Node getNextNode() {
			return next;
		}

		private void setNextNode(Node nextNode) {
			next = nextNode;
		}
	}

	private class IteratorLList implements Iterator<T> {
		
		private int iteratorPos;
		
		public IteratorLList() {
			iteratorPos = 0;
		}

		@Override
		public boolean hasNext() {
			if (getEntry(iteratorPos+1) != null) {
				return true;
			}
			return false;
		}

		@Override
		public T next() {
			return getEntry(++iteratorPos);
		}
		
	}
	
	@Override
	public Iterator<T> iterator() {
		return iterator;
	}
}