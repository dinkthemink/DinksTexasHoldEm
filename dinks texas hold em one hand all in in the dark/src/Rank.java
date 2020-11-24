
public enum Rank {
	ACE("Ace"),
	DEUCE("Deuce"),
	THREE("Three"),
	FOUR("Four"),
	FIVE("Five"),
	SIX("Six"),
	SEVEN("Seven"),
	EIGHT("Eight"),
	NINE("Nine"),
	TEN("Ten"),
	JACK("Jack"),
	QUEEN("Queen"),
	KING("King");
	private final String RankString;
	
	private Rank(String RankString) {
		this.RankString = RankString;
	}
	public String getRank() {
		return RankString;
	}
}
