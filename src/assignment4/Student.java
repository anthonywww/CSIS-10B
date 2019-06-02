package assignment4;

import java.util.Scanner;

/**
 * Write a description of class Student here. Class student represents a student
 * record in a database.
 * 
 * @author (Villarreal)
 * @version 2/9/2011
 */
public class Student implements Comparable<Student> {
	
	public static final int SORT_BY_ID = 0;
	public static final int SORT_BY_GPA = 1;
	public static final int SORT_BY_LAST_NAME = 2;
	private static int sortBy = SORT_BY_ID;
	private String firstName, lastName;
	private double GPA;
	private int ID;

	public Student() {
		firstName = "";
		lastName = "";
		GPA = 0;
		ID = 0;
	}

	public Student(String firstName, String lastName, int ID, double GPA) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ID = ID;
		this.GPA = GPA;
	}

	public Student(Scanner s) {
		ID = s.nextInt();
		firstName = s.next();
		lastName = s.next();
		GPA = s.nextDouble();
	}

	public Student clone() {
		Student copy = new Student(firstName, lastName, ID, GPA);
		return copy;
	}

	public boolean equals(Object other) {
		Student that = (Student) other;
		return ((this.ID == that.ID) && (this.GPA == that.GPA) && (this.firstName.equals(that.firstName))
				&& (this.lastName.equals(that.lastName)));
	}

	public String toString() {
		return firstName + " " + lastName + ", ID: " + ID + " - GPA: " + GPA;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getID() {
		return ID;
	}

	public double getGPA() {
		return GPA;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public void setGPA(double GPA) {
		this.GPA = GPA;
	}

	@Override
	public int compareTo(Student other) {
		if (sortBy == SORT_BY_LAST_NAME) {
			int value = lastName.compareTo(other.lastName);
			if (value == 0) {
				return firstName.compareTo(other.firstName);
			}
			return value;
		} else if (sortBy == SORT_BY_GPA) {
			return Double.compare(GPA, other.GPA);
		} else {
			return ID - other.ID;
		}
	}
	
	public void read(Scanner s) {
		ID = s.nextInt();
		firstName = s.next();
		lastName = s.next();
		GPA = s.nextDouble();
	}
	
	public static void compareBy(int sort) {
		sortBy = sort;
	}
	
}
