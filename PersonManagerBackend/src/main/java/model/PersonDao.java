package com.step.entity;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class PersonDao {
    public static java.sql.Connection initConnection() throws SQLException {
        String url = "jdbc:postgresql://127.0.0.1:54321/postgres";
        String username = "postgres";
        String password = "POSTGRESSQL";
        return getConnection(url, username, password);
    }

    public PersonDao() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Person> getAllActiveUsers() {
        try (Connection conn = initConnection()) {

            PreparedStatement ps = conn.prepareStatement("SELECT personid, name, surname,description,phone,mobil,email,regdate,idnp,birthday FROM step.person where disabled=false ORDER BY personid");
            ResultSet rs = ps.executeQuery();
            List<Person> personList = new ArrayList<>();

            while (rs.next()) {
                personList.add(new Person(Integer.parseInt(rs.getString("personid")), rs.getString("name"),
                        rs.getString("surname"), rs.getString("description"), rs.getString("phone"),
                        rs.getString("mobil"), rs.getString("email"), rs.getDate("regdate").toLocalDate(),
                        rs.getString("idnp"), rs.getDate("birthday").toLocalDate()));

            }
            return personList;
        } catch (Exception e) {
            System.out.println("EROARE! " + e.getMessage());
            return null;
        }
    }
    public List<Person> getPersonForEdit(int position) {
        try (Connection conn = initConnection()) {
            String sql = "SELECT personid, name, surname,description,phone,mobil,email,regdate,idnp,birthday FROM step.person where personid=?";
            System.out.println("sql: "+sql);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, position);
            List<Person> personToUpdate=new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                personToUpdate.add(new Person(Integer.parseInt(rs.getString("personid")), rs.getString("name"),
                        rs.getString("surname"), rs.getString("description"), rs.getString("phone"),
                        rs.getString("mobil"), rs.getString("email"), rs.getDate("regdate").toLocalDate(),
                        rs.getString("idnp"), rs.getDate("birthday").toLocalDate()));
                System.out.println("personToUpdate: " + personToUpdate);}
                return personToUpdate;

        } catch (Exception e) {
            System.out.println("EROARE! " + e.getMessage());
            return null;
        }
    }

    public void updatePerson(int position, String name, String surname, String description, String phone, String mobile, String email, String regdate, String idnp, LocalDate birthday) {
        try (Connection conn = initConnection()) {

            String sql = "UPDATE step.person SET name=?, surname=?,description=?,phone=?,mobil=?,email=?,idnp=?,birthday=? where personid=? ";
            try (Connection connection = initConnection();
                 //DB Table update
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, surname);
                preparedStatement.setString(3, description);
                preparedStatement.setString(4, phone);
                preparedStatement.setString(5, mobile);
                preparedStatement.setString(6, email);
                preparedStatement.setString(7, idnp);
                preparedStatement.setInt(9, position);
                preparedStatement.setDate(8, Date.valueOf(birthday));

                int rows = preparedStatement.executeUpdate();
                preparedStatement.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
    }
    public void deletePerson(int position) {
        try (Connection conn = initConnection()) {

            String sql = "UPDATE step.person SET disabled=true where personid=?";
            try (Connection connection = initConnection();
                 //DB Table update
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                preparedStatement.setInt(1, position);

                int rows = preparedStatement.executeUpdate();
                preparedStatement.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
    }
    public void addPerson(Person person) {
        try (Connection conn = initConnection()) {

            String sql = "INSERT INTO step.person(name, surname,description,phone,mobil,email,regdate,idnp,birthday) values(?,?,?,?,?,?,?,?,?)";

                 PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, person.getName());
                preparedStatement.setString(2, person.getSurname());
                preparedStatement.setString(3, person.getDescription());
                preparedStatement.setString(4, person.getPhone());
                preparedStatement.setString(5, person.getMobile());
                preparedStatement.setString(6, person.getEmail());
                preparedStatement.setString(8, person.getIdnp());
                preparedStatement.setDate(7, Date.valueOf(person.getRegDate()));
                preparedStatement.setDate(9, Date.valueOf(person.getBirthday()));

                int rows = preparedStatement.executeUpdate();
                preparedStatement.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}