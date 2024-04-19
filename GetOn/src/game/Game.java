package game;

import logic.Card;
import logic.Player;
import logic.Rules;
import logic.Stack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import graphics.GameFrame;
import graphics.MainMenu;
import graphics.PlayerHand;

public class Game {

	public static void main(String[] args) throws InterruptedException {

		// Declares the names and players list
		ArrayList<String> names = new ArrayList<>();
		ArrayList<Player> players = new ArrayList<>();
		
		// Launches the main menu gui
		MainMenu menu = new MainMenu(names);
		
		// Waits for GUI to return some input for the names
		while (!menu.getReceivedNames()) {
			Thread.sleep(100);
		}
		
		// Initialises players based on main menu input
		if (names.size() != 1) {
			
			// Creates two players if only two names entered
			Player firstPlayer = new Player(names.get(0), true);
			players.add(firstPlayer);
			Player secondPlayer = new Player(names.get(1), false);
			players.add(secondPlayer);
			
			// Creates a third player object when three names entered
			if (names.size() == 3){
				Player thirdPlayer = new Player(names.get(2), false);
				players.add(thirdPlayer);	
			}
			
		}

		// Intialize rules, stack and discard pile
		Rules rules = new Rules();
		Stack stack = new Stack();
		Stack discardPile = new Stack();

		
		// Create a random stack or test stack depending on which option is chosen
		if (!menu.getIsTestGame()) {
			// Create the initial stack filled with all cards that are used in the game
			stack.initializeStack();
			// Shuffle the stack
			stack.shuffle();
		} else {
			stack.initializeTestStack();
		}
		
		// Deal initial cards
		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < players.size(); i++) {
				players.get(i).drawCard(stack.drawTopCard());
			}
		}

		// Create gameContinue variable
		Boolean gameContinue = true;
		
		// Declare the selected card
		int selectedCardIndex = 0;

		// Set current player index
		int playerIndex = 0;

		// Initiate a current player
		Player currentPlayer = players.get(playerIndex);

		// Initiate playerToBully
		Player playerToBully;

		// Launch GameFrame
		PlayerHand currentPlayerHand = new PlayerHand(players.get(playerIndex), rules);
		GameFrame gameFrame = new GameFrame(stack, discardPile, players, selectedCardIndex, rules, playerIndex);
		
		// Initialize input listener
		Scanner input = new Scanner(System.in);

		// Intialize drawn cards
		Card drawnCard;

		// Game loop
		while (gameContinue) {
			currentPlayer = players.get(playerIndex);
			
			gameFrame.getPlayerHand(currentPlayerHand);
			currentPlayerHand.updateHand(986, currentPlayer, rules);			
		
			// Get the Gui popup
			gameFrame.refreshGameFrame(stack, discardPile, players, currentPlayer, rules, selectedCardIndex, playerIndex);
			System.out.println("Current player is: " + currentPlayer.getName());
			System.out.println("OnBikeStatus is: " + currentPlayer.getOnBikeStatus());
			System.out.println("HasWind status is: " + currentPlayer.getHasWind());
			System.out.println("BulliedStatus is: " + currentPlayer.getBulliedType());
			System.out.println("The traveled distance is: " + currentPlayer.getKmProgress());

			// See players hand:
			System.out.println("The player's hand contains: " + currentPlayer.viewHand());

			// Waits for GUI to return the index of the selected Card
			while (!currentPlayerHand.getReceivedSelectedCard()) {
				Thread.sleep(50);
			}

			// get the index of the selected card from the PlayerHand
			selectedCardIndex = currentPlayerHand.getSelectedCardIndex();
			// get the selected Card based on the retrieved index
			Card selectedCard = currentPlayer.getCard(selectedCardIndex);

			System.out.println("Selected card is " + selectedCard);

			while (!currentPlayerHand.getIsPlayedCard()) {
				Thread.sleep(50);
			}
			
			// Check for playability or discard the selected card
			if (currentPlayerHand.getMethodIndex() == 0 && rules.isPlayble(selectedCard, currentPlayer)) {
				// Check card type and play it accordingly
				if (selectedCard.getType().equals("BULLY")) {
					// Create a dummy player to bully
					System.out.print("\n\nEnter which player (1-3) to bully: ");
					int bullyIndex = input.nextInt() - 1;
					playerToBully = players.get(bullyIndex);
					playerToBully.setConsequences(selectedCard.getConsequences());
				}
				else {
					currentPlayer.setConsequences(selectedCard.getConsequences());
					
					// If card is km card, add it to table
					if (selectedCard.getType().equals("KILOMETER")) {
						currentPlayer.discardCard(selectedCard);
						currentPlayer.addToTable(selectedCard);						
					} else {
						currentPlayer.discardCard(selectedCard);
						discardPile.addDiscardedCard(selectedCard);
					}
					drawnCard = stack.drawTopCard();
					currentPlayer.drawCard(drawnCard);
				}
			} else {

				if (currentPlayerHand.getMethodIndex() == 0 && !rules.isPlayble(selectedCard, currentPlayer)) {
					System.out.println("Selected card cannot be played, card is discarded");
				}
				currentPlayer.discardCard(selectedCard);
				discardPile.addDiscardedCard(selectedCard);
				drawnCard = stack.drawTopCard();
				currentPlayer.drawCard(drawnCard);
			}

			System.out.println("Current player is: " + currentPlayer.getName());
			System.out.println("OnBikeStatus is: " + currentPlayer.getOnBikeStatus());
			System.out.println("HasWind status is: " + currentPlayer.getHasWind());
			System.out.println("BulliedStatus is: " + currentPlayer.getBulliedType());
			System.out.println("The traveled distance is: " + currentPlayer.getKmProgress());

			// System.out.print("\nThe player's hand now contains:\n");
			// System.out.print(currentPlayer.viewHand());

			System.out.println("Discard pile size is: " + discardPile.getStackSize() + "\n\n");

			// Passing turn to next player or first player
			if (playerIndex == players.size() - 1) {
				playerIndex = 0;

			} else {
				playerIndex++;
			}
//			gameContinue = false;

			// Check if card stack is empty and if so reshuffle discardPile
			if (stack.getStackSize() == 0) {
				stack = discardPile;
				stack.shuffle();
				discardPile.clear();
			}

			if (currentPlayer.getKmProgress() == 100) { 
				gameContinue = false;
			}

			// reset currentPlayers booleans to false
			currentPlayerHand.resetBooleans();
		}
	}

}