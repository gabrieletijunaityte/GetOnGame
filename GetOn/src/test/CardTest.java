package test;

import logic.Card;
import java.util.Arrays;
import junit.framework.TestCase;

public class CardTest extends TestCase {

	// Testing card creation
	public void testCardCreation() {
		// Setting the target
		String target1 = "Sample";
		String target2 = "Sample";

		// Creating Card class
		Card card = new Card(target1, target2, new String [] {}, new int [] {});

		// Asserting if it was created
		assertNotNull(card);
	}

	// Test the type retrieval method
	public void testgetType() {
		// Setting the target
		String target1 = "Sample";
		String target2 = "Sample";

		// Creating Card class
		Card card = new Card(target1, target2, new String [] {}, new int [] {});

		// Getting the type
		String test = card.getType();

		// Asserting if it is right type
		assertTrue(target1.equals(test));
	}

	// Test the value retrieval method
	public void testgetValue() {
		// Setting the target
		String target1 = "Sample";
		String target2 = "Sample";

		// Creating Card class
		Card card = new Card(target1, target2, new String [] {}, new int [] {});

		// Getting the type
		String test = card.getValue();

		// Asserting if it is right value
		assertTrue(target2.equals(test));
	}

	// Test the getCardName() method
	public void testgetCardName() {
		// Setting the target
		String target1 = "Sample";
		String target2 = "Sample";

		// Creating Card class
		Card card = new Card(target1, target2, new String [] {}, new int [] {});

		// Testing getCardNameMethod
		String test = card.getCardName();

		assertTrue((target1 + "_" + target2).equals(test));
	}

	// Test getPossibleValues
	public void testGetPossibleValues() {
		// Setting the target
		String target1 = "Sample";
		String target2 = "Sample";

		// Creating Card class
		Card card = new Card(target1, target2, new String [] {}, new int [] {});

		// Testing getPossibleValues() method
		int test = card.getPossibleValues().length;

		assertEquals(0, test);
	}

	// Test getRequirements
	public void testGetRequirements() {
		// Creating Card class
		String typeSample = "Sample";
		String valueSample = "Sample";
		Card card = new Card(typeSample, valueSample, new String [] {}, new int [] {});

		// Setting the target
		String[] target = {};

		// Testing getPossibleValues() method
		String[] test = card.getRequirements();

		assertTrue(Arrays.equals(target, test));
	}

	// Test getConsequences
	public void testGetConsequences() {
		// Creating Card class
		String typeSample = "Sample";
		String valueSample = "Sample";
		Card card = new Card(typeSample, valueSample, new String [] {}, new int [] {});

		// Setting the target
		String[] target = {};

		// Testing getPossibleValues() method
		String[] test = card.getConsequences();

		assertTrue(Arrays.equals(target, test));
	}

	// Test the getCardNameToString() method
	public void testGetCardNameToString() {
		// Setting the target
		String target1 = "Sample";
		String target2 = "Sample";

		// Creating Card class
		Card card = new Card(target1, target2, new String [] {}, new int [] {});

		// Testing getCardNameMethod
		String test = card.toString();

		assertTrue((target1 + "_" + target2).equals(test));
	}
}
