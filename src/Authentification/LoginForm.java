package Authentification;


import javax.swing.*;

import main.dbcnx;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.NoSuchAlgorithmException;

public class LoginForm extends JFrame {
    public LoginForm() {
        setTitle("Login Form");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create UI elements
        JTextField usernameField = new JTextField(15);
        JPasswordField passwordField = new JPasswordField(15);
        JButton loginButton = new JButton("Login");

        // Layout
        setLayout(new FlowLayout());
        add(new JLabel("Username:"));
        add(usernameField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(loginButton);

        // Login action
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();

                if (authenticate(username, new String(password))) {
                    JOptionPane.showMessageDialog(LoginForm.this, "You are successfully logged in.");
                } else {
                    JOptionPane.showMessageDialog(LoginForm.this, "Invalid username or password.");
                }
            }
        });
    }

   
    

    private boolean authenticate(String username, String inputPassword) {
        Connection conn = dbcnx.getConnection();
        if (conn != null) {
            try {
                // Hash the input password
                String hashedInputPassword = HashPassword.hashPassword(inputPassword);
                
                PreparedStatement pst = conn.prepareStatement("SELECT password FROM users WHERE username=?");
                pst.setString(1, username);
                ResultSet rs = pst.executeQuery();
                
                if (rs.next()) {
                    // Compare hashed input password with the stored hash
                    String storedPasswordHash = rs.getString("password");
                    return hashedInputPassword.equals(storedPasswordHash);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                System.err.println("Hashing algorithm not found: " + e.getMessage());
            }
        }
        return false;
    }


    

   
}
