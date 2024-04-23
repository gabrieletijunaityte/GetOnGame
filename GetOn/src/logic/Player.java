package logic;

import java.util.ArrayList;

/**
 * The player class stores the player and the player's attributes. Attributes
 * stored in the class are: name, onBikeStatus, bulliedStatus, hasWind,
 * playerTable, kmProgress, bulliedType, windType, and hand. The player class
 * handles the names of the players and their current statuses.
 */
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

	/**
	 * Constructor of the player class
	 * 
	 * @param name - name of the player
	 */
	public Player(String name) {
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

	/**
	 * Method to change the player name
	 * 
	 * @param name - player's name
	 */
	public void changeName(String name) {
		this.name = name;
	}

	/**
	 * Method to get player's name
	 * 
	 * @return name - name of the player
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method to view the cards player has in their hand (as a string)
	 * 
	 * @return handCardsString - string with the cards in the hand
	 */
	public String viewHand() {
		ArrayList<String> handCards = new ArrayList<>();
		for (Card card : this.hand.getHand()) {
			handCards.add(card.getCardName());
		}
		String handCardsString = handCards.toString();
		return handCardsString;
	}

	/**
	 * Method to get status if the player is on bike
	 * 
	 * @return onBikeStatus boolean whether the player is on the bike or not
	 */
	public Boolean getOnBikeStatus() {
		return this.onBikeStatus;
	}

	/**
	 * Method to change the player "isOnBike" status
	 * 
	 * @param onBikeStatus - boolean whether the player is on the bike or not
	 */
	public void setOnBikeStatus(Boolean onBikeStatus) {
		this.onBikeStatus = onBikeStatus;
	}

	/**
	 * Method to get the player "bullied" status
	 * 
	 * @return bulliedStatus - boolean whether the player is bullied or not
	 */
	public Boolean getBulliedStatus() {
		return this.bulliedStatus;
	}

	/**
	 * Method to change the player "bullied" status
	 * 
	 * @param bulliedStatus - boolean whether the player is bullied or not
	 */
	public void setBulliedStatus(Boolean bulliedStatus) {
		this.bulliedStatus = bulliedStatus;
	}

	/**
	 * Method to get the player "hasWind" status
	 * 
	 * @return hasWind - boolean if the player has wind or not
	 */
	public Boolean getHasWind() {
		return this.hasWind;
	}

	/**
	 * Method to get the player "bullied" status
	 * 
	 * @param hasWind - boolean whether the player has wind or not
	 */
	public void setHasWind(Boolean hasWind) {
		this.hasWind = hasWind;
	}

	/**
	 * Method updates the player's kilometer progress
	 * 
	 * @param value - value of the card
	 */
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

	/**
	 * Method to get the played cards
	 * 
	 * @return PlayerTable - cards on the table
	 */
	public PlayerTable getPlayedCards() {
		return playerTable;
	}

	/**
	 * Method to get the kilometer progress
	 * 
	 * @return kmProgress - the progress of the player
	 */
	public int getKmProgress() {
		return this.kmProgress;
	}

	/**
	 * Method to get the players "Bully type" string
	 * 
	 * @return bulliedType - the bullied type
	 */
	public String getBulliedType() {
		return this.bulliedType;
	}

	/**
	 * Method to set the "Bully Type" to a string
	 * 
	 * @param bulliedType - specifies the type of the bullying
	 */
	public void setBulliedType(String bulliedType) {
		this.bulliedType = bulliedType;
	}

	/**
	 * Method to get the players "hasWind" status
	 * 
	 * @return hasWind - Boolean with the wind status
	 */
	public Boolean getWindStatus() {
		return this.hasWind;
	}

	/**
	 * Method to get the players "WindType" string
	 * 
	 * @return windtype - String with the windtype
	 */
	public String getWindType() {
		return this.windType;
	}

	/**
	 * Method to set the players "WindType" string
	 * 
	 * @param windType - the windtype for the players
	 */
	public void setWindType(String windType) {
		this.windType = windType;
	}

	/**
	 * Method to retrieve all player statuses for card playability check in rules
	 * 
	 * @return statuses - the statuses of the player
	 */
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
		for (int i = 0; i < consequences.length; i++) {
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

	/**
	 * Method to add cards to the hand
	 * 
	 * @param card - card that gets added to the hand
	 */
	public void drawCard(Card card) {
		this.hand.addCard(card);
	}

	/**
	 * This method gets the hand for the player
	 * 
	 * @return ArrayList<Card> - cards in the player's hand
	 */
	public ArrayList<Card> getHand() {
		return hand.getHand();
	}

	/**
	 * Method that gets the card based on the index
	 * 
	 * @param selectedCardIndex
	 * @return Card - the selected card
	 */
	public Card getCard(int selectedCardIndex) {
		return this.hand.get(selectedCardIndex);
	}

	/**
	 * Method to discard the card from the player's hand
	 * 
	 * @param card - the card the the player wants to discard
	 */
	public void discardCard(Card card) {
		this.hand.discardCard(card);
	}

	/**
	 * Method to add the selectedCard to the table
	 * 
	 * @param selectedCard - the card selected by the player
	 */
	public void addToTable(Card selectedCard) {
		this.playerTable.addCard(selectedCard);
	}

	/**
	 * Method to set the kilometerprogress
	 * 
	 * @param i - which is the kilometer's cycled
	 */
	public void setKmProgress(int i) {
		this.kmProgress = i;
	}
}
