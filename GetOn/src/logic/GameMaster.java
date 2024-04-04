package logic;

import java.util.Scanner;

public class GameMaster {
	
	/* Method which calls the changeName method in Player
	 * All the empty spaces before and after the entered name are removed
	 * The method won't accept an empty string as a new name for a player and asks to enter a valid name
	 */
	public void changeName(Player player) {
		
		Scanner input = new Scanner(System.in);
		
		String newName;
		
		do {
			System.out.printf("Please enter new name for player %s:", player.getName());
			newName = input.nextLine().trim();
			if (newName.isEmpty()) {
				System.out.println("Name cannot be empty. Please enter a name:");
			}
		} while (newName.isEmpty());
		player.changeName(newName);
		System.out.println("Name updated successfully");
		
		player.changeName(newName);
		
		System.out.printf("Player name changed successfully to %s.", player.getName());
	}
	
}
