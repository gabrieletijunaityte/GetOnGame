package test;

import logic.Card;
import logic.KilometerCard;
import logic.Stack;
import logic.StatusCard;
import utilities.Constant;

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

	// Test stack for testing
	public void testInitTestStack() {

		// Initialize test stack
		Stack testStack = new Stack();
		testStack.initializeTestStack();

		// Check the length
		assertEquals(19, testStack.getStackSize());

		// Draw the top card and check if it is a Get On card
		Card card = testStack.drawTopCard();
		Card topCard = new StatusCard(Constant.GET_ON);
		
		// Initialize target and test
		String target = card.getCardName();
		String test = topCard.getCardName();
		
		assertTrue(target.equals(test));
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
		Card topCard = new KilometerCard(Constant.FIVE);

		// Initialize target and test
		String target = topCard.getCardName();
		String test = card.getCardName();
		
		assertTrue(target.equals(test));
	}

	// Test clear
	public void testClear() {
		// Create a stack
		Stack stack = new Stack();
		stack.initializeStack();

		// clear the stack
		stack.clear();

		// check if length is zero
		assertEquals(0, stack.getStackSize());
	}

	// Test for getting Stack as ArrayList
	public void testGetStack() {

		// Initialize test stack
		Stack testStack = new Stack();

		// Add Cards to the Stack
		testStack.addDiscardedCard(new KilometerCard(Constant.FIVE));
		testStack.addDiscardedCard(new KilometerCard(Constant.SIX));

		// Initalize Test and Target
		ArrayList<Card> test = testStack.getStack();
		ArrayList<Card> target = new ArrayList<Card>(
				Arrays.asList(new KilometerCard(Constant.FIVE), new KilometerCard(Constant.SIX)));

		String testString =  test.toString();
		String targetString = target.toString();
		
		assertTrue(targetString.equals(testString));
	}

	// Test for adding discarded card to Stack
	public void testAddDiscardedCard() {

		// Initialize test stack
		Stack testStack = new Stack();

		// Add Card to the Stack
		testStack.addDiscardedCard(new KilometerCard(Constant.FIVE));

		// Initalize Test and Target
		ArrayList<Card> test = testStack.getStack();
		ArrayList<Card> target = new ArrayList<Card>(Arrays.asList(new KilometerCard(Constant.FIVE)));
		
		String testString =  test.toString();
		String targetString = target.toString();
		
		assertTrue(targetString.equals(testString));
		
	}

	// Test for getting a card at a specific index
	public void testGet() {

		// Initialize test stack
		Stack testStack = new Stack();

		// Add Cards to the Stack
		testStack.addDiscardedCard(new KilometerCard(Constant.FIVE));
		testStack.addDiscardedCard(new KilometerCard(Constant.SIX));

		// Initalize tests and targets
		Card test1 = testStack.get(0);
		Card target1 = new KilometerCard(Constant.FIVE);

		Card test2 = testStack.get(1);
		Card target2 = new KilometerCard(Constant.SIX);

		String testString1 =  test1.toString();
		String targetString1 = target1.toString();

		String testString2 =  test2.toString();
		String targetString2 = target2.toString();
		
		assertTrue(targetString1.equals(testString1));
		assertTrue(targetString2.equals(testString2));	
	}
}