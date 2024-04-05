package logic;

import java.util.ArrayList;

public class PlayedCards {
	private ArrayList<Card> playedCards = new ArrayList<>();

	public PlayedCards(Card card) {
		getPlayedCards().add(card);
	}
	
	// Count how many of a specific cards have been played
	public int countCards(Card card) {
		// initiate count
		int i = 0;
		
		// iterate over the played cards
		for (Card playedCard : this.getPlayedCards()) {
			
			// check how many of the given specific cards are in the played pile
			if (playedCard.getCardName().equals(playedCard.getCardName())) {
				i++;
			}
		}
		return i;
	}

	public void addCard(Card card1) {
		// IMPLEMENT CHECKING
//		
		// Add card
		this.getPlayedCards().add(card1);
	}

	public ArrayList<Card> getPlayedCards() {
		return this.playedCards;
	}
	
	

////	Is still in work
//
//	// Method to play a selected card
//	private void isPlayable(Card card, Player currentPlayer) {
// 		// Card card - selected card
// 		// Player currentPlayer - player who plays the card
// 		
// 		// Check if the player is off the bike
//		if (!currentPlayer.getOnBikeStatus()) {
//			
//			// if player is off the bike, look if he was bullied
//			if(currentPlayer.getBulliedStatus()) {
//				
//				// if player was bullied
//				if (card.getType() == "REPAIR") {
//					
//					// if selected card is repair, play it
//					playedCards.add(card);
//				}
//				else if(card.getType() == "BULLY") {
//// Add functionality in Player
//					// if selected card is bully card, play it
////					currentPlayer.playBullyCard(bulliedPlayer);
//						}
//				else if(card.getType() == "STATUS" && card.getValue() == "TAIL_WIND") {
//					
//					// if selected card is "TAIL_WIND", play it
//					playedCards.add(card);
//				}
//				else {
//					// if selected card is none of the above, throw error
//					throw new IllegalArgumentException("Card cannot be played");
//				}
//			}
//			
//			// if the player is not on a bike and is not bullied
//			else if(card.getType() == "STATUS") {
//				
//				// play any status card
//				playedCards.add(card);
//			}
//			else if(card.getType() == "BULLY") {
//				
//				// play any bully card
////				currentPlayer.playBullyCard(bulliedPlayer);
//			}
//			else{
//				
//				// if given card is none of above throw an error
//				throw new IllegalArgumentException("Card cannot be played");
//			}
//		}	
//	}
}
