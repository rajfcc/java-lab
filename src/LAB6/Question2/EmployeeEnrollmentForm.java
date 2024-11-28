package LAB6.Question2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class EmployeeEnrollmentForm extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create labels and input fields
        Label nameLabel = new Label("Employee Name:");
        TextField nameField = new TextField();

        Label idLabel = new Label("Employee ID:");
        TextField idField = new TextField();

        Label departmentLabel = new Label("Department:");
        TextField departmentField = new TextField();

        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();

        Label phoneLabel = new Label("Phone Number:");
        TextField phoneField = new TextField();

        // Create a submit button
        Button submitButton = new Button("Submit");

        // Arrange the form in a GridPane
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        gridPane.add(nameLabel, 0, 0);
        gridPane.add(nameField, 1, 0);

        gridPane.add(idLabel, 0, 1);
        gridPane.add(idField, 1, 1);

        gridPane.add(departmentLabel, 0, 2);
        gridPane.add(departmentField, 1, 2);

        gridPane.add(emailLabel, 0, 3);
        gridPane.add(emailField, 1, 3);

        gridPane.add(phoneLabel, 0, 4);
        gridPane.add(phoneField, 1, 4);

        gridPane.add(submitButton, 1, 5);

        // Set padding for the gridPane
        gridPane.setStyle("-fx-padding: 20;");

        // Create a scene and set it on the stage
        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setTitle("Employee Enrollment Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
