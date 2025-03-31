import java.sql.*;
import java.util.Scanner;

public class UserService {

    public static void addUser(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();

        PreparedStatement stmt = conn.prepareStatement("INSERT INTO User (age, gender) VALUES (?, ?)");
        stmt.setInt(1, age);
        stmt.setString(2, gender);
        stmt.executeUpdate();
        System.out.println("User added.");
    }

    public static void showMeanAge(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT AVG(age) AS MeanAge FROM User");
        if (rs.next()) System.out.println("Mean age: " + rs.getDouble("MeanAge"));
    }

    public static void addNameColumn(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        try {
            stmt.execute("ALTER TABLE User ADD COLUMN Name TEXT");
            System.out.println("Name column added.");
        } catch (SQLException e) {
            System.out.println("Column might already exist.");
        }
    }
}

