import java.util.ArrayList;

public class Players {
	
	private ArrayList<Card> cards;
	private String name;
	private Card[] playerSortedCards;
	private Card kickerCard;
	private int value;
	
	public Players(String name) {
		this.value = 0;
		this.name = name;
		cards = new ArrayList<Card>();
		playerSortedCards = new Card[7];
		this.kickerCard = null;
		System.out.println("Player " + name + " joined the game!");
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int val) {
		this.value = val;
	}
	
	public void addCard(Card card) {
		cards.add(card);
				
	}
	
	public void addCardToArray(int index,Card c) {
		playerSortedCards[index] = c;
	}
	
	public ArrayList<Card> getCards() {
		return cards;
	}
	public Card[] getPlayerSortedCards() {
		return playerSortedCards;
	}
	public void setKickerCard(Card c) {
		kickerCard = c;
	}
	public Card getKickerCard() {
		return kickerCard;
	}
	
	public void addPlayerTestCards() {
		
		playerSortedCards[0] = new Card(Rank.DEUCE,Suit.DIAMONDS);
		playerSortedCards[1] = new Card(Rank.THREE,Suit.CLUBS);
		playerSortedCards[2] = new Card(Rank.FOUR,Suit.HEARTS);
		playerSortedCards[3] = new Card(Rank.FIVE,Suit.CLUBS);
		playerSortedCards[4] = new Card(Rank.SIX,Suit.DIAMONDS);
		playerSortedCards[5] = new Card(Rank.SEVEN,Suit.CLUBS);
		playerSortedCards[6] = new Card(Rank.SEVEN,Suit.HEARTS);
		
	}
	
	
	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
	public String toString() {
		String str = name+" ";
		return str;
	}
	public void addCardsToArray() {
		
		
		for(int i = 0;i < cards.size();i++) {
			
			addCardToArray(i,cards.get(i));
		
		}
	}
	public void sortByRank(Card[] k) {
		Card tmp;
		for(int i = 0; i < k.length; i++) {
			for(int j = 0; j < k.length; j++) {
				if(k[i].getRankNum() < k[j].getRankNum()) {					
					tmp = k[i];
					k[i] = k[j];
					k[j] = tmp;
				}
			}
		}
		
	}
	public void sortByRankDes(Card[] k) {
		Card tmp;
		for(int i = 0; i < k.length; i++) {
			for(int j = 0; j < k.length; j++) {
				if(k[i].getRankNum() > k[j].getRankNum()) {					
					tmp = k[i];
					k[i] = k[j];
					k[j] = tmp;
				}
			}
		}
		
	}
	
	public void sortBySuit(Card[] k) {
		Card tmp;
		for(int i = 0; i < k.length; i++) {
			for(int j = 0; j < k.length; j++) {
				if(k[i].getSuitNum() < k[j].getSuitNum()) {					
					tmp = k[i];
					k[i] = k[j];
					k[j] = tmp;
				}
			}
		}
		
	}
	public void testSortBySuit(Card[] k) {
		Card tmp;
		for(int i = 0; i < k.length; i++) {
			for(int j = 0; j < k.length; j++) {
				if(k[i].getSuitNum() + k[i].getRankNum() < k[j].getSuitNum() + k[j].getRankNum()) {					
					tmp = k[i];
					k[i] = k[j];
					k[j] = tmp;
				}
			}
		}	
	}	
	
	public void printPlayerCards() {
		for(int i=0;i < playerSortedCards.length;i++) {
			System.out.println("Card " + (i+1) + ": " + playerSortedCards[i]);
		}
		System.out.println();
	}
}
