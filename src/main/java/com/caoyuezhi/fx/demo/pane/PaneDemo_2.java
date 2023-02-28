package com.caoyuezhi.fx.demo.pane;

import com.caoyuezhi.fx.common.css.RegionCssContanst;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.util.ArrayList;

public class PaneDemo_2 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = new AnchorPane();
        root.setStyle(RegionCssContanst.BACKGROUND_COLOR.setValue("#66ccff").toStr());


        Button button = new Button("button");
        button.setOnAction(event -> show());
        AnchorPane.setTopAnchor(button, 100.);
        AnchorPane.setBottomAnchor(button, 100.);
        AnchorPane.setLeftAnchor(button, 100.);
        AnchorPane.setRightAnchor(button, 100.);


        root.getChildren().addAll(button);
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX");
        primaryStage.getIcons().add(new Image("/icon/icon.png"));
        primaryStage.show();
    }

    public void show() {
        AnchorPane root = new AnchorPane();
        root.setStyle(RegionCssContanst.BACKGROUND_COLOR.setValue("#66ccff").toStr());

        HBox hBox = new HBox();
//        hBox.setPadding(new Insets(10.));
        hBox.setSpacing(5.);
        hBox.setPadding(new Insets(30, 20, -1, 20));
        hBox.setStyle(
                RegionCssContanst.BACKGROUND_COLOR.setValue("#c0c0c0").toStr()
                        + RegionCssContanst.BORDER_WIDTH.setValue("1").toStr()
                        + RegionCssContanst.BORDER_COLOR.setValue("black").toStr()
        );
        AnchorPane.setLeftAnchor(hBox, 0.);
        AnchorPane.setRightAnchor(hBox, 0.);
        AnchorPane.setTopAnchor(hBox, 0.);
        AnchorPane.setBottomAnchor(hBox, 150.);

        ArrayList<Button> buttons = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Button button = new Button("Btn-" + i);
            button.setPrefWidth(60.);
            button.setPrefHeight(200.);
            buttons.add(button);

            if (i % 2 != 0){
                HBox.setMargin(button, new Insets(100, 5, -1, 5));
                button.setOpacity(0.5);
            }
        }
        hBox.getChildren().addAll(buttons);



        VBox vBox = new VBox();
        vBox.setMinHeight(100.);
        vBox.setStyle(
                RegionCssContanst.BACKGROUND_COLOR.setValue("#c0c0c0").toStr()
                        + RegionCssContanst.BORDER_WIDTH.setValue("1").toStr()
                        + RegionCssContanst.BORDER_COLOR.setValue("black").toStr()
        );
        AnchorPane.setLeftAnchor(vBox, 0.);
        AnchorPane.setRightAnchor(vBox, 0.);
        AnchorPane.setBottomAnchor(vBox, 0.);


        root.setPadding(new Insets(5.));
        root.getChildren().addAll(hBox, vBox);
        Scene scene = new Scene(root, 800, 600);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("JavaFX");
        stage.getIcons().add(new Image("/icon/icon.png"));
        stage.show();
    }
}
