module com.caoyuezhi.fx.demo1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.caoyuezhi.fx.demo1 to javafx.fxml;
    exports com.caoyuezhi.fx.demo1;
}