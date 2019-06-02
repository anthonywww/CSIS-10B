package lab6.lab6b;

/**
 * A linked implementation of the ADT list.
 * 
 * @author Frank M. Carrano
 * @version 3.0
 */
public class LinkedList<T> {
	private Node firstNode;
	private int mySize;

	public LinkedList() {
		firstNode = null;
		mySize = 0;
	}

	public boolean isEmpty() {
		return mySize == 0;
	}

	public void add(T newEntry) {
		Node newNode = new Node(newEntry);
		if (mySize > 0) {
			Node lastNode = firstNode;
			while (lastNode.next != null) {
				lastNode = lastNode.next;
			}
			lastNode.next = newNode;
			mySize++;
			return;
		}
		firstNode = newNode;
		mySize++;
	}

	public boolean add(int newPosition, T newEntry) {
		Node newNode = new Node(newEntry);
		if (newPosition >= 1 && newPosition <= mySize + 1) {
			if (newPosition == 1) {
				newNode.next = firstNode;
				firstNode = newNode;
				mySize++;
				return true;
			} else {
				Node nodeBefore = firstNode;
				int numAdvances = newPosition - 2;
				for (int i = 1; i <= numAdvances; i++) {
					nodeBefore = nodeBefore.next;
				}
				Node nodeAfter = nodeBefore.next;
				newNode.next = nodeAfter;
				nodeBefore.next = newNode;
				mySize++;
				return true;
			}
		}
		return false;
	}

	public T remove(int givenPosition) {
		if (givenPosition >= 1 && givenPosition <= mySize) {
			if (givenPosition == 1) {
				Node nodeToRemove = firstNode;
				firstNode = firstNode.next;
				mySize--;
				return nodeToRemove.data;
			}
			Node nodeBefore = firstNode;
			int position = givenPosition - 2;
			for (int i = 1; i <= position; i++) {
				nodeBefore = nodeBefore.next;
			}
			Node nodeToRemove = nodeBefore.next;
			Node nodeAfter = nodeToRemove.next;
			nodeBefore.next = nodeAfter;
			mySize--;
			return nodeToRemove.data;
		}
		return null;
	}

	public final void clear() {
		firstNode = null;
		mySize = 0;
	}

	public boolean replace(int givenPosition, T newEntry) {
		if (givenPosition >= 1 && givenPosition <= mySize) {
			remove(givenPosition);
			add(givenPosition, newEntry);
			return true;
		}
		return false;
	}

	public T getEntry(int givenPosition) {
		Node currentNode = firstNode;
		if (givenPosition >= 1 && givenPosition <= mySize) {
			int nodeNum = 1;
			while (nodeNum < givenPosition) {
				currentNode = currentNode.next;
				nodeNum++;
			}
			return currentNode.data;
		}
		return null;
	}

	public int getPosition(T entry) {
		// wasting cycles
		if (!contains(entry)) {
			return -1;
		}
		Node currentNode = firstNode;
		int position = 1;
		for (int i = 1; i <= mySize; i++) {
			if (currentNode.data.equals(entry)) {
				position = i;
			}
			currentNode = currentNode.next;
		}
		return position;
	}

	public boolean moveToEnd(int givenPosition) {
		if (givenPosition >= 1 && givenPosition <= mySize) {
			add(remove(givenPosition));
			return true;
		}
		return false;
	}

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

	public int getLength() {
		return mySize;
	}

	public T[] toArray() {
		// the cast is safe because the new array contains null entries
		// FIXME: Except that this is probably one of the worst ways to go about it,
		// Frank Carrano.
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
		private T data;
		private Node next;

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

		// TODO: Never used
		@SuppressWarnings("unused")
		private void setData(T newData) {
			data = newData;
		}

		private Node getNextNode() {
			return next;
		}

		// TODO: Never used
		@SuppressWarnings("unused")
		private void setNextNode(Node nextNode) {
			next = nextNode;
		}
	}
}
