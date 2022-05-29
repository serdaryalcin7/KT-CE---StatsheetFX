package com.example.statsheetfx.dao;

import com.example.statsheetfx.DBUtil;
import com.example.statsheetfx.model.Game;

import java.sql.*;
import java.time.LocalDate;

public class GameDao {

    public Game createGame(int teamId, String guestTeam) throws SQLException {
        Connection conn = DBUtil.connect();

        try( PreparedStatement ps = conn.prepareStatement("INSERT INTO Game (home_team_id, guest_team, date) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)){
            ps.setInt(1, teamId);
            ps.setString(2, guestTeam);
            LocalDate date = LocalDate.now();
            ps.setDate(3, Date.valueOf(date));
            ps.executeUpdate();

            try( ResultSet rs = ps.getGeneratedKeys()){
                if (rs.next()) {
                    int gameId = rs.getInt(1);

                    return new Game(gameId, teamId, guestTeam, date);
                }
            }
        }
        return null;
    }
    public Game getGameById(int id) throws SQLException {
        Connection conn = DBUtil.connect();

        try( PreparedStatement ps = conn.prepareStatement("SELECT * FROM game WHERE id = ?")){
            ps.setInt(1, id);

            try( ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    int gameId = rs.getInt("id");
                    int homeTeamId = rs.getInt("home_team_id");
                    String guestTeamId = rs.getString("guest_team");
                    Date date = rs.getDate("date");

                    return new Game(gameId, homeTeamId, guestTeamId, date.toLocalDate());
                }
            }
        }
        return null;
    }
}


