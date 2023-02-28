package com.caoyuezhi.fx.common.css;

import static com.caoyuezhi.fx.common.css.RegionCssContanst.NULL;

public interface CssContanst {

    String splice_symbol = ": ";
    String end_symbol = ";";

    public Class getClazz();

    public String getProperty();

    public String getDefaultValue();

    public String getValue();

    public CssContanst setValue(String value);

    default String toStr() {
        if (this == NULL) {
            return null;
        }
        String value = getValue();
        return getProperty() + splice_symbol + (value == null || "".equals(value) ? getDefaultValue() : value) + end_symbol;
    }
}
