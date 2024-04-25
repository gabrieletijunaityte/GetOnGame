package test;
import logic.KilometerCard;
import logic.Player;
import logic.Stack;
import utilities.Constant;
import utilities.WriteJSON;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;

public class WriteJSONTest extends TestCase {
	
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
		players.get(1).addToTable(new KilometerCard(Constant.FIVE));
		
		// Initialise writer;
		WriteJSON writer = new WriteJSON();
		
		// Write the file
		writer.writePlayers("TestPlayers", players);
		
		Boolean test = new File("data/outputs/TestPlayers.json").isFile();
		
		assertTrue(test);
	}
	
	// Testing card object to json 
	public void testWriteStack() {	
		Stack stack = new Stack();
		
		stack.addDiscardedCard(new KilometerCard (Constant.FIVE));
		stack.addDiscardedCard(new KilometerCard (Constant.SIX));
		
		WriteJSON writer = new WriteJSON();
		writer.writeCards("TestCards", stack.getStack());	
		
		Boolean test = new File("data/outputs/TestCards.json").isFile();
		
		assertTrue(test);
	}
	
	// Testing the whole game saving
	public void testWriteGame() {
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
		// Change status of 1st player
		players.get(1).setOnBikeStatus(true);
		
		// Add card to table
		players.get(1).addToTable(new KilometerCard(Constant.FIVE));
		
		// Create and initialise discard pile
		Stack discardPile = new Stack();
		discardPile.addDiscardedCard(new KilometerCard (Constant.FIVE));
		discardPile.addDiscardedCard(new KilometerCard (Constant.SIX));
		
		// Initialise writer;
		WriteJSON writer = new WriteJSON();
		
		writer.writeGame("TestGame", stack.getStack(), discardPile.getStack(), players, 2);	
		
		Boolean test = new File("data/outputs/TestGame.json").isFile();
		
		assertTrue(test);
	}
}
