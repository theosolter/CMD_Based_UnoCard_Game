

/**
 * PlayerCircle class that holds information about circle of players playing UnoGame 
 * @author Theo Solter (theosolter@brandeis.edu)
 * COSI21A: PA 1, UnoGame
 * 06/13/2020
 * 
 * 
 * Methods' running times summary:
 * 	addToCircle() --> O(n)
 * 	getFirstPlayer() --> O(1)
 * 	getSize() --> O(1)
 * 	removeFromCircle() --> O(n)
 *  toString() --> O(n)
 */


public class PlayerCircle {
	private Player head;//field to keep track of first player to play
	private int size;//field to keep track of how many players are in circle

	/**
	 * Inserts a given Player to PlayerCircle maintaining it in alphabetical order
	 * @param p - Player being inserted
	 */
	public void addToCircle(Player p) {
		// if circle is empty
		if (head == null) {
			this.head = p;
			this.head.setNextPlayer(p);
			this.head.setPrevPlayer(p);
			size++;
		} else {
			Player curr = this.head;
			// if Player p needs to be inserted before head
			if (curr.getName().toLowerCase().compareTo(p.getName().toLowerCase()) >= 0) {
				Player last = this.head.getPrevPlayer();
				p.setNextPlayer(this.head);
				p.setPrevPlayer(last);
				last.setNextPlayer(p);
				this.head.setPrevPlayer(p);
				this.head = p;
				size++;
			} else {

				while (curr.getNextPlayer() != this.head
						&& curr.getNextPlayer().getName().toLowerCase().compareTo(p.getName().toLowerCase()) <= 0) {
					curr = curr.getNextPlayer();
				}
				Player next = curr.getNextPlayer();
				curr.setNextPlayer(p);
				p.setPrevPlayer(curr);
				p.setNextPlayer(next);
				next.setPrevPlayer(p);
				size++;
			}
		}
	}

	/**
	 * gets first player to play in circle
	 * @return Will return field head of PlayerCircle object
	 */
	public Player getFirstPlayer() {
		return this.head;
	}

	/**
	 * gets how many players are in the circle
	 * @return Will return size of PlayerCircle object
	 */
	public int getSize() {
		return this.size;
	}

	/**
	 * transforms PLayerCircle object in String
	 * @return Will return PlayerCircle as a String
	 */
	public String toString() {
		Player curr = this.head;
		String str ="";
		if(curr == null) {
			return str;
		}
		do {
			str += (curr.getName() + ", ");
			curr = curr.getNextPlayer();
		} while (curr != this.head);

		return str;
	}

	/**
	 * Deletes given Player from circle of players. Throws error if circle is empty
	 * @param p - Player to be removed from circle
	 * @return Will return the Player being deleted from circle. Null if p is not in circle.
	 */
	public Player removeFromCircle(Player p) {
		if (this.head == null) {
			throw new IllegalArgumentException("Circle is empty");
		}

		// find player in circle
		Player curr = this.head;
		Player prev = null;
		
		// if p is the only one in circle
		if (curr == p && curr.getNextPlayer() == this.head && curr.getPrevPlayer() == this.head) {
			this.head = null;
			return curr;
		}
		
		while (curr != p && curr.getNextPlayer()!= this.head) {

			prev = curr;
			curr = curr.getNextPlayer();
		}
		if(curr != p) {
			return null;
		}
		// if p is the first player
		if (curr == this.head) {
			prev = this.head.getPrevPlayer();
			this.head = this.head.getNextPlayer();
			prev.setNextPlayer(this.head);
			this.head.setPrevPlayer(prev);
			return curr;
		}
		else {
			prev.setNextPlayer(curr.getNextPlayer());
			curr.getNextPlayer().setPrevPlayer(prev);
			return curr;
		}

	}

}
