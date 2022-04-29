package com.example.statsheetfx;

import javafx.beans.property.SimpleStringProperty;

public class PlayerStats {


    String name;
     int pts;
     int reb;
     int ast;
     int foulsmade;

    public PlayerStats(String name, int pts, int reb, int ast, int foulsmade) {
        this.name = name;
        this.pts = pts;
        this.reb = reb;
        this.ast = ast;
        this.foulsmade = foulsmade;
    }

    public PlayerStats(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public int getReb() {
        return reb;
    }

    public void setReb(int reb) {
        this.reb = reb;
    }

    public int getAst() {
        return ast;
    }

    public void setAst(int ast) {
        this.ast = ast;
    }

    public int getFoulsmade() {
        return foulsmade;
    }

    public void setFoulsmade(int foulsmade) {
        this.foulsmade = foulsmade;
    }
}
