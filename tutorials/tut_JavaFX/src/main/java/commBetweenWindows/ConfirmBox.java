package commBetweenWindows;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class ConfirmBox {

    static boolean answer;

    public static boolean display(String title, String message) {


        //create Stage and Settings
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Alert!");
        window.setMinWidth(250);
        Label label = new Label();
        label.setText(message);


        //create two buttons
        Button yesButton = new Button("yes");
        yesButton.setOnAction(event -> {
            answer = true;
            window.close();
        });
        Button noButton = new Button("no");
        noButton.setOnAction(event -> {
            answer = false;
            window.close();
        });


        //create VBox Layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,yesButton,noButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }
}
