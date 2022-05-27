module com.example.statsheetfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.statsheetfx to javafx.fxml;
    exports com.example.statsheetfx;
    exports com.example.statsheetfx.model;
    opens com.example.statsheetfx.model to javafx.fxml;
}