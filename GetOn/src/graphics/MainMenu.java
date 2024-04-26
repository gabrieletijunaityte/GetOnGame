package graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

/**
 * Create GUI for the Main Menu
 */
public class MainMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private boolean receivedNames = false;
	private boolean isTestGame = false;

	private JTextField player1Name;
	private JTextField player2Name;
	private JTextField player3Name;

	private JButton btnTestGame;
	private JButton btnStartGame;
	private JLabel playerLabel;

	/**
	 * Constructor for Main Menu
	 * 
	 * @param names - Names of the Players
	 */
	public MainMenu(ArrayList<String> names) {
		this.setVisible(true);
		this.setAlwaysOnTop(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 738, 397);

		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("GET ON");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel.setBounds(279, 31, 171, 63);
		contentPane.add(lblNewLabel);

		player1Name = new JTextField();
		player1Name.setBounds(328, 142, 197, 27);
		contentPane.add(player1Name);
		player1Name.setColumns(10);

		JButton btnViewRules = new JButton("View Rules");
		btnViewRules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RulesFrame rulesPopup = new RulesFrame();
			}
		});
		btnViewRules.setBounds(565, 326, 149, 23);
		contentPane.add(btnViewRules);

		JLabel lblNewLabel_1 = new JLabel("Player 1:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(230, 144, 89, 21);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Player 2:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(230, 182, 89, 21);
		contentPane.add(lblNewLabel_1_1);

		player2Name = new JTextField();
		player2Name.setColumns(10);
		player2Name.setBounds(328, 180, 197, 27);
		contentPane.add(player2Name);

		JLabel lblNewLabel_1_2 = new JLabel("Player 3:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(230, 216, 89, 21);
		contentPane.add(lblNewLabel_1_2);

		player3Name = new JTextField();
		player3Name.setColumns(10);
		player3Name.setBounds(328, 214, 197, 27);
		contentPane.add(player3Name);

		playerLabel = new JLabel("Enter player names");
		playerLabel.setForeground(Color.BLACK);
		playerLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		playerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		playerLabel.setBounds(66, 92, 593, 27);
		contentPane.add(playerLabel);

		btnStartGame = new JButton("Start Game");

		// Button to start the testgame, instead of a normal game
		btnTestGame = new JButton("Start Test Game");
		btnTestGame.setBounds(368, 264, 157, 38);
		contentPane.add(btnTestGame);

		btnStartGame.addActionListener(new ActionListener() {
			/**
			 * Action listener that starts the game when the button is clicked
			 */
			public void actionPerformed(ActionEvent e) {
				// Notifies game loop that the normal game was started
				isTestGame = false;
				// Handles the start of the game
				handleStartGame(names);
			}
		});
		btnStartGame.setBounds(230, 264, 128, 38);
		contentPane.add(btnStartGame);

		btnTestGame.addActionListener(new ActionListener() {
			/**
			 * Action listener that starts the test game when the button is clicked
			 */
			public void actionPerformed(ActionEvent e) {				
				// Notifies game loop that the test game was started
				isTestGame = true;
				// Starts the game when clicking the button
				handleStartGame(names);
			}
		});
		this.setTitle("Get On - The Classic Cycling game");
		repaint();
	}

	/**
	 * Method to check for if the Names of the Players are received.
	 * 
	 * @return receivedNames - boolean, whether player names are entered or not.
	 */
	public boolean getReceivedNames() {
		return receivedNames;
	}

	/**
	 * Method to check if a test is game is started.
	 * 
	 * @return isTestGame - boolean, whether it is a test game or not.
	 */
	public boolean getIsTestGame() {
		return isTestGame;
	}

	/**
	 * Method to reset the booleans receivedNames and isTestGame.
	 */
	public void resetBoolean() {
		receivedNames = false;
		isTestGame = false;
	}

	/**
	 * Method to end the game when one player wins the game.
	 */
	public void endGame() {
		resetBoolean();
		playerLabel.setText("Enter player names");
		playerLabel.setForeground(Color.BLACK);
		btnStartGame.setVisible(true);
		btnTestGame.setVisible(true);
		player1Name.setEditable(true);
		player2Name.setEditable(true);
		player3Name.setEditable(true);
		repaint();
	}
	
	/**
	 * Method to save the names or warn the user that at least player 1 and 2 are
	 * needed. Starts the game
	 */
	private void handleStartGame(ArrayList<String> names) {
		// Saves the entered names
		if (!player1Name.getText().isBlank() && !player2Name.getText().isBlank()) {
			names.add(player1Name.getText());
			names.add(player2Name.getText());
			if (!player3Name.getText().isBlank()) {
				names.add(player3Name.getText());
			}
		} else {
			// Warns user that you need at least two players
			playerLabel.setText("Enter at least two player names to start!");
			playerLabel.setForeground(Color.RED);
		}

		// Flags the game loop that names have been entered
		if (names.size() != 0) {
			receivedNames = true;

			// Notifies the Game Master that the game has been started and locks the
			// changing of some settings.
			playerLabel.setText("The game has been started.");
			playerLabel.setForeground(Color.BLACK);
			btnStartGame.setVisible(false);
			btnTestGame.setVisible(false);
			player1Name.setEditable(false);
			player2Name.setEditable(false);
			player3Name.setEditable(false);
		}
	}
	
	
}
