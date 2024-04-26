package graphics;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

// Importing for testing purposes
import logic.Card;
import logic.Player;
import logic.Rules;

import java.awt.Image;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.BorderFactory;

import java.awt.Insets;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Class to create the GUI for the hand of the player
 */
public class PlayerHand extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JLabel card1;
	private JLabel card2;
	private JLabel card3;
	private JLabel card4;
	private JLabel card5;

	// Initialize receivedSelectedCard boolean which indicates if a card is chosen
	// from the hand
	private boolean receivedSelectedCard = false;

	// Initialize selectedCardIndex as an AtomicInteger
	private int selectedCardIndex = 0;

	// Initialize playedCard
	private boolean isPlayedCard = false;

	// Initialize selectedBulliedPlayer
	private boolean selectBulliedPlayer = false;
	private int methodIndex;
	private Player currentPlayer;
	private int choice;

	/**
	 * Constructor of the PlayerHand
	 * 
	 * @param player - the player to show the hand
	 * @param rules  - the rules to determine which cards are playable and which
	 *               aren't.
	 */
	public PlayerHand(Player player, Rules rules) {
		this.setAlwaysOnTop(true);
		this.currentPlayer = player;

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 986, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 192, 192, 192, 192, 192, 0 };
		gbl_contentPane.rowHeights = new int[] { 437, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);
		card1 = new JLabel("");

		// change the selectedCardIndex to which card is clicked.
		card1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedCardIndex = 0;
				receivedSelectedCard = true;
				showPopupDialog();
			}
		});
		card1.setBackground(SystemColor.text);
		GridBagConstraints gbc_card1 = new GridBagConstraints();
		gbc_card1.insets = new Insets(0, 0, 0, 5);
		gbc_card1.gridx = 0;
		gbc_card1.gridy = 0;
		contentPane.add(card1, gbc_card1);

		card2 = new JLabel("");

		// change the selectedCardIndex to which card is clicked.
		card2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedCardIndex = 1;
				receivedSelectedCard = true;
				showPopupDialog();
			}
		});
		card2.setBackground(SystemColor.text);
		GridBagConstraints gbc_card2 = new GridBagConstraints();
		gbc_card2.insets = new Insets(0, 0, 0, 5);
		gbc_card2.gridx = 1;
		gbc_card2.gridy = 0;
		contentPane.add(card2, gbc_card2);

		card3 = new JLabel("");

		// change the selectedCardIndex to which card is clicked.
		card3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedCardIndex = 2;
				receivedSelectedCard = true;
				showPopupDialog();
			}
		});
		card3.setBackground(SystemColor.text);
		GridBagConstraints gbc_card3 = new GridBagConstraints();
		gbc_card3.insets = new Insets(0, 0, 0, 5);
		gbc_card3.gridx = 2;
		gbc_card3.gridy = 0;
		contentPane.add(card3, gbc_card3);

		card4 = new JLabel("");

		// change the selectedCardIndex to which card is clicked.
		card4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedCardIndex = 3;
				receivedSelectedCard = true;
				showPopupDialog();
			}
		});
		card4.setBackground(SystemColor.text);
		GridBagConstraints gbc_card4 = new GridBagConstraints();
		gbc_card4.insets = new Insets(0, 0, 0, 5);
		gbc_card4.gridx = 3;
		gbc_card4.gridy = 0;
		contentPane.add(card4, gbc_card4);

		card5 = new JLabel("");

		// change the selectedCardIndex to which card is clicked.
		card5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedCardIndex = 4;
				receivedSelectedCard = true;
				showPopupDialog();
			}
		});
		card5.setBackground(SystemColor.text);
		GridBagConstraints gbc_card5 = new GridBagConstraints();
		gbc_card5.gridx = 4;
		gbc_card5.gridy = 0;
		contentPane.add(card5, gbc_card5);

		// Sets the window title and icon
		this.setTitle(currentPlayer.getName() + "'s hand");
		ImageIcon img = new ImageIcon("data/hand_icon.png");
		this.setIconImage(img.getImage());

		// Update Hand Icons
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				int width = getWidth();
				int cardWidth = width / 5;

				// fill the cards with icons
				updateHand(cardWidth, currentPlayer, rules);
			}
		});
		repaint();
	}

	/**
	 * Method to display the cards in the GUI
	 * 
	 * @param width         - used to calculate the size of the hand
	 * @param currentPlayer - the player whose hand is shown
	 * @param rules         - the rules to see which card is playable
	 */
	public void updateHand(int width, Player currentPlayer, Rules rules) {
		this.currentPlayer = currentPlayer;
		JLabel[] cards = { card1, card2, card3, card4, card5 };
		setTitle(currentPlayer.getName() + "'s hand");

		// Calculate height based on scale
		int height = (int) (width * 2.28);

		// Inspired from
		// https://stackoverflow.com/questions/6444042/java-resize-image-dynamically-to-fit-grids-in-gridlayout
		for (int i = 0; i < currentPlayer.getHand().size(); i++) {
			Border border;
			String filePath = "data/cards/" + currentPlayer.getHand().get(i).toString() + ".png";
			ImageIcon cardImg = new ImageIcon(filePath);
			Image orignalImg = cardImg.getImage();
			Image resizedImg = orignalImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			cards[i].setIcon(new ImageIcon(resizedImg));
			Card card = currentPlayer.getHand().get(i);

			// Check if card is playable and set corresponding border color
			if (rules.isPlayble(card, currentPlayer)) {
				border = BorderFactory.createLineBorder(Color.green, 10, true);
			} else {
				border = BorderFactory.createLineBorder(Color.red, 10, true);
			}
			cards[i].setBorder(border);
		}
		repaint();
	}

	/**
	 * Method for getting boolean that indicates if a card is clicked
	 * 
	 * @return receivedSelectedCard - boolean that shows if a card is clicked or not
	 */
	public boolean getReceivedSelectedCard() {
		return receivedSelectedCard;
	}

	/**
	 * \ Method for getting selectedCardIndex
	 * 
	 * @return selectedCardIndex - int of the index of the card that is selected
	 */
	public int getSelectedCardIndex() {
		return selectedCardIndex;
	}

	/**
	 * Method to show pop-up message to play bully card to player
	 * 
	 * @param names - names of the players that can be bullied
	 * @return bullyIndex - int of the index of the player that will be bullied
	 */
	public int showSelectPlayerToBully(ArrayList<String> names) {
		if (names.size() == 2) {
			Object[] options = { names.get(0), names.get(1) };
			choice = JOptionPane.showOptionDialog(this, "Choose which player to bully", "Bully player",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		} else {
			Object[] options = { names.get(0), names.get(1), names.get(2) };
			choice = JOptionPane.showOptionDialog(this, "Choose which player to bully", "Bully player",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		}
		// Check for the option selected
		if (choice == 0) {
			methodIndex = 0;
			JOptionPane.showMessageDialog(this, names.get(0) + " is bullied.");
		} else if (choice == 1) {
			methodIndex = 1;
			JOptionPane.showMessageDialog(this, names.get(1) + " is bullied.");
		} else if (choice == 2) {
			methodIndex = 2;
			JOptionPane.showMessageDialog(this, names.get(2) + " is bullied.");
		}
		int bullyIndex = methodIndex;
		selectBulliedPlayer = true;
		return bullyIndex;
	}

	/**
	 * Method to return selectBulliedPlayer
	 * 
	 * @return selectBulliedPlayer - boolean to keep game waiting till bullied
	 *         player is selected
	 */
	public boolean getReceivedPlayerToBully() {
		return selectBulliedPlayer;
	}

	/**
	 * Method for showing a pop-up message, to play or discard the selected card
	 */
	public void showPopupDialog() {
		// create options to either "Play" or "Discard" card
		Object[] options = { "Play", "Discard" };

		int choice = JOptionPane.showOptionDialog(this, "Choose an action for this card:", "Card Action",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		// Check for the option selected
		if (choice == 0) {
			methodIndex = 0;
		} else if (choice == 1) {
			methodIndex = 1;
		}
		// Close hand after playing
		dispose();

		isPlayedCard = true;

	}

	/**
	 * method to return isPlayedCard
	 * 
	 * @return boolean - Whether a card is played or not
	 */
	public boolean getIsPlayedCard() {
		return isPlayedCard;
	}

	/**
	 * Method to return getMethodIndex
	 * 
	 * @return int - that shows index of the method
	 */
	public int getMethodIndex() {
		return methodIndex;
	}

	/**
	 * Method to reset selectedCardIndex to false
	 */
	public void resetBooleans() {
		receivedSelectedCard = false;
		isPlayedCard = false;
		selectBulliedPlayer = false;
	}

	/**
	 * Method to show a popup message about the card being played or not
	 * 
	 * @param msgIndex - index of the message to be shown
	 */
	public void popupMessage(int msgIndex) {
		// Shows popup with correct message passed by Game.
		switch (msgIndex) {
		case 1:
			JOptionPane.showMessageDialog(PlayerHand.this, "Card is Played.");
			break;
		case 2:
			JOptionPane.showMessageDialog(PlayerHand.this, "Card is Discarded.");
			break;
		case 3:
			JOptionPane.showMessageDialog(PlayerHand.this, "Card is not playable. Discarded instead.");
			break;
		}
	}
}
