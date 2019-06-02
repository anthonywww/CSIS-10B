package lab6.lab6a;

import lab5.ArrayBag;

/** Lab 5 exercises -- Array based Bag, Stack, Queue and List Classes
 *  
 */
public class Lab6a
{
    public static void main(String [] args)
    {
        System.out.println("\f");
        //********** Problem 0 Test constructors, isEmpty, isFull, getCurrentSize *************
        // declare 3 bags
        System.out.println("**************** Problem 0 **************\n");
        
        LinkedBag duffleBag = new LinkedBag();
        LinkedBag groceryBag = new LinkedBag();        
        LinkedBag tinyBag = new LinkedBag(); // this bag can hold zero items
        
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
        //********** Problem 1 test your add and toString methods  ****************
        System.out.println("\n\n**************** Problem 1 **************\n");
        
        // add some items
        duffleBag.add("ball"); duffleBag.add("keys"); duffleBag.add("cap"); duffleBag.add("ball"); 
        duffleBag.add("ball"); duffleBag.add("keys"); duffleBag.add("ball"); 
        
        System.out.println("   size of duffleBag = " + duffleBag.getCurrentSize());        
        System.out.println("   is duffleBag empty? " + duffleBag.isEmpty());
        System.out.println("   is duffleBag full? " + duffleBag.isFull());
        System.out.println("contents of duffleBag: " + duffleBag);        

        System.out.println();
        
        // check add returns boolean
        if (groceryBag.add("candy bar"))
            System.out.println("Successfully added one candy bar to groceryBag");
            
        // add until full    
        while( groceryBag.add("candy bar") && groceryBag.getCurrentSize()<10)
            System.out.println("added another candy bar!");
            
        System.out.println("\n   size of groceryBag = " + groceryBag.getCurrentSize());        
        System.out.println("   is groceryBag empty? " + groceryBag.isEmpty());
        System.out.println("   is groceryBag full? " + groceryBag.isFull());
        System.out.println("contents of groceryBag: " + groceryBag);        
        
        //********** End Problem 1  *****************************************************/  
        //********** Problem 2 test your getFrequencyOf method  ****************        
        System.out.println("\n\n**************** Problem 2**************\n");
        
        System.out.println("There are " + duffleBag.getFrequencyOf(new String("ball")) + " balls in duffleBag");
        System.out.println("There are " + groceryBag.getFrequencyOf(new String("candy bar")) + " candy bars in groceryBag");
        
        
        //********** End Problem 2  *****************************************************/
        //********** Problem 3 test your contains method  *****************
        System.out.println("\n\n**************** Problem 3**************\n");

        System.out.println("Does duffleBag contain keys? " + duffleBag.contains(new String("keys")));
        System.out.println("Does groceryBag contain broccoli? " + groceryBag.contains(new String("broccoli")));
        
        
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
        //*************  Problem 6  Test the remove(anEntry) method
        System.out.println("\n\n**************** Problem 6 **************\n");
               
        duffleBag.remove(new String("cap"));
        
        System.out.println("After remove(\"cap\"); from duffleBag");
        System.out.println("   size of duffleBag = " + duffleBag.getCurrentSize());        
        System.out.println("contents of duffleBag: " + duffleBag);        
        System.out.println("   should be: ball, ball, keys, keys, ball");
        System.out.println();   
        
        duffleBag.remove(new String("book"));
        
        System.out.println("After remove(\"book\"); from duffleBag");
        System.out.println("   size of duffleBag = " + duffleBag.getCurrentSize());        
        System.out.println("contents of duffleBag: " + duffleBag);        
        
        //********** End Problem 6  *****************************************************/   
        //*************  Problem 7 Convert LinkedBag to Generic
        System.out.println("\n\n**************** Problem 7 **************\n");
        
        Integer [] array = {10, 2, 4, 5};
        System.out.println("Can I add an array of Integer to duffleBag? " + duffleBag.add(array));
        System.out.println("size of duffleBag = " + duffleBag.getCurrentSize());        
        System.out.println("contents of duffleBag: " + duffleBag);        
        
        System.out.println("Follow the steps in Problem 7 to turn your LinkedBag into a\n" +
                           " class of generic type T");
        System.out.println("Then in step one add <String> after LinkedBag 6 times");
        System.out.println("Recompile...you should see a compiler error preventing the previous add");
        System.out.println("This is a good thing...just comment out the line that adds array to duffleBag");
        
        //********** End Problem 7  *****************************************************/   
        //*************  Problem 8 Test the toArray method
        System.out.println("\n\n**************** Problem 8 **************\n");
        
        Object [] contents = duffleBag.toArray();

        System.out.println("Here are the contents of duffleBag now in an array: ");
        for (int k=0; k<contents.length; k++)
            System.out.println(contents[k]);
            
        System.out.println("To use these items as String, you have to cast each back to String");
        System.out.println("as the following lines show in the program");
        
        String [] stringContents = new String[contents.length];
        for (int k=0; k<contents.length; k++)
            stringContents[k] =  (String) contents[k];
            
        System.out.println("Here are the contents of duffleBag now in a String array: ");
        for (int k=0; k<stringContents.length; k++)
            System.out.println(stringContents[k].toUpperCase());        
        
        //********** End Problem 8  *****************************************************/   
        //*************  Problem 9 Test the union method
        System.out.println("\n\n**************** Problem 9 **************\n");
        
        BagInterface<String> gymBag = new ArrayBag<String>();
        gymBag.add("towel");
        gymBag.add("padlock");
        gymBag.add("shampoo");

        System.out.println("\nBefore combining duffleBag with gymBag, ");        
        System.out.println("   contents of duffleBag: " + duffleBag);                
        System.out.println("   contents of gymBag: " + gymBag);

        BagInterface<String> sportBag = duffleBag.union(gymBag); 
        
        System.out.println("\nThe combined sportBag of duffelBag and gymBag contains: " + sportBag);

        System.out.println("Check that the original bags haven't changed");
        System.out.println("   contents of gymBag: " + gymBag);
        System.out.println("   contents of duffleBag: " + duffleBag);

        groceryBag.add("toothpaste");
        groceryBag.add("asparagus");
        System.out.println("\nBefore combining sportBag with groceryBag, ");        
        System.out.println("   contents of sportBag: " + sportBag);                
        System.out.println("   contents of groceryBag: " + groceryBag);        
        
        BagInterface<String> megaBag = sportBag.union(groceryBag); 
      
        System.out.println("\nThe combined megaBag of sportBag and groceryBag contains: " + megaBag);

        System.out.println("Check that the original bags haven't changed");
        System.out.println("   contents of sportBag: " + sportBag);
        System.out.println("   contents of groceryBag: " + groceryBag);
        
        //********** End Problem 9   *****************************************************/         
        
        
    }
}
