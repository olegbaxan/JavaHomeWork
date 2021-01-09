package com.step.person;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import com.step.Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.step.connection.Connection.initConnection;

public class PersonManager {
    public static ObservableList<Person> getAllActiveUsers() {
        ObservableList<Person> personList = FXCollections.observableArrayList();
        try {
            java.sql.Connection conn = initConnection();
            ;

            PreparedStatement ps = conn.prepareStatement("SELECT personid, name, surname,description,phone,mobil,email,regdate,idnp FROM step.person where disabled=false ORDER BY personid");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                personList.add(new Person(Integer.parseInt(rs.getString("personid")), rs.getString("name"),
                        rs.getString("surname"), rs.getString("description"), rs.getString("phone"),
                        rs.getString("mobil"), rs.getString("email"), rs.getDate("regdate").toLocalDate(), rs.getString("idnp")));
            }
        } catch (Exception e) {
        }
        return personList;
    }

}
