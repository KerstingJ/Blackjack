import java.util.ArrayList;

public class Player {
	public DeckOfCards deck;
	private ArrayList<Card> hand = new ArrayList<Card>();
	
	public int highAces = 0;
	public boolean blackJack = false;

	public void drawCard() {
		//adds one random Card object to hand
		//using deck.drawcard 
		hand.add(deck.drawCard());
	}

	public void firstDeal() {
		//adds 2 card object to hand
		hand.add(deck.drawCard());
		hand.add(deck.drawCard());
		
		//Checks for blackjack
		this.blackJack = this.hasBlackjack();
		if (this.blackJack) {
			System.out.println("BLACK JACK!!!!!!!");
		}
	}

	public void clearHand() {
		//clears all cards from hand
		hand.clear();
	}

	public void countAces() {
		//counts how many ace cards are in hand
		for (Card c : hand) {
			if (c.face == Faces.Ace) {
				highAces += 1;
			}
		}
	}

	public boolean hasBlackjack() {
		// looks for blackjack
		return this.handScore() == 21;
	}

	public int handScore() {
		int total = 0;

		// iterates through cards in hand, adds values
		// counts aces in hand
		for (int i = 0; i < hand.size(); i++) {
			total += hand.get(i).value;
			if (hand.get(i).face == Faces.Ace) {
				highAces += 1;
			}
		}


		// if score is over 21 adjusts for aces
		while (total > 21 && highAces > 0) {
			total = total - 10;
			highAces -= 1;
			System.out.println("Adjusted for Ace");
		}

		return total;
	}
	
	public void newHand() {
		//clears hand starts from fresh
		highAces = 0;
		hand.clear();
	}
	
	public Player(DeckOfCards deck) {
		//player constructor
		newHand();
		this.deck = deck;
	}
}
