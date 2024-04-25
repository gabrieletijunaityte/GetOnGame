package logic;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utilities.Constant;

/**
 * Stack class creates a stack with all 99 playable cards: 52 kilometer cards
 * (24 five, 12 six, 8 eight, 8 ten, 12 attack cards (4 cross_wind, 3 flat_tire,
 * 3 criss_cross, 2 tavern, 16 defense cards (8 barrier_open, 8 bike_repair), 19
 * status cards (14 get_on, 5 tail_wind). Credits for inspiration on stack
 * creation:
 * https://stackoverflow.com/questions/70086453/create-a-stack-of-cards Credits
 * For the shuffle method: "Java How To Program" by Paul Deitel & Harvey Deitel
 */
public class Stack {
	private ArrayList<Card> stack;
	private static final SecureRandom randomNumbers = new SecureRandom();

	/**
	 * Constructs a new Stack as an empty array.
	 */
	public Stack() {
		this.stack = new ArrayList<>();
	}

	/**
	 * This method initializes the stack with a predefined set of cards for testing
	 * purposes.
	 */
	public void initializeTestStack() {
		// Create objects of each different card needed for testing:
		BullyCard flatTireCard = new BullyCard(Constant.FLAT_TIRE);
		BullyCard crisCrossCard = new BullyCard(Constant.CRISS_CROSS);
		BullyCard tavernCard = new BullyCard(Constant.TAVERN);
		BullyCard crossWindCard = new BullyCard(Constant.CROSSWIND);

		KilometerCard fiveKilometerCard = new KilometerCard(Constant.FIVE);
		KilometerCard sixKilometerCard = new KilometerCard(Constant.SIX);
		KilometerCard eightKilometerCard = new KilometerCard(Constant.EIGHT);
		KilometerCard tenKilometerCard = new KilometerCard(Constant.TEN);

		RepairCard bikeRepairCard = new RepairCard(Constant.BIKE_REPAIR);

		StatusCard getOnCard = new StatusCard(Constant.GET_ON);
		StatusCard tailWindCard = new StatusCard(Constant.TAIL_WIND);

		/*
		 * Set cards in the deck in a specific order required for play testing all the
		 * cards and re-shuffling the discard pile when the last card is drawn. Only the
		 * first four cards in the hand of the three players matter for the acceptance
		 * tests.
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
	 * This method populates the stack with different types of cards based on their
	 * defined qualities and types. This stack is not is a random order.
	 */
	public void initializeStack() {
		// Initialize KilometerCard to get its methods
		KilometerCard kilometerCard = new KilometerCard(Constant.FIVE);
		String[] valuesKM = kilometerCard.getPossibleValues();
		int[] amountKM = kilometerCard.getAmounts();

		// Iterate through all values and add the amount of this value to the stack
		for (int i = 0; i < valuesKM.length; i++) {
			int times = amountKM[i];
			for (int j = 0; j < times; j++) {
				KilometerCard card = new KilometerCard(valuesKM[i]);
				stack.add(card);
			}
		}
		// Initialize BullyCard to get its methods
		BullyCard bullyCard = new BullyCard(Constant.CROSSWIND);
		String[] valuesBully = bullyCard.getPossibleValues();
		int[] amountBully = bullyCard.getAmounts();

		// Iterate through all values and add the amount of this value to the stack
		for (int i = 0; i < valuesBully.length; i++) {
			int times = amountBully[i];
			for (int j = 0; j < times; j++) {
				BullyCard card = new BullyCard(valuesBully[i]);
				stack.add(card);
			}
		}
		// Initialize RepairCard to get its methods
		RepairCard repairCard = new RepairCard(Constant.BARRIER_OPEN);
		String[] valuesRepair = repairCard.getPossibleValues();
		int[] amountRepair = repairCard.getAmounts();

		// Iterate through all values and add the amount of this value to the stack
		for (int i = 0; i < valuesRepair.length; i++) {
			int times = amountRepair[i];
			for (int j = 0; j < times; j++) {
				RepairCard card = new RepairCard(valuesRepair[i]);
				stack.add(card);
			}
		}
		// Initialize StatusCard to get its methods
		StatusCard statusCard = new StatusCard(Constant.GET_ON);
		String[] valuesStatus = statusCard.getPossibleValues();
		int[] amountStatus = statusCard.getAmounts();

		// Iterate through all values and add the amount of this value to the stack
		for (int i = 0; i < valuesStatus.length; i++) {
			int times = amountStatus[i];
			for (int j = 0; j < times; j++) {
				StatusCard card = new StatusCard(valuesStatus[i]);
				stack.add(card);
			}
		}
	}

	/**
	 * This method returns the current size of the stack.
	 * 
	 * @return The number of cards currently in the stack.
	 */
	public int getStackSize() {
		return stack.size();
	}

	/**
	 * This method shuffles the cards in the stack randomly. It takes a random index
	 * with randomNumbers() in the range of the stack size. It then iterates through
	 * the original stack based on its index and swaps the card with the random
	 * index.
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
	 * This method draws the top card from the stack and then removes it from the
	 * stack.
	 * 
	 * @return The card that was on top of the stack.
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
	 * This method adds a discarded card back to the stack.
	 * 
	 * @param discardedCard The card to be added back to the stack.
	 */
	public void addDiscardedCard(Card discardedCard) {
		// Add a discardedCard to the discardPile
		stack.add(discardedCard);
	}

	/**
	 * This method retrieves a card from the stack at a specified index without
	 * removing it.
	 * 
	 * @param i The index of the card to be retrieved.
	 * @return The card at a specified index.
	 */
	public Card get(int i) {
		// Add method to get a card at a specific index
		return stack.get(i);
	}

	/**
	 * This method clears all the cards from the stack, resulting in an empty stack.
	 */
	public void clear() {
		this.stack.clear();
	}

	/**
	 * This method gives access to the current stack of cards.
	 * 
	 * @return A list representing the current stack of cards.
	 */
	public ArrayList<Card> getStack() {
		return this.stack;
	}
}