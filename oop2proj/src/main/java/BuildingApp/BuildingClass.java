package BuildingApp;

import javafx.beans.property.*;

import java.util.Objects;

public class BuildingClass {
    /*
         toDo:
    */

    private final IntegerProperty buildingID = new SimpleIntegerProperty();
    private final IntegerProperty buildingRank = new SimpleIntegerProperty();
    private final StringProperty buildingName = new SimpleStringProperty();
    private final StringProperty cityName = new SimpleStringProperty();
    private final StringProperty countryName = new SimpleStringProperty();
    private final DoubleProperty buildingHeightMeter = new SimpleDoubleProperty();
    private final DoubleProperty buildingHeightFeet = new SimpleDoubleProperty();
    private final IntegerProperty buildingFloors = new SimpleIntegerProperty();
    private final IntegerProperty buildingBuild = new SimpleIntegerProperty();
    private final StringProperty buildingArchitect = new SimpleStringProperty();
    private final StringProperty buildingArchitectutalStyle = new SimpleStringProperty();
    private final DoubleProperty buildingCost = new SimpleDoubleProperty();
    private final StringProperty buildingMaterial = new SimpleStringProperty();
    private final DoubleProperty buildingLongitude = new SimpleDoubleProperty();
    private final DoubleProperty buildingLatitude = new SimpleDoubleProperty();
    private final StringProperty buildingImageURL = new SimpleStringProperty();


    public BuildingClass() {

    }

    public BuildingClass(String[] buildingsLine) {
        setBuildingID(Integer.valueOf(buildingsLine[0]));
        setBuildingRank(Integer.valueOf(buildingsLine[1]));
        setBuildingName(buildingsLine[2]);
        setCityName(buildingsLine[3]);
        setCountryName(buildingsLine[4]);
        setBuildingHeightMeter(Double.valueOf(buildingsLine[5]));
        setBuildingHeightFeet(Double.valueOf(buildingsLine[6]));
        setBuildingFloors(Integer.valueOf(buildingsLine[7]));
        setBuildingBuild(Integer.valueOf(buildingsLine[8]));
        if (buildingsLine[9].equals("")) {
            setBuildingArchitect("");
        } else {
            setBuildingArchitect(buildingsLine[9]);
        }

        if (buildingsLine[10].equals("")) {
            setBuildingArchitectutalStyle("");
        } else {
            setBuildingArchitectutalStyle(buildingsLine[10]);
        }
        setBuildingCost(Double.valueOf(buildingsLine[11]));
        setBuildingMaterial(buildingsLine[12]);
        setBuildingLongitude(Double.valueOf(buildingsLine[13]));
        setBuildingLatitude(Double.valueOf(buildingsLine[14]));
        setBuildingImageURL(buildingsLine[15]);
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

        return Objects.equals(getBuildingID(), building.getBuildingID());
    }

    @Override
    public int hashCode() {
        return buildingID.hashCode();
    }

    public String infoAsLine() {
        return String.join("\t",
                Integer.toString(getBuildingID()),
                Integer.toString(getBuildingRank()),
                getBuildingName(),
                getCityName(),
                getCountryName(),
                Double.toString(getBuildingHeightMeter()),
                Double.toString(getBuildingHeightFeet()),
                Integer.toString(getBuildingFloors()),
                Integer.toString(getBuildingBuild()),
                getBuildingArchitect(),
                getBuildingArchitectutalStyle(),
                Double.toString(getBuildingCost()),
                getBuildingMaterial(),
                Double.toString(getBuildingLongitude()),
                Double.toString(getBuildingLatitude()),
                getBuildingImageURL()
        );


    }

    public int getBuildingID() {
        return buildingID.get();
    }

    public IntegerProperty buildingIDProperty() {
        return buildingID;
    }

    public void setBuildingID(int buildingID) {
        this.buildingID.set(buildingID);
    }

    public int getBuildingRank() {
        return buildingRank.get();
    }

