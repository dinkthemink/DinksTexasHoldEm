import java.util.HashSet;
import java.util.Set;

public class ValueCards {
	
	public static final int ROYAL_STRAIGHT_FLUSH = 900;
	
	public static final int STRAIGHT_FLUSH = 800; 
    // + valueHighCard()
	public static final int FOUR_OF_A_KIND = 700; 
    // + Quads Card Rank
	public static final int FULL_HOUSE     = 600; 
    // + SET card rank
	public static final int FLUSH          = 500;  
    // + valueHighCard()
	public static final int STRAIGHT       = 400;   
    // + valueHighCard()
	public static final int SET            = 300;    
    // + Set card value
	public static final int TWO_PAIRS      = 200;     
    // + High2*14^4+ Low2*14^2 + card
	public static final int ONE_PAIR       = 100;      
    // + high*14^2 + high2*14^1 + low
	public Card flushHigh;
	
	public int valueHand(Players p,Card[] c) {
		if(isFlush(c) && isRoyal(c)) {
			p.setValue(valueRoyalFlush(c));
			return valueRoyalFlush(c);
			
		}else if(isFlush(c)) {
			p.setValue(valueFlush(c));
			return valueFlush(c);
			
		}else 
			p.setValue(valueHighCard(c));
			return valueHighCard(c);
		
	}
	
	public int valueFlush(Card[] c) {
		return FLUSH + flushHigh.getRankNum();
	}
	public int valueStraightFlush(Card[] c) {
		return STRAIGHT_FLUSH + flushHigh.getRankNum();
	}
	public int valueRoyalFlush(Card[] c) {
		return ROYAL_STRAIGHT_FLUSH + flushHigh.getRankNum();
	}
	public int valueStraight(Card[] c) {
		return STRAIGHT + flushHigh.getRankNum();
	}
	
	public boolean isRoyal(Card[] c) {
		sortBySuitAndRank(c);
		if(c[6].getRank() == "Ace") {
			if(c[2].getRank() == "Ten" && c[2].getSuit().equals(c[6].getSuit())
					&& c[3].getRank() == "Jack" && c[3].getSuit().equals(c[6].getSuit())
					&& c[4].getRank() == "Queen" && c[4].getSuit().equals(c[6].getSuit())
					&& c[5].getRank() == "King" && c[5].getSuit().equals(c[6].getSuit())) {
				System.out.println("ROYAL STRAIGHT GOGOGOGOGOGOOGOG");
				return true;
				
			}else if(c[5].getRank() == "Ace") {
				if(c[1].getRank() == "Ten" && c[1].getSuit().equals(c[5].getSuit())
						&& c[2].getRank() == "Jack" && c[2].getSuit().equals(c[5].getSuit())
						&& c[3].getRank() == "Queen" && c[3].getSuit().equals(c[5].getSuit())
						&& c[4].getRank() == "King" && c[4].getSuit().equals(c[5].getSuit())) {
					System.out.println("ROYAL STRAIGHT GOGOGOGOGOGOOGOG");
					return true;
				}
			}else if(c[4].getRank() == "Ace") {
				if(c[0].getRank() == "Ten" && c[0].getSuit().equals(c[4].getSuit())
						&& c[1].getRank() == "Jack" && c[1].getSuit().equals(c[4].getSuit())
						&& c[2].getRank() == "Queen" && c[2].getSuit().equals(c[4].getSuit())
						&& c[3].getRank() == "King" && c[3].getSuit().equals(c[4].getSuit())) {
					System.out.println("ROYAL STRAIGHT GOGOGOGOGOGOOGOG");
					return true;
				}
			}
		}else {
			return false;
		}
		return false;	
	}
	
