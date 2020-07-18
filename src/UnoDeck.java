/* 
 * Theo Solter (theosolter@brandeis.edu)
 * COSI21A: PA 1, UnoGame
 * 06/13/2020
 * 
 * 
 * Class for the Uno Deck 
 */

/*
 * 
 * Methods' running times summary:
 * 	discardCard() --> O(n)
 * 	drawCard() --> O(n)
 * 	getLastdiscarded() --> O(1)
 *  toString() --> O(n)
 *  getDeck() --> O(1)
 */

import java.util.*;
public class UnoDeck {
	private static final String[] REGULAR_COLORS = {"red", "yellow", "blue", "green"};
	//uncomment once you make your deck, then add all the cards in the constructor to your deck
	private SinglyLinkedList<UnoCard> deck; // initialize this in your constructor
	private SinglyLinkedList<UnoCard> discard; // initialize this in your constructor
	private UnoCard lastDiscarded;//field to hold last discarded card
	
	//http://play-k.kaserver5.org/Uno.html
	// There are 108 cards in a Uno deck. 
	// There are four suits, Red, Green, Yellow and Blue, 
	// each consisting of one 0 card, two 1 cards, two 2s, 3s, 4s, 5s, 6s, 7s, 8s and 9s; 
	// two Draw Two cards; two Skip cards; and two Reverse cards. 
	// In addition there are four Wild cards and four Wild Draw Four cards.

	public UnoDeck(){
		// Initialized as having all 108 cards, as described above
		this.deck = new SinglyLinkedList<UnoCard>();
		this.discard = new SinglyLinkedList<UnoCard>();
		
		for (String color : REGULAR_COLORS){
			deck.randomInsert(new UnoCard(color, 0)); // add one of your color in zero
			for (int i = 0; i<2; i++){
				// add numbers 1-9
				for (int cardNumber = 1; cardNumber<=9; cardNumber++){
					deck.randomInsert(new UnoCard(color, cardNumber)); // Add this to deck
				}
				// add 2 of each of the special card for that color
				deck.randomInsert(new UnoCard(color, true, false, false)); // add to deck
				deck.randomInsert(new UnoCard(color, false, true, false)); // add to deck
				deck.randomInsert(new UnoCard(color, false, false, true)); // add to deck
			}
			
		}
		// add 4 wild cards, and 4 draw 4 wild cards
		for (int i = 0; i<4; i++){
			deck.randomInsert(new UnoCard(false)); // add to deck
			deck.randomInsert(new UnoCard(true)); // add to deck
		}
	}
	
	/**
	 * gets the last card put in discard pile
	 * @return Will return last discarded UnoCard
	 */
	public UnoCard getLastDiscarded() {
		return this.lastDiscarded;
	}
	
	/**
	 * Draws one UnoCard from deck and removes it from deck
	 * @return Will return the drawn UnoCard
	 */
	public UnoCard drawCard() {
		if(this.deck.size() == 0) {
			this.deck = this.discard;
			this.discard = new SinglyLinkedList<UnoCard>();
		}
		UnoCard draw = this.deck.lastNode().getData();
		this.deck.remove(draw);
		return draw;
	}
	
	/**
	 * Adds UnoCard to the discard pile and sets it as last discarded card. Throws error if invalid UnoCard is discarded
	 * @param c - UnoCard being discarded
	 */
	public void discardCard(UnoCard c) {
		if(this.discard.size() >= 108) {
			throw new UnsupportedOperationException("New cards other than the original 108 Uno Cards cannot be added to game");
		}
		if(this.discard.size() == 0) {
			this.discard.randomInsert(c);
			this.lastDiscarded = c;
			return;
		}
		if(!c.canBePlacedOn(this.lastDiscarded)) {
			throw new UnsupportedOperationException("Invalid card placed on deck");
		}
		this.discard.randomInsert(c);
		this.lastDiscarded = c;
	}
	
	/**
	 * Transforms UnoDeck into a String
	 * @return Will return deck in String format
	 */
	public String toString() {
		int counter = 0;
		SinglyLinkedNode<UnoCard> curr = this.deck.head;
		String str = "";
		while(curr!=null) {
			str += ("("+counter+") "+curr.getData()+" |");
			curr = curr.getNext();
			counter ++;
		}
		return str;
	}

	/**
	 * Gets deck field
	 * @return Will return field deck in UnoDeck object
	 */
	public SinglyLinkedList<UnoCard> getDeck(){
		return this.deck;
	}

}