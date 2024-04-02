package game;
import logic.Card;
import logic.Player;
import logic.Type;
import logic.Value;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); 
		System.out.print("Enter player name: ");
		String playerName = input.next(); 
		
		Player firstPlayer = new Player(playerName, true);
		
		// Dummy stack
		
		ArrayList<Card> stack = new ArrayList<>();
		
		// Create 5 cards to test the set up
		stack.add(new Card(Type.getType(0), Value.getValue(0)));
		stack.add(new Card(Type.getType(1), Value.getValue(1)));
		stack.add(new Card(Type.getType(2), Value.getValue(0)));
		stack.add(new Card(Type.getType(0), Value.getValue(1)));
		stack.add(new Card(Type.getType(0), Value.getValue(1)));
		stack.add(new Card(Type.getType(1), Value.getValue(0)));
		
		// See players hand:
		firstPlayer.drawCard(stack, 5);
		System.out.print("The player's hand contains: ");
		System.out.print(firstPlayer.viewHand());
		

	}

}
