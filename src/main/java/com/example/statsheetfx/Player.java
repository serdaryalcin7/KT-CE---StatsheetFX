package com.example.statsheetfx;

public class Player {
    private String firstName;
    private String lastName;
    private int jerseyNo;

    public Player(String firstName, String lastName, int jerseyNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jerseyNo = jerseyNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getJerseyNo() {
        return jerseyNo;
    }

    public void setJerseyNo(int jerseyNo) {
        this.jerseyNo = jerseyNo;
    }
}
