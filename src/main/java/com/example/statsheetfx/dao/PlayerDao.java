package com.example.statsheetfx.dao;

import com.example.statsheetfx.DBUtil;
import com.example.statsheetfx.model.Game;
import com.example.statsheetfx.model.Player;
import com.example.statsheetfx.model.Team;

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

    public Player getPlayer(int id) {
        try {
            Connection conn = DBUtil.connect();

            try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM Player WHERE player_id = ?")) {
                ps.setInt(1, id);

                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        int playerId = rs.getInt("id");
                        String name = rs.getString("name");
                        int number = rs.getInt("number");
                        int team = rs.getInt("team_id");


                        return new Player(playerId, name, number, team);

                    }
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public Player createPlayer(Player player) throws SQLException {
        Connection conn = DBUtil.connect();

        try( PreparedStatement ps = conn.prepareStatement("INSERT INTO Player (name, number, team_id) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, player.getName());
            ps.setInt(2, player.getJerseyNo());
            ps.setInt(3, player.getTeamId());
            ps.executeUpdate();

            try( ResultSet rs = ps.getGeneratedKeys()){
                if (rs.next()) {
                    int playerId = rs.getInt(1);
                    player.setId(playerId);
                    return player;
                }
            }
        }
        return null;
    }
}
