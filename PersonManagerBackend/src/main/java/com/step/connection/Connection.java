package com.step.connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    public static java.sql.Connection initConnection() throws SQLException {
        String url = "jdbc:postgresql://127.0.0.1:54321/postgres";
        String username = "postgres";
        String password = "POSTGRESSQL";
        return DriverManager.getConnection(url, username, password);
    }
    public Connection() {
        try {
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException ex){
            throw new RuntimeException(ex);
        }
    }

}