package lab13.GraphPackage;
import java.util.Iterator;

import lab13.ADTPackage.DictionaryInterface;
import lab13.ADTPackage.LinkedDictionary;
import lab13.ADTPackage.LinkedQueue;
import lab13.ADTPackage.LinkedStack;
import lab13.ADTPackage.PriorityQueue;
import lab13.ADTPackage.PriorityQueueInterface;
import lab13.ADTPackage.QueueInterface;
import lab13.ADTPackage.StackInterface;
/**
   A class that implements the ADT directed graph.
   
   @author Frank M. Carrano
   @version 3.0
*/
public class DirectedGraph<T> implements GraphInterface<T>
{
	private DictionaryInterface<T, VertexInterface<T>> vertices;
	private int edgeCount;
	
	public DirectedGraph()
	{
		vertices = new LinkedDictionary<T, VertexInterface<T>>();
		edgeCount = 0;
	} // end default constructor

	public boolean addVertex(T vertexLabel)
	{
	  VertexInterface<T> isDuplicate = vertices.add(vertexLabel, new Vertex<T>(vertexLabel));
	  return isDuplicate == null; // was add to dictionary successful?
	} // end addVertex

	public boolean addEdge(T begin, T end, double edgeWeight)
	{
	  boolean result = false;
	  
	  VertexInterface<T> beginVertex = vertices.getValue(begin);
	  VertexInterface<T> endVertex = vertices.getValue(end);
	  
	  if ( (beginVertex != null) && (endVertex != null) )
	    result = beginVertex.connect(endVertex, edgeWeight);
	    
	  if (result)
	    edgeCount++;
	    
	  return result;
	} // end addEdge

	public boolean addEdge(T begin, T end)
	{
	  return addEdge(begin, end, 0);
	} // end addEdge

	public boolean hasEdge(T begin, T end)
	{
	  boolean found = false;
	  
	  VertexInterface<T> beginVertex = vertices.getValue(begin);
	  VertexInterface<T> endVertex = vertices.getValue(end);
	  
	  if ( (beginVertex != null) && (endVertex != null) )
	  {
	    Iterator<VertexInterface<T>> neighbors = 
	                                 beginVertex.getNeighborIterator();
	    while (!found && neighbors.hasNext())
	    {
	      VertexInterface<T> nextNeighbor = neighbors.next();
	      if (endVertex.equals(nextNeighbor))
	        found = true;
	    } // end while
	  } // end if
	  
	  return found;
	} // end hasEdge

	public boolean isEmpty()
	{
	  return vertices.isEmpty();
	} // end isEmpty

	public void clear()
	{
	  vertices.clear();
	  edgeCount = 0;
	} // end clear

	public int getNumberOfVertices()
	{
	  return vertices.getSize();
	} // end getNumberOfVertices

	public int getNumberOfEdges()
	{
	  return edgeCount;
	} // end getNumberOfEdges

	protected void resetVertices()
	{
	  Iterator<VertexInterface<T>> vertexIterator = vertices.getValueIterator();
	  while (vertexIterator.hasNext())
	  {
	    VertexInterface<T> nextVertex = vertexIterator.next();
	    nextVertex.unvisit();
	    nextVertex.setCost(0);
	    nextVertex.setPredecessor(null);
	  } // end while
	} // end resetVertices

	public QueueInterface<T> getBreadthFirstTraversal(T origin)
	{
	  resetVertices();
	  QueueInterface<T> traversalOrder = new LinkedQueue<T>();
	  QueueInterface<VertexInterface<T>> vertexQueue = 
	                               new LinkedQueue<VertexInterface<T>>();
	  VertexInterface<T> originVertex = vertices.getValue(origin);
	  originVertex.visit();
	  traversalOrder.enqueue(origin);    // enqueue vertex label
	  vertexQueue.enqueue(originVertex); // enqueue vertex
	  
	  while (!vertexQueue.isEmpty())
	  {
	    VertexInterface<T> frontVertex = vertexQueue.dequeue();
	    
	    Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();
	    while (neighbors.hasNext())
	    {
	      VertexInterface<T> nextNeighbor = neighbors.next();
	      if (!nextNeighbor.isVisited())
	      {
	        nextNeighbor.visit();
	        traversalOrder.enqueue(nextNeighbor.getLabel());
	        vertexQueue.enqueue(nextNeighbor);
	      } // end if
	    } // end while
	  } // end while
	  
	  return traversalOrder;
	} // end getBreadthFirstTraversal

