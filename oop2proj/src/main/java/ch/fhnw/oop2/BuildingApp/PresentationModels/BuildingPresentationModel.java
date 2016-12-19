package ch.fhnw.oop2.BuildingApp.PresentationModels;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ch.fhnw.oop2.BuildingApp.Classes.BuildingClass;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Dieter Holz
 */
public class BuildingPresentationModel {
	private static final String FILE_NAME = "buildings.csv";

	private static final String SEPARATOR = ";";

	private final StringProperty applicationTitle = new SimpleStringProperty("Nationalratswahlen 2007");

	private final ObservableList<BuildingClass> resulate = FXCollections.observableArrayList();

	public BuildingPresentationModel() {
		resulate.addAll(readFromFile());
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
			return stream.skip(1)                              // erste Zeile ist die Headerzeile; ueberspringen
			             .map(s -> new BuildingClass(s.split(SEPARATOR))) // aus jeder Zeile ein Objekt machen
			             .collect(Collectors.toList());        // alles aufsammeln
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

	public ObservableList<BuildingClass> getResulate() {
		return resulate;
	}

}
