package lab3;

class Node {

	Object data; // data field -- the data stored in this particular node
	Node next; // next field -- reference to next Node in list, or null

	Node(Object data, Node next) {
		this.data = data;
		this.next = next;
	}
}