package com.caoyuezhi.fx.demo;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author lenovonel
 */
public class DemoApplication extends Application {
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("(HH:mm:ss.SSS)"); //yyyy-MM-dd HH:mm:ss.SSS

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        print("DemoApplication.start()...");

        stage.setTitle("Title demo1");
        stage.getIcons().add(new Image("/icon/icon.png"));
        stage.setIconified(false); // 窗口最小化
        stage.setMaximized(false);  // 窗口最大化

        stage.setHeight(600);
        stage.setWidth(800);
        stage.setResizable(true);  // 窗口拉伸
        stage.setMinHeight(300);
        stage.setMinWidth(400);

        ReadOnlyDoubleProperty heightProperty = stage.heightProperty();
        heightProperty.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                print("当前窗口高度：" + newValue);
            }
        });
        stage.widthProperty().addListener((observable, oldValue, newValue) -> {
            print("当前窗口宽度：" + newValue);
        });

        stage.setScene(new Scene(new Group()));
        stage.setFullScreen(false); // 设置全屏

        stage.setOpacity(0.9); // 设置透明度 0~1
        stage.setAlwaysOnTop(false);    // 窗口置顶


        stage.show();
        // stage.close();  // 关闭窗口
    }

    @Override
    public void init() throws Exception {
        print("DemoApplication.init()...");
        super.init();

    }

    @Override
    public void stop() throws Exception {
        print("DemoApplication.stop()...");
        super.stop();
    }


    public static void print(String message) {
        String builder = datetime() + " " + threadInfo() + " : " + message;
        System.out.println(builder);
    }

    public static String datetime() {
        return LocalDateTime.now().format(dateTimeFormatter);
    }

    public static String threadInfo() {
        Thread thread = Thread.currentThread();
        return "<" + thread.getThreadGroup().getName() + " -> " + thread.getName() + ">";
    }

}
