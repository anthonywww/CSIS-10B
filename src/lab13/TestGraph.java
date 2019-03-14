package lab13;

import lab13.ADTPackage.LinkedStack;
import lab13.ADTPackage.StackInterface;
import lab13.GraphPackage.DirectedGraph;

/**
 * Write a description of class TestGraph here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestGraph {
	
	public static void main(String[] args) {
		DirectedGraph<String> dg = new DirectedGraph<String>();
		StackInterface<String> myPath = new LinkedStack<String>();
		dg.addVertex("LA");
		dg.addVertex("SF");
		dg.addVertex("Denver");
		dg.addVertex("Monterey");
		dg.addEdge("Denver", "SF", 200);
		dg.addEdge("Denver", "LA", 400);
		dg.addEdge("SF", "LA", 350);
		dg.addEdge("LA", "SF", 350);
		dg.addEdge("SF", "Monterey", 120);
		dg.addEdge("LA", "Montery", 230);
		System.out.println("\fshortest hops from Denver to Monterey is " + dg.getShortestPath("Denver", "Monterey", myPath));
		while (!myPath.isEmpty()) {
			myPath.pop();
		}
		System.out.println("cheapest flight from Denver to Monterey is " + dg.getCheapestPath("Denver", "Monterey", myPath));
		System.out.println("and the path is ");
		while (!myPath.isEmpty()) {
			System.out.println(myPath.pop());
		}
		
	}
	
}
