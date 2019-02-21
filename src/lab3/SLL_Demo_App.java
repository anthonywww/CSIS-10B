package lab3;

/**
 * class SLL_Demo_App here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class SLL_Demo_App {
	public static void main(String[] args) {
		System.out.println("1) ");
		// ********* demo 1 Create a list of 3 nodes (ant->bat->cat->null )
		Node catNode = new Node("cat", null);
		Node batNode = new Node("bat", catNode);
		Node antNode = new Node("ant", batNode);
		Node head = antNode;

		// printing nodes directly
		System.out.println(head.data);
		System.out.println(head.next.data);
		System.out.println(head.next.next.data);
		
		// NPE
		// System.out.println( head.next.next.next.data );

		// printing with a loop
		Node p = head;
		while(p != null) {
			System.out.println(p.data + "->");
			p = p.next;
		}
		System.out.println("null");

		// printing with printList method
		printList(head);

		// ************** end demo 1 **************************/
		// ********* demo 2 Insert a Node "asp" at front (asp->ant->bat->cat->null )
		// 1) create a new node with desired data ("asp")
		// 2) link the next field of newNode with the rest of the list
		// 3) change head to point to the new node
		System.out.println("2) ");
		// 1
		Node newNode = new Node("asp", null);
		// 2
		newNode.next = head;
		// 3
		head = newNode;
		printList(head);
		// ************** end demo 2 **************************/
		// ********* demo 3 Insert a Node "rat" in middle (asp->ant->rat->bat->cat->null )
		// 1) make nodeBefore point to the node before insertion point
		// 2) create a new node with desired data
		// 3) set newNode.next to refer to the items after nodeBefore
		// 4) set nodeBefore.next to refer to newNode
		System.out.println("3) ");
		// 1, nodeBefore points to ant node
		
		// 2
		Node nodeBefore = new Node("rat", null);
		// 3
		newNode.next = nodeBefore.next;
		// 4
		nodeBefore.next = newNode;
		printList(head);
		// ************** end demo 3 **************************/
		// ********* demo 4 Remove the Node at the front ( ant->rat->bat->cat->null)
		// 1) advance head to the next node in line
		// 2) unreferenced node will be garbage collected
		System.out.println("4) ");
		// 1
		head = head.next;
		printList(head);
		// ************** end demo 4 **************************/
		// ********* demo 5 Remove the Node "bat" from the middle (ant->rat->cat->null)
		// 1) make nodeBefore point to the node before the deletion point
		// 2) set nodeBefore.next to the list following the deletion node
		// 3) the unreferenced node will be garbage collected
		System.out.println("5) ");
		nodeBefore = head.next; // 1
		nodeBefore.next = nodeBefore.next.next; // 2
		printList(head);
		// ************** end demo 5 **************************/
		// ********* demo 6 Change a Node's data, "rat" to "pet" (ant->pet->cat->null)
		System.out.println("6) ");
		newNode.data = "pet";
		printList(head);
		// ************** end demo 6 **************************/
		// ********* demo 7 add and remove a Node after ant
		// first, add a new node after ant ant->trap->pet->cat->null
		// follow steps in demo3

		System.out.println("7) ");
		
		printList(head);
		// then remove the node after ant ant->pet->cat->null
		// follow steps in demo4
		
		printList(head);
		// ************** end demo 7 **************************/
	}

	public static void printList(Node start) {
		Node p = start;
		while (p != null) {
			System.out.print(p.data + "->");
			p = p.next;
		}
		System.out.println("null");
	}
}
