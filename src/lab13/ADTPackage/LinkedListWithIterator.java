package lab13.ADTPackage;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
   A class that implements the ADT list by using a chain of nodes.
   The list has an iterator. The class is similar to LList.
   
   @author Frank M. Carrano
   @version 3.0
*/
public class LinkedListWithIterator<T>
             implements ListWithIteratorInterface<T>
{
   private Node firstNode;
   private int  numberOfEntries;;

   public LinkedListWithIterator()
   {
      clear();
   } // end default constructor

	public final void clear() // note the final method
	{
		firstNode = null;
		numberOfEntries = 0;
	} // end clear
 
	public void add(T newEntry) 	      // OutOfMemoryError possible
	{
		Node newNode = new Node(newEntry);

		if (isEmpty())
			firstNode = newNode;
		else                              // add to end of non-empty list
		{
			Node lastNode = getNodeAt(numberOfEntries);
			lastNode.setNextNode(newNode); // make last node reference new node
		} // end if	
		
		numberOfEntries++;
	}  // end add

   public boolean add(int newPosition, T newEntry) // OutOfMemoryError possible	                                                 
	{
		boolean isSuccessful = true;

		if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) 
		{	
			Node newNode = new Node(newEntry);

			if (newPosition == 1)                // case 1
			{
				newNode.setNextNode(firstNode);							
				firstNode = newNode;
			}
			else									       // case 2: list is not empty
			{                                    // and newPosition > 1
				Node nodeBefore = getNodeAt(newPosition - 1);
				Node nodeAfter = nodeBefore.getNextNode();
				newNode.setNextNode(nodeAfter);
				nodeBefore.setNextNode(newNode);
			} // end if	
		
			numberOfEntries++;
		}
		else
			isSuccessful = false;
			
		return isSuccessful;
	} // end add

	public T remove(int givenPosition)
	{
      T result = null;                           // return value

      if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
      {
         assert !isEmpty();

         if (givenPosition == 1)                 // case 1: remove first entry
         {
            result = firstNode.getData();        // save entry to be removed 
            firstNode = firstNode.getNextNode();
         }
         else                                    // case 2: not first entry
         {
            Node nodeBefore = getNodeAt(givenPosition - 1);
            Node nodeToRemove = nodeBefore.getNextNode();
            Node nodeAfter = nodeToRemove.getNextNode();
            nodeBefore.setNextNode(nodeAfter);  
            result = nodeToRemove.getData();    // save entry to be removed
         } // end if

         numberOfEntries--;
      } // end if
  
      return result;                            // return removed entry, or 
                                                // null if operation fails
	} // end remove

	public boolean replace(int givenPosition, T newEntry)
	{
		boolean isSuccessful = true;

      if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
      {   
      	assert !isEmpty();

			Node desiredNode = getNodeAt(givenPosition);
			desiredNode.setData(newEntry);
      }    
		else
			isSuccessful = false;
			
		return isSuccessful;
   } // end replace

   public T getEntry(int givenPosition)
   {
      T result = null;  // result to return
      
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		{
			assert !isEmpty();
         result = getNodeAt(givenPosition).getData();
     	} // end if
      
      return result;
   } // end getEntry

	public boolean contains(T anEntry)
	{
		boolean found = false;
		Node currentNode = firstNode;
		
		while (!found && (currentNode != null))
		{
			if (anEntry.equals(currentNode.getData()))
				found = true;
			else
				currentNode = currentNode.getNextNode();
		} // end while
		
		return found;
	} // end contains

  public int getLength()
  {
     return numberOfEntries;
  } // end getLength

  public boolean isEmpty()
  {
      boolean result;

      if (numberOfEntries == 0) // or getLength() == 0
      {
         assert firstNode == null;
         result = true;
      }
      else
      {
         assert firstNode != null;
         result = false;
      } // end if

      return result;
  } // end isEmpty
	
   public T[] toArray()
   {
      // the cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] result = (T[])new Object[numberOfEntries];
      
      int index = 0;
      Node currentNode = firstNode;
      while ((index < numberOfEntries) && (currentNode != null))
      {
         result[index] = currentNode.getData();
         currentNode = currentNode.getNextNode();
         index++;
      } // end while
      
      return result;
   } // end toArray
   
	public Iterator<T> getIterator()
	{
	   return new IteratorForLinkedList();
	} // end getIterator

   public Iterator<T> iterator()
   {
      return getIterator();
   } // end iterator

	// Returns a reference to the node at a given position.
   // Precondition: List is not empty;
   //               1 <= givenPosition <= numberOfEntries	
	private Node getNodeAt(int givenPosition)
	{
		assert !isEmpty() && (1 <= givenPosition) && (givenPosition <= numberOfEntries);
		Node currentNode = firstNode;
		
      // traverse the list to locate the desired node
		for (int counter = 1; counter < givenPosition; counter++)
			currentNode = currentNode.getNextNode();
		
		assert currentNode != null;
      
		return currentNode;
	} // end getNodeAt

//==================================

	private class IteratorForLinkedList implements Iterator<T>
	{
      private Node nextNode;  // node containing next entry in iteration

		private IteratorForLinkedList()
		{
			nextNode = firstNode;
		} // end default constructor
		
		public boolean hasNext()
		{
			return nextNode != null;
		} // end hasNext

		public T next()
		{
			if (hasNext())
			{
				Node returnNode = nextNode; // get next node
				nextNode = nextNode.next;   // advance iterator
				
				return returnNode.data;     // return next entry in iteration
			}
			else
				throw new NoSuchElementException("Illegal call to next(); " +
		                                       "iterator is after end of list.");
		} // end next

		public void remove()
		{
			throw new UnsupportedOperationException("remove() is not " +
		                                           "supported by this iterator");
		} // end remove
	} // end IteratorForLinkedList
	
   private class Node
   {
      private T data;    // entry in bag
      private Node next; // link to next node
      
      private Node(T dataPortion)
      {
         this(dataPortion, null);
      } // end constructor
      
      private Node(T dataPortion, Node nextNode)
      {
         data = dataPortion;
         next = nextNode;
      } // end constructor
      
      private T getData()
      {
         return data;
      } // end getData
      
      private void setData(T newData)
      {
         data = newData;
      } // end setData
      
      private Node getNextNode()
      {
         return next;
      } // end getNextNode
      
      private void setNextNode(Node nextNode)
      {
         next = nextNode;
      } // end setNextNode
   } // end Node
} // end LinkedListWithIterator



