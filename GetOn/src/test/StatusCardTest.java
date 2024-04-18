package test;

import java.util.Arrays;

import junit.framework.TestCase;
import logic.Card;
import logic.StatusCard;

public class StatusCardTest extends TestCase {


	// Test status card creation
	public void testCreationOfstatusCard() {
		// Creating a status card
		StatusCard statusCard = new StatusCard("GET_ON");

		assertNotNull(statusCard);
	}
	
	// Test status card creation with invalid value
	public void testBadCreationOfStatusCard() {
		
		try {
			// Creating a repair card
			StatusCard statusCard = new StatusCard("BAD_VALUE");
			fail();
		}
		catch (IllegalArgumentException e) {
		}
	}

	// Test the type retrieval method
	public void testgetType() {
		// Setting the target
		String target = "STATUS";

		// Creating a status card
		StatusCard statusCard = new StatusCard("GET_ON");

		// Getting the type
		String test = statusCard.getType();

		// Asserting if it is right type
		assertEquals(target, test);
	}

	// Test the value retrieval method
	public void testgetValue() {
		// Setting the target
		String target = "GET_ON";

		// Creating a status  card
		StatusCard statusCard = new StatusCard(target);

		// Getting the type
		String test = statusCard.getValue();

		// Asserting if it is right type
		assertEquals(target, test);
	}

// Test the getCardName() method
	public void testgetCardName() {
		// Setting the target
		String target = "GET_ON";
		String target1 = "STATUS_" + target;

		// Creating a status card
		StatusCard statusCard = new StatusCard(target);


		// Testing getCardNameMethod
		String test = statusCard.getCardName();

		assertEquals(target1, test);
	}
	
	// Test getPossibleValues
	public void testGetPossibleValues() {
		// Creating Card class
		StatusCard statusCard = new StatusCard("GET_ON");
		
		// Testing getCardNameMethod
		String test = Arrays.toString(statusCard.getPossibleValues());
		
		assertEquals("[GET_ON, TAIL_WIND]", test);		
	}
	
	// Test getAmounts
	public void testGetAmounts() {
		// Creating Card class
		StatusCard card = new StatusCard("GET_ON");
		
		// Testing getAmounts
		String test = Arrays.toString(card.getAmounts());
		
		
		assertEquals("[14, 5]", test);		
	}
	
	// Test getRequirements
	public void testGetRequirements() {
		// Creating a statusCard 
		Card statusCard = new StatusCard("TAIL_WIND");
		String [] target = {"-1", "-1", "-1", "-1", "-1"};
		
		// Testing getPossibleValues() method
		String [] test = statusCard.getRequirements();
		
		assertTrue(Arrays.equals(target, test));		
	}
	
	
	// Test getConsequences for GET_ON
	public void testGetConsequencesCaseA() {
		// Creating a statusCard 
		Card statusCard = new StatusCard("GET_ON");
		String [] target = {"true", "-1", "-1", "-1", "-1"};
		
		// Testing getPossibleValues() method
		String [] test = statusCard.getConsequences();
		
		assertTrue(Arrays.equals(target, test));		
	}
	
	
	// Test getConsequences for TAIL_WIND
	public void testGetConsequencesCaseB() {
		// Creating a statusCard 
		Card statusCard = new StatusCard("TAIL_WIND");
		String [] target = {"-1", "-1", "true", "-1", "-1"};
		
		// Testing getPossibleValues() method
		String [] test = statusCard.getConsequences();
		
		assertTrue(Arrays.equals(target, test));		
	}
}
