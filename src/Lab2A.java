import lab2.lab2a.Person;
import lab2.lab2a.Student;

/**
 * Lab 3 exercises -- ArrayBag Class
 */
public class Lab2A {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
        
        //************  Demo 1 Use of Bag with Generic type indicator *****************
        System.out.println("**************** Demo 1**************");
        
        Bag<Object> b = new Bag<Object>();
        b.add("apple");
        b.add("carrot");
        b.add(3.45);
        b.add(new Person("John F. Kennedy"));
        
        while (!b.isEmpty()) {
            System.out.println(b.remove());
        }
        
        //********** End Demo 1  *****************************************************/            
        //********** Problem 1  Using a Bag object ****************
        System.out.println("**************** Problem 1 **************");
        // a)  Create a Bag object myBag, add the Strings 
        //      "apple", "soup", "apple", "pear", "beet", "soup" 
        //      to it and print it...you should have two soups and two apples
        Bag<String> myBag = new Bag<String>();
        myBag.add("apple");
        myBag.add("soup");
        myBag.add("apple");
        myBag.add("pear");
        myBag.add("beet");
        myBag.add("soup");
        
        System.out.printf("%s\n", myBag.toString());
      
        // b)  Determine whether myBag is full and print an appropriate message (true or false)
        System.out.printf("The bag %s.\n", myBag.isFull() ? "is full" : "still has room for more itmes");
        
        // c)  Use a method to determine how many apples are in myBag, and print it
        System.out.printf("The bag currently has %d apples.\n", myBag.getFrequencyOf("apple"));
                
        // d)  Use a method to determine if myBag contains a beet and print the appropriate message
        System.out.printf("The bag %s.\n", myBag.getFrequencyOf("beet") > 0 ? "does contain beets" : "does not contain any beets");
        
        // e)  remove both soups from myBag and prove they are gone
        if (myBag.contains("soup")) {
        	for (int i=0; i<=myBag.getFrequencyOf("soup"); i++) {
        		myBag.remove("soup");
        	}
        }
        System.out.printf("%s\n", myBag.toString());
        
        // f)  write a while loop that adds "tuna" to the bag as long as the bag is not full
        while (!myBag.isFull()) {
        	myBag.add("tuna");
        }
        
        // g)  use a while loop to remove all items from myBag (and print them), as long as 
        //      the bag is not empty)
        System.out.print("The bag currently has: ");
        while (!myBag.isEmpty()) {
        	System.out.printf("%s%s", myBag.remove(), (myBag.getCurrentSize() >= 1) ? ", " : "");
        }
        System.out.println();
        System.out.println("All items were removed from the bag.");
        
        //  and after check to verify it is empty
        if (!myBag.isEmpty()) {
        	System.err.println("WTF, Items were NOT removed from the bag!");
        }
        
        //********** End Problem 1  *****************************************************/        
        //********** Problem 2  Using a Bag to represent a club of Persons ****************
        System.out.println("**************** Problem 2 **************"); 
        //  a) Create a Bag object CS_club, that can only hold Person objects.
        //     
        //     add the Persons  Joe Frank, Lara Allende, and Presley Underwood to it
        //
        Bag<Person> csClub = new Bag<Person>();
        csClub.add(new Person("Joe Frank"));
        csClub.add(new Person("Lara Allende"));
        csClub.add(new Person("Presley Underwood"));
        
        //     Now print the bag contents. You will need to write a toString method for 
        //        the Person class.
        System.out.printf("Bag of Person's %s.\n", csClub.toString()); 
        
        //  b)	write an equals method for the Person class. Do that now. Use the pattern shown 
        //        on the lecture pdf
        
        //  c)	Then prove that your equals method works by determining if Joe Frank is in the 
        //        club. 
        System.out.printf("Joe Frank is in csClub: %s.\n", csClub.contains(new Person("Joe Frank")));
        
        //********** End Problem 2  *****************************************************/   
        //********** Problem 3  Using inheritance to derive a Student class from Person ******
        System.out.println("**************** Problem 3 **************"); 
        
        Student studentA = new Student("Bella Swinton", 123);
        Student studentB = new Student("Bella Swinton", 123);
        Student studentC = new Student("Bella Swinton", 333);
        Student studentD = new Student("David Swinton", 123);
        Student studentE = studentA;

        // a) Define the toString method for the Student class, then execute the following:
        System.out.println("Student a = " + studentA);
        System.out.println("Student b = " + studentB);
        System.out.println("Student c = " + studentC);
        System.out.println("Student d = " + studentD);
        
        // b) Then define the equals method for the Student class and execute the following:
        
        System.out.println("Student a equals b ? " + studentA.equals(studentB));
        System.out.println("Student a equals c ? " + studentA.equals(studentC));        
        System.out.println("Student a equals d ? " + studentA.equals(studentD));   
        System.out.println("Student a equals e ? " + studentA.equals(studentE));   
        
        // c)  If you keep problem 2 active, can you now add Students a and b to your club? 
        //      try it here:
        
        
        //  Inheritence lets you add a Student to a Club<Person> 
        //      since a Student IS A Person. (however if the club was defined to only work 
        //      with Student, a Person could not join the club because a Person is NOT (always)
        //      a Student)
        
        
        //********** End Problem 3  *****************************************************/
        //********** Problem 4  Using Composition to create a Club class as an adapter for Bag<Person>
         
        
        // follow the instructions on the lab handout to create a Club class, then modify 
        //  your declaration for club in problem 2 to be of class Club instead of Bag<Person>.
        //  In other words,  Club CS_club = new Club(),  and verify it works the same.
         
        //********** End Problem 4  *****************************************************/  
        /********** Problem 5 EXTRA CREDIT Define and test the intersection method (below)
        // see Lab handout
        System.out.println("**************** Problem 5 **************");          
         
         
        //********** End Problem 5  *****************************************************/        
	}
	
	
	// EXTRA CREDIT
	public static <T> Bag<T> intersection(Bag<T> bagA, Bag<T> bagB) {
		return new Bag<T>(); // fix
	}
}

/*
**************** Demo 1**************
John F. Kennedy
3.45
carrot
apple
**************** Problem 1 **************
apple, soup, apple, pear, beet, soup
The bag still has room for more itmes.
The bag currently has 2 apples.
The bag does contain beets.
apple, beet, apple, pear
The bag currently has: tuna, tuna, tuna, tuna, tuna, tuna, tuna, tuna, tuna, tuna, tuna, tuna, tuna, tuna, tuna, tuna, tuna, tuna, tuna, tuna, tuna, pear, apple, beet, apple
All items were removed from the bag.
**************** Problem 2 **************
Bag of Person's Joe Frank, Lara Allende, Presley Underwood.
Joe Frank is in csClub: true.
**************** Problem 3 **************
Student a = Bella Swinton
Student b = Bella Swinton
Student c = Bella Swinton
Student d = David Swinton
Student a equals b ? true
Student a equals c ? true
Student a equals d ? false
Student a equals e ? true
*/
