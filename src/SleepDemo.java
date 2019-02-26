import java.util.*;
  
class SleepDemo {
   public static void main(String args[]) throws InterruptedException
   {
         System.out.println(new Date( ) + "\n"); 
         Thread.sleep(3000); // sleep for 3 seconds
         System.out.println(new Date( ) + "\n"); 
   }
}