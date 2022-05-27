package com.example.statsheetfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage.setTitle("StatsheetFX");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
        stage.setResizable(true);

    }

    public static void main(String[] args) {
        launch();
    }
}