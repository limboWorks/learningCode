package _14_ComboBox;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Starter extends Application{
    private Stage window;
    private Scene scene;
    private Button button;
    private ComboBox<String> comboBox;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //stage
        window = primaryStage;
        window.setTitle("Listener");
        button = new Button("Watch");

        //combobox
        comboBox = new ComboBox<>();
        comboBox.getItems().addAll(
                "Good Will Hunting",
                "Oldboy",
                "Mulholland Drive",
                "BellaDonna's Buttface");
        comboBox.setPromptText("What's your favourite movie?");
        button.setOnAction(event -> printMovie());
        comboBox.setOnAction(event -> System.out.println("User selected "+comboBox.getValue()));
        comboBox.setEditable(true);

        //layout
        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(button,comboBox);

        //scene
        scene = new Scene(layout,350,200);
        window.setScene(scene);
        window.show();
    }

    private void printMovie() {
        System.out.println("User watched "+comboBox.getValue());
    }
}
