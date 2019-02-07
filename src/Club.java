
import lab2.lab2a.Person;

/**
 * Write a description of class Club here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Club {

	private Bag<Person> members;
	private String clubName;
	private String phoneNumber;
	private String emailAddress;

	/**
	 * Constructor for objects of class Club
	 */
	public Club() {
		this("Default Club Name");
	}
	
	public Club(String clubName) {
		this.clubName = clubName;
		members = new Bag<Person>();
	}
	
	
	public void setClubName(String clubName) {
		this.clubName = clubName;
	}
	
	public String getClubName() {
		return clubName;
	}
	
	public int getCurrentSize() {
		return members.getCurrentSize();
	}
	
	public boolean isFull() {
		return members.isFull();
	}
	
	public boolean isEmpty() {
		return members.isEmpty();
	}
	
	public boolean add(Person person) {
		return members.add(person);
	}
	
	public Person remove() {
		return members.remove();
	}
	
	public boolean remove(Person person) {
		return members.remove(person);
	}
	
	public void clear() {
		members.clear();
	}
	
	public int getFrequencyOf(Person person) {
		return members.getFrequencyOf(person);
	}
	
	public boolean contains(Person person) {
		return members.contains(person);
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return members.toString();
	}

}
