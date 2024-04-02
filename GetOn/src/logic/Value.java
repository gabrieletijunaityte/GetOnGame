package logic;

public enum Value {
	// Possible types
	five, six, eight, ten,
	hostel,
	railroadCrossing,
	flatTire,
	crosswind,
	barrierOpen, 
	bikeRepair;
	
	// Type attributes
	private static final Value[] value = Value.values();
	
	// Method to get value of card at index i
	public static Value getValue(int i) {
		
		// Checking validity and throwing an error
		if (i >= 0 && i < value.length) {
			return Value.value[i];
		}
		else {
			throw new IllegalArgumentException("Index out of range for types of cards. Given " + i);
		}
		
	}


}
