package assignment3;

import java.util.Vector;
/**
 * Implements a Queue using a Vector
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VQueue<E>
{
    // declare a Vector<E> queue here to hold the data in the VQueue
    
    
    public VQueue(){}

    public void enqueue(E value){}
    // post: the value is added to the tail of the structure
    
    public E dequeue(){return null;}
    // pre: the queue is not empty
    // post: the head of the queue is removed and returned
    
    public E getFront(){return null;}
    // pre: the queue is not empty
    // post: the element at the head of the queue is returned
    
    public boolean isEmpty(){return true;}
    // post: returns true if and only if the queue is empty
    
    public int size(){return 0;}
    // post: returns the number of elements in the queue
    public String toString(){return "";}

}