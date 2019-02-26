

public interface Queue<E> {
	// Queue manipulation operations
	public void enqueue(E newElement); // Enqueue element at rear

	public E dequeue(); // Dequeue element from front

	public void clear(); // Remove all elements from queue

	// Queue status operations
	public E getFront(); // get item at front without removing

	public boolean isEmpty(); // Is Queue empty?

	public boolean isFull(); // Is Queue full?

	public int size(); // returns number of items in queue

	public String toString(); // Outputs a String representation of Q
}
