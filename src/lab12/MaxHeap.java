package lab12;

import java.util.Arrays;

/**
 * A class that implements the ADT maxheap by using an array.
 * 
 * @author Frank M. Carrano
 * @version 3.0
 */
public class MaxHeap<T extends Comparable<? super T>> {
	private T[] heap; // array of heap entries
	private int lastIndex; // index of last entry and number of entries
	private static final int DEFAULT_INITIAL_CAPACITY = 25;

	public MaxHeap() {
		this(DEFAULT_INITIAL_CAPACITY);
	}

	public MaxHeap(int initialCapacity) {
		// the cast is safe because the new array contains all null entries
		@SuppressWarnings("unchecked")
		T[] tempHeap = (T[]) new Comparable[initialCapacity + 1];
		heap = tempHeap;
		lastIndex = 0;
	}

	public MaxHeap(T[] entries) {
		// the cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempHeap = (T[]) new Comparable[entries.length + 1];
		heap = tempHeap;
		lastIndex = entries.length;

		// copy given array to data field
		for (int index = 0; index < entries.length; index++) {
			heap[index + 1] = entries[index];
		}

		// create heap
		for (int rootIndex = lastIndex / 2; rootIndex > 0; rootIndex--) {
			reheap(rootIndex);
		}
	}

	public void add(T newEntry) {
		// increase lastIndex and make sure there is enough room in the heap
		lastIndex++;
		ensureCapacity();

		// assume the new item index (newIndex) will go at the end of array, lastIndex
		int newIndex = lastIndex;

		// find the parent index (parentIndex) of the new item (newIndex)
		int parentIndex = lastIndex / 2;

		// as long as the parentIndex is valid (>0) and the newEntry is larger than its
		// parent...
		while (parentIndex > 0 && newEntry.compareTo(heap[parentIndex]) > 0) {
			// copy the parent into the array at the child index (newIndex)
			heap[newIndex] = heap[parentIndex];

			// set the new location for newEntry to the parent index
			newIndex = parentIndex;

			// find the new parent index
			parentIndex = parentIndex / 2;
		}

		// finally, store the newEntry at the location we've determined it should go
		heap[newIndex] = newEntry;
	}

	public T removeMax() {
		// define root to refer to the item stored at the top of the heap and intialize
		// to null
		T root = null;

		// if the heap is not empty
		if (!isEmpty()) {
			// assign the item at the top of the heap to root
			root = heap[1];

			// copy the last item in the heap into the top location
			// subtract one from lastIndex (heap is one item smaller)
			heap[1] = heap[lastIndex--];
			
			// nullify old reference
			heap[lastIndex] = null;
			
			// ensure the new array satisfies the heap order property
			reheap(1);
		}
		
		// finally, return the item that used to reside at the top of the heap.
		return root;
	}

	public T getMax() {
		// return the item at the top of the heap, if it exists

		return null;
	}

	public boolean isEmpty() {
		return lastIndex < 1;
	}

	public int getSize() {
		return lastIndex;
	}

	public void clear() {
		for (; lastIndex > -1; lastIndex--) {
			heap[lastIndex] = null;
		}

		lastIndex = 0;
	}

	private void reheap(int rootIndex) {
		boolean done = false;
		T orphan = heap[rootIndex];
		int leftChildIndex = 2 * rootIndex;

		while (!done && (leftChildIndex <= lastIndex)) {
			// assume larger
			int largerChildIndex = leftChildIndex;
			int rightChildIndex = leftChildIndex + 1;

			if ((rightChildIndex <= lastIndex) && heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0) {
				largerChildIndex = rightChildIndex;
			}

			if (orphan.compareTo(heap[largerChildIndex]) < 0) {
				heap[rootIndex] = heap[largerChildIndex];
				rootIndex = largerChildIndex;
				leftChildIndex = 2 * rootIndex;
			} else {
				done = true;
			}
		}

		heap[rootIndex] = orphan;
	}

	// Doubles the size of the array bag if it is full
	private void ensureCapacity() {
		if (lastIndex >= heap.length) {
			heap = Arrays.copyOf(heap, 2 * heap.length);
		}
	}
	
	public void writeLevels() {
		// print first row, second row, third row ...
		
	}

	@Override
	public String toString() {
		String result = "[";
		for (int k = 1; k < lastIndex; k++) {
			result = result + heap[k] + ", ";
		}
		result = result + heap[lastIndex] + "]";
		return result;
	}
}
