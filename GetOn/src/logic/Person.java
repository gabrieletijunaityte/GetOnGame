package logic;

public class Person {
	// instance fields
	protected String name;
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
	
	// create player subclass
	public class Player extends Person{
		
		// constructor for the player subclass that takes parameters from the superclass
		public Player(Person person) {
			super(person.name, person.isTurn);
		}
		
	}
	
	// create Spectator subclass
	public class Spectator extends Person{
		
		// constructor for the spectator subclass that takes parameters from the superclass
		public Spectator(Person person) {
			super(person.name, person.isTurn);
		}
		
	}
	
	// create GameMaster subclass
	public class GameMaster extends Person{
		
		// constructor for the gamemaster subclass that takes parameters from the superclass
		public GameMaster(Person person) {
			super(person.name, person.isTurn);
		}
		
	}
	
	public static void main(String[] args) {
	}
}
