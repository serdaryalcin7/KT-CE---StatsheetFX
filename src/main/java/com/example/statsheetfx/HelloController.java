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
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
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
    private TableColumn<StatLineSummary, String> playerName;

    @FXML
    private TableColumn<StatLineSummary, String> totalPoints;

    @FXML
    private TableColumn<StatLineSummary, String> totalRebounds;

    @FXML
    private TableColumn<StatLineSummary, String> totalAssists;

    @FXML
    private TableColumn<StatLineSummary, String> totalPersonalFouls;

    //Skeleton for newGame.fxml

    @FXML
    private Button assist_id;

    @FXML
    private Button block_id;

    @FXML
    private Button defReb_id;

    @FXML
    private Button foulsCommited_id;

    @FXML
    private Button foulsForced_Id;

    @FXML
    private Button ftMade;

    @FXML
    private Button ftMissed1;

    @FXML
    private Button offReb_id;

    @FXML
    private Button opFTmade;

    @FXML
    private Button opthreeMade;

    @FXML
    private Button optwoMade;

    @FXML
    private Button playerSlot10_id;

    @FXML
    private Button playerSlot11_id;

    @FXML
    private Button playerSlot12_id;

    @FXML
    private Button playerSlot1_id;

    @FXML
    private Button playerSlot2_id;

    @FXML
    private Button playerSlot3_id;

    @FXML
    private Button playerSlot4_id;

    @FXML
    private Button playerSlot5_id;

    @FXML
    private Button playerSlot6_id;

    @FXML
    private Button playerSlot7_id;

    @FXML
    private Button playerSlot8_id;

    @FXML
    private Button playerSlot9_id;

    @FXML
    private Button quarter1_id;

    @FXML
    private Button quarter2_id;

    @FXML
    private Button quarter3_id;

    @FXML
    private Button quarter4_id;

    @FXML
    private Button quarterOT_id;

    @FXML
    private Label quarterScore_id;

    @FXML
    private Pane scoreBoardPane_id;

    @FXML
    private Button steal_id;


    @FXML
    private TableView<?> tableview_playByplayId;

    @FXML
    private Label teamFoulsCounter_id;

    @FXML
    private Button threeMade;

    @FXML
    private Button threeMissed;

    @FXML
    private Button turnover_id;

    @FXML
    private Button twoMade;

    @FXML
    private Button twoMissed;

    @FXML
    private Button loadTeam_id;

    @FXML
    private Text txt_2PTFieldGoalsId;

    @FXML
    private Text txt_3PTFieldGoalsId;

    @FXML
    private Text txt_FoulsId;

    @FXML
    private Text txt_FoulsId1;

    @FXML
    private Text txt_FreeThrowsId;

    @FXML
    private Text txt_homeTeam;

    @FXML
    private Text txt_playByplayId;

    @FXML
    private Text txt_visitors;

    @FXML
    void backtoHome(ActionEvent event) {

    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Set<StatLineSummary> statlinesSet = new HashSet<>();

        Player player1 = new Player("Lebron", "James", 23);
        Player player2 = new Player("Serdar", "Yalcin", 17);
        Player player3 = new Player("Donald", "Trump", 6);

        statlinesSet.add(new StatLineSummary(player1));
        statlinesSet.add(new StatLineSummary(player2));
        statlinesSet.add(new StatLineSummary(player3));

        statLines = FXCollections.observableArrayList();

        statLines.addAll(statlinesSet);

        if(playerName != null) {

            playerName.setCellValueFactory(new PropertyValueFactory<>("playerName"));
            playerName.setCellFactory(TextFieldTableCell.forTableColumn());

            totalPoints.setCellValueFactory(new PropertyValueFactory<>("totalPoints"));
            totalPoints.setCellFactory(TextFieldTableCell.forTableColumn());

            totalRebounds.setCellValueFactory(new PropertyValueFactory<>("totalRebounds"));
            totalRebounds.setCellFactory(TextFieldTableCell.forTableColumn());

            totalAssists.setCellValueFactory(new PropertyValueFactory<>("totalAssists"));
            totalAssists.setCellFactory(TextFieldTableCell.forTableColumn());

            totalPersonalFouls.setCellValueFactory(new PropertyValueFactory<>("totalPersonalFouls"));
            totalPersonalFouls.setCellFactory(TextFieldTableCell.forTableColumn());

            tableview_boxScore.setItems(statLines);
        }

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
    @FXML
    public void backtoHome() throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage window = (Stage) back.getScene().getWindow();
        window.setScene(new Scene(root, 800, 600));
    }
    @FXML
    public void twoMadeClicked(ActionEvent e) {
        int num = Integer.parseInt(counterHome.getText());
        counterHome.setText(Integer.toString(num+2));
    }
    @FXML
    public void threeMadeClicked(ActionEvent e) {
        int num = Integer.parseInt(counterHome.getText());
        counterHome.setText(Integer.toString(num+3));
    }
    @FXML
    public void ftMadeClicked(ActionEvent e) {
        int num = Integer.parseInt(counterHome.getText());
        counterHome.setText(Integer.toString(num+1));
    }
    @FXML
    public void optwoMadeClicked(ActionEvent e) {
        int num = Integer.parseInt(counterGuest.getText());
        counterGuest.setText(Integer.toString(num+2));
    }
    @FXML
    public void opthreeMadeClicked(ActionEvent e) {
        int num = Integer.parseInt(counterGuest.getText());
        counterGuest.setText(Integer.toString(num+3));
    }
    @FXML
    public void opftMadeClicked(ActionEvent e) {
        int num = Integer.parseInt(counterGuest.getText());
        counterGuest.setText(Integer.toString(num+1));
    }

    @FXML
    public void foulsClicked(ActionEvent e) {
        int num = Integer.parseInt(fouls.getText());
        fouls.setText(Integer.toString(num+1));
    }

    @FXML
    private void initializePlayers(ActionEvent e) {

        Team team = new Team("LA Lakers");

        Set<Player> playersSet = new HashSet<>();

        playersSet.add(new Player("Lebron", "James", 23));
        playersSet.add(new Player("Georg", "Rülling", 0));
        playersSet.add(new Player("Serdar", "Yalcin", 17));
        playersSet.add(new Player("Rifat", "Kiliclasan", 6));
        playersSet.add(new Player("Donald", "Trump", 6));
        playersSet.add(new Player("Tony", "Romo", 6));
        playersSet.add(new Player("Andreas", "Gabalier", 6));
        playersSet.add(new Player("Joe", "Biden", 6));
        playersSet.add(new Player("Herbert", "Grönemeyer", 6));

        team.setPlayers(playersSet);

        int i = 1;
        for(Player player :playersSet){
            if(i == 1){ playerSlot1_id.setText(player.getFirstName() + " " + player.getLastName());}
            if(i == 2){ playerSlot2_id.setText(player.getFirstName() + " " + player.getLastName());}
            if(i == 3){ playerSlot3_id.setText(player.getFirstName() + " " + player.getLastName());}
            if(i == 4){ playerSlot4_id.setText(player.getFirstName() + " " + player.getLastName());}
            if(i == 5){ playerSlot5_id.setText(player.getFirstName() + " " + player.getLastName());}
            if(i == 6){ playerSlot6_id.setText(player.getFirstName() + " " + player.getLastName());}
            if(i == 7){ playerSlot7_id.setText(player.getFirstName() + " " + player.getLastName());}
            if(i == 8){ playerSlot8_id.setText(player.getFirstName() + " " + player.getLastName());}
            if(i == 9){ playerSlot9_id.setText(player.getFirstName() + " " + player.getLastName());}
            if(i == 10){ playerSlot10_id.setText(player.getFirstName() + " " + player.getLastName());}
            if(i == 11){ playerSlot11_id.setText(player.getFirstName() + " " + player.getLastName());}
            if(i == 12){ playerSlot12_id.setText(player.getFirstName() + " " + player.getLastName());}

            i += 1;
        }
    }

}