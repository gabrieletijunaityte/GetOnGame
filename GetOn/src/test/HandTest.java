package test;

import junit.framework.TestCase;
import logic.Hand;
import logic.Player;
import logic.Stack;

public class HandTest extends TestCase {

	// Test hand creation
	public void testCreateHand() {
		// Creating stack, hand, and player
		Stack stack = new Stack();
		stack.initializeStack();
		Hand myHand = new Hand();

		// Draw cards to the hand
		myHand.fillHand(stack, 5);

		// Test the method
		assertEquals(5, myHand.getHand().size());
	}

	// Test drawing cards from the stack
	public void testDrawCard() {
		// Creating stack, hand and player
		Stack stack = new Stack();
		stack.initializeStack();
		Hand myHand = new Hand();
		// Draw cards to the hand
		myHand.fillHand(stack, 6);
		// Test the method
		assertEquals(6, myHand.getHand().size());

		assertEquals(93, stack.getStackSize());

	}
	
	// Test adding cards to the discard pile
	public void testAddDiscardPile() {
		// Creating variables for the test
		Hand myHand = new Hand();
		Stack stack = new Stack();
		Stack discardPile = new Stack();

		// Create stack of cards to test the set up
		stack.initializeStack();

		// Create a hand
		myHand.fillHand(stack, 5);
		// Discard a card, parameter indicates the index of the card to be removed. this
		// is a dummy parameter.
		myHand.discardedCard(myHand.getHand().get(1), discardPile);		// test if the card is added to the discardPile
		assertEquals("KILOMETER_FIVE", discardPile.get(discardPile.getStackSize() - 1).getCardName());
	}
	

}
