package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
    public static Connection connection;
    private final String DB_URL = "jdbc:mysql://localhost:3306/pitch_management";
    private final String USERNAME = "root";
    private final String PASSWORD = "12345aaa";
    public DAO() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
