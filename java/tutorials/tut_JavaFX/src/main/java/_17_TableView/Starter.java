package _17_TableView;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Starter extends Application{
    private Stage window;
    private TableView<Product> table;
    private Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //stage
        window = primaryStage;
        window.setTitle("Listener");

        //Name column
        TableColumn<Product,String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        //Price column
        TableColumn<Product,Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        //Quantity column
        TableColumn<Product,Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(50);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(nameColumn,priceColumn,quantityColumn);

        //layout
        VBox layout = new VBox();
        layout.getChildren().addAll(table);
        scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

    //get all of the Products
    private ObservableList<Product> getProduct(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Apple",3.40,42));
        products.add(new Product("Banana",1.40,21));
        products.add(new Product("Pineapple",7.20,64));
        products.add(new Product("Nutella",5.90,85));
        products.add(new Product("Lolfruit",31.40,21));
        return products;
    }
}
