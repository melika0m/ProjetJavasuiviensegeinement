package ui;

import javax.swing.*;

import Listesfortables.ProfesseursListe;

import java.awt.*;
import java.awt.event.ActionEvent;

public class ProjectButter extends JFrame {
    public ProjectButter() {
        try {
            // Set the Nimbus look and feel
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, fall back to the default look and feel.
        }

        setTitle("Project Butter");
        setSize(800, 600); // Adjust size as needed
        setLocationRelativeTo(null); // Center on screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Sidebar panel
        JPanel sidebarPanel = new JPanel();
        sidebarPanel.setLayout(new BoxLayout(sidebarPanel, BoxLayout.Y_AXIS));

        // Consider adding icons to your buttons
        JButton dashboardButton = new JButton("Dashboard", new ImageIcon("path/to/dashboard/icon"));
        JButton professeursButton = new JButton("Professeurs", new ImageIcon("path/to/professeurs/icon"));
        JButton coursButton = new JButton("Cours", new ImageIcon("path/to/cours/icon"));
        JButton deconnexionButton = new JButton("Deconnexion", new ImageIcon("path/to/deconnexion/icon"));

        sidebarPanel.add(dashboardButton);
        sidebarPanel.add(professeursButton);
        sidebarPanel.add(coursButton);
        sidebarPanel.add(Box.createVerticalGlue()); // This will push the Deconnexion button to the bottom
        sidebarPanel.add(deconnexionButton);
        JButton retourButton = new JButton("Retour à M1/M2");
        retourButton.addActionListener(e -> retourToM1M2());

        // Assuming sidebarPanel is your JPanel for buttons
        sidebarPanel.add(retourButton);
        // Adding sidebar to the frame
        add(sidebarPanel, BorderLayout.WEST);

        // Menu bar
        JMenuBar menuBar = new JMenuBar();
        JButton s1Button = new JButton("S1");
        JButton startYearButton = new JButton("Start Semestre");
        JLabel anneeUniversitaireLabel = new JLabel("Année Universitaire");

        menuBar.add(s1Button);
        menuBar.add(startYearButton);
        menuBar.add(Box.createHorizontalGlue()); // This will push the label to the right
        menuBar.add(anneeUniversitaireLabel);

        // Add a small image to the top-right corner
        JLabel imageLabel = new JLabel(new ImageIcon("path/to/image"));
        menuBar.add(imageLabel);

        setJMenuBar(menuBar);

        // Main panel for dashboard widgets
        JPanel dashboardPanel = new JPanel(new GridLayout(2, 2, 10, 10)); // Example grid layout
        // Add widgets to the dashboardPanel here

        // Adding dashboard to the frame
        add(dashboardPanel, BorderLayout.CENTER);

        // Action listeners for buttons
        // Example for Deconnexion button
        deconnexionButton.addActionListener((ActionEvent e) -> {
            System.out.println("Deconnexion clicked"); // Placeholder action
        });

        // Add action listeners for other buttons similarly
        startYearButton.addActionListener(e -> {
            EventQueue.invokeLater(() -> {
                SemestreForm semestreForm = new SemestreForm();
                semestreForm.setVisible(true);
            });
        });
        professeursButton.addActionListener(e -> {
            ProfesseursListe professeursListe = new ProfesseursListe();
            professeursListe.setVisible(true);
        });

        // Ensure visibility
        setVisible(true);
    }
    private void retourToM1M2() {
        this.dispose(); // Close or hide the ProjectButter window
        EventQueue.invokeLater(() -> {
            M1M2 m1m2Window = new M1M2();
            m1m2Window.setVisible(true); // Show the M1M2 window
        });
    }

    
}
