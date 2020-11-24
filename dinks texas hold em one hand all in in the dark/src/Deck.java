import java.util.ArrayList;
import java.util.Random;

public class Deck extends DinksTexasHoldEm {
	public ArrayList<Card> flop = new ArrayList<Card>();
	public ArrayList<Card> turn = new ArrayList<Card>();
	public ArrayList<Card> river = new ArrayList<Card>();
	public ArrayList<Card> allCards = new ArrayList<Card>();
	public ArrayList<Card> burnedCards = new ArrayList<Card>();
	private static int clubs = 0;
	private static int diamonds = 0;
	private static int spades = 0;
	private static int hearts = 0;
	
	private static int card1count = 0;
	private static int card2count = 0;

	Random rand = new Random();
	public void populate() {
		for(Suit suit: Suit.values()) {
			for(Rank rank: Rank.values()) {
				Card card = new Card(rank,suit);
				deck.add(card);							
			}
		}
	}
	public void shuffleDeck() {
		for(int i = deck.size() -1; i > 0;i--) {
			int pick = rand.nextInt(i);
			Card randCard = deck.get(pick);
			Card lastCard = deck.get(i);
			deck.set(i, randCard);
			deck.set(pick, lastCard);			
		}
	}
	public void flop() {
		burnedCards.add(deck.get(0));
		deck.remove(0);
		flop.add(deck.get(0));
		allCards.add(deck.get(0));
		deck.remove(0);
		flop.add(deck.get(0));
		allCards.add(deck.get(0));
		deck.remove(0);
		flop.add(deck.get(0));
		allCards.add(deck.get(0));
		deck.remove(0);
		
	}
	public ArrayList<Card> getFlop() {
		return flop;
	}
	public void setFlop(ArrayList<Card> flop) {
		this.flop = flop;
	}
	public void turn() {
		burnedCards.add(deck.get(0));
		deck.remove(0);
		turn.add(deck.get(0));
		allCards.add(deck.get(0));
		deck.remove(0);
	}
	public void river() {
		burnedCards.add(deck.get(0));
		deck.remove(0);
		river.add(deck.get(0));
		allCards.add(deck.get(0));
		deck.remove(0);
	}
	public ArrayList<Card> getTurn() {
		return turn;
	}
	public void setTurn(ArrayList<Card> turn) {
		this.turn = turn;
	}
	public ArrayList<Card> getRiver() {
		return river;
	}
	public void setRiver(ArrayList<Card> river) {
		this.river = river;
	}
	public ArrayList<Card> getAllCards() {
		return allCards;
	}
	public void setAllCards(ArrayList<Card> allCards) {
		this.allCards = allCards;
	}
	public ArrayList<Card> getBurnedCards() {
		return burnedCards;
	}
	public void setBurnedCards(ArrayList<Card> burnedCards) {
		this.burnedCards = burnedCards;
	}
	public boolean gotSameSuit() {
		for(int i = 0; i < playerList.size(); i++) {
			if(playerList.get(i).getCards().get(0).getSuit().equals(playerList.get(i).getCards().get(1).getSuit())) {
				System.out.println("DEBUG: Player hand of "+ playerList.get(i) + " is suited");
				if(playerList.get(i).getCards().get(0).getSuit().equals("Clubs")) {
					clubs++;
					clubs++;
					return true;
				}else if(playerList.get(i).getCards().get(0).getSuit().equals("Hearts")) {
					hearts++;
					hearts++;
					return true;
					
				}else if(playerList.get(i).getCards().get(0).getSuit().equals("Diamonds")) {
					diamonds++;
					diamonds++;
					return true;
				}else if(playerList.get(i).getCards().get(0).getSuit().equals("Spades")) {
					spades++;
					spades++;
					return true;
				}
			}
		}
		return false;
	}
	public void checkForSuited() {
		for(int i = 0; i < playerList.size(); i++) {
			for(int j = 0; j < allCards.size(); j++) {
				if(allCards.get(j).getSuit().equals(playerList.get(i).getCards().get(0).getSuit())) {
					System.out.println("DEBUG : SUIT MATCH");
					if(playerList.get(i).getCards().get(0).getSuit().equals("Clubs")) {
						clubs++;
					}else if(playerList.get(i).getCards().get(0).getSuit().equals("Hearts")) {
						hearts++;
						
					}else if(playerList.get(i).getCards().get(0).getSuit().equals("Diamonds")) {
						diamonds++;
						
					}else if(playerList.get(i).getCards().get(0).getSuit().equals("Spades")) {
						spades++;
					}
				}if(allCards.get(j).getSuit().equals(playerList.get(i).getCards().get(1).getSuit())) {
					System.out.println("DEBUG : SUIT MATCH");
					if(playerList.get(i).getCards().get(1).getSuit().equals("Clubs")) {
						clubs++;
					}else if(playerList.get(i).getCards().get(0).getSuit().equals("Hearts")) {
						hearts++;
						
					}else if(playerList.get(i).getCards().get(0).getSuit().equals("Diamonds")) {
						diamonds++;
						
					}else if(playerList.get(i).getCards().get(0).getSuit().equals("Spades")) {
						spades++;
					}
				}
			}
		}switch(clubs) {
		case 5:
			System.out.println("You got yourself a flush big guy");
			break;
		}
		switch(spades) {
		case 5:
			System.out.println("You got yourself a flush big guy");
			break;
		}
		switch(diamonds) {
		case 5:
			System.out.println("You got yourself a flush big guy");
			break;
		}
		switch(hearts) {
		case 5:
			System.out.println("You got yourself a flush big guy");
			break;
		}
	}
	public void gotSameRank() {
		for(int i = 0; i < playerList.size(); i ++) {	
				if(playerList.get(i).getCards().get(0).getRank().equals(playerList.get(i).getCards().get(1).getRank())) {
					System.out.println(playerList.get(i) + " already got a pair of " + playerList.get(i).getCards().get(0).getRank() + "s");
					card1count++;
					card2count++;
				}
		}
	}
	public void checkForRank() {
		for(int i = 0; i < playerList.size(); i++) {			
			for(int j = 0; j < allCards.size(); j++) {
				if(allCards.get(j).getRank().equals(playerList.get(i).getCards().get(0).getRank())) {					
					
					System.out.println(playerList.get(i) + " : " + allCards.get(j) 
					+", " + playerList.get(i).getCards().get(0).toString() + "\t" + "Pair of " + playerList.get(i).getCards().get(0).getRank() + "s" );
					
					card1count++;
				}if(allCards.get(j).getRank().equals(playerList.get(i).getCards().get(1).getRank())) {					
					
					System.out.println(playerList.get(i) + " : " + allCards.get(j)
					+ ", "+ playerList.get(i).getCards().get(1).toString() +"\t" + "Pair of " + playerList.get(i).getCards().get(1).getRank() + "s");
		
					card2count ++;
				}
			}		
		}switch(card1count) {
		case 1:
			System.out.println("DEBUG: A pair!");
			break;
		case 2:
			System.out.println("DEBUG: Three of a kind!");
			break;
		case 3:
			System.out.println("DEBUG: Four of a kind!");
			break;
		}
		switch(card2count) {
		case 1:
			System.out.println("DEBUG: A pair!");
			break;
		case 2:
			System.out.println("DEBUG: Three of a kind!");
			break;
		case 3:
			System.out.println("DEBUG: Four of a kind!");
			break;
		}
	}
	
}
