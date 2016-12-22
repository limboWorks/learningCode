package _15_ListView;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Starter extends Application{
    private Stage window;
    private Scene scene;
    private Button button;
    private ListView<String> listView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //stage
        window = primaryStage;
        window.setTitle("Listener");
        button = new Button("Click");

        //listview
        listView = new ListView<>();
        listView.getItems().addAll("21 grams","Amores Perros","The Revenant","Oldboy","Surrogates","BellaDonna's Buttface");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        button.setOnAction(event -> buttonClick());

        //layout
        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(button,listView);

        //scene
        scene = new Scene(layout,350,200);
        window.setScene(scene);
        window.show();
    }

    private void buttonClick() {
        String message = "";
        ObservableList<String> movies;
        movies = listView.getSelectionModel().getSelectedItems();

        //loop through movies and += it to message
        for (String m:movies){
            message += m + "\n";
        }

        //print the selected movies to console
        System.out.println(message);
    }
}
