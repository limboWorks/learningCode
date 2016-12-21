package _10_extractValidateInput;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Starter extends Application {

    private Stage window;
    private Scene scene;
    private Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Use Input");

        //form
        TextField nameInput = new TextField();
        button = new Button("Enter");
        button.setOnAction(e -> isInt(nameInput, nameInput.getText()));

        //layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(nameInput, button);

        //scene
        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private int isInt(TextField nameInput, String text) {
        try {
            int age = Integer.parseInt(text);
            System.out.println("User is " + age + " years old.");
            return age;
        } catch (NumberFormatException e) {
            System.out.println("invalid input");
            return 0;
        }
    }
}
