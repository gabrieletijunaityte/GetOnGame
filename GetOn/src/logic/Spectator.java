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

	// Get the stack size from the Stack class
	public int getStackSize(Stack stack) {
	    return stack.getStackSize();
	}
	
	// View the player's progress from the Spectator class
	public int getProgress(Player player) {
        return player.getKmProgress();
    }
	
}
