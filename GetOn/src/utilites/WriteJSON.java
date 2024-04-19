package utilites;

import logic.Card;
import logic.Player;
import logic.Stack;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
//import org.json.simple.JSONObject;

public class WriteJSON {
	private JSONArray playerList = new JSONArray();
	private JSONArray stack = new JSONArray();

	/**
	 * This method is a Constructor creating Writer JSON class object.
	 * 
	 * @param Players ArrayList of Players
	 * @parm StackObject Stack Class Object
	 */

	@SuppressWarnings("unchecked")
	public WriteJSON(ArrayList<Player> players, Stack stackObject) {
		for (Player player : players) {
			this.playerList.add(player);
		}
		// Add Card Information.
		addCardDetails(stackObject);
	}

	/**
	 * This method write JSON Array Players to file.
	 * 
	 * @param fileName fileName String Object specifying the fileName.
	 * @return Nothing.
	 * @serialData JSON file.
	 */
	public void writePlayers(String fileName) {
		// Write JSON file
		try (FileWriter file = new FileWriter("data/outputs/" + fileName + ".json")) {
			// We can write any JSONArray or JSONObject instance to the file
			file.write(this.playerList.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method adds cards and detials about them to the JSONArray of Stack
	 * 
	 * @param stackObject Stack Class Object
	 * @return Nothing.
	 */
	public void addCardDetails(Stack stackObject) {

		// Create Card Object
		Card cardObject;

		for (int i = 0; i < stackObject.getStackSize(); i++) {

			// Create JSON Objects for Card and Card Detials
			JSONObject card = new JSONObject();
			JSONObject cardDetails = new JSONObject();

			// Get Card from Stack
			cardObject = stackObject.get(i);

			// Put information of this card into Card Details
			cardDetails.put("type", cardObject.getType());
			cardDetails.put("value", cardObject.getValue());
			card.put("card", cardDetails);
			this.stack.add(card);
		}
	}

	/**
	 * This method write JSON Array Stack to file.
	 * 
	 * @param fileName String Object specifying the fileName
	 * @return Nothing.
	 * @serialData JSON file.
	 */
	public void writeStack(String fileName) {
		// Write JSON file
		try (FileWriter file = new FileWriter("data/outputs/" + fileName + ".json")) {
			// We can write any JSONArray or JSONObject instance to the file
			file.write(this.stack.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
