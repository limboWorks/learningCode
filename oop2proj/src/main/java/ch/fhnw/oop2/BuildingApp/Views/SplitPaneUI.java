package ch.fhnw.oop2.BuildingApp.Views;

import ch.fhnw.oop2.BuildingApp.Classes.BuildingClass;
import ch.fhnw.oop2.BuildingApp.PresentationModels.BuildingPresentationModel;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class SplitPaneUI extends SplitPane implements ViewMixin {
    //Create TableView
    private TableView buildingTable;
    //Create Columns
    private TableColumn<BuildingClass, Number> buildingRankCol;
    private TableColumn<BuildingClass, String> buildingNameCol;
    private TableColumn<BuildingClass, String> buildingCityCol;

    //get the PresentationModel
    private BuildingPresentationModel buPM;

    public SplitPaneUI(BuildingPresentationModel buPM){
        this.buPM = buPM;
        buildingTable.getSelectionModel().select(1);
        buildingTable.getSelectionModel().select(0);
    }

    @Override
    public void initializeControls() {
        buildingTable = new TableView(buPM.getFilteredList());
        buildingRankCol = new TableColumn("Rank");
        buildingNameCol = new TableColumn("Name");
        buildingCityCol = new TableColumn("City");

        //get Properties to the tableview
        buildingRankCol.setCellValueFactory(cell -> cell.getValue().buildingRankProperty());
        buildingNameCol.setCellValueFactory(cell -> cell.getValue().buildingNameProperty());
        buildingCityCol.setCellValueFactory(cell -> cell.getValue().cityNameProperty());
    }

    @Override
    public void layoutControls() {
        buildingTable.getColumns().addAll(buildingRankCol,buildingNameCol,buildingCityCol);

        getItems().addAll(buildingTable);
    }
}
