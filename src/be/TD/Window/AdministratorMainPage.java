package be.TD.Window;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class AdministratorMainPage {

	public JFrame frmAdministartorMainPage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministratorMainPage window = new AdministratorMainPage();
					window.frmAdministartorMainPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdministratorMainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdministartorMainPage = new JFrame();
		frmAdministartorMainPage.setTitle("Administartor main page");
		frmAdministartorMainPage.setBounds(100, 100, 450, 300);
		frmAdministartorMainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdministartorMainPage.getContentPane().setLayout(null);
	}

}
