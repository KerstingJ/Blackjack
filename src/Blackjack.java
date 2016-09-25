import java.util.Scanner;

public class Blackjack {

	public static void main(String[] args) {
		// setup deck and player
		DeckOfCards deck = new DeckOfCards();
		Player p = new Player(deck);
		Player dealer = new Player(deck, true);

		// setup scanners
		Scanner game = new Scanner(System.in);
		Scanner scan = new Scanner(System.in);

		// newGame response
		int newGame = 0;

		while (newGame < 1) {

			p.firstDeal();
			dealer.firstDeal();

			if (p.blackJack && dealer.blackJack) {
				System.out.println("TWO BLACK JACKS!!!!\nDRAW!");
				continue;
			} else if (p.blackJack) {
				System.out.println("You Win!");
				continue;
			} else if (dealer.blackJack) {
				System.out.println("Dealer Wins!");
				continue;
			}

			System.out.println("My hand is:");
			for (Card c : p.hand) {
				System.out.println(c);
			}
			System.out.printf("Score is: %d\n", p.handScore());

			System.out.println("\n");
			dealer.dealer_showing();

			int response = 0;

			while (response < 1 && p.blackJack == false) {

				if (p.handScore() > 21) {
					System.out.println("Sorry, Bust");
					break;
				}

				System.out.println("Do you want to hit or stay?");
				System.out.println("0 for hit, 1 for stay");
				response = scan.nextInt();

				if (response == 0) {
					p.drawCard();
				}

				System.out.println("Hand score: " + p.handScore());
			}

			while (dealer.handScore() < 17) {
				if (p.bust == true) {
					break;
				}

				dealer.drawCard();
			}

			if (p.bust == true) {
				System.out.println("You Bust, Dealer Wins");
			} else if (dealer.bust == true) {
				System.out.println("Dealer Bust, You Win!");
			} else if (dealer.handScore() > p.handScore()) {
				System.out.printf("Dealer Wins, %d vs %d\n", dealer.handScore(), p.handScore());
			} else {
				System.out.printf("You Win! %d vs %d\n", p.handScore(), dealer.handScore());
			}

			p.newHand();
			dealer.newHand();

			System.out.println("Do you want to play again?");
			System.out.println("0 for yes, 1 for no");
			newGame = game.nextInt();
		}

		game.close();
		scan.close();

	}

}
