import java.util.ArrayList;
import java.util.Random;

public class Deck extends DinksTexasHoldEm {
	public ArrayList<Card> flop = new ArrayList<Card>();
	public ArrayList<Card> turn = new ArrayList<Card>();
	public ArrayList<Card> river = new ArrayList<Card>();
	public ArrayList<Card> allCards = new ArrayList<Card>();
	public ArrayList<Card> burnedCards = new ArrayList<Card>();
	
	Random rand = new Random();
	
	// Populate deck
	public void populate() {
		for(Suit suit: Suit.values()) {
			for(Rank rank: Rank.values()) {
				Card card = new Card(rank,suit);
				deck.add(card);						
			}
		}
	}
	
	// Shuffle Deck
	public void shuffleDeck() {
		for(int i = deck.size() -1; i > 0;i--) {
			int pick = rand.nextInt(i);
			Card randCard = deck.get(pick);
			Card lastCard = deck.get(i);
			deck.set(i, randCard);
			deck.set(pick, lastCard);			
		}
	}
	
	// Flop
	public void flop() {
		burnedCards.add(deck.get(deck.size() -1));
		deck.remove(deck.size() -1);
		flop.add(deck.get(deck.size() -1));
		allCards.add(deck.get(deck.size() -1));
		deck.remove(deck.size() -1);
		flop.add(deck.get(deck.size() -1));
		allCards.add(deck.get(deck.size() -1));
		deck.remove(deck.size() -1);
		flop.add(deck.get(deck.size() -1));
		allCards.add(deck.get(deck.size() -1));
		deck.remove(deck.size() -1);		
	}
	
	// Turn	
	public void turn() {
		burnedCards.add(deck.get(deck.size() -1));
		deck.remove(deck.size() -1);
		turn.add(deck.get(deck.size() -1));
		allCards.add(deck.get(deck.size() -1));
		deck.remove(deck.size() -1);
	}
	
	// River
	public void river() {
		burnedCards.add(deck.get(deck.size() -1));
		deck.remove(deck.size() -1);
		river.add(deck.get(deck.size() -1));
		allCards.add(deck.get(deck.size() -1));
		deck.remove(deck.size() -1);
	}
	
	// Getters
	public ArrayList<Card> getFlop() {
		return flop;
	}
	
	public ArrayList<Card> getTurn() {
		return turn;
	}

	public ArrayList<Card> getRiver() {
		return river;
	}
	
	public ArrayList<Card> getAllCards() {
		return allCards;
	}

	public ArrayList<Card> getBurnedCards() {
		return burnedCards;
	}
	
}
