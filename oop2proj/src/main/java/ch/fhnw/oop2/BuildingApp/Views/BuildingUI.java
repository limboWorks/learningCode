package ch.fhnw.oop2.BuildingApp.Views;


import ch.fhnw.oop2.BuildingApp.Classes.BuildingClass;
import ch.fhnw.oop2.BuildingApp.PresentationModels.BuildingPresentationModel;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;

/**
 * The BuildingUI Classs is the main GUI Class
 */
public class BuildingUI extends BorderPane implements ViewMixin {


    private HBox top;
    private Editor rightSide;
    //private Node leftSide;
    private BuildingPresentationModel pMz;
    private SplitPane splitpane;
    private TableView<BuildingClass> leftSide;

    private Button saveButton;

    private TableColumn<BuildingClass,Number> rank;
    private TableColumn<BuildingClass,String> name;
    private TableColumn<BuildingClass,String> city;


//    public void setName(String text) {name.textProperty().setValue(text);}




    public BuildingUI(BuildingPresentationModel buildingPresentationModel) {
        this.pMz = buildingPresentationModel;
        initializeControls();
        layoutControls();
    }

    @Override
    public void initializeControls() {
        leftSide = new TableView(pMz.getFilteredList());

        rightSide = new Editor();
        top = new HBox();
        saveButton = new Button("Save");

        name = new TableColumn("Name");
        rank = new TableColumn("Rank");
        city = new TableColumn("City");
        name.setCellValueFactory(param -> param.getValue().buildingNameProperty());
        rank.setCellValueFactory(param -> param.getValue().buildingRankProperty());
        city.setCellValueFactory(param -> param.getValue().cityNameProperty());

        //leftSide = new SplitPaneUI(pMz);
    }

    @Override
    public void layoutControls() {
        top.getChildren().addAll(saveButton);
        BorderPane.setMargin(rightSide, new Insets(0, 5, 0, 5));

        leftSide.getColumns().addAll(rank,name,city);

        setLeft(leftSide);
        setRight(rightSide);
//        setLeft(leftSide);
        setTop(top);
    }
/*
   @Override
    private void initializeControls() {
        rightSide = new Editor();
        top = new HBox();
        saveButton = new Button("Save");
        name = new TableColumn();
        name.setCellValueFactory(param -> param.getValue().buildingNameProperty());

        splitpane = new SplitPane();

//        leftSide = new TableView<>();






    }


    @Override
    private void layoutControls() {
        top.getChildren().addAll(saveButton);
        BorderPane.setMargin(rightSide, new Insets(0, 5, 0, 5));

//        leftSide.getColumns().addAll(name);


        setRight(rightSide);
//        setLeft(leftSide);
        setTop(top);

    }
    */
}