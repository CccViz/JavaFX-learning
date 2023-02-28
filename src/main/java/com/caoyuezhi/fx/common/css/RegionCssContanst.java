package com.caoyuezhi.fx.common.css;

import javafx.scene.layout.Region;

public enum RegionCssContanst implements CssContanst {

    /**
     * 每个Region由几个层组成，从下到上绘制，顺序如下:
     * background fills         背景填充
     * background images        背景图片
     * border strokes           边境中风
     * border images            边框的图片
     * contents                 内容
     */
    BACKGROUND_COLOR("-fx-background-color", "transparent"),    //-fx-background-color: red;
    BACKGROUND_IMAGE("-fx-background-image", "null"),
    BACKGROUND_RADIUS("-fx-background-radius", "0 0 0 0"),
    BACKGROUND_POSITION("-fx-background-position", "0% 0%"),
    BORDER_COLOR("-fx-border-color", "0 0 0 0"),
    BORDER_WIDTH("-fx-border-width", "0 0 0 0"),
    BORDER_INSETS("-fx-border-insets", "0 0 0 0"),
    PADDING("-fx-padding", "0 0 0 0"),

    NULL(null, null);


    public final String property;
    public final String defaultValue;
    public String value;

    private static final Class<Region> clazz = Region.class;

    RegionCssContanst(String property, String defaultValue) {
        this.property = property;
        this.defaultValue = defaultValue;
    }

    @Override
    public Class getClazz() {
        return clazz;
    }

    public String getProperty() {
        return property;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public String getValue() {
        return value;
    }

    public CssContanst setValue(String value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        if (this == NULL) {
            return null;
        }
        return property + splice_symbol + (value == null || "".equals(value) ? defaultValue : value);
    }
}
