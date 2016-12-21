package BuildingApp;

import javafx.scene.control.*;

public class UI_left extends SplitPane implements ViewMixin {

    //Create TableView
    private TableView buildingTable;
    //Create Columns
    private TableColumn<BuildingClass, Number> buildingRankCol;
    private TableColumn<BuildingClass, String> buildingNameCol;
    private TableColumn<BuildingClass, String> buildingCityCol;

    //get the PresentationModel
    private BuildingPresentationModel buPM;

    public UI_left(BuildingPresentationModel buPM){
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
