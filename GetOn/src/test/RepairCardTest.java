package test;

import java.util.Arrays;

import junit.framework.TestCase;
import logic.BullyCard;
import logic.KilometerCard;
import logic.Player;
import logic.RepairCard;
import logic.Card;
import logic.Stack;

public class RepairCardTest extends TestCase {
	// Test repair card creation
	public void testCreationOfrepairCard() {
		// Creating a repair card
		RepairCard repairCard = new RepairCard("BIKE_REPAIR");

		assertNotNull(repairCard);
	}

	// Test repair card creation with invalid value
	public void testBadCreationOfRepairCard() {

		try {
			// Creating a repair card
			RepairCard repairCard = new RepairCard("BAD_VALUE");
			fail();
		} catch (IllegalArgumentException e) {
		}
	}

	// Test the type retrieval method
	public void testgetType() {
		// Setting the target
		String target = "REPAIR";

		// Creating a repair card
		RepairCard repairCard = new RepairCard("BIKE_REPAIR");

		// Getting the type
		String test = repairCard.getType();

		// Asserting if it is right type
		assertEquals(target, test);
	}

	// Test the value retrieval method
	public void testgetValue() {
		// Setting the target
		String target = "BIKE_REPAIR";

		// Creating a repair card
		RepairCard repairCard = new RepairCard(target);

		// Getting the type
		String test = repairCard.getValue();

		// Asserting if it is right type
		assertEquals(target, test);
	}

// Test the getCardName() method
	public void testgetCardName() {
		// Setting the target
		String target = "BIKE_REPAIR";
		String target1 = "REPAIR_" + target;

		// Creating a repair card
		RepairCard repairCard = new RepairCard(target);

		// Testing getCardNameMethod
		String test = repairCard.getCardName();

		assertEquals(target1, test);
	}

	// Test getPossibleValues
	public void testGetPossibleValues() {
		// Creating Card class
		RepairCard repairCard = new RepairCard("BIKE_REPAIR");

		// Testing getCardNameMethod
		String test = Arrays.toString(repairCard.getPossibleValues());
		System.out.print(Arrays.toString(repairCard.getPossibleValues()));

		assertEquals("[BIKE_REPAIR, BARRIER_OPEN]", test);
	}

	// Test getAmounts
	public void testGetAmounts() {
		// Creating Card class
		RepairCard card = new RepairCard("BIKE_REPAIR");

		// Testing getAmounts
		String test = Arrays.toString(card.getAmounts());

		assertEquals("[8, 8]", test);
	}

	// Test isPlayable
	public void testIsPlayable() {
		// Creating Card class
		RepairCard repairCard = new RepairCard("BIKE_REPAIR");

		// Create player
		Player testPlayer = new Player("Jan", true);

		testPlayer.getPlayedCards().addCard(repairCard);

		// Testing isPlayable
		boolean test = false;

		boolean target = repairCard.isPlayable(testPlayer);

		assertEquals(target, test);

	}
	
	// Test playing repair card
		public void testPlayCard() {
			// creating dummy players
			Player targetPlayer = new Player("Gabby", false);
			
			// Creating a bully card
			BullyCard bullyCard = new BullyCard("FLAT_TIRE");
			
			// Create discard pile
			Stack discard = new Stack();
			
			// Test playing bully card to Gabby
			bullyCard.playCard(targetPlayer, discard);
			
			// Creating a repair card
			RepairCard repairCard = new RepairCard("BIKE_REPAIR");
			
			// Test playing bully card to Gabby
			repairCard.playCard(targetPlayer, discard);
			
			boolean target = false;
			boolean test = targetPlayer.getBulliedStatus();
			
			String target2 = "";
			String test2 = targetPlayer.getBulliedType();
			
			assertEquals(target, test);
			assertEquals(target2, test2);
		}
		
		// Test getRequirements
		public void testGetRequirements() {
			// Creating a statusCard 
			Card repairCard = new RepairCard("BIKE_REPAIR");
			String [] target =  {"-1", "true", "-1", "FLAT_TIRE", "-1"};
			
			// Testing getPossibleValues() method
			String [] test = repairCard.getRequirements();
			
			assertTrue(Arrays.equals(target, test));		
		}
		
		// Test getConsequences
		public void testGetConsequences() {
			// Creating a statusCard 
			Card repairCard = new RepairCard("BIKE_REPAIR");
			String [] target =  {"-1", "false", "-1", null, "-1"};
			
			// Testing getPossibleValues() method
			String [] test = repairCard.getConsequences();
			
			assertTrue(Arrays.equals(target, test));		
		}


}
