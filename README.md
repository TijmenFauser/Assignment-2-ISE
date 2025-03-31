# Assignment-2-ISE
# BookTracker Application

## Overview
BookTracker is a Java-based command-line application that allows users to track and manage their reading habits. It provides functionalities to add users, track books read, record pages read, and view various statistics about reading habits.

## Project Structure
The application is structured with the following Java classes:
- `BookTracker.java`: The main class containing the application menu and control flow
- `DatabaseManager.java`: Handles database connection and configuration
- `UserService.java`: Contains methods for user-related operations
- `ReadingHabitService.java`: Contains methods for reading habit management and statistics

## Database Schema
The application uses a SQLite database with two main tables:
1. **User Table**
   - userID (INTEGER): Primary key
   - age (INTEGER): User's age
   - gender (TEXT): User's gender
   - name (TEXT): User's name (optional column that can be added)

2. **ReadingHabit Table**
   - habitID (INTEGER): Primary key
   - userID (INTEGER): Foreign key referencing User table
   - book (TEXT): Book title
   - pagesRead (INTEGER): Number of pages read
   - submissionMoment (TEXT): Timestamp of when the reading habit was recorded

## Features
The application provides the following functionalities:

1. **User Management**
   - Add new users with age and gender
   - Add a 'Name' column to the User table (schema modification)
   - View mean age of all users

2. **Reading Habit Management**
   - View reading habits for a specific user
   - Change book titles in the database
   - Delete reading habit records
   - Show statistics about reading habits:
     - Number of users who read a specific book
     - Total pages read by all users
     - Number of users who read more than one book

## How to Run the Application
1. Ensure you have Java Development Kit (JDK) installed on your system.
2. Make sure you have the SQLite JDBC driver in your classpath.
3. Compile all Java files:
   ```
   javac *.java
   ```
4. Run the application:
   ```
   java BookTracker
   ```
5. Follow the on-screen menu to interact with the application.

### Requirements

- Java (17 or higher recommended)
- SQLite JDBC Driver (`sqlite-jdbc-3.42.0.0.jar`)
- `booktracker.db` already populated

---

## Database Connection
The application connects to a SQLite database named `booktracker.db` in the same directory as the application. If the database doesn't exist, it will be created automatically.

## Menu Options
When you run the application, you'll see a menu with the following options:
1. Add a user (with auto-generated user ID)
2. Show reading habits for a user
3. Change a book title for a specific reading habit
4. Delete a reading habit
5. Show mean age of users
6. Show number of users who read a specific book
7. Show total pages read
8. Show number of users who read more than one book
9. Add 'Name' column to User table
0. Exit

## Example Usage
1. Add a new user:
   - Select option 1
   - Enter the user's age and gender

2. View reading habits for a user:
   - Select option 2
   - Enter the user ID

3. Get statistics about reading habits:
   - Select options 5-8 to view different statistics

## Implementation Notes
- The application uses JDBC to connect to the SQLite database
- Foreign key constraints are enabled to maintain data integrity
- SQL queries are used for data calculations and statistics instead of Java computations
- Prepared statements are used to prevent SQL injection

## Data Format
The application comes with pre-populated data if you're using the provided database file. The data includes:
- 65 users with ages and genders
- 100 reading habit records with book titles, pages read, and submission timestamps

## Error Handling
The application includes basic error handling for database operations and user input. If a database error occurs, an error message will be displayed with details about the exception.
