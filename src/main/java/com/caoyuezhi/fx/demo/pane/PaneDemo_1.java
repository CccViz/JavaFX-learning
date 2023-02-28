package com.caoyuezhi.fx.demo.pane;

import com.caoyuezhi.fx.common.css.RegionCssContanst;
import com.caoyuezhi.fx.example.button.ButtonExample1;
import com.caoyuezhi.fx.example.button.MyButton;
import com.caoyuezhi.fx.example.stage.StageExample1;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class PaneDemo_1 extends Application {

    private Stage mainStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        root.setStyle(RegionCssContanst.BACKGROUND_COLOR.setValue("#f0f0f0").toStr());

        Button btn1 = ButtonExample1.simpleButton("AnchorPane");
        root.getChildren().add(btn1);
        MyButton b1 = (MyButton) btn1;
        b1.setFireTask(this::showAnchorPane);

        Button btn2 = ButtonExample1.simpleButton("VBox");
        root.getChildren().add(btn2);
        MyButton b2 = (MyButton) btn2;
        b2.setFireTask(this::showVBox);
        btn2.setLayoutY(50.0 * (root.getChildren().size() - 1));
        btn2.setLayoutX(50.0 * (root.getChildren().size() - 1));

        Button btn3 = ButtonExample1.simpleButton("HBox");
        root.getChildren().add(btn3);
        MyButton b3 = (MyButton) btn3;
        b3.setFireTask(this::showHBox);
        btn3.setLayoutY(50.0 * (root.getChildren().size() - 1));
        btn3.setLayoutX(50.0 * (root.getChildren().size() - 1));


        Stage stage = StageExample1.stageInit(primaryStage);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        mainStage = stage;
        stage.show();

        Button flush = new Button("FLUSH");
        flush.setOnAction(event -> {
            Button source = (Button) event.getSource();
            if (System.currentTimeMillis() % 2 == 0)
                source.setText(source.getText() + "*");
            else
                source.setText("FLUSH");
            System.out.println("style = " + source.getStyle());
        });
        root.getChildren().add(flush);
        flush.setLayoutX(300.);
        flush.setLayoutY(300.);
    }


    public void showAnchorPane() {
        Group root = new Group();
        AnchorPane anchorPane = new AnchorPane();
        root.getChildren().addAll(anchorPane);    // 后添加的元素会盖住旧元素
        anchorPane.setPrefWidth(400);
        anchorPane.setPrefHeight(300);
        anchorPane.setStyle(RegionCssContanst.BACKGROUND_COLOR.setValue("#00aca7").toStr());

        Button b1 = ButtonExample1.simpleButton("Btn-1");

        Button b2 = ButtonExample1.simpleButton("Btn-2");
        AnchorPane.setLeftAnchor(b2, b1.getPrefWidth() - 20);
        AnchorPane.setTopAnchor(b2, b1.getPrefHeight() - 20);

        // todo ???需要拉伸窗口才显示
        Button b3 = ButtonExample1.simpleButton("Btn-3");
        AnchorPane.setLeftAnchor(b3, 0.0);
//        AnchorPane.setTopAnchor(b3, 0.);
        AnchorPane.setRightAnchor(b3, 0.0);
        AnchorPane.setBottomAnchor(b3, 0.0);


        Stage stage = StageExample1.stageInit(new Stage());
        anchorPane.getChildren().addAll(b3, b1, b2);    // 后添加的元素会盖住旧元素
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("AnchorPane");
        stage.show();
    }

    public void showVBox() {
        Group root = new Group();
        VBox vBox = new VBox();
        root.getChildren().addAll(vBox);
        vBox.setPrefHeight(500.);

        ArrayList<Button> buttons = new ArrayList<>(16);
        for (int i = 0; i < 5; i++) {
            Button button = ButtonExample1.simpleButton("Btn_" + i);
            buttons.add(button);
        }
        vBox.getChildren().addAll(buttons);


        Stage stage = StageExample1.stageInit(new Stage());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("AnchorPane");
        stage.show();
    }


    public void showHBox() {
        AnchorPane root = new AnchorPane();
        HBox hBox = new HBox();
        root.getChildren().addAll(hBox);
//        hBox.setPrefWidth(500.);
//        hBox.setPrefHeight(300.);
        AnchorPane.setTopAnchor(hBox, 0.);
        AnchorPane.setBottomAnchor(hBox, 0.);

        hBox.setStyle(
                RegionCssContanst.BACKGROUND_COLOR.setValue("#009ce6").toStr()
                        + RegionCssContanst.BORDER_WIDTH.setValue("2").toStr()
                        + RegionCssContanst.BORDER_COLOR.setValue("black").toStr()
        );

        ArrayList<Button> buttons = new ArrayList<>(16);
        for (int i = 0; i < 5; i++) {
            Button button = ButtonExample1.simpleButton("Btn_" + i);
            buttons.add(button);
        }
        hBox.getChildren().addAll(buttons);
        hBox.setPadding(new Insets(10, 20, 10, 1));     // padding 内边距：区域内容与区域边框的距离
        hBox.setSpacing(10);
        HBox.setMargin(buttons.get(1), new Insets(50));
        hBox.setAlignment(Pos.CENTER);  // 对齐：居中对齐


        Stage stage = StageExample1.stageInit(new Stage());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("AnchorPane");
        stage.show();
    }


}
