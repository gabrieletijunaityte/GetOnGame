package test;

import java.util.Arrays;

import junit.framework.TestCase;
import logic.KilometerCard;
import utilities.Constant;
import logic.Card;

public class KilometerCardTest extends TestCase {

	// Test km card creation
	public void testCreationOfKmCard() {
		// Creating a km card
		KilometerCard kmCard = new KilometerCard(Constant.FIVE);

		assertNotNull(kmCard);
	}
	
	// Test bully card creation with invalid value
	public void testBadCreationOfKilometerCard() {
		try {
			// Creating a bully card
			KilometerCard kmCard = new KilometerCard("BAD_VALUE");
			fail();
		}
		catch (IllegalArgumentException e) {
		}
	}

	// Test the type retrieval method
	public void testgetType() {
		// Setting the target
		String target = Constant.KILOMETER;

		// Creating a km card
		KilometerCard kmCard = new KilometerCard(Constant.FIVE);

		// Getting the type
		String test = kmCard.getType();

		// Asserting if it is right type
		assertEquals(target, test);
	}

	// Test the value retrieval method
	public void testgetValue() {
		// Setting the target
		String target = Constant.FIVE;

		// Creating a km card
		KilometerCard kmCard = new KilometerCard(target);

		// Getting the type
		String test = kmCard.getValue();

		// Asserting if it is right type
		assertEquals(target, test);
	}

// Test the getCardName() method
	public void testgetCardName() {
		// Setting the target
		String target = Constant.FIVE;
		String target1 = Constant.KILOMETER + "_" + target;

		// Creating a km card
		KilometerCard kmCard = new KilometerCard(target);


		// Testing getCardNameMethod
		String test = kmCard.getCardName();

		assertEquals(target1, test);
	}
	
	// Test getPossibleValues
	public void testGetPossibleValues() {
		// Creating Card class
		KilometerCard kmCard = new KilometerCard(Constant.FIVE);
		
		// Testing getCardNameMethod
		String test = Arrays.toString(kmCard.getPossibleValues());
		String target = Arrays.toString(new String [] {Constant.FIVE, Constant.SIX, Constant.EIGHT, Constant.TEN});
		
		assertEquals(target, test);		
	}
	
	// Test getAmounts
	public void testGetAmounts() {
		// Creating Card class
		KilometerCard kmCard = new KilometerCard(Constant.FIVE);
		
		// Testing getAmounts
		String test = Arrays.toString(kmCard.getAmounts());
		String target = Arrays.toString(Constant.VALID_KM_AMOUNTS);
		
		assertEquals(target, test);		
	}
	
	// Test getRequirements
	public void testGetRequirements() {
		// Creating a kmCard
		Card kmCard = new KilometerCard(Constant.FIVE);
		String [] target = {Constant.TRUE, Constant.FALSE, Constant.IGNORE, Constant.IGNORE, "7"};
		
		// Testing getPossibleValues() method
		String [] test = kmCard.getRequirements();
		
		assertTrue(Arrays.equals(target, test));		
	}
	
	
	// Test getConsequences
	public void testGetConsequences() {
		// Creating a kmCard
		Card kmCard = new KilometerCard(Constant.FIVE);
		String [] target = {Constant.IGNORE, Constant.IGNORE, Constant.IGNORE, Constant.IGNORE, Constant.FIVE};
		
		// Testing getPossibleValues() method
		String [] test = kmCard.getConsequences();
		
		assertTrue(Arrays.equals(target, test));		
	}
}
