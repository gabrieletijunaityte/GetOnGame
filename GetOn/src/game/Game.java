package game;
import logic.Card;
import logic.GameMaster;
import logic.Player;
import logic.Rules;
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
		
		// Intialize rules
		Rules rules = new Rules();
		
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
		firstPlayer.hand.fillHand(stack, 5);
		secondPlayer.hand.fillHand(stack, 5);
		thirdPlayer.hand.fillHand(stack, 5);
		
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
		
		// Intialize drawn cards
		Card drawnCard;
		
		
		// Game loop
		while (gameContinue) {
			currentPlayer = players.get(playerIndex);
			System.out.println("Current player is: " + currentPlayer.getName());
			System.out.println("OnBikeStatus is: " +currentPlayer.getOnBikeStatus());
			System.out.println("HasWind status is: " + currentPlayer.getHasWind());
			System.out.println("BulliedStatus is: " + currentPlayer.getBulliedType());
			System.out.println("The traveled distance is: " + currentPlayer.getKmProgress());
			
					
			
			// See players hand:
			System.out.println("The player's hand contains: " + currentPlayer.viewHand());
			
		
			// Discard a chosen card:
			System.out.println("Enter which card (1-5) you want to play or discard: ");
			int discardIndex = input.nextInt() - 1;
			
			selectedCard = currentPlayer.hand.getHand().get(discardIndex);
			System.out.println("Selected card is " + selectedCard);
			
			// Ask player to play or discard the selected card
			System.out.println("Enter 1 to Play or 0 to discard the card: ");
			int methodIndex = input.nextInt();
			
			System.out.println(Arrays.toString(selectedCard.getRequirements()));
			
			System.out.println(rules.isPlayble(selectedCard, currentPlayer));
			
			// Check for playability or discard the selected  card
			if (methodIndex == 1 && rules.isPlayble(selectedCard, currentPlayer)) {
				
				System.out.println(rules.isPlayble(selectedCard, currentPlayer));
				
				// Check card type and play it accordingly 
				if (!selectedCard.getType().equals("BULLY")) {
					//currentPlayer.hand.getHand().getHand(this).selectCard(this, selectedCard, stack, discardPile);
					
					
					}
				else {
					// Create a dummy player to bully
					System.out.print("\n\nEnter which player (1-3) to bully: ");
					int bullyIndex = input.nextInt() - 1;
					playerToBully = players.get(bullyIndex);
					//currentPlayer.selectCard(selectedCard, playerToBully, stack, discardPile);
				}

				
			}
			else { 
				
				if (!rules.isPlayble(selectedCard, currentPlayer)) {
					
					System.out.println("Selected card cannot be played, card is discarded");
				}
				
				currentPlayer.hand.discardedCard(selectedCard, discardPile);
				
			}
			

			drawnCard = stack.drawTopCard();
			currentPlayer.hand.addCard(drawnCard);
			
			System.out.println("Current player is: " + currentPlayer.getName());
			System.out.println("OnBikeStatus is: " +currentPlayer.getOnBikeStatus());
			System.out.println("HasWind status is: " + currentPlayer.getHasWind());
			System.out.println("BulliedStatus is: " + currentPlayer.getBulliedType());
			System.out.println("The traveled distance is: " + currentPlayer.getKmProgress());

			//System.out.print("\nThe player's hand now contains:\n");
			//System.out.print(currentPlayer.viewHand());
			
			System.out.println("Discard pile size is: " + discardPile.getStackSize()+ "\n\n");
			
			// Passing turn to next player or first player
			if (playerIndex == 2) {
				playerIndex = 0;
			
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
			
			if (currentPlayer.getKmProgress() == 100) {
				gameContinue = false;
			}
		}
		
		
		
		
		// Get hand from player for GUI
		ArrayList<Card> hand = firstPlayer.hand.getHand();
		
		// Launch the main menu
		// to realy lunch it you need to win the game first (reach 100km)
		MainMenu.main(args, firstPlayer, secondPlayer, thirdPlayer, stack, discardedCardName, hand);
			
		
		
		// Add dicardCardName for GUI
//		discardedCardName = firstPlayer.discardCard(discardIndex, discardPile);
		
		// Test PlayerHand GUI, to be removed later
		//PlayerHand.main(args, firstPlayer.getHand());
		
		// Launch GameFrame GUI (Test)
		//GameFrame.main(args);
	
		
		
	}

}