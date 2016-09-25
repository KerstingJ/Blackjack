
public class Card {
	public Suites suite;
	public Faces face;
	public int value;
	
	public String toString() {
		return String.format("%s of %s", face, suite);
	}

	public Card(Suites s, Faces f) {
		suite = s;
		face = f;

		switch (face) {
			case Ace:
				value = 11;
				break;
			case Eight:
				value = 8;
				break;
			case Five:
				value = 5;
				break;
			case Four:
				value = 4;
				break;
			case Jack:
				value = 10;
				break;
			case King:
				value = 10;
				break;
			case Nine:
				value = 9;
				break;
			case Queen:
				value = 10;
				break;
			case Seven:
				value = 7;
				break;
			case Six:
				value = 6;
				break;
			case Ten:
				value = 10;
				break;
			case Three:
				value = 3;
				break;
			case Two:
				value = 2;
				break;
			default:
				break;

		}
	}

}
