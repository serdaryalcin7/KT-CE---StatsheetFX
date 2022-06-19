package com.example.statsheetfx.model;

import java.time.LocalDate;

public class GameListItem {
    String homeTeam;
    String opponent;
    LocalDate date;

    public GameListItem(String homeTeam, String opponent, LocalDate date) {
        this.homeTeam = homeTeam;
        this.opponent = opponent;
        this.date = date;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
