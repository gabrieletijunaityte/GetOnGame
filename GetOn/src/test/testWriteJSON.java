package test;
import logic.Player;
import utilites.WriteJSON;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;

public class testWriteJSON extends TestCase {
	
	// Testing player object to json 
	public void testWritePlayers() {
		ArrayList <Player> players = new ArrayList <Player> (Arrays.asList(new Player("Tom", true), 
																		new Player("Mark", false), 
																		new Player("Kelly", false)));
		
		WriteJSON writer = new WriteJSON(players);
		writer.writePlayers();	
		
		Boolean test = new File("data/outputs/players.json").isFile();
		
		assertTrue(test);
	}

}
