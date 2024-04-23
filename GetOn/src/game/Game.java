package game;

import logic.Card;
import logic.Player;
import logic.Rules;
import logic.Stack;
import utilities.WriteJSON;

import java.util.ArrayList;
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
			Player firstPlayer = new Player(names.get(0));
			players.add(firstPlayer);
			Player secondPlayer = new Player(names.get(1));
			players.add(secondPlayer);
			
			// Creates a third player object when three names entered
			if (names.size() == 3){
				Player thirdPlayer = new Player(names.get(2));
				players.add(thirdPlayer);	
			}	
		}

		// Initialize rules, stack and discard pile
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
			// Updates the player
			for (int i = 0; i < players.size(); i++) {
				players.get(i).setKmProgress(85);
			}
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
		PlayerHand currentPlayerHand = new PlayerHand(currentPlayer, rules);
		GameFrame gameFrame = new GameFrame(stack, discardPile, players, selectedCardIndex, rules, playerIndex);
		gameFrame.updatePlayerHand(currentPlayerHand);
		
		// Initialize input listener
		Scanner input = new Scanner(System.in);

		// Intialize drawn cards
		Card drawnCard;

		// Game loop
		while (gameContinue) {
			
			// Activate current player
			currentPlayer = players.get(playerIndex);

			System.out.println("OnBikeStatus is: " + currentPlayer.getOnBikeStatus());
			System.out.println("HasWind status is: " + currentPlayer.getHasWind());
			System.out.println("BulliedStatus is: " + currentPlayer.getBulliedType());
			
			// Update current players hand
			currentPlayerHand.updateHand(986, currentPlayer, rules);
			gameFrame.updatePlayerHand(currentPlayerHand);		
		
			// Get the GUI popup
			gameFrame.refreshGameFrame(stack, discardPile, players, currentPlayer, rules, selectedCardIndex, playerIndex);

			// Select card through hand GUI
			// Waits for GUI to return the index of the selected Card
			while (!currentPlayerHand.getReceivedSelectedCard()) {
				Thread.sleep(50);
			}

			// Get the index of the selected card from the PlayerHand
			selectedCardIndex = currentPlayerHand.getSelectedCardIndex();
			
			// Get the selected Card based on the retrieved index
			Card selectedCard = currentPlayer.getCard(selectedCardIndex);

			while (!currentPlayerHand.getIsPlayedCard()) {
				Thread.sleep(50);
			}
			
			// Ask player if he wants to play the card through GUI
			// if yes: check for playability of the selected card
			if (currentPlayerHand.getMethodIndex() == 0 && rules.isPlayble(selectedCard, currentPlayer)) {
				// Check card type and play it accordingly
				if (selectedCard.getType().equals("BULLY")) {

					// launch optionPane to select player you want to bully
					int bullyIndex = currentPlayerHand.showSelectPlayerToBully(names);	
					// wait for selection input
					while (!currentPlayerHand.getReceivedPlayerToBully()) {
						Thread.sleep(50);
					}
					// bully player/update its statuses 
					playerToBully = players.get(bullyIndex);
					playerToBully.setConsequences(selectedCard.getConsequences());
					
					// Discard played card
					currentPlayer.discardCard(selectedCard);
					discardPile.addDiscardedCard(selectedCard);
					
				} else {
					// If card is not bully, update current player statuses
					currentPlayer.setConsequences(selectedCard.getConsequences());
					
					// If card is km card, add it to table
					if (selectedCard.getType().equals("KILOMETER")) {
						currentPlayer.discardCard(selectedCard);
						currentPlayer.addToTable(selectedCard);						
					} 
					// If card is not km card, discard it
					else {
						currentPlayer.discardCard(selectedCard);
						discardPile.addDiscardedCard(selectedCard);
					}
				}
			} 
			// If card is not playable or player selected to discard card:
			else {
				// If player wants to play un-playble card:
				if (currentPlayerHand.getMethodIndex() == 0 && !rules.isPlayble(selectedCard, currentPlayer)) {
					System.out.println("Selected card cannot be played, card is discarded");
				}
				// Discard selected card
				currentPlayer.discardCard(selectedCard);
				discardPile.addDiscardedCard(selectedCard);			
			}
			
			// Replenish player's card from stack
			drawnCard = stack.drawTopCard();
			currentPlayer.drawCard(drawnCard);
			
			// Passing turn to next player or first player
			if (playerIndex == players.size() - 1) {
				playerIndex = 0;
			} else {
				playerIndex++;
			}

			// Check if card stack is empty and if so re-shuffle discardPile
			if (stack.getStackSize() == 0) {
				for (int i = 0; i < discardPile.getStackSize(); i++) {
					stack.addDiscardedCard(discardPile.get(i));
				}
				stack.shuffle();
				discardPile.clear();
			}
			
			// Check if the game has ended
			if (currentPlayer.getKmProgress() == 100) { 
				gameContinue = false;
				gameFrame.winGame(currentPlayer);
				gameFrame.dispose();
				menu.endGame();
			}

			// reset currentPlayers booleans to false
			currentPlayerHand.resetBooleans();
			
			if (gameFrame.getIsExit()) {
				gameContinue = false;
				gameFrame.dispose();
				menu.endGame();
				WriteJSON writer = new WriteJSON();
				writer.writeGame("saved_game", stack.getStack(), discardPile.getStack(), players, playerIndex);
			}
		
		}
	}

}