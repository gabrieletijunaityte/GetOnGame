package graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import logic.Rules;

import javax.swing.JTextPane;
import java.awt.GridLayout;

/**
 * Create Frame to display the rules
 * 
 */
public class RulesFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	private JTextPane textRules;

	/**
	 * Create the Rules Frame.
	 */
	public RulesFrame() {
		this.setSize(781, 410);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
		this.setResizable(false);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPanel);
		contentPanel.setLayout(new GridLayout(0, 1, 0, 0));

		textRules = new JTextPane();

		// Make sure the shown text is not editable by the spectator
		textRules.setEditable(false);

		// Add scroll to view the full rules
		JScrollPane verticalScroll = new JScrollPane(textRules, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		contentPanel.add(verticalScroll);
		this.setTitle("Rules");

		repaint();
		handleShowRules();
	}

	// Method to show the rules when the window is opened
	protected void handleShowRules() {
		Rules defaultRules = new Rules();
		if (defaultRules != null) {
			textRules.setText(defaultRules.getRules());
		}
	}
}
