package lab2.lab2a;

//*** make Student inherit from Person class
public class Student extends Person {

	private int studentNumber;

	public Student() {
		// *** invoke the no-arg constructor of the base class (Person)
		super();

		// *** set the studentNumber to 0, indicating no number yet
		this.studentNumber = 0;
	}

	public Student(String initialName, int initialStudentNumber) {
		// *** invoke the explicit constructor of the base class (Person), passing it
		// initialName
		super(initialName);

		// *** set the studentNumber to initialStudentNumber
		this.studentNumber = initialStudentNumber;
	}

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int newStudentNumber) {
		// *** set the studentNumber to newStudentNumber
		this.studentNumber = newStudentNumber;
	}

	public static void main(String[] args) {
		/******
		 * Test Driver for Student class **************************** Student s1 = new
		 * Student();
		 * 
		 * s1.setName("Hermes Paris"); // uses the setName of the Person class
		 * s1.setStudentNumber(987654);
		 * 
		 * Student s2 = new Student("Zeus Monassus", 12345);
		 * 
		 * System.out.println("Student s1 = " + s1); System.out.println("Student s2 = "
		 * + s2); //
		 ******************************************************************/
		Student s1 = new Student();
		s1.setName("Hermes Paris");
		s1.setStudentNumber(987654);
		
		Student s2 = new Student("Zeus Monassus", 12345);
		
		System.out.printf("Student s1 = %s\n", s1);
		System.out.printf("Student s2 = %s\n", s2);
	}
}

/*
Student s1 = Hermes Paris
Student s2 = Zeus Monassus
*/
