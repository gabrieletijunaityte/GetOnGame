package test;

import junit.framework.TestCase;
import logic.Rules;

public class RulesTest extends TestCase {

	// Testing the creation of the default rule object
	public void testRuleCreation() {
		
		Rules defaultRule = new Rules();
		assertNotNull(defaultRule);
		
	}
	
	// Testing the retrieving of the default rule object
	public void testGetRules() {
		
		Rules defaultRule = new Rules();
		String returned = defaultRule.getRules();
		assertNotNull(returned);
		System.out.println(returned);
		
	}
	
}
