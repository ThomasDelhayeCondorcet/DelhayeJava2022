package be.TD.Window;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
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
		
		tf_password = new JTextField();
		tf_password.setColumns(10);
		tf_password.setBounds(26, 133, 113, 20);
		frame.getContentPane().add(tf_password);
		
		JLabel lb_password = new JLabel("password :");
		lb_password.setBounds(26, 108, 83, 14);
		frame.getContentPane().add(lb_password);
		
		JButton bt_login = new JButton("Login");
		bt_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bt_login.setBounds(167, 187, 89, 23);
		frame.getContentPane().add(bt_login);
		
		JLabel lb_error = new JLabel("");
		lb_error.setForeground(Color.RED);
		lb_error.setHorizontalAlignment(SwingConstants.CENTER);
		lb_error.setBounds(127, 162, 165, 14);
		frame.getContentPane().add(lb_error);
		
		JButton bt_register = new JButton("Register");
		bt_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterWindow next = new RegisterWindow();
				JFrame nextFrame=next.frame;
				ChangeFrame(nextFrame);
			}
			
			public void ChangeFrame(Frame window){
				window.setVisible(true);
				frame.dispose();
			}
			
		});
		bt_register.setBounds(167, 227, 89, 23);
		frame.getContentPane().add(bt_register);
	}
}
