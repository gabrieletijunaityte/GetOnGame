package test;
import logic.KilometerCard;
import logic.Player;
import logic.Stack;
import utilites.WriteJSON;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;

public class testWriteJSON extends TestCase {
	
	// Testing player object to json 
	public void testWritePlayers() {
		// Create players
		ArrayList <Player> players = new ArrayList <Player> (Arrays.asList(new Player("Tom"), 
																		new Player("Mark"), 
																		new Player("Kelly")));
		
		// Create and initialise stack
		Stack stack = new Stack();
		stack.initializeStack();
		stack.shuffle();
		
		// Give players 5 cards each
		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < players.size(); i++) {
				players.get(i).drawCard(stack.drawTopCard());
			}
		}
		players.get(1).setOnBikeStatus(true);
		players.get(1).addToTable(new KilometerCard("FIVE"));
		
		// Initialise writer;
		WriteJSON writer = new WriteJSON();
		
		// Write the file
		writer.writePlayers("TestPlayers", players);
		
		Boolean test = new File("data/outputs/TestPlayers.json").isFile();
		
		assertTrue(test);
	}
	
	// Testing card object to json 
	public void testWriteStack() {
		ArrayList <Player> players = new ArrayList <Player> (Arrays.asList(new Player("Tom"), 
																		new Player("Mark"), 
																		new Player("Kelly")));
		
		Stack stack = new Stack();
		
		stack.addDiscardedCard(new KilometerCard ("FIVE"));
		stack.addDiscardedCard(new KilometerCard ("SIX"));
		
		WriteJSON writer = new WriteJSON();
		writer.writeCards("TestCards", stack.getStack());	
		
		Boolean test = new File("data/outputs/TestCards.json").isFile();
		
		assertTrue(test);
	}
}
