package logic;

public enum Type {
	// Possible types
	kilometer,
	bully,
	defense,
	status;
	
	// Type attributes
	private static final Type[] type = Type.values();
	
	// Method to get type of card at index i
	public static Type getType(int i) {
		
		// Checking validity and throwing an error
		if (i >= 0 && i < type.length) {
			return Type.type[i];
		}
		else {
			throw new IllegalArgumentException("Index out of range for values of cards. Given " + i);
		}
		
	}

}
