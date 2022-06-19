package com.example.statsheetfx.controller;

import com.example.statsheetfx.dao.GameDao;
import com.example.statsheetfx.dao.PlayerDao;
import com.example.statsheetfx.dao.StatLineDao;
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
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class GameAnalysis implements Initializable {
    /* ------------ Elements of analysis.fxml ----------------*/
    private TeamDao teamDao;
    private PlayerDao playerDao;
    private StatLineDao statLineDao;
    private GameDao gameDao;



    @FXML
    private Button btn_cancel;
    @FXML
    private TableView<StatLine> tableview_boxScore;
    @FXML
    private TableColumn<StatLine, String> playerName;
    @FXML
    private TableColumn<StatLine, String> totalPoints;
    @FXML
    private TableColumn<?, ?> totalRebounds;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        teamDao = new TeamDao();
        playerDao = new PlayerDao();
        statLineDao = new StatLineDao();
       // gameDao = new GameDao();

            ObservableList<StatLine> players = FXCollections.observableArrayList(statLineDao.getStats(15));
            tableview_boxScore.getItems().addAll(players);
            playerName.setCellValueFactory(new PropertyValueFactory<>("p"));
            totalPoints.setCellValueFactory(new PropertyValueFactory<>("points"));
            totalRebounds.setCellValueFactory(new PropertyValueFactory<>("totalRebs"));
            tableview_boxScore.refresh();

    }

    public void cancelNewGame() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = loader.load();
        Stage window = (Stage) btn_cancel.getScene().getWindow();
        window.setScene(new Scene(root, 1200, 900));
    }


}
