package utilites;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import logic.Card;
import logic.Player;

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
			JSONObject playerInformation = new JSONObject();
			
			// Put player name information
			playerInformation.put("Name", playerObject.getName());

			// Put information of this card into Card Details
			String[] statuses = playerObject.getStatuses();
			statusDetails.put("GetOnStatus", statuses[0]);
			statusDetails.put("BulliedStatus", statuses[1]);
			statusDetails.put("HasWind", statuses[2]);
			statusDetails.put("BullyType", statuses[3]);
			playerInformation.put("Statuses", statusDetails);
			
			

			JSONArray playerHand = addCards(playerObject.getHand()); // Pass the playerCards list

			// Create a new list of cards for each player
			playerInformation.put("Hand", playerHand);

			JSONArray playerTable = addCards(playerObject.getPlayedCards().getPlayedCards());
			playerInformation.put("Table", playerTable);

			playerList.add(playerInformation);
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

	/**
	 * Method that collects all game variables and saves it to JSON file with a given name
	 * 
	 * @param fileName  - string value of desired file name
	 * @param stack - stack class object containing unplayed cards
	 * @param discardPile - stack class object containing played/discarded cards
	 * @param players - arrayList of player class objects, containing active players and their information
	 * @param currentPlayerIndex - index value of the current player whos turn will be next if game would be reloaded
	 */
	public void writeGame(String fileName, ArrayList<Card> stack, ArrayList<Card> discardPile, ArrayList<Player> players, int currentPlayerIndex) {
		// Create game JSON array and objects (for labels)
		JSONArray gameJSON = new JSONArray();
		JSONObject objects = new JSONObject();
		
		// Create player JSON object and add it to objects
		JSONArray playersJSON = addPlayer(players);
		objects.put("Players", playersJSON);
		
		// Create stack JSON object and add it to objects
		JSONArray stackJSON = addCards(stack);
		objects.put("Stack", stackJSON);
		
		// Create discard ile JSON object and add it to objects
		JSONArray discardPileJSON = addCards(discardPile);
		objects.put("DiscardPile", discardPileJSON);
		
		// Add currentPlayer index to object		
		objects.put("CurrentIndex", currentPlayerIndex);

		// Add objects to array
		gameJSON.add(objects);
		
		// Write it to the file
		writeJSON(fileName, gameJSON);
	}
}
