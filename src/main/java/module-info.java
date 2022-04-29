module com.example.statsheetfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.statsheetfx to javafx.fxml;
    exports com.example.statsheetfx;
}