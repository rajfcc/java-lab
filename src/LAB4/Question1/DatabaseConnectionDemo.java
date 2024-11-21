package LAB4.Question1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnectionDemo {
    // Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/demo_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver registered successfully");

            // Step 2: Establish the connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected successfully");

            // Step 3: Create statement
            Statement statement = connection.createStatement();
            System.out.println("Statement created successfully");

            // Step 4: Execute query
            String sql = "SELECT * FROM employees";
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println("\nQuery results:");

            // Step 5: Process the result set
            while (resultSet.next()) {
                // Assuming employees table has id, name, and email columns
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
            }

            // Step 6: Close resources in reverse order
            resultSet.close();
            statement.close();
            connection.close();
            System.out.println("\nDatabase resources closed successfully");

        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}