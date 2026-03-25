package a;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableSelection extends JPanel {

    private JButton[] tableButtons = new JButton[10];
    private Page main;

    public TableSelection(CardLayout layout, JPanel container, Page main) {
        this.main = main;
        setLayout(null);

        JLabel lblTitle = new JLabel("Select your table");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblTitle.setBounds(119, 29, 218, 40);
        add(lblTitle);

        int startX = 60;
        int startY = 80;

        for (int i = 0; i < tableButtons.length; i++) {
            final int tableIndex = i;
            tableButtons[i] = new JButton("" + (i + 1));
            if (i == 5) {
                startX = 60;
                startY += 90;
            }
            tableButtons[i].setBounds(startX, startY, 60, 60);
            startX += 70;  

            tableButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    main.currentSelectedTable = tableIndex;
                    layout.show(container, "Data"); 
                }
            });
            add(tableButtons[i]);
        }

        refreshTableColors();

        JButton btnBack = new JButton("Logout");
        btnBack.setBounds(10, 10, 80, 30);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layout.show(container, "login");
            }
        });
        add(btnBack);
    }

    public void refreshTableColors() {
        for (int i = 0; i < tableButtons.length; i++) {
            if (main.isTableBooked[i]) {
                tableButtons[i].setBackground(Color.RED);
                tableButtons[i].setForeground(Color.WHITE);
                tableButtons[i].setEnabled(false); // จองแล้วกดไม่ได้
            } else {
                tableButtons[i].setBackground(Color.GREEN);
                tableButtons[i].setForeground(Color.BLACK);
                tableButtons[i].setEnabled(true); // ว่างกดได้
            }
        }
    }
}
