package ch.fhnw.oop2.DepartureBoard;

import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class PresentationModel {

    public static final String FILE_NAME = "data/olten.csv";
    private final Result resultProxy = new Result();
    private static final String Semikolon = ";";
	private final StringProperty applicationTitle = new SimpleStringProperty("Departure Board");
    private final IntegerProperty selectedResultId = new SimpleIntegerProperty();
	private final ObservableList<Result> elements = FXCollections.observableArrayList();
    private final StringProperty  ctrZbutton = new SimpleStringProperty("Undo");
    private List<Command> lastCommand; // speichert das letzte Command
    private final ObservableList<Command> undoStack = FXCollections.observableArrayList();
    private final ObservableList<Command> redoStack = FXCollections.observableArrayList();
    private final BooleanProperty undoDisabled = new SimpleBooleanProperty();
    private final BooleanProperty redoDisabled = new SimpleBooleanProperty();

    private final ChangeListener propertyChangeListenerForUndoSupport = (observable, oldValue, newValue) -> {
        redoStack.clear();
        undoStack.add(0, new ValueChangeCommand(PresentationModel.this, (Property) observable, oldValue, newValue));
    };

    public Result getSelectedDeparture() {
        return selectedDeparture.get();

    }
    private ObjectProperty<Result> selectedDeparture = new SimpleObjectProperty<>();

    public Result getNewDeparture(){return newDepartures.get();}
    private ObjectProperty<Result> newDepartures = new SimpleObjectProperty<>();

	public PresentationModel(){
        elements.setAll(readFromTheFile());


        undoDisabled.bind(Bindings.isEmpty(undoStack));
        redoDisabled.bind(Bindings.isEmpty(redoStack));

        selectedResultIdProperty().addListener((observable, oldValue, newValue) -> {
                    Result oldSelection = getResult((int) oldValue);
                     Result newSelection = getResult((int) newValue);

                    if (oldSelection != null) {
                        unbindFromProxy(oldSelection);
                        disableUndoSupport(oldSelection);
                    }

                    if (newSelection != null) {
                        bindToProxy(newSelection);
                        enableUndoSupport(newSelection);
                    }
                }
        );

        setSelectedResultId(0);

        // selection changes are undoable
        selectedResultIdProperty().addListener(propertyChangeListenerForUndoSupport);
    }

    private void disableUndoSupport(Result result) {
        result.idProperty().removeListener(propertyChangeListenerForUndoSupport);
        result.inRichtungProperty().removeListener(propertyChangeListenerForUndoSupport);
        result.uhrZeitProperty().removeListener(propertyChangeListenerForUndoSupport);
        result.gleisProperty().removeListener(propertyChangeListenerForUndoSupport);
        result.ueberProperty().removeListener(propertyChangeListenerForUndoSupport);
        result.zugNummerProperty().removeListener(propertyChangeListenerForUndoSupport);
    }

    private void enableUndoSupport(Result result ) {
        result.idProperty().addListener(propertyChangeListenerForUndoSupport);
        result.inRichtungProperty().addListener(propertyChangeListenerForUndoSupport);
        result.uhrZeitProperty().addListener(propertyChangeListenerForUndoSupport);
        result.gleisProperty().addListener(propertyChangeListenerForUndoSupport);
        result.ueberProperty().addListener(propertyChangeListenerForUndoSupport);
        result.zugNummerProperty().addListener(propertyChangeListenerForUndoSupport);
    }

    private List<Result> readFromTheFile() {
        try (Stream<String> stream = getStreamOfLines(FILE_NAME,true)) {
            return stream.skip(1)                              // erste Zeile ist die Headerzeile; ueberspringen
                    .map(s -> new Result(s.split(Semikolon))) // aus jeder Zeile ein Objekt machen
                    .collect(Collectors.toList());        // alles aufsammeln
        }
    }
    public void undo() {
        if (undoStack.isEmpty()) {
            return;
        }
        Command cmd = undoStack.get(0);
        undoStack.remove(0);
        redoStack.add(0, cmd);

        cmd.undo();
    }

    public void redo() {
        if (redoStack.isEmpty()) {
            return;
        }
        Command cmd = redoStack.get(0);
        redoStack.remove(0);
        undoStack.add(0, cmd);

        cmd.redo();
    }

    private void bindToProxy(Result result) {
        resultProxy.idProperty().bindBidirectional(result.idProperty());
        resultProxy.inRichtungProperty().bindBidirectional(result.inRichtungProperty());
        resultProxy.gleisProperty().bindBidirectional(result.gleisProperty());
        resultProxy.uhrZeitProperty().bindBidirectional(result.uhrZeitProperty());
        resultProxy.ueberProperty().bindBidirectional(result.ueberProperty());
        resultProxy.zugNummerProperty().bindBidirectional(result.zugNummerProperty());
    }

    private void unbindFromProxy(Result result) {
        resultProxy.idProperty().unbindBidirectional(result.idProperty());
        resultProxy.inRichtungProperty().unbindBidirectional(result.inRichtungProperty());
        resultProxy.gleisProperty().unbindBidirectional(result.gleisProperty());
        resultProxy.uhrZeitProperty().unbindBidirectional(result.uhrZeitProperty());
        resultProxy.ueberProperty().unbindBidirectional(result.ueberProperty());
        resultProxy.zugNummerProperty().unbindBidirectional(result.zugNummerProperty());
    }
public boolean newDepart(String[]a){
        Result result;
         result = new Result(a[0], a[1], a[2], a[3], a[4]);
        result.setId(elements.size());
        return elements.add(result);


}
    public Result getResult(int id){
        Optional<Result> optionalResult = getElements().stream()
                .filter(Result -> Integer.valueOf(Result.getId()) == id)
                .findAny();
        return optionalResult.isPresent() ? optionalResult.get() : null;
    }


    public static <S> void addAutoScroll(final TableView<S> view) {
        if (view == null) {
            throw new NullPointerException();
        }

        view.getItems().addListener((ListChangeListener<S>) (c -> {
            c.next();
            final int size = view.getItems().size();
            if (size > 0) {
                view.scrollTo(size - 1);
            }
        }));
    }

    public <T> void setPropertyValueWithoutUndoSupport(Property<T> property, T newValue){
        property.removeListener(propertyChangeListenerForUndoSupport);
        property.setValue(newValue);
        property.addListener(propertyChangeListenerForUndoSupport);
    }


public Alert validation(String[] a){

    Validator v = new Validator(a);
    if(v.checkOrtschaft()&&v.CheckTime()&&v.checkGleis()){
       Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
        return alert;
    }
    Alert alert = new Alert(Alert.AlertType.ERROR);
    return alert;
}


    public Alert showAlert(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        String stylesheet = getClass().getResource("style.css").toExternalForm();
        alert.getDialogPane().getStylesheets().add(stylesheet);

        alert.getDialogPane().getStyleClass().add("myDialog");
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Soll diese Information wirklich gelöscht werden?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
           delete();
        } else {
            alert.close();
        }

        return alert;
    }
