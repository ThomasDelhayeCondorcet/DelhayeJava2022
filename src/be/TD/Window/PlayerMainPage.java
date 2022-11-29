package be.TD.Window;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;

import be.TD.POJO.Player;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlayerMainPage {

	public JFrame frmPlayerMainPage;
	public Player player;

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

	public PlayerMainPage(Object connected) {
		// TODO Auto-generated constructor stub
		player = (Player) connected;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPlayerMainPage = new JFrame();
		frmPlayerMainPage.setTitle("Player main page");
		frmPlayerMainPage.setBounds(100, 100, 650, 400);
		frmPlayerMainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPlayerMainPage.getContentPane().setLayout(null);
		
		JLabel lb_player_info = new JLabel("Welcome " + player.getPseudo() + " you have : " + player.getCredit() + " credit remaining");
		lb_player_info.setBounds(10, 11, 414, 14);
		frmPlayerMainPage.getContentPane().add(lb_player_info);
		
		JButton bt_add_copy = new JButton("Add copy");
		bt_add_copy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCopy next = new AddCopy(player);
				JFrame nextFrame=next.frmAddCopy;
				ChangeFrame(nextFrame);
			}
		});
		bt_add_copy.setBounds(10, 36, 121, 23);
		frmPlayerMainPage.getContentPane().add(bt_add_copy);
	}

	public void ChangeFrame(Frame window){
		window.setVisible(true);
		frmPlayerMainPage.dispose();
	}
}
