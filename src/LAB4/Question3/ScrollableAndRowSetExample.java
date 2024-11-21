package LAB4.Question3;
import java.sql.*;
import javax.sql.rowset.*;

public class ScrollableAndRowSetExample {
    public static void main(String[] args) {
        // Database credentials and URL
        String url = "jdbc:mysql://localhost:3306/demo_db"; // Replace with your database name
        String user = "root"; // Default username for XAMPP MySQL
        String password = ""; // Default password is blank for XAMPP

        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            // 1. Scrollable and Read-Only ResultSet
            Statement stmt = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            System.out.println("Scrollable ResultSet:");
            rs.afterLast(); // Move to the end of the ResultSet
            while (rs.previous()) { // Iterate backward
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }

            // 2. Updatable ResultSet
            Statement updatableStmt = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            );
            ResultSet updatableRs = updatableStmt.executeQuery("SELECT * FROM students");

            System.out.println("\nUpdating ResultSet:");
            if (updatableRs.next()) {
                updatableRs.updateString("name", "Updated Alice");
                updatableRs.updateRow();
                System.out.println("Updated first row's name.");
            }

            // 3. Using RowSet (JdbcRowSet)
            RowSetFactory factory = RowSetProvider.newFactory();
            JdbcRowSet jdbcRowSet = factory.createJdbcRowSet();
            jdbcRowSet.setUrl(url);
            jdbcRowSet.setUsername(user);
            jdbcRowSet.setPassword(password);
            jdbcRowSet.setCommand("SELECT * FROM students");
            jdbcRowSet.execute();

            System.out.println("\nUsing RowSet:");
            while (jdbcRowSet.next()) {
                System.out.println("ID: " + jdbcRowSet.getInt("id") + ", Name: " + jdbcRowSet.getString("name"));
            }

            // 4. Using CachedRowSet
            CachedRowSet cachedRowSet = factory.createCachedRowSet();
            cachedRowSet.setUrl(url);
            cachedRowSet.setUsername(user);
            cachedRowSet.setPassword(password);
            cachedRowSet.setCommand("SELECT * FROM students");
            cachedRowSet.execute();

            System.out.println("\nUsing CachedRowSet:");
            while (cachedRowSet.next()) {
                System.out.println("ID: " + cachedRowSet.getInt("id") + ", Name: " + cachedRowSet.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
