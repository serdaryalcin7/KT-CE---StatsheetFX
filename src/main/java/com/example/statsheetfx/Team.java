package com.example.statsheetfx;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Team {
    private String name;
    private Set<Player> players;

    public Team(String name) {
        this.name = name;
        players = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player){
        if(player != null) {
            this.getPlayers().add(player);
        }
    }
}
