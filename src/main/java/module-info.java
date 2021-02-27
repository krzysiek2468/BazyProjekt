module org.example {
    requires javafx.controls;
    requires com.jfoenix;
    requires javafx.fxml;


    opens org.example to javafx.fxml;
    exports org.example;


}