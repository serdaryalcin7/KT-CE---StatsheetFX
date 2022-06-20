package com.example.statsheetfx.model;

public class BoxScoreLine {
    private String player;
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
    private double ftPercentage;
    private double threepointPercentage;


    public BoxScoreLine(String player, int fga2, int fgm2, int fga3, int fgm3, int fta, int ftm, int orebs, int drebs, int totalRebs, int assists, int steals, int turnovers, int blocks, int personalFouls, int forcedFouls, int points, double twopointPercentage, double ftPercentage, double threepointPercentage) {
        this.player = player;
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
        this.twopointPercentage = twopointPercentage;
        this.ftPercentage = ftPercentage;
        this.threepointPercentage = threepointPercentage;
    }

    public BoxScoreLine(StatLine statLine){
        this.player = statLine.getPlayer().getName();
        this.fga2 = statLine.getFga2();
        this.fgm2 = statLine.getFgm2();
        this.fga3 = statLine.getFga3();
        this.fgm3 = statLine.getFgm3();
        this.fta = statLine.getFta();
        this.ftm = statLine.getFtm();
        this.orebs = statLine.getOrebs();
        this.drebs = statLine.getDrebs();
        this.totalRebs = statLine.getTotalRebs();
        this.assists = statLine.getAssists();
        this.steals = statLine.getSteals();
        this.turnovers = statLine.getTurnovers();
        this.blocks = statLine.getBlocks();
        this.personalFouls = statLine.getPersonalFouls();
        this.forcedFouls = statLine.getForcedFouls();
        this.points = statLine.getPoints();

    }

    public double getThreepointPercentage() {
        return threepointPercentage;
    }

    public void setThreepointPercentage(double threepointPercentage) {
        this.threepointPercentage = threepointPercentage;
    }

    public double getFtPercentage() {
        return ftPercentage;
    }

    public void setFtPercentage(double ftPercentage) {
        this.ftPercentage = ftPercentage;
    }

    public double getTwopointPercentage() {
        return twopointPercentage;
    }

    public void setTwopointPercentage(double twopointPercentage) {
        this.twopointPercentage = twopointPercentage;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }




    public int getFga2() {
        return fga2;
    }

    public void setFga2(int fga2) {
        this.fga2 = fga2;
    }

    public int getFgm2() {
        return fgm2;
    }

    public void setFgm2(int fgm2) {
        this.fgm2 = fgm2;
    }

    public int getFga3() {
        return fga3;
    }

    public void setFga3(int fga3) {
        this.fga3 = fga3;
    }

    public int getFgm3() {
        return fgm3;
    }

    public void setFgm3(int fgm3) {
        this.fgm3 = fgm3;
    }

    public int getFta() {
        return fta;
    }

    public void setFta(int fta) {
        this.fta = fta;
    }

    public int getFtm() {
        return ftm;
    }

    public void setFtm(int ftm) {
        this.ftm = ftm;
    }

    public int getOrebs() {
        return orebs;
    }

    public void setOrebs(int orebs) {
        this.orebs = orebs;
    }

    public int getDrebs() {
        return drebs;
    }

    public void setDrebs(int drebs) {
        this.drebs = drebs;
    }

    public int getTotalRebs() {
        return totalRebs;
    }

    public void setTotalRebs(int totalRebs) {
        this.totalRebs = totalRebs;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getSteals() {
        return steals;
    }

    public void setSteals(int steals) {
        this.steals = steals;
    }

    public int getTurnovers() {
        return turnovers;
    }

    public void setTurnovers(int turnovers) {
        this.turnovers = turnovers;
    }

    public int getBlocks() {
        return blocks;
    }

    public void setBlocks(int blocks) {
        this.blocks = blocks;
    }

    public int getPersonalFouls() {
        return personalFouls;
    }

    public void setPersonalFouls(int personalFouls) {
        this.personalFouls = personalFouls;
    }

    public int getForcedFouls() {
        return forcedFouls;
    }

    public void setForcedFouls(int forcedFouls) {
        this.forcedFouls = forcedFouls;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }


}


