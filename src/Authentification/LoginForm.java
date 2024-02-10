package Authentification;


import javax.swing.*;

import main.dbcnx;
import ui.Dashboard;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.NoSuchAlgorithmException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

//                if (authenticate(username, new String(password))) {
//                    JOptionPane.showMessageDialog(LoginForm.this, "You are successfully logged in.");
//                } else {
//                    JOptionPane.showMessageDialog(LoginForm.this, "Invalid username or password.");
//                }
                if (authenticate(username, new String(password))) {
                    JOptionPane.showMessageDialog(LoginForm.this, "You are successfully logged in.");
                    LoginForm.this.setVisible(false); // Hide login form
                    new Dashboard().setVisible(true); // Show dashboard
                } else {
                    JOptionPane.showMessageDialog(LoginForm.this, "Invalid username or password.");
                }

            }
        });
    }

   
        // Implement your authentication logic here
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
    	        }
    	    }
    	    return false;
    	

    	}   
}
