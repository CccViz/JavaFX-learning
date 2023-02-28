package com.caoyuezhi.fx.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ChatGPTDemo_3 extends Application {

    private ImageView imageView;

    @Override
    public void start(Stage primaryStage) {
        // 创建登录表单
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> {
            // 实现登录逻辑
        });

        // 将登录表单添加到网格面板中
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.add(usernameLabel, 0, 0);
        grid.add(usernameField, 1, 0);
        grid.add(passwordLabel, 0, 1);
        grid.add(passwordField, 1, 1);
        grid.add(loginButton, 1, 2);

        // 创建选择图片按钮和预览图片视图
        Button selectImageButton = new Button("Select Background Image");
        selectImageButton.setOnAction(e -> selectImage(primaryStage));
        imageView = new ImageView();
        imageView.setFitWidth(400);
        imageView.setFitHeight(300);

        // 创建一个垂直布局，将选择图片按钮和登录表单添加到布局中
        VBox root = new VBox();
        root.getChildren().add(selectImageButton);
        root.getChildren().add(grid);

        // 使用 StackPane 布局将背景图片和布局组合起来
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView, root);

        // 创建场景并将布局添加到场景中
        Scene scene = new Scene(stackPane, 600, 400);

        // 将场景设置为舞台的场景，并显示舞台
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login");
        primaryStage.show();
    }

    // 实现选择图片功能
    private void selectImage(Stage primaryStage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image");
        File file = fileChooser.showOpenDialog(primaryStage);
        if (file != null) {
            try {
                Image image = new Image(new FileInputStream(file));
                imageView.setImage(image);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
