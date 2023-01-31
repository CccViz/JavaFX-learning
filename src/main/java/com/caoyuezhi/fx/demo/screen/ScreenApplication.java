package com.caoyuezhi.fx.demo.screen;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ScreenApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.show();

        ObservableList<Screen> screens = Screen.getScreens();

        Screen primary = Screen.getPrimary();

        Rectangle2D bounds = primary.getBounds();
        System.out.println("bounds = " + bounds);

        Rectangle2D visualBounds = primary.getVisualBounds();
        System.out.println("visualBounds = " + visualBounds);

        double dpi = primary.getDpi();
        System.out.println("dpi = " + dpi);

        double x = primary.getOutputScaleX();
        System.out.println("x = " + x);

        double y = primary.getOutputScaleY();
        System.out.println("y = " + y);

//        Platform.exit();
    }
}
