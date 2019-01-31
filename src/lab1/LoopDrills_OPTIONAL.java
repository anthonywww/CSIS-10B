package lab1;

import java.util.*;

/**
 * Drills in different Looping constructs
 */

public class LoopDrills_OPTIONAL {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		// ****************** Problem 1 Multiple Assignment *************************
		System.out.println("****************** P1 *********************");
		// observer the output of these four statements,
		// then add statements where indicated below.
		int x = 5;
		System.out.println("after assigning 5 to x, x = " + x);
		x = 7;
		System.out.println("after assigning 7 to x, x = " + x);

		int y = 3;
		// a) assign the value of y to x here (this means x = y;)
		y = x;
		System.out.println("after assigning y to x, x = " + x + " (should be 3)");

		// demonstrates assigning the result of adding x + 1 back to x
		x = x + 1;
		System.out.println("after assigning x + 1 to x, x = " + x + " (should be 4)");

		// b) assign the result of adding x + 5 back to x
		x += 5;
		System.out.println("after assigning x + 5 to x, x = " + x + " (should be 9!)");

		// c) use System.out.println to determine the effect of this statement on the
		// value stored in x
		x++;
		System.out.println("x++ = " + x);

		// d) use System.out.println to determine the effect of this statement on the
		// value stored in x
		x--;
		System.out.println("x--" + x);

		// ****************** End Problem 1 ***************************/
		/******************
		 * Problem 2 Basic Counting While Loop *******************
		 * System.out.println("****************** P2 *********************"); // Run
		 * this loop and observe the output. // Then modify the loop controls at a), b)
		 * and c) so it prints // "0, 2, 4, 6, 8, Done!"
		 * 
		 * int n=10; // a) initialize the value of n while (n > 0) // b) test the value
		 * in n { System.out.println(n); n = n-1; // c) change the value in n }
		 * System.out.println("Blastoff!"); // d) final message (only repeats once)
		 * 
		 * 
		 * //****************** End Problem 2
		 ***************************/
		/******************
		 * Problem 3 While Loop Debug *****************************
		 * System.out.println("****************** P3 *********************"); // This
		 * loop is supposed to count up from 0 to 100 in steps of 10 // But it has a
		 * couple errors. Fix it so it works right. // Remember, to halt an infinite
		 * loop in BlueJ, // R-click the red "barber pole" run indicator, then choose
		 * reset JVM
		 * 
		 * int k = 0; while (k != 101) { System.out.print(k + ", "); k + 10; }
		 * System.out.println("Done");
		 * 
		 * //****************** End Problem 3
		 *****************************/
		/******************
		 * Problem 4 Repeating a Calculation ********************
		 * System.out.println("****************** P4 *********************"); // Run
		 * this program, then modify it using a While-loop to calculate // the area of
		 * three different circles, following the instructions below.
		 * 
		 * double radius, area; // 1) System.out.println("Enter a radius "); // 2)
		 * radius = keyboard.nextDouble(); // 3) area=3.14*radius*radius; // 4)
		 * System.out.println("The area is " + area); // 5)
		 * 
		 * // a) Above line 1) declare variable int count and initialize it to 0 // b)
		 * insert a while statement after line 1) while (count < 3) // c) put lines 2
		 * through 5 inside curly braces below your while header // d) before the close
		 * curly brace, (after line 5) increment count by 1.
		 * 
		 * // Run your modified program and see that it computes area for three circles
		 * 
		 * //****************** End Problem 4
		 ***************************/
		/******************
		 * Problem 5 If Statements in loops *****************************
		 * System.out.println("****************** P5 *********************"); // Run
		 * this program. Notice that to quit the loop, enter an age less than 0 // //
		 * Now add if statements to the loop to insult the person based on their age //
		 * for people less than 13, "not ready for prime time" // for teenagers, "grow
		 * up" // for people 20 and over, "get a job!" // ...etc...
		 * 
		 * int age = 0;
		 * 
		 * while (age >= 0) { System.out.print("What is your age? "); age =
		 * keyboard.nextInt(); System.out.println("Really, you are " + age + " years
		 * old?"); }
		 * 
		 * //****************** End Problem 5
		 ***************************/
		/******************
		 * Problem 6 Input Validation Loops ****************
		 * System.out.println("****************** P6 *********************"); // Run
		 * this program, then add a do-while loop to make sure // the input is between 1
		 * and 100 before allowing the // the program to continue to the last statement.
		 * // int number;
		 * 
		 * // start the do loop here System.out.print("Enter a number in the " + "range
		 * of 1 through 100: "); number = keyboard.nextInt();
		 * 
		 * 
		 * System.out.println("Finally! You entered " + number);
		 * 
		 * 
		 * 
		 * //****************** End Problem 6
		 ***************************/
		// ****************** Problem 7 Printing a table ****************
		System.out.println("****************** P7 *********************");
		// Run this program, which makes a table converting Centigrade to Fahrenheit
		// then make another table as indicated below.

		double tempF;
		double tempC = 20;
		while (tempC <= 40) {
			tempF = 1.8 * tempC + 32;
			System.out.println(tempC + " C = " + tempF + " F");
			tempC = tempC + 5;
		}

		// NOW make your own table of miles to kilometers using a loop as above
		// miles on the left, from 10 to 100 miles, steps of 10
		// km on the right
		// remember km = miles*1.609344

		// ****************** End Problem 7 ***************************/
		// ****************** Problem 8 Encapsulating a loop in a method *********
		System.out.println("****************** P8 *********************");
		// Run this program and notice it calls the C2FTable method
		// defined below main. Notice the output.

		C2FTable(0, 100, 10);

		// now print a table from 30 to 50 degrees C, in steps of 1 deg C.

		// now write your own method below main to print miles to km tables
		// test using these calls
		// miles2kmTable(20,120,5);
		// miles2kmTable(50,55,0.1);

		// ****************** End Problem 8 ***************************/
	} // end of main method

	public static void C2FTable(int startC, int stopC, int stepC) {
		double tempC = startC, tempF;
		while (tempC <= stopC) {
			tempF = 1.8 * tempC + 32;
			System.out.println(tempC + "C = " + tempF + "F");
			tempC = tempC + stepC;
		}
	}
}
