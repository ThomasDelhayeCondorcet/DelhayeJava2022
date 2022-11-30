package be.TD.Window;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JLabel;

import be.TD.POJO.Copy;
import be.TD.POJO.Player;
import be.TD.POJO.VideoGame;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ViewGameAvailable {

	public JFrame frmAvailableGame;
	public Player player;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewGameAvailable window = new ViewGameAvailable();
					window.frmAvailableGame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewGameAvailable() {
		initialize();
	}

	public ViewGameAvailable(Player player) {
		// TODO Auto-generated constructor stub
		this.player = player;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAvailableGame = new JFrame();
		frmAvailableGame.setTitle("Available game");
		frmAvailableGame.setBounds(100, 100, 650, 420);
		frmAvailableGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAvailableGame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 614, 280);
		frmAvailableGame.getContentPane().add(scrollPane);
		
		JLabel lb_error = new JLabel("");
		lb_error.setForeground(Color.RED);
		lb_error.setHorizontalAlignment(SwingConstants.CENTER);
		lb_error.setBounds(10, 302, 614, 14);
		frmAvailableGame.getContentPane().add(lb_error);
		
		ArrayList<Copy> copys = Copy.GetAll();
		String[] colName = {"Name", "Console", "Price", "Owner"};
		DefaultTableModel myModel = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return true;
			}
		};
		myModel.setColumnIdentifiers(colName);
		for(Copy copy : copys) {
			if(copy.IsAvailable() && copy.getOwner().getId() != player.getId()) {
				Object rows[] = new Object[colName.length];
				rows[0] = copy.getVideoGame().getName();
				rows[1] = copy.getVideoGame().getConsole();
				rows[2] = copy.getVideoGame().getCreditCost();
				rows[3] = copy.getOwner().getPseudo();
				myModel.addRow(rows);
			}
		}
		
		JTable table = new JTable();
		table.setModel(myModel);
		table.setCellSelectionEnabled(true);
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(false);
		table.setCellSelectionEnabled(false); 
		scrollPane.setViewportView(table);
		
		JButton bt_return = new JButton("Return");
		bt_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayerMainPage next = new PlayerMainPage(player);
				JFrame nextFrame = next.frmPlayerMainPage;
				ChangeFrame(nextFrame);
			}
		});
		bt_return.setBounds(10, 347, 89, 23);
		frmAvailableGame.getContentPane().add(bt_return);
	}

	public void ChangeFrame(Frame window){
		window.setVisible(true);
		frmAvailableGame.dispose();
	}
}
