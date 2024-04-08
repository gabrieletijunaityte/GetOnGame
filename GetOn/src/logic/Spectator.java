package logic;

// Create spectator class
public class Spectator {

	/* Method to create a rules object, and use getRules() from the Rules Class
	to get the rules and return them*/
	public String viewRules() {
		Rules rules = new Rules();
		String rulesOut = rules.getRules();
		return rulesOut;
	}
	
	public int viewStackSize(Stack stack) {
		return stack.getStackSize();
	}

}
