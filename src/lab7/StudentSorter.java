package lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Write a description of class StudentSorter here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class StudentSorter {
	
	public static void main(String[] args) {
		
//		int[] data = {4,1,6,9,3,2,7,8,5};
//		System.out.println(Arrays.toString(data));
//		Arrays.sort(data);
//		System.out.println(Arrays.toString(data));
		
		
		File file = new File("src/lab7/Student100.txt");
		Student temp;
		Student[] database = new Student[200]; // extra space in case we go over 100
		int size = 0;
		
		try {
			Scanner s = new Scanner(file);

			while (s.hasNext()) {
				// read in a Student record from the scanner and store in database array
				temp = new Student();
				temp.read(s);
				database[size++] = temp;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// print the unsorted database array
		System.out.println(Arrays.toString(database));

		// sort and display the database array by lastName (and if they are the same by firstName) using your bubble sort method
		Arrays.sort(database, 0, size);
		System.out.println("After sorting by LAST NAME ...");
		System.out.println(Arrays.toString(database));
		
		// Then sort and display the database array by ID using your bubble sort
		Student.compareType = Student.BY_ID;
		Arrays.sort(database, 0, size);
		System.out.println("After sorting by ID ...");
		System.out.println(Arrays.toString(database));

		// Then sort and display the database array by descending GPA using your bubble sort
		Student.compareType = Student.BY_GPA;
		Arrays.sort(database, 0, size);
		System.out.println("After sorting by GPA ...");
		System.out.println(Arrays.toString(database));
	}
	
	
}