public boolean delete(){
    return elements.remove(getResult(getSelectedResultId()));

}
    public void save() {
        try (BufferedWriter writer = Files.newBufferedWriter(getPath(FILE_NAME, true))) {
            writer.write("#id;Uhrzeit;Zugnummer;in Richtung;über;Gleis;");
            writer.newLine();
            elements.stream().forEach(resultat -> {
                try {
                    writer.write(resultat.informationAsLine());
                    writer.newLine();
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                }
            });
        } catch (IOException e) {
            throw new IllegalStateException("save failed");
        }
    }

    private Stream<String> getStreamOfLines(String fileName, boolean locatedInSameFolder) {
        try {
            return Files.lines(getPath(fileName, locatedInSameFolder), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
    private Path getPath(String fileName, boolean locatedInSameFolder) {
        try {
            if (!locatedInSameFolder) {
                fileName = "/" + fileName;
            }
            return Paths.get(getClass().getResource(fileName).toURI());
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }

	public String getApplicationTitle() {
		return applicationTitle.get();
	}
    public String getCtrlZButtonName(){return ctrZbutton.get();}

	public StringProperty applicationTitleProperty() {
		return applicationTitle;
	}
    public StringProperty ctrZProperty(){return ctrZbutton;}

	public void setApplicationTitle(String applicationTitle) {
		this.applicationTitle.set(applicationTitle);
	}

    public void setButtonTitlectrZbutton(String titlectrZbutton){this.ctrZbutton.set(titlectrZbutton);}
    public void setSelectedDeparture(Result selectedDeparture){
        this.selectedDeparture.set(selectedDeparture);
    }
	public ObservableList<Result> getElements() {
		return elements;
	}
    public ObjectProperty<Result> selectedDepartureProperty() {
        return selectedDeparture;
    }

    public void setNewDeparture(Result newDeparture){
        this.newDepartures.set(newDeparture);
    }
    public ObjectProperty<Result> newDepartureProperty() {
        return newDepartures;
    }

    public Result getResultProxy() {
        return resultProxy;
    }

    public int getSelectedResultId() {
        return selectedResultId.get();
    }

    public IntegerProperty selectedResultIdProperty() {
        return selectedResultId;
    }

    public void setSelectedResultId(int selectedResultId) {
        this.selectedResultId.set(selectedResultId);
    }
    public boolean getUndoDisabled() {
        return undoDisabled.get();
    }

    public BooleanProperty undoDisabledProperty() {
        return undoDisabled;
    }

    public void setUndoDisabled(boolean undoDisabled) {
        this.undoDisabled.set(undoDisabled);
    }

    public boolean getRedoDisabled() {
        return redoDisabled.get();
    }

    public BooleanProperty redoDisabledProperty() {
        return redoDisabled;
    }

    public void setRedoDisabled(boolean redoDisabled) {
        this.redoDisabled.set(redoDisabled);
    }
}
