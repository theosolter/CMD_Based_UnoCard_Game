

/**
 * Player class that holds information and behavior of Players in a uno game. 
 * @author Theo Solter (theosolter@brandeis.edu)
 * COSI21A: PA 1, UnoGame
 * 06/13/2020
 * 
 * 
 * Methods' running times summary:
 * 	addToHand() --> O(n)
 * 	getHand() --> O(1)
 * 	getHandSize() --> O(1)
 * 	getName() --> O(1)
 * 	getNextPlayer() --> O(1)
 * 	getPrevPlayer() --> O(1)
 * 	setNextPlayer() --> O(1)
 * 	setPrevPlayer() --> O(1)
 * 	setHand() --> O(1)
 *  removeFromHand() --> O(n)
 *  winner() --> O(1)
 *  toString() --> O(1)
 */
 


public class Player {
	private String name;//field to hold Player's name
	private Player nextPlayer = null;//field to hold next player in game
	private Player prevPlayer = null;//field to hold previous player in game
	private SinglyLinkedList<UnoCard> hand;//field to hold Player's hand of UnoCards

	/**
	 * Constructs a Player object
	 * @param name - String for Player's name
	 */
	public Player(String name) {
		this.name = name;
		this.hand = new SinglyLinkedList<UnoCard>();
	}

	/**
	 * Inserts a given UnoCard to Player's hand
	 * @param c - UnoCard being inserted
	 */
	public void addToHand(UnoCard c) {
		this.hand.regularInsert(c);
	}

	/**
	 * Removes UnoCard at give index from Player's hand
	 * @param index - position at which to be deleted UnoCard is in hand
	 */
	public void removeFromHand(int index) {
		if(this.hand.size() == 0) {
			throw new UnsupportedOperationException("Hand is empty");
		}
		this.hand.removeIndex(index);
	}

	/**
	 * gets if player is winner
	 * @return Will return true if Player has won UnoGame, false if not
	 */
	public boolean winner() {
		if (this.hand.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * gets Player at next position in uno game
	 * @return Will return next Player in game
	 */
	public Player getNextPlayer() {
		return nextPlayer;
	}

	/**
	 * Sets player at the next position from Player's object
	 * @param nextPlayer - player to be put in next position
	 */
	public void setNextPlayer(Player nextPlayer) {
		this.nextPlayer = nextPlayer;
	}

	/**
	 * gets Player at previous position in uno game
	 * @return Will return previous Player in game
	 */
	public Player getPrevPlayer() {
		return prevPlayer;
	}

	/**
	 * Sets player at the previous position from Player's object
	 * @param prevPlayer - player to be put in previous position
	 */
	public void setPrevPlayer(Player prevPlayer) {
		this.prevPlayer = prevPlayer;
	}

	/**
	 * transforms PLayer object in String
	 * @return Will return Player as a String
	 */
	public String toString() {
		return "Player [name=" + name + "]";
	}

	/**
	 * gets name of player to add in circle alphabetically
	 * @return Will return Player's name field
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * gets how many cards player has in hand
	 * @return Will return size of Player's hand
	 */
	public int getHandSize() {
		return this.hand.size();
	}

	/**
	 * gets PLayer's entire hand
	 * @return Will return Player's hand
	 */
	public SinglyLinkedList<UnoCard> getHand() {
		return this.hand;
	}

	/**
	 * allows for player's hand to be changed as a whole
	 * @param hand - hand of cards that will substitute current player's hand
	 */
	public void setHand(SinglyLinkedList<UnoCard> hand) {
		if(hand == null) {
			throw new UnsupportedOperationException("Hand value must not be null");
		}
		this.hand = hand;
	}


}