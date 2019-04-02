package assignment2.assignment2;

import java.util.Scanner;

/**
 * Write a description of class Student here. Class student represents a student
 * record in a database.
 * 
 * @author (Villarreal)
 * @version 2/9/2011
 */
public class Student {
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
}
