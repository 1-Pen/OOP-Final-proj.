package a;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class Page extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CardLayout cardLayout = new CardLayout();
	
	
	public static class User {
	    private String name;
	    private String password;

	    public User(String name, String password) {
	        this.name = name;
	        this.password = password;
	    }

	    public String getName() { 
	    	return name; 
	    }
	    
	    public String getPassword() { 
	    	return password;
	    }
	}
	
	
	private ArrayList<User> registeredUsers = new ArrayList<>();

    public boolean checkLogin(String name, String password) {
        for (User i : registeredUsers) {
            if (i.getName().equals(name) && i.getPassword().equals(password)) 
                return true; // Match found
        }
        return false; // No match
    }
    
    public void addUser(User u) {
        registeredUsers.add(u);
    }
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Page frame = new Page();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 300);
    // This is the "Deck of Cards"
		contentPane = new JPanel();
		contentPane.setLayout(cardLayout);
    	setContentPane(contentPane);
    	Register register = new Register(cardLayout, contentPane, this);
    	contentPane.add(register, "register");
    	contentPane.add(new Login(cardLayout, contentPane, this), "login");
    
    // Show the starting page
    	cardLayout.show(contentPane, "register");
	}

}
