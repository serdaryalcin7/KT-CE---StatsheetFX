package com.example.statsheetfx;
import java.sql.*;

public class DBUtil {
    private static String connectionUrl = "jdbc:mysql://localhost:3306/StatSheetFX_DB?serverTimezone=UTC";
    private static Connection conn;



    public static Connection connect() throws SQLException {
        String userName = "root";
        String password = "admin";
        if(conn == null){
            conn = DriverManager.getConnection(connectionUrl, userName, password);
        }
        return conn;
    }

    public static void disconnect() throws SQLException {
        if(conn != null){
            conn.close();
        }
    }
}
