package lab13.lab14Andersen;


//--------------------------------------------------------------------
//
//  Laboratory 14                                    TestWtGraph.java
//
//  Test program for the operations in the Weighted Graph ADT
//
//--------------------------------------------------------------------
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

class TestWtGraph {

	public static void main(String args[]) throws IOException {
		WtGraph testGraph = new WtGraph(8); // Test graph
		Vertex testVertex; // Vertex
		String v1 = new String(), v2 = new String(), tint;
		char cmd; // Input command
		int wt = WtGraph.INFINITE_EDGE_WT; // Edge weight

		// -----------------------------------------------------------------
		// Initialize reader and tokenizer for the input stream -
		// for reading 'tokens' (namely vertex labels
		// & weigth values) input from the keyboard.
		//
		// Initialize reader - To read a character at a time
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// Initialize the tokenizer -
		// To read tokens (words and numbers separated by whitespace)
		StreamTokenizer tokens = new StreamTokenizer(reader);

		// Note: use the nextToken( ) method to step through a stream of tokens.
		// Use tokenizer's nval to obtain the number read.
		// Since nval is of type double, cast it to an int.
		// Use tokenizer's sval to obtain the word read.

		System.out.println();
		System.out.println("Commands:");
		System.out.println("  +v      : Insert (or update) vertex v");
		System.out.println("  =v w wt : Insert an edge with weight wt between " + "vertices v and w");
		System.out.println("  ?v      : Retrieve vertex");
		System.out.println("  #v w    : Display the weight of the edge between " + "vertices v and w");
		System.out.println("  -v      : Remove vertex v");
		System.out.println("  !v w    : Remove the edge between vertices v and w");
		System.out.println("  C       : Clear the graph");
		System.out.println("  E       : Empty graph?");
		System.out.println("  F       : Full graph?");
		System.out.println("  Q       : Quit the test program");
		System.out.println();

		do {
			// D // In-lab Exercise 1
			// D if ( testGraph.allEven( ) )
			// D {
			// D System.out.println( );
			// D System.out.println("All vertices have even degree");
			// D }
			// D else
			// D {
			// D System.out.println( );
			// D System.out.println("NOT all vertices have even degree");
			// D }

			// PC // In-lab Exercise 2
			// PC if ( testGraph.properColoring( ) )
			// PC System.out.println("Proper coloring");
			// PC else
			// PC {
			// PC System.out.println( );
			// PC System.out.println("NOT a proper coloring");
			// PC }

			// PM testGraph.computePaths( ); // In-lab Exercise 3

			testGraph.showStructure(); // Output graph

			System.out.println();
			System.out.print("Command: ");

			// Read command
			cmd = (char) reader.read();
			while (Character.isWhitespace(cmd)) // Ignore whitespace
				cmd = (char) reader.read();

			// get/read remaining command data
			if (cmd == '+' || cmd == '?' || cmd == '-') {
				tokens.nextToken();
				v1 = tokens.sval;
			} else if (cmd == '#' || cmd == '!') {
				tokens.nextToken();
				v1 = tokens.sval;
				tokens.nextToken();
				v2 = tokens.sval;
			} else if (cmd == '=') {
				tokens.nextToken();
				v1 = tokens.sval;
				tokens.nextToken();
				v2 = tokens.sval;
				tokens.nextToken();
				wt = (int) tokens.nval;
			}

			// PC if ( cmd == '+' ) // In-lab Exercise 2
			// PC {
			// PC System.out.print("Color: ");
			// PC tokens.nextToken( );
			// PC tint = tokens.sval;
			// PC }

			switch (cmd) {
			case '+': // insertVertex
				System.out.println("Insert vertex : " + v1);
				testVertex = new Vertex(v1);
				testGraph.insertVertex(testVertex);
				// PC testVertex.setColor(tint);
				break;

			case '=': // insertEdge
				System.out.println("Insert edge : " + v1 + " " + v2 + " " + wt);
				testGraph.insertEdge(v1, v2, wt);
				break;

			case '?': // retrieveVertex
				if (testGraph.retrieveVertex(v1) != null)
					System.out.println("Vertex " + v1 + " exists");
				else
					System.out.println("Vertex NOT found");
				break;

			case '#': // edgeWeight
				if ((wt = testGraph.edgeWeight(v1, v2)) != WtGraph.INFINITE_EDGE_WT)
					System.out.println("Weight = " + wt);
				else
					System.out.println("No edge between these vertices");
				break;

			case '-': // removeVertex
				System.out.println("Remove vertex " + v1);
				testGraph.removeVertex(v1);
				break;

			case '!': // removeEdge
				System.out.println("Remove the edge between vertices " + v1 + " and " + v2);
				testGraph.removeEdge(v1, v2);
				break;

			case 'C':
			case 'c': // clear
				System.out.println("Clear the graph");
				testGraph.clear();
				break;

			case 'E':
			case 'e': // empty
				if (testGraph.isEmpty())
					System.out.println("Graph is empty");
				else
					System.out.println("Graph is NOT empty");
				break;

			case 'F':
			case 'f': // full
				if (testGraph.isFull())
					System.out.println("Graph is full");
				else
					System.out.println("Graph is NOT full");
				break;

			case 'Q':
			case 'q': // Quit test program
				break;

			default: // Invalid command
				System.out.println("Invalid command");
			}
		} while (cmd != 'Q' && cmd != 'q');
	} // main

} // class TestWtGraph
