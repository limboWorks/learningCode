package ch.fhnw.oop2.BuildingApp.Views;

public interface ViewMixin {
    default void init() {
        initializeControls();
        layoutControls();
        addEventHandlers();
        addValueChangedListeners();
        addBindings();

    }

    void initializeControls();

    void layoutControls();

    default void addEventHandlers() {

    }
    default void addValueChangedListeners() {

    }

    default void addBindings() {

    }

}
