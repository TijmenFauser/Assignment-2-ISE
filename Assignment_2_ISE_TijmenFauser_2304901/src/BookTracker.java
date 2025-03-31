import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class BookTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (Connection conn = DatabaseManager.connect()) {
            System.out.println("Connected to database.");

            while (true) {
                System.out.println("\n===== Booktracker Menu =====");
                System.out.println("1. Add a user");
                System.out.println("2. Show reading habits for a user");
                System.out.println("3. Change a book title");
                System.out.println("4. Delete a reading habit");
                System.out.println("5. Show mean age of users");
                System.out.println("6. Show number of users who read a specific book");
                System.out.println("7. Show total pages read");
                System.out.println("8. Show number of users who read more than one book");
                System.out.println("9. Add 'Name' column to User table");
                System.out.println("0. Exit");
                System.out.println("============================");
                System.out.println("Enter your choice: ");


                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1 -> UserService.addUser(conn, scanner);
                    case 2 -> ReadingHabitService.showReadingHabits(conn, scanner);
                    case 3 -> ReadingHabitService.changeBookTitle(conn, scanner);
                    case 4 -> ReadingHabitService.deleteReadingHabit(conn, scanner);
                    case 5 -> UserService.showMeanAge(conn);
                    case 6 -> ReadingHabitService.usersPerBook(conn, scanner);
                    case 7 -> ReadingHabitService.totalPagesRead(conn);
                    case 8 -> ReadingHabitService.usersWithMultipleBooks(conn);
                    case 9 -> UserService.addNameColumn(conn);
                    case 0 -> {
                        System.out.println("Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid option.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
