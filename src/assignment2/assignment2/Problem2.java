package assignment2.assignment2;
import java.util.Scanner;

import lab13.ADTPackage.LinkedQueue;

/**
 * Write a description of class Problem2 here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Problem2 {
	
	public static void main(String[] args) {
		// Solve the Palindrome problem here
		System.out.print("Enter word >> ");
		Scanner keyboard = new Scanner(System.in);
		String input = keyboard.nextLine();
		ArrayStack<Character> stack = new ArrayStack<Character>();
		LinkedQueue<Character> queue = new LinkedQueue<Character>();
		
		for (int i=0; i<input.length(); i++) {
			char c = input.charAt(i);
			if (Character.isLetter(c)) {
				c = Character.toLowerCase(c);
				stack.push(c);
				queue.enqueue(c);
			}
		}
		
		keyboard.close();
		System.out.println("Is isPalindrome: " + isPalindrome(stack, queue));
	}
	
	public static boolean isPalindrome(ArrayStack<Character> stack1, LinkedQueue<Character> queue1) {
		while (!stack1.isEmpty()) {
			if (stack1.pop() != queue1.dequeue()) {
				return false;
			}
		}
		return true;
	}
	
}

/*
Enter word >> racecar
Is isPalindrome: true
Enter word >> tom
Is isPalindrome: false
*/
