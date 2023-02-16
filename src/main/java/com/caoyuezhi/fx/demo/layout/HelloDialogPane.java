package com.caoyuezhi.fx.demo.layout;

import com.caoyuezhi.fx.example.stage.StageExample1;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Optional;

public class HelloDialogPane extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage stage = StageExample1.stageInit(primaryStage);
        stage.show();

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #ffcc99;");

        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);


        Button b1 = new Button("B1");
        Button b2 = new Button("B2");
        Button b3 = new Button("B3");

        anchorPane.getChildren().addAll(b1);
        double width = scene.getWidth();
        double height = scene.getHeight();


        AnchorPane.setLeftAnchor(b1, width / 2 - b1.getWidth() / 2);
        AnchorPane.setTopAnchor(b1, height / 2 - b1.getHeight() / 2);

        b1.setOnAction(event -> {
            Object source = event.getSource();
            Optional<Button> sourceOptional = source instanceof Button ? Optional.of((Button) source) : Optional.empty();
            sourceOptional.ifPresent((button) -> {
                double w = button.getWidth();
                double h = button.getHeight();
            });


            DialogPane dialogPane = new DialogPane();
            dialogPane.setStyle("-fx-background-color: #ccff99;");
            dialogPane.setHeaderText("HeaderText");
            dialogPane.setContentText("ContentText");
            dialogPane.setAccessibleText("AccessibleText");


            ImageView imageView = new ImageView(new Image("icon/icon.png"));
            dialogPane.setGraphic(imageView);

            dialogPane.setExpandableContent(new Text("拓展内容1\nqwer"));   // 详细信息


            dialogPane.getButtonTypes().addAll(ButtonType.NO, ButtonType.CANCEL, ButtonType.CLOSE, ButtonType.PREVIOUS, ButtonType.NEXT);
            ObservableList<ButtonType> buttonTypes = dialogPane.getButtonTypes();
            buttonTypes.forEach(type -> {
                Button btn = (Button) dialogPane.lookupButton(type);
                btn.setOnAction(e -> {
                    System.out.println("OnAction: " + btn.getText());
                });
            });


            Stage dialogStage = new Stage();
//            dialogStage.setResizable(false);
            dialogStage.show();

            Scene dialogScene = new Scene(dialogPane);
            dialogStage.setScene(dialogScene);
        });

        System.out.println("start() end...");
    }
}
