

public class ValueCards {
	
	public static final int ROYAL_STRAIGHT_FLUSH = 900;
	
	public static final int STRAIGHT_FLUSH = 800; 
 
	public static final int FOUR_OF_A_KIND = 700; 
    
	public static final int FULL_HOUSE     = 600; 
   
	public static final int FLUSH          = 500;  
    
	public static final int STRAIGHT       = 400;   
    
	public static final int THREE_OF_A_KIND= 300;    
  
	public static final int TWO_PAIRS      = 200;     
   
	public static final int ONE_PAIR       = 100;      
   
	public Card flushHigh;
	public Card quadHigh;
	public Card rolayStraigthFlushHigh;
	public Card straightHigh;
	public Card straigthFlushHigh;
	public Card fullHouseHigh;
	public Card threeHigh;	
	public Card onePairHigh;
	public Card twoPairHigh;
	
	public int valueHand(Players p,Card[] c) {
		
		if(isRoyalFlush(c)) {
			p.setValue(valueRoyalFlush(c));
			return valueRoyalFlush(c);
			
		}else if(isStraightFlush(c)) {
			p.setValue(valueStraightFlush(c));
			return valueStraightFlush(c);
			
		}else if(isQuads(c)) {
			p.setValue(valueQuad(c));
			return valueQuad(c);
			
		}else if(isFullHouse(c)) {
			p.setValue(valueFullHouse(c));
			return valueFullHouse(c);
			
		}else if(isFlush(c)) {
			p.setValue(valueFlush(c));
			return valueFlush(c);
			
		}else if(isStraight(c)) {
			p.setValue(valueStraight(c));
			return valueStraight(c);
			
		}else if(isThree(c)) {
			p.setValue(valueThree(c));
			return valueThree(c);
			
		}else if(isTwoPair(c)) {
			p.setValue(valueTwoPair(c));
			return valueTwoPair(c);
			
		}else if(isPair(c)) {
			p.setValue(valuePair(c));
			return valuePair(c);
		}else 
			p.setValue(valueHighCard(c));
			return valueHighCard(c);
		
	}
	
	// Value Checkers
	
	public int valueQuad(Card[] c) {
		return FOUR_OF_A_KIND + quadHigh.getRankNum() + valueHighCard(c);
	}
	public int valueThree(Card[] c) {
		return THREE_OF_A_KIND + threeHigh.getRankNum() + valueHighCard(c);
	}
	public int valueTwoPair(Card[] c) {
		return TWO_PAIRS + twoPairHigh.getRankNum() + valueHighCard(c);
	}
	public int valuePair(Card[] c) {
		return ONE_PAIR + onePairHigh.getRankNum() + valueHighCard(c);
	}
	public int valueFlush(Card[] c) {
		return FLUSH + flushHigh.getRankNum();
	}
	public int valueFullHouse(Card[] c) {
		return FULL_HOUSE + fullHouseHigh.getRankNum();
	}
	public int valueStraightFlush(Card[] c) {
		return STRAIGHT_FLUSH + straigthFlushHigh.getRankNum();
	}
	public int valueRoyalFlush(Card[] c) {
		return ROYAL_STRAIGHT_FLUSH + rolayStraigthFlushHigh.getRankNum();
	}
	public int valueStraight(Card[] c) {
		return STRAIGHT + straightHigh.getRankNum();
	}
	public int valueHighCard(Card[] c) {
		int highCard;
		sortByRank(c);
		highCard = c[6].getRankNum();
		return highCard;
	}
	
	// Checking Card Methods
	
	public boolean isQuads(Card[] c) {
		sortByRank(c);
		boolean isQuad = false;
		int cardRepeat = 1;
		for(int i=0;i < c.length -1;i++) {
			
			if(c[i].getRank() == c[i+1].getRank()) {
				cardRepeat++;
				if(cardRepeat == 4) {
					isQuad = true;
					System.out.println("JESUS A QUAD OF " + c[i+1].getRank());
					valueQuadHigh(c[i+1]);
				}
			}else {
				cardRepeat = 1;
			}
		}
		return isQuad;
	}
	
