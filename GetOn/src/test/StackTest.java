package test;

import logic.Card;
import logic.Stack;

import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

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

}
