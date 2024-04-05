package graphics;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

// Importing for testing purposes
import logic.Card;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JTextPane;
import java.awt.GridBagConstraints;
import javax.swing.BoxLayout;
import java.awt.Insets;
import javax.swing.JTextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;

public class PlayerHand extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField card1;
	private JTextField card2;
	private JTextField card3;
	private JTextField card4;
	private JTextField card5;
	
	/**
	 * Launch the application.
	 * @param hand 
	 */
	public static void main(String[] args, ArrayList<Card> hand) {
		
		// Information passed by game of the current player's hand
		ArrayList<Card> currentPlayerHand = hand;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerHand frame = new PlayerHand(currentPlayerHand);
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
	 */
	public PlayerHand(ArrayList<Card> hand) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 986, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{192, 192, 192, 192, 192, 0};
		gbl_contentPane.rowHeights = new int[]{437, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		card1 = new JTextField();
		card1.setBackground(Color.WHITE);
		card1.setEditable(false);
		GridBagConstraints gbc_card1 = new GridBagConstraints();
		gbc_card1.insets = new Insets(0, 0, 0, 5);
		gbc_card1.fill = GridBagConstraints.BOTH;
		gbc_card1.gridx = 0;
		gbc_card1.gridy = 0;
		contentPane.add(card1, gbc_card1);
		card1.setColumns(10);
		card1.setHorizontalAlignment(JTextField.CENTER);
		
		card2 = new JTextField();
		card2.setHorizontalAlignment(SwingConstants.CENTER);
		card2.setEditable(false);
		card2.setColumns(10);
		card2.setBackground(Color.WHITE);
		GridBagConstraints gbc_card2 = new GridBagConstraints();
		gbc_card2.insets = new Insets(0, 0, 0, 5);
		gbc_card2.fill = GridBagConstraints.BOTH;
		gbc_card2.gridx = 1;
		gbc_card2.gridy = 0;
		contentPane.add(card2, gbc_card2);
		
		card3 = new JTextField();
		card3.setHorizontalAlignment(SwingConstants.CENTER);
		card3.setEditable(false);
		card3.setColumns(10);
		card3.setBackground(Color.WHITE);
		GridBagConstraints gbc_card3 = new GridBagConstraints();
		gbc_card3.insets = new Insets(0, 0, 0, 5);
		gbc_card3.fill = GridBagConstraints.BOTH;
		gbc_card3.gridx = 2;
		gbc_card3.gridy = 0;
		contentPane.add(card3, gbc_card3);
		
		card4 = new JTextField();
		card4.setHorizontalAlignment(SwingConstants.CENTER);
		card4.setEditable(false);
		card4.setColumns(10);
		card4.setBackground(Color.WHITE);
		GridBagConstraints gbc_card4 = new GridBagConstraints();
		gbc_card4.insets = new Insets(0, 0, 0, 5);
		gbc_card4.fill = GridBagConstraints.BOTH;
		gbc_card4.gridx = 3;
		gbc_card4.gridy = 0;
		contentPane.add(card4, gbc_card4);
		
		card5 = new JTextField();
		card5.setHorizontalAlignment(SwingConstants.CENTER);
		card5.setEditable(false);
		card5.setColumns(10);
		card5.setBackground(Color.WHITE);
		GridBagConstraints gbc_card5 = new GridBagConstraints();
		gbc_card5.fill = GridBagConstraints.BOTH;
		gbc_card5.gridx = 4;
		gbc_card5.gridy = 0;
		contentPane.add(card5, gbc_card5);
		
		// Sets the window title and icon
		this.setTitle("Player hand");
		ImageIcon img = new ImageIcon("data/hand_icon.png");
		this.setIconImage(img.getImage());		
		
		updateHand(hand);
		
	}
	
	// Method to display the cards in the GUI
	public void updateHand(ArrayList<Card> hand) {
		
		JTextField[] cards = {card1, card2, card3, card4, card5};
		
		for (int i = 0; i < hand.size(); i++) {
			cards[i].setText(hand.get(i).toString());
		}
		
	}
		
	
}
