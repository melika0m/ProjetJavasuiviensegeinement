package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class dbcnx {
    private static final String URL = "jdbc:mysql://localhost/projetjava";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
//    private static final String USERNAME = "hp"; // Remplacez par votre nom d'utilisateur
//    private static final String PASSWORD = "test"; // Remplacez par votre mot de passe

    private static volatile Connection con = null;

    private dbcnx() {
        try {
            Class.forName(DRIVER);
//            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            con= DriverManager.getConnection(URL,"root","");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver class not found: " + e);
        } catch (SQLException e) {
            System.out.println("SQLException caught: " + e);
        }
    }

    public static Connection getConnection() {
        if (con == null) {
            synchronized (dbcnx.class) {
                if (con == null) {
                    new dbcnx();
                }
            }
        }
        return con;
    }
    
}
