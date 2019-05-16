package lab12;

//--------------------------------------------------------------------
//
//  Laboratory 13, In-lab Exercise 3                       OsSim.jshl
//
//  (Shell) Operating system task scheduling simulation
//
//  The student is to complete all missing or incomplete method 
//     implementations for this class
//
//--------------------------------------------------------------------

// Simulates an operating system's use of a priority queue to regulate
// access to a system resource (printer, disk, etc.).

import java.io.*;
import java.util.Random;
import java.util.Scanner;

class OS_Simulator {
	
	public static void main (String args[]) {
        PriorityQueue<Job> taskPQ = new PriorityQueue<Job>( ); // Priority queue of tasks
        
        Job task;                           // Task
        int simLength,                      // Length of simulation (minutes)
            minute,                         // Current minute
            timeArrived,                    // Time task arrived
            numPtyLevels,                   // Number of priority levels
            pLevel,                         // Priority level of the task
            numArrivals = 0,                // Number of new tasks arriving
            maxWait0 = 0,                   // Longest wait for priority 0
            maxWait1 = 0,                   // Longest wait for priority 1 
            j;                              // Loop counter

        Random rand = new Random(System.currentTimeMillis());
        Scanner keyboard = new Scanner(System.in);                                                      
        //-----------------------------------------------------------------
        // Read in the number of priority levels
        
        System.out.println( );
        System.out.print("Enter the number of priority levels : ");
        numPtyLevels = keyboard.nextInt();

        System.out.print("Enter the length of time to run the simulator : ");
        simLength = keyboard.nextInt();
        
        System.out.println( );
        System.out.println("                 Priority"  
                           + "    Arrived" + "\t"
                           + "Waited");

        for ( minute = 0 ; minute < simLength ; minute++ )
        {
            // Dequeue the first task in the queue (if any) and
            //  print info about the task dequeued.


            
            
            
            
            
            // Determine the number of new tasks.





        
        
        
        
        
            // Add new tasks to the queue.
            for (                                       )
            {
            
        
        
        
                System.out.println("At " + minute + " enqueued : " + "\t" + task.pty( ));
            }
        }

        // Output longestWait for each priority
  
        
        
    } // main

} // class