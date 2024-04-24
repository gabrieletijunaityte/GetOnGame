package utilities;

/**
 * A class containing all the symbolic constants for fixed values
 */
public class Constant {    
    // Fixed string values for card types
    public static final String KILOMETER = "KILOMETER";
    public static final String BULLY = "BULLY";
    public static final String REPAIR = "REPAIR";
    public static final String STATUS = "STATUS";
    
    // Fixed Strings values for km values
    public static final String FIVE = "FIVE";
    public static final String SIX = "SIX";
    public static final String EIGHT = "EIGHT";
    public static final String TEN = "TEN";

    // Fixed strings values for bully card values
    public static final String TAVERN = "TAVERN";
    public static final String FLAT_TIRE = "FLAT_TIRE";
    public static final String CROSSWIND = "CROSSWIND";
    public static final String CRISS_CROSS = "CRISS_CROSS";
    
    // Fixed strings values for repair card values
    public static final String BIKE_REPAIR = "BIKE_REPAIR";
    public static final String BARRIER_OPEN = "BARRIER_OPEN";
    
    // Fixed strings values for status card values
    public static final String GET_ON = "GET_ON";
    public static final String TAIL_WIND = "TAIL_WIND";
    
    // Fixed values for arbitrary values, 
    	// e.g. for implementing logic in requirements
    public static final String TRUE = "true";
    public static final String FALSE = "false";
    public static final String IGNORE = "-1";
    
    // Possible value arrays
    public static final String[] VALID_BULLY_VALUES = new String[] {TAVERN, CROSSWIND, FLAT_TIRE, CRISS_CROSS};
    public static final String[] VALID_KM_VALUES = new String[] {FIVE, SIX, EIGHT, TEN};
    
    public static final int[] VALID_BULLY_AMOUNTS = new int[] {2, 4, 3, 3 };
    public static final int[] VALID_KM_AMOUNTS = new int[] { 24, 12, 8, 8 };
}
