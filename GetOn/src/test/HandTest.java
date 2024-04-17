package test;

import java.util.Arrays;

import junit.framework.TestCase;
import logic.Hand;
import logic.Player;
import logic.Stack;

public class HandTest extends TestCase {

	// Test hand creation
	public void testCreateHand() {
		// Creating stack, hand, and player
		Hand myHand = new Hand();

		// Test the method
		assertNotNull(myHand);
	}

	// Test drawing cards from the stack
	public void testAddCard() {
		// Creating stack, hand and player
		Stack stack = new Stack();
		stack.initializeStack();
		Hand myHand = new Hand();
		// Draw cards to the hand
		myHand.addCard(stack.drawTopCard());
		// Test the method
		assertEquals(1, myHand.getHand().size());

		assertEquals(98, stack.getStackSize());

	}

	// Test adding cards to the discard pile
	public void testGet() {
		// Creating variables for the test
		Hand myHand = new Hand();
		Stack stack = new Stack();

		// Create stack of cards to test the set up
		stack.initializeStack();

		// Create a hand
		myHand.addCard(stack.drawTopCard());

		assertEquals("KILOMETER_FIVE", myHand.get(0).toString());
	}

	// Test getting the hand
	public void testGetHand() {
		// Creating variables for the test
		Hand myHand = new Hand();
		Stack stack = new Stack();

		// Create stack of cards to test the set up
		stack.initializeStack();
		
		// Add 5 cards
		myHand.addCard(stack.drawTopCard());
		myHand.addCard(stack.drawTopCard());
		myHand.addCard(stack.drawTopCard());
		myHand.addCard(stack.drawTopCard());
		myHand.addCard(stack.drawTopCard());
		
		String target = "[KILOMETER_FIVE, KILOMETER_FIVE, KILOMETER_FIVE, KILOMETER_FIVE, KILOMETER_FIVE]";
		String test = myHand.getHand().toString();
		
		assertEquals(target, test);
	}

}
