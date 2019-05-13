import java.util.Arrays;
import java.util.Random;

public class Thing2 implements Comparable<Thing2> {
	
	private String name;
	private double cost;

	public Thing2(String name, double cost) {
		this.name = name;
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public int compareTo(Thing2 other) {
		if (cost == other.cost)
			return 0;
		else if (cost < other.cost)
			return -1;
		else
			return 1;
	}

	@Override
	public String toString() {
		return name + ": " + cost;
	}
	
	public static void main(String[] args) {
		Thing2[] things = new Thing2[6];
		Random rand = new Random();
		for (int i=0; i<things.length; i++) {
			things[i] = new Thing2("jerry", rand.nextInt(100));
		}
		
		for (Thing2 t : things) {
			System.out.println(t.toString());
		}
		
		Arrays.sort(things);
		System.out.println();
		
		for (Thing2 t : things) {
			System.out.println(t.toString());
		}
		
	}
}
