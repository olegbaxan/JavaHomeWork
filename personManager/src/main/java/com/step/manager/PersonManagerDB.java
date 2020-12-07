package com.step.manager;

import com.step.exception.NumberNotValidException;
import com.step.menu.Menu;
import com.step.person.Person;

import java.sql.*;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PersonManagerDB implements IPersonManager {

    public Connection initConnection() throws SQLException {
        String url = "jdbc:postgresql://127.0.0.1:54321/postgres";
        String username = "postgres";
        String password = "POSTGRESSQL";
        return DriverManager.getConnection(url, username, password);
    }

    @Override
    public int insert(List<Person> person) {
        String personName = enterText("Enter name of the Person");
        String surname = enterText("Enter surname of the Person");
        String description = enterText("Enter description of the Person");
        String phone = enterText("Enter phone of the Person");
        String mobile = enterText("Enter mobile of the Person");
        String email = enterText("Enter email of the Person");
        LocalDate today = LocalDate.now();
        String idnp;
        boolean exist;
        do {
            exist = false;
            idnp = enterText("Enter IDNP of the Person");
            boolean checkIDNP= checkIDNP(idnp, person);
            System.out.println("checkIDNP(idnp,person))="+checkIDNP);
            if (checkIDNP) {
                exist = true;
                System.out.println("Person with this IDNP already exist!");
            }
        } while (exist);



        String sql = "INSERT INTO step.person(name, surname,description,phone,mobil,email,regdate,idnp) values(?,?,?,?,?,?,?,?)";
        try(Connection connection = initConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,personName);
            preparedStatement.setString(2,surname);
            preparedStatement.setString(3,description);
            preparedStatement.setString(4,phone);
            preparedStatement.setString(5,mobile);
            preparedStatement.setString(6,email);
            preparedStatement.setString(8,idnp);
            preparedStatement.setDate(7, Date.valueOf(today));

            int rows = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            return rows;
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }

    }
    public static boolean checkIDNP(String idnp, List<Person> person) {
        boolean found = false;
        System.out.println("person.size()=" +person.size());
        for (int i = 0; i < person.size(); i++) {
            if (person.get(i).getIdnp().equals(idnp)) {
                System.out.println("idnp="+idnp);
                System.out.println("idnpCheck = "+ person.get(i).getIdnp());
                found = true;
                break;
            }
        }
        return found;
    }

    public static int getOption() throws NumberNotValidException {
        Scanner sc = new Scanner(System.in);
        try {
            return sc.nextInt();
        } catch (InputMismatchException ex) {
            sc.nextLine();
            System.out.println("Data is not a number");
            throw new NumberNotValidException();
        }
    }

    @Override
    public int update(int attrToModify, List<Person> person) {
        String newValue;
        int personToModify = -1;
        String sql;
        read(person);
        show(person);
        person.clear();
        System.out.println("Select ID of the person to modify");

        boolean isValid = false;
        do {
            try {
                personToModify = Menu.getOption();
                isValid = true;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Please try again");
            }
        } while (!isValid);
        switch (attrToModify) {
            case 1:
                newValue = enterText("Enter new value for Description");
                sql = "UPDATE step.person SET description=? WHERE personid=?";
                break;
            case 2:
                newValue = enterText("Enter new value for Phone");
                sql = "UPDATE step.person SET phone=? WHERE personid=?";
                break;
            case 3:
                newValue = enterText("Enter new value for Mobile");
                sql = "UPDATE step.person SET mobil=? WHERE personid=?";
                break;
            case 4:
                newValue = enterText("Enter new value for Email");
                sql = "UPDATE step.person SET email=? WHERE personid=?";
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + attrToModify);
        }
        try(Connection connection = initConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, newValue);
            preparedStatement.setInt(2, personToModify);
            preparedStatement.executeUpdate();
//                    preparedStatement.close();
//                    connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int search(int attrToSearch, List<Person> person) {
        person.clear();
        String valueToSearch,sql;
        switch (attrToSearch) {
            case 1:
                valueToSearch = enterText("Enter value for IDNP to search");
                sql = "SELECT personid, name, surname,description,phone,mobil,email,regdate,idnp FROM step.person where idnp like '%"+valueToSearch+"%'";
                break;
            case 2:
                valueToSearch = enterText("Enter value for Surname to search");
                sql = "SELECT personid, name, surname,description,phone,mobil,email,regdate,idnp FROM step.person where LOWER(surname) like LOWER('%"+valueToSearch+"%')";
                break;
            case 3:
                valueToSearch = enterText("Enter value for Phone to search");
                sql = "SELECT personid, name, surname,description,phone,mobil,email,regdate,idnp FROM step.person where phone like '%"+valueToSearch+"%'";
                break;
            case 4:
                valueToSearch = enterText("Enter value for Mobil to search");
                sql = "SELECT personid, name, surname,description,phone,mobil,email,regdate,idnp FROM step.person where mobil like '%"+valueToSearch+"%'";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + attrToSearch);
        }

        try {
            Connection connection=initConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                int id=resultSet.getInt("personid");
                String personName = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String description = resultSet.getString("description");
                String phone = resultSet.getString("phone");
                String mobile = resultSet.getString("mobil");
                String email = resultSet.getString("email");
                LocalDate date = resultSet.getDate(("regdate")).toLocalDate();
                String idnp=resultSet.getString("idnp");

                person.add(new Person(id,personName, surname, description, phone, mobile, email, idnp, date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        show(person);
        person.clear();
        return 0;
    }

    @Override
    public int delete(List<Person> person) {
        read(person);
        show(person);
        person.clear();
        int rows=0;
        System.out.println("Select ID of the person to delete");
        int personToDelete = -1;
        boolean isValid = false;
        do {
            try {
                personToDelete = Menu.getOption();
                isValid = true;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Please try again");
            }
        } while (!isValid);

        String sql = "DELETE FROM step.person WHERE personid=?";
        try(Connection connection = initConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, personToDelete);
            rows = preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        switch (rows){
            case 0:{
                System.out.println("There is nothing to delete from DB");
                break;
            }
            case 1:{
                System.out.println("Person deleted successfully");
            }
            default:
                System.out.println("Check the SQL, deleted more than one row");
        }
        return 0;
    }

    @Override
    public List<Person> read(List<Person> person) {
        person.clear();
        String sql = "SELECT personid, name, surname,description,phone,mobil,email,regdate,idnp FROM step.person ORDER BY personid";
        try {
            Connection connection=initConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                int id=resultSet.getInt("personid");
                String personName = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String description = resultSet.getString("description");
                String phone = resultSet.getString("phone");
                String mobile = resultSet.getString("mobil");
                String email = resultSet.getString("email");
                LocalDate date = resultSet.getDate(("regdate")).toLocalDate();
                String idnp=resultSet.getString("idnp");

                person.add(new Person(id,personName, surname, description, phone, mobile, email, idnp, date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    public void show(List<Person> person){
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%3s %15s %15s %10s %10s %30s %20s %13s", "ID", "NAME ", "SURNAME", "PHONE", "MOBILE", "EMAIL ID", "DESCRIPTION", "IDNP");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        for (Person pers : person) {
            System.out.format("%3d %15s %15s %10s %10s %30s %20s %13s",
                    pers.getPersonId(), pers.getName(), pers.getSurname(), pers.getPhone(), pers.getMobile(), pers.getEmail(), pers.getDescription(), pers.getIdnp());
            System.out.println();
        }

        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
    }

    @Override
    public void close(List<Person> person) {

    }

    public static String enterText(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        return sc.nextLine();
    }

}