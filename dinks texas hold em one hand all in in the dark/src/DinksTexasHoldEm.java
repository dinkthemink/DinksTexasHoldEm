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
			
			// Give the player 2 cards
			playerList.get(i).addCard(deck.get(deck.size() -1));
			deck.remove(deck.get(deck.size() -1));
			playerList.get(i).addCard(deck.get(deck.size() -1));
			deck.remove(deck.size() -1);
			
						
			System.out.println("Player " + playerList.get(i)+"cards: " +playerList.get(i).getCards() + "\n");		
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
		
		// Sort the player cards for comparison
		
//		for(int i =0;i < playerList.size();i++) {
//			playerList.get(i).sortByRank(playerList.get(i).getPlayerSortedCards());
//			playerList.get(i).sortBySuit(playerList.get(i).getPlayerSortedCards());
//		}

		System.out.println();
		System.out.println();
		
		// Print sorted Cards for each player
		for(int i =0;i < playerList.size();i++) {
			
//			playerList.get(i).printPlayerCards();
			playerList.get(i).testSortBySuit(playerList.get(i).getPlayerSortedCards());
			playerList.get(i).printPlayerCards();
			
		}
		for(int i=0;i < playerList.size();i++) {
//			checker.isFlush(playerList.get(i).sortByRank(playerList.get(i).getPlayerSortedCards()));
			
			
			System.out.println("PLayer " + (i+1)  + " Hand Value: " + value.valueHand(playerList.get(i),playerList.get(i).getPlayerSortedCards()));
			
//			value.testFunk(playerList.get(i).getPlayerSortedCards());
			
			
			
		}
		
		

	}
	
}
