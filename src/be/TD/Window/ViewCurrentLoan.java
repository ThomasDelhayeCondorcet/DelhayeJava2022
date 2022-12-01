package be.TD.Window;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import be.TD.POJO.Copy;
import be.TD.POJO.Loan;
import be.TD.POJO.Player;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ViewCurrentLoan {

	public JFrame frmCurrentLoan;
	Player player;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCurrentLoan window = new ViewCurrentLoan();
					window.frmCurrentLoan.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewCurrentLoan() {
		initialize();
	}

	public ViewCurrentLoan(Player player) {
		// TODO Auto-generated constructor stub
		this.player = player;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCurrentLoan = new JFrame();
		frmCurrentLoan.setTitle("Current Loan");
		frmCurrentLoan.setBounds(100, 100, 650, 400);
		frmCurrentLoan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCurrentLoan.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 614, 280);
		frmCurrentLoan.getContentPane().add(scrollPane);
		
		ArrayList<Loan> loans = Loan.GetAll();
		String[] colName = {"Id", "Name", "Console", "Start date", "End date", "Owner"};
		DefaultTableModel myModel = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		myModel.setColumnIdentifiers(colName);
		for(Loan loan : loans) {
			if(loan.getBorrower().getId() == player.getId() && loan.isOnGoing()) {
				Object rows[] = new Object[colName.length];
				rows[0] = loan.getId();
				rows[1] = loan.getCopy().getVideoGame().getName();
				rows[2] = loan.getCopy().getVideoGame().getConsole();
				rows[3] = loan.getStartDate();
				rows[4] = loan.getEndDate();
				rows[5] = loan.getCopy().getOwner().getPseudo();
				myModel.addRow(rows);
			}
		}
		
		JTable table = new JTable();
		table.setModel(myModel);
		table.setShowHorizontalLines(true);
	    table.setRowSelectionAllowed(true);
		scrollPane.setViewportView(table);
		
		JButton bt_return = new JButton("Return");
		bt_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayerMainPage next = new PlayerMainPage(player);
				JFrame nextFrame = next.frmPlayerMainPage;
				ChangeFrame(nextFrame);
			}
		});
		bt_return.setBounds(10, 327, 89, 23);
		frmCurrentLoan.getContentPane().add(bt_return);
		
		JButton bt_put_back = new JButton("Put back");
		bt_put_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				int idSelected = (int) table.getModel().getValueAt(selectedRow, 0);
				for(Loan loan : loans) {
					if(idSelected == loan.getId()) {
						loan.EndLoan(loan);
						loan.getCopy().setAvailable(1);
						Copy copy = loan.getCopy();
						copy.setAvailable(1);
						copy.UpdateAvailable(copy);
						PlayerMainPage next = new PlayerMainPage(player);
						JFrame nextFrame = next.frmPlayerMainPage;
						ChangeFrame(nextFrame);
					}
				}
			}
		});
		bt_put_back.setBounds(535, 327, 89, 23);
		frmCurrentLoan.getContentPane().add(bt_put_back);
	}

	public void ChangeFrame(Frame window){
		window.setVisible(true);
		frmCurrentLoan.dispose();
	}
}
