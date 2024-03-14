package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Dashboard extends JFrame {
    public Dashboard() {
        setTitle("Dashboard");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton masterFCButton = new JButton("Master FC");
        JButton masterIGButton = new JButton("Master IG");

        setLayout(new FlowLayout());
        add(masterFCButton);
        add(masterIGButton);

        masterFCButton.addActionListener(e -> JOptionPane.showMessageDialog(Dashboard.this, "Master FC clicked"));

        masterIGButton.addActionListener(e -> {
            EventQueue.invokeLater(() -> {
                ProjectButter projectButter = new ProjectButter(); // Assuming default constructor or appropriate constructor
                projectButter.setVisible(true);
                Dashboard.this.dispose(); // Optionally close the Dashboard window
            });
        });

        setVisible(true);
    }

}
