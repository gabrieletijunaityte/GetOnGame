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
	private PlayerTable playerTable;
	private int kmProgress;
	private String bulliedType;
	private String windType;

	// Constructor
	public Player(String name, Boolean isTurn) {
		this.name = name;
		this.isTurn = true;
		this.hand = new ArrayList<>();
		this.onBikeStatus = false;
		this.bulliedStatus = false;
		this.hasWind = false;
		this.playerTable = new PlayerTable();
		this.kmProgress = 0;
		this.bulliedType = null;
		this.windType = null;
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
		 changeTurn();
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
	public void discardCard(Card discardedCard, Stack discardPile) {
		// Add the discarded card to the discardPile and remove the card from the hand

			// Add the discarded card to the discardPile
			discardPile.addDiscardedCard(discardedCard);
			// Remove the card from the hand
			hand.remove(discardedCard);

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

	public PlayerTable getPlayedCards() {
		return playerTable;
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
	
	// Select a card from the players hand, innitiate the play card method and remove the card from the players hand
	public void selectCard(Card card, Player bulliedPlayer, Stack stack, Stack discard) {
		card.playCard(bulliedPlayer, discard);
		this.hand.remove(card);
		this.drawCard(stack);
	}
	
	// get the players "Bully type" string
	public String getBulliedType() {
		return this.bulliedType;
	}
	
	// Set the "Bully Type" to a string
	public void setBulliedType(String bulliedType) {
		this.bulliedType = bulliedType;
	}
	
	// Get the players "hasWind" status
	public Boolean getWindStatus() {
		return this.hasWind;
	}
	
	// Get the players "WindType" string
	public String getWindType() {
		return this.windType;
	}
	
	// Set the players "WindType" string
	public void setWindType(String windType) {
		this.windType = windType;
	}
	
	// Method to retrieve all player statuses for card
	// playability check in rules
	public String[] getStatuses() {
		// In order:
			// GetOnStatus
			// BulliedStatus
			// hasWindStatus
			// Bullied type 
		String [] statuses = {String.valueOf(this.getOnBikeStatus()),
				String.valueOf(this.getBulliedStatus()),
				String.valueOf(this.getHasWind()),
				getBulliedType()};
		return statuses;
	}
}
