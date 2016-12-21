package _11_checkBoxes;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Starter extends Application{
    private Stage window;
    private Scene scene;
    private Button button;
    private CheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Checkboxes");

        //checkboxes
        checkBox1 = new CheckBox("Virgin");
        checkBox1.setSelected(true);
        checkBox2 = new CheckBox("Anal Virgin");
        checkBox3 = new CheckBox("Deepthroater");
        checkBox4 = new CheckBox("Gaper");
        checkBox5 = new CheckBox("Squirter");

        //button
        button = new Button("Order Slut");
        button.setOnAction(event -> handleOptions(checkBox1,checkBox2));

        //layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,button);

        //scene
        scene = new Scene(layout,300,200);
        window.setScene(scene);
        window.show();
    }

    //handle checkbox options
    private void handleOptions(CheckBox checkBox1, CheckBox checkBox2){
        String message = "User orders:\n";

        if(checkBox1.isSelected()&&checkBox2.isSelected()){
            System.out.println("SUPER VIRGIN");
        }
    }
}
