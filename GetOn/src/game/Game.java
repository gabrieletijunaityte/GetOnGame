package game;
import logic.Card;
import logic.GameMaster;
import logic.Player;
import logic.Type;
import logic.Value;

import java.util.ArrayList;
import java.util.Scanner;

import graphics.PlayerHand;

public class Game {

	public static void main(String[] args) {
		
		// Create firstplayer with default name and change it with changeName method
		Player firstPlayer = new Player("Player1", true);
		GameMaster.changeName(firstPlayer);
		
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
		
		// Dummy discard pile:
		ArrayList<Card> discardPile = new ArrayList<>();
		
		// Discard a chosen card:
		Scanner input = new Scanner(System.in); 
		System.out.print("\n\nEnter which card (1-5) you want to discard: ");
		int discardIndex = input.nextInt() - 1;
		firstPlayer.discardCard(discardIndex, discardPile);
		
		
		// Draw card
		System.out.print("\nA new card was drawn from the pile:\n");
		firstPlayer.drawCard(stack);
		System.out.print(firstPlayer.getHand().get(4));
		System.out.print("\nThe player's hand now contains:\n");

		// Test PlayerHand GUI, to be removed later
		PlayerHand.main(args, firstPlayer.getHand());
		
	}

}
