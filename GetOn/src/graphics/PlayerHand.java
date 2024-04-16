package graphics;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

// Importing for testing purposes
import logic.Card;
// Importing Game Frame
import graphics.GameFrame;

import java.awt.Image;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;


import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//import AtomicInteger in order to be able to override selectedCardIndex
//https://stackoverflow.com/questions/51686465/local-variable-count-defined-in-an-enclosing-scope-must-be-final-or-effectively
//https://stackoverflow.com/questions/38402493/local-variable-log-defined-in-an-enclosing-scope-must-be-final-or-effectively-fi
import java.util.concurrent.atomic.AtomicInteger;

public class PlayerHand extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel card1;
	private JLabel card2;
	private JLabel card3;
	private JLabel card4;
	private JLabel card5;
	// initialise receivedSelectedCard boolean which indicates if a card is chosen from the hand
	public static boolean receivedSelectedCard = false;
	// initialise selectedCardIndex as an AtomicInteger
	private static AtomicInteger selectedCardIndex = new AtomicInteger(0);
	// initialize playedCard
	private static boolean isPlayedCard = false;
	// initialize methodIndex to play the card
	private static int methodIndex;
	
	/**
	 * Launch the application.
	 * @param hand 
	 */
	public static void main(String[] args, ArrayList<Card> hand, int selectedCardIndex) {
		
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
	    
//	    // Add mouse listener to select a card based on where the mouse is clicked
//	    contentPane.addMouseListener(new MouseAdapter() {
//	        @Override
//	        public void mouseClicked(MouseEvent e) {
//	            // Get location of the click to calculate the card that's selected
//	        	int clickLocation = e.getX();
//	            int cardWidth = contentPane.getWidth() / hand.size();
//	            int clickedCardIndex = clickLocation / cardWidth;
//
//	            // If the card width is greater than 0 and less than the hand size
//	            if (clickedCardIndex >= 0 && clickedCardIndex < hand.size()) {
//	                Card clickedCard = hand.get(clickedCardIndex);
//	                System.out.println("Mouse clicked on card " + clickedCardIndex);
//	                // Get card type and card value for subsequent steps, catch the error if not possible
//	                try {
//	                    String cardType = clickedCard.getType();
//	                    String cardValue = clickedCard.getValue();
//	                    System.out.println("Clicked card type: " + cardType + ", card value: " + cardValue);
//	                } 
//	                catch (Exception ex) {
//	                    ex.printStackTrace();
//	                }
//	            }
//	        }
//	    });
	    
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{192, 192, 192, 192, 192, 0};
		gbl_contentPane.rowHeights = new int[]{437, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		card1 = new JLabel("");
		// change the selectedCardIndex to which card is clicked.
		card1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedCardIndex.set(0);
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
				selectedCardIndex.set(1);
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
				selectedCardIndex.set(2);
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
				selectedCardIndex.set(3);
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
				selectedCardIndex.set(4);
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
	
	// method for getting boolean that indicates if a card is clicked
	public static boolean getReceivedSelectedCard() {
		return receivedSelectedCard;
	}
	
	
	// method for getting selectedCardIndex
	public static AtomicInteger getSelectedCardIndex() {
		return selectedCardIndex;
	}
	
	// method for showing a pop-up message, to play or discard the selected card
    public void showPopupDialog() {
    	
    	// create options to either "Play" or "Discard" card
    	Object[] options = {"Play", "Discard"};
    
    	int choice = JOptionPane.showOptionDialog(this, "Choose an action for this card:", "Card Action",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    	
        // Check for the option selected
        if (choice == 0) {
        	isPlayedCard = true;
        	methodIndex = 0;
            JOptionPane.showMessageDialog(this, "Card is Played.");
        } else if (choice == 1) {
        	isPlayedCard = true;
        	methodIndex = 1;
            JOptionPane.showMessageDialog(this, "Card is Discared.");
        }
        
        // Close hand after playing
        dispose();
        
    }
    
    //method to return isPlayedCard boolean
    public static boolean getIsPlayedCard() {
    	return isPlayedCard;
    }
    
    
    //method to return getMethodIndex int
    public static int getMethodIndex() {
    	return methodIndex;
    }
    
	// method to reset selectedCardIndex to false
	public static void resetBooleans() {
		receivedSelectedCard = false;
		isPlayedCard = false;
	}
		
	
}
