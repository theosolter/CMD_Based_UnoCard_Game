import java.util.Random;

/**
 * SinglyLinkedList class is an implementation of a singly linked list data structure. 
 * @author Theo Solter (theosolter@brandeis.edu)
 * COSI21A: PA 1, UnoGame
 * 06/13/2020
 * 
 * Methods' running times summary:
 * 	getHead() --> O(1)
 * 	lastNode() --> O(n)
 * 	randomInsert() --> O(n)
 * 	regularInsert() --> O(n)
 * 	remove() --> O(n)
 *  removeIndex() --> O(n)
 *  size() --> O(1)
 *  toString() --> O(n)
 */


public class SinglyLinkedList<T> {
	SinglyLinkedNode<T> head;//field to point to Linked list head node
	int size;//field to keep track of linked list size

	/**
	 * Constructs a SinglyLinkedList object with default size 0.
	 */
	public SinglyLinkedList() {
		this.size = 0;
	}

	/**
	 * gets the head element of linked list
	 * @return Will return element to which the head pointer points
	 */
	public SinglyLinkedNode<T> getHead() {
		return this.head;
	}

	/**
	 * Inserts node with a given element at the end of linked list
	 * @param data - element being inserted
	 */
	public void regularInsert(T data) {
		if(data == null) {
			throw new IllegalArgumentException("Data must not be null");
		}
		SinglyLinkedNode<T> newNode = new SinglyLinkedNode<T>(data);
		newNode.setNext(null);

		// if list is empty, make new node the head
		if (this.head == null) {
			this.head = newNode;
		}
		// else go through the list until the end and insert newNode as the last node
		else {
			SinglyLinkedNode<T> end = this.head;
			while (end.getNext() != null) {
				end = end.getNext();
			}

			end.setNext(newNode);
		}
		this.size += 1;
	}

	/**
	 * Inserts node with a given element at a random position in the linked list
	 * @param data - element being inserted
	 */
	public void randomInsert(T data) {
		if(data == null) {
			throw new IllegalArgumentException("Data must not be null");
		}
		SinglyLinkedNode<T> newNode = new SinglyLinkedNode<T>(data);
		Random rand = new Random();
		if (this.size == 0) {
			newNode.setNext(this.head);
			this.head = newNode;
			this.size++;
			return;
		}
		int nodePosition = rand.nextInt(this.size);
		if (nodePosition == 0) {
			newNode.setNext(this.head);
			this.head = newNode;
		} else if (nodePosition == this.size) {
			this.regularInsert(data);
		} else {
			int counter = 0;
			SinglyLinkedNode<T> target = this.head;
			while (counter != nodePosition - 1) {
				target = target.getNext();
				counter += 1;
			}
			newNode.setNext(target.getNext());
			target.setNext(newNode);
		}

		this.size += 1;
	}

	/**
	 * Deletes node with a given element from the linked list
	 * @param data - element to be removed
	 * @return Will return the element being deleted from linked list. Null if linked list is empty or element does not exist
	 */
	public T remove(T data) {

		// keeps track of current node
		SinglyLinkedNode<T> curr = this.head;
		// keeps track of previous node
		SinglyLinkedNode<T> prev = null;
		// saves what element is getting removed
		T deletedElement;
		// if list is empty
		if (curr == null) {
			return null;
		}
		// if first node has data
		if (curr.getData() == data) {
			deletedElement = this.head.getData();
			this.head = curr.getNext();
			this.size -= 1;
			return deletedElement;
		}
		// traverses list
		while (curr != null && curr.getData() != data) {
			prev = curr;
			curr = curr.getNext();
		}
		// if node with data was not found
		if (curr == null) {
			return null;
		}
		deletedElement = curr.getData();
		// delete node with data
		prev.setNext(curr.getNext());
		this.size -= 1;
		return deletedElement;
	}

	/**
	 * gets how many elements linked list has
	 * @return Will return size of linked list
	 */
	public int size() {
		return this.size;
	}

	/**
	 * transforms SinglyLinkedList object in String
	 * @return Will return SinglyLinkedList as a String
	 */
	public String toString() {
		int counter = 0;
		// keeps track of current node
		SinglyLinkedNode<T> curr = this.head;
		String str = "";
		while (curr != null) {
			str += ("(" + counter + ") " + curr.getData() + " |");
			curr = curr.getNext();
			counter++;
		}
		return str;
	}

	/**
	 * gets last node in linked list
	 * @return Will return last node in linked list. Returns null if list is empty
	 */
	public SinglyLinkedNode<T> lastNode() {
		SinglyLinkedNode<T> end = this.head;
		if(end == null) {
			return null;
		}
		while (end.getNext() != null) {
			end = end.getNext();
		}
		return end;
	}

	/**
	 * Deletes node at a certain position("index") the linked list
	 * @param index - position of element to be removed
	 * @return Will return the element being deleted from linked list. Null if index is bigger than list size or list is empty
	 */
	public T removeIndex(int index) {
		int counter = 0;
		// keeps track of current node
		SinglyLinkedNode<T> curr = this.head;
		// keeps track of previous node
		SinglyLinkedNode<T> prev = null;
		// saves what element is getting removed
		T deletedElement;
		//if index is bigger than list size
		if(index>this.size) {
			return null;
		}
		// if list is empty
		if (curr == null) {
			return null;
		}
		// if first node has data
		if (index == 0) {
			deletedElement = this.head.getData();
			this.head = curr.getNext();
			this.size -= 1;
			return deletedElement;
		}
		// traverses list
		while (counter != index) {
			prev = curr;
			curr = curr.getNext();
			counter += 1;
		}
		deletedElement = curr.getData();
		// delete node on index
		prev.setNext(curr.getNext());
		this.size -= 1;
		return deletedElement;
	}
}
