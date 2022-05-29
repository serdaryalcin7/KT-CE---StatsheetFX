package com.example.statsheetfx.controller;
import com.example.statsheetfx.dao.PlayerDao;
import com.example.statsheetfx.dao.TeamDao;
import com.example.statsheetfx.model.Player;
import com.example.statsheetfx.model.Team;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class createTeamPlayerController implements Initializable {
    private TeamDao teamDao;
    private PlayerDao playerDao;

    @FXML
    private Button btn_finish;

    @FXML
    public TextField teamName;

    @FXML
    public TextField teamCity;

    @FXML
    public TextField newFirstName;

    @FXML
    public TextField newLastName;

    @FXML
    public TextField newNumber;

    @FXML
    public TableView<Player> playersTable;


    @FXML
    public void addPlayerToTable(ActionEvent actionEvent) {
        ObservableList<Player> data = playersTable.getItems();
        Player toAdd = new Player();
        toAdd.setName(newFirstName.getText() + " " + newLastName.getText());
        toAdd.setJerseyNo(Integer.parseInt(newNumber.getText()));
        data.add(toAdd);

        newFirstName.setText("");
        newLastName.setText("");
        newNumber.setText("");
        newNumber.setPromptText("Number");
    }

    @FXML
    public void createNewTeam(ActionEvent actionEvent) throws SQLException, IOException {
        Team team = new Team();
        team.setName(teamName.getText());

        team = teamDao.createTeam(team);

        ObservableList<Player> players = playersTable.getItems();
        for (Player player : players) {
            player.setTeamId(team.getId());
           playerDao.createPlayer(player);
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = loader.load();
        Stage window = (Stage) btn_finish.getScene().getWindow();
        window.setScene(new Scene(root, 800, 600));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        teamDao = new TeamDao();
        playerDao = new PlayerDao();
    }
}