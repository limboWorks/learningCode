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
	private static final String FILE_NAME = "/buildings.csv";
	private static final String SEPARATOR = ";";

	private final StringProperty applicationTitle = new SimpleStringProperty("buildings.csv");

	private final ObservableList<BuildingClass> resulates = FXCollections.observableArrayList();

	private final FilteredList<BuildingClass> filteredList = new FilteredList<> (resulates, resulate -> true);

	public BuildingPresentationModel() {
		resulates.addAll(readFromFile());
	}

	/*
	public void save() {
		try (BufferedfWriter writer = Files.newBufferedWriter(getPath(FILE_NAME, true))) {
			writer.write("Gemeinde-Nr.\tBFS Gemeinden\tKanton\tFDP\tCVP\tSPS\tSVP\tLPS\tEVP\tCSP\tGLP\tPdA Sol.\tFGA\tGPS\tSD\tEDU\tFPS\tLega\tÜbrige\tWahlberechtigte\tWählende");
			writer.newLine();
			resulate.stream().forEach(resultat -> {
				try {
					writer.write(resultat.infoAsLine());
					writer.newLine();
				} catch (IOException e) {
					throw new IllegalStateException(e);
				}
			});
		} catch (IOException e) {
			throw new IllegalStateException("save failed");
		}
	}
*/
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


	// all getters and setters

	public String getApplicationTitle() {
		return applicationTitle.get();
	}

	public StringProperty applicationTitleProperty() {
		return applicationTitle;
	}

	public ObservableList<BuildingClass> getResulates() {
		return resulates;
	}

	public FilteredList<BuildingClass> getFilteredList() {
		return filteredList;
	}
}
