package test;

import logic.Card;
import logic.KilometerCard;
import logic.Stack;
import logic.StatusCard;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;

public class StackTest extends TestCase {
	// Test to see if a Stack is created
	public void testStackCreation() {
		// Create deck
		Stack stack = new Stack();
		stack.initializeStack();

		// Assert if the deck is created
		assertNotNull(stack);
	}

	// Test to see if the length of the Stack is equal to 99
	public void testStackSize() {
		// Create a stack
		Stack stack = new Stack();
		stack.initializeStack();

		// Check if the size of the stack is 99
		assertEquals(99, stack.getStackSize());
	}

	// Test to see if the stack is shuffled
	public void testShuffle() {
		// Create 2 stacks
		Stack stack = new Stack();
		Stack stack2 = new Stack();
		stack.initializeStack();
		stack2.initializeStack();

		// Shuffle one stack
		stack.shuffle();

		// Check if the stacks are still the same size
		assertEquals(stack.getStackSize(), stack2.getStackSize());

		// Check if the stacks are not equals
		assertFalse(stack.equals(stack2));
	}

	// Test drawCard from the stack
	public void testDrawTopCard() {
		// Create a stack
		Stack stack = new Stack();
		stack.initializeStack();

		// Draw a card from the stack
		Card card = stack.drawTopCard();
		// topCard is kilometer five because stack is not shuffled
		Card topCard = new KilometerCard("FIVE");

		// Assert drawn card is equal to topCard
		assertEquals(topCard.getCardName(), card.getCardName());
	}

	// Test clear()
	public void testClear() {
		// Create a stack
		Stack stack = new Stack();
		stack.initializeStack();

		// clear the stack
		stack.clear();

		// check if length is zero
		assertEquals(0, stack.getStackSize());
	}

	// Test stack for testing
	public void testInitTestStack() {

		// Initialze teststack
		Stack testStack = new Stack();
		testStack.initializeTestStack();
		
		//Check the length
		assertEquals(19,testStack.getStackSize());

		// Draw the top card and check if it is a Get On card
		Card card = testStack.drawTopCard();
		Card topCard = new StatusCard("GET_ON");
		assertEquals(card.getCardName(), topCard.getCardName());

	}

	// Test for getting Stack as ArrayList
	public void testgetStack() {
		
		// Initialze teststack
		Stack testStack = new Stack();
		
		testStack.addDiscardedCard(new KilometerCard ("FIVE"));
		testStack.addDiscardedCard(new KilometerCard ("SIX"));
		ArrayList<Card> test = testStack.getStack();
		ArrayList<Card> target = new ArrayList<Card> (Arrays.asList(new KilometerCard ("FIVE"), new KilometerCard ("SIX")));
		
		assertEquals(target.toString(), test.toString());
		
		

	}

}
