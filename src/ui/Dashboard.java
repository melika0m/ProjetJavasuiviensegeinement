package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame {
    public Dashboard() {
        setTitle("Dashboard");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create buttons
        JButton masterFCButton = new JButton("Master FC");
        JButton masterIGButton = new JButton("Master IG");

        // Layout
        setLayout(new FlowLayout());
        add(masterFCButton);
        add(masterIGButton);

        // Button actions
        masterFCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add action for Master FC button
                JOptionPane.showMessageDialog(Dashboard.this, "Master FC clicked");
            }
        });

//        masterIGButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Add action for Master IG button
//                JOptionPane.showMessageDialog(Dashboard.this, "Master IG clicked");
//            }
//        });
        masterIGButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open Master IG Dashboard
                new MasterIGDashboard().setVisible(true);
            }
        });

    }
}

