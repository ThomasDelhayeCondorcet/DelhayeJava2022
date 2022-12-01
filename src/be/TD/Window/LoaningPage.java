package be.TD.Window;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;

import be.TD.POJO.Copy;
import be.TD.POJO.Loan;
import be.TD.POJO.Player;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class LoaningPage {

	public JFrame frmLoaningPage;
	public Player player;
	public Copy copy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoaningPage window = new LoaningPage();
					window.frmLoaningPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoaningPage() {
		initialize();
	}

	public LoaningPage(Player player, Copy copy) {
		// TODO Auto-generated constructor stub
		this.player = player;
		this.copy = copy;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoaningPage = new JFrame();
		frmLoaningPage.setTitle("Loaning page");
		frmLoaningPage.setBounds(100, 100, 450, 300);
		frmLoaningPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoaningPage.getContentPane().setLayout(null);
		
		JLabel lb_owner = new JLabel("Owner : " + copy.getOwner().getPseudo());
		lb_owner.setBounds(10, 11, 403, 14);
		frmLoaningPage.getContentPane().add(lb_owner);
		
		JLabel lb_game_name = new JLabel("Name : " + copy.getVideoGame().getName());
		lb_game_name.setBounds(10, 36, 403, 14);
		frmLoaningPage.getContentPane().add(lb_game_name);
		
		JLabel lb_console = new JLabel("Console : " + copy.getVideoGame().getConsole());
		lb_console.setBounds(10, 61, 403, 14);
		frmLoaningPage.getContentPane().add(lb_console);
		
		JLabel lb_price = new JLabel("Price : " + copy.getVideoGame().getCreditCost());
		lb_price.setBounds(10, 86, 403, 14);
		frmLoaningPage.getContentPane().add(lb_price);
		
		JLabel lb_week = new JLabel("Number of week :");
		lb_week.setBounds(10, 111, 114, 14);
		frmLoaningPage.getContentPane().add(lb_week);
		
		JButton bt_return = new JButton("Return");
		bt_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewGameAvailable next = new ViewGameAvailable(player);
				JFrame nextFrame= next.frmAvailableGame;
				ChangeFrame(nextFrame);
			}
		});
		
		int maxWeek = player.getCredit()/Integer.valueOf(copy.getVideoGame().getCreditCost());
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, maxWeek, 1));
		spinner.setBounds(109, 108, 30, 20);
		frmLoaningPage.getContentPane().add(spinner);
		
		bt_return.setBounds(10, 227, 89, 23);
		frmLoaningPage.getContentPane().add(bt_return);
		
		JButton bt_loan = new JButton("Loan");
		bt_loan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LocalDate start = LocalDate.now();
				LocalDate end = start.plusWeeks((Integer)spinner.getValue());
				Loan loan = new Loan(start, end, true, player, copy.getOwner(), copy);
				loan.Create(loan);
				
				int total= (Integer.valueOf(copy.getVideoGame().getCreditCost())*(Integer)spinner.getValue());
				player.setCredit(player.getCredit()-total);
				player.UpdateCredit(player);
				
				Player lender = Player.Find(copy.getOwner().getId());
				lender.setCredit(lender.getCredit()+total);
				lender.UpdateCredit(lender);
				copy.setAvailable(0);
				copy.UpdateAvailable(copy);
				
				PlayerMainPage next = new PlayerMainPage(player);
				JFrame nextFrame= next.frmPlayerMainPage;
				ChangeFrame(nextFrame);
			}
		});
		bt_loan.setBounds(335, 227, 89, 23);
		frmLoaningPage.getContentPane().add(bt_loan);
		
	}

	public void ChangeFrame(Frame window){
		window.setVisible(true);
		frmLoaningPage.dispose();
	}
}
