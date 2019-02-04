package lab1;

import java.util.Scanner;

/**
 * Write a description of class Drills here.
 * 
 * @author anthonywww
 * @version 1/28/2019
 */
public class Drills_OPTIONAL {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter a test score: ");
		int score = keyboard.nextInt();
               
        /************* Ex A **************************
        // write a simple if statement that says "pass" 
        //  if score is >= 65, otherwise it says nothing 
        System.out.println("A) Conditional Execution");
        //************ End Ex A **********************/
		if (score >= 65) {
			System.out.println("pass");
		}
		
        /************* Ex B **************************
        // Use an if-else statement to choose one of the following:
        //     Show "pass" if score is>=65, 
        //     otherwise show "fail"  (use  if-else)
        //    Test your solution by entering different scores
        System.out.println("B) Alternative Execution");
		//************ End Ex B **********************/
		if (score >= 65) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
		
		
        /************* Ex C **************************
        // Study the Lecture 4	slides and then write a 
        // nested if-else statement that prints
        //            "A" if the variable score is >= 90, 
        //            "B" if the variable score is >= 80, 
        //            "C" if the variable score is >= 65, 
        //            "D" if the variable score is >= 50, or 
        //            "F" if none of the above are true  
        System.out.println("C) Chained Conditionals");
		//************ End Ex C **********************/
		if (score >= 90) {
			System.out.println("A");
		} else if (score >= 80) {
			System.out.println("B");
		} else if (score >= 65) {
			System.out.println("C");
		} else if (score >= 50) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}
		
		
        /************* Ex D **************************
        // Write a mini program in which the user inputs 
        // an age and the output states whether or not the 
        // person is a teenager. Use nested conditionals 
        //   -- first check if age is greater than 12
        //   --    inside the code block for true, 
        //   --       check if age is less than 20
        //
        // Print  "Hooray! A Teen!"  or "sorry :("  depending on age
        //
        // Use the keyboard scanner we've already created to read age
        //
        System.out.println("D) Nested Conditionals");
        System.out.print("   What is your age?");
        // declare int age and read age from keyboard Scanner
        // write your nested if block here
        //************ End Ex D **********************/
		System.out.print("What is your age? ");
		int age = keyboard.nextInt();
		if (age > 12) {
			if (age < 20) {
				System.out.println("Hooray! A Teen!");
			} else {
				System.out.println("Sorry :(");
			}
		} else {
			System.out.println("Sorry :(");
		}
		
		
        /************* Ex E ************************** // write a void method, paycheck, below main
		 * that calculates and prints // a worker's paycheck, given the number of hours,
		 * and pay rate // similar to last weeks drill, but THIS TIME use an if
		 * statement to // award overtime properly. // payCheck( 40, 7.75); // answer:
		 * $310
		 * 
		 * payCheck( 20, 9.25); // answer: $185
		 * 
		 * payCheck( 50, 12.50); // answer: $687.50 // (the first 40 hours are paid at $12.50 // the next 10 hours are at $12.50*1.5)
		 * 
		 * payCheck( 45, 15.00); // answer: $712.50
		 * //************ End Ex E **********************/
		
		payCheck(40, 7.75);  // $310
		payCheck(20, 9.25);   // $185
		payCheck(50, 12.50);  // $687.50
		payCheck(45, 15.00);  // $712.50
	}
	
	
	// write your pay method here
	private static void payCheck(int hours, double rate) {
		double money = 0.0;
		final double overtimeMultiplier = 1.5;
		final int overtimeHours = 41;
		
		if (hours >= overtimeHours) {
			// Calculate normal rate first, then calculate overtime hours
			money = (overtimeHours-1) * rate;
			money += (hours - (overtimeHours-1)) * rate * overtimeMultiplier;
		} else {
			// Calculate normal rate
			money = hours * rate;
		}
		
		System.out.printf("$%.2f\n", money);
	}
	
	
}

/*
Enter a test score: 90
pass
pass
A
What is your age? 13
Hooray! A Teen!
$310.00
$185.00
$687.50
$712.50
*/