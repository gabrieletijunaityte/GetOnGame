package card01;

public class KilometerCard implements Card {
	// Create the variables that keep track of the number of cards played and Km value per card.
	// For testing, these random values have been chosen. They should be retrieved from the player's input.
	public int fiveKmCardsPlayed = 4;
	public int sixKmCardsPlayed = 4;
	public int eightKmCardsPlayed = 1;
	public int tenKmCardsPlayed = 2;
	public int cardKmValue;
	
	public KilometerCard(int cardKmValue) {
		// Initialise the cardKmValue
		this.cardKmValue = cardKmValue;
	}
	
	
/* Check which Km card is played. If the maximum is not exceeded yet,
 * the value of the cards played is incremented.
 * Print the played card and the total amount of cards played for that kilometer class.
 * 
 */
	public void playCard() {
		if(cardKmValue == 5) {
			if (fiveKmCardsPlayed < 8) {
				fiveKmCardsPlayed++;
				System.out.printf("Played a five kilometer card. %nTotal five-kilometer cards played: %d%n", fiveKmCardsPlayed);
			}
			else{System.out.println("Five km card cannot be played");
			}}
		else if(cardKmValue == 6) {
			if(sixKmCardsPlayed < 4) {
				sixKmCardsPlayed++;
				System.out.printf("Played a six kilometer card. %nTotal six-kilometer cards played: %d%n", sixKmCardsPlayed);}
			else {System.out.println("Six km card cannot be played");
			}}
		else if(cardKmValue == 8) {
			if(eightKmCardsPlayed < 2) {
				eightKmCardsPlayed++;
				System.out.printf("Played a eight kilometer card. %nTotal eight-kilometer cards played: %d%n", eightKmCardsPlayed);}
			else {System.out.println("eight km card cannot be played");
			}}
		else if(cardKmValue == 10) {
			if(tenKmCardsPlayed < 2) {
				tenKmCardsPlayed++;
				System.out.printf("Played a ten kilometer card. %nTotal ten-kilometer cards played: %d%n", tenKmCardsPlayed);}
			else {System.out.println("ten km card cannot be played");
			}}
		}
	public static void main(String[] args) {
		
	}
}


