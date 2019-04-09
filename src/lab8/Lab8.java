package lab8;

import java.util.Scanner;

/**
 * class Lab6: Recursion and Big-O code analysis
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lab8 {
	
	public static int board[][] = {
			{ 6, 4, 7, 4, 8, 3, 6, 7 },
			{ 9, 1, 4, 7, 3, 6, 8, 6 },
			{ 4, 8, 1, 9, 7, 9, 2, 3 },
			{ 1, 8, 6, 6, 8, 4, 8, 3 },
			{ 7, 3, 7, 4, 4, 1, 5, 9 },
			{ 1, 6, 3, 2, 1, 4, 3, 3 },
			{ 5, 3, 8, 4, 2, 6, 7, 9 },
			{ 6, 4, 3, 8, 7, 1, 2, 4 } 
	};

	public static int validInput(int low, int high) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("Enter a number between %d and %d: ", low, high);
		int i = sc.nextInt();
		if (i <= high && i >= low) {
			return i;
		}
		return validInput(low, high);
	}

	private static void displayRowOfCharacters(char c, int times) {
		if (times > 1) {
			displayRowOfCharacters(c, times - 1);
		}
		System.out.print(c);
	}

	private static void displayBackward2(int[] data, int start, int end) {
		if (end > start) {
			displayBackward2(data, start + 1, end);
			System.out.print(", ");
		}
		System.out.print(data[start]);
	}

	private static void displayBackward(int[] data, int start, int end) {
		System.out.print(data[end]);
		if (end > start) {
			System.out.print(", ");
			displayBackward(data, 0, end - 1);
		}
	}

	private static boolean isPalindrome(String s) {
		boolean firstAndLast = s.charAt(0) == s.charAt(s.length() - 1);
		if (firstAndLast) {
			if (s.length() <= 2) {
				return true;
			}
			return isPalindrome(s.substring(1, s.length() - 1));
		}
		return false;
	}

	public static void main(String[] args) {
		// read the Lab 6 handout on the website for more information

		// **************** Problem 1 Write the recursive method used below *****
		// Do not change this method call

		int n = validInput(1, 10);
		System.out.println("You entered " + n);

		// ************************ End Problem 1 ****************************/
		// ******* Problem 2 Implement displayRowOfCharacters above main ******

		displayRowOfCharacters('~', 50);
		displayRowOfCharacters('@', 10);
		System.out.println();

		// ************************ End Problem 2 ****************************/
		// **************** Problem 3 displayBackward method ********

		int data[] = { 12, 20, 30, 42, 49, 50 };
		displayBackward(data, 0, 5);
		System.out.println();

		// ************************ End Problem 3 ***************************/
		// **************** Problem 4 displayBackward2 method ********

		int data2[] = { 12, 20, 30, 42, 49, 50 };
		displayBackward2(data, 0, 5);
		System.out.println();

		// ************************ End Problem 4 ***************************/
		// **************** Problem 5 isPalindrome method ********

		System.out.println("Is level a palindrome? " + isPalindrome("level"));
		System.out.println("Is deed a palindrome? " + isPalindrome("deed"));
		System.out.println("Is leval a palindrome? " + isPalindrome("leval"));
		System.out.println("Is dead a palindrome? " + isPalindrome("dead"));

		// ************************ End Problem 5 ***************************/
		// **************** Problem 6 Do CodingBat exercises, copy answers below
		// ********

		System.out.println("factorial(10) = " + factorial(10));
		System.out.println("bunnyEars(212) = " + bunnyEars(212));
		System.out.println("count7(37891734) = " + count7(37891734));
		System.out.println("sumDigits(51823102) = " + sumDigits(51823102));

		// ************************ End Problem 6 ***************************/
		// **************** Problem 7 write the maxValue method and use it ********
		// to find the max value possible from moving from the bottom to the top
		// row of the checkerboard defined above as board[][]

		// ************************ End Problem 7 ***************************/
	}
	
	
	private static int maxValue(int row, int column) {
		// FIXME: read lab paper
		
	}
	

	private static int factorial(int n) {
		if (n <= 1) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	private static int bunnyEars(int bunnies) {
		if (bunnies <= 0) {
			return 0;
		}
		return 2 + bunnyEars(bunnies - 1);
	}

	private static int count7(int n) {
		if (n <= 0) {
			return 0;
		}
		if (n % 10 == 7) {
			return 1 + count7(n / 10);
		}
		return count7(n / 10);
	}

	private static int sumDigits(int n) {
		if (n <= 0) {
			return 0;
		}
		return (n % 10) + sumDigits(n / 10);
	}

}
