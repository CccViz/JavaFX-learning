package com.caoyuezhi.fx.demo.platform;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class PlatformApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        String threadName = Thread.currentThread().getName();
        System.out.println("Platform runLater before ..." + threadName);


        Platform.runLater(() -> {
            String tName = Thread.currentThread().getName();
            System.out.println("Platform runLater: " + tName);
        });


        System.out.println("Platform runLater after ..." + threadName);


        Platform.setImplicitExit(false);



        primaryStage.show();


    }
}
