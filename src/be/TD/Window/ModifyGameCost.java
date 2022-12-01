package be.TD.Window;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import be.TD.POJO.Administrator;
import be.TD.POJO.VideoGame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;

public class ModifyGameCost {

	public JFrame frmModifyGamePage;
	public Administrator admin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyGameCost window = new ModifyGameCost();
					window.frmModifyGamePage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ModifyGameCost() {
		initialize();
	}

	public ModifyGameCost(Administrator admin) {
		this.admin = admin;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmModifyGamePage = new JFrame();
		frmModifyGamePage.setTitle("Modify Game page");
		frmModifyGamePage.setBounds(100, 100, 750, 400);
		frmModifyGamePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmModifyGamePage.getContentPane().setLayout(null);
		
		ArrayList<VideoGame> videoGames = VideoGame.GetAll();
		String[] colName = {"Name", "Console", "Price"};
		DefaultTableModel myModel = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return true;
			}
			
		};
		myModel.setColumnIdentifiers(colName);
		for(VideoGame videoGame : videoGames) {
			Object rows[] = new Object[colName.length];
			rows[0] = videoGame.getName();
			rows[1] = videoGame.getConsole();
			rows[2] = videoGame.getCreditCost();
			myModel.addRow(rows);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 58, 714, 230);
		frmModifyGamePage.getContentPane().add(scrollPane);
		
		JLabel lb_error = new JLabel("");
		lb_error.setForeground(Color.RED);
		lb_error.setHorizontalAlignment(SwingConstants.CENTER);
		lb_error.setBounds(10, 302, 714, 14);
		frmModifyGamePage.getContentPane().add(lb_error);
		
		JTable table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setModel(myModel);
		scrollPane.setViewportView(table);
		
		
		JButton btnNewButton = new JButton("Confirm Change");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i =0; i<videoGames.size();i++) {
					int id = videoGames.get(i).getId();
					String name = videoGames.get(i).getName();
					String console = videoGames.get(i).getConsole();
					String newCerditCost = (String) table.getModel().getValueAt(i, 2);
					VideoGame videoGame = new VideoGame(id, name, newCerditCost, console);
					
					if(videoGame.UpdateCost(videoGame)) {
						AdministratorMainPage next = new AdministratorMainPage(admin);
						JFrame nextFrame=next.frmAdministartorMainPage;
						ChangeFrame(nextFrame);
					}else {
						lb_error.setText("Impossible to save changes");
					}
						
				}
			}

			public void ChangeFrame(Frame window){
				window.setVisible(true);
				frmModifyGamePage.dispose();
			}
		});
		btnNewButton.setBounds(295, 327, 143, 23);
		frmModifyGamePage.getContentPane().add(btnNewButton);
	}
}
