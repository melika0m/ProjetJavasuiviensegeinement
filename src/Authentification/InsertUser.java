package Authentification;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import main.dbcnx;

public class InsertUser {
    public static void insertUser(String username, String password) {
        Connection conn = dbcnx.getConnection();
        if (conn != null) {
            try {
                String hashedPassword = HashPassword.hashPassword(password);
                PreparedStatement pst = conn.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");
                pst.setString(1, username);
                pst.setString(2, hashedPassword);
                int result = pst.executeUpdate();
                if (result > 0) {
                    System.out.println("User inserted successfully.");
                } else {
                    System.out.println("User insertion failed.");
                }
            } catch (SQLException e) {
                System.out.println("SQL Exception: " + e.getMessage());
            } catch (NoSuchAlgorithmException e) {
                System.out.println("No such algorithm exception: " + e.getMessage());
            }
        }
    }

    
}
