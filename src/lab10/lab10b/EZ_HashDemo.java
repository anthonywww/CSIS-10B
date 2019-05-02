package lab10.lab10b;

import java.util.Scanner;

/**
 * Write a description of class HashDemo here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class EZ_HashDemo {
	
	public static void main(String[] args) {
		String name = "";
		char grade;
		Scanner keyboard = new Scanner(System.in);
		EZ_HashedDictionary finalGrades = new EZ_HashedDictionary();

		finalGrades.display();
		finalGrades.add("Jill", 'A');
		finalGrades.add("Jeff", 'B');
		finalGrades.display();
		System.out.println("Jill's grade is " + finalGrades.getValue("Jill"));

		while (!name.equals("quit")) {
			System.out.println("Enter a name and grade");
			name = keyboard.next();
			//grade = keyboard.next().charAt(0);
			if (!name.equals("quit")) {
				System.out.printf("Grade for %s is %c\n", name, finalGrades.getValue(name));
				finalGrades.display();
			}
		}
		
		keyboard.close();
	}
	
}
