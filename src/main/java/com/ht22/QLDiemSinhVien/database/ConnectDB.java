package com.ht22.QLDiemSinhVien.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static String URL = "jdbc:mysql://localhost:3306/qlsv";
    private static String USERNAME = "vietlinh";
    private static String PASSWORD = "622004";

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
