package test;

import java.util.Arrays;

import junit.framework.TestCase;
import logic.BullyCard;
import logic.KilometerCard;
import logic.Player;

public class BullyCardTest extends TestCase {


	// Test bully card creation
	public void testCreationOfbullyCard() {
		// Creating a bully card
		BullyCard bullyCard = new BullyCard("TAVERN");

		assertNotNull(bullyCard);
	}
	
	// Test bully card creation with invalid value
	public void testBadCreationOfbullyCard() {
		
		try {
			// Creating a bully card
			BullyCard bullyCard = new BullyCard("BAD_VALUE");
			fail();
		}
		catch (IllegalArgumentException e) {
		}
	}

	// Test the type retrieval method
	public void testgetType() {
		// Setting the target
		String target = "BULLY";

		// Creating a bully card
		BullyCard bullyCard = new BullyCard("TAVERN");

		// Getting the type
		String test = bullyCard.getType();

		// Asserting if it is right type
		assertEquals(target, test);
	}

	// Test the value retrieval method
	public void testgetValue() {
		// Setting the target
		String target = "TAVERN";

		// Creating a bully  card
		BullyCard bullyCard = new BullyCard(target);

		// Getting the type
		String test = bullyCard.getValue();

		// Asserting if it is right type
		assertEquals(target, test);
	}

// Test the getCardName() method
	public void testgetCardName() {
		// Setting the target
		String target = "TAVERN";
		String target1 = "BULLY_" + target;

		// Creating a bully card
		BullyCard bullyCard = new BullyCard(target);


		// Testing getCardNameMethod
		String test = bullyCard.getCardName();

		assertEquals(target1, test);
	}
	
	// Test getPossibleValues
	public void testGetPossibleValues() {
		// Creating Card class
		BullyCard bullyCard = new BullyCard("TAVERN");
		
		// Testing getCardNameMethod
		String test = Arrays.toString(bullyCard.getPossibleValues());
		System.out.print(Arrays.toString(bullyCard.getPossibleValues()));
		
		assertEquals("[TAVERN, CROSSWIND, FLAT_TIRE, CRISS_CROSS]", test);		
	}
	
	// Test getAmounts
	public void testGetAmounts() {
		// Creating Card class
		BullyCard card = new BullyCard("TAVERN");
		
		// Testing getAmounts
		String test = Arrays.toString(card.getAmounts());
		
		
		assertEquals("[2, 4, 3, 3]", test);		
	}
	
	// Test playing bully card
	public void testPlayCard() {
		// creating dummy players
		Player bulliedPlayer = new Player("Gabby", false);
		
		// Creating a bully card
		BullyCard bullyCard = new BullyCard("TAVERN");
		
		// Test playing bully card to Gabby
		bullyCard.playCard(bulliedPlayer);
		
		boolean target = true;
		boolean test = bulliedPlayer.getBulliedStatus();
		
		assertEquals(target, test);
		
		String test1 = bulliedPlayer.getPlayedCards().toString();
		assertNotNull(test1);
		
	}

}
