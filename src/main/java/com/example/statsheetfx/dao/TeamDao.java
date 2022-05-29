package com.example.statsheetfx.dao;

import com.example.statsheetfx.DBUtil;
import com.example.statsheetfx.model.Game;
import com.example.statsheetfx.model.Player;
import com.example.statsheetfx.model.Team;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class TeamDao {
    public List<Team> getTeams() {
        try {
            Connection conn = DBUtil.connect();

            try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM Team")) {
                List<Team> allTeams = new ArrayList<>();
                try(ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        int teamId = rs.getInt("id");
                        String name = rs.getString("name");
                        allTeams.add(new Team(teamId, name));
                    }
                }
                return allTeams;
            }
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public Team createTeam(Team team) throws SQLException {
        Connection conn = DBUtil.connect();

        try( PreparedStatement ps = conn.prepareStatement("INSERT INTO Team (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, team.getName());
            ps.executeUpdate();

            try( ResultSet rs = ps.getGeneratedKeys()){
                if (rs.next()) {
                    int teamId = rs.getInt(1);
                    team.setId(teamId);
                    return team;
                }
            }
        }
        return null;
    }
}

