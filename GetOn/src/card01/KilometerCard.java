package card01;

public class KilometerCard implements Card {
	public int fiveKmCardsPlayed = 8;
	public int cardValue;
	
	public KilometerCard(int cardValue) {
		this.cardValue = cardValue;
	}
	
	

	public void playCard(int cardValue) {
		if(cardValue == 5) {
			if (fiveKmCardsPlayed < 8) {
				fiveKmCardsPlayed++;
			}
			else{
				System.out.println("Card cannot be played");
			}
		}
		System.out.println(fiveKmCardsPlayed);
	}
	public static void main(String[] args) {
        // Simulate playing a 5km card
		
	}
}


