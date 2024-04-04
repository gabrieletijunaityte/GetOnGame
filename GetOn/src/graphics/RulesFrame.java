package graphics;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import logic.Rules;

import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RulesFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	private JTextPane textRules;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RulesFrame frame = new RulesFrame();
					frame.setSize(781, 410);
					frame.setVisible(true);
					
					// Do not allow to resize the frame
					frame.setResizable(false);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RulesFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		
		// Add button that print the rules
		JButton btnShowRules = new JButton("Show rules");
		btnShowRules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				handleShowRules();
				
			}
		});
		btnShowRules.setBounds(10, 11, 197, 23);
		contentPanel.add(btnShowRules);
		
		textRules = new JTextPane();
		
		// Make sure the shown text is not editable by the spectator
		textRules.setEditable(false);
		
		// Add scroll to view the full rules
		JScrollPane verticalScroll = new JScrollPane(textRules, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		verticalScroll.setBounds(10, 47, 747, 315);
		contentPanel.add(verticalScroll);
		
	
	}

	protected void handleShowRules() {
		
		Rules defaultRules = new Rules();
		
		if (defaultRules != null) {
			textRules.setText(defaultRules.getRules());
		}
		
	}
}