	public boolean isFullHouse(Card[] c) {
		sortByRank(c);
		boolean isTwo = false;
		boolean isThree = false;
		int cardRepeat = 1;
		Card ifThree = null;
		Card ifTwo = null;
		
		for(int i = 0; i < c.length -1;i++) {
			if(c[i].getRank() == c[i+1].getRank()) {
				cardRepeat++;
				if(cardRepeat == 3) {
					ifThree = c[i];
					isThree = true;
					cardRepeat = 1;
				}
			}else {
				cardRepeat = 1;
			}
		}
		
		if(isThree) {
			for(int i = 0; i < c.length -1;i++) {
				if(c[i].getRank() == c[i+1].getRank() && c[i].getRankNum() != ifThree.getRankNum()) {
					cardRepeat++;
					if(cardRepeat == 2) {
						ifTwo = c[i];
						isTwo = true;
					}
				}else {
					cardRepeat = 1;
				}
			}
			
		}
		
		if(isThree && isTwo) {
			valueFullHouseHigh(ifThree);
			System.out.println("FULL HOUSE WITH " + ifThree.getRank() + " and " + ifTwo.getRank()  );
		}
		return (isThree && isTwo);
		
	}
	public boolean isThree(Card[] c) {
		sortByRank(c);
		boolean isThree = false;
		int cardRepeat = 1;
		for(int i=0;i < c.length -1;i++) {
			
			if(c[i].getRank() == c[i+1].getRank()) {
				cardRepeat++;
				if(cardRepeat == 3) {
					isThree = true;
					System.out.println("Three of a kind of " + c[i+1].getRank());
					valueThreeHigh(c[i+1]);
				}
			}else {
				cardRepeat = 1;
			}
		}
		return isThree;
	}
	public boolean isTwoPair(Card[] c) {
		sortByRank(c);
		boolean isTwo = false;
		int cardRepeat = 1;
		int numberOfPairs = 0;
		Card p1 = null;
		Card p2 = null;
		for(int i = 0;i < c.length -1;i++) {
			if(c[i].getRankNum() == c[i+1].getRankNum()) {
				cardRepeat++;
				if(cardRepeat == 2) {
					cardRepeat = 1;
					numberOfPairs++;
					p1 = c[i+1];
					break;
				}
			}
		}
		for(int i=0; i < c.length -1;i++) {
			if(c[i].getRankNum() == c[i+1].getRankNum() && c[i].getRankNum() != p1.getRankNum()) {
				cardRepeat++;
				numberOfPairs++;
				if(numberOfPairs == 2 && cardRepeat == 2) {
					p2 = c[i+1];
					System.out.println("TWO PAIRS FOUND " + p1.getRank() + " and " + p2.getRank());
					valueTwoPair(p2);
					isTwo = true;
				}
			}
		}		
		return isTwo;
	}
	public boolean isPair(Card[]c) {
		sortByRankDes(c);
		boolean isPair = false;
		for(int i = 0;i < c.length -1;i++) {
			if(c[i].getRank() == c[i+1].getRank() ) {
				valueOnePair(c[i]);
				System.out.println("Pair of " +c[i].getRankNum() + " found!");
				isPair = true;
			}
		}
		return isPair;
	}
	
	public boolean isRoyalFlush(Card[] c) {
		sortBySuitAndRank(c);
		if(c[6].getRank() == "Ace") {
			if(c[2].getRank() == "Ten" && c[2].getSuit().equals(c[6].getSuit())
					&& c[3].getRank() == "Jack" && c[3].getSuit().equals(c[6].getSuit())
					&& c[4].getRank() == "Queen" && c[4].getSuit().equals(c[6].getSuit())
					&& c[5].getRank() == "King" && c[5].getSuit().equals(c[6].getSuit())) {
				System.out.println("ROYAL STRAIGHT GOGOGOGOGOGOOGOG");
				valueRolayStraigthFlushHighCard(c[6]);
				return true;
				
			}else if(c[5].getRank() == "Ace") {
				if(c[1].getRank() == "Ten" && c[1].getSuit().equals(c[5].getSuit())
						&& c[2].getRank() == "Jack" && c[2].getSuit().equals(c[5].getSuit())
						&& c[3].getRank() == "Queen" && c[3].getSuit().equals(c[5].getSuit())
						&& c[4].getRank() == "King" && c[4].getSuit().equals(c[5].getSuit())) {
					System.out.println("ROYAL STRAIGHT GOGOGOGOGOGOOGOG");
					valueRolayStraigthFlushHighCard(c[5]);
					return true;
				}
			}else if(c[4].getRank() == "Ace") {
				if(c[0].getRank() == "Ten" && c[0].getSuit().equals(c[4].getSuit())
						&& c[1].getRank() == "Jack" && c[1].getSuit().equals(c[4].getSuit())
						&& c[2].getRank() == "Queen" && c[2].getSuit().equals(c[4].getSuit())
						&& c[3].getRank() == "King" && c[3].getSuit().equals(c[4].getSuit())) {
					System.out.println("ROYAL STRAIGHT GOGOGOGOGOGOOGOG");
					valueRolayStraigthFlushHighCard(c[4]);
					return true;
				}
			}
		}else {
			return false;
		}
		return false;	
	}
	
