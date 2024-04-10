package logic;

import java.util.ArrayList;

import javax.swing.JLabel;

import graphics.GameFrame;

public class Player {

	private ArrayList<Card> hand;
	private Boolean isTurn;
	private String name;
	private Boolean onBikeStatus;
	private Boolean bulliedStatus;
	private Boolean hasWind;
	private PlayedCards playedCards;
	private int kmProgress;
	private String bulliedType;

	// Constructor
	public Player(String name, Boolean isTurn) {
		this.name = name;
		this.isTurn = true;
		this.hand = new ArrayList<>();
		this.onBikeStatus = false;
		this.bulliedStatus = false;
		this.hasWind = false;
		this.playedCards = new PlayedCards();
		this.kmProgress = 0;
		this.bulliedType = null;
	}

	// Add card to the hand (only needed for testing)
	public void addCard(Card card) {
		// Add a card to the hand
		this.hand.add(card);
	}
	
	// Method to draw a single card
	public void drawCard(Stack stack) {
		
		// Add a card to the hand
		Card topCard = stack.drawTopCard();
		addCard(topCard);
		
		// Change turn after drawing a card
		// changeTurn();
	}

	// Method to change the player name
	public void changeName(String name) {
		this.name = name;
	}

	// Get player's name
	public String getName() {
		return name;
	}

	// Get the player game status (if it's their turn)
	public Boolean getTurn() {
		return this.isTurn;
	}

	// Change the player game status
	public void changeTurn() {
		if (isTurn) {
			this.isTurn = false;
		} else {
			this.isTurn = true;
		}
	}

	// Method to draw a specific amount of cards
	public void drawCard(Stack stack, int amount) {
		// Create a dummy hand
		// Get five cards
		ArrayList<Card> temp_hand = new ArrayList<>();

		for (int i = 0; i < amount; i++) {
			temp_hand.add(stack.drawTopCard());
		}
		this.hand = temp_hand;
	}

	// Method to discard a card
	public String discardCard(int i, Stack discardPile) {
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
			
			// Show the hand after the removal
			System.out.println("Current hand: " + viewHand());
			
			// return discard card to visualize in GUI
			return discardedCard.getCardName();
		}
		


		}



	// Get the hand as array list
	public ArrayList<Card> getHand() {
		return this.hand;
	}

	// View the cards player has in their hand (as a string)
	public String viewHand() {
		ArrayList<String> handCards = new ArrayList<>();
		for (Card card : this.hand) {
			handCards.add(card.getCardName());
		}
		String handCardsString = handCards.toString();
		return handCardsString;
	}

	// Get status if the player is on bike
	public Boolean getOnBikeStatus() {
		return this.onBikeStatus;
	}

	// Change the player "isOnBike" status
	public void setOnBikeStatus(Boolean onBikeStatus) {
		this.onBikeStatus = onBikeStatus;
	}

	// Get the player "bullied" status
	public Boolean getBulliedStatus() {
		return this.bulliedStatus;
	}

	// Change the player "bullied" status
	public void setBulliedStatus(Boolean bulliedStatus) {
		this.bulliedStatus = bulliedStatus;
	}

	// Get the player "hasWind" status
	public Boolean getHasWind() {
		return this.hasWind;
	}

	// Get the player "bullied" status
	public void setHasWind(Boolean hasWind) {
		this.hasWind = hasWind;
	}

	// This method updates the player's kilometer progress
	public void playerProgress(Card card) {
		// Check if the object is of KilometerCard
		if (card instanceof KilometerCard) {
			// Obtain the kilometer value
			String value = card.getValue();
			switch (value) {
			case "FIVE":
				this.kmProgress += 5;
				break;
			case "SIX":
				this.kmProgress += 6;
				break;
			case "EIGHT":
				this.kmProgress += 8;
				break;
			case "TEN":
				this.kmProgress += 10;
				break;
			// If the card is not one of these four cards, nothing "default" is triggered
			// and nothing happens
			default:
				break;
			}
		} else {
			throw new IllegalArgumentException("Method works with Kilometer cards only");
		}
	}

	public PlayedCards getPlayedCards() {
		return playedCards;
	}

	public int getKmProgress() {
		return this.kmProgress;
	}
	
	public void selectCard(Card card, Stack stack, Stack discard) {
		// play the selected card
		card.playCard(this, discard);
		
		// remove the card from the hand
		this.hand.remove(card);
		
		// draw a card from a pile and change turn
		drawCard(stack);
	}

	public void selectCard(BullyCard card, Player bulliedPlayer, Stack stack, Stack discard) {
		card.playCard(bulliedPlayer, discard);
		this.hand.remove(card);
		this.drawCard(stack);
	}
	
	public String getBulliedType() {
		return this.bulliedType;
	}
	public void setBulliedType(String bulliedType) {
		this.bulliedType = bulliedType;
	}
}
