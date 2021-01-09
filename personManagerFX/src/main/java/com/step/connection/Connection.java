package com.step.connection;

import com.step.person.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connection {
    public static java.sql.Connection initConnection() throws SQLException {
        String url = "jdbc:postgresql://127.0.0.1:54321/postgres";
        String username = "postgres";
        String password = "POSTGRESSQL";
        return DriverManager.getConnection(url, username, password);
    }

}