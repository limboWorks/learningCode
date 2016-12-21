package alertBoxes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


    public class Starter extends Application {

        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage primaryStage) throws Exception {
            primaryStage.setTitle("JavaFX Tutorials - limboWorks");
            Button clickButton = new Button();
            Button inertButton = new Button();
            clickButton.setText("Click me!");
            inertButton.setText(".");
            clickButton.setOnAction(event -> AlertBox.display("Alert","GOTTA FIX DIS SHIT")); // calling AlertBox Class

            StackPane layout = new StackPane(); // stackpane piles everything ontop of eachother
            layout.getChildren().addAll(clickButton,inertButton);

            Scene scene = new Scene(layout, 300, 250);
            primaryStage.setScene(scene);
            primaryStage.show();

        }


    }


