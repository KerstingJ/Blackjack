import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeckOfCards {
	public List<Card> cards = new ArrayList<Card>();

	public DeckOfCards() {
		newDeck();
	}

	public void newDeck() {
		cards.clear();

		for (Suites suite : Suites.values()) {
			for (Faces face : Faces.values()) {
				Card card = new Card(suite, face);
				cards.add(card);
			}
		}

	}

	public Card drawCard() {
		Random rn = new Random();
		int card = Math.abs(rn.nextInt() % (cards.size()));
		// System.out.println("Length of deck: " + cards.size());
		// System.out.println("Index of drawn card: " + card);
		Card drawn = cards.remove(card);
		System.out.println("Just drew " + drawn);
		return drawn;
	}
}
