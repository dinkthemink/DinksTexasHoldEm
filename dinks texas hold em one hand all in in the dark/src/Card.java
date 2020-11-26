
public class Card {
	private Rank rank;
	private Suit suit;
	private int cardRank;
	private int cardSuit;
	
	public Card(Rank rank,Suit suit) {
		this.rank = rank;
		this.suit = suit;
		
		if(rank.getRank() == "Ace") {
			this.cardRank =14;
		}else if(rank.getRank() == "King") {
			this.cardRank = 13;
		}else if(rank.getRank() == "Queen") {
			this.cardRank = 12;
		}else if(rank.getRank() == "Jack") {
			this.cardRank = 11;
		}else if(rank.getRank() == "Ten") {
			this.cardRank = 10;
		}else if(rank.getRank() == "Nine") {
			this.cardRank = 9;
		}else if(rank.getRank() == "Eight") {
			this.cardRank = 8;
		}else if(rank.getRank() == "Seven") {
			this.cardRank = 7;
		}else if(rank.getRank() == "Six") {
			this.cardRank = 6;
		}else if(rank.getRank() == "Five") {
			this.cardRank = 5;
		}else if(rank.getRank() == "Four") {
			this.cardRank = 4;
		}else if(rank.getRank() == "Three") {
			this.cardRank = 3;
		}else if(rank.getRank() == "Deuce") {
			this.cardRank = 2;
		}
		if(suit.getSuit() == "Spades") {
			this.cardSuit = 100;
		}else if(suit.getSuit() == "Hearts") {
			this.cardSuit = 200;
		}else if(suit.getSuit() == "Diamonds") {
			this.cardSuit = 300;
		}else if(suit.getSuit() == "Clubs") {
			this.cardSuit = 400;
		}
		// ENUMS LOl
	}
	
	public String getSuit() {
		return suit.getSuit();
	}
	
	public String getRank() {
		return rank.getRank();
	}
	
	public int getRankNum() {
		return cardRank;
	}
	public int getSuitNum() {
		return cardSuit;
	}
	public String toString() {
		String str = "";
		str+= rank.getRank() + " of " + suit.getSuit();
		return str;
	}
	
}
