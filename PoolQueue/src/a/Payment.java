package a;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import java.io.File;

public class Payment extends JPanel {
	private static JLabel lblPrice;
	public static void updateData() {
		
		lblPrice.setText(String.format("Total: %d Baht", Page.price));
    }

    public Payment(CardLayout layout, JPanel container, Page main) {
        setLayout(null);

        lblPrice = new JLabel("", SwingConstants.CENTER);
        lblPrice.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblPrice.setForeground(Color.RED); 
        lblPrice.setBounds(100, 55, 218, 40);
        add(lblPrice);
        
        
        
        JLabel lblTitle = new JLabel("Payment", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblTitle.setBounds(100, 27, 218, 40);
        add(lblTitle);

        

        JLabel lblQRCode = new JLabel("<html><center>จำลองภาพ<br>QR Code</center></html>", SwingConstants.CENTER);
        lblQRCode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblQRCode.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        lblQRCode.setBounds(74, 100, 100, 100);
        add(lblQRCode);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(10, 10, 80, 30);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layout.show(container, "Data");
            }
        });
        add(btnBack);

        JButton btnDone = new JButton("Confirm payment");
        btnDone.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnDone.setBounds(106, 211, 200, 40);
        btnDone.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                main.isTableBooked[main.currentSelectedTable] = true;
                main.tablePage.refreshTableColors();
                layout.show(container, "TableSelection"); 
            }
        });
        add(btnDone);
        
        JButton btnUpload = new JButton("Slip File");
        btnUpload.setBounds(200, 100, 218, 40);
        btnUpload.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    System.out.println("Selected File: " + selectedFile.getAbsolutePath());

                }
            }
        });
        add(btnUpload);
    }
    
}
