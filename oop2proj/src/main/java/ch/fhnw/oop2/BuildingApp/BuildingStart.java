package ch.fhnw.oop2.BuildingApp;

import ch.fhnw.oop2.BuildingApp.PresentationModels.BuildingPresentationModel;
import ch.fhnw.oop2.BuildingApp.Views.BuildingUI;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BuildingStart extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        BuildingPresentationModel buildingPresentationModel = new BuildingPresentationModel();
        Parent rootPanel = new BuildingUI(buildingPresentationModel);
        Scene scene = new Scene(rootPanel);

        primaryStage.setScene(scene);
        primaryStage.setMinWidth(1200);
        primaryStage.setMinHeight(550);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

