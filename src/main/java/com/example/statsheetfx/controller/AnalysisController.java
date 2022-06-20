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
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AnalysisController implements Initializable {
    /* ------------ Elements of analysis.fxml ----------------*/

    @FXML
    private Button btn_analyse;

    @FXML
    private Button btn_cancel;

    @FXML
    private TableView<GameListItem> analysisTable;

    @FXML
    private TableColumn<Team,String> hometeam_col;

    @FXML
    private TableColumn<Team,String> oppteam_col;

    @FXML
    private TableColumn<Game, LocalDate> date_col;

    List<Game> gameList = new ArrayList<>();
    List<GameListItem> gameItems = new ArrayList<>();

    public void cancelNewGame() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = loader.load();
        Stage window = (Stage) btn_cancel.getScene().getWindow();
        window.setScene(new Scene(root, 1200, 900));
    }

    public void analyseSelected() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gameAnalysis.fxml"));
        Parent root = loader.load();
        GameAnalysis gameAnalysis = loader.getController();
        Stage window = (Stage) btn_analyse.getScene().getWindow();
        window.setScene(new Scene(root, 1200, 900));

        gameAnalysis.setGameId(analysisTable.getSelectionModel().getSelectedItem().getId());
        gameAnalysis.init();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TeamDao teamDao = new TeamDao();
        GameDao gameDao = new GameDao();

        ObservableList<GameListItem> games = FXCollections.observableArrayList();

        try {
            gameList = gameDao.getGames();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for(Game game : gameList){
            gameItems.add(new GameListItem(game.getId(),teamDao.getTeam(game.getHomeTeamId()).getName(), game.getGuestTeamId(), game.getDate()));

        }

        games.addAll(gameItems);


        analysisTable.getItems().addAll(gameItems);
        hometeam_col.setCellValueFactory(new PropertyValueFactory<>("homeTeam"));
        date_col.setCellValueFactory(new PropertyValueFactory<>("date"));
        oppteam_col.setCellValueFactory(new PropertyValueFactory<>("opponent"));
    }
}
