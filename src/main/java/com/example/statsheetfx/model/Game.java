package com.example.statsheetfx.model;

import java.time.LocalDate;

public class Game {
    private int id;
    private int homeTeamId;
    private String guestTeamId;
    private LocalDate date;

    public Game(int id, int homeTeamId, String guestTeamId, LocalDate date) {
        this.id = id;
        this.homeTeamId = homeTeamId;
        this.guestTeamId = guestTeamId;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(int homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public String getGuestTeamId() {
        return guestTeamId;
    }

    public void setGuestTeamId(String guestTeamId) {
        this.guestTeamId = guestTeamId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
