package logic;

public class Spectator {

	public String viewRules() {
		Rules rules = new Rules();
		String rulesOut = rules.getRules();
		return rulesOut;
	}

}
