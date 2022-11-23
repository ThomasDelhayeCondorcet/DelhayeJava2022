package be.TD.Window;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class PlayerMainPage {

	public JFrame frmPlayerMainPage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerMainPage window = new PlayerMainPage();
					window.frmPlayerMainPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PlayerMainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPlayerMainPage = new JFrame();
		frmPlayerMainPage.setTitle("Player main page");
		frmPlayerMainPage.setBounds(100, 100, 450, 300);
		frmPlayerMainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPlayerMainPage.getContentPane().setLayout(null);
	}

}
