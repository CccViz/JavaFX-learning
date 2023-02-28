package com.caoyuezhi.fx.example.button;

import javafx.scene.control.Button;

public class ButtonExample1 {

    public static Button simpleButton() {
        Button button = new MyButton();
        return button;
    }

    public static Button simpleButton(String text) {
        Button button = simpleButton();
        button.setText(text);
        return button;
    }
}
