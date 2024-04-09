package graphics;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

// Importing for testing purposes
import logic.Card;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.GridBagLayout;
import javax.swing.JTextPane;
import java.awt.GridBagConstraints;
import javax.swing.BoxLayout;
import java.awt.Insets;
import javax.swing.JTextArea;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.SystemColor;

public class PlayerHand extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel card1;
	private JLabel card2;
	private JLabel card3;
	private JLabel card4;
	private JLabel card5;
	
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
		
		card1 = new JLabel("");
		card1.setBackground(SystemColor.text);
		GridBagConstraints gbc_card1 = new GridBagConstraints();
		gbc_card1.insets = new Insets(0, 0, 0, 5);
		gbc_card1.gridx = 0;
		gbc_card1.gridy = 0;
		contentPane.add(card1, gbc_card1);
		
		card2 = new JLabel("");
		card2.setBackground(SystemColor.text);
		GridBagConstraints gbc_card2 = new GridBagConstraints();
		gbc_card2.insets = new Insets(0, 0, 0, 5);
		gbc_card2.gridx = 1;
		gbc_card2.gridy = 0;
		contentPane.add(card2, gbc_card2);
		
		card3 = new JLabel("");
		card3.setBackground(SystemColor.text);
		GridBagConstraints gbc_card3 = new GridBagConstraints();
		gbc_card3.insets = new Insets(0, 0, 0, 5);
		gbc_card3.gridx = 2;
		gbc_card3.gridy = 0;
		contentPane.add(card3, gbc_card3);
		
		card4 = new JLabel("");
		card4.setBackground(SystemColor.text);
		GridBagConstraints gbc_card4 = new GridBagConstraints();
		gbc_card4.insets = new Insets(0, 0, 0, 5);
		gbc_card4.gridx = 3;
		gbc_card4.gridy = 0;
		contentPane.add(card4, gbc_card4);
		
		card5 = new JLabel("");
		card5.setBackground(SystemColor.text);
		GridBagConstraints gbc_card5 = new GridBagConstraints();
		gbc_card5.gridx = 4;
		gbc_card5.gridy = 0;
		contentPane.add(card5, gbc_card5);
		
		// Sets the window title and icon
		this.setTitle("Player hand");
		ImageIcon img = new ImageIcon("data/hand_icon.png");
		this.setIconImage(img.getImage());		
		
		// Update Hand Icons
		this.addComponentListener(new ComponentAdapter() {
			
			@Override
			public void componentResized(ComponentEvent e) {
				int width = getWidth();
				
				int cardWidth = width/5;
				
				// fill the cards with icons
				updateHand(hand, cardWidth);
				
			}

		});
		
	}
	
	// Method to display the cards in the GUI
	public void updateHand(ArrayList<Card> hand, int width) {
		
		JLabel[] cards = {card1, card2, card3, card4, card5};
		
		// Calculate height based on scale
		int height = (int) (width * 2.28);
		
		
		// Inspired from https://stackoverflow.com/questions/6444042/java-resize-image-dynamically-to-fit-grids-in-gridlayout
		for (int i = 0; i < hand.size(); i++) {
			
			String filePath = "data/cards/" + hand.get(i).toString() + ".png";
			ImageIcon cardImg = new ImageIcon(filePath);
			Image orignalImg = cardImg.getImage();
			Image resizedImg = orignalImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			cards[i].setIcon(new ImageIcon(resizedImg));
			
		}
		
	}
		
	
}
