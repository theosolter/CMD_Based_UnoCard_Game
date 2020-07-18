import java.util.Arrays;

/**
 * Queue class is an array implementation of a queue. 
 * @author Theo Solter (theosolter@brandeis.edu)
 * COSI21A: PA 1, UnoGame
 * 06/13/2020
 * 
 * Methods' running times summary:
 * 	dequeue() --> O(n)
 * 	enqueue() --> O(1)
 * 	getFront() --> O(1)
 * 	getSize() --> O(1)
 * 	isEmpty() --> O(1)
 *  isFull() --> O(1)
 */


public class Queue<T> {
	private int front;//field to store index of front element
	private int back;//field to store index of rear element
	private int capacity;//field to store the maximum capacity of Queue
	private T[] queue;//field to store underlying array in Queue object
	private boolean isEmpty;//field to store if queue is empty
	private boolean isFull;//field to store if queue is full
	
	/**
	 * Constructs a Queue object with given capacity. Throws XXXXX exception if given capacity is less than 1
	 * @param size - The capacity of Queue object
	 */
	public Queue(int size) {
		if(size < 1) {
			throw new IllegalArgumentException("Size needs to be 1 or bigger");
		}
		this.capacity = size;
		this.front = 0;
		this.back = 0;
		this.queue = (T[]) new Object[this.capacity];
		this.isEmpty = true;
		this.isFull = false;
	}
	
	/**
	 * Inserts an element at the back of Queue object
	 * @param data - element being inserted
	 */
	public void enqueue(T data) {
		if(this.isFull) {
			throw new UnsupportedOperationException("Queue is full");
		}
		else {
			queue[this.back] = data;
			this.back++;
		}
		this.isFull = (this.capacity == this.back);
		this.isEmpty = (this.front == this.back);
	}
	
	/**s
	 * Deletes an element from the front of Queue object shifting previous element to the front
	 * @return Will return the element being deleted from Queue object. Null if queue is empty
	 */
	public T dequeue() {
		if(this.isEmpty) {
			throw new UnsupportedOperationException("Queue is empty");
		}
		else {
			T dequeued = queue[this.front];
			int i = 0;
			while(i<this.back-1) {
				queue[i] = queue[i + 1];
				i++;
			}
			//transforms previous instance of dequeued item in null
			if(this.back <= this.capacity) {
				queue[this.back-1] = null;
			}
			this.back--;
		
			this.isEmpty = (this.front == this.back);
			this.isFull = (this.capacity == this.back);
			return dequeued;
		}
	}
	
	/**
	 * gets current size of queue
	 * @return Will return int size
	 */
	public int getSize() {
		return this.back;
	}
	
	/**
	 * checks if queue is empty
	 * @return Will return true if empty, false if not
	 */
	public boolean isEmpty() {
		return this.isEmpty;
	}
	
	/**
	 * checks if queue is full
	 * @return Will return true if full, false if not
	 */
	public boolean isFull() {
		return this.isFull;
	}
	
	/**
	 * gets the element in front of queue
	 * @return Will return element in the front position of Queue object
	 */
	public T getFront() {
		if(this.getSize() == 0) {
			return null;
		}
		return this.queue[this.front];
	}
	
}
