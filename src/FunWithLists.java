
/**
 * Write a description of class FunWithLists here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class FunWithLists {

	public static void main(String[] args) {
		LList<String> myList = new LList<String>();

		myList.add("hey");
		myList.add("there");
		myList.add("people");
		myList.add(2, "hello");

		System.out.println("myList = " + myList);
	}

}
