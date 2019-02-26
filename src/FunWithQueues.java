


/**
 * Write a description of class QueueDemo here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class FunWithQueues {
	
	public static void main(String[] args) {
		LQueue<String> q1 = new LQueue<String>();

		q1.enqueue("Jim");
		q1.enqueue("Jess");
		q1.enqueue("Jill");
		q1.enqueue("Jane");
		
		System.out.println("q1 = " + q1);
		
		while (!q1.isEmpty()) {
			System.out.println("q1 -> " + q1.dequeue());
		}
		
		LinkedPriorityQueue<String> q2 = new LinkedPriorityQueue<String>();

		LinkedPriorityQueue<Thing<String>> pq = new LinkedPriorityQueue<Thing<String>>();
		
		pq.add(new Thing<String>("Justin Trudeau", 2));
		pq.add(new Thing<String>("Tom Rebold", 1));
		pq.add(new Thing<String>("Hillary Clinton", 3));

		LinkedDeque<String> dq = new LinkedDeque<String>();

	}
	
}
