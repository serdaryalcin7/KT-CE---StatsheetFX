package com.example.statsheetfx.model;

public class Player {
    private int id;
    private String name;
    private int jerseyNo;
    private int teamId;

    public Player(int id, String name, int jerseyNo, int teamId) {
        this.id = id;
        this.name = name;
        this.jerseyNo = jerseyNo;
        this.teamId = teamId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJerseyNo() {
        return jerseyNo;
    }

    public void setJerseyNo(int jerseyNo) {
        this.jerseyNo = jerseyNo;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }
}
