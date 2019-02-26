
/**
 * Write a description of class FunWithLists here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FunWithLists
{
    public static void main(String [] args)
    {
        System.out.println("\f");
        LList<String> myList = new LList<String>();
        
        myList.add("hey"); myList.add("there"); myList.add("people");
        
        System.out.println("myList = " + myList);
        
    }
}
