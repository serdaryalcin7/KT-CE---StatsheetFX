package com.example.statsheetfx.controller;

import com.example.statsheetfx.dao.GameDao;
import com.example.statsheetfx.dao.PlayerDao;
import com.example.statsheetfx.dao.StatLineDao;
import com.example.statsheetfx.dao.TeamDao;
import com.example.statsheetfx.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

public class NewGameController implements Initializable {
    String eventPlayerName = "";
    String event = "";
    @FXML
    Button back;
    @FXML
    Label counterHome;
    @FXML
    Label counterGuest;

    @FXML
    Label fouls;
    private final ObservableList<StatLine> stats = FXCollections.observableArrayList();
    private String opponent;
    private Team team;
    private Game game;

    /* Data access object - classes */
    private GameDao gameDao;
    private PlayerDao playerDao;
    private StatLineDao statLineDao;

    //Skeleton for newGame.fxml
    private TeamDao teamDao;
    @FXML
    private Button assist_id;
    @FXML
    private Button block_id;

    @FXML
    private Button defReb_id;

    @FXML
    private Button finish_game_id;

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
    private Text txt_visitors;
    @FXML
    private TableView<StatLine> tableview_boxScore;
    @FXML
    private TableColumn<StatLine, String> playerName;
    @FXML
    private TableColumn<StatLine, String> totalPoints;

