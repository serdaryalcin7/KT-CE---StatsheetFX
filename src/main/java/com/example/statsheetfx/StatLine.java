package com.example.statsheetfx;

public class StatLine {
    private Player player;
    private int fga2;
    private int fgm2;
    private int fga3;
    private int fgm3;
    private int fta;
    private int ftm;
    private int orebs;
    private int drebs;
    private int assists;
    private int steals;
    private int turnovers;
    private int blocks;
    private int personalFouls;
    private int forcedFouls;

    public StatLine(Player player) {
        this.player = player;
        this.fga2 = 0;
        this.fgm2 = 0;
        this.fga3 = 0;
        this.fgm3 = 0;
        this.fta = 0;
        this.ftm = 0;
        this.orebs = 0;
        this.drebs = 0;
        this.assists = 0;
        this.steals = 0;
        this.turnovers = 0;
        this.blocks = 0;
        this.personalFouls = 0;
        this.forcedFouls = 0;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getFga2() {
        return fga2;
    }

    public int getFgm2() {
        return fgm2;
    }

    public int getFga3() {
        return fga3;
    }

    public int getFgm3() {
        return fgm3;
    }

    public int getFta() {
        return fta;
    }

    public int getFtm() {
        return ftm;
    }

    public int getOrebs() {
        return orebs;
    }

    public int getDrebs() {
        return drebs;
    }

    public int getAssists() {
        return assists;
    }

    public int getSteals() {
        return steals;
    }

    public int getTurnovers() {
        return turnovers;
    }

    public int getBlocks() {
        return blocks;
    }

    public int getPersonalFouls() {
        return personalFouls;
    }

    public int getForcedFouls() {
        return forcedFouls;
    }

    public void fg2Attempt(){
        this.fga2 +=1;
    }
    public void fg2Made(){                  // FG-Made always means FG-Attempt as well
        fg2Attempt();
        this.fgm2 +=1;
    }

    public void fg3Attempt(){
        this.fga3 +=1;
    }
    public void fg3Made(){                  // FG-Made always means FG-Attempt as well
        fg3Attempt();
        this.fgm3 +=1;
    }

    public void ftAttempt(){
        this.fta +=1;
    }
    public void ftMade(){                  // FT-Made always means FG-Attempt as well
        ftAttempt();
        this.ftm +=1;
    }

    public void offRebound(){
        this.orebs += 1;
    }

    public void defRebound(){
        this.drebs += 1;
    }
    public void assist(){
        this.assists += 1;
    }
    public void steal(){
        this.steals += 1;
    }
    public void turnover(){
        this.turnovers += 1;
    }

    public void block(){
        this.blocks += 1;
    }

    public void foulCommited(){
        this.personalFouls += 1;
    }

    public void foulForced(){
        this.forcedFouls += 1;
    }
}
