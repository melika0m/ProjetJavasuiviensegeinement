package Authentification;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import main.dbcnx; // Ensure this class exists and has a method getConnection
import ui.Dashboard; // Ensure this class exists for the application's dashboard

public class LoginForm extends JFrame {

    public LoginForm() {
        initUI();
    }

    private void initUI() {
        setTitle("Login Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(600, 600); // Set the size of the login form
        setLocationRelativeTo(null); // Center the form on the screen

        // Logo Panel
        JPanel logoPanel = new JPanel();
        logoPanel.setLayout(new BorderLayout());
        logoPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        ImageIcon logoIcon = new ImageIcon("path/to/your/logo.png"); // Replace with the path to your logo image
        JLabel logoLabel = new JLabel("", logoIcon, JLabel.CENTER);
        logoPanel.add(logoLabel, BorderLayout.CENTER);

        // Form Panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel labelUsername = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(labelUsername, gbc);

        JTextField usernameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        formPanel.add(usernameField, gbc);

        JLabel labelPassword = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(labelPassword, gbc);

        JPasswordField passwordField = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        formPanel.add(passwordField, gbc);

        JButton loginButton = new JButton("Login");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(loginButton, gbc);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();

                if (authenticate(username, new String(password))) {
                    JOptionPane.showMessageDialog(LoginForm.this, "You are successfully logged in.");
                    LoginForm.this.setVisible(false); // Hide login form
                    new Dashboard().setVisible(true); // Show dashboard
                } else {
                    JOptionPane.showMessageDialog(LoginForm.this, "Invalid username or password.");
                }
            }
        });

        // Adding Panels to the Frame
        add(logoPanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);

        // Set the background color of the main panel (optional)
        getContentPane().setBackground(Color.WHITE);

        // Improve the look and feel to match the system's native UI
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private boolean authenticate(String username, String password) {
        Connection conn = dbcnx.getConnection();
        if (conn != null) {
            try {
                PreparedStatement pst = conn.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
                pst.setString(1, username);
                pst.setString(2, password); // In a real application, consider using hashed passwords for security
                ResultSet rs = pst.executeQuery();
                return rs.next(); // Returns true if a match is found
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LoginForm loginForm = new LoginForm();
                loginForm.setVisible(true);
            }
        });
    }
}
