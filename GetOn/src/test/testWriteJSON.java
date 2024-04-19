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
		ArrayList <Player> players = new ArrayList <Player> (Arrays.asList(new Player("Tom", true), 
																		new Player("Mark", false), 
																		new Player("Kelly", false)));
		
		Stack stack = new Stack();
		
		stack.initializeStack();
		
		WriteJSON writer = new WriteJSON(players, stack);
		writer.writePlayers("TestPlayers");	
		
		Boolean test = new File("data/outputs/TestPlayers.json").isFile();
		
		assertTrue(test);
	}
	
	// Testing card object to json 
	public void testWriteStack() {
		ArrayList <Player> players = new ArrayList <Player> (Arrays.asList(new Player("Tom", true), 
																		new Player("Mark", false), 
																		new Player("Kelly", false)));
		
		Stack stack = new Stack();
		
		stack.addDiscardedCard(new KilometerCard ("FIVE"));
		stack.addDiscardedCard(new KilometerCard ("SIX"));
		
		WriteJSON writer = new WriteJSON(players, stack);
		writer.writeStack("TestCards");	
		
		Boolean test = new File("data/outputs/TestCards.json").isFile();
		
		assertTrue(test);
	}

}
