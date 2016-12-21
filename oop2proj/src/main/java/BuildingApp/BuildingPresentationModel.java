package BuildingApp;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;


public class BuildingPresentationModel {

	//init values
	private static final String FILE_NAME = "/buildings.csv";
	private static final String SEPARATOR = ";";
	private final StringProperty applicationTitle = new SimpleStringProperty("buildings.csv");
	private final ObservableList<BuildingClass> results = FXCollections.observableArrayList();
	private final FilteredList<BuildingClass> filteredList = new FilteredList<> (results, results -> true);

	//constructor
	public BuildingPresentationModel() {
		results.addAll(readFromFile());
	}

	//reading buildings.csv
	private List<BuildingClass> readFromFile() {
		try (Stream<String> stream = getStreamOfLines(FILE_NAME, true)) {
			return stream.skip(1)
			             .map(s -> new BuildingClass(s.split(SEPARATOR)))
			             .collect(Collectors.toList());
		}
	}


	private Stream<String> getStreamOfLines(String fileName, boolean locatedInSameFolder) {
		try {
			return Files.lines(getPath(fileName, locatedInSameFolder), StandardCharsets.UTF_8);
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}

	private Path getPath(String fileName, boolean locatedInSameFolder)  {
		try {
			if(!locatedInSameFolder) {
				fileName = "/" + fileName;
			}
			return Paths.get(getClass().getResource(fileName).toURI());
		} catch (URISyntaxException e) {
			throw new IllegalArgumentException(e);
		}
	}

	//getters and setters
	public String getApplicationTitle() {
		return applicationTitle.get();
	}
	public StringProperty applicationTitleProperty() {
		return applicationTitle;
	}
	public ObservableList<BuildingClass> getResults() {
		return results;
	}
	public FilteredList<BuildingClass> getFilteredList() {
		return filteredList;
	}

}
