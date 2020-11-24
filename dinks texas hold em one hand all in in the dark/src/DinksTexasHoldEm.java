import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DinksTexasHoldEm {
	public static ArrayList<Card> deck = new ArrayList<Card>();
	public static ArrayList<Players> playerList = new ArrayList<Players>();

	public static void main(String[] args) {
		// Create deck and shuffle
		
		Deck game = new Deck();
		game.populate();
		game.shuffleDeck();


		
		// Create some players and give them cards
	


		String numberOfPlayers = JOptionPane.showInputDialog("How many players?");
		
		for(int i = 0;i < Integer.parseInt(numberOfPlayers); i++) {
			String in = JOptionPane.showInputDialog("Name of player " + (i+1));
			playerList.add(new Players(in));
//			System.out.println("KORT 0?????? " +deck.get(0));
//			System.out.println("KORT 1????? " + deck.get(1));
			playerList.get(i).addCard(deck.get(0));
			deck.remove(0);
			playerList.get(i).addCard(deck.get(0));
			deck.remove(0);
			
						
			System.out.println("Player " + playerList.get(i)+"cards: " +playerList.get(i).getCards() + "\n");		
		}
		
		// The flop
		game.flop();
		System.out.println("The flop: " + game.getFlop() + "\n");
		
		// The turn
		game.turn();
		System.out.println("Cards after turn: " + game.getAllCards() + "\n");
		
		// The river
		game.river();
		
		// Display all cards on the table
		System.out.println("Cards after river: " + game.getAllCards());
		
//		game.gotSameRank();
//		game.checkForRank();
//		game.gotSameSuit();
//		game.checkForSuited();
	}
	

}
