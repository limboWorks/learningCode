package ch.fhnw.oop2.DepartureBoard;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class DepartStarter extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        PresentationModel pM = new PresentationModel();
        Parent rootPanel = new ApplicationUI(pM);

        Scene scene = new Scene(rootPanel);

        String stylesheet = getClass().getResource("style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);

        primaryStage.titleProperty().bind(pM.applicationTitleProperty());
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setMinWidth(1200);
        primaryStage.setMinHeight(500);

        primaryStage.getIcons().add(new Image("/ion.png"));}

    public static void main(String[] args) {
        launch(args);
    }
}
