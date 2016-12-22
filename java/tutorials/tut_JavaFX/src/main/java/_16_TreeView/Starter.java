package _16_TreeView;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Starter extends Application{
    private Stage window;
    private Scene scene;
    private TreeView<String> tree;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //stage
        window = primaryStage;
        window.setTitle("Listener");

        //TreeView
        TreeItem<String> root, lorenzo, umut;
        root = new TreeItem<>();
        root.setExpanded(true);
        //lorenzo
        lorenzo = makeBranch("Lorenzo",root);
        makeBranch("Girls", lorenzo);
        makeBranch("Drugs", lorenzo);
        makeBranch("Guns", lorenzo);
        //umut
        umut = makeBranch("Umut",root);
        makeBranch("Family", umut);
        makeBranch("Football", umut);
        makeBranch("Games", umut);
        //create tree
        tree = new TreeView<>(root);
        tree.setShowRoot(false);
        tree.getSelectionModel().selectedItemProperty()
                .addListener((v,oldValue,newValue)->{
            if(newValue!=null)
                System.out.println(newValue.getValue());
        });

        //layout
        StackPane layout = new StackPane();
        layout.getChildren().add(tree);
        scene = new Scene(layout,350,200);
        window.setScene(scene);
        window.show();
    }

    private TreeItem<String> makeBranch(String title, TreeItem<String> root) {
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        root.getChildren().add(item);
        return item;
    }


}
