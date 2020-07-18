
/**
 * SinglyLinkedNode class is an implementation of a node for a singly linked list data structure. 
 * @author Theo Solter (theosolter@brandeis.edu)
 * COSI21A: PA 1, UnoGame
 * 06/13/2020
 * 
 * Methods' running times summary:
 * 	getData() --> O(1)
 * 	getNext() --> O(1)
 * 	setNext() --> O(1)
 *  toString() --> O(1)
 */

public class SinglyLinkedNode<T> {

	private T data;//field to store data inside Node
	private SinglyLinkedNode<T> next;//field to store next Node
	
	/**
	 * Constructs a SinglyLinkedNode object with default next to null.
	 * @param data - data to be store inside Node
	 */
	public SinglyLinkedNode(T data) {
		this.data = data;
		this.next = null;
	}
	
	/**
	 * gets the data inside Node
	 * @return Will return data inside Node
	 */
	public T getData() {
		return this.data;
	}
	
	/**
	 * sets Node for field next to point to
	 * @param nextNode - next SinglyLinkedNode this Node will point to
	 */
	public void setNext(SinglyLinkedNode<T> nextNode) {
		this.next = nextNode;
	}
	
	/**
	 * gets the next Node
	 * @return Will return next Node
	 */
	public SinglyLinkedNode<T> getNext(){
		return this.next;
	}
	
	/**
	 * transforms Node data into String
	 * @return Will return Node data in String format
	 */
	public String toString() {
		return this.data.toString();
	}
}
