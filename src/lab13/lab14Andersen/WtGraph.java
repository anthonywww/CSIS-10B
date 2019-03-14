package lab13.lab14Andersen;

//--------------------------------------------------------------------
//
//  Laboratory 14                                        WtGraph.jshl
//
//  Class declaration for the adjacency matrix implementation of
//  the Weighted Graph ADT
//
//--------------------------------------------------------------------

public class WtGraph {
	// Default number of vertices (a constant)
	public final int DEF_MAX_GRAPH_SIZE = 10;
	// "Weight" of a missing edge (a constant) -- the max int value
	// Note: since this is declared 'static' then it can be
	// referenced elsewhere with WtGraph.INFINITE_EDGE_WT.
	// If not, it can only be referenced by a variable of type WtGraph.
	public static final int INFINITE_EDGE_WT = Integer.MAX_VALUE;

	// Data members
	private int size; // Actual number of vertices in the graph
	private Vertex[] vertexList; // Vertex list
	private int[][] adjMatrix; // Adjacency matrix (a 2D array in 1D form)

	// Constructors
	public WtGraph() {
	}

	public WtGraph(int maxNumber) {
	}

	// Class methods
	private void setUp(int maxNumber) // Called by constructors
	{
	}

	public void insertVertex(Vertex newVertex) // Insert vertex
	{
	}

	public void insertEdge(String v1, String v2, int wt) // Insert edge
	{
	}

	public Vertex retrieveVertex(String v) // Get vertex
	{
		return null;
	}

	public int edgeWeight(String v1, String v2) // Get edge wt.
	{
		return 0;
	}

	public void removeVertex(String v) // Remove vertex
	{
	}

	public void removeEdge(String v1, String v2) // Remove edge
	{
	}

	public void clear() // Clear graph
	{
	}

	public boolean isEmpty() // Is graph empty?
	{
		return false;
	}

	public boolean isFull() // Is graph full?
	{
		return false;
	}

	public void showStructure()
	// Outputs a graph's vertex list, and adjacency matrix.
	// This operation is intended for testing/debugging purposes only.
	{
		int wt, // Edge weight
				row, col; // Loop counters

		if (size == 0)
			System.out.println("Empty graph");
		else {
			System.out.println();
			System.out.println("Vertex list : ");
			for (row = 0; row < size; row++)
				System.out.println(row + "\t" + vertexList[row].getLabel());

			System.out.println();
			System.out.println("Edge matrix : ");
			System.out.print("\t");
			for (col = 0; col < size; col++)
				System.out.print(col + "\t");
			System.out.println();
			for (row = 0; row < size; row++) {
				System.out.print(row + "\t");
				for (col = 0; col < size; col++) {
					wt = getEdge(row, col);
					if (wt == INFINITE_EDGE_WT)
						System.out.print("- \t");
					else
						System.out.print(wt + "\t");
				}
				System.out.println();
			}
		}
	} // showStructure

	// --------------------------------------------------------------------
	//
	// Facilitator methods
	//

	private int index(String v) // Converts vertex label to an
								// adjacency matrix index
	{
		return 0;
	}

	private int getEdge(int row, int col)// Get edge weight using
											// adjacency matrix indices
	{
		return 0;
	}

	private void setEdge(int row, int col, int wt)// Set edge wt using
													// adjacency matrix indices
	{

	}

} // class WtGraph