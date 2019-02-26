

//--------------------------------------------------------------------
//
//  Laboratory 6, In-lab Exercise 3                    StoreSim.jshl
//
//  (Shell) Store simulation program
//
//  The student is to complete all missing or incomplete method
//     implementations for this class
//
//--------------------------------------------------------------------

// Simulates the flow of customers through a line in a store.

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

class StoreSim {
    public static void main (String args[]) {
        // want to make the "uses unsafe operations" warning go away?
        //  put <Integer> after LQueue (both places) below
        
        LQueue<Integer> custQ = new LQueue<Integer>(); // Line (queue) of customers containing 
                                     //   the time that each customer arrived 
                                     //   and joined the line
        Random rand                  // Initialize random number generator
            = new Random(System.currentTimeMillis());   // seed is system 
                                                        // clocktime to limit 
                                                        // sequence repetition
        Scanner keyboard = new Scanner(System.in);
        
        int simLength,              // Length of simulation (minutes)
            minute,                 // Current minute
            timeArrived,            // Time dequeued customer arrived
            waitTime,               // How long dequeued customer waited
            totalServed = 0,        // Total customers served
            totalWait   = 0,        // Total waiting time for all customers
            maxWait     = 0,        // Longest wait
            numArrivals = 0,        // Number of new arrivals
            j;                      // Loop counter



        System.out.println("Enter the Number of minutes the Simulator will run: ");
        simLength = keyboard.nextInt();

        for (minute = 0; minute<simLength; minute++) {
            // Output time & number of customers waiting in line
            System.out.printf("Minute: %d, Arrivals: %d\n", minute, custQ.size());

            // Dequeue the first customer in line (if any). Increment
            // totalServed, add the time that this customer waited to
            // totalWait, and update maxWait if this customer waited
            // longer than any previous customer.
            if (!custQ.isEmpty()) {
            	timeArrived = custQ.dequeue();
            	waitTime = minute - timeArrived;
                totalServed++;
                totalWait += waitTime;
                
                System.err.printf("arrived:%s wait:%s served:%s wait:%s\n", timeArrived, waitTime, totalServed, totalWait);
                
                if (waitTime > maxWait) {
                	maxWait = waitTime;
                }
            }

            // Determine the number of new customers.
            // Uses a random number generator.

            switch (rand.nextInt(4))  // Randomly generate a number from 0 to 3
            {
            	case 0:
            	case 1:
            		// No customers
            		break;
            	case 2:
            		// One customer
            		custQ.enqueue(minute);
            		break;
            	case 3:
            		// Two customers
            		custQ.enqueue(minute);
            		custQ.enqueue(minute);
            		break;
            }

            // Add the new customers to the line

        }
        
        // set precision to 2 decimal places
        DecimalFormat fmt = new DecimalFormat("0.##");
        
        System.out.println("\nCustomers served : " + totalServed);
        System.out.println("Average wait     : " + fmt.format((double)totalWait/totalServed));
        System.out.println("Longest wait     : " + maxWait);
    }

}