package com.example.statsheetfx.controller;

import com.example.statsheetfx.dao.TeamDao;
import com.example.statsheetfx.model.Team;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateGameController implements Initializable {
    /* ------------ Elements of createGame.fxml ----------------*/

    Team team;
    String opponent;

    @FXML
    private Button btn_cancel;

    @FXML
    private Button btn_startGame;

    @FXML
    private ComboBox<Team> chooseHomeTeam_id = new ComboBox<Team>();

    @FXML
    private TextField tf_enterOpposingTeam;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TeamDao teamDao = new TeamDao();
        ObservableList<Team> teams = FXCollections.observableArrayList(teamDao.getTeams());
        chooseHomeTeam_id.getItems().addAll(teams);

        BooleanBinding oppTeam = new BooleanBinding() {
            {
                super.bind(chooseHomeTeam_id.valueProperty(), tf_enterOpposingTeam.textProperty());
            }
            @Override
            protected boolean computeValue() {
                return (chooseHomeTeam_id.getValue() == null) || tf_enterOpposingTeam.getText().isEmpty();
            }
        };

        btn_startGame.disableProperty().bind(oppTeam);
    }

    /* ------------------------------------------------------*/

    public void init(){
        System.out.println("test");
    }
    @FXML
    public void startGameClicked() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("newGame.fxml"));
        Parent root = loader.load();
        NewGameController newGameController = loader.getController();
        Stage window = (Stage) btn_startGame.getScene().getWindow();
        window.setScene(new Scene(root, 1000, 800));

        opponent = tf_enterOpposingTeam.getText();
        team = chooseHomeTeam_id.getValue();
        newGameController.setOpponent(opponent);
        newGameController.setTeam(team);
        newGameController.init();
    }

    // Zurueck zur Homepage

    @FXML
    public void cancelNewGame() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = loader.load();
        Stage window = (Stage) btn_cancel.getScene().getWindow();
        window.setScene(new Scene(root, 1200, 900));
    }
}
