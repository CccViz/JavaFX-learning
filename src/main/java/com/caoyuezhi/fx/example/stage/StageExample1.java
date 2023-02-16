package com.caoyuezhi.fx.example.stage;

import javafx.scene.image.Image;
import javafx.stage.Stage;

public class StageExample1 {

    public static String stageTitle = "JavaFX";




    public static Stage stageInit(Stage stage) {
        stage.setWidth(800);
        stage.setHeight(450);
        //stage.setResizable(false);       // 窗口拉伸
        stage.show();
        stage.setOpacity(0.99); // 设置透明度 0~1
        //stage.setIconified(true); // 窗口最小化
        //stage.setMaximized(true);  // 窗口最大化
        //stage.setFullScreen(true); // 设置全屏
        //stage.setAlwaysOnTop(true);    // 窗口置顶

        stage.setTitle(stageTitle);
        stage.getIcons().add(new Image("/icon/icon.png"));
        return stage;
    }
}
