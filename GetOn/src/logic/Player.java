package logic;

import java.util.ArrayList;

import javax.swing.JLabel;

import graphics.GameFrame;

import logic.Hand;

public class Player {


	private String name;
	private Boolean onBikeStatus;
	private Boolean bulliedStatus;
	private Boolean hasWind;
	private PlayerTable playerTable;
	private int kmProgress;
	private String bulliedType;
	private String windType;
	public Hand hand;

	// Constructor
	public Player(String name, Boolean isTurn) {
		this.name = name;
		this.onBikeStatus = false;
		this.bulliedStatus = false;
		this.hasWind = false;
		this.playerTable = new PlayerTable();
		this.kmProgress = 0;
		this.bulliedType = null;
		this.windType = null;
		this.hand = new Hand();
}

	// Method to change the player name
	public void changeName(String name) {
		this.name = name;
	}

	// Get player's name
	public String getName() {
		return name;
	}

	// View the cards player has in their hand (as a string)
	public String viewHand() {
		ArrayList<String> handCards = new ArrayList<>();
		for (Card card : this.hand.getHand()) {
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
