package commBetweenWindows;

import alertBoxes.AlertBox;
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

        //create stage
        primaryStage.setTitle("limboWorks");
        Button clickButton = new Button();
        clickButton.setText("Click me!");
        clickButton.setOnAction(event -> {

            boolean result = ConfirmBox.display("Wait!", "Do you really want to send Nudes to your crush?");
            System.out.println(result);
                });


        StackPane layout = new StackPane();
        layout.getChildren().add(clickButton);

        Scene scene = new Scene(layout, 300, 250);

        primaryStage.setScene(scene);
        primaryStage.show();

    }


}


