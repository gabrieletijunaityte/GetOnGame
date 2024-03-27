package personClass;

import junit.framework.TestCase;

public class PersonTest extends TestCase {
	
	// testing the creation of person objects
	public void testCreation() {
		Person myName = new Person("Mirte");
		assertNotNull(myName);
	}
	
	// testing the name of person objects
	public void testGetName() {
		Person myName = new Person("Mirte");
		assertEquals("Mirte", myName.getName());	
	}
	
	
}
