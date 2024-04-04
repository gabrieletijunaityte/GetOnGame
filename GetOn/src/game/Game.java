package game;
import logic.Card;
import logic.Player;
import logic.KilometerCard;

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
		stack.add(new KilometerCard("FIVE"));
		stack.add(new KilometerCard("SIX"));
		stack.add(new KilometerCard("TEN"));
		stack.add(new KilometerCard("EIGHT"));
		stack.add(new KilometerCard("SIX"));
		stack.add(new KilometerCard("FIVE"));
		
		// See players hand:
		firstPlayer.drawCard(stack, 5);
		System.out.print("The player's hand contains: ");
		System.out.print(firstPlayer.viewHand());
		
		
		// Dummy discard pile:
		ArrayList<Card> discardPile = new ArrayList<>();
		
		// Discard a chosen card:
		System.out.print("\n\nEnter which card (1-5) you want to discard: ");
		int discardIndex = input.nextInt() - 1;
		firstPlayer.discardCard(discardIndex, discardPile);
		
		// Draw card
		System.out.print("\nA new card was drawn from the pile:\n");
		firstPlayer.drawCard(stack);
		System.out.print(firstPlayer.getHand().get(4));
		System.out.print("\nThe player's hand now contains:\n");
		System.out.print(firstPlayer.viewHand());


	}

}
