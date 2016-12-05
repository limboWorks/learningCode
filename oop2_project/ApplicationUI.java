package ch.fhnw.oop2.DepartureBoard;

import com.sun.javafx.geom.Area;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import ch.fhnw.oop2.DepartureBoard.SimpleControl;

import static javafx.geometry.Orientation.HORIZONTAL;
import static javafx.geometry.Orientation.VERTICAL;
import static javafx.geometry.VPos.*;

public class ApplicationUI extends BorderPane {

    private PresentationModel pM;

    private TableView<Result> elements;
	private Button ctrZbutton, ctrVbutton,saveButton,addButton,deleteButton,showDepartureBoardButton,
			uploadButton,pauseButton,playButton;
	private Label abfahrt,nach,zugnummer,gleis,zwischenhalt;
	private TextField abfahrtTextfield,nachTextfield,zugnummerTextfield,gleisTextfield,searchField;
	private TextArea zwischenhaltArea;
	private HBox hBox;
	private SplitPane splitPane1;
    private GridPane gPane;
    private SimpleControl customControl;
	public ApplicationUI(PresentationModel PM) {
        this.pM = PM;
		initializeControls();
		layoutControls();
		addEventHandlers();
		addValueChangedListeners();
		addBindings();
	}

	private void initializeControls() {
		ctrZbutton = new Button("Undo");
		ctrVbutton = new Button("Redo");
		saveButton = new Button("Save");
		addButton = new Button("Add");
		deleteButton = new Button("Delete");
		showDepartureBoardButton = new Button("Show board");
		uploadButton = new Button("Upload");
		pauseButton = new Button("Pause");
		playButton = new Button("Play");
		zwischenhaltArea = new TextArea();
		abfahrt = new Label("Abfahrt: ");
		nach = new Label("Nach: ");
		zugnummer = new Label("Zugnummer: ");
		gleis = new Label("Gleis: ");
		zwischenhalt = new Label("Zwischenhalt: ");
		hBox = new HBox();
        gPane = new GridPane();
        nachTextfield = new TextField();
		searchField = new TextField("Search");
        abfahrtTextfield=new TextField();
        zugnummerTextfield = new TextField();
        gleisTextfield = new TextField();
        elements = initilizeResultElements();
		splitPane1 = new SplitPane();
        splitPane1.setDividerPosition(0,2);
        customControl = new SimpleControl();

    }
    private TableView<Result> initilizeResultElements() {
        TableView<Result> tableView = new TableView<>(pM.getElements());

        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		TableColumn<Result, String> activTableCell  = new TableColumn<>("");
        TableColumn<Result, String> zugId           = new TableColumn<>("#Id");
        TableColumn<Result, String> uhrzeit         = new TableColumn<>("Uhrzeit");
        TableColumn<Result, String> zugnummer       = new TableColumn<>("Zugnummer");
        TableColumn<Result, String> inRichtung      = new TableColumn<>("in Richtung");
		TableColumn<Result,String> ueber			= new TableColumn<>("Über");
		 TableColumn<Result, String> gleis           = new TableColumn<>("Gleis");

		activTableCell.setCellValueFactory(cell -> cell.getValue().aktivProperty());
        zugId.setCellValueFactory(cell -> cell.getValue().idProperty().asString());
        uhrzeit.setCellValueFactory(cell -> cell.getValue().uhrZeitProperty());
        zugnummer.setCellValueFactory(cell -> cell.getValue().zugNummerProperty());
		inRichtung.setCellValueFactory(cell -> cell.getValue().inRichtungProperty());
		ueber.setCellValueFactory(cell -> cell.getValue().ueberProperty());
		gleis.setCellValueFactory(cell -> cell.getValue().gleisProperty());

		activTableCell.setCellFactory(param -> new ActivTableCell());

        tableView.getColumns().addAll(activTableCell,zugId, zugnummer,uhrzeit,gleis);

        return tableView;
    }


	private void layoutControls() {
        gPane.add(abfahrt,0,0);
        gPane.add(nach,0,1);
        gPane.add(zugnummer,0,2);
        gPane.add(gleis,0,3);
        gPane.add(zwischenhalt,0,4);
        gPane.add(abfahrtTextfield,1,0);
        gPane.add(nachTextfield,1,1);
        gPane.add(zugnummerTextfield,1,2);
        gPane.add(gleisTextfield,1,3);
        gPane.add(zwischenhaltArea,1,4);
		splitPane1.getItems().addAll(elements, gPane);
		setCenter(splitPane1);
		setTop(hBox);
		hBox.getChildren().addAll(saveButton,addButton,deleteButton,ctrZbutton,ctrVbutton,showDepartureBoardButton,uploadButton,pauseButton,playButton,searchField);
		gPane.setId("gPane");
		zwischenhaltArea.setId("zwischenhaltArea");
		searchField.setId("search");
		gPane.setValignment(zwischenhalt,VPos.TOP );
		gPane.setValignment(gleis,VPos.TOP );
		gPane.setValignment(zugnummer,VPos.TOP );
		gPane.setValignment(nach,VPos.TOP );
		gPane.setValignment(abfahrt,VPos.TOP );
		gPane.setHalignment(zwischenhaltArea,HPos.RIGHT );
		gPane.setHalignment(gleisTextfield,HPos.RIGHT );
		gPane.setHalignment(zugnummerTextfield,HPos.RIGHT);
		gPane.setHalignment(nachTextfield,HPos.RIGHT );
		gPane.setHalignment(abfahrtTextfield,HPos.RIGHT );
        gPane.add(customControl,3,0,6,6);
        ColumnConstraints cc = new ColumnConstraints();
        cc.setHgrow(Priority.ALWAYS);

        gPane.getColumnConstraints().addAll(new ColumnConstraints(),cc,cc);


	}

	private void addEventHandlers() {
		saveButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				pM.save();
			}
			});
		addButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
                Validator v;
                String abfahrt = abfahrtTextfield.getText();
                String zwischenhalt = zwischenhaltArea.getText();
                String gleis = gleisTextfield.getText();
                String zugnummer = zugnummerTextfield.getText();
                String nach = nachTextfield.getText();
                String a[] = {abfahrt, zugnummer, nach, zwischenhalt, gleis};
                pM.addAutoScroll(elements);
                pM.newDepart(a);
                //pM.validation(a);

            }
        });

		deleteButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				pM.showAlert();

			}
		});

		ctrZbutton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				pM.undo();
			}
		});
		ctrVbutton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				pM.redo();
			}
		});

	}


	private void addValueChangedListeners() {

		elements.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
		pM.setSelectedResultId(Integer.valueOf(newValue.getId())));
	}


	private void addBindings() {

		abfahrtTextfield.textProperty().bindBidirectional(pM.getResultProxy().uhrZeitProperty());
		nachTextfield.textProperty().bindBidirectional(pM.getResultProxy().inRichtungProperty());
		zugnummerTextfield.textProperty().bindBidirectional(pM.getResultProxy().zugNummerProperty());
		gleisTextfield.textProperty().bindBidirectional(pM.getResultProxy().gleisProperty());
		zwischenhaltArea.textProperty().bindBidirectional(pM.getResultProxy().ueberProperty());
        abfahrtTextfield.textProperty().bindBidirectional(customControl.textProperty());

    ctrZbutton.textProperty().bind(pM.ctrZProperty());

	}
}
