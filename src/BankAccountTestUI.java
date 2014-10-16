import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JRadioButton;


public class BankAccountTestUI {

	private JFrame frame;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankAccountTestUI window = new BankAccountTestUI();
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
	public BankAccountTestUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCreateAccount = new JButton("CREATE ACCOUNT");
		btnCreateAccount.setBackground(UIManager.getColor("Button.light"));
		btnCreateAccount.setOpaque(true);
		btnCreateAccount.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		btnCreateAccount.setBounds(88, 122, 200, 65);
		frame.getContentPane().add(btnCreateAccount);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBackground(UIManager.getColor("Button.light"));
		btnNewButton.setOpaque(true);
		btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(88, 200, 200, 65);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to ATMlite.");
		lblWelcomeToThe.setFont(new Font("Segoe UI Light", Font.PLAIN, 33));
		lblWelcomeToThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToThe.setBounds(12, 24, 358, 56);
		frame.getContentPane().add(lblWelcomeToThe);
		
		JLabel lblSignUpOr = new JLabel("Sign up or login to get started.");
		lblSignUpOr.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSignUpOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUpOr.setBounds(88, 76, 207, 23);
		frame.getContentPane().add(lblSignUpOr);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 382, 353);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(88, 202, 209, 62);
		panel.add(passwordField);
		
		JLabel lblPinNumber = new JLabel("PIN Number");
		lblPinNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblPinNumber.setBounds(140, 184, 96, 16);
		panel.add(lblPinNumber);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Account 1");
		rdbtnNewRadioButton.setBounds(88, 85, 127, 25);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnAccount = new JRadioButton("Account 2");
		rdbtnAccount.setBounds(88, 107, 127, 25);
		panel.add(rdbtnAccount);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
		lblLogin.setBounds(31, 13, 205, 53);
		panel.add(lblLogin);
	}
}
