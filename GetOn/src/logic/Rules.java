package logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;

import utilities.Constant;

/**
 * Loads the game rules from a text file, and checks whether the card can be played.
 */
public class Rules {
	
	private String rules = readRules();
	
	/**
	 * Constructs a new Rules object and loading it from a text file.
	 * 
	 * @return A single string containing all rules.
	 */
	private String readRules() {
		
		String defaultRules = "";
	
		// Inspired by: https://stackoverflow.com/questions/14171732/how-to-keep-text-file-contents-in-same-format-after-replacing-a-string
		try {
			// Read the text file that contains the rules
			File file = new File("data/rules.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = "";
			
			// Add every single line to the empty default rules
			while ((line = reader.readLine()) != null){
				defaultRules += line + System.lineSeparator();
			}
			reader.close();
			
		} catch (NoSuchElementException | IllegalStateException | IOException e) {
			System.err.println("Error reading text file. Terminating.");
		}
		return defaultRules;
	}
	
	/**
	 * This method is used to retrieve the rules.
	 * 
	 * @return A single string containing all game rules.
	 */
	public String getRules() {
		return rules;
	}
	
	/**
	 * Evaluates the requirements of the card against the status of the player and
	 * checks whether the maximum number of the same card type has been reached.
	 *
	 * @param card The card to evaluate.
	 * @param player The player attempting to play the card.
	 * @return {@code true} if the card can be played, {@code false} is the card cannot be played.
	 */
	public Boolean isPlayble(Card card, Player player) {
		String[] requirements = card.getRequirements();
		String[] playerStatus = player.getStatuses();

		for (int i = 0; i < playerStatus.length; i++) {
			if (!requirements[i].equals(Constant.IGNORE)) {
				if (!requirements[i].equals(playerStatus[i])) {
					return false;
				}
			}
		}
		
		// check if max amount of cards is not reached
		int maxNum = Integer.parseInt(requirements[4]);
		
		if (maxNum != -1 && player.getPlayedCards().countCards(card) > maxNum) {
			return false;
		}
		return true;
	}	
}