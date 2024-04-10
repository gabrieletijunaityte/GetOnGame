package game;
import logic.Card;
import logic.GameMaster;
import logic.Player;
import logic.Stack;
import logic.KilometerCard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import graphics.GameFrame;
import graphics.MainMenu;
import graphics.PlayerHand;

public class Game {

	public static void main(String[] args) {
		
		Player firstPlayer = new Player("Player1", true), secondPlayer = new Player("Player2", false), thirdPlayer = new Player("Player3", false);
		
		
		// Initialize the stack
		Stack stack = new Stack();
		
		// Initialize discardPile
		Stack discardPile = new Stack();
		
		// Create 5 cards to test the set up
		stack.initializeStack();
		// Shuffle the stack
		stack.shuffle();
		
		// Initialize discardCardName for GUI
		String discardedCardName = null;
		
		// Deal cards
		firstPlayer.drawCard(stack, 5);
		secondPlayer.drawCard(stack, 5);
		thirdPlayer.drawCard(stack, 5);
		
		// Create an Array list with the players
		ArrayList <Player> players = new ArrayList<>(Arrays.asList(firstPlayer, secondPlayer, thirdPlayer));
		
		// Create gameContinue variable
		Boolean gameContinue = true;
		
		// Set current player index
		int playerIndex = 0;
		
		// Initiate a current player
		Player currentPlayer;
		
		// Initiate playerToBully
		Player playerToBully;
		
		// Initiate selected card
		Card selectedCard;
		
		// Initialize input listener
		Scanner input = new Scanner(System.in); 
		
		// Game loop
		while (gameContinue) {
			currentPlayer = players.get(playerIndex);
			System.out.println(currentPlayer.getName());
			
			// See players hand:
			System.out.print("The player's hand contains: ");
			System.out.print(currentPlayer.viewHand());
			
			// Discard a chosen card:
			System.out.print("\n\nEnter which card (1-5) you want to discard: ");
			int discardIndex = input.nextInt() - 1;
			
			selectedCard = currentPlayer.getHand().get(discardIndex);
			System.out.println("Selected card is ");	
			System.out.print(selectedCard);
			
			// Check card type and play it accordingly 
			if (selectedCard.getType() != "BULLY") {
				currentPlayer.selectCard(selectedCard, stack, discardPile);
			}
			else {
				// Create a dummy player to bully
				playerToBully = players.get(2);
				currentPlayer.selectCard(selectedCard, playerToBully, stack, discardPile);
			}

			System.out.print("\nThe player's hand now contains:\n");
			System.out.print(currentPlayer.viewHand());
			
			//System.out.println(discardPile.getStackSize());
			
			// Passing turn to next player or first player
			if (playerIndex == 2) {
				playerIndex = 0;
				gameContinue = false;
			}
			else {
				playerIndex ++;
			}
			
			// Check if card stack is empty and if so reshuffle discardPile
			if (stack.getStackSize() == 0) {
				stack = discardPile;
				stack.shuffle();
				discardPile.clear();
			}
		}
		
		
		
		
		// Get hand from player for GUI
		ArrayList<Card> hand = firstPlayer.getHand();
		
		// Launch the main menu
		//MainMenu.main(args, firstPlayer, secondPlayer, thirdPlayer, stack, discardedCardName, hand);
			
		
		
		// Add dicardCardName for GUI
//		discardedCardName = firstPlayer.discardCard(discardIndex, discardPile);
		
		// Test PlayerHand GUI, to be removed later
		//PlayerHand.main(args, firstPlayer.getHand());
		
		// Launch GameFrame GUI (Test)
		//GameFrame.main(args);
	
		
		
	}

}