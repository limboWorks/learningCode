package ch.fhnw.oop2.BuildingApp.Classes;

import javafx.beans.property.*;

public class BuildingClass {
    /*
    toDo:

            1. Define Properties
            2. Getter%setter generiere
            3. Apasse

    */

    //IntegerProperties
    private final IntegerProperty buildingID = new SimpleIntegerProperty();
    private final IntegerProperty buildingRank = new SimpleIntegerProperty();
    private final IntegerProperty buildingFloors = new SimpleIntegerProperty();

    //StringProperties
    private final StringProperty buildingName = new SimpleStringProperty();
    private final StringProperty cityName = new SimpleStringProperty();
    private final StringProperty countryName = new SimpleStringProperty();
//    private final StringProperty  = new SimpleStringProperty();
//    private final StringProperty  = new SimpleStringProperty();
//    private final StringProperty  = new SimpleStringProperty();
//    private final StringProperty  = new SimpleStringProperty();

    //    Error:java: javacTask: source release 1.8 requires target release 1.8   //DoubleProperties
    private final DoubleProperty buildingHeight = new SimpleDoubleProperty();
    private final DoubleProperty getBuildingHeightFeet = new SimpleDoubleProperty();


    public BuildingClass(String[] buildingsLine) {
        setBuildingId(Integer.valueOf(buildingsLine[0]));
        setBuildingRank(Integer.valueOf(buildingsLine[1]));
        setBuildingName(buildingsLine[2]);
        setCityName(buildingsLine[3]);
        setCountryName(buildingsLine[4]);
        setBuildingHeightMeter(Double.valueOf(buildingsLine[5]));
        setBuildingHeightFeet(Double.valueOf(buildingsLine[6]));
        setFloorNumber(Integer.valueOf(buildingsLine[7]));
        setBuildingYear(Integer.valueOf(buildingsLine[8]));
        if (buildingsLine[9].equals("")) {
            setArchitectName("");
        } else {
            setArchitectName(buildingsLine[9]);
        }

        if (buildingsLine[10].equals("")) {
            setArchitectualStyle("");
        } else {
            setArchitectualStyle(buildingsLine[10]);
        }
        setCostsAmount(Double.valueOf(buildingsLine[11]));
        setBuildingMaterial(buildingsLine[12]);
        setLongtitude(Double.valueOf(buildingsLine[13]));
        setLatitude(Double.valueOf(buildingsLine[14]));
        setImageUrl(buildingsLine[15]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BuildingClass building = (BuildingClass) o;

        return Objects.equals(getBuildingId(), building.getBuildingId());
    }

    @Override
    public int hashCode() {
        return buildingId.hashCode();
    }

    public String infoAsLine() {


        return String.join("\t",
                Integer.toString(getBuildingId()),
                Integer.toString(getBuildingRank()),
                getBuildingName(),
                getCityName(),
                getCountryName(),
                Double.toString(getBuildingHeightMeter()),
                Double.toString(getBuildingHeightFeet()),
                Integer.toString(getFloorNumber()),
                Integer.toString(getBuildingYear()),
                getArchitectName(),
                getArchitectualStyle(),
                Double.toString(getCostsAmount()),
                getBuildingMaterial(),
                Double.toString(getLongtitude()),
                Double.toString(getLatitude()),
                getImageUrl()
        );


    }

}