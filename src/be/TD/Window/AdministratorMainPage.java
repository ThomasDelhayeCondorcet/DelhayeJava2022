package be.TD.Window;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;

import be.TD.POJO.Administrator;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdministratorMainPage {

	public JFrame frmAdministartorMainPage;
	public Administrator admin;

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

	public AdministratorMainPage(Object connected) {
		// TODO Auto-generated constructor stub
		admin = (Administrator) connected; 
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
		
		JButton bt_modifyGame = new JButton("Modify game");
		bt_modifyGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyGameCost next = new ModifyGameCost();
				JFrame nextFrame=next.frmModifyGamePage;
				ChangeFrame(nextFrame);
			}
		});
		bt_modifyGame.setBounds(10, 47, 121, 23);
		frmAdministartorMainPage.getContentPane().add(bt_modifyGame);
	}
	public void ChangeFrame(Frame window){
		window.setVisible(true);
		frmAdministartorMainPage.dispose();
	}
}
