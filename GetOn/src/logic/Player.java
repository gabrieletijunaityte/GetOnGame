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
	private Hand hand;

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
	public void playerProgress(String value) {

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
		String[] statuses = { String.valueOf(this.getOnBikeStatus()), String.valueOf(this.getBulliedStatus()),
				String.valueOf(this.getHasWind()), getBulliedType() };
		return statuses;
	}

	// Implement set Consequences method
	public void setConsequences(String[] consequences) {
		for (int i = 0; i< consequences.length; i++) {
			switch (i) {
			case 0:
				if (!consequences[0].equals("-1")) {

					setOnBikeStatus(Boolean.valueOf(consequences[0]));
				}
				break;
			case 1:
				if (!consequences[1].equals("-1")) {
					setBulliedStatus(Boolean.valueOf(consequences[1]));
					// Reset bullied type to null if bullied status is set to false
                    if (!Boolean.valueOf(consequences[1])) {
                        setBulliedType(null);
                    }
				}
				break;
			case 2:
				if (!consequences[2].equals("-1")) {
					setHasWind(Boolean.valueOf(consequences[2]));
				}
				break;
			case 3:
				if (consequences[3] != null && !consequences[3].equals("-1")) {
                    setBulliedType(consequences[3]);
                }				
				break;
			case 4:
				if (!consequences[4].equals("-1")) {
					playerProgress(consequences[4]);
				}
			}
		}
	}
	
	// Add card to the hand
	public void drawCard(Card card) {
		this.hand.addCard(card);
	}
	
	public ArrayList<Card> getHand() {
		return hand.getHand();
	}

	public Card getCard(int selectedCardIndex) {
		return this.hand.get(selectedCardIndex);
	}
	
	public void discardCard(Card card) {
		this.hand.discardCard(card);
	}	
}
