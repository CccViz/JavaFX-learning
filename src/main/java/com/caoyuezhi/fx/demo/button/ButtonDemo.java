package com.caoyuezhi.fx.demo.button;

import com.caoyuezhi.fx.example.stage.StageExample1;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ButtonDemo extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage = StageExample1.stageInit(primaryStage);

        Group group = new Group();

        Scene scene = new Scene(group);
        primaryStage.setScene(scene);

        Button button1 = button1();
        group.getChildren().add(button1);

        Button button2 = button2();
        button2.setLayoutX(100);
        button2.setLayoutY(500);
        group.getChildren().add(button2);

        primaryStage.show();
    }


    public static Button button1() {
        Button button = new Button();

        button.setText("按钮-1");
        button.setPrefWidth(300);
        button.setPrefHeight(120);

        button.setLayoutX(30);
        button.setLayoutY(40);

        button.setFont(Font.font("幼圆", FontWeight.BLACK, 30));
        button.setTextFill(Paint.valueOf("#aa2116"));

        button.setCursor(Cursor.CLOSED_HAND);


        /* 背景 */
        BackgroundFill backgroundFill = new BackgroundFill(Paint.valueOf("#faa755"), new CornerRadii(20, 5, 20, 5, false), new Insets(15, 10, 20, 10)
//                Insets.EMPTY
        );
        Background background = new Background(backgroundFill);
        button.setBackground(background);
//        button.setBackground(Background.EMPTY);     // 隐藏背景


        /* 边框 */
        BorderStroke borderStroke = new BorderStroke(Paint.valueOf("#4e72b8"),
                // DASHED: 虚线; DOTTED: 点; SOLID: 实线
                BorderStrokeStyle.SOLID, new CornerRadii(20, 5, 20, 5, false), new BorderWidths(2, 4, 2, 4)

        );
        Border border = new Border(borderStroke);
        button.setBorder(border);
//        button.setBorder(Border.EMPTY);     // 隐藏边框

        return button;
    }


    public static Button button2() {
        Button button = new Button();

        button.setText("按钮-2");
        button.setPrefWidth(300);
        button.setPrefHeight(120);

        button.setLayoutX(30);
        button.setLayoutY(40);

        button.setFont(Font.font("幼圆", FontWeight.BLACK, 30));
        button.setTextFill(Paint.valueOf("#aa2116"));

        button.setCursor(Cursor.CLOSED_HAND);

        button.setStyle(
                "-fx-background-color:#7CCD7C;"
                + "-fx-background-radius:10 5 10 5;"
                + "-fx-background-insets:10 5 15 5;"
                + "-fx-text-fill:#5CACEE;"
        );

        return button;
    }
}
