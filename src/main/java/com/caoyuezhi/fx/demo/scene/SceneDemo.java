package com.caoyuezhi.fx.demo.scene;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;

public class SceneDemo extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group group = new Group();

        Scene scene = new Scene(group);
        primaryStage.setScene(scene);


        Button button = new Button("按钮");
        group.getChildren().add(button);
        button.setPrefHeight(300);
        button.setPrefWidth(400);

        button.setCursor(Cursor.CLOSED_HAND);   // 设置鼠标(悬浮)样式
        URL url = getClass().getClassLoader().getResource("icon/icon.png");
        button.setCursor(Cursor.cursor(url.toExternalForm())); //自定义鼠标样式


        primaryStage.setHeight(1080);
        primaryStage.setWidth(1920);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
