package be.TD.Window;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import be.TD.POJO.Administrator;
import be.TD.POJO.Player;
import be.TD.POJO.User;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginWindow {

	public JFrame frame;
	private JTextField tf_pseudo;
	private JTextField tf_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lb_title = new JLabel("GameSwap - Login");
		lb_title.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title.setBounds(10, 11, 414, 14);
		frame.getContentPane().add(lb_title);
		
		JLabel lb_pseudo = new JLabel("Pseudo :");
		lb_pseudo.setBounds(26, 52, 83, 14);
		frame.getContentPane().add(lb_pseudo);
		
		tf_pseudo = new JTextField();
		tf_pseudo.setBounds(26, 77, 113, 20);
		frame.getContentPane().add(tf_pseudo);
		tf_pseudo.setColumns(10);
		
		tf_password = new JPasswordField();
		tf_password.setColumns(10);
		tf_password.setBounds(26, 133, 113, 20);
		frame.getContentPane().add(tf_password);
		
		JLabel lb_password = new JLabel("password :");
		lb_password.setBounds(26, 108, 83, 14);
		frame.getContentPane().add(lb_password);
		
		JLabel lb_error = new JLabel("");
		lb_error.setForeground(Color.RED);
		lb_error.setHorizontalAlignment(SwingConstants.CENTER);
		lb_error.setBounds(10, 162, 414, 14);
		frame.getContentPane().add(lb_error);
		
		JButton bt_login = new JButton("Login");
		bt_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf_pseudo.getText().equals("")|| tf_password.getText().equals("")) {
					lb_error.setText("All field must be fill");
				}
				Object connected = User.Login(tf_pseudo.getText(), tf_password.getText());
				if(connected instanceof Player) {
					PlayerMainPage next = new PlayerMainPage();
					JFrame nextFrame=next.frmPlayerMainPage;
					ChangeFrame(nextFrame);
				}
				if(connected instanceof Administrator) {
					AdministratorMainPage next = new AdministratorMainPage();
					JFrame nextFrame=next.frmAdministartorMainPage;
					ChangeFrame(nextFrame);
				}else {
					lb_error.setText("Password or pseudo are incorrect");
				}		
			}
		});
		bt_login.setBounds(167, 187, 89, 23);
		frame.getContentPane().add(bt_login);
		
		JButton bt_register = new JButton("Register");
		bt_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterWindow next = new RegisterWindow();
				JFrame nextFrame=next.frame;
				ChangeFrame(nextFrame);
			}
			
		});
		bt_register.setBounds(167, 227, 89, 23);
		frame.getContentPane().add(bt_register);
	}
	public void ChangeFrame(Frame window){
		window.setVisible(true);
		frame.dispose();
	}
}
