import java.util.ArrayList;
import javax.swing.JOptionPane;


public class DinksTexasHoldEm {
	public static ArrayList<Card> deck = new ArrayList<Card>();
	public static ArrayList<Players> playerList = new ArrayList<Players>();
	

	public static void main(String[] args) {
		// Create deck and shuffle
		
		Deck game = new Deck();
		ValueCards value = new ValueCards();
		game.populate();
		game.shuffleDeck();

		
		// Create some players and give them cards

		String numberOfPlayers = JOptionPane.showInputDialog("How many players?");
		
		for(int i = 0;i < Integer.parseInt(numberOfPlayers); i++) {
			
			// Add player(s)
			String in = JOptionPane.showInputDialog("Name of player " + (i+1));
			playerList.add(new Players(in));
			
		}
		
		// Hand players 2 cards and assign kickerCard
		for(int i =0; i < 2;i++) {
			
			for(Players p: playerList) {
				if(p.getKickerCard() == null) {
					p.setKickerCard(deck.get(deck.size()- 1));
				}else {
					if(p.getKickerCard().getRankNum() < deck.get(deck.size()-1).getRankNum() ) {
						p.setKickerCard(deck.get(deck.size() -1));
					}
				}
				p.addCard(deck.get(deck.size() -1));
				deck.remove(deck.size() -1);
			}
		}
		
		// Just printing player cards
		for(Players p: playerList) {
			System.out.println("Player " + p + " cards: " + p.getCards());
			System.out.println("PLayer kickerCard : " + p.getKickerCard());
			
		}
		
		// The flop
		game.flop();
		System.out.println("The flop: " + game.getFlop() + "\n");
		
		// The turn
		game.turn();
		System.out.println("Turn card: " + game.getTurn() + "\n");
		
		// The river
		game.river();
		System.out.println("River card: " + game.getRiver() + "\n");
		
		// Display all cards on the table
		System.out.println("All cards on the table: " + game.getAllCards());
		
		// Add all cards on the table to playerCards for comparing
		
		for(int i= 0;i < playerList.size();i++) {
			for(Card c: game.getAllCards()) {
				playerList.get(i).addCard(c);
			}
		}
		
		// Add the cards to another Array for sorting
		
		for(int i=0;i < playerList.size();i++) {
			playerList.get(i).addCardsToArray();
		}
		

		System.out.println();
		System.out.println();
		
		// Print sorted Cards for each player
		for(int i =0;i < playerList.size();i++) {
			

			playerList.get(i).sortByRank(playerList.get(i).getPlayerSortedCards());

			playerList.get(i).printPlayerCards();
			
		}
		
		// Value all hands and print them out
		
		for(int i=0;i < playerList.size();i++) {
			
			System.out.println("PLayer " + (playerList.get(i).getName())  + " Hand Value: " + value.valueHand(playerList.get(i),playerList.get(i).getPlayerSortedCards()));
		
			
			
			
		}
		
		

	}
	
}
