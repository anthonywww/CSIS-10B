package lab7;

import java.util.Scanner;

/**
 * Write a description of class Student here. Class student represents a student
 * record in a database.
 * 
 * @author (Villarreal)
 * @version 2/9/2011
 */
public class Student implements Comparable<Student> {
	
	public static final int BY_ID = 0;
	public static final int BY_LASTNAME = 1;
	public static final int BY_GPA = 2;
	public static int compareType = BY_LASTNAME;
	
	private String firstName, lastName;
	private double GPA;
	private int ID;

	public Student() { // default constructor
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
		return firstName + " " + lastName + ", ID: " + ID + " - GPA: " + GPA + "\n";
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

	public void read(Scanner s) {
		ID = s.nextInt();
		firstName = s.next();
		lastName = s.next();
		GPA = s.nextDouble();
	}

	@Override
	public int compareTo(Student other) {
		if (compareType == BY_LASTNAME) {
			if (lastName.equals(other.lastName)) {
				return this.firstName.compareTo(other.firstName);
			}
			return this.lastName.compareTo(other.lastName);
		} else if (compareType == BY_ID) {
			return ID - other.ID;
		} else if (compareType == BY_GPA) {
			return Double.compare(other.GPA, GPA);
		}		
		return 0;
	}
}
