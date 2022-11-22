package be.TD.Window;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import be.TD.POJO.Player;
import be.TD.POJO.User;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class RegisterWindow {

	public JFrame frame;
	private JTextField tf_firstname;
	private JTextField tf_pseudo;
	private JTextField tf_mail;
	private JTextField tf_adress;
	private JPasswordField tf_password;
	private JPasswordField tf_password_confirm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterWindow window = new RegisterWindow();
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
	public RegisterWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lb_title = new JLabel("GameSwap - Register");
		lb_title.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title.setBounds(10, 11, 414, 14);
		frame.getContentPane().add(lb_title);
		
		JLabel lb_username = new JLabel("UserName :");
		lb_username.setBounds(10, 51, 130, 14);
		frame.getContentPane().add(lb_username);
		
		tf_firstname = new JTextField();
		tf_firstname.setBounds(90, 48, 130, 20);
		frame.getContentPane().add(tf_firstname);
		tf_firstname.setColumns(10);
		
		JLabel lb_pseudo = new JLabel("Pseudo :");
		lb_pseudo.setBounds(10, 79, 130, 14);
		frame.getContentPane().add(lb_pseudo);
		
		tf_pseudo = new JTextField();
		tf_pseudo.setColumns(10);
		tf_pseudo.setBounds(90, 76, 130, 20);
		frame.getContentPane().add(tf_pseudo);
		
		tf_mail = new JTextField();
		tf_mail.setColumns(10);
		tf_mail.setBounds(90, 107, 130, 20);
		frame.getContentPane().add(tf_mail);
		
		JLabel lb_mail = new JLabel("E-mail :");
		lb_mail.setBounds(10, 110, 130, 14);
		frame.getContentPane().add(lb_mail);
		
		tf_adress = new JTextField();
		tf_adress.setColumns(10);
		tf_adress.setBounds(90, 138, 130, 20);
		frame.getContentPane().add(tf_adress);
		
		JLabel lb_adress = new JLabel("Adress :");
		lb_adress.setBounds(10, 141, 130, 14);
		frame.getContentPane().add(lb_adress);
		
		JLabel lb_birthday = new JLabel("BirthDay :");
		lb_birthday.setBounds(10, 172, 130, 14);
		frame.getContentPane().add(lb_birthday);
		
		MaskFormatter mask = null;
		try {
			mask = new MaskFormatter("##/##/####");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JFormattedTextField tf_birthday = new JFormattedTextField(mask);
		tf_birthday.setBounds(90, 169, 130, 20);
		frame.getContentPane().add(tf_birthday);
		
		JLabel lb_password = new JLabel("Password :");
		lb_password.setBounds(10, 197, 89, 14);
		frame.getContentPane().add(lb_password);
		
		tf_password = new JPasswordField();
		tf_password.setBounds(90, 194, 130, 20);
		frame.getContentPane().add(tf_password);
		
		JLabel lb_password_confirm = new JLabel("Confirm password :");
		lb_password_confirm.setBounds(10, 225, 103, 14);
		frame.getContentPane().add(lb_password_confirm);
		
		tf_password_confirm = new JPasswordField();
		tf_password_confirm.setBounds(123, 222, 130, 20);
		frame.getContentPane().add(tf_password_confirm);
		
		JLabel lb_error = new JLabel("");
		lb_error.setForeground(Color.RED);
		lb_error.setHorizontalAlignment(SwingConstants.CENTER);
		lb_error.setBounds(10, 263, 414, 14);
		frame.getContentPane().add(lb_error);
		
		JButton bt_confirm = new JButton("Confirm");
		bt_confirm.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(tf_firstname.getText().equals("") || tf_pseudo.getText().equals("") || tf_mail.getText().equals("") || tf_adress.getText().equals("") || 
				   tf_birthday.getText().equals("") || tf_password_confirm.getText().equals("") || tf_password_confirm.getText().equals("")) {
					lb_error.setText("all must be fill");
				}
				if(!tf_password.getText().equals(tf_password_confirm.getText())) {
					lb_error.setText("Password doesn't match");
				}else {
					LocalDate CreationDate= LocalDate.now();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate birthDay = LocalDate.parse(tf_birthday.getText(),formatter);
					User user = new Player(tf_firstname.getText(), tf_password.getText(), tf_pseudo.getText(),CreationDate, birthDay, tf_mail.getText(), tf_adress.getText());
					if(user.Register((Player) user)){
						LoginWindow next = new LoginWindow();
						JFrame nextFrame=next.frame;
						ChangeFrame(nextFrame);
					}else {
						lb_error.setText("Error during the creation try again");
					}
				}	
			}
			public void ChangeFrame(Frame window){
				window.setVisible(true);
				frame.dispose();
			}
		});
		bt_confirm.setBounds(164, 292, 89, 23);
		frame.getContentPane().add(bt_confirm);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginWindow next = new LoginWindow();
				JFrame nextFrame=next.frame;
				ChangeFrame(nextFrame);
			}
			
			public void ChangeFrame(Frame window){
				window.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(163, 341, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
