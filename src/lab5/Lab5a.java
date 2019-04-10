package lab5;

/** Lab 5 exercises -- Array based Bag, Stack, Queue and List Classes
 *  
 */
public class Lab5a {
	
	public static void main(String[] args) {
        //********** Problem 0 Test constructors, isEmpty, isFull, getCurrentSize, toString *************
        // declare 3 bags
        System.out.println("**************** Problem 0 **************\n");
        
        ArrayBag<String> duffleBag = new ArrayBag<String>();
        ArrayBag<String> groceryBag = new ArrayBag<String>(10);
        ArrayBag<String> tinyBag = new ArrayBag<String>(0); // this bag can hold zero items
        
        System.out.println("   size of duffleBag = " + duffleBag.getCurrentSize());        
        System.out.println("   is duffleBag empty? " + duffleBag.isEmpty());
        System.out.println("   is duffleBag full? " + duffleBag.isFull());
        System.out.println("contents of duffleBag: " + duffleBag);        
        
        System.out.println("\n   size of groceryBag = " + groceryBag.getCurrentSize());        
        System.out.println("   is groceryBag empty? " + groceryBag.isEmpty());
        System.out.println("   is groceryBag full? " + groceryBag.isFull());
        System.out.println("contents of groceryBag: " + groceryBag);        
        
        System.out.println("\n   size of tinyBag = " + tinyBag.getCurrentSize());        
        System.out.println("   is tinyBag empty? " + tinyBag.isEmpty());
        System.out.println("   is tinyBag full? " + tinyBag.isFull());
        System.out.println("contents of tinyBag: " + tinyBag);        
        
        
        //********** End Problem 0  *****************************************************/        
        //********** Problem 1 test your add method  ****************
        System.out.println("\n\n**************** Problem 1 **************\n");
        
        // add some items
        duffleBag.add("ball"); duffleBag.add("cap"); duffleBag.add("ball");
        duffleBag.add("keys"); duffleBag.add("ball");
        
        System.out.println("   size of duffleBag = " + duffleBag.getCurrentSize());        
        System.out.println("   is duffleBag empty? " + duffleBag.isEmpty());
        System.out.println("   is duffleBag full? " + duffleBag.isFull());
        System.out.println("contents of duffleBag: " + duffleBag);        

        System.out.println();
        
        // check add returns boolean
        if (groceryBag.add("candy bar"))
            System.out.println("Successfully added one candy bar to groceryBag");
            
        // add until full    
        while( groceryBag.add("candy bar"))
            System.out.println("added another candy bar!");
            
        System.out.println("\n   size of groceryBag = " + groceryBag.getCurrentSize());        
        System.out.println("   is groceryBag empty? " + groceryBag.isEmpty());
        System.out.println("   is groceryBag full? " + groceryBag.isFull());
        System.out.println("contents of groceryBag: " + groceryBag);        
        
        //********** End Problem 1  *****************************************************/  
        //********** Problem 2 test your getFrequencyOf method  ****************        
        System.out.println("\n\n**************** Problem 2**************\n");
        
        System.out.println("There are " + duffleBag.getFrequencyOf("ball") + " balls in duffleBag");
        System.out.println("There are " + groceryBag.getFrequencyOf("candy bar") + " candy bars in groceryBag");
        
        
        //********** End Problem 2  *****************************************************/
        //********** Problem 3 test your contains method  *****************
        System.out.println("\n\n**************** Problem 3**************\n");

        System.out.println("Does duffleBag contain keys? " + duffleBag.contains("keys"));
        System.out.println("Does groceryBag contain broccoli? " + groceryBag.contains("broccoli"));
        
        
        //********** End Problem 3  *****************************************************/      
        //********** Problem 4 Test the remove method ************** 
        System.out.println("\n\n**************** Problem 4**************\n");
        
        System.out.println("Removing " + duffleBag.remove() + " from duffleBag");
        System.out.println("   size of duffleBag = " + duffleBag.getCurrentSize());        
        System.out.println("contents of duffleBag: " + duffleBag);        

        System.out.println();

        System.out.println("Removing " + tinyBag.remove() + " from tinyBag");
        System.out.println("   size of tinyBag = " + tinyBag.getCurrentSize());        
        System.out.println("contents of tinyBag: " + tinyBag);                    
              
        //********** End Problem 4  *****************************************************/     
        //*************  Problem 5  Test the clear method ****************************
        System.out.println("\n\n**************** Problem 5 **************\n");

        groceryBag.clear();
        
        System.out.println("Clearing all items from groceryBag");
        System.out.println("   size of groceryBag = " + groceryBag.getCurrentSize());        
        System.out.println("   is groceryBag empty? " + groceryBag.isEmpty());
        System.out.println("   is groceryBag full? " + groceryBag.isFull());
        System.out.println("contents of groceryBag: " + groceryBag);        
        
        //********** End Problem 5  *****************************************************/     
        //*************  Problem 6  (Optional) Test the remove(anEntry) method
        System.out.println("\n\n**************** Problem 6 (Optional) **************\n");
               
        duffleBag.remove("keys");
        
        System.out.println("After remove(\"keys\"); from duffleBag");
        System.out.println("   size of duffleBag = " + duffleBag.getCurrentSize());        
        System.out.println("contents of duffleBag: " + duffleBag);        

        System.out.println();   
        
        duffleBag.remove("book");
        
        System.out.println("After remove(\"book\"); from duffleBag");
        System.out.println("   size of duffleBag = " + duffleBag.getCurrentSize());        
        System.out.println("contents of duffleBag: " + duffleBag);        
        
        //********** End Problem 6  *****************************************************/   
        //*************  Problem 7  (Optional) Test the remove(anEntry) method
        System.out.println("\n\n**************** Problem 7 (Optional) **************\n");
        
        //Integer [] array = {10, 2, 4, 5};
        //System.out.println("Can I add an array of Integer to duffleBag? " + duffleBag.add(array));
        System.out.println("size of duffleBag = " + duffleBag.getCurrentSize());        
        System.out.println("contents of duffleBag: " + duffleBag);        
        
        System.out.println("Follow the steps in Problem 7 to turn your ArrayBag into a\n" + " class of generic type T");
        System.out.println("Then in step one add <String> after ArrayBag 6 times");
        System.out.println("Recompile...you should see a compiler error preventing the previous add");
        
        
        //********** End Problem 7  *****************************************************/   
        //*************  Problem 8  (Optional) Test the toArray method
        System.out.println("\n\n**************** Problem 8 (Optional) **************\n");
        
        Object [] contents = duffleBag.toArray();
        
        System.out.println("Here are the contents of duffleBag now in an array: ");
        for (int k=0; k<contents.length; k++)
            System.out.println(contents[k]);
            
        System.out.println("To use these items as String, you have to cast each back to String");
        
        String [] stringContents = new String[contents.length];
        for (int k=0; k<contents.length; k++)
            stringContents[k] = (String) contents[k];
            
        System.out.println("Here are the contents of duffleBag now in a String array: ");
        for (int k=0; k<stringContents.length; k++)
            System.out.println(stringContents[k].toUpperCase());        
        
        //********** End Problem 8  *****************************************************/   
    }
}