	public boolean isStraight(Card[] c) {
		sortByRank(c);
		int cardsInARow = 0;
		int cardsInARowWithAce = 0;
		boolean isStraigth = false;
		
		// Check if Ace
		
		if(c[6].getRankNum() == 14 && c[0].getRankNum() == 2) {
			cardsInARowWithAce++;
			for(int i =1;i < c.length -1;i++) {
				if(c[i+1].getRankNum() - c[i].getRankNum() == 1 && c[i+1].getRankNum() - c[i -1].getRankNum() == 2) {
					cardsInARowWithAce++;
					if(cardsInARowWithAce == 4) {
						valueStraigthHighCard(c[i+1]);
						System.out.println("STRAIGTH FOUND WITH ACE HIGH CARD " + c[i+1].getRank());
						isStraigth = true;
						break;
					}
				}
			}
		}
		// Check if no Ace
		
		for(int i = 0;i < c.length -1; i++) {
			if(i == 0) {
				if(c[i+1].getRankNum() - c[i].getRankNum() == 1) {
					cardsInARow++;
				}
			}
			if(i > 0) {

				if(c[i+1].getRankNum() - c[i].getRankNum() == 1 && c[i+1].getRankNum() - c[i -1].getRankNum() == 2) {
					cardsInARow++;
					if(cardsInARow == 4) {
						
						valueStraigthHighCard(c[i+1]);
						System.out.println("STRAIGTH FOUND HIGH CARD " + c[i+1].getRank());
						isStraigth = true;
						break;
					}
				}
				
			}		
		}
		
		return isStraigth;		
	}
	
	public boolean isStraightFlush(Card[] c) {
		sortBySuitAndRank(c);
		int cardsInARow = 0;


		boolean isStraigthFlush = false;
		
		for(int i = 0;i < c.length -1; i++) {
			if(i == 0) {
				if(c[i+1].getRankNum() - c[i].getRankNum() == 1
					&& c[i+1].getSuit() == c[i].getSuit()) {
					cardsInARow++;
				}
			}
			if(i > 0) {

				if(c[i+1].getRankNum() - c[i].getRankNum() == 1 
						&& c[i+1].getSuit() == c[i].getSuit() 
						&& c[i+1].getRankNum() - c[i -1].getRankNum() == 2 
						&& c[i+1].getSuit() == c[i -1].getSuit()) {
						cardsInARow++;
						
					if(cardsInARow == 4) {
						
						valueStraigthFlushHighCard(c[i+1]);
						System.out.println("STRAIGTH FOUND HIGH CARD " + c[i+1].getRank());
						isStraigthFlush = true;
						break;
					}
				}
				
			}		
		}
		
		return isStraigthFlush;		
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
	
	
	// Set high card methods
	
	public int valueRolayStraigthFlushHighCard(Card c) {
		rolayStraigthFlushHigh = c;
		return rolayStraigthFlushHigh.getRankNum();
	}
	
	public int valueStraigthFlushHighCard(Card c) {
		straigthFlushHigh = c;
		return straigthFlushHigh.getRankNum();
	}
	
	public int valueFlushHighCard(Card c) {
		
		flushHigh = c;
		return flushHigh.getRankNum();
	}
	public int valueStraigthHighCard(Card c) {
		
		straightHigh = c;
		return straightHigh.getRankNum();
	}
	
	public int valueQuadHigh(Card c ) {
		quadHigh = c;
		return quadHigh.getRankNum();
	}
	public int valueFullHouseHigh(Card c) {
		fullHouseHigh = c;
		return fullHouseHigh.getRankNum();
	}
	public int valueThreeHigh(Card c) {
		threeHigh = c;
		return threeHigh.getRankNum();
	}
	public int valueTwoPair(Card c) {
		twoPairHigh = c;
		return twoPairHigh.getRankNum();
	}
	public int valueOnePair(Card c) {
		onePairHigh = c;
		return onePairHigh.getRankNum();
	}
		
	// Sorting and Test Methods
	
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
