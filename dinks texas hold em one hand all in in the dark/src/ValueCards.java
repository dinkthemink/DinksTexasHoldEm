

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
	public Card twoPairLow;
	
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
			p.setValue(valueThree(c)  + p.getKickerCard().getRankNum());
			return valueThree(c)  + p.getKickerCard().getRankNum();
			
		}else if(isTwoPair(c)) {
			p.setValue(valueTwoPair(c)  + p.getKickerCard().getRankNum());
			return valueTwoPair(c)  + p.getKickerCard().getRankNum();
			
		}else if(isPair(c)) {
			p.setValue(valuePair(c)  + p.getKickerCard().getRankNum());
			return valuePair(c)  + p.getKickerCard().getRankNum();
		}else 
			p.setValue(valueHighCard(c)  + p.getKickerCard().getRankNum());
			return valueHighCard(c)  + p.getKickerCard().getRankNum();
		
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
		sortByRankDes(c);
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
		sortByRankDes(c);
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
		sortByRankDes(c);
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
					valueTwoPair(p1,p2);
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
		Card highCard = null;
		int cardsInARow = 0;
		boolean isRoyalFlush = false;
		sortBySuitAndRank(c);
		for(int i = 0;i < c.length -1; i++) {
			
			if(c[i+1].getRankNum() - c[i].getRankNum() == 1 && c[i+1].getSuit() == c[i].getSuit() ) {
				cardsInARow++;
				highCard = c[i+1];
			}else {
				if(i <= 2) {
					cardsInARow = 0;
					continue;			
				}else {
					break;
				}
				
			}
				
		}
		
		if(cardsInARow >= 4 && highCard.getRankNum() == 14) {
			isRoyalFlush = true;
			System.out.println("RoyalFlush! HighCard: ");
			valueRolayStraigthFlushHighCard(highCard);
		}
		
		return isRoyalFlush;	
	}
	
	public boolean isStraight(Card[] c) {
		Card highCard = null;
		sortByRank(c);
		int cardsInARow = 0;
		int cardsInARowWithAce = 0;
		boolean isStraigth = false;
		
		// Check if Ace
		
		if(c[6].getRankNum() == 14 && c[0].getRankNum() == 2) {
			cardsInARowWithAce++;
			for(int i = 0;i < c.length -2;i++) {
				if(c[i+1].getRankNum() - c[i].getRankNum() == 0) {
					continue;
				}
				if(c[i+1].getRankNum() - c[i].getRankNum() == 1) {
					cardsInARowWithAce++;
					highCard = c[i+1];
				}else {
					break;
				}
			
			}

		}
		// Check if no Ace

		for(int i = 0;i < c.length -1; i++) {
			if(c[i+1].getRankNum() - c[i].getRankNum() == 0) {
				continue;
			}
			if(c[i+1].getRankNum() - c[i].getRankNum() == 1) {
				cardsInARow++;
				highCard = c[i+1];
			}else {
				if(i < 2) {
					cardsInARow = 0;
					continue;
				}else {
					break;
				}			
			}			
		}
		
		if(cardsInARow >= 4) {
			isStraigth = true;
			System.out.println("Straight found! Highcard: " + highCard);
			valueStraigthHighCard(highCard);
			
		}
		if(cardsInARowWithAce >= 4) {
			
			valueStraigthHighCard(highCard);
			System.out.println("Straight found with Ace! HighCard: " + highCard);
			
		}
		
		return isStraigth;		
	}
	
	public boolean isStraightFlush(Card[] c) {
		Card highCard = null;
		sortBySuitAndRank(c);
		int cardsInARow = 0;
		int cardsInARowWithAce = 0;
		boolean isStraigthFlush = false;	
		
		// Check if no Ace

		for(int i = 0;i < c.length -1; i++) {
			
			if(c[i+1].getRankNum() - c[i].getRankNum() == 1 && c[i+1].getSuit() == c[i].getSuit()) {
				cardsInARow++;
				highCard = c[i+1];
			}else {
				if(i < 2) {
					cardsInARow = 0;
					continue;
				}else {
					break;
				}
			}
				
		}
		// Check for straight flush with aces
		
		for(int i = 0;i < c.length; i++) {
			if(c[i].getRankNum() == 14) {
				
				for(int j = 0; j < c.length -1;j++) {
					if(c[j].getRankNum() == 2 && c[j].getSuit() == c[i].getSuit()
							&& c[j+1].getRankNum() == 3 && c[j+1].getSuit() == c[i].getSuit()
							&& c[j+2].getRankNum() == 4 && c[j+2].getSuit() == c[i].getSuit()
							&& c[j+3].getRankNum() == 5 && c[j+3].getSuit() == c[i].getSuit()) {
						cardsInARowWithAce = 5;					
						highCard = c[j+3];
						
					}
				}
			}
				
		}
		
		if(cardsInARow >= 4) {
			isStraigthFlush = true;
			System.out.println("StraightFlush! Highcard: " + highCard);
			valueStraigthFlushHighCard(highCard);
			
		}else if(cardsInARowWithAce >= 4) {
			isStraigthFlush = true;
			System.out.println("Straithflush with Ace to Five! Highcard: " +highCard);
			valueStraigthFlushHighCard(highCard);
			
		}
			
		return isStraigthFlush;		
	}
		
	public boolean isFlush(Card[] c ) {
		boolean isFlush = false;
		Card highCard = null;
		int cardsInARow = 0;
		sortBySuitAndRank(c);
		for(int i = 0;i < c.length -1;i++) {
			if(c[i+1].getSuit() == c[i].getSuit()) {
				highCard = c[i+1];
				cardsInARow++;
			}else {
				if(i < 2) {
					cardsInARow = 0;
					continue;
				}else {
					break;
				}
			}
		}
		
		if(cardsInARow >= 4) {
			System.out.println("Flush found! HighCard: "+ highCard);
			valueFlushHighCard(highCard);
			isFlush = true;
			
		}
		return isFlush;
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
	public int valueTwoPair(Card c,Card d) {
		twoPairHigh = c;
		twoPairLow = d;
		return (twoPairHigh.getRankNum()+ twoPairLow.getRankNum());
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
