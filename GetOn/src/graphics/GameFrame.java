package graphics;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import logic.Card;
import logic.Stack;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class GameFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel player1;
	private JPanel player2;
	private JPanel player3;
	//private String discardCard = "Dummy Discard";
	
    protected int numberof5cards = 1;
    protected int numberof6cards = 2;
    protected int numberof8cards = 3;
    protected int numberof10cards = 4;
    


	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Stack stack, String discardedCardName, ArrayList<Card> hand, int selectedCardIndex) {

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameFrame frame = new GameFrame(stack, discardedCardName, hand, selectedCardIndex);
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
	 */
	public GameFrame(Stack stack, String discardedCardName, ArrayList<Card> hand, int selectedCardIndex) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{172, 212, 274, 208, 0};
		gbl_contentPane.rowHeights = new int[]{79, 74, 89, 91, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		

		JPanel panelStack = new JPanel();
		GridBagConstraints gbc_panelStack = new GridBagConstraints();
		gbc_panelStack.insets = new Insets(0, 0, 5, 5);
		gbc_panelStack.fill = GridBagConstraints.BOTH;
		gbc_panelStack.gridx = 0;
		gbc_panelStack.gridy = 0;
		gbc_panelStack.gridwidth = 2;
		gbc_panelStack.gridheight = 2;
		contentPane.add(panelStack, gbc_panelStack);
		
		
        ImageIcon stackIcon = new ImageIcon("data/stack_of_cards.png");
        JLabel stackOfCards = new JLabel(stackIcon);
        panelStack.add(stackOfCards);
        
        JLabel lblStackLabel = new JLabel("Stack Label");
        panelStack.add(lblStackLabel);
        
        int stackSize = stack.getStackSize();
        
        lblStackLabel.setText("Remaining Cards = " + stackSize);
		
		JPanel panelDiscard = new JPanel();
		
		JLabel discardLabel = new JLabel();
		
	
		// Create visual for discard pile
		discardLabel.setText("Discarded Card is: " + discardedCardName );
		
		
		
		GridBagConstraints gbc_panelDiscard = new GridBagConstraints();
		gbc_panelDiscard.insets = new Insets(0, 0, 5, 5);
		gbc_panelDiscard.fill = GridBagConstraints.BOTH;
		gbc_panelDiscard.gridx = 2;
		gbc_panelDiscard.gridy = 0;
		gbc_panelDiscard.weightx = 1.0;
		gbc_panelDiscard.weighty = 1.0;
		gbc_panelDiscard.gridheight = 2;
		gbc_panelDiscard.gridwidth = 2;
		gbc_panelDiscard.anchor = GridBagConstraints.CENTER;
		contentPane.add(panelDiscard);
		
		panelDiscard.add(discardLabel, gbc_panelDiscard);
		
		JPanel player1Status = new JPanel();
		GridBagConstraints gbc_player1Status = new GridBagConstraints();
		gbc_player1Status.insets = new Insets(0, 0, 5, 5);
		gbc_player1Status.fill = GridBagConstraints.BOTH;
		gbc_player1Status.gridx = 0;
		gbc_player1Status.gridy = 2;
		contentPane.add(player1Status, gbc_player1Status);
		
		JSplitPane splitPane = new JSplitPane();
		player1Status.add(splitPane);
		
		JLabel lblP1BikeStatus = new JLabel("P1 Bike Status");
		splitPane.setLeftComponent(lblP1BikeStatus);
		
		JLabel lblP1WindStatus = new JLabel("P1 Wind Status");
		splitPane.setRightComponent(lblP1WindStatus);
		
		JPanel player2Status = new JPanel();
		GridBagConstraints gbc_player2Status = new GridBagConstraints();
		gbc_player2Status.insets = new Insets(0, 0, 5, 5);
		gbc_player2Status.fill = GridBagConstraints.BOTH;
		gbc_player2Status.gridx = 1;
		gbc_player2Status.gridy = 2;
		contentPane.add(player2Status, gbc_player2Status);
		
		JSplitPane splitPane_1 = new JSplitPane();
		player2Status.add(splitPane_1);
		
		JLabel lblP2BikeStatus = new JLabel("P2 Bike Status");
		splitPane_1.setLeftComponent(lblP2BikeStatus);
		
		JLabel lblP2WindStatus = new JLabel("P2 Wind Status");
		splitPane_1.setRightComponent(lblP2WindStatus);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 2;
		gbc_panel_3.gridy = 2;
		contentPane.add(panel_3, gbc_panel_3);
		
		JSplitPane splitPane_2 = new JSplitPane();
		panel_3.add(splitPane_2);
		
		JLabel lblP3BikeStatus = new JLabel("P3 Bike Status");
		splitPane_2.setLeftComponent(lblP3BikeStatus);
		
		JLabel lblP3Windstatus = new JLabel("P3 Wind Status");
		splitPane_2.setRightComponent(lblP3Windstatus);
		
		player1 = new JPanel();
		GridBagConstraints gbc_player1 = new GridBagConstraints();
		gbc_player1.insets = new Insets(0, 0, 0, 5);
		gbc_player1.fill = GridBagConstraints.BOTH;
		gbc_player1.gridx = 0;
		gbc_player1.gridy = 3;
		contentPane.add(player1, gbc_player1);
		
		addCardWithCounter(player1 ,createCardLabel("| 5 Km cards: "), numberof5cards);
        addCardWithCounter(player1, createCardLabel("| 6 Km cards: "), numberof6cards);
        addCardWithCounter(player1, createCardLabel("| 8 Km cards: "), numberof8cards);
        addCardWithCounter(player1, createCardLabel("| 10 Km cards: "), numberof10cards);
		
		player2 = new JPanel();
		GridBagConstraints gbc_player2 = new GridBagConstraints();
		gbc_player2.insets = new Insets(0, 0, 0, 5);
		gbc_player2.fill = GridBagConstraints.BOTH;
		gbc_player2.gridx = 1;
		gbc_player2.gridy = 3;
		contentPane.add(player2, gbc_player2);
		
		addCardWithCounter(player2 ,createCardLabel("| 5 Km cards: "), numberof5cards);
		addCardWithCounter(player2, createCardLabel("| 6 Km cards: "), numberof6cards);
		addCardWithCounter(player2, createCardLabel("| 8 Km cards: "), numberof8cards);
		addCardWithCounter(player2, createCardLabel("| 10 Km cards: "), numberof10cards);
		
		player3 = new JPanel();
		GridBagConstraints gbc_player3 = new GridBagConstraints();
		gbc_player3.insets = new Insets(0, 0, 0, 5);
		gbc_player3.fill = GridBagConstraints.BOTH;
		gbc_player3.gridx = 2;
		gbc_player3.gridy = 3;
		contentPane.add(player3, gbc_player3);
		
        addCardWithCounter(player3 ,createCardLabel("| 5 Km cards: "), numberof5cards);
        addCardWithCounter(player3, createCardLabel("| 6 Km cards: "), numberof6cards);
        addCardWithCounter(player3, createCardLabel("| 8 Km cards: "), numberof8cards);
        addCardWithCounter(player3, createCardLabel("| 10 Km cards: "), numberof10cards);
        
        JButton btnViewHand = new JButton("View Hand");
        btnViewHand.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		PlayerHand.main(null, hand, selectedCardIndex);
        		
        	}
        });

        
        GridBagConstraints gbc_btnViewHand = new GridBagConstraints();
        gbc_btnViewHand.gridx = 3;
        gbc_btnViewHand.gridy = 3;
        contentPane.add(btnViewHand, gbc_btnViewHand);
        
        
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
    
}
