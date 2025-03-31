import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:sqlite:booktracker.db";

    public static Connection connect() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL);
        Statement init = conn.createStatement();
        init.execute("PRAGMA foreign_keys = ON"); // Enforce foreign keys
        return conn;
    }
}

