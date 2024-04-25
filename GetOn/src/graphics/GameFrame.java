package graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import logic.KilometerCard;
import logic.Player;
import logic.Rules;
import logic.Stack;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JProgressBar;

/**
 * Create GUI for the player table
 */
public class GameFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel player1;
	private JPanel player2;
	private JPanel player3;

	private JLabel lblCardStackCounter;
	private JLabel lblDiscardCounter;
	private JLabel lblDiscardedCard;

	private JLabel lblP1BikeStatus;
	private JLabel lblP2BikeStatus;
	private JLabel lblP3BikeStatus;

	private JLabel lblP1WindStatus;
	private JLabel lblP2WindStatus;
	private JLabel lblP3WindStatus;

	private PlayerHand currentPlayerHand;
	private int currentPlayerIndex;
	private JProgressBar p1Progress;
	private JProgressBar p2Progress;
	private JProgressBar p3Progress;

	private Boolean isExit = false;

	/**
	 * Constructor for the GameFrame
	 * 
	 * @param stack              - Stack of Card
	 * @param discardPile        - Stack of discarded Card
	 * @param players            - Player(s) that participate in the game
	 * @param selectedCardIndex  - int that indicates the selected Card
	 * @param rules              - Rules for the game
	 * @param currentPlayerIndex - int of the Player who's turn it is
	 */
	public GameFrame(Stack stack, Stack discardPile, ArrayList<Player> players, int selectedCardIndex, Rules rules,
			int currentPlayerIndex) {

		this.setVisible(true);
		this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 1238, 625);
		this.currentPlayerIndex = currentPlayerIndex;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Player 1 statuses
		JPanel player1Status = new JPanel();
		player1Status.setBounds(5, 280, 306, 43);
		contentPane.add(player1Status);

		JLabel lblPlayer1Name = new JLabel(players.get(0).getName());
		player1Status.add(lblPlayer1Name);

		JSplitPane splitPane = new JSplitPane();
		player1Status.add(splitPane);

		lblP1BikeStatus = new JLabel(" ");
		splitPane.setLeftComponent(lblP1BikeStatus);

		lblP1WindStatus = new JLabel(" ");
		splitPane.setRightComponent(lblP1WindStatus);

		// Player 1 progressbar
		JPanel P1Progressbar = new JPanel();
		P1Progressbar.setBounds(5, 330, 306, 43);
		contentPane.add(P1Progressbar);

		p1Progress = new JProgressBar();
		P1Progressbar.add(p1Progress);

		// Player 2 statuses
		JPanel player2Status = new JPanel();
		player2Status.setBounds(316, 280, 306, 43);
		contentPane.add(player2Status);

		JLabel lblPlayer2Name = new JLabel(players.get(1).getName());
		player2Status.add(lblPlayer2Name);

		JSplitPane splitPane_1 = new JSplitPane();
		player2Status.add(splitPane_1);

		lblP2BikeStatus = new JLabel(" ");
		splitPane_1.setLeftComponent(lblP2BikeStatus);

		lblP2WindStatus = new JLabel(" ");
		splitPane_1.setRightComponent(lblP2WindStatus);

		// Player 2 progressbar
		JPanel P2Progressbar = new JPanel();
		P2Progressbar.setBounds(316, 330, 306, 43);
		contentPane.add(P2Progressbar);

		p2Progress = new JProgressBar();
		P2Progressbar.add(p2Progress);

		// Player 3 statuses
		JPanel player3Status = new JPanel();
		player3Status.setBounds(627, 280, 306, 43);

		JPanel P3Progressbar = new JPanel();
		P3Progressbar.setBounds(627, 330, 306, 43);

		if (players.size() == 3) {

			JLabel lblPlayer3Name = new JLabel(players.get(2).getName());
			player3Status.add(lblPlayer3Name);

			JSplitPane splitPane_2 = new JSplitPane();
			player3Status.add(splitPane_2);
			contentPane.add(player3Status);

			lblP3BikeStatus = new JLabel(" ");
			splitPane_2.setLeftComponent(lblP3BikeStatus);

			lblP3WindStatus = new JLabel(" ");
			splitPane_2.setRightComponent(lblP3WindStatus);

			contentPane.add(P3Progressbar);

			p3Progress = new JProgressBar();
			P3Progressbar.add(p3Progress);
		}
		player1 = new JPanel();
		player2 = new JPanel();
		player3 = new JPanel();

		JButton btnViewHand = new JButton("View Hand");
		btnViewHand.setBounds(1091, 554, 123, 23);
		btnViewHand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				currentPlayerHand.setVisible(true);

			}
		});
		contentPane.add(btnViewHand);

		JLabel lblDiscardPile = new JLabel("Discard Pile");
		lblDiscardPile.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDiscardPile.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiscardPile.setBounds(645, 30, 85, 14);
		contentPane.add(lblDiscardPile);

		lblDiscardedCard = new JLabel("");
		lblDiscardedCard.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiscardedCard.setBounds(626, 55, 128, 169);
		contentPane.add(lblDiscardedCard);

		JLabel lblCardStack = new JLabel("Card Stack");
		lblCardStack.setHorizontalAlignment(SwingConstants.CENTER);
		lblCardStack.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCardStack.setBounds(358, 30, 85, 14);
		contentPane.add(lblCardStack);

		JLabel lblCardStackIcon = new JLabel("");
		lblCardStackIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblCardStackIcon.setBounds(343, 55, 128, 169);
		contentPane.add(lblCardStackIcon);

		lblCardStackCounter = new JLabel("0");
		lblCardStackCounter.setHorizontalAlignment(SwingConstants.CENTER);
		lblCardStackCounter.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCardStackCounter.setBounds(490, 131, 85, 53);
		contentPane.add(lblCardStackCounter);

		lblDiscardCounter = new JLabel("0");
		lblDiscardCounter.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiscardCounter.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDiscardCounter.setBounds(761, 131, 85, 53);
		contentPane.add(lblDiscardCounter);

		ImageIcon stackIcon = new ImageIcon("data/stack_of_cards.png");
		Image orignalImg = stackIcon.getImage();
		int width = lblCardStackIcon.getWidth();
		int height = lblCardStackIcon.getHeight();
		Image resizedImg = orignalImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		lblCardStackIcon.setIcon(new ImageIcon(resizedImg));

		JButton btnSaveQuit = new JButton("Save & Quit");
		btnSaveQuit.addMouseListener(new MouseAdapter() {

			/**
			 * Method to handle mouse click
			 * 
			 * @param e - location of mouse click
			 */
			public void mouseClicked(MouseEvent e) {
				isExit = true;
				JOptionPane.showMessageDialog(GameFrame.this, "Game will be ended after finishing this turn.");
			}
		});
		btnSaveQuit.setBounds(1091, 21, 123, 23);
		contentPane.add(btnSaveQuit);

		refreshGameFrame(stack, discardPile, players, players.get(currentPlayerIndex), rules, selectedCardIndex,
				currentPlayerIndex);
		repaint();
	}

	private void addCardWithCounter(JPanel panel, JLabel cardLabel, int count) {
		JLabel counterLabel = new JLabel(String.valueOf(count)); // Convert count to string
		counterLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(cardLabel);
		panel.add(counterLabel); // Add counter label to the panel

	}

	private JLabel createCardLabel(String labelText) {
		JLabel label = new JLabel(labelText);
		return label;
	}

	/**
	 * Method to refresh the scores shown on the game table
	 * 
	 * @param players            - ArrayList of Player that participate
	 * @param currentPlayerIndex - int of the Player who's turn it is
	 */
	public void refreshScores(ArrayList<Player> players, int currentPlayerIndex) {
		int kmProgress;

		contentPane.remove(player1);
		contentPane.remove(player2);
		contentPane.remove(player3);

		Border player1border;
		player1 = new JPanel();
		player1.setBounds(5, 430, 306, 152);
		if (currentPlayerIndex == 0) {
			player1border = BorderFactory.createLineBorder(Color.green, 5, true);
		} else {
			player1border = BorderFactory.createLineBorder(Color.red, 5, true);
		}
		player1.setBorder(player1border);
		contentPane.add(player1);

		addCardWithCounter(player1, createCardLabel("| 5 Km cards: "),
				players.get(0).getPlayedCards().countCards(new KilometerCard("FIVE")));
		addCardWithCounter(player1, createCardLabel("| 6 Km cards: "),
				players.get(0).getPlayedCards().countCards(new KilometerCard("SIX")));
		addCardWithCounter(player1, createCardLabel("| 8 Km cards: "),
				players.get(0).getPlayedCards().countCards(new KilometerCard("EIGHT")));
		addCardWithCounter(player1, createCardLabel("| 10 Km cards: "),
				players.get(0).getPlayedCards().countCards(new KilometerCard("TEN")));

		kmProgress = players.get(0).getKmProgress();

		Border player2border;
		player2 = new JPanel();
		player2.setBounds(316, 430, 306, 152);
		if (currentPlayerIndex == 1) {
			player2border = BorderFactory.createLineBorder(Color.green, 5, true);
		} else {
			player2border = BorderFactory.createLineBorder(Color.red, 5, true);
		}
		player2.setBorder(player2border);
		contentPane.add(player2);

		addCardWithCounter(player2, createCardLabel("| 5 Km cards: "),
				players.get(1).getPlayedCards().countCards(new KilometerCard("FIVE")));
		addCardWithCounter(player2, createCardLabel("| 6 Km cards: "),
				players.get(1).getPlayedCards().countCards(new KilometerCard("SIX")));
		addCardWithCounter(player2, createCardLabel("| 8 Km cards: "),
				players.get(1).getPlayedCards().countCards(new KilometerCard("EIGHT")));
		addCardWithCounter(player2, createCardLabel("| 10 Km cards: "),
				players.get(1).getPlayedCards().countCards(new KilometerCard("TEN")));

		kmProgress = players.get(0).getKmProgress();
		p1Progress.setStringPainted(true);
		p1Progress.setValue(kmProgress);
		p1Progress.setString(kmProgress + " KM travelled");

		kmProgress = players.get(1).getKmProgress();
		p2Progress.setStringPainted(true);
		p2Progress.setValue(kmProgress);
		p2Progress.setString(kmProgress + " KM travelled");

		if (players.size() == 3) {
			player3 = new JPanel();
			player3.setBounds(627, 430, 324, 152);
			Border player3border;
			if (currentPlayerIndex == 2) {
				player3border = BorderFactory.createLineBorder(Color.green, 5, true);
			} else {
				player3border = BorderFactory.createLineBorder(Color.red, 5, true);
			}
			player3.setBorder(player3border);
			contentPane.add(player3);

			addCardWithCounter(player3, createCardLabel("| 5 Km cards: "),
					players.get(2).getPlayedCards().countCards(new KilometerCard("FIVE")));
			addCardWithCounter(player3, createCardLabel("| 6 Km cards: "),
					players.get(2).getPlayedCards().countCards(new KilometerCard("SIX")));
			addCardWithCounter(player3, createCardLabel("| 8 Km cards: "),
					players.get(2).getPlayedCards().countCards(new KilometerCard("EIGHT")));
			addCardWithCounter(player3, createCardLabel("| 10 Km cards: "),
					players.get(2).getPlayedCards().countCards(new KilometerCard("TEN")));

			kmProgress = players.get(2).getKmProgress();
			p3Progress.setStringPainted(true);
			p3Progress.setValue(kmProgress);
			p3Progress.setString(kmProgress + " KM travelled");

		}
		contentPane.revalidate();
		contentPane.repaint();
	}

	/**
	 * Method to refresh the graphics shown on the game table
	 * 
	 * @param stack              - Stack of Card
	 * @param discardPile        - Stack of discarded Card
	 * @param players            - ArrayList of Player that participate
	 * @param currentPlayer      - Player who's turn it is
	 * @param rules              - Rules of the game
	 * @param selectedCardIndex  - int that indicates the selected Card
	 * @param currentPlayerIndex - int of the Player who's turn it is
	 */
	public void refreshGameFrame(Stack stack, Stack discardPile, ArrayList<Player> players, Player currentPlayer,
			Rules rules, int selectedCardIndex, int currentPlayerIndex) {

		lblCardStackCounter.setText("" + stack.getStackSize());
		lblDiscardCounter.setText("" + discardPile.getStackSize());
		refreshScores(players, currentPlayerIndex);

		if (discardPile.getStackSize() != 0) {
			String cardPath = discardPile.get(discardPile.getStackSize() - 1).toString();
			ImageIcon cardIcon = new ImageIcon("data/cards/" + cardPath + ".png");
			Image originalImg = cardIcon.getImage();
			int width = lblDiscardedCard.getWidth();
			int height = lblDiscardedCard.getHeight();
			Image resizedImg = originalImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			lblDiscardedCard.setIcon(new ImageIcon(resizedImg));
		}
		// Player1 status update
		if (!players.get(0).getOnBikeStatus()) {
			if (players.get(0).getBulliedStatus()) {
				lblP1BikeStatus.setText("" + players.get(0).getBulliedType());
			} else {
				lblP1BikeStatus.setText("Not on the bike.");
			}
		} else {
			lblP1BikeStatus.setText("On bike");
		}
		if (players.get(0).getHasWind()) {
			lblP1WindStatus.setText("Tailwind");
		} else {
			lblP1WindStatus.setText("Headwind");
		}
		// Player2 status update
		if (!players.get(1).getOnBikeStatus()) {
			if (players.get(1).getBulliedStatus()) {
				lblP2BikeStatus.setText("" + players.get(1).getBulliedType());
			} else {
				lblP2BikeStatus.setText("Not on the bike.");
			}
		} else {
			lblP2BikeStatus.setText("On bike");
		}
		if (players.get(1).getHasWind()) {
			lblP2WindStatus.setText("Tailwind");
		} else {
			lblP2WindStatus.setText("Headwind");
		}
		// Player3 status update
		if (players.size() == 3) {
			if (!players.get(2).getOnBikeStatus()) {
				if (players.get(2).getBulliedStatus()) {
					lblP3BikeStatus.setText("" + players.get(2).getBulliedType());
				} else {
					lblP3BikeStatus.setText("Not on the bike.");
				}
			} else {
				lblP3BikeStatus.setText("On bike");
			}
			if (players.get(2).getHasWind()) {
				lblP3WindStatus.setText("Tailwind");
			} else {
				lblP3WindStatus.setText("Headwind");
			}
		}
		contentPane.revalidate();
		contentPane.repaint();
	}

	/**
	 * Method which updates the graphics of the players hand
	 * 
	 * @param playerHand - The hand of the player
	 */
	public void updatePlayerHand(PlayerHand playerHand) {
		currentPlayerHand = playerHand;
	}

	/**
	 * Method which shows a dialog which congratulates the player that has won the
	 * game.
	 * 
	 * @param currentPlayer - The player who's turn it is when the game finishes
	 */
	public void winGame(Player currentPlayer) {
		JOptionPane.showMessageDialog(this, "Congrats! " + currentPlayer.getName() + " has won the game.");
	}

	/**
	 * Method which closes the game frem when it ends.
	 * 
	 * @return game exits
	 */
	public boolean getIsExit() {
		return isExit;
	}
}
