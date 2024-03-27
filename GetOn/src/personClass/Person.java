package personClass;

public class Person {
	// instance fields
	private String name;
	protected boolean isTurn;
	
	// constructor for initialising the name
	public Person(String name, boolean turn) {
		this.name = name;
		this.isTurn = turn;
	}
	
	// function to return the name
	public String getName() {
		return this.name;
	}
	

	// function to return isTurn
	public Object getTurn() {
		return this.isTurn;
	}
	
	public static void main(String[] args) {
	}
}
