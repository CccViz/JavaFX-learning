package com.caoyuezhi.fx.example.button;

import com.caoyuezhi.fx.common.css.RegionCssContanst;
import javafx.scene.control.Button;

public class MyButton extends Button {

    private Runnable fireTask;

    public void setFireTask(Runnable task) {
        this.fireTask = task;
        this.setOnAction(event -> {
            System.out.println(this.getText() + String.format(": width=[%s, %s], height=[%s, %s]", this.getWidth(), this.getPrefWidth(), this.getHeight(), this.getPrefHeight()));
            if (fireTask != null) {
                fireTask.run();
            }
        });
    }


    public MyButton() {
        super();
        this.setFireTask(null);
        this.setPrefHeight(40.);
        this.setPrefWidth(100.);
        this.setStyle(
                RegionCssContanst.BACKGROUND_COLOR.setValue("#e8e8e8").toStr()
                + RegionCssContanst.BORDER_COLOR.setValue("#2b2b2b").toStr()
                + RegionCssContanst.BORDER_WIDTH.setValue("1 3 2 1").toStr()
                + RegionCssContanst.BORDER_INSETS.setValue("10 20 10 5").toStr()
                + RegionCssContanst.PADDING.setValue("10 20 10 5").toStr()
        );
    }

    public MyButton(String text) {
        this();
        this.setText(text);
    }

    public MyButton(Runnable task) {
        this();
        this.setFireTask(task);
    }

}
