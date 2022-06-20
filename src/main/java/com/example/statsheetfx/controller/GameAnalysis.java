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

    private int gameId;

    public GameAnalysis(int id){
        this.gameId = id;
    }

    public GameAnalysis(){

    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    private TeamDao teamDao;
    private PlayerDao playerDao;
    private StatLineDao statLineDao;
    private GameDao gameDao;

    @FXML
    private Button btn_cancel;
    @FXML
    private TableView<BoxScoreLine> tableview_boxScore;
    @FXML
    private TableColumn<BoxScoreLine, String> playerName;
    @FXML
    private TableColumn<BoxScoreLine, String> totalPoints;
    @FXML
    private TableColumn<?, ?> totalRebounds;
    @FXML
    private TableColumn<?, ?> totalTurnovers;
    @FXML
    private TableColumn<?, ?> ftPercentage;
    @FXML
    private TableColumn<?, ?> totalSteals;
    @FXML
    private TableColumn<StatLine, String> twopoint;
    @FXML
    private TableColumn<?, ?> twopointPercentage;
    @FXML
    private TableColumn<?, ?> threepointPercentage;
    @FXML
    private TableColumn<?, ?> totalAssists;
    @FXML
    private TableColumn<?, ?> threepoint;
    @FXML
    private TableColumn<?, ?> totalBlocks;
    @FXML
    private TableColumn<?, ?> totalPersonalFouls;





    @Override
    public void initialize(URL location, ResourceBundle resources) {
        teamDao = new TeamDao();
        playerDao = new PlayerDao();
        statLineDao = new StatLineDao();
       // gameDao = new GameDao();

    }

    public void cancelNewGame() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = loader.load();
        Stage window = (Stage) btn_cancel.getScene().getWindow();
        window.setScene(new Scene(root, 1200, 900));
    }

    public void init(){
        ObservableList<BoxScoreLine> statLines = FXCollections.observableArrayList(statLineDao.getStats(this.getGameId()));
        tableview_boxScore.getItems().addAll(statLines);
        playerName.setCellValueFactory(new PropertyValueFactory<>("player"));
        totalPoints.setCellValueFactory(new PropertyValueFactory<>("points"));
        totalRebounds.setCellValueFactory(new PropertyValueFactory<>("totalRebs"));
        totalAssists.setCellValueFactory(new PropertyValueFactory<>("assists"));
        totalSteals.setCellValueFactory(new PropertyValueFactory<>("steals"));
        totalBlocks.setCellValueFactory(new PropertyValueFactory<>("blocks"));
        totalTurnovers.setCellValueFactory(new PropertyValueFactory<>("turnovers"));
        totalPersonalFouls.setCellValueFactory(new PropertyValueFactory<>("personalFouls"));
        twopoint.setCellValueFactory(new PropertyValueFactory<>("fgm2"));
        twopointPercentage.setCellValueFactory(new PropertyValueFactory<>("twopointPercentage"));
        threepoint.setCellValueFactory(new PropertyValueFactory<>("fgm3"));
        threepointPercentage.setCellValueFactory(new PropertyValueFactory<>("threepointPercentage"));
        ftPercentage.setCellValueFactory(new PropertyValueFactory<>("ftPercentage"));
        tableview_boxScore.refresh();

    }

}
