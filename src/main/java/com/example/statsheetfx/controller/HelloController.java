package com.example.statsheetfx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    Button newGame;

    @FXML
    private Button btn_createTeamPlayer;

    @FXML
    private Button btn_analysisWindow;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }


    //Wechsel zu Screen New Game
    @FXML
    public void newGameClicked() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("createGame.fxml"));
        Parent root = loader.load();
        CreateGameController createGameController = loader.getController();
        Stage window = (Stage) newGame.getScene().getWindow();
        window.setScene(new Scene(root, 1000, 800));
    }

    @FXML
    void createTeamsPlayersClicked(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("createTeamPlayer.fxml"));
        Parent root = loader.load();
        createTeamPlayerController createTeamPlayerController = loader.getController();
        Stage window = (Stage) btn_createTeamPlayer.getScene().getWindow();
        window.setScene(new Scene(root, 1000, 800));
    }

    public void analysisWindowOpen() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("analysis.fxml"));
        Parent root = loader.load();
        AnalysisController analysisController = loader.getController();
        Stage window = (Stage) btn_analysisWindow.getScene().getWindow();
        window.setScene(new Scene(root, 1000, 800));
    }
}