package ch.fhnw.oop2.BuildingApp.Views;

import javafx.scene.layout.BorderPane;

public class BorderPaneCenterUI extends BorderPane implements ViewMixin {

    SplitPaneUI splitPane;
    NavigationTop top;


    @Override
    public void initializeControls() {

        splitPane = new SplitPaneUI();
        top = new NavigationTop();

    }

    @Override
    public void layoutControls() {

        setTop(top);
        setCenter(splitPane);

    }

}
