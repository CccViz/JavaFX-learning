package com.caoyuezhi.fx.demo.pane;

import com.caoyuezhi.fx.common.css.RegionCssContanst;
import com.caoyuezhi.fx.example.button.ButtonExample1;
import com.caoyuezhi.fx.example.button.MyButton;
import com.caoyuezhi.fx.example.stage.StageExample1;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class PaneDemo_1 extends Application {

    private Stage mainStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = new AnchorPane();
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

        Button btn4 = ButtonExample1.simpleButton("FlowPane");
        root.getChildren().add(btn4);
        MyButton b4 = (MyButton) btn4;
        b4.setFireTask(this::showFlowPane);
        btn4.setLayoutY(50.0 * (root.getChildren().size() - 1));
        btn4.setLayoutX(50.0 * (root.getChildren().size() - 1));

        Button btn5 = ButtonExample1.simpleButton("GridPane");
        root.getChildren().add(btn5);
        MyButton b5 = (MyButton) btn5;
        b5.setFireTask(this::showGridPane);
        btn5.setLayoutY(50.0 * (root.getChildren().size() - 1));
        btn5.setLayoutX(50.0 * (root.getChildren().size() - 1));

        Button btn6 = ButtonExample1.simpleButton("TilePane");
        root.getChildren().add(btn6);
        MyButton b6 = (MyButton) btn6;
        b6.setFireTask(this::showTilePane);
        btn6.setLayoutY(50.0 * (root.getChildren().size() - 1));
        btn6.setLayoutX(50.0 * (root.getChildren().size() - 1));


        /*Stage stage = StageExample1.stageInit(primaryStage);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        mainStage = stage;
        stage.show();*/

        Scene scene = new Scene(root, 800, 450);
        Stage stage = primaryStage;
        stage.setScene(scene);
        stage.setTitle("JavaFX");
        stage.getIcons().add(new Image("/icon/icon.png"));
        stage.show();
        mainStage = stage;

        Button flush = new Button("FLUSH");
        flush.setPrefWidth(120);
        flush.setPrefHeight(50);
        flush.setOnAction(event -> {
            Button source = (Button) event.getSource();
            if (System.currentTimeMillis() % 2 == 0)
                source.setText(source.getText() + "*");
            else
                source.setText("FLUSH");
            System.out.printf("%s  %s  %s\n", source.getText(), root.getWidth(), root.getHeight());

            source.setLayoutX(root.getWidth() - source.getWidth());
            source.setLayoutY(root.getHeight() - source.getHeight());
        });
        root.getChildren().add(flush);
        AnchorPane.setBottomAnchor(flush, 0.);
        AnchorPane.setRightAnchor(flush, 0.);
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
        AnchorPane root = new AnchorPane();
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
        stage.setTitle("VBox");
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
                RegionCssContanst.BACKGROUND_COLOR.setValue("#66ccff").toStr()
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
        stage.setTitle("HBox");
        stage.show();
    }


    public void showFlowPane() {
        AnchorPane root = new AnchorPane();
        FlowPane flowPane = new FlowPane();
        root.getChildren().addAll(flowPane);
        AnchorPane.setLeftAnchor(flowPane, 0.);
        AnchorPane.setRightAnchor(flowPane, 0.);
        flowPane.setStyle(
                RegionCssContanst.BACKGROUND_COLOR.setValue("#66ccff").toStr()
                        + RegionCssContanst.BORDER_WIDTH.setValue("2").toStr()
                        + RegionCssContanst.BORDER_COLOR.setValue("black").toStr()
        );

        ArrayList<Button> buttons = new ArrayList<>(16);
        for (int i = 0; i < 11; i++) {
//            Button button = ButtonExample1.simpleButton("Btn_" + i);
            Button button = new Button("Btn_" + i);
            button.setMinWidth(150);
            buttons.add(button);
        }
        flowPane.getChildren().addAll(buttons);

        flowPane.setAlignment(Pos.CENTER);
        flowPane.setHgap(5);    // 水平间距
        flowPane.setVgap(5);    // 垂直间距
        flowPane.setOrientation(Orientation.VERTICAL);      // 排列方式：HORIZONTAL 水平、VERTICAL 垂直
        flowPane.setPadding(new Insets(10));
        flowPane.setMargin(buttons.get(3), new Insets(10));

        Stage stage = StageExample1.stageInit(new Stage());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("FlowPane");
        stage.show();
    }


    public void showGridPane() {
        AnchorPane root = new AnchorPane();
        /*
        Tab切换子节点的顺序与添加顺序有关
        */
        GridPane gridPane = new GridPane();
        root.getChildren().addAll(gridPane);
        AnchorPane.setLeftAnchor(gridPane, 0.);
        AnchorPane.setRightAnchor(gridPane, 0.);
        gridPane.setStyle(
                RegionCssContanst.BACKGROUND_COLOR.setValue("#66ccff").toStr()
                        + RegionCssContanst.BORDER_WIDTH.setValue("2").toStr()
                        + RegionCssContanst.BORDER_COLOR.setValue("black").toStr()
        );

        /*ArrayList<Button> buttons = new ArrayList<>(16);
        for (int i = 0; i < 9; i++) {
//            Button button = ButtonExample1.simpleButton("Btn_" + i);
            Button button = new Button("button_" + i);
            button.setMinWidth(120);
            buttons.add(button);
        }*/
        Button b1 = new Button("button_1");
        Button b2 = new Button("button_2");
        Button b3 = new Button("button_3");
        Button b4 = new Button("button_4");
        Button b5 = new Button("button_5");
        Button b6 = new Button("button_6");
        Button b7 = new Button("button_7");
        Button b8 = new Button("button_8");
        Button b9 = new Button("button_9");

//        gridPane.getChildren().addAll(b1,b2,b3,b4,b5);

        //方式二
        GridPane.setConstraints(b8, 1, 1);
        gridPane.getChildren().addAll(b8);

        //方式四
        gridPane.addColumn(1, b1, b2, b3);
        gridPane.addRow(1, b4, b5, b6);

        // 方式一
        gridPane.add(b7, 0, 0);

        //方式三
        GridPane.setRowIndex(b9, 2);
        GridPane.setColumnIndex(b9, 2);
        gridPane.getChildren().addAll(b9);


        gridPane.setAlignment(Pos.CENTER_LEFT);
        gridPane.setHgap(10);    // 水平间距
        gridPane.setVgap(5);    // 垂直间距
//        gridPane.setPadding(new Insets(10));

        // todo 单独设置各行各列的间距

        Stage stage = StageExample1.stageInit(new Stage());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("GridPane");
        stage.show();
    }


    public void showTilePane() {
        AnchorPane root = new AnchorPane();
        TilePane tilePane = new TilePane();
        root.getChildren().addAll(tilePane);
        AnchorPane.setLeftAnchor(tilePane, 0.);
        AnchorPane.setRightAnchor(tilePane, 0.);
        tilePane.setStyle(
                RegionCssContanst.BACKGROUND_COLOR.setValue("#66ccff").toStr()
                        + RegionCssContanst.BORDER_WIDTH.setValue("2").toStr()
                        + RegionCssContanst.BORDER_COLOR.setValue("black").toStr()
        );

        Button b1 = new Button("button_1");
        Button b2 = new Button("button_2");
        Button b3 = new Button("button_3");
        Button b4 = new Button("button_4");
        Button b5 = new Button("button_5");
        Button b6 = new Button("button_6");
        Button b7 = new Button("button_7");
        Button b8 = new Button("button_8");
        Button b9 = new Button("button_9");

        tilePane.getChildren().addAll(b1, b2, b3, b4, b5, b6, b7, b8, b9);

        Stage stage = StageExample1.stageInit(new Stage());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("TilePane");
        stage.show();
    }
}
