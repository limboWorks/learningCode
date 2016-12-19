package ch.fhnw.oop2.BuildingApp;

import ch.fhnw.oop2.BuildingApp.Views.BorderPaneCenterUI;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BuildingStarter extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent rootPanel = new BorderPaneCenterUI();
        Scene scene = new Scene(rootPanel);

        primaryStage.setScene(scene);
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(550);


        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

