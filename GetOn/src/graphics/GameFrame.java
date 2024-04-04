package graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

public class GameFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel kilometerPanel;
    private JPanel topCardPanel;


    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GameFrame frame = new GameFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public GameFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{213, 213, 0}; 
        gbl_contentPane.rowHeights = new int[]{14, 20, 0, 224, 0, 0};
        gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE}; 
        gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);
        
        JLabel lblNewLabel = new JLabel("GameTable");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
        gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        contentPane.add(lblNewLabel, gbc_lblNewLabel);
        
        JPanel discardPanel = new JPanel();
        GridBagConstraints gbc_discardPanel = new GridBagConstraints();
        gbc_discardPanel.insets = new Insets(0, 0, 5, 5);
        gbc_discardPanel.fill = GridBagConstraints.BOTH;
        gbc_discardPanel.gridx = 1;
        gbc_discardPanel.gridy = 3;
        contentPane.add(discardPanel, gbc_discardPanel);
        discardPanel.setLayout(new GridLayout(1, 0, 0, 0));
        
        JLabel discardPile = new JLabel("Discard pile");
        discardPanel.add(discardPile);
        
        JPanel stackPanel = new JPanel();
        GridBagConstraints gbc_stackPanel = new GridBagConstraints();
        gbc_stackPanel.gridwidth = 0;
        gbc_stackPanel.insets = new Insets(0, 0, 5, 0);
        gbc_stackPanel.fill = GridBagConstraints.BOTH;
        gbc_stackPanel.gridx = 0;
        gbc_stackPanel.gridy = 3;
        contentPane.add(stackPanel, gbc_stackPanel);
        stackPanel.setLayout(new GridLayout(1, 0, 0, 0));
        
        JLabel stackOfCards = new JLabel("Stack of cards");
        stackPanel.add(stackOfCards);
        
        kilometerPanel = new JPanel(); 
        kilometerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        GridBagConstraints gbc_kilometerPanel = new GridBagConstraints();
        gbc_kilometerPanel.insets = new Insets(0, 0, 0, 5);
        gbc_kilometerPanel.gridwidth = 2;
        gbc_kilometerPanel.gridx = 0;
        gbc_kilometerPanel.gridy = 4;
        contentPane.add(kilometerPanel, gbc_kilometerPanel);
        
        JLabel cardLabel5 = new JLabel("Card 5");
        addCardWithCounter(cardLabel5, 5);
        
        JLabel cardLabel6 = new JLabel("Card 6");
        addCardWithCounter(cardLabel6, 6);
        
        JLabel cardLabel8 = new JLabel("Card 8");
        addCardWithCounter(cardLabel8, 8);
        
        JLabel cardLabel10 = new JLabel("Card 10");
        addCardWithCounter(cardLabel10, 10);
        
        
        
    }
    
    private void addCardWithCounter(JLabel cardLabel, int count) {
        JLabel counterLabel = new JLabel(String.valueOf(count)); // Convert count to string
        counterLabel.setHorizontalAlignment(SwingConstants.CENTER);
        kilometerPanel.add(cardLabel);
        kilometerPanel.add(counterLabel); // Add counter label to the panel
    }

}
