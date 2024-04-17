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

	public static void main(String[] args) throws InterruptedException {

		// Declares the names list
		ArrayList<String> names = new ArrayList<>();

		// Declare the selected card
		int selectedCardIndex = 0;

		// Intialize rules
		Rules rules = new Rules();

		// Launches the main menu gui
		MainMenu.main(args, names);

		// Waits for GUI to return some input for the names
		while (!MainMenu.getReceivedNames()) {
			Thread.sleep(100);
		}

		// Intializes players
		Player firstPlayer = new Player("Player1", true), secondPlayer = new Player("Player2", false),
				thirdPlayer = new Player("Player3", false);

		// Create an Array list with the players
		ArrayList<Player> players = new ArrayList<>(Arrays.asList(firstPlayer, secondPlayer, thirdPlayer));

		// Changes player names based on GUI input
		for (int i = 1; i <= names.size(); i++) {
			players.get(i - 1).changeName(names.get(i - 1));
		}

		// Sets the amount of players in the game
		if (names.size() == 2) {
			players.remove(thirdPlayer);
		}

		// Initialize the stack
		Stack stack = new Stack();

		// Initialize discardPile
		Stack discardPile = new Stack();

		// Create the initial stack filled with all cards that are used in the game
		stack.initializeStack();
		// Shuffle the stack
		stack.shuffle();

		// Initialize discardCardName for GUI
		String discardedCardName = null;

		// Deal initial cards
		for (int j = 0; j < 5; j++) {
			for (int i = 0; i <= players.size() - 1; i++) {
				players.get(i).drawCard(stack.drawTopCard());
			}
		}

		// Create gameContinue variable
		Boolean gameContinue = true;

		// Set current player index
		int playerIndex = 0;

		// Initiate a current player
		Player currentPlayer = players.get(playerIndex);

		// Initiate playerToBully
		Player playerToBully;

		// Launch GameFrame
		//GameFrame gameFrame = new GameFrame(stack, discardedCardName, names, selectedCardIndex, currentPlayer, rules);
//		GameFrame.main(args, stack, discardedCardName, names, selectedCardIndex, players.get(playerIndex), rules);


		// Initialize input listener
		Scanner input = new Scanner(System.in);

		// Intialize drawn cards
		Card drawnCard;

		// Create a GUI game loop
		Card cardToPlay = new Card(discardedCardName, discardedCardName);

		// Game loop
		while (gameContinue) {
			currentPlayer = players.get(playerIndex);
			// Create a new gameFrame method
			GameFrame gameFrame = new GameFrame(stack, discardedCardName, names, selectedCardIndex, currentPlayer, rules);
			// Get the Gui popup
			gameFrame.main(gameFrame);
			System.out.println("Current player is: " + currentPlayer.getName());
			System.out.println("OnBikeStatus is: " + currentPlayer.getOnBikeStatus());
			System.out.println("HasWind status is: " + currentPlayer.getHasWind());
			System.out.println("BulliedStatus is: " + currentPlayer.getBulliedType());
			System.out.println("The traveled distance is: " + currentPlayer.getKmProgress());

			// See players hand:
			System.out.println("The player's hand contains: " + currentPlayer.viewHand());

			// Waits for GUI to return the index of the selected Card
			while (!PlayerHand.getReceivedSelectedCard()) {
				Thread.sleep(50);
			}

			// get the index of the selected card from the PlayerHand
			selectedCardIndex = PlayerHand.getSelectedCardIndex().get();
			// get the selected Card based on the retrieved index
			Card selectedCard = currentPlayer.getCard(selectedCardIndex);

			System.out.println("Selected card is " + selectedCard);

			while (!PlayerHand.getIsPlayedCard()) {
				Thread.sleep(50);
			}
			// Check for playability or discard the selected card
			if (PlayerHand.getMethodIndex() == 0 && rules.isPlayble(selectedCard, currentPlayer)) {
				// Check card type and play it accordingly
				if (!selectedCard.getType().equals("BULLY")) {
					currentPlayer.setConsequences(selectedCard.getConsequences());

				} else {

					// Create a dummy player to bully
					System.out.print("\n\nEnter which player (1-3) to bully: ");
					int bullyIndex = input.nextInt() - 1;
					playerToBully = players.get(bullyIndex);
					playerToBully.setConsequences(selectedCard.getConsequences());
				}

				// If card is km card, add it to table
				if (selectedCard.getType().equals("KILOMETER")) {

					currentPlayer.discardCard(selectedCard);
					currentPlayer.addToTable(selectedCard);

					drawnCard = stack.drawTopCard();
					currentPlayer.drawCard(drawnCard);
				} else {
					currentPlayer.discardCard(selectedCard);
					discardPile.addDiscardedCard(selectedCard);

					drawnCard = stack.drawTopCard();
					currentPlayer.drawCard(drawnCard);
				}

			} else {

				if (PlayerHand.getMethodIndex() == 0 && !rules.isPlayble(selectedCard, currentPlayer)) {
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
			PlayerHand.resetBooleans();
			
			// Close the gameFrame GUI
			gameFrame.dispose();
			
		}
		// Add dicardCardName for GUI
//		discardedCardName = firstPlayer.discardCard(discardIndex, discardPile);

		// Test PlayerHand GUI, to be removed later
		// PlayerHand.main(args, firstPlayer.getHand());

		// Launch GameFrame GUI (Test)
		// GameFrame.main(args);

	}

}