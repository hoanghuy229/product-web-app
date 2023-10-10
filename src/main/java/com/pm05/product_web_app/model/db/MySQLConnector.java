package com.pm05.product_web_app.model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector {
    public static Connection getMySQLConnection() throws SQLException {
        String hostname = "localhost";
        String dbName = "product-db";
        String username = "root";
        String password = "huy22092003";

        return getMySQLConnection(hostname, dbName, username, password);
    }

    private static Connection getMySQLConnection(String hostname, String dbName, String username, String password)throws SQLException {
        String connectionURL = "jdbc:mysql://" + hostname + ":3306/" + dbName;
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        conn = DriverManager.getConnection(connectionURL, username, password);
        return conn;
    }

    public static void  Closeconnection(Connection conn){
        try {
            if(conn != null)
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
