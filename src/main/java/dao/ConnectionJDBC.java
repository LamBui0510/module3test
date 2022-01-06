package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionJDBC {
    public static Connection getConnection() {
        String jdbcURL = "jdbc:mysql://localhost:3306/quanlysanpham";
        String jdbcUsername = "root";
        String jdbcPassword = "mothaiba123.";
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (
                Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
