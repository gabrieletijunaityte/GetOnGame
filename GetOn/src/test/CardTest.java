package test;

import logic.Card;
import junit.framework.TestCase;

public class CardTest extends TestCase {
	
	// Testing card creation
	public void testCardCreation () {
		// Setting the target
		String target1 = "Sample";
		String target2 = "Sample";
		
		// Creating Card class
		Card card = new Card(target1, target2);
		
		// Asserting if it was created
		assertNotNull(card);
	}

	// Test the type retrieval method
	public void testgetType() {
		
		// Setting the target
		String target1 = "Sample";
		String target2 = "Sample";
		
		// Creating Card class
		Card card = new Card(target1, target2);
		
		// Getting the type
		String test = card.getType();
		
		// Asserting if it is right type
		assertEquals(target1, test);
	}
	
		// Test the value retrieval method
		public void testgetValue() {
			
			// Setting the target
			String target1 = "Sample";
			String target2 = "Sample";
			
			// Creating Card class
			Card card = new Card(target1, target2);
			
			// Getting the type
			String test = card.getValue();
			
			// Asserting if it is right type
			assertEquals(target2, test);
	}
	
	// Test the getCardName() method
	public void testgetCardName() {
		// Setting the target
		String target1 = "Sample";
		String target2 = "Sample";
		
		// Creating Card class
		Card card = new Card(target1, target2);
		
		// Testing getCardNameMethod
		String test = card.getCardName();
		
		assertEquals(target1 + "_" + target2, test);		
	}
	
	// Test getPossibleValues
	public void testGetPossibleValues() {
		// Setting the target
		String target1 = "Sample";
		String target2 = "Sample";
		
		// Creating Card class
		Card card = new Card(target1, target2);
		
		// Testing getPossibleValues() method
		String [] test = card.getPossibleValues();
		
		assertEquals(null, test);		
	}
}