    /* TableView for StatlineSummaries */
    @FXML
    private TableColumn<StatLine, String> totalRebounds;
    @FXML
    private TableColumn<StatLine, String> totalAssists;
    @FXML
    private TableColumn<StatLine, String> totalSteals;
    @FXML
    private TableColumn<StatLine, String> totalTurnovers;
    @FXML
    private TableColumn<StatLine, String> totalBlocks;
    @FXML
    private TableColumn<StatLine, String> totalPersonalFouls;

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setGame(Game game) {
        this.game = game;
    }
    /*-----------------------------*/

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        playerDao = new PlayerDao();
        teamDao = new TeamDao();
        gameDao = new GameDao();
        statLineDao = new StatLineDao();
    }

    @FXML
    public void backtoHome() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage window = (Stage) back.getScene().getWindow();
        window.setScene(new Scene(root, 800, 600));
    }


    /* Schritt 1 - auswählen eines Events, Schritt 2 - auswählen eines Playerslots */

    @FXML
    public void twoAttClicked(ActionEvent e) throws InterruptedException {
        event = "2PT-FG Attempted";
    }

    @FXML
    public void twoMadeClicked(ActionEvent e) throws InterruptedException {
        event = "2PT-FG Made";
    }

    @FXML
    public void threeAttClicked(ActionEvent e) throws InterruptedException {
        event = "3PT-FG Attempted";
    }

    @FXML
    public void threeMadeClicked(ActionEvent e) {
        event = "3PT-FG Made";
    }

    @FXML
    public void ftAttClicked(ActionEvent e) throws InterruptedException {
        event = "FT Attempted";
    }
    @FXML
    public void ftMadeClicked(ActionEvent e) {
        event = "FT Made";
    }

    @FXML
    void offRebClicked(ActionEvent e) {
        event = "Offensive Rebound";
    }

    @FXML
    void defRebClicked(ActionEvent e) {
        event = "Defensive Rebound";
    }

    @FXML
    void assistClicked(ActionEvent e) {
        event = "Assist";
    }

    @FXML
    void stealClicked(ActionEvent e) {
        event = "Steal";
    }

    @FXML
    void turnOverClicked(ActionEvent e) {
        event = "Turn-Over";
    }

    @FXML
    void blockClicked(ActionEvent e) {
        event = "Block";
    }

    @FXML
    void personalFoulClicked(ActionEvent e) {
        event = "Personal Foul Committed";
    }

    @FXML
    void forcedFoulClicked(ActionEvent e) {
        event = "Foul Forced";
    }

    @FXML
    void adjustHomeFoulCounter(){
        int num = Integer.parseInt(teamFoulsCounter_id.getText());
        teamFoulsCounter_id.setText(Integer.toString(num + 1));
    }




    /* Opponent scores */
    @FXML
    public void optwoMadeClicked(ActionEvent e) {
        int num = Integer.parseInt(counterGuest.getText());
        counterGuest.setText(Integer.toString(num + 2));
    }

    @FXML
    public void opthreeMadeClicked(ActionEvent e) {
        int num = Integer.parseInt(counterGuest.getText());
        counterGuest.setText(Integer.toString(num + 3));
    }

    @FXML
    public void opftMadeClicked(ActionEvent e) {
        int num = Integer.parseInt(counterGuest.getText());
        counterGuest.setText(Integer.toString(num + 1));
    }
    /* --------------------------------------------------------*/



    @FXML
    void finishButtonClicked(ActionEvent event) throws Exception {
        finish_game_id.setDisable(true);

        for (StatLine s : stats) {
            statLineDao.saveStatLine(s, game.getId(), s.getPlayer().getId());
        }
        backtoHome();
    }

    @FXML
    public void playerSlotClicked(ActionEvent e) {
        System.out.println(e.getSource());
        Button clickedPlayerSlot = (Button) e.getSource();
        eventPlayerName = clickedPlayerSlot.getText();
        updateStatlines(eventPlayerName, event);
    }


    private void updateStatlines(String eventPlayerName, String event) {
        for (StatLine s : stats) {
            if (eventPlayerName.equals(s.getPlayerName())) {
                if (!event.isEmpty()) {

                    if (event.equals("2PT-FG Attempted")) {
                        s.fga2();
                    }

                    if (event.equals("2PT-FG Made")) {
                        s.fgm2();
                        int num = Integer.parseInt(counterHome.getText()) + 2;
                        counterHome.setText(String.valueOf(num));
                    }

                    if (event.equals("3PT-FG Attempted")) {
                        s.fga3();
                    }
                    if (event.equals("3PT-FG Made")) {
                        s.fgm3();
                        int num = Integer.parseInt(counterHome.getText()) + 3;
                        counterHome.setText(String.valueOf(num));
                    }

                    if (event.equals("FT Attempted")) {
                        s.fta();
                    }
                    if (event.equals("FT Made")) {
                        s.ftm();
                        int num = Integer.parseInt(counterHome.getText()) + 1;
                        counterHome.setText(String.valueOf(num));
                    }

                    if (event.equals("Offensive Rebound")) {
                        s.oreb();
                    }
                    if (event.equals("Defensive Rebound")) {
                        s.dreb();
                    }

                    if (event.equals("Assist")) {
                        s.setAssists(s.getAssists() + 1);
                    }
                    if (event.equals("Steal")) {
                        s.setSteals(s.getSteals() + 1);
                    }
                    if (event.equals("Turn-Over")) {
                        s.setTurnovers(s.getTurnovers() + 1);
                    }
                    if (event.equals("Block")) {
                        s.setBlocks(s.getBlocks() + 1);
                    }
                    if (event.equals("Personal Foul Committed")) {
                        s.setPersonalFouls(s.getPersonalFouls() + 1);
                        adjustHomeFoulCounter();
                    }
                    if (event.equals("Foul Forced")) {
                        s.setForcedFouls(s.getForcedFouls() + 1);
                    }
                }
            }
        }
        tableview_boxScore.refresh();
        event = "";
        eventPlayerName = "";
    }





    public void init() {
        try {
            game = gameDao.createGame(team.getId(), opponent);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Player> players = playerDao.getPlayersFromTeam(team.getId());


        int i = 1;
        for (Player player : players) {
            stats.add(new StatLine(player));
            if (i == 1) {
                playerSlot1_id.setText(player.getName());
            }
            if (i == 2) {
                playerSlot2_id.setText(player.getName());
            }
            if (i == 3) {
                playerSlot3_id.setText(player.getName());
            }
            if (i == 4) {
                playerSlot4_id.setText(player.getName());
            }
            if (i == 5) {
                playerSlot5_id.setText(player.getName());
            }
            if (i == 6) {
                playerSlot6_id.setText(player.getName());
            }
            if (i == 7) {
                playerSlot7_id.setText(player.getName());
            }
            if (i == 8) {
                playerSlot8_id.setText(player.getName());
            }
            if (i == 9) {
                playerSlot9_id.setText(player.getName());
            }
            if (i == 10) {
                playerSlot10_id.setText(player.getName());
            }
            if (i == 11) {
                playerSlot11_id.setText(player.getName());
            }
            if (i == 12) {
                playerSlot12_id.setText(player.getName());
            }
            i++;
        }

        playerName.setCellValueFactory(new PropertyValueFactory<>("playerName"));
        totalPoints.setCellValueFactory(new PropertyValueFactory<>("points"));
        totalRebounds.setCellValueFactory(new PropertyValueFactory<>("totalRebs"));
        totalAssists.setCellValueFactory(new PropertyValueFactory<>("assists"));
        totalSteals.setCellValueFactory(new PropertyValueFactory<>("steals"));
        totalTurnovers.setCellValueFactory(new PropertyValueFactory<>("turnovers"));
        totalBlocks.setCellValueFactory(new PropertyValueFactory<>("blocks"));
        totalPersonalFouls.setCellValueFactory(new PropertyValueFactory<>("personalFouls"));
        tableview_boxScore.setItems(stats);
    }
}
