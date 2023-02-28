package com.caoyuezhi.fx.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChatGPTDemo_2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // 创建标签
        Label label = new Label("Hello, JavaFX!");

        // 创建按钮
        Button button = new Button("Click me!");
        button.setOnAction(e -> label.setText("Button clicked!"));

        // 创建一个垂直布局，将标签和按钮添加到布局中
        VBox root = new VBox();
        root.getChildren().add(label);
        root.getChildren().add(button);

        // 创建场景并将布局添加到场景中
        Scene scene = new Scene(root, 300, 250);

        // 将场景设置为舞台的场景，并显示舞台
        primaryStage.setScene(scene);
        primaryStage.setTitle("My JavaFX App");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
