package game;
import logic.Card;
import logic.GameMaster;
import logic.Player;
import logic.Type;
import logic.Value;

import java.util.ArrayList;
import java.util.Scanner;

import graphics.GameFrame;
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
		//PlayerHand.main(args, firstPlayer.getHand());
		
		// Launch GameFrame GUI (Test)
		GameFrame.main(args);
		
	}

}

// 	First try by SY JW: 20240404
//	// Make a turn
//	public static void takeTurn(Player currentPlayer, ArrayList<Card> stack, Scanner input) {
//        
//        // See players hand:
//        currentPlayer.drawCard(stack, 5);
//        System.out.print("The player's hand contains: ");
//        System.out.print(currentPlayer.viewHand());
//        
//        
//        // Dummy discard pile:
//        ArrayList<Card> discardPile = new ArrayList<>();
//        
//        // Choose a card to discard
//        System.out.print("\n\nEnter which card (1-5) you want to discard: ");
//        int discardIndex = input.nextInt() - 1;
//        ArrayList<String> playersHand = currentPlayer.viewHand();
//        
//        // Check what we can do with the card
//// Implement a Status for the player and setCountFiveKM()
//        if (currentPlayer.getStatus() == "OnBike"){
//        	if (playersHand.get(discardIndex) == "kilometer_five" && currentPlayer.setCountFiveKM() < 8){
//        		currentPlayer.discardCard(discardIndex, discardPile);
//        		// Update players progress and count of 5km cards
//// Implement setProgress() 
//        		currentPlayer.setProgress() += 5;
//        		currentPlayer.setCountFiveKM() += 1; 
//        		}
//                
//        	if (playersHand.get(discardIndex) == "kilometer_six" && currentPlayer.setCountSixKM() < 4){
//        		currentPlayer.discardCard(discardIndex, discardPile);
//        		// Update players progress and count of 6km cards
//// Implement setCountSixKM()
//        		currentPlayer.setProgress() += 6;
//        		currentPlayer.setCountSixKM() += 1;  
//        	}
//
//// Implement getWindStatus() for Player        	
//        	if (playersHand.get(discardIndex) == "kilometer_eight" && currentPlayer.getWindStatus() == "Wind in the back" && currentPlayer.setCountEightKM() < 2){
//        		currentPlayer.discardCard(discardIndex, discardPile);
//        		// Update players progress and count of 8km cards
//// Implement setCountEightKM()
//        		currentPlayer.setProgress() += 8;
//        		currentPlayer.setCountEightKM() += 1;  
//        	}
//        	
//        	if (playersHand.get(discardIndex) == "kilometer_ten" && currentPlayer.getWindStatus() == "Wind in the back" && currentPlayer.setCountTenKM() < 2){
//        		currentPlayer.discardCard(discardIndex, discardPile);
//        		// Update players progress and count of 10km cards
//// Implement setCountTenKM()
//        		currentPlayer.setProgress() += 10;
//        		currentPlayer.setCountEightKM() += 1;  
//        	}
//        }
//            
//        currentPlayer.discardCard(discardIndex, discardPile);
//        
//        // Draw card
//        System.out.print("\nA new card was drawn from the pile:\n");
//        currentPlayer.drawCard(stack);
//        System.out.print(currentPlayer.getHand().get(4));
//        System.out.print("\nThe player's hand now contains:\n");
//        System.out.print(currentPlayer.viewHand());
//        
//        currentPlayer.changeTurn(); 
//    }
// }
