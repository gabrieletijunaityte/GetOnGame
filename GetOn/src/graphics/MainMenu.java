package graphics;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Card;
import logic.Player;
import logic.Stack;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class MainMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField player1Name;
	private JTextField player2Name;
	private JTextField player3Name;

	/**
	 * Launch the application.
	 * @param thirdPlayer 
	 * @param secondPlayer 
	 * @param firstPlayer 
	 * @return 
	 */
	public static void  main(String[] args, Player firstPlayer, Player secondPlayer, Player thirdPlayer, Stack stack, String discardedCardName, 
			ArrayList<Card> hand) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu(firstPlayer, secondPlayer, thirdPlayer, stack, discardedCardName, hand);
					frame.setVisible(true);
					frame.setAlwaysOnTop(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 * @param thirdPlayer 
	 * @param secondPlayer 
	 * @param firstPlayer 
	 */
	public MainMenu(Player firstPlayer, Player secondPlayer, Player thirdPlayer, Stack stack, String discardedCardName, ArrayList<Card> hand) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GET ON");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel.setBounds(285, 29, 137, 63);
		contentPane.add(lblNewLabel);
		
		player1Name = new JTextField();
		player1Name.setBounds(328, 142, 197, 27);
		contentPane.add(player1Name);
		player1Name.setColumns(10);
		
		JButton btnViewRules = new JButton("View Rules");
		btnViewRules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RulesFrame.main(null);
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
		
		JLabel playerLabel = new JLabel("Enter player names");
		playerLabel.setForeground(Color.BLACK);
		playerLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		playerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		playerLabel.setBounds(66, 92, 593, 27);
		contentPane.add(playerLabel);
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.addActionListener(new ActionListener() {

		

			public void actionPerformed(ActionEvent e) {
				
				// Allows the user to start the game whilst initializing players
				Boolean canStart = false;
				
				if (!player1Name.getText().isBlank() && !player2Name.getText().isBlank()){

					firstPlayer.changeName(player1Name.getText());
					secondPlayer.changeName(player2Name.getText());
					canStart = true;
					
				} else if (!player3Name.getText().isBlank()) {
					
					thirdPlayer.changeName(player3Name.getText());
					
				} else {
					
					// Warns user that you need at least two players
					playerLabel.setText("Enter at least two player names to start!");
					playerLabel.setForeground(Color.RED);
					
				}
				
				if (canStart == true) {
					
					
					// Launches the GameFrame and closes main menu
					GameFrame.main(null, stack, discardedCardName, hand);
					dispose();
					
				}
				
			}

		});
		
		btnStartGame.setBounds(305, 263, 128, 38);
		contentPane.add(btnStartGame);
		
		this.setTitle("Get On - The Classic Cycling game");
		
	}
}
