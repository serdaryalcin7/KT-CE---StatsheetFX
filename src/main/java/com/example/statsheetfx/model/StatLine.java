package com.example.statsheetfx.model;

public class StatLine {
    private Player player;
    private int id;
    private int fga2;
    private int fgm2;
    private int fga3;
    private int fgm3;
    private int fta;
    private int ftm;
    private int orebs;
    private int drebs;
    private int totalRebs;
    private int assists;
    private int steals;
    private int turnovers;
    private int blocks;
    private int personalFouls;
    private int forcedFouls;
    private int points;
    private double twopointPercentage;


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
        this.totalRebs = 0;
        this.assists = 0;
        this.steals = 0;
        this.turnovers = 0;
        this.blocks = 0;
        this.personalFouls = 0;
        this.forcedFouls = 0;
        this.points = this.ftm * 1 + this.fgm2 * 2 + this.fgm3 * 3;

    }

    public StatLine(Player player, int id, int fga2, int fgm2, int fga3, int fgm3, int fta, int ftm, int orebs, int drebs, int totalRebs, int assists, int steals, int turnovers, int blocks, int personalFouls, int forcedFouls, int points) {
        this.player = player;
        this.id = id;
        this.fga2 = fga2;
        this.fgm2 = fgm2;
        this.fga3 = fga3;
        this.fgm3 = fgm3;
        this.fta = fta;
        this.ftm = ftm;
        this.orebs = orebs;
        this.drebs = drebs;
        this.totalRebs = totalRebs;
        this.assists = assists;
        this.steals = steals;
        this.turnovers = turnovers;
        this.blocks = blocks;
        this.personalFouls = personalFouls;
        this.forcedFouls = forcedFouls;
        this.points = points;

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

    public int getPoints() {
        return points;
    }


    public String getPlayerName(){
        return this.player.getName();
    }

    public void setId(int statLineId) {
        this.id = statLineId;
    }

    public int getTotalRebs() {
        return totalRebs;
    }

    public void setFga2(int fga2) {
        this.fga2 = fga2;
    }

    public void setFgm2(int fgm2) {
        this.fgm2 = fgm2;
    }

    public void setFga3(int fga3) {
        this.fga3 = fga3;
    }

    public void setFgm3(int fgm3) {
        this.fgm3 = fgm3;
    }

    public void setFta(int fta) {
        this.fta = fta;
    }

    public void setFtm(int ftm) {
        this.ftm = ftm;
    }

    public void setOrebs(int orebs) {
        this.orebs = orebs;
    }

    public void setDrebs(int drebs) {
        this.drebs = drebs;
    }

    public void setTotalRebs(int totalRebs) {
        this.totalRebs = totalRebs;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public void setSteals(int steals) {
        this.steals = steals;
    }

    public void setTurnovers(int turnovers) {
        this.turnovers = turnovers;
    }

    public void setBlocks(int blocks) {
        this.blocks = blocks;
    }

    public void setPersonalFouls(int personalFouls) {
        this.personalFouls = personalFouls;
    }

    public void setForcedFouls(int forcedFouls) {
        this.forcedFouls = forcedFouls;
    }

    public void setPoints(int points) {
        this.points = points;
    }


    // 2 Points Attempted / Scored

    public void fta(){
        this.fta += 1;
    }

    public void ftm(){
        fta();
        this.ftm += 1;
        this.points += 1;
    }

    public void fga2(){
        this.fga2 += 1;
    }

    public void fgm2(){
        fga2();
        this.fgm2 += 1;
        this.points += 2;
    }

    // 3 Points Attempted / Scored

    public void fga3(){
        this.fga3 += 1;
    }

    public void fgm3(){
        fga3();
        this.fgm3 += 1;
        this.points += 3;
    }

    // Rebounds

    public void dreb(){
        this.drebs += 1;
        this.totalRebs += 1;
    }

    public void oreb(){
        this.drebs += 1;
        this.totalRebs += 1;
    }

}
