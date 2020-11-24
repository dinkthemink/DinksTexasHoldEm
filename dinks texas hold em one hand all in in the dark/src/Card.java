
public class Card {
	private Rank rank;
	private Suit suit;
	
	public Card(Rank rank,Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	public String getSuit() {
		return suit.getSuit();
	}
	
	public String getRank() {
		return rank.getRank();
	}
	
	public String toString() {
		String str = "";
		str+= rank.getRank() + " of " + suit.getSuit();
		return str;
	}
}
