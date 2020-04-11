import java.sql.*;

public class Database {
    private static Connection connection = null;
    private static Database database;

    public Database() {
        database = new Database();
    }

    public static Database getDatabase() {
        return database;
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicalbums?useSSL=false", "dba", "sql");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}