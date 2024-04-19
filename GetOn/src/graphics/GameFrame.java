package graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
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

public class GameFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel player1;
	private JPanel player2;
	private JPanel player3;
	
	private JLabel lblCardStackCounter;
	private JLabel lblDiscardCounter;
	private JLabel lblDiscardedCard;
	
	private PlayerHand currentPlayerHand = new PlayerHand(null, null);
	private int currentPlayerIndex;
	
	public GameFrame(Stack stack, Stack discardPile, ArrayList<Player> players, int selectedCardIndex, Rules rules, int currentPlayerIndex) {

		this.setVisible(true);
		this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 1238, 625);
		this.currentPlayerIndex = currentPlayerIndex;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel player1Status = new JPanel();
		player1Status.setBounds(5, 280, 306, 145);
		contentPane.add(player1Status);
		
		JSplitPane splitPane = new JSplitPane();
		player1Status.add(splitPane);
		
		JLabel lblP1BikeStatus = new JLabel(players.get(0).getName() + " Bike Status");
		splitPane.setLeftComponent(lblP1BikeStatus);
		
		JLabel lblP1WindStatus = new JLabel(players.get(0).getName() + " Wind Status");
		splitPane.setRightComponent(lblP1WindStatus);
		
		JPanel player2Status = new JPanel();
		player2Status.setBounds(316, 280, 306, 145);
		contentPane.add(player2Status);
		
		JSplitPane splitPane_1 = new JSplitPane();
		player2Status.add(splitPane_1);
		
		JLabel lblP2BikeStatus = new JLabel(players.get(1).getName() + " Bike Status");
		splitPane_1.setLeftComponent(lblP2BikeStatus);
		
		JLabel lblP2WindStatus = new JLabel(players.get(1).getName() + " Wind Status");
		splitPane_1.setRightComponent(lblP2WindStatus);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(627, 280, 324, 145);
		contentPane.add(panel_3);
		
		JSplitPane splitPane_2 = new JSplitPane();
		panel_3.add(splitPane_2);
		
		if (players.size() == 3) {
			
			JLabel lblP3BikeStatus = new JLabel(players.get(2).getName() + " Bike Status");
			splitPane_2.setLeftComponent(lblP3BikeStatus);
			
			JLabel lblP3Windstatus = new JLabel(players.get(2).getName() + " Wind Status");
			splitPane_2.setRightComponent(lblP3Windstatus);
		
		} else {
			
			JLabel lblP3BikeStatus = new JLabel("Bike Status");
			splitPane_2.setLeftComponent(lblP3BikeStatus);
			
			JLabel lblP3Windstatus = new JLabel("Wind Status");
			splitPane_2.setRightComponent(lblP3Windstatus);
			
		}
		
		player1 = new JPanel();
		player2 = new JPanel();
		player3 = new JPanel();
		
        
        JButton btnViewHand = new JButton("View Hand");
        btnViewHand.setBounds(1129, 554, 85, 23);
        btnViewHand.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		currentPlayerHand.updateHand(986, players.get(currentPlayerIndex), rules);
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
        
        refreshGameFrame(stack, discardPile, players, players.get(currentPlayerIndex), rules, selectedCardIndex, currentPlayerIndex);
        
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
    
    public void refreshScores(ArrayList <Player> players, int currentPlayerIndex) {
    	contentPane.remove(player1);
        contentPane.remove(player2);
        contentPane.remove(player3);
        
        Border player1border;
    	player1 = new JPanel();
		player1.setBounds(5, 430, 306, 152);
		if(currentPlayerIndex == 0) {
			player1border = BorderFactory.createLineBorder(Color.green, 5, true);
		}else {
			player1border = BorderFactory.createLineBorder(Color.red, 5, true);
		}
		player1.setBorder(player1border);
		contentPane.add(player1);
		
		addCardWithCounter(player1 ,createCardLabel("| 5 Km cards: "), players.get(0).getPlayedCards().countCards(new KilometerCard("FIVE")));
        addCardWithCounter(player1, createCardLabel("| 6 Km cards: "),  players.get(0).getPlayedCards().countCards(new KilometerCard("SIX")));
        addCardWithCounter(player1, createCardLabel("| 8 Km cards: "),  players.get(0).getPlayedCards().countCards(new KilometerCard("EIGHT")));
        addCardWithCounter(player1, createCardLabel("| 10 Km cards: "),  players.get(0).getPlayedCards().countCards(new KilometerCard("TEN")));
		
        Border player2border;
		player2 = new JPanel();
		player2.setBounds(316, 430, 306, 152);
		if(currentPlayerIndex == 1) {
			player2border = BorderFactory.createLineBorder(Color.green, 5, true);
		}else {
			player2border = BorderFactory.createLineBorder(Color.red, 5, true);
		}
		player2.setBorder(player2border);
		contentPane.add(player2);
		
		addCardWithCounter(player2 ,createCardLabel("| 5 Km cards: "), players.get(1).getPlayedCards().countCards(new KilometerCard("FIVE")));
		addCardWithCounter(player2, createCardLabel("| 6 Km cards: "), players.get(1).getPlayedCards().countCards(new KilometerCard("SIX")));
		addCardWithCounter(player2, createCardLabel("| 8 Km cards: "), players.get(1).getPlayedCards().countCards(new KilometerCard("EIGHT")));
		addCardWithCounter(player2, createCardLabel("| 10 Km cards: "), players.get(1).getPlayedCards().countCards(new KilometerCard("TEN")));
		
		if (players.size() == 3) {
			
			player3 = new JPanel();
			player3.setBounds(627, 430, 324, 152);
			Border player3border;
			if(currentPlayerIndex == 2) {
				player3border = BorderFactory.createLineBorder(Color.green, 5, true);
			}else {
				player3border = BorderFactory.createLineBorder(Color.red, 5, true);
			}
			player3.setBorder(player3border);
			contentPane.add(player3);
			
	        addCardWithCounter(player3 ,createCardLabel("| 5 Km cards: "), players.get(2).getPlayedCards().countCards(new KilometerCard("FIVE")));
	        addCardWithCounter(player3, createCardLabel("| 6 Km cards: "), players.get(2).getPlayedCards().countCards(new KilometerCard("SIX")));
	        addCardWithCounter(player3, createCardLabel("| 8 Km cards: "), players.get(2).getPlayedCards().countCards(new KilometerCard("EIGHT")));
	        addCardWithCounter(player3, createCardLabel("| 10 Km cards: "), players.get(2).getPlayedCards().countCards(new KilometerCard("TEN")));
			
		}
        
        contentPane.revalidate();
        contentPane.repaint();
    	
    }

    public void refreshGameFrame(Stack stack, Stack discardPile, ArrayList <Player> players, Player currentPlayer, Rules rules, int selectedCardIndex, int currentPlayerIndex) {
    
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
    	
    }
    
    public void getPlayerHand(PlayerHand playerHand) {
    	
    	this.currentPlayerHand = playerHand;
    	
    }
    
}
