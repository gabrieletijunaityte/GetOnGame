package utilites;

import logic.Card;
import logic.Player;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * This class creates JSON files for saving the game state
 */
public class WriteJSON {

	/**
	 * This method is a Constructor creating Writer JSON class object.
	 * 
	 * @param Players     ArrayList of Players
	 * @param StackObject Stack Class Object
	 */
	@SuppressWarnings("unchecked")
	public WriteJSON() {
	}

	/**
	 * This method write JSON Array Players to file.
	 * 
	 * @param fileName fileName String Object specifying the fileName.
	 * @return Nothing.
	 * @serialData JSON file.
	 */
	public void writePlayers(String fileName, ArrayList<Player> players) {
		JSONArray playerList = addPlayer(players);
		writeJSON(fileName, playerList);
	}

	/**
	 * This method adds players to playersList JSON array
	 * 
	 * @param players - Array list of players
	 */
	private JSONArray addPlayer(ArrayList<Player> players) {
		JSONArray playerList = new JSONArray();
		for (Player playerObject : players) {
			JSONObject statusDetails = new JSONObject();
			JSONObject playerStatuses = new JSONObject();

			// Put information of this card into Card Details
			String[] statuses = playerObject.getStatuses();
			statusDetails.put("GetOnStatus", statuses[0]);
			statusDetails.put("BulliedStatus", statuses[1]);
			statusDetails.put("HasWind", statuses[2]);
			statusDetails.put("BullyType", statuses[3]);
			playerStatuses.put("Statuses", statusDetails);

			JSONArray playerHand = addCards(playerObject.getHand()); // Pass the playerCards list

			// Create a new list of cards for each player
			playerStatuses.put("Hand", playerHand);

			JSONArray playerTable = addCards(playerObject.getPlayedCards().getPlayedCards());
			playerStatuses.put("Table", playerTable);

			playerList.add(playerStatuses);
		}
		return playerList;
	}

	/**
	 * This method adds cards and details about them to the JSONArray of Stack
	 * 
	 * @param cards Stack Class Object
	 * @return Nothing.
	 */
	public JSONArray addCards(ArrayList<Card> cards) {
		// Create a new list of cards for each player
		JSONArray playerCards = new JSONArray();
		for (Card cardObject : cards) {
			// Create JSON Objects for Card and Card Details
			JSONObject card = new JSONObject();
			JSONObject cardDetails = new JSONObject();

			// Put information of this card into Card Details
			cardDetails.put("type", cardObject.getType());
			cardDetails.put("value", cardObject.getValue());
			card.put("card", cardDetails);
			playerCards.add(card); // Add the card to the playerCards list
		}
		return playerCards;
	}

	/**
	 * This method write JSON Array Stack to file.
	 * 
	 * @param fileName - String Object specifying the fileName
	 * @return Nothing.
	 */
	public void writeCards(String fileName, ArrayList<Card> cards) {
		JSONArray cardsJSON = addCards(cards);
		writeJSON(fileName, cardsJSON);
	}

	/**
	 * A method that writes a given JSONArray into a file
	 * @param fileName - string name for a file name
	 * @param arrayJSON - JSONArray object to be saved in the file
	 * @serialData JSON file.
	 */
	private void writeJSON(String fileName, JSONArray arrayJSON) {
		if (!new File("data/outputs").isFile()) {
			new File("data/outputs").mkdirs();
		}
		// Write JSON file
		try (FileWriter file = new FileWriter("data/outputs/" + fileName + ".json")) {
			// We can write any JSONArray or JSONObject instance to the file
			file.write(arrayJSON.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
