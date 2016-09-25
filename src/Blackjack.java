import java.util.Scanner;

public class Blackjack {

	public static void main(String[] args) {
		DeckOfCards deck = new DeckOfCards();
		Player p = new Player(deck);

		Scanner game = new Scanner(System.in);
		Scanner scan = new Scanner(System.in);
		
		int newGame = 0;

		while (newGame < 1) {

			p.firstDeal();

			System.out.printf("Score is: %d\n", p.handScore());
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

			p.newHand();

			System.out.println("Do you want to play again?");
			System.out.println("0 for yes, 1 for no");
			newGame = game.nextInt();
		}

		game.close();
		scan.close();

	}

}
