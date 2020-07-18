import java.util.*;

/**
 * UnoGame class that holds the client code and runs the Uno game. 
 * @author Theo Solter
 * COSI21A: PA 1, UnoGame
 * 06/13/2020
 */

public class UnoGame {

	private static final int AMOUNT_DRAW_START = 7;//global variable for number of cards distributed to players

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int numPlayers = getNumPlayers();

		PlayerCircle circle = new PlayerCircle();
		Queue<Player> queue = new Queue<Player>(numPlayers);

		gameSetup(circle, queue, numPlayers);
		boolean playAgain = true;
		while (playAgain) {
			run(circle, queue);
			System.out.println("Everyone in the game has already played. Would you like to repeat the game? (Yes/ (Anything other than Yes for No)");
			String again = input.next();
			if (again.toLowerCase().equals("yes")) {
				playAgain = true;
			} else {
				playAgain = false;
			}
			System.out.println("");
			System.out.println("Game is over!");
		}

	}

	/**
	 * Runs a short program that get the number of players expected in the game
	 * @return int representing number of players
	 */
	public static int getNumPlayers() {

		System.out.println("Hello!");
		System.out.println("Let's play Uno!");
		Scanner input = new Scanner(System.in);
		boolean waitingForValidIn = true;
		int numPlayers = 0;
		do {
			System.out.println("How many people would like to play Uno:");
			try {
				numPlayers = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.print("Non-integer values are not allowed.");
				input.nextLine();
			}
			if (numPlayers >= 2) {
				waitingForValidIn = false;
			} else {
				System.out.println("Number of players entered must be a nonnegative number bigger than 1.");
			}
		} while (waitingForValidIn);
		waitingForValidIn = true;
		return numPlayers;
	}

	/**
	 * Runs a short program that sets up the UnoGame placing first 5 players in game and rest in a queue (all in alphabetical order) 
	 * @param circle (circle of players), queue (queue of players waiting of play), numPlayers (number of players in total) 
	 */
	public static void gameSetup(PlayerCircle circle, Queue<Player> queue, int numPlayers) {
		Scanner input = new Scanner(System.in);
		boolean waitingForValidIn = true;
		System.out.println("Please enter the names of the people playing:");
		if (numPlayers <= 5) {
			for (int i = 0; i < numPlayers; i++) {
				do {
					try {
						String name = input.next();
						Player player = new Player(name);
						circle.addToCircle(player);
						waitingForValidIn = false;
					} catch (InputMismatchException e) {
						System.out.print("Non-String values are not allowed.");
						input.nextLine();
					}
				} while (waitingForValidIn);
				waitingForValidIn = true;
			}
		} else {
			for (int i = 0; i < 5; i++) {
				do {
					try {
						String name = input.next();
						Player player = new Player(name);
						circle.addToCircle(player);
						waitingForValidIn = false;
					} catch (InputMismatchException e) {
						System.out.print("Non-String values are not allowed.");
						input.nextLine();
					}
				} while (waitingForValidIn);
				waitingForValidIn = true;
			}
			for (int j = 5; j < numPlayers; j++) {
				do {
					try {
						String name = input.next();
						Player player = new Player(name);
						queue.enqueue(player);
						waitingForValidIn = false;
					} catch (InputMismatchException e) {
						System.out.print("Non-String values are not allowed.");
						input.nextLine();
					}
				} while (waitingForValidIn);
				waitingForValidIn = true;
			}
		}

	}

	/**
	 * Runs a program that runs the Uno Game with all its logic
	 * @return Player object with loser of game
	 */
	public static Player runGame(PlayerCircle circle, Queue<Player> queue, UnoDeck deck) {

		Scanner input = new Scanner(System.in);

		int round = 0;
		Player curr = circle.getFirstPlayer();
		boolean reversed = false;

		while (true) {

			System.out.println("");

			if (curr == circle.getFirstPlayer()) {
				round++;
			}

			if (deck.getLastDiscarded().isDrawTwo() || deck.getLastDiscarded().isWildDrawFour()) {
				if (deck.getLastDiscarded().isDrawTwo()) {
					for (int i = 0; i < 2; i++) {
						curr.addToHand(deck.drawCard());
					}
				} else {
					for (int i = 0; i < 4; i++) {
						curr.addToHand(deck.drawCard());
					}
				}
			}

			System.out.println("It is " + curr.getName() + "'s turn");
			System.out.print(curr.getName() + "'s Hand: ");
			System.out.println(curr.getHand().toString());
			System.out.println("TOPCARD: " + deck.getLastDiscarded());

			SinglyLinkedList<UnoCard> allowedCards = new SinglyLinkedList<UnoCard>();
			SinglyLinkedNode<UnoCard> currCard = curr.getHand().getHead();
			while (currCard != null) {
				if (currCard.getData().canBePlacedOn(deck.getLastDiscarded())) {
					allowedCards.regularInsert(currCard.getData());
				}
				currCard = currCard.getNext();
			}
			if (allowedCards.size() == 0) {
				curr.addToHand(deck.drawCard());
				System.out.println(curr.getName() + " cannot play any cards.");
				System.out.println(curr.getName() + " drawed one card from the deck and is being skipped.");
				if (reversed) {
					curr = curr.getPrevPlayer();
				} else {
					curr = curr.getNextPlayer();
				}
			} else {
				System.out.print(curr.getName() + " can play the following card(s): ");
				System.out.println(allowedCards.toString());
				boolean waitingForValidIn = true;
				do {
					try {
						try {
							System.out.println("Choose which card (number) " + curr.getName() + " would like to play:");
							int selectedCardIndex = input.nextInt();
							UnoCard selectedCard = allowedCards.removeIndex(selectedCardIndex);
							deck.discardCard(curr.getHand().remove(selectedCard));
							
						} catch (InputMismatchException e) {
							System.out.print("Non-Integer values are not allowed.");
							System.out.print("Please choose again.");
							System.out.print("");
							input.nextLine();
						}
						waitingForValidIn = false;
					} catch (NullPointerException e) {
						System.out.println("Please choose one of the cards (numbers) you are allowed to play.");
						input.nextLine();
					}
				} while (waitingForValidIn);

				if (curr.winner()) {
					System.out.println("");
					System.out.println(curr.getName() + " is the winner!");
					System.out.println("The game went around the circle " + round + " times.");
					Player winner = curr;
					curr = curr.getNextPlayer();
					Player loser = curr;
					while (curr.getNextPlayer() != winner) {
						if (curr.getHandSize() > loser.getHandSize()) {
							loser = curr;
						}
						curr = curr.getNextPlayer();
					}
					System.out.println(loser.getName() + " is the loser :(");
					System.out.println("There are " + queue.getSize() + " players in the queue.");
					if (queue.getSize() == 0) {
						return loser;
					} else {
						System.out.println(
								loser.getName() + " is being removed from the circle and placed in the queue.");

						// reset players hands
						Player currReset = circle.getFirstPlayer();
						while (currReset.getNextPlayer() != circle.getFirstPlayer()) {
							currReset.setHand(new SinglyLinkedList<UnoCard>());
							currReset = currReset.getNextPlayer();
						}

						

						return loser;
					}
				}

				if (deck.getLastDiscarded().isReverse()) {
					if(reversed) {
						reversed = false;
					}else {
					reversed = true;
					}
					System.out.println("");
					System.out.println("Direction is switched!");
				}

				if (deck.getLastDiscarded().isSkip()) {
					if (reversed) {
						System.out.println(curr.getPrevPlayer().getName() + " has been skipped!");
						curr = curr.getPrevPlayer().getPrevPlayer();
					} else {
						System.out.println(curr.getNextPlayer().getName() + " has been skipped!");
						curr = curr.getNextPlayer().getNextPlayer();
					}
				}

				else {

					if (reversed) {
						curr = curr.getPrevPlayer();
					} else {
						curr = curr.getNextPlayer();
					}
				}
			}

		}
	}

	/**
	 * Runs a short program that distributes the cards of the Uno Game among the players 
	 * @param circle (circle of players), deck (initial deck of UnoCards) 
	 */
	public static void distributeCards(PlayerCircle circle, UnoDeck deck) {

		System.out.println("----------------------------------------------------");
		System.out.println("			NEW GAME");
		System.out.println("----------------------------------------------------");

		Player p = circle.getFirstPlayer();
		while (p.getHandSize() != AMOUNT_DRAW_START) {
			p.addToHand(deck.drawCard());
		}
		System.out.print(p.getName() + "'s Hand: ");
		System.out.println(p.getHand().toString());
		while (p.getNextPlayer() != circle.getFirstPlayer()) {
			p = p.getNextPlayer();
			while (p.getHandSize() != AMOUNT_DRAW_START) {
				p.addToHand(deck.drawCard());
			}
			System.out.print(p.getName() + "'s Hand: ");
			System.out.println(p.getHand().toString());
		}
		System.out.println("");

		deck.discardCard(deck.drawCard());
		System.out.println("TOPCARD: " + deck.getLastDiscarded());
	}

	/**
	 * Runs a short program that runs the UnoGame repeatedly until all players play (including the ones in the queue)
	 * @param circle (circle of players initially playing), queue (initial players waiting to play Uno) 
	 */
	public static void run(PlayerCircle circle, Queue<Player> queue) {
		UnoDeck deck = new UnoDeck();
		distributeCards(circle, deck);
		Player firstLoser = runGame(circle, queue, deck);
		queue.enqueue(circle.removeFromCircle(firstLoser));
		Player dequeued = queue.dequeue();
		System.out.println(
				dequeued.getName() + " is being removed from the queue and placed into the game.");
		circle.addToCircle(dequeued);
		if(queue.getSize() == 1 && queue.getFront() == firstLoser) {
			deck = new UnoDeck();
			distributeCards(circle, deck);
			runGame(circle,queue,deck);
			queue.enqueue(circle.removeFromCircle(firstLoser));
			dequeued = queue.dequeue();
			System.out.println(
					dequeued.getName() + " is being removed from the queue and placed into the game.");
			circle.addToCircle(dequeued);
		}else {
			if(queue.getSize() == 0) {
				return;
			}
			do{
			deck = new UnoDeck();
			distributeCards(circle, deck);
			runGame(circle, queue, deck);
			queue.enqueue(circle.removeFromCircle(firstLoser));
			dequeued = queue.dequeue();
			System.out.println(
					dequeued.getName() + " is being removed from the queue and placed into the game.");
			circle.addToCircle(dequeued);
		}while (dequeued != firstLoser && queue.getSize() != 0);
		}
	}
}
