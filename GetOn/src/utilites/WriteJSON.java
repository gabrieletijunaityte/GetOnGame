package utilites;

import logic.Player;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;

public class WriteJSON {
	private JSONArray playerList = new JSONArray();

	@SuppressWarnings("unchecked")
	public WriteJSON(ArrayList <Player> players) {
		for (Player player : players) {
			this.playerList.add(player);
		}

	}
	
	public void writePlayers() {
        //Write JSON file
        try (FileWriter file = new FileWriter("data/outputs/players.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(this.playerList.toJSONString()); 
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
