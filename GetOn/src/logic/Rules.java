package logic;

// Import required functionalities
import java.io.IOException;
import java.lang.IllegalStateException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;


// Create rule class
public class Rules {
	
	// Set the default rules of the game
	private String rules = readRules();
	
	// Method to load the rules from the data folder
	private static String readRules() {
		
		String defaultRules = "";
		
		try (Scanner input = new Scanner(Paths.get("data/rules.txt"))) {
			
			while (input.hasNext()) {
				defaultRules += " ";
				defaultRules += input.next();
			}
			
		} catch (NoSuchElementException | IllegalStateException | IOException e) {
			System.err.println("Error reading text file. Terminating.");
		}
		
		return defaultRules;
		
	}
	
	// Method to show the rules to a spectator
	public String getRules() {
		return rules;
	}
	
}
