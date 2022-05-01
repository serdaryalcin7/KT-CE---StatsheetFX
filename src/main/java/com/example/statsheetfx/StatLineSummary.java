package com.example.statsheetfx;

public class StatLineSummary {
    private String playerName;
    private String totalPoints;
    private String totalAssists;
    private String totalRebounds;
    private String totalPersonalFouls;

    public StatLineSummary(StatLine statLine) {
        this.playerName = statLine.getPlayer().getFirstName() + " " + statLine.getPlayer().getLastName();
        this.totalPoints = String.valueOf((statLine.getFgm2()*2) + (statLine.getFgm3()*3) + statLine.getFtm());
        this.totalAssists = String.valueOf(statLine.getAssists());
        this.totalRebounds = String.valueOf(statLine.getOrebs() + statLine.getDrebs());
        this.totalPersonalFouls = String.valueOf(statLine.getPersonalFouls());
    }

    public StatLineSummary(Player player){
        this.playerName = player.getFirstName() + " " + player.getLastName();
        this.totalPoints = "0";
        this.totalAssists = "0";
        this.totalRebounds = "0";
        this.totalPersonalFouls = "0";
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(String totalPoints) {
        this.totalPoints = totalPoints;
    }

    public String getTotalAssists() {
        return totalAssists;
    }

    public void setTotalAssists(String totalAssists) {
        this.totalAssists = totalAssists;
    }

    public String getTotalRebounds() {
        return totalRebounds;
    }

    public void setTotalRebounds(String totalRebounds) {
        this.totalRebounds = totalRebounds;
    }

    public String getTotalPersonalFouls() {
        return totalPersonalFouls;
    }

    public void setTotalPersonalFouls(String totalPersonalFouls) {
        this.totalPersonalFouls = totalPersonalFouls;
    }
}
