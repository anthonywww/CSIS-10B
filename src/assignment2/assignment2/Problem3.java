package assignment2.assignment2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Write a description of class Problem3 here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Problem3 {
	
	public static void main(String[] args) throws IOException {
		// solve the Student List problem here
		
		LList<Student> students = new LList<Student>();
		Scanner sc = new Scanner(new File("src/assignment2/assignment2/Student100.txt"));
		
		while (sc.hasNext()) {
			Student student = new Student();
			student.read(sc);
			students.add(student);
		}
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter a cutoff GPA >> ");
		double cutoff = keyboard.nextDouble();
		keyboard.close();
		
		System.out.println(students.getLength());
		
		for (int i=1; i<students.getLength()+1; i++) {
			Student s = students.getEntry(i);
			if (s.getGPA() < cutoff) {
				students.remove(i);
				i--;
			}
		}
		
		for (int i=1; i<students.getLength()+1; i++) {
			System.out.println(students.getEntry(i));
		}
		
		System.out.println(students.getLength());
	}
	
}
