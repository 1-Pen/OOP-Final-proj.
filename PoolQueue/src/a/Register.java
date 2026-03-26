package a;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Register extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private JPasswordField confirmPasswordField;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel confirmLabel;

	/**
	 * Create the panel.
	 */
	public Register(CardLayout layout, JPanel container,Page main) {
		setBackground(new Color(240, 240, 240));
		setLayout(null);
		
		JButton toLogin = new JButton("Already have an account?");
		toLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(container, "Login");
			}
		});
		toLogin.setBounds(132, 231, 185, 20);
		add(toLogin);
		
		JLabel lblNewLabel = new JLabel("Create New Account");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(130, 32, 185, 25);
		add(lblNewLabel);
		
		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtUsername.getText().equals("Enter Name...")) {
					txtUsername.setText("");
					txtUsername.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtUsername.getText().isEmpty()) {
					txtUsername.setForeground(Color.GRAY);
					txtUsername.setText("Enter Name...");
		        }
		    }
		});
		
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setBounds(172, 101, 96, 18);
		add(txtUsername);
		txtUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(172, 129, 96, 18);
		add(passwordField);
		
		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setBounds(172, 157, 96, 18);
		add(confirmPasswordField);
		
		usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(112, 104, 50, 12);
		add(usernameLabel);
		
		passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(112, 132, 50, 12);
		add(passwordLabel);
		
		confirmLabel = new JLabel("Confirm Password:");
		confirmLabel.setBounds(75, 160, 87, 12);
		add(confirmLabel);
		
		JButton registerbtn = new JButton("Register");
		registerbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = new String(passwordField.getPassword());
				String confirmPassword = new String(confirmPasswordField.getPassword());
				
				if(txtUsername.getText().equals("Enter Name...") || password.trim().isEmpty() || confirmPassword.isEmpty()) 
                    JOptionPane.showMessageDialog(Register.this, "Please fill everything in form", "Alert", JOptionPane.WARNING_MESSAGE);
				else {
					if(confirmPassword.equals(password)) {
						Page.User ud = new Page.User(txtUsername.getText(), password);
						main.addUser(ud);
						JOptionPane.showMessageDialog(null, "Account created");
						layout.show(container, "Login");
					}
					else
						JOptionPane.showMessageDialog(null, "Password doesn't match");
				}
			}
				
		});
		registerbtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		registerbtn.setBounds(162, 193, 116, 25);
		add(registerbtn);

	}
}
