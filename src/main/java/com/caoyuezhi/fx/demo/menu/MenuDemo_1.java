package com.caoyuezhi.fx.demo.menu;

import com.caoyuezhi.fx.common.css.RegionCssContanst;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class MenuDemo_1 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root, 800, 450);
        scene.setFill(Paint.valueOf("#cccccc"));
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX");
        primaryStage.show();


        Button simpleMenu = new Button("SimpleMenu");
        simpleMenu.setOnAction(event -> showSimpleMenu());


        root.getChildren().addAll(simpleMenu);
    }

    public void showSimpleMenu() {
        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root, 800, 450);
        scene.setFill(Paint.valueOf("#cccccc"));
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Simple Menu");
        stage.show();

        MenuBar menuBar = new MenuBar();
//        menuBar.setStyle(RegionCssContanst.BACKGROUND_COLOR.setValue("#ccffff").toStr());
        menuBar.setPrefWidth(scene.getWidth());
        menuBar.setMinHeight(30);
        menuBar.setPadding(new Insets(10, 20, 5, 20));

        scene.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                menuBar.setPrefWidth(newValue.doubleValue());
            }
        });

        Menu m1 = new Menu("Menu_1");
        Menu m2 = new Menu("Menu_2");
        Menu m3 = new Menu("Menu_3");
        Menu m4 = new Menu("Menu_4");

        menuBar.getMenus().addAll(m1, m2, m3, m4);
        menuBar.getMenus().forEach(m -> {
            m.setStyle(RegionCssContanst.BACKGROUND_COLOR.setValue("#ccffff").toStr());
            m.setOnAction(event -> {
                Menu source = (Menu) event.getSource();
                System.out.println(source.getText());
            });
        });

        root.getChildren().addAll(menuBar);

        MenuItem item_1 = new MenuItem("Item_1");
        MenuItem item_2 = new MenuItem("item_2");
        MenuItem item_3 = new MenuItem("item_3");
        MenuItem item_4 = new MenuItem("item_4");
        MenuItem item_5 = new MenuItem("item_5");
        MenuItem item_6 = new MenuItem("item_6");

        SeparatorMenuItem smi1 = new SeparatorMenuItem();
        SeparatorMenuItem smi2 = new SeparatorMenuItem();
        SeparatorMenuItem smi3 = new SeparatorMenuItem();

        m1.getItems().addAll(item_1, smi1);
        m2.getItems().addAll(item_3, smi2, item_2);
        m3.getItems().addAll(item_4, item_5, smi3, item_6);


    }

    public static void main(String[] args) {
        launch(args);
    }
}
