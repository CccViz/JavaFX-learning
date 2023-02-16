package com.caoyuezhi.fx;

import com.caoyuezhi.fx.example.stage.StageExample1;
import javafx.application.Application;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;


import java.time.LocalDateTime;
import java.time.LocalTime;

public class HelloScheduledService extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage stage = StageExample1.stageInit(primaryStage);
        stage.show();


        AnchorPane aPane = new AnchorPane();
        aPane.setStyle("-fx-background-color: #ffffcc;");

        Button b1 = new Button("B1");
        aPane.getChildren().add(b1);
        b1.setStyle(
                "-fx-background-color: #3399cc;"
                        + "-fx-pref-width: 160;"
                        + "-fx-pref-height: 80;"
                        + " -fx-font-size: 24;"
        );
        b1.setCursor(Cursor.CLOSED_HAND);
        b1.setLayoutX(100);
        b1.setLayoutY(100);

        b1.setOnAction(event -> {
            Button btn = (Button) event.getSource();

            DialogPane dPane = new DialogPane();
            dPane.setStyle("-fx-background-color: #ffffcc;");
            dPane.setHeaderText("HeaderText");
            dPane.setContentText("ContentText");
            dPane.setAccessibleText("AccessibleText");
            dPane.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);

            Scene dScene = new Scene(dPane);

            Stage dStage = new Stage();
            dStage.setTitle("Dialog");
            dStage.setScene(dScene);
            dStage.show();

            MyScheduledService scheduledService = new MyScheduledService(dPane, dStage);
            scheduledService.setPeriod(Duration.seconds(1.0));
            scheduledService.start();
        });


        Scene scene = new Scene(aPane);
        stage.setScene(scene);


        b1.fire();


        StageStyle stageStyle = stage.getStyle();
        System.out.println("stageStyle = " + stageStyle);
    }


    public class MyScheduledService extends ScheduledService {

        public DialogPane dialogPane;
        public Stage dialogStage;

        private LocalDateTime startTime;

        private int iii = 1;

        public MyScheduledService(DialogPane dialogPane, Stage stage) {
            this.dialogPane = dialogPane;
            this.dialogStage = stage;
        }

        @Override
        protected Task createTask() {
            Task<Object> task = new Task<>() {

                @Override
                protected Object call() throws Exception {
                    System.out.println(Thread.currentThread().getName() + "\tiii = " + iii);
                    startTime = startTime == null ? LocalDateTime.now().withNano(0) : startTime;
                    iii += 1;
                    return LocalTime.now().withNano(0);
                }


                @Override
                protected void updateValue(Object value) {
                    super.updateValue(value);
                    System.out.println(Thread.currentThread().getName() + "\tvalue = " + value);


                    String oldText = dialogPane.getContentText();
                    dialogPane.setContentText(oldText + "\n" + value);

                    int compare = LocalDateTime.now().withNano(0).minusSeconds(10L).compareTo(startTime);
                    if (compare >= 0){
                        close();
                    }
                }
            };


            return task;
        }

        private void close(){
            System.out.println("close() : " + Thread.currentThread().getName());
            System.out.println("startTime = " + startTime);
            this.cancel();
            dialogStage.close();
        }


    }
}
