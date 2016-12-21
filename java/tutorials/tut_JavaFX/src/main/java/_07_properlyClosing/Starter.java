package _07_properlyClosing;

import _06_commBetweenWindows.ConfirmBox;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Starter extends Application {


    //init
    Stage primaryStage;
    Button closeButton;
    Pane layout;
    Scene scene;


    public static void main(String[] args) {
        launch(args);
    }


    //setting up primaryStage
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("primaryStage");
        closeButton = new Button("Close");

        primaryStage.setOnCloseRequest(event -> {
            event.consume();
            closeProgram();
        });

        closeButton.setOnAction(e -> closeProgram());
        layout = new StackPane();
        layout.getChildren().add(closeButton);
        scene = new Scene(layout,300,250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private void closeProgram() {
        Boolean answer = ConfirmBox.display("Attention","Do you really want to close?");
        if(answer)
            primaryStage.close();
    }


}
