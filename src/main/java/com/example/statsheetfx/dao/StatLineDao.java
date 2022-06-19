package com.example.statsheetfx.dao;

import com.example.statsheetfx.DBUtil;
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

public List<StatLine> getStats (int gameId) {
        PlayerDao playerDao = new PlayerDao();
    try {
        Connection conn = DBUtil.connect();

        try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM StatLine WHERE game_id = ?")) {
            ps.setInt(1, gameId);
            List<StatLine> stats = new ArrayList<>();
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int player = rs.getInt("player");
                    int id = rs.getInt("id");
                    int fga2 = rs.getInt("fga2");
                    int fga3 = rs.getInt("fga3");
                    int fgm2 = rs.getInt("fgm2");
                    int fgm3= rs.getInt("fgm3");
                    int fta = rs.getInt("fta");
                    int ftm = rs.getInt("ftm");
                    int orebs = rs.getInt("orebs");
                    int drebs = rs.getInt("drebs");
                    int totalRebs = rs.getInt("totalRebs");
                    int assists = rs.getInt("assists");
                    int steals = rs.getInt("steals");
                    int turnovers = rs.getInt("turnovers");
                    int blocks = rs.getInt("blocks");
                    int personalFouls = rs.getInt("personalFouls");
                    int forcedFouls = rs.getInt("forcedFouls");
                    int points = rs.getInt("points");

                    Player p = playerDao.getPlayer(player);

                    stats.add(new StatLine(p,id,fga3, fga2,fgm2, fgm3,fta,ftm,  orebs, drebs,totalRebs,assists,steals,turnovers,blocks,personalFouls,forcedFouls, points ));
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