	public QueueInterface<T> getDepthFirstTraversal(T origin)
	{
		// assumes graph is not empty
		resetVertices();
		QueueInterface<T> traversalOrder = new LinkedQueue<T>();
		StackInterface<VertexInterface<T>> vertexStack = new LinkedStack<VertexInterface<T>>();
		
		VertexInterface<T> originVertex = vertices.getValue(origin);
		originVertex.visit();
		traversalOrder.enqueue(origin); // enqueue vertex label
		vertexStack.push(originVertex); // enqueue vertex
	
		while (!vertexStack.isEmpty())
		{
			VertexInterface<T> topVertex = vertexStack.peek();
			VertexInterface<T> nextNeighbor = topVertex.getUnvisitedNeighbor();

			if (nextNeighbor != null)
			{
				nextNeighbor.visit();
				traversalOrder.enqueue(nextNeighbor.getLabel());
				vertexStack.push(nextNeighbor);
			}
			else // all neighbors are visited
				vertexStack.pop(); 
		} // end while
			
		return traversalOrder;
	} // end getDepthFirstTraversal

	public StackInterface<T> getTopologicalOrder() 
	{
		resetVertices();

		StackInterface<T> vertexStack = new LinkedStack<T>();
		int numberOfVertices = getNumberOfVertices();
		for (int counter = 1; counter <= numberOfVertices; counter++)
		{
			VertexInterface<T> nextVertex = findTerminal();
			nextVertex.visit();
			vertexStack.push(nextVertex.getLabel());
		} // end for
		
		return vertexStack;	
	} // end getTopologicalOrder

	/** Precondition: path is an empty stack (NOT null) */
	public int getShortestPath(T begin, T end, StackInterface<T> path)
	{
	  resetVertices();
	  boolean done = false;
	  QueueInterface<VertexInterface<T>> vertexQueue = 
	                                     new LinkedQueue<VertexInterface<T>>();
	  VertexInterface<T> originVertex = vertices.getValue(begin);
	  VertexInterface<T> endVertex = vertices.getValue(end);
	  
	  originVertex.visit();
	  // Assertion: resetVertices() has executed setCost(0)
	  // and setPredecessor(null) for originVertex
	  
	  vertexQueue.enqueue(originVertex);
	  
	  while (!done && !vertexQueue.isEmpty())
	  {
	    VertexInterface<T> frontVertex = vertexQueue.dequeue();
	    
	    Iterator<VertexInterface<T>> neighbors = 
	                                 frontVertex.getNeighborIterator();
	    while (!done && neighbors.hasNext())
	    {
	      VertexInterface<T> nextNeighbor = neighbors.next();
	      
	      if (!nextNeighbor.isVisited())
	      {
	        nextNeighbor.visit();
	        nextNeighbor.setCost(1 + frontVertex.getCost());
	        nextNeighbor.setPredecessor(frontVertex);
	        vertexQueue.enqueue(nextNeighbor);
	      } // end if
	      
	      if (nextNeighbor.equals(endVertex))
	        done = true;
	    } // end while
	  } // end while
	  
	  // traversal ends; construct shortest path
	  int pathLength = (int)endVertex.getCost();
	  path.push(endVertex.getLabel());
	  
	  VertexInterface<T> vertex = endVertex;
	  while (vertex.hasPredecessor())
	  {
	    vertex = vertex.getPredecessor();
	    path.push(vertex.getLabel());
	  } // end while
	  
	  return pathLength;
	} // end getShortestPath

