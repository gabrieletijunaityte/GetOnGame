package logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
	
	// Method to show the rules to a spectator
	public String getRules() {
		return rules;
	}
	
}
