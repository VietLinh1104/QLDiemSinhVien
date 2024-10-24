package com.ht22.QLDiemSinhVien.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static String URL = "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12740470";
    private static String USERNAME = "sql12740470";
    private static String PASSWORD = "6Lz6WXeWba";

    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void main(String[] args) {

        ConnectDB conn = new ConnectDB();
        conn.getConnection();
    }

}
