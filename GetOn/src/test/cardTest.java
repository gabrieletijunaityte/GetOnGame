package test;

import logic.Card;
import logic.Type;
import logic.Value;
import junit.framework.TestCase;

public class cardTest extends TestCase {
	
	public void testCardCreation () {
		// Creating Card class
		Card card1 = new Card(Type.getType(0), Value.getValue(0));
		
		// asserting if it was created
		assertNotNull(card1);
	}
	
	Card card1 = new Card(Type.getType(0), Value.getValue(0));
	
	public void testgetValue() {
		// Testing getValue method
		Value test = card1.getValue();
		Value test1 = Value.getValue(0);
		
		assertEquals(test, test1);
	}
	
	public void testgetType() {
		// Testing getType method
		Type test = card1.getType();
		Type test1 = Type.getType(0);
		
		assertEquals(test, test1);
	}
	
	public void testgetCardName() {
		// Testing getCardNameMethod
		String test = card1.getCardName();
		String test1 = Type.getType(0) + "_" + Value.getValue(0);
		
		assertEquals(test, test1);		
	}
	
	
	
	
	
	


}
