package lab13.lab14Andersen;

//--------------------------------------------------------------------
//
//  Laboratory 14                                        Vertex.java
//
//  SOLUTION: Vertex class for the Weighted Graph ADT
//
//--------------------------------------------------------------------

public class Vertex {
	// Data members
	private String label; // Vertex label
	private String color; // Vertex color

	public Vertex(String name) {
		label = name;
		color = "w"; // default color is White
	}

	public String getLabel() {
		return label;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String shade) {
		color = shade;
	}

} // class Vertex