	/** Precondition: path is an empty stack (NOT null) */
	public double getCheapestPath(T begin, T end, StackInterface<T> path) // STUDENT EXERCISE
	{
		resetVertices();
		boolean done = false;

		// use EntryPQ instead of Vertex because multiple entries contain 
		// the same vertex but different costs - cost of path to vertex is EntryPQ's priority value
		PriorityQueueInterface<EntryPQ> priorityQueue = new PriorityQueue<EntryPQ>();
		
		VertexInterface<T> originVertex = vertices.getValue(begin);
		VertexInterface<T> endVertex = vertices.getValue(end);

		priorityQueue.add(new EntryPQ(originVertex, 0, null));
	
		while (!done && !priorityQueue.isEmpty())
		{
			EntryPQ frontEntry = priorityQueue.remove();
			VertexInterface<T> frontVertex = frontEntry.getVertex();
			
			if (!frontVertex.isVisited())
			{
				frontVertex.visit();
				frontVertex.setCost(frontEntry.getCost());
				frontVertex.setPredecessor(frontEntry.getPredecessor());
				
				if (frontVertex.equals(endVertex))
					done = true;
				else 
				{
					Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();
					Iterator<Double> edgeWeights = frontVertex.getWeightIterator();
					while (neighbors.hasNext())
					{
						VertexInterface<T> nextNeighbor = neighbors.next();
						Double weightOfEdgeToNeighbor = edgeWeights.next();
						
						if (!nextNeighbor.isVisited())
						{
							double nextCost = weightOfEdgeToNeighbor + frontVertex.getCost();
							priorityQueue.add(new EntryPQ(nextNeighbor, nextCost, frontVertex));
						} // end if
					} // end while
				} // end if
			} // end if
		} // end while

		// traversal ends, construct cheapest path
		double pathCost = endVertex.getCost();
		path.push(endVertex.getLabel());
		
		VertexInterface<T> vertex = endVertex;
		while (vertex.hasPredecessor())
		{
			vertex = vertex.getPredecessor();
			path.push(vertex.getLabel());
		} // end while

		return pathCost;
	} // end getCheapestPath

	protected VertexInterface<T> findTerminal()
	{
		boolean found = false;
		VertexInterface<T> result = null;

		Iterator<VertexInterface<T>> vertexIterator = vertices.getValueIterator();

		while (!found && vertexIterator.hasNext())
		{
			VertexInterface<T> nextVertex = vertexIterator.next();
			
			// if nextVertex is unvisited AND has only visited neighbors)			
			if (!nextVertex.isVisited())
			{ 
				if (nextVertex.getUnvisitedNeighbor() == null )
				{ 
					found = true;
					result = nextVertex;
				} // end if
			} // end if
		} // end while

		return result;
	} // end findTerminal

	// Used for testing
	public void display()
	{
		System.out.println("Graph has " + getNumberOfVertices() + " vertices and " +
		                                  getNumberOfEdges() + " edges.");
		
		System.out.println("\nEdges exist from the first vertex in each line to the other vertices in the line.");
		System.out.println("(Edge weights are given; weights are zero for unweighted graphs):\n");
		Iterator<VertexInterface<T>> vertexIterator = vertices.getValueIterator();
		while (vertexIterator.hasNext())
		{
			((Vertex<T>)(vertexIterator.next())).display();
		} // end while
	} // end display 
	
	private class EntryPQ implements Comparable<EntryPQ>
	{
		private VertexInterface<T> vertex; 	
		private VertexInterface<T> previousVertex; 
		private double cost; // cost to nextVertex
		
		private EntryPQ(VertexInterface<T> vertex, double cost, VertexInterface<T> previousVertex)
		{
			this.vertex = vertex;
			this.previousVertex = previousVertex;
			this.cost = cost;
		} // end constructor
		
		public VertexInterface<T> getVertex()
		{
			return vertex;
		} // end getVertex
		
		public VertexInterface<T> getPredecessor()
		{
			return previousVertex;
		} // end getPredecessor

		public double getCost()
		{
			return cost;
		} // end getCost
		
		public int compareTo(EntryPQ otherEntry)
		{
			// using opposite of reality since our priority queue uses a maxHeap;
			// could revise using a minheap
			return (int)Math.signum(otherEntry.cost - cost);
		} // end compareTo
		
		public String toString()
		{
			return vertex.toString() + " " + cost;
		} // end toString 
	} // end EntryPQ
} // end DirectedGraph