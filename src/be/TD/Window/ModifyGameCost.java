package be.TD.Window;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import be.TD.POJO.VideoGame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class ModifyGameCost {

	public JFrame frmModifyGamePage;

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
			Object rows[] = new Object[videoGames.size()];
			rows[0] = videoGame.getName();
			rows[1] = videoGame.getConsole();
			rows[2] = videoGame.getCreditCost();
			myModel.addRow(rows);
		}
		
		JButton btnNewButton = new JButton("Confirm Change");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(295, 327, 143, 23);
		frmModifyGamePage.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 58, 714, 245);
		frmModifyGamePage.getContentPane().add(scrollPane);
		
		JTable table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setModel(myModel);
		scrollPane.setViewportView(table);
	}
}
