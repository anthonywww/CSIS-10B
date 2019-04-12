package assignment3;

import java.util.*;

/**
 * Tester App for Stack Classes
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StackTester {
	
    public static void main(String [] args) {
        //****************** 1 make an array based stack **********************
        StackArray st = new StackArray();       

        System.out.println("1 Empty stack ? " + st.isEmpty() );
        
        System.out.println("1 StackArray st = " + st);
        //****************** end 1 **********************/
        //****************** 2 add items **********************

        st.push("ball");
        st.push("cap");
        st.push("mitt");
        st.push("cleats");
        System.out.println("2 Stack st = " + st);
        System.out.println("2 Stack st contains " + st.size() + " elements");  
        
        /****************** end 2 **********************/
        //****************** 3 examine and remove items **********************
        
        System.out.println("3 top of stack = "+ st.peek());
        
        while( !st.isEmpty())
            System.out.println( st.pop());
        
        System.out.println("3 Stack st = " + st);
        
        //****************** end 3 **********************/
        //****************** 4 make an linked node based stack **********************
		StackLink sl = new StackLink();

		System.out.println("4 Empty stack ? " + sl.isEmpty());
		System.out.println("4 StackLink sl = " + sl);
        
        //****************** end 4 **********************/
        //****************** 5 add items **********************

		sl.push("ball");
		sl.push("cap");
		sl.push("mitt");
		sl.push("cleats");
		System.out.println("5 Stack sl = " + sl);
		System.out.println("5 Stack sl contains " + sl.size() + " elements");  
        
        //****************** end 5 **********************/
        //****************** 6 examine and remove items **********************
        
		System.out.println("6 top of stack = " + sl.peek());

		while (!sl.isEmpty()) {
			System.out.println(sl.pop());
		}
        
        //****************** end 6 **********************/
    }
    
}
