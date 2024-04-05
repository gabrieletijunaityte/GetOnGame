package logic;

import java.util.ArrayList;

public class PlayedCards {
	private ArrayList<Card> playedCards = new ArrayList<>();
	
	public PlayedCards(Card card) {
		playedCards.add(card);
		}
	
/*	Is still in work
 
 	private void isPlayable(Card card, Player currentPlayer) {
		if (!currentPlayer.getOnBikeStatus()) {
			if(currentPlayer.getBulliedStatus()) {
				if (card.getType() == "REPAIR") {
					playedCards.add(card);
				}
				else if(card.getType() == "BULLY") {
// Add functionality in Player
//					currentPlayer.playBullyCard(bulliedPlayer);
						}
				else if(card.getType() == "STATUS" && card.getValue() == "TAIL_WIND") {
					playedCards.add(card);
				}
				else {
					throw new IllegalArgumentException("Card cannot be played");
				}
			}
			else if(card.getType() == "STATUS") {
				playedCards.add(card)
			}
			else if(card.getType() == "BULLY") {
//				currentPlayer.playBullyCard(bulliedPlayer);
			}
			else{
				throw new IllegalArgumentException("Card cannot be played");
			}
		}
		
		
		
		String cardType = card.getType();
		
		
	}
	*/
}
	
