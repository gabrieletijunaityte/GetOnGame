package graphics;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import logic.Player;
import logic.Rules;
import logic.Stack;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

public class GameFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel player1;
	private JPanel player2;
	private JPanel player3;
	
    protected int numberof5cards = 1;
    protected int numberof6cards = 2;
    protected int numberof8cards = 3;
    protected int numberof10cards = 4;
	private JLabel lblCardStackCounter;
	private JLabel lblDiscardCounter;
	private JLabel lblDiscardedCard;
	
	/**
	 * Launch the application.
	 * @param player 
	 */
	public static void main(GameFrame frame) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
					frame.setAlwaysOnTop(true); // Makes sure frame always is on top
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param player 
	 */
	public GameFrame(Stack stack, Stack discardPile, ArrayList<String> names, int selectedCardIndex, Player currentPlayer, Rules rules) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1238, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel player1Status = new JPanel();
		player1Status.setBounds(5, 280, 306, 145);
		contentPane.add(player1Status);
		
		JSplitPane splitPane = new JSplitPane();
		player1Status.add(splitPane);
		
		JLabel lblP1BikeStatus = new JLabel(names.get(0) + " Bike Status");
		splitPane.setLeftComponent(lblP1BikeStatus);
		
		JLabel lblP1WindStatus = new JLabel(names.get(0) + " Wind Status");
		splitPane.setRightComponent(lblP1WindStatus);
		
		JPanel player2Status = new JPanel();
		player2Status.setBounds(316, 280, 306, 145);
		contentPane.add(player2Status);
		
		JSplitPane splitPane_1 = new JSplitPane();
		player2Status.add(splitPane_1);
		
		JLabel lblP2BikeStatus = new JLabel(names.get(1) + " Bike Status");
		splitPane_1.setLeftComponent(lblP2BikeStatus);
		
		JLabel lblP2WindStatus = new JLabel(names.get(1) + " Wind Status");
		splitPane_1.setRightComponent(lblP2WindStatus);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(627, 280, 324, 145);
		contentPane.add(panel_3);
		
		JSplitPane splitPane_2 = new JSplitPane();
		panel_3.add(splitPane_2);
		
		if (names.size() == 3) {
			JLabel lblP3BikeStatus = new JLabel(names.get(2) + " Bike Status");
			splitPane_2.setLeftComponent(lblP3BikeStatus);
			
			JLabel lblP3Windstatus = new JLabel(names.get(2) + " Wind Status");
			splitPane_2.setRightComponent(lblP3Windstatus);
		
		} else {
			JLabel lblP3BikeStatus = new JLabel("Bike Status");
			splitPane_2.setLeftComponent(lblP3BikeStatus);
			
			JLabel lblP3Windstatus = new JLabel("Wind Status");
			splitPane_2.setRightComponent(lblP3Windstatus);
		}
		
		player1 = new JPanel();
		player1.setBounds(5, 430, 306, 152);
		contentPane.add(player1);
		
		addCardWithCounter(player1 ,createCardLabel("| 5 Km cards: "), numberof5cards);
        addCardWithCounter(player1, createCardLabel("| 6 Km cards: "), numberof6cards);
        addCardWithCounter(player1, createCardLabel("| 8 Km cards: "), numberof8cards);
        addCardWithCounter(player1, createCardLabel("| 10 Km cards: "), numberof10cards);
		
		player2 = new JPanel();
		player2.setBounds(316, 430, 306, 152);
		contentPane.add(player2);
		
		addCardWithCounter(player2 ,createCardLabel("| 5 Km cards: "), numberof5cards);
		addCardWithCounter(player2, createCardLabel("| 6 Km cards: "), numberof6cards);
		addCardWithCounter(player2, createCardLabel("| 8 Km cards: "), numberof8cards);
		addCardWithCounter(player2, createCardLabel("| 10 Km cards: "), numberof10cards);
		
		player3 = new JPanel();
		player3.setBounds(627, 430, 324, 152);
		contentPane.add(player3);
		
        addCardWithCounter(player3 ,createCardLabel("| 5 Km cards: "), numberof5cards);
        addCardWithCounter(player3, createCardLabel("| 6 Km cards: "), numberof6cards);
        addCardWithCounter(player3, createCardLabel("| 8 Km cards: "), numberof8cards);
        addCardWithCounter(player3, createCardLabel("| 10 Km cards: "), numberof10cards);
        
        JButton btnViewHand = new JButton("View Hand");
        btnViewHand.setBounds(1129, 554, 85, 23);
        btnViewHand.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		PlayerHand.main(null, currentPlayer, rules, selectedCardIndex);
        		refreshGameFrame(stack, discardPile);
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

        refreshGameFrame(stack, discardPile);
        
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

    public void refreshGameFrame(Stack stack, Stack discardPile) {
    
    	lblCardStackCounter.setText("" + stack.getStackSize());
    	lblDiscardCounter.setText("" + discardPile.getStackSize());
    	
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

}
