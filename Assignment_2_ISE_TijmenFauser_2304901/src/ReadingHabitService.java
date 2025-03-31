import java.sql.*;
import java.util.Scanner;

public class ReadingHabitService {

    public static void showReadingHabits(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter User ID: ");
        int id = scanner.nextInt();
        PreparedStatement stmt = conn.prepareStatement("SELECT book, pagesRead, submissionMoment FROM ReadingHabit WHERE userID = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("book") + " - " + rs.getInt("pagesRead") + " pages on " + rs.getString("submissionMoment"));
        }
    }

    public static void changeBookTitle(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter habit ID: ");
        int habitID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new book title: ");
        String newTitle = scanner.nextLine();

        PreparedStatement stmt = conn.prepareStatement("UPDATE ReadingHabit SET book = ? WHERE habitID = ?");
        stmt.setString(1, newTitle);
        stmt.setInt(2, habitID);
        stmt.executeUpdate();
        System.out.println("Book title updated.");
    }

    public static void deleteReadingHabit(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter habit ID to delete: ");
        int habitID = scanner.nextInt();

        PreparedStatement stmt = conn.prepareStatement("DELETE FROM ReadingHabit WHERE habitID = ?");
        stmt.setInt(1, habitID);
        stmt.executeUpdate();
        System.out.println("Habit deleted.");
    }

    public static void usersPerBook(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter exact book title: ");
        String bookTitle = scanner.nextLine();
        PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(DISTINCT userID) AS Count FROM ReadingHabit WHERE book = ?");
        stmt.setString(1, bookTitle);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) System.out.println("Users who read it: " + rs.getInt("Count"));
    }

    public static void totalPagesRead(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT SUM(pagesRead) AS Total FROM ReadingHabit");
        if (rs.next()) System.out.println("Total pages read: " + rs.getInt("Total"));
    }

    public static void usersWithMultipleBooks(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS Count FROM (SELECT userID FROM ReadingHabit GROUP BY userID HAVING COUNT(DISTINCT book) > 1)");
        if (rs.next()) System.out.println("Users with multiple books: " + rs.getInt("Count"));
    }
}

