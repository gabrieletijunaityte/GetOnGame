package logic;



public class KilometerCard extends Card {
	// Possible km values
	private String [] pos_values = {"FIVE", "SIX", "EIGHT", "TEN"};
	
	// Constructor
	public KilometerCard (String value) {

		super("KILOMETER", value);
		
	}
	
	// Method to retrieve possible km values
	public String[] getPossibleValues() {        
        return this.pos_values;
		
	}
}


