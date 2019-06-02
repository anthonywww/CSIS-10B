package assignment4;

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
		File file = new File("src/assignment4/Student100.txt");
		Student temp;
		Student[] database = new Student[200];
		int index = 0;
		try {
			Scanner s = new Scanner(file);
			while (s.hasNext()) {
				temp = new Student();
				temp.read(s);
				database[index++] = temp;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Sort by last name
		for (int i = 0; i < index; i++) {
			System.out.println("Sort by Last Name");
			Student.compareBy(Student.SORT_BY_LAST_NAME);
			sortAndDisplay(database, index);
		}

		// Sort by GPA
		for (int i = 0; i < index; i++) {
			System.out.println("Sort by GPA");
			Student.compareBy(Student.SORT_BY_GPA);
			sortAndDisplay(database, index);
		}

		// Sort by ID
		for (int i = 0; i < index; i++) {
			System.out.println("Sort by ID");
			Student.compareBy(Student.SORT_BY_ID);
			sortAndDisplay(database, index);
		}

		// Search for student by ID
		System.out.print("Enter student ID: ");
		Scanner keyboard = new Scanner(System.in);
		int id = Integer.parseInt(keyboard.nextLine());
		keyboard.close();

		Student key = new Student();
		key.setID(id);

		int locationIndex = Arrays.binarySearch(database, key);

		if (locationIndex >= 0 && locationIndex < database.length) {
			Student s = database[locationIndex];
			System.out.printf("Student %s, %s found at index #%d\n", s.getFirstName(), s.getLastName(), locationIndex);
		} else {
			System.out.println("Student not found by id: " + id);
		}

	}

	private static void sortAndDisplay(Student[] database, int index) {
		Arrays.sort(database, 0, index);
		for (int i = 0; i < index; i++) {
			System.out.println(database[i]);
		}
	}

}
