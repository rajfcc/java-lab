package LAB4.Question4;

import java.sql.*;

public class TransactionExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/demo_db"; // Replace with your database
        String user = "root"; // Default username for XAMPP MySQL
        String password = ""; // Default password is blank for XAMPP

        Connection connection = null;

        try {
            // Establish connection
            connection = DriverManager.getConnection(url, user, password);

            // Disable auto-commit mode
            connection.setAutoCommit(false);

            // Prepare SQL statements
            String withdrawSQL = "UPDATE accounts SET balance = balance - ? WHERE name = ?";
            String depositSQL = "UPDATE accounts SET balance = balance + ? WHERE name = ?";

            try (
                    PreparedStatement withdrawStmt = connection.prepareStatement(withdrawSQL);
                    PreparedStatement depositStmt = connection.prepareStatement(depositSQL)
            ) {
                // Withdraw from Alice's account
                withdrawStmt.setDouble(1, 200); // Amount to withdraw
                withdrawStmt.setString(2, "Alice");
                withdrawStmt.executeUpdate();

                // Simulate an error (uncomment to test rollback)
//                 int x = 1 / 0;



                // Deposit into Bob's account
                depositStmt.setDouble(1, 200); // Amount to deposit
                depositStmt.setString(2, "Bob");
                depositStmt.executeUpdate();

                // Commit the transaction
                connection.commit();
                System.out.println("Transaction successful!");
            } catch (Exception e) {
                // Rollback the transaction in case of an error
                if (connection != null) {
                    connection.rollback();
                }
                System.out.println("Transaction failed. Rolled back.");
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection
            if (connection != null) {
                try {
                    connection.setAutoCommit(true); // Restore auto-commit mode
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

