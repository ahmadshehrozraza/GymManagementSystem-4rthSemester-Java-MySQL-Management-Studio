
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // Database credentials and URL
    private static final String URL = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=gym_management_system;encrypt=true;trustServerCertificate=true";
    private static final String USER = "admin";
    private static final String PASSWORD = "12345";

    /**
     * Establishes and returns a connection to the database.
     * @return Connection object if successful, null otherwise.
     */
    public static Connection getConnection() {
        try {
            // Optional: Load driver explicitly if needed (usually auto-loaded in newer JDBC)
            // Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
            return null;
        }
    }
}
