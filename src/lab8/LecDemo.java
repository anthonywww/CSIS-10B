package lab8;


/**
 * Write a description of class Demo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LecDemo
{
    public static void main(String [] args)
    {
    
    }
    
    
    public static void countDown(int n)
    {
        System.out.println( n );
        if (n > 1)
            countDown(n-1); 
    }
    
    public static int sumOf(int n)
    {
        int sum;
        if (n == 1)
            sum = 1; // base case
        else
            sum = sumOf(n - 1) + n; // recursive call
        return sum;
    } // end sumOf
    
    public static void displayArray(int array[], int first, int last)
    { // display an array using recursion
      //    print the first item in array,
      //    if we haven't finished printing, 
      //        do recursive call on the rest
        System.out.println( array[first] + " ");
        
        
    }
    
    public static void displayArray2(int array[], int first, int last)
    {  // display an array using recursion
       //   invoke recursive call FIRST, then do the end of array
        
       
       //  if we haven't finished printing all the items
       //    print all items up to but not including the last one
       
       //  then print the last one
        System.out.println( array[last] + " ");
        
        
    }    
    
    public static void displayArray3(int array[], int first, int last)
    { // uses a midpoint algorithm to divide up the array in half
      // then invokes itself again on both the lower half and the upper half
      //   this is somewhat similar to how the binarySearch algorithm works
      //   and other recursive algorithms such as QuickSort and MergeSort
      
      // if the first and last indices are the same, print that index      
        System.out.println( array[first] + " ");
      // otherwise, 
      //   find the midpoint between first and last
      
      //   display the array recursively from first to mid
      //   display the array recursively from mid+1 to last
        
    }        
    
    
    public static void solveTowers(int numDisks, char startPole, 
                                   char endPole, char tempPole)
    {
        if (numDisks == 1)
            System.out.println("Move a disk from pole " + startPole + " to pole " + endPole);
        
        
    }
}
