package com.example.statsheetfx.dao;

import com.example.statsheetfx.DBUtil;
import com.example.statsheetfx.model.BoxScoreLine;
import com.example.statsheetfx.model.Player;
import com.example.statsheetfx.model.StatLine;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StatLineDao {
    public StatLine saveStatLine(StatLine statLine, int gameId, int playerId) throws SQLException {
        Connection conn = DBUtil.connect();

        try (PreparedStatement ps = conn.prepareStatement("insert into statline (game_id, player_id, FGA2, FGM2, FGA3, FGM3, FTA, FTM, OREB, DREB, TOT, ASS, STL, TOS, BLK, PF,FF, PTS, PER) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, gameId);
            ps.setInt(2, playerId);
            ps.setInt(3, statLine.getFga2());
            ps.setInt(4, statLine.getFgm2());
            ps.setInt(5, statLine.getFga3());
            ps.setInt(6, statLine.getFgm3());
            ps.setInt(7, statLine.getFta());
            ps.setInt(8, statLine.getFtm());
            ps.setInt(9, statLine.getOrebs());
            ps.setInt(10, statLine.getDrebs());
            ps.setInt(11, statLine.getTotalRebs());
            ps.setInt(12, statLine.getAssists());
            ps.setInt(13, statLine.getSteals());
            ps.setInt(14, statLine.getTurnovers());
            ps.setInt(15, statLine.getBlocks());
            ps.setInt(16, statLine.getPersonalFouls());
            ps.setInt(17, statLine.getForcedFouls());
            ps.setInt(18, statLine.getPoints());
            ps.setInt(19, statLine.calculatePER());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int statLineId = rs.getInt(1);
                    statLine.setId(statLineId);
                    return statLine;
                }
            }
        }
        return null;
    }

public List<BoxScoreLine> getStats (int gameId) {
        PlayerDao playerDao = new PlayerDao();
    try {
        Connection conn = DBUtil.connect();

        try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM StatLine WHERE game_id = ?")) {
            ps.setInt(1, gameId);
            List<BoxScoreLine> stats = new ArrayList<>();
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int player = rs.getInt("player_id");
                    int id = rs.getInt("id");
                    int fga2 = rs.getInt("fga2");
                    int fga3 = rs.getInt("fga3");
                    int fgm2 = rs.getInt("fgm2");
                    int fgm3= rs.getInt("fgm3");
                    int fta = rs.getInt("fta");
                    int ftm = rs.getInt("ftm");
                    int oreb = rs.getInt("oreb");
                    int dreb = rs.getInt("dreb");
                    int totalRebs = rs.getInt("tot");
                    int assists = rs.getInt("ass");
                    int steals = rs.getInt("stl");
                    int turnovers = rs.getInt("tos");
                    int blocks = rs.getInt("blk");
                    int personalFouls = rs.getInt("pf");
                    int forcedFouls = rs.getInt("ff");
                    int points = rs.getInt("pts");

                    String p = playerDao.getPlayer(player).getName();

                    stats.add(new BoxScoreLine(p,fga3,fga2,fgm2,fgm3,fta,ftm,oreb,dreb,totalRebs,assists,steals,turnovers,blocks,personalFouls,forcedFouls,points));
                }
            }
            return stats;
        }
    }catch(SQLException e){
        e.printStackTrace();

        return null;
    }
}
}



