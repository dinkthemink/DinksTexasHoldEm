
public enum Suit {
	HEARTS("Hearts"),
	SPADES("Spades"),
	DIAMONDS("Diamonds"),
	CLUBS("Clubs");
	
	private final String SuitText;
	
	private Suit(String SuitText) {
		this.SuitText = SuitText;
	}
	public String getSuit() {
		return SuitText;
	}
}
