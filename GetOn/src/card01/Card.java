package card01;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;

// Class to represent a card in the deck
public class Card {

	public enum CardType {km, bully, fix, status};
	
	private final CardType cardtype;
	
	// constructor
	public Card(CardType cardtype) {
		this.cardtype = cardtype;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
