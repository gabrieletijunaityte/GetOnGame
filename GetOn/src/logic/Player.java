package logic;

import java.util.ArrayList;

public class Player {

	private ArrayList<Card> hand;
	private Boolean isTurn;
	private String name;
	private Boolean onBikeStatus;
	private Boolean bulliedStatus;
	private Boolean hasWind;
	private PlayedCards playedCards;

	public Player(String name, Boolean isTurn) {
		this.name = name;
		this.isTurn = true;
		this.hand = new ArrayList<>();
		this.onBikeStatus = false;
		this.bulliedStatus = false;
		this.hasWind = false;
		this.playedCards = new PlayedCards();
	}


	public void drawCard(Stack stack) {
	
		// Add a card to the hand	
		this.hand.add(stack.drawTopCard());
		
		// change turn after drawing a card
		changeTurn();
	}

	// method to change the player name
	public void changeName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Boolean getTurn() {
		return this.isTurn;
	}

	public void changeTurn() {
		if (isTurn) {
			this.isTurn = false;
		} else {
			this.isTurn = true;
		}
	}


	public void drawCard(Stack stack, int amount) {
		// Create a dummy hand
		// Get five cards
		ArrayList<Card> temp_hand = new ArrayList<>();
		
		for (int i = 0; i < amount; i++){
			temp_hand.add(stack.drawTopCard());
		}
		this.hand = temp_hand;
	}

	public String viewHand() {
		ArrayList<String> handCards = new ArrayList<>();
		for (Card card : this.hand) {
			handCards.add(card.getCardName());
		}
		String handCardsString = handCards.toString();
//		System.out.println(handCardsString); 
		return handCardsString;
	}

	public void discardCard(int i, Stack discardPile) {
		// Add the discarded card to the discardPile and remove the card from the hand
		// Check if the index is possible, if not, throw exception
		if (i < 0 || i >= 5) {
			throw new IllegalArgumentException("The index must be cannot be lower than 0 and higher than 4");
		} else {
			// TODO: REMOVE THE PRINTS

			// Set discarded card to the parameter index of the hand.
			Card discardedCard = hand.get(i);
			// Add the discarded card to the discardPile
			discardPile.addDiscardedCard(discardedCard);
			// Remove the card from the hand
			hand.remove(i);
			// Show which card is removed
			System.out.println(discardedCard.getCardName() + ": has been discarded from your hand");
		}
		// Show the hand after the removal
		System.out.println("Current hand: " + viewHand());
	}

	public ArrayList<Card> getHand() {
		return this.hand;
	}

	public Boolean getOnBikeStatus() {
		return this.onBikeStatus;
	}

	public void setOnBikeStatus(Boolean onBikeStatus) {
		this.onBikeStatus = onBikeStatus;
	}

	public Boolean getBulliedStatus() {
		return this.bulliedStatus;
	}

	public void setBulliedStatus(Boolean bulliedStatus) {
		this.bulliedStatus = bulliedStatus;
	}

	public Boolean getHasWind() {
		return this.hasWind;
	}

	public void setHasWind(Boolean hasWind) {
		this.hasWind = hasWind;
	}

	public PlayedCards getPlayedCards() {
		return playedCards;
	}
}
