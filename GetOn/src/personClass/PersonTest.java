package personClass;

import junit.framework.TestCase;

public class PersonTest extends TestCase {
	
	// testing the creation of person objects
	public void testCreation() {
		Person myName = new Person("Mirte", false);
		assertNotNull(myName);
	}
	
	// testing the name of person objects
	public void testGetName() {
		Person myName = new Person("Mirte", false);
		assertEquals("Mirte", myName.getName());	
	}
	
	// testing the isTurn of person objects
	public void testIsTurn() {
		Person myName = new Person("Mirte", true);
		assertEquals(true, myName.getTurn());
	}
	
	
}
