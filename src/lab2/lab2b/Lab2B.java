package lab2.lab2b;

import java.util.Scanner;

/**
 * Tester App for Stack Classes
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lab2B {
	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		// ****************** 1 make a few stacks, using interface, Array and
		// LinkedStack
		// *********************** and push/pop/print them **********************
		StackInterface<String> st = new LinkedStack<String>();

		System.out.println("1 Empty stack ? " + st.isEmpty());

		System.out.println("1 Stack st = " + st);

		st.push("ball");
		st.push("cap");
		st.push("mitt");
		st.push("cleats");
		System.out.println("2 Stack st = " + st);

		// ****************** end 1 **********************/
		/******************
		 * 2 examine and remove items ********************** // a) print out the top
		 * item on the stack but don't remove it
		 * 
		 * // b) as long as the Stack is not empty, print and pop the next item off the
		 * stack
		 * 
		 * 
		 * 
		 * //****************** end 2
		 **********************/
		/******************
		 * 3 experimenting with Java Wrapper classes ******** // Unfortunately we cannot
		 * make a Stack of char, or double, or int (primitives)
		 * 
		 * // the following won't compile -- until you replace double with Double //
		 * Double is wrapper class for primitive double values StackInterface<Double>
		 * valueStack = new LinkedStack<Double>();
		 * 
		 * // A Double is an object that holds a double primitive value Double number =
		 * new Double(2.34); // this is an object of class Double double value = 2.34;
		 * // this is a primitive of type double // you can use the debugger to see the
		 * difference between number and value
		 * 
		 * // Java has a special service called "autoboxing" that automatically //
		 * encloses a double value into a Double object (and vice versa) as needed // so
		 * you normally don't have to worry about Double vs double issues // this
		 * applies equally to all Wrapper classes -- Double, Integer, Character, //
		 * Boolean, etc number = 3.14; // this is an object of class Double value =
		 * 3.14; // this is a primitive of type double value = number; // autounboxing
		 * -- pulls primitive out of object number = value; // autoboxing -- puts
		 * primitive into object
		 * 
		 * System.out.println("number = " + number + ", value = " + value);
		 * System.out.println("number * value = " + (number*value));
		 * 
		 * // we can put doubles into our valueStack and it converts them to Doubles
		 * valueStack.push(number); valueStack.push(number + value);
		 * System.out.println("valueStack = " + valueStack);
		 * 
		 * //****************** end 3
		 **********************/
		/******************
		 * 4 Static Methods in Java Wrapper classes ******** // The Java Wrapper classes
		 * also come with static methods that can // be useful in processing primitive
		 * data
		 * 
		 * // Note that because they are STATIC methods you invoke them with // the name
		 * of the class in other words, Character.methodName() char keyValue;
		 * 
		 * System.out.println("Type a letter and I will tell you if it's a digit: ");
		 * keyValue = keyboard.nextLine().charAt(0);
		 * 
		 * if ( Character.isDigit(keyValue) ) { System.out.println(keyValue + " is a
		 * digit, between 0 and 9 "); double dval = Character.getNumericValue(keyValue);
		 * System.out.println("The numeric equivalent is " + dval); } else {
		 * System.out.println(keyValue + " is NOT a digit"); } //****************** end
		 * 4
		 **********************/
		/**************
		 * 5 Stack RPN Application ************************ // deactivate problems 1-4
		 * System.out.println("Enter a postfix expression to process: "); String
		 * mathExpression = keyboard.nextLine();
		 * 
		 * char symbol; // one character from the math expression double op1, op2; //
		 * op1, op2: numeric digits popped off of numStack prior to doing operation
		 * double value; // the input character after being converted to a double
		 * 
		 * StackInterface<Double> numStack = new LinkedStack<Double>(); // the numeric
		 * Stack for holding intermediate values
		 * 
		 * for (int k=0; k < mathExpression.length(); k++) { symbol =
		 * mathExpression.charAt(k); System.out.println(" symbol: " + symbol); }
		 * //************************end 5
		 *********************************/
	}
}