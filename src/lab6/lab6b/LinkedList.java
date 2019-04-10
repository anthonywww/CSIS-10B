package lab6.lab6b;

/**
   A linked implementation of the ADT list.
   
   @author Frank M. Carrano
   @version 3.0
*/
public class LinkedList<T> 
{
    private Node firstNode; // reference to first node
    private int  mySize; 

    public LinkedList()
    {
        firstNode = null;
        mySize = 0;
    } // end default constructor

    public boolean isEmpty()
    {
      boolean result;

      if (mySize == 0) // or getLength() == 0
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
    
    public void add(T newEntry)           // OutOfMemoryError possible
    {
 
    }  // end add

   public boolean add(int newPosition, T newEntry) // OutOfMemoryError possible                                                  
    {
        return false;
    } // end add

    public T remove(int givenPosition)
    {
        return null;                        // return removed entry, or 
                                                // null if operation fails
    } // end remove

    public final void clear() // note the final method
    {
        firstNode = null;
        mySize = 0;
    } // end clear
 

    public boolean replace(int givenPosition, T newEntry)
    {
        return false;
    } // end replace

   public T getEntry(int givenPosition)
   {
       return null;
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
     return mySize;
  } // end getLength

    
   public T[] toArray()
   {
      // the cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] result = (T[])new Object[mySize];
      
      int index = 0;
      Node currentNode = firstNode;
      while ((index < mySize) && (currentNode != null))
      {
         result[index] = currentNode.getData();
         currentNode = currentNode.getNextNode();
         index++;
      } // end while
      
      return result;
   } // end toArray
   
   public String toString()
   {
       String result = "[";
       Node currentNode = firstNode;
       if (currentNode == null)
          result = "[]";
       while (currentNode != null)
       {
            if (currentNode.getNextNode() == null)
                result += currentNode.getData() + "]";
            else
                result += currentNode.getData() + ", ";
            currentNode = currentNode.getNextNode();    
       }
       return result;
   }

   

    private class Node 
    {
      private T    data; // entry in list
      private Node next; // link to next node

      private Node(T dataPortion)
      {
         data = dataPortion;
         next = null;   
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
} // end LList



