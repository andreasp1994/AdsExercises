import java.util.*;
import java.io.*;

public class ArrayQueue<E> {

    public static final int CAPACITY = 10;  // default queue capacity
    private E[] Q;                          // E array used to implement the queue  
    private int n;                          // actual capacity of queue
    private int front;                      // index for the top of queue
    private int rear;                       // rear of the queue
    private int size;                       // size of the queue
    
	
    public ArrayQueue(){this(CAPACITY);}

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity){
	n = capacity;
	Q = (E[]) new Object [n]; 
	front = rear = size = 0;
    }
    //
    // NOTE: java does not allow creation of array with parametrised type!
    //
	
	//Returns the size of the ArrayQueue
    public int size(){
		return size;
	}
	
	//Returns true of the ArrayQueue is empty, and false otherwise.
    public boolean isEmpty(){
		return size == 0;
	}
	
	//Returns the first element of the ArrayQueue
	//Throws an exception if the ArrayQueue is empty.
    public E front() throws ArrayQueueException {
		if (isEmpty()) { throw new ArrayQueueException("Underflow exception. The arrayqueue is empty!");}   
		return Q[front];
	}
	
	//Adds a new generic type element to the end of the Queue
	//Throws exception if the Queue is full.
    public void enqueue(E element) throws ArrayQueueException {
		if (size() == n){throw new ArrayQueueException("Overflow exception. The arrayqueue is full!");}
		Q[rear] = element;
		rear = (rear + 1) % n;
		size++;
	}

	//Removes the last element from the ArrayQueue
	//Throws an exception if the ArrayQueue is empty.
    public E dequeue() throws ArrayQueueException {
		if (isEmpty()) { throw new ArrayQueueException("Underflow exception. The array queue is empty!");}
		E element = Q[front];
		front = (front + 1) % n;
		size--;
		return element;
	}

    //Returns a string representation of the ArrayQueue
    public String toString(){
		String out = "[";
		if (!isEmpty()) out += Q[front].toString(); //add first element to string variable
		for (int i = 1;i<size;i++){	//skip first cause it was added above
			out = out + ',' + Q[(front + i) % n];
		}
		out += "]";
		return out;
	}    
    // NOTE: if the queue contains 1,2,3 then return "[1,2,3]"
    //       if the queue contains 1 then return "[1]"
    //       if the queue is empty return "[]"
    //
}
	
