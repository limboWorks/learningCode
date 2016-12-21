package gridPane;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Starter extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage primaryStage1 = primaryStage;
        primaryStage1.setTitle("gridPane");

        //create GridPane Layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        //name Label
        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel,0,0);

        //name input
        TextField nameInput = new TextField("Limbo");
        GridPane.setConstraints(nameInput,0,0);

        //pass Label
        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel,0,1);

        //pass input
        TextField passInput = new TextField("");
        passInput.setPromptText("Password");
        GridPane.setConstraints(passInput,0,1);

        //loginButton
        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton,1,2);

        grid.getChildren().addAll(nameLabel,nameInput,passLabel,passInput,loginButton);

        Scene scene = new Scene(grid,300,200);
        primaryStage1.setScene(scene);
        primaryStage1.show();
    }
}
