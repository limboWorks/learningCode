package embeddingLayouts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Starter extends Application{


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage primaryStage1 = primaryStage;
        primaryStage1.setTitle("Embedded");

        HBox topMenu = new HBox();
        Button buttonA = new Button("File");
        Button buttonB = new Button("Edit");
        Button buttonC = new Button("View");
        topMenu.getChildren().addAll(buttonA, buttonB, buttonC);

        VBox sideMenu = new VBox();
        buttonA = new Button("A");
        buttonB = new Button("B");
        buttonC = new Button("C");
        sideMenu.getChildren().addAll(buttonA, buttonB, buttonC);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topMenu);
        borderPane.setLeft(sideMenu);

        Scene scene = new Scene(borderPane,300,250);
        primaryStage1.setScene(scene);
        primaryStage1.show();


    }
}
