package game;
import logic.Card;
import logic.GameMaster;
import logic.Player;
import logic.Stack;
import logic.KilometerCard;

import java.util.ArrayList;
import java.util.Scanner;

import graphics.GameFrame;
import graphics.MainMenu;
import graphics.PlayerHand;

public class Game {

	public static void main(String[] args) {
		
		Player firstPlayer = new Player("", true), secondPlayer = new Player("", false), thirdPlayer = new Player("", false);
		
		
		// Launch the main menu
		MainMenu.main(args, firstPlayer, secondPlayer, thirdPlayer);
		
		// Initialize the stack
		Stack stack = new Stack();
		// Create 5 cards to test the set up
		stack.initializeStack();

		
		// See players hand:
		firstPlayer.drawCard(stack, 5);
		System.out.print("The player's hand contains: ");
		System.out.print(firstPlayer.viewHand());
		
		// Dummy discard pile:
		Stack discardPile = new Stack();
		
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
		//PlayerHand.main(args, firstPlayer.getHand());
		
		// Launch GameFrame GUI (Test)
		GameFrame.main(args);
		
	}

}