	public boolean isStraight(Card[] c) {
		sortBySuitAndRank(c);
		Set<Card> setC = new HashSet<Card>();
		for(Card s: c) {
			setC.add(s);
		}
		Card [] c2 = new Card[setC.size()];
		setC.toArray(c2);
		// Laga listo utan duplicates å koll tärifrån
		// Check with Ace
		return false;
	}
	public void testFunk(Card[] c) {
		sortBySuitAndRank(c);
		Set<Card> setC = new HashSet<Card>();
		for(Card s: c) {
			
			setC.add(s);
		}
		Card [] c2 = new Card[setC.size()];
		setC.toArray(c2);
		System.out.println("-----------ska int finnas duplicates------------");
		sortBySuitAndRank(c2);
		for(Card t: c2) {
			System.out.println(t);
		}
	}
	
	public boolean isFlush(Card[] c ) {				
		
		sortBySuitAndRank(c);
		if(c[2].getSuit() == c[6].getSuit()) {
			int maxVal;
			int minVal;
			int tmpMax = 2;
			int tmpMin = 2;
			maxVal = c[2].getRankNum();
			minVal = c[2].getRankNum();
			
			for(int i =2;i < 7;i++) {
				if(c[0].getSuit() == c[2].getSuit() && c[0].getRankNum() < minVal) {
					minVal = c[0].getRankNum();
					tmpMin = 0;
				}else if(c[1].getSuit() == c[2].getSuit() && c[0].getRankNum() < minVal) {
					minVal = c[1].getRankNum();
					tmpMin = 1;
				}
				if(c[i].getRankNum() < minVal) {
					minVal = c[i].getRankNum();
					tmpMin = i;
					continue;
				}
				if(c[i].getRankNum() > maxVal) {
					maxVal = c[i].getRankNum();
					tmpMax = i;
				}
			}
			System.out.println("FLUSH FOUND! "+ c[tmpMin] + " to " + c[tmpMax] );
			valueFlushHighCard(c[tmpMax]);
			return true;
		}else if(c[1].getSuit() == c[5].getSuit()) {
			int maxVal;
			int minVal;
			int tmpMax = 1;
			int tmpMin = 1;
			maxVal = c[1].getRankNum();
			minVal = c[1].getRankNum();
			
			for(int i =1;i < 6;i++) {
				if(c[0].getSuit() == c[1].getSuit() && c[0].getRankNum() < minVal) {
					minVal = c[0].getRankNum();
					tmpMin = 0;
				}
				if(c[i].getRankNum() < minVal) {
					minVal = c[i].getRankNum();
					tmpMin = i;
					continue;
				}
				if(c[i].getRankNum() > maxVal) {
					maxVal = c[i].getRankNum();
					tmpMax = i;
				}
			}
			System.out.println("FLUSH FOUND! "+ c[tmpMin] + " to " + c[tmpMax] );
			valueFlushHighCard(c[tmpMax]);
			return true;
		}else if(c[0].getSuit() == c[4].getSuit()) {
			int maxVal;
			int minVal;
			int tmpMax = 0;
			int tmpMin = 0;
			maxVal = c[0].getRankNum();
			minVal = c[0].getRankNum();
			
			for(int i =0;i < 5;i++) {
				if(c[i].getRankNum() < minVal) {
					minVal = c[i].getRankNum();
					tmpMin = i;
					continue;
				}
				if(c[i].getRankNum() > maxVal) {
					maxVal = c[i].getRankNum();
					tmpMax = i;
				}
			}
			System.out.println("FLUSH FOUND! "+ c[tmpMin] + " to " + c[tmpMax] );
			valueFlushHighCard(c[tmpMax]);
			return true;
		}else {
			return false;
		}		
	}
	
	public int valueFlushHighCard(Card c) {
		
		flushHigh = c;
		return flushHigh.getRankNum();
	}
	
	public int valueHighCard(Card[] c) {
		int highCard;
		sortByRank(c);
		highCard = c[6].getRankNum();
		return highCard;
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
	public void sortBySuitAndRank(Card[] k) {
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
	

	
}
