package com.example.statsheetfx;

import com.example.statsheetfx.dao.GameDao;
import com.example.statsheetfx.dao.PlayerDao;
import com.example.statsheetfx.model.Player;
import com.example.statsheetfx.model.StatLineSummary;
import com.example.statsheetfx.model.Team;
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

import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

public class HelloController implements Initializable {
    private Set<StatLineSummary> statLinesSet;
    private ObservableList<StatLineSummary> statLines = FXCollections.observableArrayList();

    String eventPlayerName = "";
    String event = "";

    private GameDao gameDao;
    private PlayerDao playerDao;

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


    public Set<StatLineSummary> getStatLinesSet() {
        return statLinesSet;
    }

    public void setStatLinesSet(Set<StatLineSummary> statLinesSet) {
        this.statLinesSet = statLinesSet;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        playerDao = new PlayerDao();

        Set<StatLineSummary> statlinesSet = new HashSet<>();

        List<Player> players= playerDao.getPlayersFromTeam(1);

        for(Player p : players ){
            statlinesSet.add(new StatLineSummary(p));
        }


        setStatLinesSet(statlinesSet);

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
    public void twoMadeClicked(ActionEvent e) throws InterruptedException {
        //TODO: counter should be updated after Player and Event is clicked
        if(!eventPlayerName.isEmpty()) {
            String num = counterHome.getText();
            counterHome.setText(addTwo(num));
        }else{
            highlightClickedButton((Button) e.getSource());
        }
        event = "2PT-FG Made";
    }

    @FXML
    public void highlightClickedButton(Button b){
            b.setText("markiert");
        return;
    }

    @FXML
    public void threeMadeClicked(ActionEvent e) {
        int num = Integer.parseInt(counterHome.getText());
        counterHome.setText(Integer.toString(num+3));
        event = "3PT-FG Made";
    }
    @FXML
    public void ftMadeClicked(ActionEvent e) {
        int num = Integer.parseInt(counterHome.getText());
        counterHome.setText(Integer.toString(num+1));
        event = "FT Made";

    }

    @FXML void offRebClicked(ActionEvent e){
        event = "Offensive Rebound";
    }

    @FXML void defRebClicked(ActionEvent e){
        event = "Defensive Rebound";
    }

    @FXML void assistClicked(ActionEvent e){
        event = "Assist";
    }

    @FXML void personalFoulClicked(ActionEvent e){
        event = "Personal Foul Committed";

        //TODO: Foul-Counter should only be updated after PlayerSlot is clicked!
        int num = Integer.parseInt(teamFoulsCounter_id.getText());
        teamFoulsCounter_id.setText(Integer.toString(num+1));

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

    public int addOne(int i){

        return i+1;
    }

    public String addTwo(String num){
        return Integer.toString(Integer.parseInt(num)+2);
    }

    public int addThree(int i){
        return i+2;
    }


    @FXML
    public void foulsClicked(ActionEvent e) {

    }

    @FXML
    public void playerSlotClicked(ActionEvent e){
        System.out.println(e.getSource());

        Button clickedPlayerSlot = (Button) e.getSource();


        eventPlayerName = clickedPlayerSlot.getText();

        updateStatlines(eventPlayerName, event);
    }



    private void updateStatlines(String eventPlayerName, String event) {
        for (StatLineSummary s : statLinesSet){
            if(eventPlayerName.equals(s.getPlayerName())) {
                if(!event.isEmpty()){

                    // TODO: implement for all Categories in StatLine

                    if(event.equals("2PT-FG Made")){
                        int i = Integer.parseInt(s.getTotalPoints());
                        i += 2;
                        String updatedTotalPoints = String.valueOf(i);

                        s.setTotalPoints(updatedTotalPoints);
                    }
                    if(event.equals("3PT-FG Made")){
                        int i = Integer.parseInt(s.getTotalPoints());
                        i += 3;
                        String updatedTotalPoints = String.valueOf(i);

                        s.setTotalPoints(updatedTotalPoints);
                    }
                    if(event.equals("FT Made")){
                        int i = Integer.parseInt(s.getTotalPoints());
                        i += 1;
                        String updatedTotalPoints = String.valueOf(i);

                        s.setTotalPoints(updatedTotalPoints);

                    }
                    if(event.equals("Offensive Rebound") || event.equals("Defensive Rebound")){
                        int i = Integer.parseInt(s.getTotalRebounds());
                        i += 1;
                        String updatedTotalRebounds= String.valueOf(i);
                        s.setTotalRebounds(updatedTotalRebounds);
                    }
                    if(event.equals("Assist")){
                        int i = Integer.parseInt(s.getTotalAssists());
                        i += 1;
                        String updatedTotalAssists= String.valueOf(i);
                        s.setTotalAssists(updatedTotalAssists);
                    }
                    if(event.equals("Personal Foul Committed")){
                        int i = Integer.parseInt(s.getTotalPersonalFouls());
                        i += 1;
                        String updatedTotalFouls= String.valueOf(i);
                        s.setTotalPersonalFouls(updatedTotalFouls);
                    }
                }
            }
        }
        tableview_boxScore.refresh();
    }


    @FXML
    private void initializePlayers(ActionEvent e) {
        List<Player> players= playerDao.getPlayersFromTeam(1);
        int i = 1;
        for(Player player :players){
            if(i == 1){ playerSlot1_id.setText(player.getName());}
            if(i == 2){ playerSlot2_id.setText(player.getName());}
            if(i == 3){ playerSlot3_id.setText(player.getName());}
            if(i == 4){ playerSlot4_id.setText(player.getName());}
            if(i == 5){ playerSlot5_id.setText(player.getName());}
            if(i == 6){ playerSlot6_id.setText(player.getName());}
            if(i == 7){ playerSlot7_id.setText(player.getName());}
            if(i == 8){ playerSlot8_id.setText(player.getName());}
            if(i == 9){ playerSlot9_id.setText(player.getName());}
            if(i == 10){ playerSlot10_id.setText(player.getName());}
            if(i == 11){ playerSlot11_id.setText(player.getName());}
            if(i == 12){ playerSlot12_id.setText(player.getName());}

            i += 1;
        }
    }

}