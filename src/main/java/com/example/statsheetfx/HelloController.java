package com.example.statsheetfx;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;

public class HelloController implements Initializable {
    private Set<StatLine> statLinesSet;
    private ObservableList<StatLineSummary> statLines = FXCollections.observableArrayList();

    @FXML
    Button newGame;
    @FXML
    Button back;
    @FXML
    Label counterHome;
    @FXML
    Label counterGuest;
    @FXML
    Label fouls;
    @FXML
    private TableView<StatLineSummary> tableview_boxScore;

    @FXML
    private TableColumn<StatLineSummary, String> name;

    @FXML
    private TableColumn<StatLineSummary, String> pts;

    @FXML
    private TableColumn<StatLineSummary, String> reb;

    @FXML
    private TableColumn<StatLineSummary, String> ast;

    @FXML
    private TableColumn<StatLineSummary, String> foulsCommited;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        /* Georg (probiert, die Tabelle zu befüllen)
        statLinesSet = new TreeSet<>();
        statLines = FXCollections.observableArrayList();

        Player player1 = new Player("Georg", "Rülling", 0);
        Player player2 = new Player("Magic-Serdar", "Yalcin", 23);
        Player player3 = new Player("Mamba-Rifat", "Bryant", 0);

        statLinesSet.add(new StatLine(player1));
        statLinesSet.add(new StatLine(player2));
        statLinesSet.add(new StatLine(player3));

        StatLineSummary line = new StatLineSummary(new StatLine(player1));
        statLines.add(line);



        if(name != null) {

            name.setCellValueFactory(new PropertyValueFactory<>("name"));
            name.setCellFactory(TextFieldTableCell.forTableColumn());

            pts.setCellValueFactory(new PropertyValueFactory<>("pts"));
            pts.setCellFactory(TextFieldTableCell.forTableColumn());

            reb.setCellValueFactory(new PropertyValueFactory<>("pts"));
            reb.setCellFactory(TextFieldTableCell.forTableColumn());

            ast.setCellValueFactory(new PropertyValueFactory<>("pts"));
            ast.setCellFactory(TextFieldTableCell.forTableColumn());

            tableview_boxScore.setItems(statLines);


         */
        }

        /*
        name.setCellValueFactory(new PropertyValueFactory<PlayerStats, SimpleStringProperty>("name"));
        pts.setCellValueFactory(new PropertyValueFactory<PlayerStats, Integer>("pts"));
        reb.setCellValueFactory(new PropertyValueFactory<PlayerStats, Integer>("reb"));
        ast.setCellValueFactory(new PropertyValueFactory<PlayerStats, Integer>("ast"));
        foulsmade.setCellValueFactory(new PropertyValueFactory<PlayerStats, Integer>("foulsmade"));

        tableview.setItems(getPlayerStats());
        */

      public ObservableList<PlayerStats> getPlayerStats() {

        ObservableList<PlayerStats> playerStats = FXCollections.observableArrayList();
        playerStats.add(new PlayerStats("Lebron", 12, 12, 12, 12));
        playerStats.add(new PlayerStats("Rif", 12, 12, 12, 12));
        playerStats.add(new PlayerStats("Anan", 12, 12, 12, 12));

        return playerStats;
    }




    //Wechsel zu Screen New Game
    @FXML
    public void newGameClicked() throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("newGame.fxml"));
        Stage window = (Stage) newGame.getScene().getWindow();
        window.setScene(new Scene(root, 1000, 800));

    }


    // Zurueck zur Homepage
    public void backtoHome() throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage window = (Stage) back.getScene().getWindow();
        window.setScene(new Scene(root, 800, 600));
    }

    public void twoMadeClicked(ActionEvent e) {
        int num = Integer.parseInt(counterHome.getText());
        counterHome.setText(Integer.toString(num+2));
    }

    public void threeMadeClicked(ActionEvent e) {
        int num = Integer.parseInt(counterHome.getText());
        counterHome.setText(Integer.toString(num+3));
    }

    public void ftMadeClicked(ActionEvent e) {
        int num = Integer.parseInt(counterHome.getText());
        counterHome.setText(Integer.toString(num+1));
    }

    public void optwoMadeClicked(ActionEvent e) {
        int num = Integer.parseInt(counterGuest.getText());
        counterGuest.setText(Integer.toString(num+2));
    }

    public void opthreeMadeClicked(ActionEvent e) {
        int num = Integer.parseInt(counterGuest.getText());
        counterGuest.setText(Integer.toString(num+3));
    }

    public void opftMadeClicked(ActionEvent e) {
        int num = Integer.parseInt(counterGuest.getText());
        counterGuest.setText(Integer.toString(num+1));
    }

    public void foulsClicked(ActionEvent e) {
        int num = Integer.parseInt(fouls.getText());
        fouls.setText(Integer.toString(num+1));
    }

}