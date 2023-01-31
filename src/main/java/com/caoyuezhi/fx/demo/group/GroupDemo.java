package com.caoyuezhi.fx.demo.group;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GroupDemo extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Group group = new Group();

        Scene scene = new Scene(group);
        primaryStage.setScene(scene);



        Button b3 = new Button("b3");
        group.getChildren().add(b3);
        b3.setPrefWidth(300);
        b3.setPrefHeight(150);

        Button b2 = new Button("b2");
        group.getChildren().add(b2);
        b2.setPrefWidth(100);
        b2.setPrefHeight(100);

        Button b1 = new Button("b1");
        group.getChildren().add(b1);
        System.out.println(b1.getWidth() +  "  " +b1.getHeight());
        b1.setPrefWidth(100);
        b1.setPrefHeight(40);




        b2.setLayoutX(500);
        b2.setLayoutY(50);

        b3.setLayoutX(50);
        b3.setLayoutY(50);

        b1.setLayoutX(b3.getLayoutX() + b3.getPrefWidth());
        b1.setLayoutY(b3.getLayoutY() + b3.getPrefHeight());


        primaryStage.setWidth(1600);
        primaryStage.setHeight(900);
        primaryStage.setTitle("JavaFX");
        primaryStage.show();
    }
}
