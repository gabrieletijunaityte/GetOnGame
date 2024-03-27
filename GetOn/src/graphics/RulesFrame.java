package graphics;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Rules;

import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RulesFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextPane textRules;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RulesFrame frame = new RulesFrame();
					frame.setVisible(true);
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
		setBounds(100, 100, 781, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnShowRules = new JButton("Show rules");
		btnShowRules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				handleShowRules();
				
			}
		});
		btnShowRules.setBounds(10, 11, 197, 23);
		contentPane.add(btnShowRules);
		
		textRules = new JTextPane();
		textRules.setBounds(10, 47, 757, 315);
		contentPane.add(textRules);
	}

	protected void handleShowRules() {
		
		Rules defaultRules = new Rules();
		
		if (defaultRules != null) {
			textRules.setText(defaultRules.getRules());
		}
		
	}
}
