package BuildingApp;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Starter extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        BuildingPresentationModel buildingPresentationModel = new BuildingPresentationModel();
        Parent rootPanel = new BuildingUI(buildingPresentationModel);
        Scene scene = new Scene(rootPanel);

        primaryStage.setScene(scene);
        primaryStage.setMinWidth(700);
        primaryStage.setMinHeight(550);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

