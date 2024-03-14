package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbcnx {
    private static final String URL = "jdbc:mysql://localhost/projetjava";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static volatile Connection con = null;

    private dbcnx() {
        connect();
    }

    private static void connect() {
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, "root", "");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver class not found: " + e.getMessage(), e);
        } catch (SQLException e) {
            throw new RuntimeException("SQLException caught: " + e.getMessage(), e);
        }
    }

    public static Connection getConnection() {
        if (con == null) {
            synchronized (dbcnx.class) {
                if (con == null) {
                    new dbcnx();
                }
            }
        } else {
            try {
                if (con.isClosed()) {
                    connect();
                }
            } catch (SQLException e) {
                throw new RuntimeException("Failed to check connection status: " + e.getMessage(), e);
            }
        }
        return con;
    }
}
