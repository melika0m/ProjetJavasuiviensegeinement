package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MasterIGDashboard extends JFrame {
    public MasterIGDashboard() {
        setTitle("Master IG Dashboard");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window on close

        // Create buttons
        JButton semestre1Button = new JButton("Semestre 1");
        JButton semestre2Button = new JButton("Semestre 2");
        JButton startYearButton = new JButton("Commencer l'année Universitaire");

        // Layout
        setLayout(new FlowLayout());
        add(semestre1Button);
        add(semestre2Button);
        add(startYearButton);

        // Button actions
        semestre1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action for Semestre 1 button
                JOptionPane.showMessageDialog(MasterIGDashboard.this, "Semestre 1 clicked");
            }
        });

        semestre2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action for Semestre 2 button
                JOptionPane.showMessageDialog(MasterIGDashboard.this, "Semestre 2 clicked");
            }
        });

//        startYearButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Action for Commencer l'année Universitaire button
//                JOptionPane.showMessageDialog(MasterIGDashboard.this, "Commencer l'année Universitaire clicked");
//            }
//        });
        startYearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a popup menu for options
                JPopupMenu popupMenu = new JPopupMenu();
                
                // Create menu items
                JMenuItem s1Option = new JMenuItem("S1");
                JMenuItem s2Option = new JMenuItem("S2");
                
                // Add actions to menu items
                s1Option.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Action for S1
                        JOptionPane.showMessageDialog(MasterIGDashboard.this, "Option S1 selected");
                    }
                });
                
                s2Option.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Action for S2
                        JOptionPane.showMessageDialog(MasterIGDashboard.this, "Option S2 selected");
                    }
                });
                
                // Add items to popup menu
                popupMenu.add(s1Option);
                popupMenu.add(s2Option);
                
                // Show popup menu
                popupMenu.show(startYearButton, startYearButton.getWidth()/2, startYearButton.getHeight()/2);
            }
        });

    }
}

