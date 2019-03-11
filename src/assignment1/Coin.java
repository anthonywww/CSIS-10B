package assignment1;

/**
 * class Coin inherits from GenericCoin
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Coin extends GeneralCoin {
	
	private int value;
	private String name;
	
	public Coin() {
		this.value = 0;
		this.name = "Unnamed";
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
