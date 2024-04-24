package logic;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Stack class Creates a stack with all 99 playable cards - 52 kilometer cards
 * (24 five, 12 six, 8 eight, 8 ten) - 12 attack cards (4 crosswind, 3 flatTire,
 * 3 crisscross, 2 tavern - 16 defense cards (8 barrierOpen, 8 bikeRepair) - 19
 * status cards (14 getOn, 5 tailwind) Credits for inspiration on stack
 * creation:
 * https://stackoverflow.com/questions/70086453/create-a-stack-of-cards Credits
 * for shuffle method: java how to program Paul Deitel & Harvey Deitel
 */
public class Stack {
	private ArrayList<Card> stack;
	private static final SecureRandom randomNumbers = new SecureRandom();

	/**
	 * Constructor for the stack
	 */
	public Stack() {
		this.stack = new ArrayList<>();
	}


	/**
	 * Method to intitialize deck with limited cards for testing purposes
	 */
	public void initializeTestStack() {

		// Create objects of each different card needed vor testing:
		StatusCard getOnCard = new StatusCard("GET_ON");
		StatusCard tailWindCard = new StatusCard("TAIL_WIND");

		KilometerCard fiveKilometerCard = new KilometerCard("FIVE");
		KilometerCard sixKilometerCard = new KilometerCard("SIX");
		KilometerCard eightKilometerCard = new KilometerCard("EIGHT");
		KilometerCard tenKilometerCard = new KilometerCard("TEN");

		BullyCard flatTireCard = new BullyCard("FLAT_TIRE");
		BullyCard crisCrossCard = new BullyCard("CRISS_CROSS");
		BullyCard tavernCard = new BullyCard("TAVERN");
		BullyCard crossWindCard = new BullyCard("CROSSWIND");

		RepairCard bikeRepairCard = new RepairCard("BIKE_REPAIR");

		/*
		 * Set cards in the deck in specific order required for play testing all the
		 * cards an reshuffling the discard pile when the last card is drawn Only the
		 * first four cards in the hand of the three players matter for the acceptance
		 * tests
		 */
		List<Card> testListStack = Arrays.asList(getOnCard, flatTireCard, bikeRepairCard, fiveKilometerCard, getOnCard,
				flatTireCard, crisCrossCard, getOnCard, tavernCard, tailWindCard, sixKilometerCard, eightKilometerCard,
				crossWindCard, tenKilometerCard, fiveKilometerCard, fiveKilometerCard, fiveKilometerCard,
				fiveKilometerCard, eightKilometerCard);

		for (Card i : testListStack) {
			stack.add(i);
		}
	}

	/**
	 * Method to initialize the stack and add the cards to it
	 */
	public void initializeStack() {
		// initialize KilometerCard to get its methods
		KilometerCard kilometerCard = new KilometerCard("FIVE");
		String[] valuesKM = kilometerCard.getPossibleValues();
		int[] amountKM = kilometerCard.getAmounts();

		// iterate through all values and add the amount of this value to the stack
		for (int i = 0; i < valuesKM.length; i++) {
			int times = amountKM[i];
			for (int j = 0; j < times; j++) {
				KilometerCard card = new KilometerCard(valuesKM[i]);
				stack.add(card);
			}
		}

		// initialize BullyCard to get its methods
		BullyCard bullyCard = new BullyCard("CROSSWIND");
		String[] valuesBully = bullyCard.getPossibleValues();
		int[] amountBully = bullyCard.getAmounts();

		// iterate through all values and add the amount of this value to the stack
		for (int i = 0; i < valuesBully.length; i++) {
			int times = amountBully[i];
			for (int j = 0; j < times; j++) {
				BullyCard card = new BullyCard(valuesBully[i]);
				stack.add(card);
			}
		}

		// initialize RepairCard to get its methods
		RepairCard repairCard = new RepairCard("BARRIER_OPEN");
		String[] valuesRepair = repairCard.getPossibleValues();
		int[] amountRepair = repairCard.getAmounts();

		// iterate through all values and add the amount of this value to the stack
		for (int i = 0; i < valuesRepair.length; i++) {
			int times = amountRepair[i];
			for (int j = 0; j < times; j++) {
				RepairCard card = new RepairCard(valuesRepair[i]);
				stack.add(card);
			}
		}

		// initialize StatusCard to get its methods
		StatusCard statusCard = new StatusCard("GET_ON");
		String[] valuesStatus = statusCard.getPossibleValues();
		int[] amountStatus = statusCard.getAmounts();

		// iterate through all values and add the amount of this value to the stack
		for (int i = 0; i < valuesStatus.length; i++) {
			int times = amountStatus[i];
			for (int j = 0; j < times; j++) {
				StatusCard card = new StatusCard(valuesStatus[i]);
				stack.add(card);
			}
		}
	}

	/**
	 * Method to return the stack size
	 * 
	 * @return stack size - int of the amount of cards in the stack
	 */
	public int getStackSize() {
		return stack.size();
	}

	/**
	 * Method to shuffle cards This method takes a random index with randomNumbers
	 * in the range of the stack size it then iterates through the original stack
	 * based on its index. The card is swapped with the random index
	 */
	public void shuffle() {
		for (int first = 0; first < stack.size(); first++) {
			int second = randomNumbers.nextInt(stack.size());
			Card temp = stack.get(first);
			stack.set(first, stack.get(second));
			stack.set(second, temp);
		}
	}

	/**
	 * Method to draw the top card from the stack
	 * 
	 * @return topCard - card that is on top of the stack
	 */
	public Card drawTopCard() {
		// Draw the top card from the stack
		Card topCard = stack.get(0);
		// Remove the topCard from the stack
		stack.remove(stack.get(0));
		// Return the topCard
		return topCard;
	}

	/**
	 * Method to add the discarded card to the discard pile
	 * 
	 * @param discardedCard - card that is discarded
	 */
	public void addDiscardedCard(Card discardedCard) {
		// add a discardedCard to the discardPile
		stack.add(discardedCard);

	}

	/**
	 * Method to get a card at a specific index
	 * 
	 * @param i - int specifying the index
	 * @return Card - card at index i
	 */
	public Card get(int i) {
		// add method to get a card at a specific index
		return stack.get(i);
	}

	/**
	 * Method to clear the stack
	 */
	public void clear() {
		this.stack.clear();
	}

	/**
	 * Method to get the stack
	 * 
	 * @return stack - the current stack
	 */
	public ArrayList<Card> getStack() {
		return this.stack;
	}

}
