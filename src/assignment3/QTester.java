package assignment3;


/**
 * Tester App for Stack and Queue demo classes
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QTester
{
    public static void main(String [] args){
        
        /****************** 1 make a LQueue **********************
        LQueue qu = new LQueue();       

        System.out.println("1 Empty queue ? " + qu.isEmpty() );
        
        System.out.println("1 Queue qu = " + qu);
        //****************** end 1 **********************/
        /****************** 2 add items **********************

        qu.enqueue("ball");
        qu.enqueue("cap");
        qu.enqueue("mitt");
        qu.enqueue("cleats");
        System.out.println("2 Queue qu = " + qu);
        System.out.println("2 Queue qu contains " + qu.size() + " elements");  
        
        //****************** end 2 **********************/
        /****************** 3 examine and remove items **********************
        
        System.out.println("3 head of queue = "+ qu.getFront());
        
        while( !qu.isEmpty())
            System.out.println( qu.dequeue());
        
        //****************** end 3 **********************/
        /****************** 4 make a VQueue **********************
        VQueue<String> qu = new VQueue<String>();       

        System.out.println("4 Empty queue ? " + qu.isEmpty() );
        
        System.out.println("4 Queue qu = " + qu);
        //****************** end 4 **********************/
        /****************** 5 add items **********************

        qu.enqueue("ball");
        qu.enqueue("cap");
        qu.enqueue("mitt");
        qu.enqueue("cleats");
        System.out.println("5 Queue qu = " + qu);
        System.out.println("5 Queue qu contains " + qu.size() + " elements");  
        
        //****************** end 5 **********************/
        /****************** 6 examine and remove items **********************
        
        System.out.println("6 front of queue = "+ qu.getFront());
        
        while( !qu.isEmpty())
            System.out.println( qu.dequeue());
        
        //****************** end 6 **********************/
        
    }
    
}