    public IntegerProperty buildingRankProperty() {
        return buildingRank;
    }

    public void setBuildingRank(int buildingRank) {
        this.buildingRank.set(buildingRank);
    }

    public String getBuildingName() {
        return buildingName.get();
    }

    public StringProperty buildingNameProperty() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName.set(buildingName);
    }

    public String getCityName() {
        return cityName.get();
    }

    public StringProperty cityNameProperty() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName.set(cityName);
    }

    public String getCountryName() {
        return countryName.get();
    }

    public StringProperty countryNameProperty() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName.set(countryName);
    }

    public double getBuildingHeightMeter() {
        return buildingHeightMeter.get();
    }

    public DoubleProperty buildingHeightMeterProperty() {
        return buildingHeightMeter;
    }

    public void setBuildingHeightMeter(double buildingHeightMeter) {
        this.buildingHeightMeter.set(buildingHeightMeter);
    }

    public double getBuildingHeightFeet() {
        return buildingHeightFeet.get();
    }

    public DoubleProperty buildingHeightFeetProperty() {
        return buildingHeightFeet;
    }

    public void setBuildingHeightFeet(double buildingHeightFeet) {
        this.buildingHeightFeet.set(buildingHeightFeet);
    }

    public int getBuildingFloors() {
        return buildingFloors.get();
    }

    public IntegerProperty buildingFloorsProperty() {
        return buildingFloors;
    }

    public void setBuildingFloors(int buildingFloors) {
        this.buildingFloors.set(buildingFloors);
    }

    public int getBuildingBuild() {
        return buildingBuild.get();
    }

    public IntegerProperty buildingBuildProperty() {
        return buildingBuild;
    }

    public void setBuildingBuild(int buildingBuild) {
        this.buildingBuild.set(buildingBuild);
    }

    public String getBuildingArchitect() {
        return buildingArchitect.get();
    }

    public StringProperty buildingArchitectProperty() {
        return buildingArchitect;
    }

    public void setBuildingArchitect(String buildingArchitect) {
        this.buildingArchitect.set(buildingArchitect);
    }

    public String getBuildingArchitectutalStyle() {
        return buildingArchitectutalStyle.get();
    }

    public StringProperty buildingArchitectutalStyleProperty() {
        return buildingArchitectutalStyle;
    }

    public void setBuildingArchitectutalStyle(String buildingArchitectutalStyle) {
        this.buildingArchitectutalStyle.set(buildingArchitectutalStyle);
    }

    public double getBuildingCost() {
        return buildingCost.get();
    }

    public DoubleProperty buildingCostProperty() {
        return buildingCost;
    }

    public void setBuildingCost(double buildingCost) {
        this.buildingCost.set(buildingCost);
    }

    public String getBuildingMaterial() {
        return buildingMaterial.get();
    }

    public StringProperty buildingMaterialProperty() {
        return buildingMaterial;
    }

    public void setBuildingMaterial(String buildingMaterial) {
        this.buildingMaterial.set(buildingMaterial);
    }

    public double getBuildingLongitude() {
        return buildingLongitude.get();
    }

    public DoubleProperty buildingLongitudeProperty() {
        return buildingLongitude;
    }

    public void setBuildingLongitude(double buildingLongitude) {
        this.buildingLongitude.set(buildingLongitude);
    }

    public double getBuildingLatitude() {
        return buildingLatitude.get();
    }

    public DoubleProperty buildingLatitudeProperty() {
        return buildingLatitude;
    }

    public void setBuildingLatitude(double buildingLatitude) {
        this.buildingLatitude.set(buildingLatitude);
    }

    public String getBuildingImageURL() {
        return buildingImageURL.get();
    }

    public StringProperty buildingImageURLProperty() {
        return buildingImageURL;
    }

    public void setBuildingImageURL(String buildingImageURL) {
        this.buildingImageURL.set(buildingImageURL);
    }
}