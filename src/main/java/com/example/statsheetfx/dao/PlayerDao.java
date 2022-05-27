package com.example.statsheetfx.dao;

import com.example.statsheetfx.DBUtil;
import com.example.statsheetfx.model.Game;
import com.example.statsheetfx.model.Player;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlayerDao {
    public List<Player> getPlayersFromTeam(int id) {
        try {
            Connection conn = DBUtil.connect();

            try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM Player WHERE team_id = ?")) {
                ps.setInt(1, id);
                List<Player> players = new ArrayList<>();
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        System.out.println("Found Player");
                        int playerId = rs.getInt("id");
                        String name = rs.getString("name");
                        int number = rs.getInt("number");
                        int team = rs.getInt("team_id");

                        players.add(new Player(playerId, name, number, team));
                    }
                }
                return players;
            }
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
