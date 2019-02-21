package lab3;

class IntNode {
	
	int data; // data field -- the data stored in this particular node
	IntNode next; // next field -- reference to next IntNode in list, or null

	IntNode(int data, IntNode next) {
		this.data = data;
		this.next = next;
	}
}