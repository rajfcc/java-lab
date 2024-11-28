package LAB6.Question1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LayoutExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // HBox and VBox
        HBox hbox = new HBox(10, new Button("Btn 1"), new Button("Btn 2"));
        VBox vbox = new VBox(10, new Button("Btn A"), new Button("Btn B"));

        // BorderPane
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(new Button("Top"));
        borderPane.setBottom(new Button("Bottom"));
        borderPane.setLeft(new Button("Left"));
        borderPane.setRight(new Button("Right"));
        borderPane.setCenter(new Button("Center"));

        // GridPane
        GridPane gridPane = new GridPane();
        gridPane.add(new Button("0,0"), 0, 0);
        gridPane.add(new Button("1,0"), 1, 0);
        gridPane.add(new Button("0,1"), 0, 1);
        gridPane.add(new Button("1,1"), 1, 1);

        // StackPane
        StackPane stackPane = new StackPane(new Button("Stacked"));

        // Main layout
        VBox mainLayout = new VBox(20, hbox, vbox, borderPane, gridPane, stackPane);

        // Stage and scene
        primaryStage.setScene(new Scene(mainLayout, 400, 400));
        primaryStage.setTitle("JavaFX Layouts Demo");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
