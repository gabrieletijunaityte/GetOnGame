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

public class GameFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel stackPanel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GameFrame frame = new GameFrame();
                    frame.setVisible(true);
                    frame.addCards();
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
        gbl_contentPane.columnWidths = new int[]{426, 0};
        gbl_contentPane.rowHeights = new int[]{14, 219, 20, 0};
        gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);
        
        JLabel lblNewLabel = new JLabel("GameTable");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
        gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        contentPane.add(lblNewLabel, gbc_lblNewLabel);
        
        stackPanel = new JPanel(); 
        stackPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); 
        GridBagConstraints gbc_stackPanel = new GridBagConstraints();
        gbc_stackPanel.gridx = 0;
        gbc_stackPanel.gridy = 2;
        contentPane.add(stackPanel, gbc_stackPanel);
    }
    
    public void addCards() {
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
        JPanel cardPanel = new JPanel(new BorderLayout());
        cardPanel.add(cardLabel, BorderLayout.CENTER);
        
        JLabel counterLabel = new JLabel(String.valueOf(count));
        counterLabel.setHorizontalAlignment(JLabel.CENTER);
        cardPanel.add(counterLabel, BorderLayout.NORTH); 
        

        cardPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0)); 
        
        stackPanel.add(cardPanel);
    }
}
