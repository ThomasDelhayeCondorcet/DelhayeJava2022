package be.TD.Window;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;

import be.TD.POJO.Copy;
import be.TD.POJO.Player;
import be.TD.POJO.VideoGame;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCopy {

	public JFrame frmAddCopy;
	public Player player;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCopy window = new AddCopy();
					window.frmAddCopy.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddCopy() {
		initialize();
	}

	public AddCopy(Player player) {
		// TODO Auto-generated constructor stub
		this.player = player;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddCopy = new JFrame();
		frmAddCopy.setTitle("Add Copy");
		frmAddCopy.setBounds(100, 100, 450, 300);
		frmAddCopy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddCopy.getContentPane().setLayout(null);
		
		ArrayList<VideoGame> videoGames = VideoGame.GetAll();
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		for(VideoGame videogame: videoGames) {
			model.addElement(videogame.getName() + " - "+  videogame.getConsole());
		}
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(model);
		comboBox.setBounds(10, 51, 253, 22);
		frmAddCopy.getContentPane().add(comboBox);
		
		JLabel lb_info = new JLabel("Select a game in the list to add it to loanable game");
		lb_info.setBounds(10, 11, 414, 14);
		frmAddCopy.getContentPane().add(lb_info);
		
		JButton bt_add_copy = new JButton("Add copy");
		bt_add_copy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result = (String) comboBox.getSelectedItem();
				String[] splitresult = result.split(" - ");
				for(VideoGame videoGame : videoGames) {
					if(videoGame.getName().equals(splitresult[0]) && videoGame.getConsole().equals(splitresult[1]) ) {
						Copy copy = new Copy(videoGame, player );
						
					}
				}
			}
		});
		bt_add_copy.setBounds(174, 147, 89, 23);
		frmAddCopy.getContentPane().add(bt_add_copy);
	}
}
