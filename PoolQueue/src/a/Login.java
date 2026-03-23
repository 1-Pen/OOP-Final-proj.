package a;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Login extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	private JTextField txtUsername;

	/**
	 * Create the panel.
	 */
	public Login(CardLayout layout, JPanel container, Page main) {
		setLayout(null);
		
		JButton btnNewButton = new JButton("Create an account..");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(container, "register");
			}
		});
		btnNewButton.setBounds(154, 220, 142, 20);
		add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(172, 136, 105, 18);
		add(passwordField);
		
		txtUsername = new JTextField("Enter Name...");
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
		txtUsername.setColumns(10);
		txtUsername.setBounds(172, 93, 105, 18);
		add(txtUsername);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLogin.setBounds(136, 28, 185, 25);
		add(lblLogin);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() { 
		    public void actionPerformed(ActionEvent e) {
		    	 String pass = new String(passwordField.getPassword());
			        if (main.checkLogin(txtUsername.getText(), pass)) {
			        	JOptionPane.showMessageDialog(null, "Done");
			            layout.show(container, "register");
			        }
			        else 
			            JOptionPane.showMessageDialog(null, "Invalid Name or Password!");
			    }
			});
		btnLogIn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogIn.setBounds(165, 175, 116, 25);
		add(btnLogIn);

	}

	
}