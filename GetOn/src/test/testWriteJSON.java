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
		ArrayList <Player> players = new ArrayList <Player> (Arrays.asList(new Player("Tom"), 
																		new Player("Mark"), 
																		new Player("Kelly")));
		Stack stack = new Stack();
		
		stack.initializeStack();
		
		WriteJSON writer = new WriteJSON();
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
