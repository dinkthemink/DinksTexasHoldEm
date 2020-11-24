import java.util.ArrayList;

public class Players {
	
	public ArrayList<Card> cards;
	public String name;
	
	public Players(String name) {
		this.name = name;
		cards = new ArrayList<Card>();
		System.out.println("Player " + name + " joined the game!");
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addCard(Card card) {
		cards.add(card);
		
	}
	public ArrayList<Card> getCards() {
		return cards;
	}
	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	public String toString() {
		String str = name+" ";
		return str;
	}
}
