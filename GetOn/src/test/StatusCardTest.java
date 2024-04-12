package test;

import java.util.Arrays;

import junit.framework.TestCase;
import logic.KilometerCard;
import logic.Player;
import logic.RepairCard;
import logic.Stack;
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
		System.out.print(Arrays.toString(statusCard.getPossibleValues()));
		
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
	
	// Test isPlayable
	public void testIsPlayable() {
		// Creating Card class
		StatusCard card = new StatusCard("GET_ON");
		
		// Create test player
		Player testPlayer = new Player("Jan", true);
		
		testPlayer.setBulliedStatus(true);
		
		// Test boolean
		boolean target = false;
		
		boolean test = card.isPlayable(testPlayer);
		
		assertEquals(target, test);		
	}
	
	// ADD TEST FOR playCard()
	public void testPlayGetOnCard() {
		
		// creating dummy players
		Player targetPlayer = new Player("Gabby", false);
		
		// Create discard pile
		Stack discard = new Stack();
		
		// Creating a get on card
		StatusCard getOnCard = new StatusCard("GET_ON");
		
		// test playing the get on card
		getOnCard.playCard(targetPlayer, discard);
		
		boolean target = true;
		boolean test = targetPlayer.getOnBikeStatus();
		
		assertEquals(target, test);
	}
	
	public void testPlayWindsCard() {
		// creating dummy players
		Player targetPlayer = new Player("Gabby", false);
				
		// Create discard pile
		Stack discard = new Stack();
				
		// Creating a tail wind card
		StatusCard tailWindCard = new StatusCard("TAIL_WIND");
		
		// test playing the get on card
		tailWindCard.playCard(targetPlayer, discard);
		
		// 
		boolean target = true;
		boolean test = targetPlayer.getWindStatus();
		
		assertEquals(target, test);
		
		String target2 = "TAIL_WIND";
		String test2 = targetPlayer.getWindType();
		
		assertEquals(target2, test2);
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
}
