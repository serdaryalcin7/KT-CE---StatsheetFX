package com.example.statsheetfx.controller;

import com.example.statsheetfx.dao.GameDao;
import com.example.statsheetfx.dao.TeamDao;
import com.example.statsheetfx.model.*;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class GameAnalysis implements Initializable {
    /* ------------ Elements of analysis.fxml ----------------*/
    @FXML
    private Button btn_cancel;




    public void cancelNewGame() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = loader.load();
        Stage window = (Stage) btn_cancel.getScene().getWindow();
        window.setScene(new Scene(root, 1200, 900));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}