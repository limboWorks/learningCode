package BuildingApp;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;

public class BuildingUI extends BorderPane implements ViewMixin {


    //init values
    private HBox top;
    private UI_right rightSide;
    private BuildingPresentationModel buildingPresentationModel;
    private TableView<BuildingClass> leftSide;
    private Button saveButton;
    private TableColumn<BuildingClass,Number> rank;
    private TableColumn<BuildingClass,String> name;
    private TableColumn<BuildingClass,String> city;


    //constructor
    public BuildingUI(BuildingPresentationModel buildingPresentationModel) {
        this.buildingPresentationModel = buildingPresentationModel;
        initializeControls();
        layoutControls();
    }


    //
    @Override
    public void initializeControls() {
        leftSide = new TableView(buildingPresentationModel.getFilteredList());
        rightSide = new UI_right();
        top = new HBox();
        saveButton = new Button("Save");
        name = new TableColumn("Name");
        rank = new TableColumn("Rank");
        city = new TableColumn("City");
        name.setCellValueFactory(param -> param.getValue().buildingNameProperty());
        rank.setCellValueFactory(param -> param.getValue().buildingRankProperty());
        city.setCellValueFactory(param -> param.getValue().cityNameProperty());
    }


    //
    @Override
    public void layoutControls() {
        top.getChildren().addAll(saveButton);
        BorderPane.setMargin(rightSide, new Insets(0, 5, 0, 5));
        leftSide.getColumns().addAll(rank,name,city);
        setLeft(leftSide);
        setRight(rightSide);
        setTop(top);
    }

}